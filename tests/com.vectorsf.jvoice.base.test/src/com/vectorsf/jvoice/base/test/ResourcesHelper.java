package com.vectorsf.jvoice.base.test;

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
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.osgi.framework.Bundle;

import com.vectorsf.jvoice.core.project.JVoiceApplicationConfigurator;
import com.vectorsf.jvoice.core.project.JVoiceProjectConfigurator;

public class ResourcesHelper {

	public static final String JV_PATH = "src/main/resources/jv";
	public static final String CONFIG_PATH = "src/main/config/properties";

	private ResourcesHelper() {
		super();
	}

	public static void safelyRetry(IWorkspaceRunnable iWorkspaceRunnable) throws CoreException {
		safelyRetry(iWorkspaceRunnable, null);
	}

	public static void safelyRetry(IWorkspaceRunnable iWorkspaceRunnable, ISchedulingRule rule) throws CoreException {
		int count = 0;
		boolean executed = false;
		CoreException lastException = null;
		while (count < 10 && !executed) {
			try {
				count++;
				executeWksRunnable(iWorkspaceRunnable, rule);
				executed = true;
			} catch (CoreException e) {
				lastException = e;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
			}
		}
		if (!executed) {
			throw lastException;
		}
	}

	public static void executeWksRunnable(IWorkspaceRunnable runnable) throws CoreException {
		ResourcesPlugin.getWorkspace().run(runnable, null);
	}

	public static void executeWksRunnable(IWorkspaceRunnable runnable, ISchedulingRule rule) throws CoreException {
		ResourcesPlugin.getWorkspace().run(runnable, rule, IWorkspace.AVOID_UPDATE, null);
	}

	public static IProject createProject(final String name) throws CoreException {
		return JVoiceProjectConfigurator.createProject(name, name, name);
	}
	
	public static IProject createApplicationProject(final String name) throws CoreException {
		return JVoiceApplicationConfigurator.createApplication(name, name, name);
	}

	public static IFolder createFolders(final IProject project, final String ruta) throws CoreException {
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

	public static IFile createFile(IProject project, String ruta, String contents) throws CoreException {
		byte[] bytes;
		try {
			bytes = contents.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new CoreException(new Status(IStatus.ERROR, "", e.getMessage(), e));
		}
		InputStream input = new ByteArrayInputStream(bytes);
		return createFile(project, ruta, input);
	}

	public static IFile createFile(final IProject project, final String ruta, final InputStream contents)
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

	public static void updateFile(final IFile file, String contents) throws CoreException {
		byte[] bytes;
		try {
			bytes = contents.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new CoreException(new Status(IStatus.ERROR, "", e.getMessage(), e));
		}
		InputStream input = new ByteArrayInputStream(bytes);
		updateFile(file, input);
	}

	public static void updateFile(final IFile file, final InputStream contents) throws CoreException {
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				file.setContents(contents, true, false, monitor);
			}

		}, file);
	}

	public static void deleteProject(final IProject project) throws CoreException {
		safelyRetry(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				project.delete(true, true, monitor);
			}
		});
	}
	
	public static void deleteApplicationProject(final IProject project) throws CoreException {
		safelyRetry(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				project.delete(true, true, monitor);
			}
		});
	}

	public static void deleteFolder(final IProject project, final String path) throws CoreException {
		safelyRetry(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IFolder folder = project.getFolder(path);
				folder.delete(true, monitor);
			}

		}, project);
	}

	public static void deleteFile(final IProject project, final String path) throws CoreException {
		safelyRetry(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IFile file = project.getFile(path);
				file.delete(true, monitor);
			}

		}, project);
	}

	private static void createRecursively(IFolder container, IProgressMonitor monitor) throws CoreException {
		IContainer parent = container.getParent();
		if (parent instanceof IFolder && !parent.exists()) {
			createRecursively((IFolder) parent, monitor);
		}

		if (!container.exists()) {
			container.create(true, true, monitor);
		}

	}

	public static void moveFile(final IFile file, final IPath fullPath) throws CoreException {
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				file.move(fullPath, true, monitor);
			}

		});
	}

	public static InputStream getInputStreamResource(Bundle bundle, String resourceName) throws IOException {
		return bundle.getResource("/resources/" + resourceName).openStream();
	}

}