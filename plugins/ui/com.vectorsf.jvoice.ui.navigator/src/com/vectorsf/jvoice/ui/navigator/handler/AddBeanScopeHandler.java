package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.ui.navigator.util.AbstractFlowModificationOperation;

public class AddBeanScopeHandler extends AbstractModifyFlowHandler {

	public AddBeanScopeHandler() {
		super();
		setOperation(new AddBeanScopeOperation());
	}

	private ComponentBean componentBean;

	@Override
	protected boolean canExecute(ExecutionEvent event) {
		Flow flow = operation.getOriginalFlow();
		IProject project = getProject(flow);
		Shell shell = HandlerUtil.getActiveShell(event);

		BeanScopeAddDialog dialog = new BeanScopeAddDialog(shell,
				operation.getPersistedFlow(), (IPackageFragment) findPackage(
						flow, project), project);
		boolean ret = dialog.open() == Window.OK;
		if (ret) {
			componentBean = dialog.getComponentBean();
		}
		return ret;
	}

	@SuppressWarnings("restriction")
	protected IJavaElement findPackage(Flow flow, IProject project) {
		org.eclipse.jdt.internal.core.JavaProject javaProject = (org.eclipse.jdt.internal.core.JavaProject) JavaCore
				.create(project);
		try {
			return javaProject.findPackageFragment(flow.getOwnerPackage()
					.getOwnerModule().getComponentsPackage());
		} catch (JavaModelException e) {
			return null;
		}
	}

	public class AddBeanScopeOperation extends
			AbstractFlowModificationOperation {

		@Override
		protected Command getChangeCommand(EditingDomain domain, Flow flow) {
			return AddCommand.create(domain, flow,
					OperationsPackage.eINSTANCE.getFlow_Beans(), componentBean);
		}

	}

}
