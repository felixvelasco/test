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
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

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
	private IPath configPath = new Path("src/main/config/properties");
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

	private JVProject createProject(IProject project) {
		JVProject jvProject = BaseFactory.eINSTANCE.createJVProject();
		jvProject.setName(project.getName());
		jvProject.setDescription(project.getName());

		IFolder packageFolder = (IFolder) project.findMember(ruta);
		if (packageFolder != null) {
			try {
				packageFolder.accept(new ResourceVisitor(jvProject));
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

	private JVPackage createPackage(IFolder folder) throws CoreException {
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
			if (resource instanceof IFolder && resource.getProjectRelativePath() != null
					&& !resource.getProjectRelativePath().toString().trim().equalsIgnoreCase(ruta)
					&& !resource.getProjectRelativePath().toString().trim().equalsIgnoreCase(rutaProperties)) {
				project.getPackages().add(createPackage((IFolder) resource));
			}
			return true;
		}

	}

	private class BaseModelResourceChangeListener implements IResourceChangeListener {

		@Override
		public void resourceChanged(IResourceChangeEvent event) {
			boolean existe = false;

			if (event.getDelta() == null) {
				return;
			}

			for (IResourceDelta child : event.getDelta().getAffectedChildren()) {

				IResource res = child.getResource();
				if (res instanceof IProject) {
					String name = res.getName();
					// El modelo est� vac�o y se est� creando un proyecto
					if (model.getProjects().isEmpty()) {
						model.getProjects().add(createProject((IProject) res));
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
							model.getProjects().add(createProject((IProject) res));
						}
					}

				}
			}

		}
	}

	private void updatePackages(IResourceDelta delta, JVProject prj) {
		if (delta != null) {
			CheckDeltaChange visitor = new CheckDeltaChange(prj, null);
			try {
				delta.accept(visitor);
			} catch (CoreException e) {
			}

		}

	}

	private class CheckDeltaChange implements IResourceDeltaVisitor {

		private JVProject jvProject;
		private JVPackage currentPackage;

		public CheckDeltaChange(JVProject prj, IFolder packageFolder) {
			jvProject = prj;
			currentPackage = null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
		 */
		@Override
		public boolean visit(IResourceDelta delta) throws CoreException {
			boolean existePaquete = false;
			IResource resource = delta.getResource();
			switch (resource.getType()) {
			case IResource.FOLDER:
				// SI es un paquete de configuraci�n no debe aparecer en la lista
				if (isValidFolder(resource) && !isConfigurantionFolder(resource)) {
					IPath relPath = getRelativePath(resource);
					// verificamos si el proyecto tiene paquetes
					if (jvProject.getPackages().isEmpty()) {
						// es un proyecto vac�o, hay que a�adirle el paquete
						jvProject.getPackages().add(createPackage((IFolder) resource));
						return false;
					}
					for (JVPackage pkg : jvProject.getPackages()) {
						if (pkg.getName().equals(relPath.toString().replace("/", "."))) {
							existePaquete = true;
							currentPackage = pkg;
							if (isInterestingDelta(delta)) {

								verificarBorrado(delta.getKind(), resource);
							}
						}
					}
					// hemos recorrido los paquete del proyecto pero no encuentra el actual, es nuevo y hay que a�adirlo
					if (!existePaquete) {
						jvProject.getPackages().add(createPackage((IFolder) resource));
						return false;
					}
				}

				return true;

			case IResource.FILE:
				boolean yaExiste = false;

				if (isInterestingDelta(delta) && currentPackage != null) {

					// el paquete est� vac�o, as� que hay que a�adir el bean
					if (currentPackage.getBeans().isEmpty()) {
						currentPackage.getBeans().add(createBean((IFile) resource));
						return false;
					}
					// si es un evento de adici�n al paquete, por culpa del bug de eclipse que lanza el delta 2 veces
					// tenemos que comprobar que lo hemos agregado ya antes, para no duplicarlo
					if (delta.getKind() == IResourceDelta.ADDED) {
						for (JVBean bean : currentPackage.getBeans()) {
							if (bean.getName().equals(resource.getName())) {
								yaExiste = true;
								break;
							}
						}
						if (!yaExiste) {
							currentPackage.getBeans().add(createBean((IFile) resource));
							return false;
						} else {
							return true;
						}
					} else {
						// se busca el elemento en el paquete y se elimina
						verificarBorrado(delta.getKind(), resource);
					}
					// Se trata de un archivo de configuraci�n
				} else if (isInterestingDelta(delta) && resource.getFileExtension().equalsIgnoreCase("properties")) {
					// si es un evento de adici�n al paquete, por culpa del bug de eclipse que lanza el delta 2 veces
					// tenemos que comprobar que lo hemos agregado ya antes, para no duplicarlo
					if (delta.getKind() == IResourceDelta.ADDED) {
						for (Configuration config : jvProject.getConfiguration()) {
							String name = resource.getName().substring(0, resource.getName().lastIndexOf('.'));
							if (config.getName().equals(name)) {
								yaExiste = true;
								break;
							}
						}
						if (!yaExiste) {
							jvProject.getConfiguration().add(createConfigurationFromFile((IFile) resource));
							return false;
						} else {
							return true;
						}
					} else if (delta.getKind() == IResourceDelta.REMOVED) {
						for (Configuration config : jvProject.getConfiguration()) {
							String name = resource.getName().substring(0, resource.getName().lastIndexOf('.'));
							if (config.getName().equals(name)) {
								jvProject.getConfiguration().remove(config);
								break;
							}
						}
					}
				}

				return false;
			case IResource.PROJECT:
				return verificarBorrado(delta.getKind(), resource);
			}

			return false;
		}

		private boolean isInterestingDelta(IResourceDelta delta) {
			return delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.REMOVED
					|| delta.getKind() == IResourceDelta.CHANGED && (delta.getFlags() & IResourceDelta.CONTENT) != 0;
		}

		private boolean verificarBorrado(int estado, IResource recurso) throws CoreException {
			if (estado == IResourceDelta.REMOVED) {
				if (recurso instanceof IFile) {
					for (JVBean bean : currentPackage.getBeans()) {
						if (bean.getName().equals(recurso.getName())) {
							currentPackage.getBeans().remove(bean);
							break;
						}
					}
				} else if (recurso instanceof IFolder) {
					for (JVPackage paquete : jvProject.getPackages()) {
						if (paquete.getName().equals(recurso.getName())) {
							jvProject.getPackages().remove(paquete);
							break;
						}
					}
				} else if (recurso instanceof IProject) {
					for (JVProject proyecto : model.getProjects()) {
						if (proyecto.getName().equals(recurso.getName())) {
							model.getProjects().remove(proyecto);
							break;
						}
					}
				}

			}
			return true;
		}

		private boolean isValidFolder(IResource resource) {
			if (pkgPath.isPrefixOf(resource.getProjectRelativePath())
					&& !pkgPath.equals(resource.getProjectRelativePath())) {
				return true;
			} else {
				return false;
			}
		}

		private IPath getRelativePath(IResource resource) {
			if (pkgPath.isPrefixOf(resource.getProjectRelativePath())
					&& !pkgPath.equals(resource.getProjectRelativePath())) {
				return resource.getProjectRelativePath().makeRelativeTo(pkgPath);
			} else {
				return null;
			}
		}

		private boolean isConfigurantionFolder(IResource resource) {
			if (configPath.isPrefixOf(resource.getProjectRelativePath())
					&& configPath.equals(resource.getProjectRelativePath())) {
				return true;
			}
			return false;
		}
	}
}
