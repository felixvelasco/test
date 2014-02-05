package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.ui.navigator.util.AbstractFlowModificationOperation;

public class RefreshBeanScopeHandler extends AbstractModifyFlowHandler {

	private ComponentBean selectedBean;
	private ComponentBean changeBean;

	public RefreshBeanScopeHandler() {
		super();
		setOperation(new RefreshBeanScopeOperation());
	}

	@Override
	protected boolean canExecute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) currentSelection).getFirstElement();
			if (firstElement instanceof ComponentBean) {
				Shell shell = HandlerUtil.getActiveShell(event);
				selectedBean = (ComponentBean) firstElement;
				Flow flow = operation.getOriginalFlow();

				IProject project = getProject(flow);
				BeanScopeAddDialog dialog = new BeanScopeAddDialog(shell, flow, findPackage(project), project,
						selectedBean);
				boolean ret = dialog.open() == Window.OK;
				if (ret) {
					changeBean = dialog.getComponentBean();
				}
				return ret;
			}
		}
		return false;

	}

	@SuppressWarnings("restriction")
	protected IPackageFragment findPackage(IProject project) {
		org.eclipse.jdt.internal.core.JavaProject javaProject = (org.eclipse.jdt.internal.core.JavaProject) JavaCore
				.create(project);
		try {
			String pack = ((JVModule) BaseModel.getInstance().getModel().getProject(project.getName()))
					.getComponentsPackage();
			return (IPackageFragment) javaProject.findPackageFragment(pack);
		} catch (JavaModelException e) {
			return null;
		}
	}

	public class RefreshBeanScopeOperation extends AbstractFlowModificationOperation {

		@Override
		protected Command getChangeCommand(EditingDomain domain, Flow flow) {
			for (ComponentBean bean : flow.getBeans()) {
				if (bean == selectedBean || bean.getId().equals(selectedBean.getId())) {
					CompoundCommand commandrefresh = new CompoundCommand();

					Command prototype = SetCommand.create(domain, bean,
							OperationsPackage.eINSTANCE.getComponentBean_Prototype(), changeBean.isPrototype());
					Command fqdn = SetCommand.create(domain, bean, OperationsPackage.eINSTANCE.getComponentBean_Fqdn(),
							changeBean.getFqdn());
					Command namebean = SetCommand.create(domain, bean,
							OperationsPackage.eINSTANCE.getComponentBean_NameBean(), changeBean.getNameBean());
					Command name = SetCommand.create(domain, bean, BasePackage.eINSTANCE.getNamedElement_Name(),
							changeBean.getName());
					commandrefresh.appendIfCanExecute(prototype);
					commandrefresh.appendIfCanExecute(namebean);
					commandrefresh.appendIfCanExecute(fqdn);
					commandrefresh.appendIfCanExecute(name);

					return commandrefresh;
				}

			}
			return null;
		}
	}

}
