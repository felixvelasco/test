package com.vectorsf.jvoice.base.model.listener;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVProject;

public class ResourceVisitor implements IResourceVisitor {
	
	private JVProject project;
	private String ruta = "src/main/resources/jv";
	private String rutaProperties = "src/main/config/properties";
	private BaseModel base;

	public ResourceVisitor(JVProject jvProject, BaseModel base) {
		this.project = jvProject;
		this.base = base;
	}

	@Override
	public boolean visit(IResource resource) throws CoreException {
		if (resource instanceof IFolder && resource.getProjectRelativePath() != null
				&& !resource.getProjectRelativePath().toString().trim().equalsIgnoreCase(ruta)
				&& !resource.getProjectRelativePath().toString().trim().equalsIgnoreCase(rutaProperties)) {
			project.getPackages().add(base.createPackage((IFolder) resource));
		}
		return true;
	}

}
