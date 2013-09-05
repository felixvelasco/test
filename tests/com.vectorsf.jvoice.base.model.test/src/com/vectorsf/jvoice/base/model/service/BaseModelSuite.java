package com.vectorsf.jvoice.base.model.service;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

public class BaseModelSuite {

	protected String ruta = "src/main/resources/jv";
	protected String rutaProperties = "src/main/config/properties";

	public BaseModelSuite() {
		super();
	}

	protected IProject createProject(final String name) throws CoreException {
		final IProject result[] = new IProject[1];
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				result[0] = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
				result[0].create(monitor);
				result[0].open(monitor);

			}
		}, null);

		return result[0];
	}

	protected IFolder createFolders(final IProject project, final String ruta) throws CoreException {
		final IFolder result[] = new IFolder[1];
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				result[0] = project.getFolder(new Path(ruta));
				IFolder folder = result[0];
				createRecursively(folder, monitor);
			}

			private void createRecursively(IFolder container, IProgressMonitor monitor) throws CoreException {
				IContainer parent = container.getParent();
				if (parent instanceof IFolder && !parent.exists()) {
					createRecursively((IFolder) parent, monitor);
				}

				container.create(true, false, monitor);

			}
		}, null);

		return result[0];
	}

	protected void deleteProject(final IProject project) throws CoreException {
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				project.delete(true, true, monitor);
			}

		}, null);
	}

	protected void deleteFolder(final IProject project, final String path) throws CoreException {
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IFolder folder = project.getFolder(new Path(path));
				folder.delete(true, monitor);
			}

		}, null);

	}

}