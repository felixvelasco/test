package com.vectorsf.jvoice.core.reconciliator;

import java.io.IOException;
import java.io.InputStream;
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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.core.factory.JVBeanFactory;
import com.vectorsf.jvoice.core.factory.JVBeanFactoryManager;
import com.vectorsf.jvoice.core.project.JVoiceApplicationNature;
import com.vectorsf.jvoice.core.project.JVoiceModuleNature;
import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.Configuration;
import com.vectorsf.jvoice.model.base.JVApplication;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModule;
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
				if (project.isOpen() && project.hasNature(JVoiceApplicationNature.NATURE_ID)) {
					baseModel.getModel().getProjects().add(createApplication(project));
				} else if (project.isOpen() && project.hasNature(JVoiceModuleNature.NATURE_ID)) {
					baseModel.getModel().getProjects().add(createProject(project));
				}
			} catch (CoreException e) {
				// CoreException is only launched on closed or non-existing projects, and we are guarded against both
				// conditions
			}
		}

		workspace.addResourceChangeListener(new BaseModelResourceChangeListener());
		//Nuevo listener para modificar el POM e incluir o eliminar wsdl
		workspace.addResourceChangeListener(new PomWsdlsChangeListener());
		//Listener que a�ade/elimina en el POM de la app la dependencia del legacy logger
		workspace.addResourceChangeListener(new LegacyLoggerChangeListener());
		
	}

	public JVProject createProject(IProject project) {

		ResourceSet rSet = baseModel.getResourceSet();
		URI resourceURI = URI.createPlatformResourceURI(
				project.getFile(".projectInformation").getFullPath().toString(), true).appendFragment("/0");
		JVProject jvProject = null;
		try {
			jvProject = (JVProject) rSet.getEObject(resourceURI, true);
		} catch (RuntimeException e) {
			jvProject = BaseFactory.eINSTANCE.createJVModule();
			jvProject.setName(project.getName());
			jvProject.setDescription(project.getName());

			if (jvProject instanceof JVModule) {
				JVModule module = (JVModule) jvProject;
				addPackages(project, module, baseModel.getResourceSet());
				module.setComponentsPackage(JVoiceModuleNature.getDefaultComponentsPackageName(module));
			}

			addConfiguration(project, jvProject);
		}

		return jvProject;
	}

	// Este metodo no se esta usando.
	public JVApplication createApplication(IProject project) {
		ResourceSet rSet = baseModel.getResourceSet();
		URI resourceURI = URI.createPlatformResourceURI(
				project.getFile(".projectInformation").getFullPath().toString(), true).appendFragment("/0");
		JVApplication application = null;
		try {
			application = (JVApplication) rSet.getEObject(resourceURI, true);
		} catch (RuntimeException e) {
			application = BaseFactory.eINSTANCE.createJVApplication();
			application.setName(project.getName());
			application.setDescription(project.getName());
			addConfiguration(project, application);
		}

		return application;
	}

	public void addPackages(IProject project, JVModule jvModule, ResourceSet resourceSet) {
		IFolder packageFolder = (IFolder) project.findMember(BaseModel.JV_PATH);
		if (packageFolder != null) {
			try {
				packageFolder.accept(new ResourceVisitor(jvModule, resourceSet));
			} catch (CoreException e) {
			}
		}
	}

	public void addConfiguration(IProject project, JVProject jvProject) {
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
		try (InputStream contents = file.getContents()) {
			pr.load(contents);
		} catch (IOException e) {
			throw new CoreException(null);
		}

		for (String name : pr.stringPropertyNames()) {
			configuration.getParameters().put(name, pr.getProperty(name));
		}
	}

	public JVPackage createPackage(IFolder folder, ResourceSet resourceSet) throws CoreException {
		JVPackage jvPackage = BaseFactory.eINSTANCE.createJVPackage();
		IPath relativePath = folder.getProjectRelativePath().makeRelativeTo(PACKAGES_PATH);
		jvPackage.setName(relativePath.toString().replace("/", "."));
		jvPackage.setDescription(folder.getName());

		for (IResource res : folder.members()) {
			if (res instanceof IFile) {
				JVBean bean = createBean((IFile) res, resourceSet);
				if (bean != null) {
					jvPackage.getBeans().add(bean);
				}
			}
		}

		return jvPackage;
	}

	public JVBean createBean(IFile file, ResourceSet resourceSet) {
		JVBeanFactory factory = JVBeanFactoryManager.getInstance().getFactory(file.getFileExtension());
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		return factory != null ? factory.loadBeanFromFile(resourceSet, uri) : null;
	}

	public JVBean createBean(URI uri, ResourceSet resourceSet) {
		JVBeanFactory factory = JVBeanFactoryManager.getInstance().getFactory(uri.fileExtension());
		return factory != null ? factory.loadBeanFromFile(resourceSet, uri) : null;
	}

	public String getBeanName(IFile file) {
		JVBeanFactory factory = JVBeanFactoryManager.getInstance().getFactory(file.getFileExtension());
		return factory != null ? factory.getNameFromFile(file) : null;
	}

	public class ResourceVisitor implements IResourceVisitor {

		private JVModule project;
		private ResourceSet resourceSet;

		public ResourceVisitor(JVModule jvProject, ResourceSet resourceSet) {
			this.project = jvProject;
			this.resourceSet = resourceSet;
		}

		@Override
		public boolean visit(IResource resource) throws CoreException {
			if (resource instanceof IFolder && !resource.getProjectRelativePath().toString().equals(BaseModel.JV_PATH)
					&& !((IFolder) resource).getName().endsWith("resources")) {
				project.getPackages().add(createPackage((IFolder) resource, resourceSet));
			}
			return true;
		}

	}
}
