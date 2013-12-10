package com.vectorsf.jvoice.ui.navigator.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.resources.mapping.ResourceMappingContext;
import org.eclipse.core.resources.mapping.ResourceTraversal;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.internal.ui.refactoring.RefactoringUIMessages;
import org.eclipse.ltk.internal.ui.refactoring.RefactoringUIPlugin;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.ui.navigator.util.AbstractFlowModificationOperation;
import com.vectorsf.jvoice.ui.navigator.util.RenameIVRResourceWizard;

@SuppressWarnings("restriction")
public class RenameHandler extends AbstractModifyFlowHandler {

	private CompoundCommand cambios = new CompoundCommand();
	private RenameFlowState renameStateFlow = new RenameFlowState();
	private List<VoiceDsl> estados = new ArrayList<VoiceDsl>();
	private String newName;

	public RenameHandler() {
		super();
		setOperation(renameStateFlow);
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell activeShell = HandlerUtil.getActiveShell(event);
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (sel instanceof IStructuredSelection) {
			IResource resource = getCurrentResource((IStructuredSelection) sel);
			if (resource != null) {
				RenameIVRResourceWizard refactoringWizard = new RenameIVRResourceWizard(
						resource);
				RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(
						refactoringWizard);
				try {
					op.run(activeShell,
							RefactoringUIMessages.RenameResourceHandler_title);

					if (refactoringWizard.isDsl()) {
						// se ha renombrado un DSL, tenemos que actualizar el
						// flujo
						newName = refactoringWizard.getNewName();

						buscarFlow(resource);
						renameStateFlow.saveFlow();
					}
				} catch (InterruptedException e) {
					// do nothing
				}
			}
		}
		return null;
	}

	private void buscarFlow(IResource resource) {

		IFolder base = (IFolder) resource.getParent().getParent();
		String flujoBuscado = resource.getParent().getName()
				.replace(".resources", ".jvflow");

		IFile flujo = base.getFile(flujoBuscado);
		if (flujo.exists()) {
			JVModel model = BaseModel.getInstance().getModel();
			JVModule proyecto = (JVModule) model.getProject(resource
					.getProject().getName());
			JVPackage paquete = proyecto.getPackage(base.getName());
			Flow flow = (Flow) paquete.getBean(flujoBuscado.replace(".jvflow",
					""));

			renameStateFlow.setOriginalFlow(flow);

			if (flow.getStates().size() > 0) {
				for (State estado : flow.getStates()) {
					if (estado instanceof LocutionState) {
						LocutionState salida = (LocutionState) estado;
						if (salida.getLocution() != null) {
							VoiceDsl voice = salida.getLocution();
							if (voice
									.eResource()
									.getURI()
									.equals(URI.createPlatformResourceURI(
											resource.getFullPath().toString(),
											true))) {

								voice.setName(newName);
								estados.add(voice);
							}
						}
					}
				}
			}
		}
	}

	private IResource getCurrentResource(IStructuredSelection sel) {
		IResource[] resources = getSelectedResources(sel);
		if (resources.length == 1) {
			return resources[0];
		}
		return null;
	}

	protected IResource[] getSelectedResources(IStructuredSelection sel) {
		List<Object> resources = new ArrayList<Object>(sel.size());
		for (Iterator<?> e = sel.iterator(); e.hasNext();) {
			Object next = e.next();
			if (next instanceof IResource) {
				resources.add(next);
				continue;
			} else if (next instanceof IAdaptable) {
				Object resource = ((IAdaptable) next)
						.getAdapter(IResource.class);
				if (resource != null) {
					resources.add(resource);
					continue;
				}
			} else {
				IAdapterManager adapterManager = Platform.getAdapterManager();
				ResourceMapping mapping = (ResourceMapping) adapterManager
						.getAdapter(next, ResourceMapping.class);

				if (mapping != null) {

					ResourceTraversal[] traversals = null;
					try {
						traversals = mapping.getTraversals(
								ResourceMappingContext.LOCAL_CONTEXT,
								new NullProgressMonitor());
					} catch (CoreException exception) {
						RefactoringUIPlugin.log(exception.getStatus());
					}

					if (traversals != null) {
						for (int i = 0; i < traversals.length; i++) {
							IResource[] traversalResources = traversals[i]
									.getResources();
							if (traversalResources != null) {
								for (int j = 0; j < traversalResources.length; j++) {
									resources.add(traversalResources[j]);
								}// for
							}// if
						}// for
					}// if
				}// if
			}
		}
		return resources.toArray(new IResource[resources.size()]);
	}

	@Override
	protected boolean canExecute(ExecutionEvent event)
			throws ExecutionException {
		return true;
	}

	public class RenameFlowState extends AbstractFlowModificationOperation {

		protected Flow flow;
		private EditingDomain editingDomain;
		private boolean shouldSave;
		private VoiceDsl changed;

		@Override
		protected Command getChangeCommand(EditingDomain domain, Flow flow) {

			return SetCommand.create(domain, flow,
					OperationsPackage.eINSTANCE.getLocutionState_Locution(),
					changed);
		}

		@Override
		public void saveFlow() throws ExecutionException {
			try {
				flow = getOriginalFlow();
				URI uri = EcoreUtil.getURI(flow);
				Flow persistedFlow = getModifiableFlow(uri);
				for (VoiceDsl voiceDsl : estados) {
					changed = voiceDsl;
					cambios.append(getChangeCommand(editingDomain,
							persistedFlow));
				}

				editingDomain.getCommandStack().execute(cambios);

				if (shouldSave) {
					persistedFlow.eResource().save(null);
				}
			} catch (IOException e) {
				throw new ExecutionException("Error saving " + flow.getName(),
						e);
			}
		}

		private Flow getModifiableFlow(URI uri) {
			URIEditorInput input = new URIEditorInput(uri);
			IEditorPart editor = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.findEditor(input);

			if (editor == null || !(editor instanceof IEditingDomainProvider)) {
				editingDomain = TransactionalEditingDomain.Factory.INSTANCE
						.createEditingDomain();
				ResourceSet resourceSet = editingDomain.getResourceSet();
				VegaXMLURIHandlerImpl vegaURIHandler = new VegaXMLURIHandlerImpl();
				resourceSet.getLoadOptions().put(
						XMLResource.OPTION_URI_HANDLER, vegaURIHandler);
				Flow persistedFlow = (Flow) resourceSet.getEObject(uri, true);
				shouldSave = true;

				return persistedFlow;
			} else if (editor instanceof IEditingDomainProvider) {
				IEditingDomainProvider provider = (IEditingDomainProvider) editor;
				editingDomain = provider.getEditingDomain();
				ResourceSet rSet = editingDomain.getResourceSet();
				Flow liveFlow = (Flow) rSet.getEObject(uri, true);
				shouldSave = false;

				return liveFlow;
			}
			return null;
		}
	}
}
