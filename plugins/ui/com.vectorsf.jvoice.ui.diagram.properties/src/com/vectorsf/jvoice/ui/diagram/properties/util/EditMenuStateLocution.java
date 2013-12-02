package com.vectorsf.jvoice.ui.diagram.properties.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.PromptState;
import com.vectorsf.jvoice.model.operations.RecordState;
import com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogLocution;

public class EditMenuStateLocution extends RecordingCommand {

	private MenuState menuLocution;
	private InputState inputLocution;
	private PromptState outputLocution;
	private RecordState recordLocution;
	private Text nameSubFlow;
	private CustomState custom;
	private Flow flujo;
	private String flowFolderPath;
	private IFolder resourcesFolder;

	public EditMenuStateLocution(TransactionalEditingDomain domain, CustomState custom, Text nameSubFlow) {
		super(domain);
		this.custom = custom;
		this.nameSubFlow = nameSubFlow;

	}

	public EditMenuStateLocution(TransactionalEditingDomain domain, MenuState menuLocution, Text nameSubFlow) {
		super(domain);
		this.menuLocution = menuLocution;
		this.nameSubFlow = nameSubFlow;

	}

	public EditMenuStateLocution(TransactionalEditingDomain domain, InputState inputLocution, Text nameSubFlow) {
		super(domain);
		this.inputLocution = inputLocution;
		this.nameSubFlow = nameSubFlow;

	}

	public EditMenuStateLocution(TransactionalEditingDomain domain, PromptState outputLocution, Text nameSubFlow) {
		super(domain);
		this.outputLocution = outputLocution;
		this.nameSubFlow = nameSubFlow;

	}

	public EditMenuStateLocution(TransactionalEditingDomain domain, RecordState recordLocution, Text nameSubFlow) {
		super(domain);
		this.recordLocution = recordLocution;
		this.nameSubFlow = nameSubFlow;

	}

	@SuppressWarnings("restriction")
	@Override
	protected void doExecute() {
		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		flujo = obtenerFlow();
		DialogLocution dialog = new DialogLocution(activeShell);
		List locutionResources = new ArrayList<>();
		flowFolderPath = getFolderPath(flujo);

		resourcesFolder = (IFolder) ResourcesPlugin.getWorkspace().getRoot().findMember(flowFolderPath);

		try {
			IResource[] resources = resourcesFolder.members();
			for (IResource resource : resources) {
				if (resource instanceof File) {
					URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					EObject eObject = null;
					if (!resource.getName().contains(".jsp")) {
						eObject = flujo.eResource().getResourceSet().getResource(uri, true).getContents().get(0);
					}
					if (menuLocution != null) {
						if (eObject instanceof MenuDsl) {
							locutionResources.add(eObject);
						}
					}
					if (inputLocution != null) {
						if (eObject instanceof InputDsl) {
							locutionResources.add(eObject);
						}
					}
					if (outputLocution != null) {
						if (eObject instanceof PromptDsl) {
							locutionResources.add(eObject);
						}
					}
					if (recordLocution != null) {
						if (eObject instanceof RecordDsl) {
							locutionResources.add(eObject);
						}
					}
					if (custom != null) {
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
		dialog.setButtonCreateAvailable(false);
		dialog.setListLabelProvider(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		dialog.setInitialPattern("?", FilteredItemsSelectionDialog.FULL_SELECTION);

		titleAndMessage(dialog);

		dialog.open();

		// change locution
		Object[] results = dialog.getResult();
		changeLocution(results);
	}

	private void titleAndMessage(DialogLocution dialog) {
		if (menuLocution != null) {
			dialog.setTitle("Menu Selection");
			dialog.setMessage("Select a menu:");
		} else if (inputLocution != null) {
			dialog.setTitle("Input Selection");
			dialog.setMessage("Select an input:");
		} else if (outputLocution != null) {
			dialog.setTitle("Output Selection");
			dialog.setMessage("Select an output:");
		} else if (recordLocution != null) {
			dialog.setTitle("Record Selection");
			dialog.setMessage("Select an record:");
		} else if (custom != null) {
			dialog.setTitle("Custom Selection");
			dialog.setMessage("Select a Custom:");
		}
	}

	private void changeLocution(Object[] results) {
		if (results != null) {
			if (results[0] instanceof MenuDsl) {
				MenuDsl result = (MenuDsl) results[0];
				URI menuURI = EcoreUtil.getURI(result);
				result = (MenuDsl) menuLocution.eResource().getResourceSet().getEObject(menuURI, true);

				menuLocution.setLocution(result);
				nameSubFlow.setText(menuLocution.getLocution().getName());

			} else if (results[0] instanceof InputDsl) {
				InputDsl result = (InputDsl) results[0];
				URI inputURI = EcoreUtil.getURI(result);
				result = (InputDsl) inputLocution.eResource().getResourceSet().getEObject(inputURI, true);

				inputLocution.setLocution(result);
				nameSubFlow.setText(inputLocution.getLocution().getName());

			} else if (results[0] instanceof PromptDsl) {
				PromptDsl result = (PromptDsl) results[0];

				URI outputURI = EcoreUtil.getURI(result);
				result = (PromptDsl) outputLocution.eResource().getResourceSet().getEObject(outputURI, true);

				outputLocution.setLocution(result);
				nameSubFlow.setText(outputLocution.getLocution().getName());
			} else if (results[0] instanceof RecordDsl) {
				RecordDsl result = (RecordDsl) results[0];
				URI inputURI = EcoreUtil.getURI(result);
				result = (RecordDsl) recordLocution.eResource().getResourceSet().getEObject(inputURI, true);

				recordLocution.setLocution(result);
				nameSubFlow.setText(recordLocution.getLocution().getName());

			} else if (results[0].toString().contains(".jsp")) {
				IFile resultcustom = resourcesFolder.getFile(results[0].toString());
				nameSubFlow.setText(custom.getName());
				custom.setPath(resultcustom.getName());

			}
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
		if (menuLocution != null) {
			return (Flow) menuLocution.eContainer();
		}
		if (inputLocution != null) {
			return (Flow) inputLocution.eContainer();
		}
		if (outputLocution != null) {
			return (Flow) outputLocution.eContainer();
		}
		if (recordLocution != null) {
			return (Flow) recordLocution.eContainer();
		}
		if (custom != null) {
			return (Flow) custom.eContainer();
		}
		return null;
	}
}
