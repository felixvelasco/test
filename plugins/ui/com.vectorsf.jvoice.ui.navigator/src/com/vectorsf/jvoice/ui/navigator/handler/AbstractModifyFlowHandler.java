package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.AttributeValueWrapperItemProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.provider.flow.TransientFlowItemProvider;
import com.vectorsf.jvoice.ui.navigator.util.AbstractFlowModificationOperation;

public abstract class AbstractModifyFlowHandler extends AbstractHandler {

	protected AbstractFlowModificationOperation operation;

	public void setOperation(AbstractFlowModificationOperation operation) {
		this.operation = operation;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Flow flow = getFlow(event);
		if (flow == null) {
			return null;
		}

		operation.setOriginalFlow(flow);
		if (canExecute(event)) {
			operation.saveFlow();
		}

		return null;
	}

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
			} else if (firstElement instanceof EObject) {
				return findFlowAncestor((EObject) firstElement);
			} else if (firstElement instanceof AttributeValueWrapperItemProvider) {
				return findFlowAncestor((EObject) ((AttributeValueWrapperItemProvider) firstElement).getOwner());
			}
		}

		return null;
	}

	private Flow findFlowAncestor(EObject element) {
		if (element == null) {
			return null;
		}
		if (element instanceof Flow) {
			return (Flow) element;
		}
		return findFlowAncestor(element.eContainer());
	}

}