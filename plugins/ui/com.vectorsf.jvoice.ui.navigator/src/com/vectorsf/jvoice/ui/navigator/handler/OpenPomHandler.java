package com.vectorsf.jvoice.ui.navigator.handler;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;

import com.vectorsf.jvoice.model.base.JVProject;

public class OpenPomHandler extends AbstractHandler {
	private IFile filePOM;
	private static final String POM_XML = "/pom.xml";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Obtenemos el POM correspondiente al proyecto y lo mostramos en
		// pantalla
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (sel instanceof IStructuredSelection) {
			JVProject module = (JVProject) ((IStructuredSelection) sel)
					.getFirstElement();
			IProject iproject = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(module.getName());
			File pomFile = new File(iproject.getLocationURI().getPath(),
					POM_XML);
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			IPath location = Path.fromOSString(pomFile.getAbsolutePath());
			filePOM = ResourcesPlugin.getWorkspace().getRoot()
					.getFileForLocation(location);
			if (filePOM.exists()) {
				try {
					IDE.openEditor(page, filePOM);
				} catch (PartInitException e) {
					String error = "error open editor";
					IStatus status = new Status(IStatus.ERROR, "0", error, e);
					ErrorDialog.openError(
							Display.getDefault().getActiveShell(), error, null,
							status);
				}
			}
		}
		return null;
	}

}
