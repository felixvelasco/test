/**
 * 
 */
package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.OpenFileAction;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

import com.vectorsf.jvoice.core.project.AbstractJVoiceNature;
import com.vectorsf.jvoice.model.base.JVProject;

/**
 * @author xIS14487
 * 
 */
public class JVProjectActionProvider extends CommonActionProvider {

	private OpenFileAction openFileAction;

	private ICommonViewerWorkbenchSite viewSite = null;
	private boolean contribute = false;

	@Override
	public void init(ICommonActionExtensionSite aConfig) {
		if (aConfig.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			viewSite = (ICommonViewerWorkbenchSite) aConfig.getViewSite();
			openFileAction = new OpenFileAction(viewSite.getPage());
			contribute = true;
		}
	}

	@Override
	public void fillContextMenu(IMenuManager aMenu) {
		if (!contribute || getContext().getSelection().isEmpty()) {
			return;
		}

		IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();

		openFileAction.selectionChanged(selection);
		if (openFileAction.isEnabled()) {
			aMenu.insertAfter(ICommonMenuConstants.GROUP_OPEN, openFileAction);
		}
	}

	@Override
	public void fillActionBars(IActionBars theActionBars) {
		if (!contribute) {
			return;
		}
		IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
		if (selection.size() == 1) {
			Object firstElement = selection.getFirstElement();
			if (firstElement instanceof JVProject) {
				IProject project = (IProject) Platform.getAdapterManager().getAdapter(firstElement, IProject.class);
				IStructuredSelection fakeSelection = new StructuredSelection(
						project.getFile(AbstractJVoiceNature.PROJECT_INFORMATION_FILE));
				openFileAction.selectionChanged(fakeSelection);
				theActionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openFileAction);
			}
		}

	}
}
