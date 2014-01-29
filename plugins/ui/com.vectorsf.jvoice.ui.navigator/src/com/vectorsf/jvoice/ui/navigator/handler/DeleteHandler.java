package com.vectorsf.jvoice.ui.navigator.handler;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.ltk.ui.refactoring.resource.DeleteResourcesWizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.model.operations.Flow;

public class DeleteHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection sel = (IStructuredSelection) currentSelection;
			Collection<IResource> resources = new ArrayList<IResource>();
			for (Object o : sel.toArray()) {
				IResource resource = (IResource) Platform.getAdapterManager()
						.getAdapter(o, IResource.class);
				if (resource != null) {
					resources.add(resource);
					if (o instanceof Flow) {
						IPath path = new Path(resource.getName().replace(
								".jvflow", ".resources"));
						IFolder relacionado = resource.getParent().getFolder(
								path);
						if (relacionado.exists()) {
							IResource extras = (IResource) Platform
									.getAdapterManager().getAdapter(
											relacionado, IResource.class);
							resources.add(extras);
						}
					}
				}
			}
			if (!resources.isEmpty()) {
				delete(resources.toArray(new IResource[resources.size()]));
			}
		}
		return null;
	}

	private boolean delete(final IResource[] resources) {
		DeleteResourcesWizard refactoringWizard = new DeleteResourcesWizard(
				resources);
		refactoringWizard.setDefaultPageTitle("Delete");
		RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(
				refactoringWizard);
		try {
			Shell activeShell = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell();
			op.run(activeShell, "");

		} catch (InterruptedException e) {
		}
		return true;
	}

}
