package com.vectorsf.jvoice.core.reconciliator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

import com.vectorsf.jvoice.core.project.JVoiceApplicationNature;
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
		if (delta.getKind() == IResourceDelta.CHANGED
				&& ((delta.getFlags() & IResourceDelta.DESCRIPTION) != 0 || (delta.getFlags() & IResourceDelta.OPEN) != 0)) {
			IProject project = (IProject) resource;
			if (!project.isOpen() || !project.hasNature(JVoiceApplicationNature.NATURE_ID)) {
				jvProject.getModel().getProjects().remove(jvProject);
				return false;
			}
		}
		return false;
	}

}
