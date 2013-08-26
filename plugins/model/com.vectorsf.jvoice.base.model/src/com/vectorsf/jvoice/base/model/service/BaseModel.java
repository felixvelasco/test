package com.vectorsf.jvoice.base.model.service;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import com.vectorsf.jvoice.base.BaseFactory;
import com.vectorsf.jvoice.base.JVBean;
import com.vectorsf.jvoice.base.JVModel;
import com.vectorsf.jvoice.base.JVPackage;
import com.vectorsf.jvoice.base.JVProject;
import com.vectorsf.jvoice.base.impl.JVBeanImpl;

public class BaseModel {

	private static BaseModel baseModel = new BaseModel();
	private JVModel model;

	public static BaseModel getInstance() {
		return baseModel;
	}

	private BaseModel() {
		model = BaseFactory.eINSTANCE.createJVModel();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		for (IProject project : workspace.getRoot().getProjects()) {
			model.getProjects().add(createProject(project));
		}
		workspace.addResourceChangeListener(new BaseModelResourceChangeListener());
	}

	private JVProject createProject(IProject project) {
		JVProject jvProject = BaseFactory.eINSTANCE.createJVProject();
		jvProject.setName(project.getName());
		jvProject.setDescription(project.getName());

		IFolder packs = (IFolder) project.findMember("src/main/resources/jv");
		if (packs != null) {
			try {
				packs.accept(new ResourceVisitor(jvProject));
			} catch (CoreException e) {
			}
		}

		return jvProject;
	}

	private JVPackage createPackage(IFolder folder) throws CoreException {
		JVPackage jvPackage = BaseFactory.eINSTANCE.createJVPackage();
		jvPackage.setName(folder.getName());
		jvPackage.setDescription(folder.getName());

		for (IResource res : folder.members()) {
			if (res instanceof IFile) {
				JVBean bean = createBean((IFile) res);
				if (bean != null) {
					jvPackage.getBeans().add(bean);
				}
			}
		}

		return jvPackage;
	}

	private JVBean createBean(IFile res) {
		JVBean fake = new JVBeanImpl() {
		};
		fake.setName(res.getName());

		return fake;
	}

	public class ResourceVisitor implements IResourceVisitor {

		private JVProject project;

		public ResourceVisitor(JVProject jvProject) {
			this.project = jvProject;
		}

		@Override
		public boolean visit(IResource resource) throws CoreException {
			if (resource instanceof IFolder) {
				project.getPackages().add(createPackage((IFolder) resource));
			}
			return true;
		}

	}

	private class BaseModelResourceChangeListener implements IResourceChangeListener {

		@Override
		public void resourceChanged(IResourceChangeEvent event) {
			if (event.getDelta() == null) {
				return;
			}

			// TODO: Optimize, this is refreshing too often
			for (IResourceDelta child : event.getDelta().getAffectedChildren()) {
				IResource res = child.getResource();
				if (res instanceof IProject) {
					String name = res.getName();
					for (Iterator<JVProject> it = model.getProjects().iterator(); it.hasNext();) {
						JVProject prj = it.next();
						if (name.equals(prj.getName())) {
							it.remove();
							break;
						}
					}

					model.getProjects().add(createProject((IProject) res));
				}
			}
		}
	}
}
