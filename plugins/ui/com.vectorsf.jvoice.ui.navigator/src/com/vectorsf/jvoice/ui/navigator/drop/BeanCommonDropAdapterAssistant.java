package com.vectorsf.jvoice.ui.navigator.drop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;

import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.ui.navigator.activator.Activator;

public class BeanCommonDropAdapterAssistant extends CommonDropAdapterAssistant {
    public BeanCommonDropAdapterAssistant() {
    }

    @Override
    public IStatus validateDrop(Object target, int operation,
	    TransferData transferType) {
	if (operation != DND.DROP_MOVE) {
	    return Status.CANCEL_STATUS;
	}

	if (getBeans().isEmpty()) {
	    return Status.CANCEL_STATUS;
	}

	IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
	for (JVBean bean : getBeans()) {

	    IFile diagram = (IFile) Platform.getAdapterManager().getAdapter(
		    bean, IFile.class);

	    IResource targetRes = (IResource) Platform.getAdapterManager()
		    .getAdapter(target, IResource.class);
	    IPath targetPath = targetRes.getFullPath()
		    .append(diagram.getName());
	    if (root.getFile(targetPath).exists()) {
		return Status.CANCEL_STATUS;
	    }
	}

	return Status.OK_STATUS;
    }

    @Override
    public IStatus handleDrop(CommonDropAdapter aDropAdapter,
	    DropTargetEvent aDropTargetEvent, Object aTarget) {
	aDropTargetEvent.detail = DND.DROP_NONE;

	JVPackage target = (JVPackage) aTarget;
	for (JVBean bean : getBeans()) {
	    IFile diagram = (IFile) Platform.getAdapterManager().getAdapter(
		    bean, IFile.class);

	    // Recursos del flow
	    IFolder resourcesFlow = diagram.getParent()
		    .getFolder(
			    new Path(diagram.getName().replace(".jvflow",
				    ".resources")));

	    if (!resourcesFlow.exists()) {
		// no existe carpeta de recursos, se cancela la operacion
		return Status.CANCEL_STATUS;
	    }

	    IResource targetRes = (IResource) Platform.getAdapterManager()
		    .getAdapter(target, IResource.class);
	    IPath targetPath = targetRes.getFullPath()
		    .append(diagram.getName());

	    IPath targetResources = targetRes.getFullPath().append(
		    resourcesFlow.getName());

	    try {
		diagram.move(targetPath, true, null);
		resourcesFlow.move(targetResources, true, null);
	    } catch (CoreException e) {
		Activator
			.getDefault()
			.getLog()
			.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
				"Error moving resources", e));
		e.printStackTrace();
	    }

	}

	return Status.OK_STATUS;
    }

    private Collection<JVBean> getBeans() {
	Collection<JVBean> selectedResources = new ArrayList<JVBean>();
	ISelection selection = LocalSelectionTransfer.getTransfer()
		.getSelection();

	if (selection instanceof IStructuredSelection) {
	    for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it
		    .hasNext();) {
		Object o = it.next();
		if (o instanceof JVBean) {
		    selectedResources.add((JVBean) o);
		} else {
		    return Collections.emptySet();
		}
	    }
	}

	return selectedResources;
    }

}
