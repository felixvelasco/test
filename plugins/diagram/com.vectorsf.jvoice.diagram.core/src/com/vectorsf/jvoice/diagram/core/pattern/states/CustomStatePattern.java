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
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogLocution;
import com.vectorsf.jvoice.ui.wizard.create.CreateJspCustom;

public class CustomStatePattern extends SimpleStatePattern {

	private static final String CUSTOM = "Custom";

	@Override
	public Object[] create(ICreateContext context) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		DialogLocution dialog = new DialogLocution(shell);

		// Obtenemos las jsp del flujo
		URI res = flow.eResource().getURI();
		String projectName = res.segment(1);
		IFile fileFlow = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);

		IFolder folderFlow = project.getFolder(fileFlow.getParent().getProjectRelativePath() + "/" + flow.getName()
				+ ".resources");
		List<String> fileList = new ArrayList<>();
		IResource[] members = null;
		int i = 0;
		try {
			if (folderFlow.exists()) {
				members = folderFlow.members();
				for (IResource member : members) {
					if (member.getName().contains(".jsp")) {
						if (member instanceof IFile) {
							fileList.add(i, member.getName());
							i++;
						}
					}
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dialog.setInitialElementSelections(fileList);
		try {
			dialog.setResources(fileList);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		dialog.setHelpAvailable(false);
		dialog.setIsButtonCreatevailable(true);
		dialog.setListLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		dialog.setInitialPattern("?", FilteredItemsSelectionDialog.FULL_SELECTION);

		dialog.setTitle("Custom Selection");
		dialog.setMessage("Select a Custom:");

		dialog.open();

		String CustomStateName = null;
		IFile result = null;
		CustomState customState = OperationsFactory.eINSTANCE.createCustomState();

		switch (dialog.getReturnCode()) {
		case Dialog.OK:

			Object[] results = dialog.getResult();

			result = folderFlow.getFile(results[0].toString());
			CustomStateName = result.getName();

			customState.setName(CustomStateName);

			break;
		case IDialogConstants.PROCEED_ID:
			IFile file = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);

			IProject projectRoot = root.getProject(projectName);

			IFolder folder = projectRoot.getFolder(file.getParent().getProjectRelativePath() + "/" + flow.getName()
					+ ".resources");
			CreateJspCustom newWizard = new CreateJspCustom(folder, "Custom");
			WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(), newWizard);
			if (wizardDialog.open() == Window.OK) {
				result = newWizard.getFile();

			} else {
				throw new OperationCanceledException();
			}
			break;
		case Dialog.CANCEL:
			throw new OperationCanceledException();

		default:
			break;
		}

		customState.setPath(result.getName());

		customState.setName(result.getName().replace(".jsp", ""));
		flow.getStates().add(customState);

		addGraphicalRepresentation(context, customState);

		return new Object[] { customState };
	}

	@Override
	public String getCreateName() {
		return CUSTOM;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof CustomState;
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_CUSTOM;
	}

	@Override
	protected String getStateImageId() {
		return CoreImageProvider.IMG_STATE_CUSTOM;
	}
}
