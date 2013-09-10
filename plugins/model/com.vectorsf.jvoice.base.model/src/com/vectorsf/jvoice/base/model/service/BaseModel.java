package com.vectorsf.jvoice.base.model.service;

import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.vectorsf.jvoice.base.model.listener.BaseModelResourceChangeListener;
import com.vectorsf.jvoice.base.model.listener.ResourceVisitor;
import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.Configuration;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.base.impl.JVBeanImpl;

public class BaseModel {

	private static BaseModel baseModel = new BaseModel();
	private String ruta = "src/main/resources/jv";
	private String rutaProperties = "src/main/config/properties";
	private IPath pkgPath = new Path("src/main/resources/jv");
	private JVModel model;

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

	public JVProject createProject(IProject project) {
		JVProject jvProject = BaseFactory.eINSTANCE.createJVProject();
		jvProject.setName(project.getName());
		jvProject.setDescription(project.getName());

		IFolder packageFolder = (IFolder) project.findMember(ruta);
		if (packageFolder != null) {
			try {
				packageFolder.accept(new ResourceVisitor(jvProject, this));
			} catch (CoreException e) {
			}
		}

		IFolder configurationsFolder = (IFolder) project.findMember(rutaProperties);
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

	public Configuration createConfigurationFromFile(IFile res) throws CoreException {
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

	public JVPackage createPackage(IFolder folder) throws CoreException {
		JVPackage jvPackage = BaseFactory.eINSTANCE.createJVPackage();
		IPath relativePath = folder.getProjectRelativePath().makeRelativeTo(pkgPath);
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

	public JVBean createBean(IFile res) {
		JVBean fake = new JVBeanImpl() {
		};
		fake.setName(res.getName());

		return fake;
	}	
}
