package com.vectorsf.jvoice.core.reconciliator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVModel;
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
				if (prj != null) {
					updatePackages(child, prj);
				} else {
					// el modelo tiene proyectos, pero no encuentra el solicitado. Es nuevo
					model.getProjects().add(JVoiceModelReconcilier.getInstance().createProject((IProject) res));
				}

			}
		}

	}

	public void updatePackages(IResourceDelta delta, JVProject prj) {
		if (delta != null) {
			CheckDeltaChange visitor = new CheckDeltaChange(prj, null);
			try {
				delta.accept(visitor);
			} catch (CoreException e) {
			}
		}
	}

}
