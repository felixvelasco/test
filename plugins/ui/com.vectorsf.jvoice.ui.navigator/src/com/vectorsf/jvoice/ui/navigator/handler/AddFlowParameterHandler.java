package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.ui.navigator.util.AbstractFlowModificationOperation;

public class AddFlowParameterHandler extends AbstractModifyFlowHandler {

	private String name;

	public AddFlowParameterHandler() {
		super();
		setOperation(new AddFlowParameterOperation());
	}

	@Override
	protected boolean canExecute(ExecutionEvent event) {
		Shell shell = HandlerUtil.getActiveShell(event);
		Flow flow = operation.getOriginalFlow();

		FlowParameterAddDialog dialog = new FlowParameterAddDialog(shell, flow);

		boolean ret = dialog.open() == Window.OK;
		if (ret) {
			name = dialog.getParameterName();
		}
		return ret;
	}

	public class AddFlowParameterOperation extends AbstractFlowModificationOperation {

		@Override
		protected Command getChangeCommand(EditingDomain domain, Flow flow) {
			return AddCommand.create(domain, flow, OperationsPackage.eINSTANCE.getFlow_Parameters(), name);
		}

	}
}
