package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;

import com.vectorsf.jvoice.model.base.JVBean;

public class OpenHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection sel = (IStructuredSelection) currentSelection;

			for (Object o : sel.toArray()) {
				if (o instanceof JVBean) {

					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					IFile file = (IFile) Platform.getAdapterManager().getAdapter(o, IFile.class);

					try {
						IDE.openEditor(page, file);

					} catch (PartInitException e) {
						throw new ExecutionException("Error opening " + ((JVBean) o).getName(), e);
					}
				}
			}
		}
		return null;
	}
}
