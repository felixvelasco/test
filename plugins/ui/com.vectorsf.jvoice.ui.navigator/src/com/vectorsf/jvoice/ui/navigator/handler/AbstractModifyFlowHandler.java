package com.vectorsf.jvoice.ui.navigator.handler;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.provider.flow.TransientFlowItemProvider;

public abstract class AbstractModifyFlowHandler extends AbstractHandler {

	protected Flow flow;
	private EditingDomain editingDomain;
	private boolean shouldSave;

	public AbstractModifyFlowHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		flow = getFlow(event);
		if (flow == null) {
			return null;
		}

		if (canExecute(event)) {
			saveFlow();
		}

		return null;
	}

	private void saveFlow() throws ExecutionException {
		try {
			URI uri = EcoreUtil.getURI(flow);
			Flow persistedFlow = getModifiableFlow(uri);

			Command command = getChangeCommand(editingDomain, persistedFlow);
			editingDomain.getCommandStack().execute(command);

			if (shouldSave) {
				persistedFlow.eResource().save(null);
			}
		} catch (IOException e) {
			throw new ExecutionException("Error saving " + flow.getName(), e);
		}
	}

	private Flow getModifiableFlow(URI uri) {
		URIEditorInput input = new URIEditorInput(uri);
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findEditor(input);

		if (editor == null || !(editor instanceof IEditingDomainProvider)) {
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
			ResourceSet resourceSet = editingDomain.getResourceSet();
			VegaXMLURIHandlerImpl vegaURIHandler = new VegaXMLURIHandlerImpl();
			resourceSet.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, vegaURIHandler);
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

	protected abstract Command getChangeCommand(EditingDomain domain, Flow persistedFlow) throws ExecutionException;

	protected abstract boolean canExecute(ExecutionEvent event) throws ExecutionException;

	protected IProject getProject(Flow flow) {
		URI uri = flow.eResource().getURI();
		IPath path = new Path(uri.toPlatformString(true));
		return ResourcesPlugin.getWorkspace().getRoot().getFile(path).getProject();
	}

	protected Flow getFlow(ExecutionEvent event) {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) currentSelection).getFirstElement();
			if (firstElement instanceof TransientFlowItemProvider) {
				return ((TransientFlowItemProvider) firstElement).getFlow();
			} else if (firstElement instanceof Flow) {
				return (Flow) firstElement;
			}
		}

		return null;
	}

}