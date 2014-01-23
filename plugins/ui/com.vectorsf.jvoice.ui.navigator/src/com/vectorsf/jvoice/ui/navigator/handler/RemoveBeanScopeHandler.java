package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.ui.navigator.util.AbstractFlowModificationOperation;

public class RemoveBeanScopeHandler extends AbstractModifyFlowHandler {

	private ComponentBean selectedBean;

	public RemoveBeanScopeHandler() {
		super();
		setOperation(new RemoveBeanScopeOperation());
	}

	@Override
	protected boolean canExecute(ExecutionEvent event) {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) currentSelection)
					.getFirstElement();
			if (firstElement instanceof ComponentBean) {
				selectedBean = (ComponentBean) firstElement;
				return true;
			}
		}
		return false;
	}

	public class RemoveBeanScopeOperation extends
			AbstractFlowModificationOperation {

		@Override
		protected Command getChangeCommand(EditingDomain domain, Flow flow) {
			for (ComponentBean bean : flow.getBeans()) {
				if (bean == selectedBean
						|| bean.getId().equals(selectedBean.getId())) {
					return DeleteCommand.create(domain, bean);
				}

			}
			return DeleteCommand.create(domain, selectedBean);
		}
	}

}
