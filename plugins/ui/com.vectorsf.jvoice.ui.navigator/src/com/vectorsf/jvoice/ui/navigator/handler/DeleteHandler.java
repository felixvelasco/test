package com.vectorsf.jvoice.ui.navigator.handler;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.ltk.ui.refactoring.resource.DeleteResourcesWizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

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
		refactoringWizard.setWindowTitle("Borrar");
		RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(
				refactoringWizard);
		try {
			Shell activeShell = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell();
			op.run(activeShell, "Se va a borrar eh?");
		} catch (InterruptedException e) {
		}
		return true;
	}
}
