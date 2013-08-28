package com.vectorsf.jvoice.base.model.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

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
import org.eclipse.core.runtime.IPath;

import com.vectorsf.jvoice.base.BaseFactory;
import com.vectorsf.jvoice.base.Configuration;
import com.vectorsf.jvoice.base.JVBean;
import com.vectorsf.jvoice.base.JVModel;
import com.vectorsf.jvoice.base.JVPackage;
import com.vectorsf.jvoice.base.JVProject;
import com.vectorsf.jvoice.base.impl.JVBeanImpl;

public class BaseModel {

	private static BaseModel baseModel = new BaseModel();
	public JVModel model;

	public static BaseModel getInstance() {
		return baseModel;
	}

	public JVModel getModel() {
		return model;
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

		IFolder packageFolder = (IFolder) project.findMember("src/main/resources/jv");
		if (packageFolder != null) {
			try {
				packageFolder.accept(new ResourceVisitor(jvProject, packageFolder));
			} catch (CoreException e) {
			}
		}

		IFolder configurationsFolder = (IFolder) project.findMember("src/main/config/properties");
		if (configurationsFolder != null) {
			try {
				for (IResource res : configurationsFolder.members()) {
					if (res.getType() == IResource.FILE && res.getFileExtension().equalsIgnoreCase(".properties")) {
						jvProject.getConfiguration().add(createConfigurationFromFile((IFile) res));
					}
				}
			} catch (CoreException e) {
			}
		}

		return jvProject;
	}

	private Configuration createConfigurationFromFile(IFile res) throws CoreException {
		Configuration configuration = BaseFactory.eINSTANCE.createConfiguration();
		configuration.setName(res.getName().substring(0, res.getName().lastIndexOf('.')));
		Properties pr = new Properties();
		try {
			pr.load(res.getContents());
		} catch (IOException e) {
			throw new CoreException(null);
		}

		for (String name : pr.stringPropertyNames()) {
			configuration.getParameters().put(name, pr.getProperty(name));
		}

		return configuration;
	}

	private JVPackage createPackage(IFolder folder, IPath packagePath) throws CoreException {
		JVPackage jvPackage = BaseFactory.eINSTANCE.createJVPackage();
		IPath relativePath = folder.getProjectRelativePath().makeRelativeTo(packagePath);
		jvPackage.setName(relativePath.toString().replace("/", "."));
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
		private IFolder packageFolder;
		private IPath packagePath;

		public ResourceVisitor(JVProject jvProject, IFolder packageFolder) {
			this.project = jvProject;
			this.packageFolder = packageFolder;
			packagePath = packageFolder.getProjectRelativePath();
		}

		@Override
		public boolean visit(IResource resource) throws CoreException {
			if (resource instanceof IFolder && !resource.getProjectRelativePath().equals(packagePath)) {
				project.getPackages().add(createPackage((IFolder) resource, packagePath));
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
