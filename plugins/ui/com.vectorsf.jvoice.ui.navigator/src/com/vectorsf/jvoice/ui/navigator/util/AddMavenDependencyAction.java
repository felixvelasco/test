package com.vectorsf.jvoice.ui.navigator.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2e.core.internal.IMavenConstants;
import org.eclipse.m2e.core.ui.internal.actions.AddDependencyAction;

import com.vectorsf.jvoice.model.base.JVProject;

public class AddMavenDependencyAction extends AddDependencyAction {

	@Override
	protected IFile getPomFileFromPomEditorOrViewSelection() {
		IFile file = null;

		if (selection instanceof IStructuredSelection) {
			Object o = selection.iterator().next();

			if (o instanceof JVProject) {
				IProject project = (IProject) Platform.getAdapterManager()
						.getAdapter(o, IProject.class);
				file = project.getFile(IMavenConstants.POM_FILE_NAME);
			}
			if (file != null) {
				return file;
			}
		}
		return null;
	}
}
