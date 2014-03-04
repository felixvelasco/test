package com.vectorsf.jvoice.ui.navigator.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.resources.mapping.ResourceMappingContext;
import org.eclipse.core.resources.mapping.ResourceTraversal;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Crea la carpeta "src/main/webapp/resources/audios/numset" en las
 * aplicaciones.
 */
public class AddNumsetFolderHandler extends AbstractHandler {

    public static final String NUMSET_LOCATION = "src/main/webapp/resources/audios/numset";

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
	ISelection sel = HandlerUtil.getCurrentSelection(event);

	if (!(sel instanceof IStructuredSelection)) {
	    return null;
	}

	IResource[] selectedResources = getSelectedResources((IStructuredSelection) sel);
	if (selectedResources.length != 1) {
	    MessageDialog.openWarning(null, "Carpeta Numset",
		    "Seleccione un único proyecto de aplicación");
	    return null;
	}

	IProject prj = (IProject) selectedResources[0];

	if (prj.getFolder(NUMSET_LOCATION).exists()) {
	    MessageDialog.openWarning(null, "Carpeta Numset",
		    "Ya existe la carpeta '" + NUMSET_LOCATION + "'");
	    return null;
	}

	createFolder(prj);

	return null;
    }

    /**
     * Crea recursivamente la carpeta.
     */
    private void createFolder(IProject prj) {
	try {
	    StringTokenizer st = new StringTokenizer(NUMSET_LOCATION, "/");
	    String folderName = "";
	    while (st.hasMoreTokens()) {
		folderName += st.nextToken() + "/";
		IFolder folder = prj.getFolder(folderName);

		if (!folder.exists()) {
		    folder.create(true, true, null);
		}
	    }

	    MessageDialog.openConfirm(null, "Carpeta Numset",
		    "Creada carpeta '" + NUMSET_LOCATION + "'");
	} catch (Exception e) {
	    MessageDialog.openError(null, "Error",
		    "Se ha producido un error al crear la carpeta '"
			    + NUMSET_LOCATION + ":'\n\n" + e);
	}
    }

    protected IResource[] getSelectedResources(IStructuredSelection sel) {
	List<Object> resources = new ArrayList<Object>(sel.size());
	for (Iterator<?> e = sel.iterator(); e.hasNext();) {
	    Object next = e.next();
	    if (next instanceof IResource) {
		resources.add(next);
		continue;
	    } else if (next instanceof IAdaptable) {
		Object resource = ((IAdaptable) next)
			.getAdapter(IResource.class);
		if (resource != null) {
		    resources.add(resource);
		    continue;
		}
	    } else {
		IAdapterManager adapterManager = Platform.getAdapterManager();
		ResourceMapping mapping = (ResourceMapping) adapterManager
			.getAdapter(next, ResourceMapping.class);

		if (mapping != null) {

		    ResourceTraversal[] traversals = null;
		    try {
			traversals = mapping.getTraversals(
				ResourceMappingContext.LOCAL_CONTEXT,
				new NullProgressMonitor());
		    } catch (CoreException exception) {
			System.err
				.println("AddNumsetFolderHandler.getSelectedResources(): "
					+ e);
		    }

		    if (traversals != null) {
			for (int i = 0; i < traversals.length; i++) {
			    IResource[] traversalResources = traversals[i]
				    .getResources();
			    if (traversalResources != null) {
				for (int j = 0; j < traversalResources.length; j++) {
				    resources.add(traversalResources[j]);
				}
			    }
			}
		    }
		}
	    }
	}

	return resources.toArray(new IResource[resources.size()]);
    }

}
