package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JavaProject;
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

import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.ui.navigator.activator.Activator;

public class ComponentBeanActionProviderIVR extends CommonActionProvider {

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

	IStructuredSelection selection = (IStructuredSelection) getContext()
		.getSelection();

	openFileAction.selectionChanged(selection);
	if (openFileAction.isEnabled()) {
	    aMenu.insertAfter(ICommonMenuConstants.GROUP_OPEN, openFileAction);
	}
    }

    @SuppressWarnings("restriction")
    @Override
    public void fillActionBars(IActionBars theActionBars) {
	if (!contribute) {
	    return;
	}
	IStructuredSelection selection = (IStructuredSelection) getContext()
		.getSelection();
	if (selection.size() == 1) {
	    Object firstElement = selection.getFirstElement();
	    if (firstElement instanceof ComponentBean) {
		ComponentBean componente = (ComponentBean) firstElement;
		Flow flujo = (Flow) componente.eContainer();
		IFile fileFlow = (IFile) Platform.getAdapterManager()
			.getAdapter(flujo, IFile.class);

		IProject project = fileFlow.getProject();

		JavaProject javaProject = (JavaProject) JavaCore
			.create(project);

		IType type;
		try {
		    type = javaProject.findType(componente.getFqdn());
		    selection = new StructuredSelection(type);
		    openFileAction.selectionChanged(selection);
		    theActionBars.setGlobalActionHandler(
			    ICommonActionConstants.OPEN, openFileAction);
		} catch (JavaModelException e) {
		    Activator
			    .getDefault()
			    .getLog()
			    .log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
				    "Error buscando clase", e));
		    e.printStackTrace();
		}
	    }
	}
    }
}
