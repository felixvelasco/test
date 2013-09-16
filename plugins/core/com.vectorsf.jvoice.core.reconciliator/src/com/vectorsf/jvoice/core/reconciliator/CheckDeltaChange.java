package com.vectorsf.jvoice.core.reconciliator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.Configuration;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;

public class CheckDeltaChange implements IResourceDeltaVisitor {

	private final static IPath pkgPath = new Path(BaseModel.JV_PATH);
	private final static IPath configPath = new Path(BaseModel.PROPERTIES_PATH);

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
		IResource resource = delta.getResource();
		switch (resource.getType()) {
		case IResource.FOLDER:
			// SI es un paquete de configuración no debe aparecer en la lista
			if (isValidFolder(resource) && !isConfigurationFolder(resource)) {
				IPath relPath = getRelativePath(resource);
				JVPackage pkg = jvProject.getPackage(relPath.toString().replace("/", "."));

				if (pkg != null) {
					currentPackage = pkg;
					if (delta.getKind() == IResourceDelta.REMOVED) {
						delete(resource);
						return false;
					}
				} else {
					currentPackage = JVoiceModelReconcilier.getInstance().createPackage((IFolder) resource);
					jvProject.getPackages().add(currentPackage);
				}
			}
			return true;
		case IResource.FILE:
			if (isInterestingDelta(delta)) {
				if (currentPackage != null) {
					JVBean bean = currentPackage.getBean(getBeanName((IFile) resource));
					if (delta.getKind() == IResourceDelta.ADDED) {
						if (bean == null) {
							currentPackage.getBeans().add(
									JVoiceModelReconcilier.getInstance().createBean((IFile) resource));
						}

					} else if (delta.getKind() == IResourceDelta.CHANGED) {
						reloadBean(bean, (IFile) resource);

					} else if (delta.getKind() == IResourceDelta.REMOVED) {
						// se busca el elemento en el paquete y se elimina
						delete(resource);
					}
					// Se trata de un archivo de configuración
				} else if (resource.getFileExtension().equalsIgnoreCase("properties")) {
					String name = resource.getName().substring(0, resource.getName().lastIndexOf('.'));
					// si es un evento de adición al paquete, por culpa del bug de eclipse que lanza el delta 2 veces
					// tenemos que comprobar que lo hemos agregado ya antes, para no duplicarlo
					if (delta.getKind() == IResourceDelta.ADDED) {
						Configuration config = jvProject.getConfiguration(name);
						if (config == null) {
							jvProject.getConfiguration().add(
									JVoiceModelReconcilier.getInstance().createConfigurationFromFile((IFile) resource));
						}

					} else if (delta.getKind() == IResourceDelta.REMOVED) {
						jvProject.getConfiguration().remove(jvProject.getConfiguration(name));

					} else if (delta.getKind() == IResourceDelta.CHANGED) {
						Configuration config = jvProject.getConfiguration(name);
						JVoiceModelReconcilier.getInstance().reloadConfigurationProperties((IFile) resource, config);
					}
				}
			}
			return false;
		case IResource.PROJECT:
			if (delta.getKind() == IResourceDelta.REMOVED) {
				delete(resource);
				return false;
			}
		}

		return true;
	}

	private boolean isInterestingDelta(IResourceDelta delta) {
		return delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.REMOVED
				|| delta.getKind() == IResourceDelta.CHANGED && (delta.getFlags() & IResourceDelta.CONTENT) != 0;
	}

	private void delete(IResource resource) throws CoreException {
		if (resource instanceof IFile) {
			currentPackage.getBeans().remove(currentPackage.getBean(getBeanName((IFile) resource)));

		} else if (resource instanceof IFolder) {
			jvProject.getPackages().remove(jvProject.getPackage(resource.getName()));

		} else if (resource instanceof IProject) {
			JVModel model = BaseModel.getInstance().getModel();
			model.getProjects().remove(model.getProject(resource.getName()));
		}
	}

	private String getBeanName(IFile file) {
		// TODO: Enganchar punto de extensión ¿Llevar al reconciliador?
		return file.getName();
	}

	private void reloadBean(JVBean bean, IFile resource) {
		// TODO: Enganchar punto de extensión ¿Llevar al reconciliador?
	}

	private boolean isValidFolder(IResource resource) {
		if (pkgPath.isPrefixOf(resource.getProjectRelativePath()) && !pkgPath.equals(resource.getProjectRelativePath())) {
			return true;
		} else {
			return false;
		}
	}

	private IPath getRelativePath(IResource resource) {
		if (pkgPath.isPrefixOf(resource.getProjectRelativePath()) && !pkgPath.equals(resource.getProjectRelativePath())) {
			return resource.getProjectRelativePath().makeRelativeTo(pkgPath);
		} else {
			return null;
		}
	}

	private boolean isConfigurationFolder(IResource resource) {
		if (configPath.isPrefixOf(resource.getProjectRelativePath())
				&& configPath.equals(resource.getProjectRelativePath())) {
			return true;
		}
		return false;
	}
}
