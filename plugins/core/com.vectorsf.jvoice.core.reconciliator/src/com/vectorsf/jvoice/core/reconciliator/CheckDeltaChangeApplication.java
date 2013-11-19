package com.vectorsf.jvoice.core.reconciliator;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

import com.vectorsf.jvoice.model.base.JVApplication;

public class CheckDeltaChangeApplication implements IResourceDeltaVisitor {

	private JVApplication jvProject;

	public CheckDeltaChangeApplication(JVApplication prj) {
		jvProject = prj;
	}
	
	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if (delta.getKind() == IResourceDelta.REMOVED) {
			jvProject.getModel().getProjects().remove(jvProject);
		}
		
		return false;
	}

}
