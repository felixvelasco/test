package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AttributeValueWrapperItemProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.ui.navigator.util.AbstractFlowModificationOperation;

public class RemoveFlowParameterHandler extends AbstractModifyFlowHandler {

	private AttributeValueWrapperItemProvider value;

	public RemoveFlowParameterHandler() {
		super();
		setOperation(new RemoveFlowParameterOperation());
	}

	@Override
	protected boolean canExecute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) currentSelection).getFirstElement();
			if (firstElement instanceof AttributeValueWrapperItemProvider) {
				value = (AttributeValueWrapperItemProvider) firstElement;
				return true;
			}
		}
		return false;
	}

	public class RemoveFlowParameterOperation extends AbstractFlowModificationOperation {

		@Override
		protected Command getChangeCommand(EditingDomain domain, Flow flow) {
			return RemoveCommand.create(domain, flow, OperationsPackage.eINSTANCE.getFlow_Parameters(),
					value.getValue());
		}

	}
}
