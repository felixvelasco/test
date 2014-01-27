package com.vectorsf.jvoice.ui.diagram.properties.section;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.IObjectChooser;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogLocution;
import com.vectorsf.jvoice.ui.wizard.create.CreateJspCustom;

public class CustomPageChooser implements IObjectChooser {

	@Override
	public Object getValue(EObject bo, TransactionalEditingDomain editingDomain) {

		// Se crea el dialogo de selección de locution (definition).
		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		DialogLocution dialog = new DialogLocution(activeShell);

		// Se obtiene la carpeta de recursos del flujo
		Flow flow = (Flow) bo.eContainer();
		String flowFolderPath = getFolderPath(flow);
		IFolder resourcesFolder = (IFolder) ResourcesPlugin.getWorkspace().getRoot().findMember(flowFolderPath);

		List<Object> locutionResources = new ArrayList<>();

		// Se obtienen los páginas a mostrar en el diálogo de selección.
		try {
			IResource[] resources = resourcesFolder.members();
			for (IResource resource : resources) {
				if (resource instanceof IFile) {
					if (resource.getName().contains(".jsp")) {
						locutionResources.add(resource.getName());
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
		dialog.setTitle("Custom Selection");
		dialog.setMessage("Select a custom:");
		int dopen = dialog.open();

		if (dopen == Window.OK) {
			// Si se pulsa OK en el dialogo, cambiamos el locution (definition) asociado al estado por el seleccionado.
			Object[] results = dialog.getResult();
			return results[0];
		} else if (dopen == IDialogConstants.PROCEED_ID) {
			// Si se pulsa "Create" en el dialogo, se abre el wizard para la creación de la página nueva.
			return createAndChangeLocution(flow);
		} else { // Cancel button
			return null;
		}

	}

	private String createAndChangeLocution(Flow flow) {

		// Obtenemos la carpeta de recursos asociado al flujo
		IFile file = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		URI res = flow.eResource().getURI();
		String projectName = res.segment(1);
		IProject projectRoot = root.getProject(projectName);
		IFolder folder = projectRoot.getFolder(file.getParent().getProjectRelativePath() + "/" + flow.getName()
				+ ".resources");

		CreateJspCustom createWizard = new CreateJspCustom(folder);

		WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				createWizard);

		if (wizardDialog.open() == Window.OK) {
			return createWizard.getFile().getName();
		} else {
			return null;
		}

	}

	private String getFolderPath(Flow flow) {
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

}
