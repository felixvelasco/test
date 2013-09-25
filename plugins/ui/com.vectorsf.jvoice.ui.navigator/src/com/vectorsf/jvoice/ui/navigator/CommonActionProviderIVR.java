/**
 * 
 */
package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.navigator.CommonActionProvider;

import com.vectorsf.jvoice.model.base.JVBean;

/**
 * @author xIS14487
 * 
 */
public class CommonActionProviderIVR extends CommonActionProvider {

	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		IStructuredSelection selection = (IStructuredSelection) getContext()
				.getSelection();

		for (Object o : selection.toArray()) {
			if (o instanceof JVBean) {

				// re-target the double-click open action.
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				IFile file = (IFile) Platform.getAdapterManager().getAdapter(o,
						IFile.class);

				try {
					IDE.openEditor(page, file);

				} catch (PartInitException e) {
					try {
						throw new ExecutionException("Error opening "
								+ ((JVBean) o).getName(), e);
					} catch (ExecutionException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		}

	}

}
