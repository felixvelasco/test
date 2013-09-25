package com.vectorsf.jvoice.core.reconciliator.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.osgi.framework.Bundle;

import com.vectorsf.jvoice.core.project.JVoiceProjectConfigurator;

import static org.junit.Assert.fail;

public class BaseModelResources {

	protected String ruta = "src/main/resources/jv";
	protected String rutaProperties = "src/main/config/properties";

	protected static final Bundle bundle = Platform.getBundle("com.vectorsf.jvoice.core.reconciliator");

	public BaseModelResources() {
		super();
	}

	protected void executeWksRunnable(IWorkspaceRunnable runnable) throws CoreException {
		ResourcesPlugin.getWorkspace().run(runnable, null);
	}

	protected void executeWksRunnable(IWorkspaceRunnable runnable, ISchedulingRule rule) throws CoreException {
		ResourcesPlugin.getWorkspace().run(runnable, rule, IWorkspace.AVOID_UPDATE, null);
	}

	protected IProject createProject(final String name) throws CoreException {
		return JVoiceProjectConfigurator.createProject(name, name, name);
	}

	protected IFolder createFolders(final IProject project, final String ruta) throws CoreException {
		final IFolder result[] = new IFolder[1];
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				result[0] = project.getFolder(ruta);
				IFolder folder = result[0];
				createRecursively(folder, monitor);
			}

		}, project);

		return result[0];
	}

	protected IFile createFile(IProject project, String ruta, String contents) throws CoreException {
		byte[] bytes;
		try {
			bytes = contents.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new CoreException(new Status(IStatus.ERROR, "", e.getMessage(), e));
		}
		InputStream input = new ByteArrayInputStream(bytes);
		return createFile(project, ruta, input);
	}

	protected IFile createFile(final IProject project, final String ruta, final InputStream contents)
			throws CoreException {
		final IFile result[] = new IFile[1];
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				result[0] = project.getFile(ruta);
				IContainer container = result[0].getParent();
				if (!container.exists() && container instanceof IFolder) {
					createRecursively((IFolder) container, monitor);
				}
				result[0].create(contents, true, monitor);
			}

		}, project);

		return result[0];
	}

	protected void updateFile(final IFile file, String contents) throws CoreException {
		byte[] bytes;
		try {
			bytes = contents.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new CoreException(new Status(IStatus.ERROR, "", e.getMessage(), e));
		}
		InputStream input = new ByteArrayInputStream(bytes);
		updateFile(file, input);
	}

	protected void updateFile(final IFile file, final InputStream contents) throws CoreException {
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				file.setContents(contents, true, false, monitor);
			}

		}, file);
	}

	protected void deleteProject(final IProject project) throws CoreException {
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				project.delete(true, true, monitor);
			}

		});
	}

	protected void deleteFolder(final IProject project, final String path) throws CoreException {
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IFolder folder = project.getFolder(path);
				folder.delete(true, monitor);
			}

		}, project);
	}

	protected void deleteFile(final IProject project, final String path) throws CoreException {
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IFile file = project.getFile(path);
				file.delete(true, monitor);
			}

		}, project);
	}

	private void createRecursively(IFolder container, IProgressMonitor monitor) throws CoreException {
		IContainer parent = container.getParent();
		if (parent instanceof IFolder && !parent.exists()) {
			createRecursively((IFolder) parent, monitor);
		}

		if (!container.exists()) {
			container.create(true, false, monitor);
		}

	}

	protected void moveFile(final IFile file, final IPath fullPath) throws CoreException {
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				file.move(fullPath, true, monitor);
			}

		});
	}

	protected InputStream getInputStreamResource(String resourceName) {
		try {
			return bundle.getResource("/resources/" + resourceName).openStream();
		} catch (IOException e) {
			fail(e.getMessage());
			return null;
		}
	}

}