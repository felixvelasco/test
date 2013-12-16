package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AttributeValueWrapperItemProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.ui.navigator.util.AbstractFlowModificationOperation;
import com.vectorsf.jvoice.ui.navigator.util.RenameFlowParameterWizard;

public class RenameFlowParameterHandler extends AbstractModifyFlowHandler {
	private AttributeValueWrapperItemProvider value;
	private String newName;
	private int index;

	public RenameFlowParameterHandler() {
		super();
		setOperation(new RenameFlowParameterOperation());
	}

	@Override
	protected boolean canExecute(ExecutionEvent event)
			throws ExecutionException {
		Shell activeShell = HandlerUtil.getActiveShell(event);
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {

			Object firstElement = ((IStructuredSelection) currentSelection)
					.getFirstElement();
			if (firstElement instanceof AttributeValueWrapperItemProvider) {
				value = (AttributeValueWrapperItemProvider) firstElement;
				Flow flow = (Flow) value.getParent(value);
				RenameFlowParameterWizard wizard = new RenameFlowParameterWizard(
						flow, value.getText(value));
				WizardDialog dialog = new WizardDialog(activeShell, wizard);
				dialog.open();
				switch (dialog.getReturnCode()) {
				case Dialog.OK:
					newName = wizard.getParamName();
					for (int i = 0; i < flow.getParameters().size(); i++) {
						if (flow.getParameters().get(i)
								.equals(value.getText(value))) {
							index = i;
						}
					}
					return true;
				case Dialog.CANCEL:
					throw new OperationCanceledException();
				default:
					break;
				}
			}
		}

		return false;
	}

	public class RenameFlowParameterOperation extends
			AbstractFlowModificationOperation {

		@Override
		protected Command getChangeCommand(EditingDomain domain, Flow flow) {
			return SetCommand.create(domain, flow,
					OperationsPackage.eINSTANCE.getFlow_Parameters(), newName,
					index);
		}

	}

}
