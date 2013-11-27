package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.model.operations.Flow;

public class AddFlowParameterHandler extends AbstractModifyFlowHandler {

	private String name;

	@Override
	protected void performChanges(Flow flow) throws ExecutionException {
		flow.getParameters().add(name);
	}

	@Override
	protected boolean canExecute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);

		FlowParameterAddDialog dialog = new FlowParameterAddDialog(shell, flow);

		boolean ret = dialog.open() == Window.OK;
		if (ret) {
			name = dialog.getParameterName();
		}
		return ret;
	}

}
