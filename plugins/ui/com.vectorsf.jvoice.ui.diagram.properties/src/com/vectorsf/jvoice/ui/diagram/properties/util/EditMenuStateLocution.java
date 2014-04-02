package com.vectorsf.jvoice.ui.diagram.properties.util;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.PromptState;
import com.vectorsf.jvoice.model.operations.RecordState;
import com.vectorsf.jvoice.model.operations.TransferState;
import com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogLocution;
import com.vectorsf.jvoice.ui.wizard.PicWizardDialog;
import com.vectorsf.jvoice.ui.wizard.create.CreateDefinitionWizard;
import com.vectorsf.jvoice.ui.wizard.create.DefinitionHelper;

public class EditMenuStateLocution extends RecordingCommand {

	private LocutionState locutionState;
	private Text nameSubFlow;
	private Flow flujo;
	private String flowFolderPath;
	private IFolder resourcesFolder;

	public EditMenuStateLocution(TransactionalEditingDomain domain, LocutionState locutionState, Text nameSubFlow) {
		super(domain);
		this.locutionState = locutionState;
		this.nameSubFlow = nameSubFlow;
	}

	@Override
	protected void doExecute() {

		// Se crea el dialogo de selecci�n de locution (definition).
		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		DialogLocution dialog = new DialogLocution(activeShell);

		// Se obtiene la carpeta de recursos del flujo
		flujo = obtenerFlow();
		flowFolderPath = getFolderPath(flujo);
		resourcesFolder = (IFolder) ResourcesPlugin.getWorkspace().getRoot().findMember(flowFolderPath);

		List<Object> locutionResources = new ArrayList<>();

		// Se obtienen los locutions a mostrar en el di�logo de selecci�n.
		try {
			IResource[] resources = resourcesFolder.members();
			for (IResource resource : resources) {
				if (resource instanceof IFile) {
					URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					EObject eObject = null;
					if (!resource.getName().contains(".jsp")) {
						eObject = flujo.eResource().getResourceSet().getResource(uri, true).getContents().get(0);
					}
					if (locutionState instanceof MenuState && eObject instanceof MenuDsl) {
						locutionResources.add(eObject);
					} else if (locutionState instanceof InputState && eObject instanceof InputDsl) {
						locutionResources.add(eObject);
					} else if (locutionState instanceof PromptState && eObject instanceof PromptDsl) {
						locutionResources.add(eObject);
					} else if (locutionState instanceof RecordState && eObject instanceof RecordDsl) {
						locutionResources.add(eObject);
					} else if (locutionState instanceof TransferState && eObject instanceof TransferDsl) {
						locutionResources.add(eObject);
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

		titleAndMessage(dialog);

		int dopen = dialog.open();

		if (dopen == Window.OK) {
			// Si se pulsa OK en el dialogo, cambiamos el locution (definition) asociado al estado por el seleccionado.
			Object[] results = dialog.getResult();
			changeLocution(results);
		} else if (dopen == IDialogConstants.PROCEED_ID) {
			// Si se pulsa "Create" en el dialogo, se abre el wizard para la creaci�n del locution (definitio) que
			// pasar� a ser el asociado al estado.
			createAndChangeLocution();
		}

	}

	private void titleAndMessage(DialogLocution dialog) {
		if (locutionState instanceof MenuState) {
			dialog.setTitle("Menu Selection");
			dialog.setMessage("Select a menu:");
		} else if (locutionState instanceof InputState) {
			dialog.setTitle("Input Selection");
			dialog.setMessage("Select an input:");
		} else if (locutionState instanceof PromptState) {
			dialog.setTitle("Output Selection");
			dialog.setMessage("Select an output:");
		} else if (locutionState instanceof RecordState) {
			dialog.setTitle("Record Selection");
			dialog.setMessage("Select a record:");
		} else if (locutionState instanceof TransferState) {
			dialog.setTitle("Transfer Selection");
			dialog.setMessage("Select a transfer:");
		}
	}

	private void changeLocution(Object[] results) {
		if (results != null) {
			if (results[0] instanceof VoiceDsl) {
				VoiceDsl result = (VoiceDsl) results[0];
				URI menuURI = EcoreUtil.getURI(result);
				result = (MenuDsl) locutionState.eResource().getResourceSet().getEObject(menuURI, true);

				locutionState.setLocution(result);
				nameSubFlow.setText(result.getName());
			}
		}
	}

	private void createAndChangeLocution() {

		// Obtenemos la carpeta de recursos asociado al flujo
		IFile file = (IFile) Platform.getAdapterManager().getAdapter(flujo, IFile.class);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		URI res = flujo.eResource().getURI();
		String projectName = res.segment(1);
		IProject projectRoot = root.getProject(projectName);
		IFolder folder = projectRoot.getFolder(file.getParent().getProjectRelativePath() + "/" + flujo.getName()
				+ ".resources");

		// Si se quiere cambiar el locution (definition) asociado a un estado creamos el wizard de creaci�n de
		// definition.
		Wizard createWizard = createDslJVoice(folder);

		WizardDialog wizardDialog = new PicWizardDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), createWizard);

		if (wizardDialog.open() == Window.OK) {
			// Obtenemos la URI del dsl creado
			URI locationUri = ((CreateDefinitionWizard) createWizard).getURI();
			// Cambios la asociaci�n estado-dsl. Del antiguo dsl al nuevo.
			setNewLocutionOnState(locationUri);
		}

	}

	private CreateDefinitionWizard createDslJVoice(IFolder folder) {
		DefinitionHelper helper;

		// Se crea el wizard adecuado en funci�n del tipo de estado.
		if (locutionState instanceof MenuState) {
			helper = DefinitionHelper.MENU;
		} else if (locutionState instanceof InputState) {
			helper = DefinitionHelper.INPUT;
		} else if (locutionState instanceof PromptState) {
			helper = DefinitionHelper.OUTPUT;
		} else if (locutionState instanceof RecordState) {
			helper = DefinitionHelper.RECORD;
		} else { // locutionState instanceof TransferState
			helper = DefinitionHelper.TRANSFER;
		}

		return new CreateDefinitionWizard(obtenerFlow(), helper);
	}

	private void setNewLocutionOnState(URI locationUri) {

		VoiceDsl voiceDsl = (VoiceDsl) flujo.eResource().getResourceSet().getEObject(locationUri, true);

		// Se setea el locution (definition) en el estado.
		locutionState.setLocution(voiceDsl);
	}

	private String getFolderPath(Flow flujo) {
		String path = "";
		String flowUri = flujo.eResource().getURI().toString();
		String[] flowUriSegments = flowUri.split("/");
		for (int i = 2; i < flowUriSegments.length - 1; i++) {
			if (!flowUriSegments[i].contains(".jvflow")) {
				path = path.concat("/" + flowUriSegments[i]);
			}

		}
		return path.concat("/" + flujo.getName() + ".resources");
	}

	private Flow obtenerFlow() {
		return (Flow) locutionState.eContainer();
	}
}
