package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.provider.flow.ScopeItemProvider;

public class AddBeanScopeHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Flow flow = getFlow(event);
		if (flow == null) {
			return null;
		}

		IProject project = getProject(flow);
		IJavaProject jProject = JavaCore.create(project);

		Shell shell = HandlerUtil.getActiveShell(event);

		BeanScopeAddDialog dialog = new BeanScopeAddDialog(shell, jProject);
		dialog.open();

		return null;
	}

	private IProject getProject(Flow flow) {
		URI uri = flow.eResource().getURI();
		IPath path = new Path(uri.toPlatformString(true));
		return ResourcesPlugin.getWorkspace().getRoot().getFile(path)
				.getProject();
	}

	private Flow getFlow(ExecutionEvent event) {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) currentSelection)
					.getFirstElement();
			if (firstElement instanceof ScopeItemProvider) {
				return ((ScopeItemProvider) firstElement).getFlow();
			}
		}

		return null;
	}
}
