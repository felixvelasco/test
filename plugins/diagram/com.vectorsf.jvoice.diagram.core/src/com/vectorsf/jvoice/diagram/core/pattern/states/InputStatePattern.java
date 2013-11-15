package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IPredefinedRenderingStyle;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.vectorsf.jvoice.diagram.core.pattern.StatePredefinedColoredAreas;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogLocution;
import com.vectorsf.jvoice.ui.wizard.create.CreateDslJVoice;

public class InputStatePattern extends StatePattern implements ISelectionStatusValidator {

	private static final String INPUT = "Input";
	private static int MIN_WIDTH = 120;
	private static int MIN_HEIGHT = 60;

	@Override
	protected PictogramElement doAdd(IAddContext context) {

		InputState addedDomainObject = (InputState) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		ContainerShape outerContainerShape = peCreateService.createContainerShape(getDiagram(), true);

		RoundedRectangle mainRectangle = gaService.createRoundedRectangle(outerContainerShape, 25, 25);
		setId(mainRectangle, ID_MAIN_FIGURE);
		mainRectangle.setFilled(true);
		gaService.setRenderingStyle(mainRectangle, StatePredefinedColoredAreas
				.getAdaptedGradientColoredAreas(IPredefinedRenderingStyle.SILVER_WHITE_GLOSS_ID));
		gaService.setLocationAndSize(mainRectangle, context.getX(), context.getY(),
				Math.max(MIN_WIDTH, context.getWidth()), Math.max(MIN_HEIGHT, context.getHeight()));

		Text text = gaService.createText(mainRectangle, addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);

		return outerContainerShape;

	}

	@SuppressWarnings("restriction")
	@Override
	public Object[] create(ICreateContext context) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());

		DialogLocution dialog = new DialogLocution(shell);
		List<VoiceDsl> locutionResources = new ArrayList<VoiceDsl>();
		String flowFolderPath = getFlowFolderPath(flow);

		IFolder resourcesFolder = (IFolder) ResourcesPlugin.getWorkspace().getRoot().findMember(flowFolderPath);

		try {
			IResource[] resources = resourcesFolder.members();
			for (IResource resource : resources) {
				if (resource instanceof File) {
					URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					EObject eObject = flow.eResource().getResourceSet().getResource(uri, true).getContents().get(0);
					if (eObject instanceof InputDsl) {
						locutionResources.add((InputDsl) eObject);
					}
				}
			}
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dialog.setInitialElementSelections(locutionResources);
		try {
			dialog.setResources(locutionResources);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		dialog.setHelpAvailable(false);
		dialog.setIsButtonCreatevailable(true);
		dialog.setListLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		dialog.setInitialPattern("?", FilteredItemsSelectionDialog.FULL_SELECTION);
		dialog.setTitle("Input Selection");
		dialog.setMessage("Select an input:");

		URI res = flow.eResource().getURI();
		String projectName = res.segment(1);

		dialog.open();

		VoiceDsl result = null;
		URI flowURI = null;
		InputState inputState = OperationsFactory.eINSTANCE.createInputState();
		switch (dialog.getReturnCode()) {
		case Dialog.OK:
			Object[] results = dialog.getResult();
			InputDsl input = (InputDsl) results[0];
			inputState.setName(input.getName());
			Resource eResource = input.eResource();
			flowURI = eResource.getURI().appendFragment(eResource.getURIFragment(input));
			break;
		case IDialogConstants.PROCEED_ID:
			IFile file = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);

			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject projectRoot = root.getProject(projectName);

			IFolder folder = projectRoot.getFolder(file.getParent().getProjectRelativePath() + "/" + flow.getName()
					+ ".resources");
			CreateDslJVoice newWizard = new CreateDslJVoice(folder, "Input");
			WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(), newWizard);
			if (wizardDialog.open() == Window.OK) {
				flowURI = newWizard.getURI();

			} else {
				throw new OperationCanceledException();
			}

			break;
		case Dialog.CANCEL:
			throw new OperationCanceledException();

		default:
			break;
		}

		result = (InputDsl) flow.eResource().getResourceSet().getEObject(flowURI, true);

		inputState.setLocution(result);
		inputState.setName(result.getName());

		flow.getStates().add(inputState);

		addGraphicalRepresentation(context, inputState);

		return new Object[] { inputState };
	}

	private String getFlowFolderPath(Flow flow) {
		String path = "";
		String flowUri = flow.eResource().getURI().toString();
		String[] flowUriSegments = flowUri.split("/");
		for (int i = 2; i < flowUriSegments.length - 1; i++) {
			if (!flowUriSegments[i].contains(".jvflow")) {
				path = path.concat("/" + flowUriSegments[i]);
			}

		}
		return path.concat("/" + flow.getName() + ".resources");
	}

	@Override
	public String getCreateName() {
		return INPUT;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof InputState;
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public IStatus validate(Object[] selection) {
		if (selection.length > 0) {
			if (selection[0] instanceof InputDsl) {
				return Status.OK_STATUS;
			} else {
				return new Status(IStatus.ERROR, "com.vectorsf.jvoice.diagram.core", "Select an input");
			}

		} else {
			return new Status(IStatus.ERROR, "com.vectorsf.jvoice.diagram.core", "Select an input");
		}
	}

}
