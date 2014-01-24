package com.vectorsf.jvoice.ui.diagram.properties.util;

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
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InputState;
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
import com.vectorsf.jvoice.ui.wizard.create.CreateDslJVoice;
import com.vectorsf.jvoice.ui.wizard.create.CreateJspCustom;

public class EditMenuStateLocution extends RecordingCommand {

	private MenuState menuState;
	private InputState inputState;
	private PromptState outputState;
	private RecordState recordState;
	private Text nameSubFlow;
	private CustomState customState;
	private Flow flujo;
	private String flowFolderPath;
	private IFolder resourcesFolder;
	private TransferState transferState;

	public EditMenuStateLocution(TransactionalEditingDomain domain, CustomState customState, Text nameSubFlow) {
		super(domain);
		this.customState = customState;
		this.nameSubFlow = nameSubFlow;

	}

	public EditMenuStateLocution(TransactionalEditingDomain domain, MenuState menuState, Text nameSubFlow) {
		super(domain);
		this.menuState = menuState;
		this.nameSubFlow = nameSubFlow;

	}

	public EditMenuStateLocution(TransactionalEditingDomain domain, InputState inputState, Text nameSubFlow) {
		super(domain);
		this.inputState = inputState;
		this.nameSubFlow = nameSubFlow;

	}

	public EditMenuStateLocution(TransactionalEditingDomain domain, PromptState outputState, Text nameSubFlow) {
		super(domain);
		this.outputState = outputState;
		this.nameSubFlow = nameSubFlow;

	}

	public EditMenuStateLocution(TransactionalEditingDomain domain, RecordState recordState, Text nameSubFlow) {
		super(domain);
		this.recordState = recordState;
		this.nameSubFlow = nameSubFlow;

	}

	public EditMenuStateLocution(TransactionalEditingDomain domain, TransferState transferState, Text nameSubFlow) {
		super(domain);
		this.transferState = transferState;
		this.nameSubFlow = nameSubFlow;

	}

	@SuppressWarnings("restriction")
	@Override
	protected void doExecute() {

		// Se crea el dialogo de selección de locution (definition).
		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		DialogLocution dialog = new DialogLocution(activeShell);

		// Se obtiene la carpeta de recursos del flujo
		flujo = obtenerFlow();
		flowFolderPath = getFolderPath(flujo);
		resourcesFolder = (IFolder) ResourcesPlugin.getWorkspace().getRoot().findMember(flowFolderPath);

		List<Object> locutionResources = new ArrayList<>();

		// Se obtienen los locutions a mostrar en el diálogo de selección.
		try {
			IResource[] resources = resourcesFolder.members();
			for (IResource resource : resources) {
				if (resource instanceof File) {
					URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					EObject eObject = null;
					if (!resource.getName().contains(".jsp")) {
						eObject = flujo.eResource().getResourceSet().getResource(uri, true).getContents().get(0);
					}
					if (menuState != null) {
						if (eObject instanceof MenuDsl) {
							locutionResources.add(eObject);
						}
					}
					if (inputState != null) {
						if (eObject instanceof InputDsl) {
							locutionResources.add(eObject);
						}
					}
					if (outputState != null) {
						if (eObject instanceof PromptDsl) {
							locutionResources.add(eObject);
						}
					}
					if (recordState != null) {
						if (eObject instanceof RecordDsl) {
							locutionResources.add(eObject);
						}
					}
					if (transferState != null) {
						if (eObject instanceof TransferDsl) {
							locutionResources.add(eObject);
						}
					}
					if (customState != null) {
						if (resource.getName().contains(".jsp")) {
							locutionResources.add(resource.getName());
						}

					}

				}

			}
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
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
			// Si se pulsa "Create" en el dialogo, se abre el wizard para la creación del locution (definitio) que
			// pasará a ser el asociado al estado.
			createAndChangeLocution();
		}

	}

	private void titleAndMessage(DialogLocution dialog) {
		if (menuState != null) {
			dialog.setTitle("Menu Selection");
			dialog.setMessage("Select a menu:");
		} else if (inputState != null) {
			dialog.setTitle("Input Selection");
			dialog.setMessage("Select an input:");
		} else if (outputState != null) {
			dialog.setTitle("Output Selection");
			dialog.setMessage("Select an output:");
		} else if (recordState != null) {
			dialog.setTitle("Record Selection");
			dialog.setMessage("Select a record:");
		} else if (transferState != null) {
			dialog.setTitle("Transfer Selection");
			dialog.setMessage("Select a transfer:");
		} else if (customState != null) {
			dialog.setTitle("Custom Selection");
			dialog.setMessage("Select a custom:");
		}
	}

	private void changeLocution(Object[] results) {
		if (results != null) {
			if (results[0] instanceof MenuDsl) {
				MenuDsl result = (MenuDsl) results[0];
				URI menuURI = EcoreUtil.getURI(result);
				result = (MenuDsl) menuState.eResource().getResourceSet().getEObject(menuURI, true);

				menuState.setLocution(result);
				nameSubFlow.setText(menuState.getLocution().getName());

			} else if (results[0] instanceof InputDsl) {
				InputDsl result = (InputDsl) results[0];
				URI inputURI = EcoreUtil.getURI(result);
				result = (InputDsl) inputState.eResource().getResourceSet().getEObject(inputURI, true);

				inputState.setLocution(result);
				nameSubFlow.setText(inputState.getLocution().getName());

			} else if (results[0] instanceof PromptDsl) {
				PromptDsl result = (PromptDsl) results[0];

				URI outputURI = EcoreUtil.getURI(result);
				result = (PromptDsl) outputState.eResource().getResourceSet().getEObject(outputURI, true);

				outputState.setLocution(result);
				nameSubFlow.setText(outputState.getLocution().getName());
			} else if (results[0] instanceof RecordDsl) {
				RecordDsl result = (RecordDsl) results[0];
				URI inputURI = EcoreUtil.getURI(result);
				result = (RecordDsl) recordState.eResource().getResourceSet().getEObject(inputURI, true);

				recordState.setLocution(result);
				nameSubFlow.setText(recordState.getLocution().getName());

			} else if (results[0] instanceof TransferDsl) {
				TransferDsl result = (TransferDsl) results[0];

				URI transferURI = EcoreUtil.getURI(result);
				result = (TransferDsl) transferState.eResource().getResourceSet().getEObject(transferURI, true);

				transferState.setLocution(result);
				nameSubFlow.setText(transferState.getLocution().getName());
			} else if (results[0].toString().contains(".jsp")) {
				IFile resultcustom = resourcesFolder.getFile(results[0].toString());
				nameSubFlow.setText(customState.getName());
				customState.setPath(resultcustom.getName());
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

		BasicNewResourceWizard createWizard;

		if (customState != null) {
			// Si se quiere cambiar la jsp asociada a un estado custom creamos el wizard de creación de jsp.
			createWizard = new CreateJspCustom(folder);
		} else {
			// Si se quiere cambiar el locution (definition) asociado a un estado creamos el wizard de creación de
			// definition.
			createWizard = createDslJVoice(folder);
		}

		WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				createWizard);

		if (wizardDialog.open() == Window.OK) {
			if (customState != null) {
				customState.setPath(((CreateJspCustom) createWizard).getFile().getName());
			} else {
				// Obtenemos la URI del dsl creado
				URI locationUri = ((CreateDslJVoice) createWizard).getURI();
				// Cambios la asociación estado-dsl. Del antiguo dsl al nuevo.
				setNewLocutionOnState(locationUri);
			}
		}

	}

	private CreateDslJVoice createDslJVoice(IFolder folder) {
		CreateDslJVoice createDslWizard;

		// Se crea el wizard adecuado en función del tipo de estado.
		if (menuState != null) {
			createDslWizard = new CreateDslJVoice(folder, MenuDsl.class);
		} else if (inputState != null) {
			createDslWizard = new CreateDslJVoice(folder, InputDsl.class);
		} else if (outputState != null) {
			createDslWizard = new CreateDslJVoice(folder, PromptDsl.class);
		} else if (recordState != null) {
			createDslWizard = new CreateDslJVoice(folder, RecordDsl.class);
		} else {
			createDslWizard = new CreateDslJVoice(folder, TransferDsl.class);
		}

		return createDslWizard;
	}

	private void setNewLocutionOnState(URI locationUri) {

		VoiceDsl voiceDsl = (VoiceDsl) flujo.eResource().getResourceSet().getEObject(locationUri, true);

		// Se setea el locution (definition) en el estado.
		if (menuState != null) {
			menuState.setLocution(voiceDsl);
		} else if (inputState != null) {
			inputState.setLocution(voiceDsl);
		} else if (outputState != null) {
			outputState.setLocution(voiceDsl);
		} else if (recordState != null) {
			recordState.setLocution(voiceDsl);
		} else {
			transferState.setLocution(voiceDsl);
		}

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
		if (menuState != null) {
			return (Flow) menuState.eContainer();
		}
		if (inputState != null) {
			return (Flow) inputState.eContainer();
		}
		if (outputState != null) {
			return (Flow) outputState.eContainer();
		}
		if (recordState != null) {
			return (Flow) recordState.eContainer();
		}
		if (transferState != null) {
			return (Flow) transferState.eContainer();
		}
		if (customState != null) {
			return (Flow) customState.eContainer();
		}
		return null;
	}
}
