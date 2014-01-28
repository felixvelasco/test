package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogLocution;
import com.vectorsf.jvoice.ui.wizard.create.CreateDslJVoice;

public abstract class LocutionStatePattern extends SimpleStatePattern {

	private DialogLocution dialog;
	private URI result;

	public LocutionStatePattern() {
		super();
	}

	@Override
	public final Object[] create(ICreateContext context) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());

		int dialogResult = openDialog(shell, flow, getTitle(), getDescription());

		if (dialogResult == Dialog.OK) {
			LocutionState state = createMainState();
			URI locutionUri = getDialogResult();

			if (locutionUri != null) {
				IResource resourceFile = getResourceFile(flow, locutionUri);
				ResourceSet resourceSet = BaseModel.getInstance().getResourceSet();
				Resource resource = resourceSet.getResource(locutionUri, false);
				if (resource == null) {
					resource = resourceSet.getResource(locutionUri, true);
				} else if (resourceFile != null & resource.getTimeStamp() < resourceFile.getLocalTimeStamp()) {
					resource.unload();
					resource = resourceSet.getResource(locutionUri, true);
				}

				VoiceDsl result = (VoiceDsl) resource.getContents().get(0);

				state.setName(result.getName());
				state.setLocution(result);
				flow.getStates().add(state);

				addGraphicalRepresentation(context, state);

				return new Object[] { state };
			}
			return null;
		} else {
			throw new OperationCanceledException();
		}
	}

	private IResource getResourceFile(Flow flow, URI locationUri) {
		IFile flowFile = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);
		IPath resourcesPath = flowFile.getFullPath().removeFileExtension().addFileExtension("resources");
		IFolder resourcesFolder = (IFolder) ResourcesPlugin.getWorkspace().getRoot().findMember(resourcesPath);
		IResource resourceFile = null;
		try {
			for (IResource file : resourcesFolder.members()) {
				if (locationUri != null) {
					if (file.getName().equals(locationUri.lastSegment())) {
						resourceFile = file;
						break;
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return resourceFile;
	}
	
	@Override
	protected PictogramElement doAdd(IAddContext context) {

		if (context.getNewObject() instanceof VoiceDsl) {
			// Obtenemos el dsl que se ha arrastrado al editor
			VoiceDsl dsl = (VoiceDsl) context.getNewObject();
			String dslName = dsl.getName();

			// Obtenemos el flujo al que se ha arrastrado.
			Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());

			// Creamos el estado a partir del dsl
			LocutionState state = createMainState();
			state.setName(getValidStateName(flow, dslName));
			state.setLocution(dsl);

			// Añadimos al flujo el estado creado.
			flow.getStates().add(state);

			// El padre necesita un estado en el contexto, así que creamos un nuevo contexto y le seteamos el estado.
			AddContext newContext = new AddContext(context, state);

			return super.doAdd(newContext);
		} else {
			return super.doAdd(context);
		}
	}

	protected boolean isDslFromTargetFlow(VoiceDsl dsl) {
		// Obtenemos el flujo al que se ha arrastrado el dsl.
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());

		// Obtenemos el flujo al que pertenece el dsl arrastrado.
		IFile file = (IFile) Platform.getAdapterManager().getAdapter(dsl, IFile.class);
		String dslFlow = file.getParent().getName().substring(0, file.getParent().getName().indexOf(".resources"));

		// Comparamos que sean el mismo flujo.
		return dslFlow.equals(flow.getName());
	}

	private IPath getFlowFolderPath(Flow flow) {
		IPath path = new Path(flow.eResource().getURI().toPlatformString(true));
		IPath parentPath = path.removeLastSegments(1);

		return parentPath.append(flow.getName() + ".resources");
	}

	private URI getDialogResult() {
		return result;
	}

	private int openDialog(Shell shell, Flow flow, String title, String message) {
		dialog = new DialogLocution(shell);
		List<VoiceDsl> locutionResources = new ArrayList<VoiceDsl>();
		IPath flowFolderPath = getFlowFolderPath(flow);

		IFolder resourcesFolder = (IFolder) ResourcesPlugin.getWorkspace().getRoot().findMember(flowFolderPath);

		try {
			for (IResource resource : resourcesFolder.members()) {
				if (resource instanceof IFile) {
					URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					if (!resource.getName().contains(".jsp")) {
						try {
							Resource res = flow.eResource().getResourceSet().getResource(uri, true);
							EObject eObject = res.getContents().get(0);

							if (getMainType().isInstance(eObject)) {
								locutionResources.add((VoiceDsl) eObject);
							}
						} catch (RuntimeException ignored) {
						}
					}
				}
			}
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		dialog.setInitialElementSelections(locutionResources);
		dialog.setResources(locutionResources);
		dialog.setHelpAvailable(false);
		dialog.setButtonCreateAvailable(true);
		dialog.setListLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		dialog.setInitialPattern("?", FilteredItemsSelectionDialog.FULL_SELECTION);
		dialog.setTitle(title);
		dialog.setMessage(message);

		int dopen = dialog.open();
		if (dopen == Window.OK) {
			EObject eObject = (EObject) dialog.getResult()[0];
			result = EcoreUtil.getURI(eObject);
		} else if (dopen == IDialogConstants.PROCEED_ID) {
			return createLocution(flow);
		}

		return dopen;
	}

	private int createLocution(Flow flow) {
		IFile file = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		URI res = flow.eResource().getURI();
		String projectName = res.segment(1);
		IProject projectRoot = root.getProject(projectName);

		IFolder folder = projectRoot.getFolder(file.getParent().getProjectRelativePath() + "/" + flow.getName()
				+ ".resources");
		CreateDslJVoice newWizard = new CreateDslJVoice(folder, getMainType());
		WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				newWizard);
		if (wizardDialog.open() == Window.OK) {
			result = newWizard.getURI();
			return Window.OK;
		} else {
			return Window.CANCEL;
		}

	}

	protected abstract LocutionState createMainState();

	protected abstract String getTitle();

	protected abstract String getDescription();

	protected abstract Class<? extends VoiceDsl> getMainType();

}