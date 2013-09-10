package com.vectorsf.jvoice.base.model.listener;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.CoreException;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVProject;

public class BaseModelResourceChangeListener implements IResourceChangeListener{
	
	@SuppressWarnings("unused")
	private JVModel model;
	private BaseModel base;
	
		@Override
		public void resourceChanged(IResourceChangeEvent event) {
			boolean existe = false;
			JVModel model = null;
			model = base.getModel();
			
			if (event.getDelta() == null) {
				return;
			}

			for (IResourceDelta child : event.getDelta().getAffectedChildren()) {

				IResource res = child.getResource();
				if (res instanceof IProject) {
					String name = res.getName();
					// El modelo est� vac�o y se est� creando un proyecto
					if (model.getProjects().isEmpty()) {
						model.getProjects().add(base.createProject((IProject) res));
						break;
					} else {
						for (Iterator<JVProject> it = model.getProjects().iterator(); it.hasNext();) {
							JVProject prj = it.next();
							if (name.equals(prj.getName())) {
								updatePackages(child, prj);
								existe = true;
							}
						}
						// el modelo tiene proyectos, pero no encuentra el solicitado. Es nuevo
						if (!existe) {
							model.getProjects().add(base.createProject((IProject) res));
						}
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
