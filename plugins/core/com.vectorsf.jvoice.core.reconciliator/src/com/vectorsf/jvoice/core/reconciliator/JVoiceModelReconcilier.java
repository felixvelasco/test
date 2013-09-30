package com.vectorsf.jvoice.core.reconciliator;

import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.core.factory.JVBeanFactory;
import com.vectorsf.jvoice.core.factory.JVBeanFactoryManager;
import com.vectorsf.jvoice.core.project.JVoiceProjectNature;
import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.Configuration;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;

public class JVoiceModelReconcilier {

	private static JVoiceModelReconcilier instance = new JVoiceModelReconcilier();
	private static final Path PACKAGES_PATH = new Path(BaseModel.JV_PATH);

	private BaseModel baseModel;

	private JVoiceModelReconcilier() {

	}

	public static JVoiceModelReconcilier getInstance() {
		return instance;
	}

	public void create(BaseModel baseModel) {
		this.baseModel = baseModel;

		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		for (IProject project : workspace.getRoot().getProjects()) {
			try {
				if (project.isOpen() && project.hasNature(JVoiceProjectNature.NATURE_ID)) {
					baseModel.getModel().getProjects().add(createProject(project));
				}
			} catch (CoreException e) {
				// CoreException is only launched on closed or non-existing projects, and we are guarded against both
				// conditions
			}
		}

		workspace.addResourceChangeListener(new BaseModelResourceChangeListener());
	}

	public JVProject createProject(IProject project) {
		JVProject jvProject = BaseFactory.eINSTANCE.createJVProject();
		jvProject.setName(project.getName());
		jvProject.setDescription(project.getName());

		IFolder packageFolder = (IFolder) project.findMember(BaseModel.JV_PATH);
		if (packageFolder != null) {
			try {
				packageFolder.accept(new ResourceVisitor(jvProject, baseModel));
			} catch (CoreException e) {
			}
		}

		IFolder configurationsFolder = (IFolder) project.findMember(BaseModel.PROPERTIES_PATH);
		if (configurationsFolder != null) {
			try {
				for (IResource res : configurationsFolder.members()) {
					if (res.getType() == IResource.FILE && res.getFileExtension().equalsIgnoreCase("properties")) {
						jvProject.getConfiguration().add(createConfigurationFromFile((IFile) res));
					}
				}
			} catch (CoreException e) {
				System.out.print(e);
			}
		}

		return jvProject;
	}

	public Configuration createConfigurationFromFile(IFile file) throws CoreException {
		Configuration configuration = BaseFactory.eINSTANCE.createConfiguration();
		configuration.setName(file.getName().substring(0, file.getName().lastIndexOf('.')));

		reloadConfigurationProperties(file, configuration);

		return configuration;
	}

	public void reloadConfigurationProperties(IFile file, Configuration configuration) throws CoreException {
		configuration.getParameters().clear();
		Properties pr = new Properties();
		try {
			pr.load(file.getContents());
		} catch (IOException e) {
			throw new CoreException(null);
		}

		for (String name : pr.stringPropertyNames()) {
			configuration.getParameters().put(name, pr.getProperty(name));
		}
	}

	public JVPackage createPackage(IFolder folder) throws CoreException {
		JVPackage jvPackage = BaseFactory.eINSTANCE.createJVPackage();
		IPath relativePath = folder.getProjectRelativePath().makeRelativeTo(PACKAGES_PATH);
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

	public JVBean createBean(IFile file) {
		JVBeanFactory factory = JVBeanFactoryManager.getInstance().getFactory(file);
		return factory != null ? factory.loadBeanFromFile(file) : null;
	}

	public String getBeanName(IFile file) {
		JVBeanFactory factory = JVBeanFactoryManager.getInstance().getFactory(file);
		return factory != null ? factory.getNameFromFile(file) : null;
	}

	public class ResourceVisitor implements IResourceVisitor {

		private JVProject project;

		public ResourceVisitor(JVProject jvProject, BaseModel base) {
			this.project = jvProject;
		}

		@Override
		public boolean visit(IResource resource) throws CoreException {
			if (resource instanceof IFolder && !resource.getProjectRelativePath().toString().equals(BaseModel.JV_PATH)) {
				project.getPackages().add(createPackage((IFolder) resource));
			}
			return true;
		}

	}
}
