package com.vectorsf.jvoice.ui.project.editor;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.parsley.resource.EmptyResourceInitializer;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVProject;

public class ProjectEditorEmptyResourceInitializer extends EmptyResourceInitializer {
	@Override
	public void initialize(Resource resource) {
		URI uri = resource.getURI();
		if (uri.fileExtension().equals("projectInformation")) {
			IPath path = new Path(uri.toPlatformString(true));
			JVProject project = BaseModel.getInstance().getModel().getProject(path.segment(0));
			JVProject newProject = EcoreUtil.copy(project);

			newProject.getConfiguration().clear();
			if (newProject instanceof JVModule) {
				((JVModule) newProject).getPackages().clear();
			}
			resource.getContents().add(newProject);

		}
		super.initialize(resource);
	}
}
