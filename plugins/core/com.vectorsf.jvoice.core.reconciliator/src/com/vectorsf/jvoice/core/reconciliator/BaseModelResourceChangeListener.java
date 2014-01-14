package com.vectorsf.jvoice.core.reconciliator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.core.project.JVoiceApplicationNature;
import com.vectorsf.jvoice.core.project.JVoiceModuleNature;
import com.vectorsf.jvoice.model.base.JVApplication;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVProject;

public class BaseModelResourceChangeListener implements IResourceChangeListener {

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		JVModel model = null;
		model = BaseModel.getInstance().getModel();

		if (event.getDelta() == null) {
			return;
		}

		for (IResourceDelta child : event.getDelta().getAffectedChildren()) {

			IResource res = child.getResource();
			if (res instanceof IProject) {
				String name = res.getName();

				JVProject prj = model.getProject(name);
				if (prj instanceof JVModule) {
					updatePackages(child, (JVModule) prj);
				} else if (prj instanceof JVApplication) {
					updateApplication(child, (JVApplication) prj);
				} else { // el modelo tiene proyectos, pero no encuentra el solicitado. Es nuevo
					try {
						IProject project = (IProject) res;
						if (project.exists() && project.isOpen()) {
							if (project.hasNature(JVoiceApplicationNature.NATURE_ID)) {
								model.getProjects().add(
										JVoiceModelReconcilier.getInstance().createApplication((IProject) res));
							} else if (project.hasNature(JVoiceModuleNature.NATURE_ID)) {
								model.getProjects().add(
										JVoiceModelReconcilier.getInstance().createProject((IProject) res));
							}
						}
					} catch (CoreException e) {
						// CoreException is only launched on closed or non-existing projects, and we are guarded against
						// both conditions
					}
				}
			}
		}
	}

	private void updateApplication(IResourceDelta child, JVApplication prj) {
		if (child != null) {
			CheckDeltaChangeApplication visitor = new CheckDeltaChangeApplication(prj);
			try {
				child.accept(visitor);
			} catch (CoreException e) {
			}
		}

	}

	public void updatePackages(IResourceDelta delta, JVModule prj) {
		if (delta != null) {
			CheckDeltaChange visitor = new CheckDeltaChange(prj, null);
			try {
				delta.accept(visitor);
			} catch (CoreException e) {
			}
		}
	}
}
