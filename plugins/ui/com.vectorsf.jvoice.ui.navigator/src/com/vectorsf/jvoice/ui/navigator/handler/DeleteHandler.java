package com.vectorsf.jvoice.ui.navigator.handler;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
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
		refactoringWizard.setDefaultPageTitle("Delete");
		RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(
				refactoringWizard);
		try {
			Shell activeShell = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell();
			op.run(activeShell, "");

			// Si se trata de un fichero wsdl se elima del pom el plugin
			// correspondiente.
			for (IResource iResource : resources) {
				String extension = iResource.getName().substring(
						iResource.getName().lastIndexOf(".") + 1);
				if ("wsdl".equalsIgnoreCase(extension)) {
					DeletePomWSDL deletewsdl = new DeletePomWSDL();
					IFolder folder = (IFolder) iResource.getParent();
					try {
						if (folder.members().length == 0) {
							deletewsdl.modifyPom(iResource.getProject());
						}
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (InterruptedException e) {
		}
		return true;
	}
}
