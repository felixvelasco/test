package com.vectorsf.jvoice.ui.navigator.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.resources.mapping.ResourceMappingContext;
import org.eclipse.core.resources.mapping.ResourceTraversal;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.internal.ui.refactoring.RefactoringUIMessages;
import org.eclipse.ltk.internal.ui.refactoring.RefactoringUIPlugin;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.ui.navigator.util.AbstractFlowModificationOperation;
import com.vectorsf.jvoice.ui.navigator.util.RenameIVRResourceWizard;

@SuppressWarnings("restriction")
public class RenameHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell activeShell = HandlerUtil.getActiveShell(event);
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (sel instanceof IStructuredSelection) {
			IResource resource = getCurrentResource((IStructuredSelection) sel);
			if (resource != null) {
				RenameIVRResourceWizard refactoringWizard = new RenameIVRResourceWizard(resource);
				RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(refactoringWizard);
				try {
					op.run(activeShell, RefactoringUIMessages.RenameResourceHandler_title);

					if (refactoringWizard.isDsl()) {
						// se ha renombrado un DSL, tenemos que actualizar el
						// flujo
						RenameFlowState renameStateFlow = new RenameFlowState();
						renameStateFlow.setOriginalURI(URI.createPlatformResourceURI(resource.getFullPath().toString(),
								true));
						renameStateFlow.setOriginalFlow(buscarFlow(resource));
						renameStateFlow.setNewName(refactoringWizard.getNewName());
						renameStateFlow.saveFlow();
					}
				} catch (InterruptedException e) {
					// do nothing
				}
			}
		}
		return null;
	}

	private Flow buscarFlow(IResource resource) {

		IFolder base = (IFolder) resource.getParent().getParent();
		IPath relativePackage = base.getProjectRelativePath().makeRelativeTo(new Path(BaseModel.JV_PATH));
		String flujoBuscado = resource.getParent().getName().replace(".resources", ".jvflow");

		JVModel model = BaseModel.getInstance().getModel();
		JVModule proyecto = (JVModule) model.getProject(resource.getProject().getName());
		JVPackage paquete = proyecto.getPackage(relativePackage.toString().replace("/", "."));
		Flow flow = (Flow) paquete.getBean(flujoBuscado.replace(".jvflow", ""));

		return flow;
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
				Object resource = ((IAdaptable) next).getAdapter(IResource.class);
				if (resource != null) {
					resources.add(resource);
					continue;
				}
			} else {
				IAdapterManager adapterManager = Platform.getAdapterManager();
				ResourceMapping mapping = (ResourceMapping) adapterManager.getAdapter(next, ResourceMapping.class);

				if (mapping != null) {

					ResourceTraversal[] traversals = null;
					try {
						traversals = mapping.getTraversals(ResourceMappingContext.LOCAL_CONTEXT,
								new NullProgressMonitor());
					} catch (CoreException exception) {
						RefactoringUIPlugin.log(exception.getStatus());
					}

					if (traversals != null) {
						for (int i = 0; i < traversals.length; i++) {
							IResource[] traversalResources = traversals[i].getResources();
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

	public class RenameFlowState extends AbstractFlowModificationOperation {

		private URI oldURI;
		private URI newURI;
		private Resource dslResource;
		private String newName;

		@Override
		protected Command getChangeCommand(EditingDomain domain, Flow flow) {
			CompoundCommand ret = new CompoundCommand();
			EObject eObject = domain.getResourceSet().getEObject(newURI, true);
			dslResource = eObject.eResource();
			ret.append(SetCommand.create(domain, eObject, BasePackage.eINSTANCE.getNamedElement_Name(), newName));
			for (State state : flow.getStates()) {
				if (state instanceof LocutionState) {
					LocutionState lState = (LocutionState) state;
					URI uri = EcoreUtil.getURI(lState.getLocution()).trimFragment();
					if (uri.equals(oldURI)) {
						ret.append(SetCommand.create(domain, lState,
								OperationsPackage.eINSTANCE.getLocutionState_Locution(), eObject));
					}
				}
			}

			return ret;
		}

		@Override
		public void saveFlow() throws ExecutionException {
			super.saveFlow();
			try {
				dslResource.save(null);
			} catch (IOException e) {
				throw new ExecutionException("Error saving " + flow.getName(), e);
			}
		}

		public void setOriginalURI(URI oldURI) {
			this.oldURI = oldURI;
		}

		public void setNewName(String name) {
			this.newName = name;
			this.newURI = oldURI.trimSegments(1).appendSegment(name + ".voiceDsl").appendFragment("/0");
		}
	}
}
