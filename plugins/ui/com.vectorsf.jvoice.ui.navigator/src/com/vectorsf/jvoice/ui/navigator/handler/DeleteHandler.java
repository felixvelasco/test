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
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.ltk.ui.refactoring.resource.DeleteResourcesWizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.core.operation.helper.FlowService;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.operations.Flow;

public class DeleteHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection sel = (IStructuredSelection) currentSelection;
			Collection<IResource> resources = new ArrayList<IResource>();
			for (Object o : sel.toArray()) {
				IResource resource = (IResource) Platform.getAdapterManager().getAdapter(o, IResource.class);
				if (resource != null) {
					resources.add(resource);
					if (o instanceof Flow) {
						IResource resourcesFolder = findResourcesFolder(resource);
						if (resourcesFolder.exists()) {
							resources.add(resourcesFolder);
						}

						IResource helperClass = findHelperClass((Flow) o);
						if (helperClass != null && helperClass.exists()) {
							resources.add(helperClass);
						}
					}
					if (o instanceof JVPackage) {
						JVPackage jvPackage = (JVPackage) o;

						for (JVBean bean : jvPackage.getBeans()) {
							if (bean instanceof Flow) {
								IResource helperClass = findHelperClass((Flow) bean);
								if (helperClass != null && helperClass.exists()) {
									resources.add(helperClass);
								}
							}
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

	private IResource findHelperClass(Flow flow) {
		try {
			ICompilationUnit helperFile = FlowService.getHelperICU(flow);
			return helperFile == null ? null : helperFile.getResource();
		} catch (JavaModelException e) {
			return null;
		}
	}

	private IFolder findResourcesFolder(IResource resource) {
		IPath path = new Path(resource.getName().replace(".jvflow", ".resources"));
		IFolder relacionado = resource.getParent().getFolder(path);
		return relacionado;
	}

	private boolean delete(final IResource[] resources) {
		DeleteResourcesWizard refactoringWizard = new DeleteResourcesWizard(resources);
		refactoringWizard.setDefaultPageTitle("Delete");
		RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(refactoringWizard);
		try {
			Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			op.run(activeShell, "");

		} catch (InterruptedException e) {
		}
		return true;
	}

}
