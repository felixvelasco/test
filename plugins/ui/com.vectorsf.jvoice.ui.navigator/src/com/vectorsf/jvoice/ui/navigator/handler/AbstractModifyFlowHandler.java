package com.vectorsf.jvoice.ui.navigator.handler;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.provider.flow.TransientFlowItemProvider;

public abstract class AbstractModifyFlowHandler extends AbstractHandler {

	protected Flow flow;

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
			ResourceSet resourceSet = new ResourceSetImpl();
			VegaXMLURIHandlerImpl vegaURIHandler = new VegaXMLURIHandlerImpl();
			resourceSet.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, vegaURIHandler);
			Flow persistedFlow = (Flow) resourceSet.getEObject(uri, true);

			performChanges(persistedFlow);
			persistedFlow.eResource().save(null);
		} catch (IOException e) {
			throw new ExecutionException("Error saving " + flow.getName(), e);
		}
	}

	protected abstract void performChanges(Flow persistedFlow) throws ExecutionException;

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