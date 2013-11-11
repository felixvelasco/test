/**
 * 
 */
package com.vectorsf.jvoice.ui.diagram.properties.test;

import static org.junit.Assert.fail;

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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;

import com.vectorsf.jvoice.core.project.JVoiceProjectConfigurator;

/**
 * @author xIS16396
 *
 */
public class SWTBotHelper {
	protected String rutaProperties = "src/main/config/properties";

	protected static final Bundle bundle = Platform.getBundle("com.vectorsf.jvoice.ui.diagram.properties.test");

	private SWTBotHelper() {}
	
	public static void openView(SWTWorkbenchBot bot, String node, String view) {
		bot.menu("Window").menu("Show View").menu("Other...").click();
		SWTBotShell shell1 = bot.shell("Show View");
		shell1.activate();
		bot.tree().expandNode(node).select(view);
		bot.button("OK").click();

	}
	
	public static void openPerspective(SWTWorkbenchBot bot, String perspective) {
		bot.menu("Window").menu("Open Perspective").menu("Other...").click();
		SWTBotShell openPerspectiveShell = bot.shell("Open Perspective");
		openPerspectiveShell.activate();
		bot.table().select(perspective);
		bot.button("OK").click();

	}
	
	public static void closeWelcomeView(SWTWorkbenchBot bot) {
		try {
			bot.viewByTitle("Welcome").close();
		} catch (WidgetNotFoundException e) {
			// do nothing
		}
	}
	
	public static void executeWksRunnable(IWorkspaceRunnable runnable) throws CoreException {
		ResourcesPlugin.getWorkspace().run(runnable, null);
	}

	public static void executeWksRunnable(IWorkspaceRunnable runnable, ISchedulingRule rule) throws CoreException {
		ResourcesPlugin.getWorkspace().run(runnable, rule, IWorkspace.AVOID_UPDATE, null);
	}

	public static IProject createProject(final String name) throws CoreException {
		return JVoiceProjectConfigurator.createProject(name, name, name, "test module");
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
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				try{
				project.delete(true, true, monitor);
				}catch(Exception e){
					for (int i = 0; i < 10; i++){ 
						project.delete(true, true, monitor);
					}
				}
			}

		});
	}

	public static void deleteFolder(final IProject project, final String path) throws CoreException {
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IFolder folder = project.getFolder(path);
				folder.delete(true, monitor);
			}

		}, project);
	}

	public static void deleteFile(final IProject project, final String path) throws CoreException {
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IFile file = project.getFile(path);
				file.delete(true, monitor);
			}

		}, project);
	}

	public static void moveFile(final IFile file, final IPath fullPath) throws CoreException {
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				file.move(fullPath, true, monitor);
			}

		});
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

	public static InputStream getInputStreamResource(String resourceName) {
		try {
			return bundle.getResource("/resources/" + resourceName).openStream();
		} catch (IOException e) {
			fail(e.getMessage());
			return null;
		}
	}
	
	public static void openFile(final IFile file) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				IWorkbenchPage activePage = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(activePage, file);
				} catch (PartInitException e) {
					throw new RuntimeException(e);
				}
			}
		});
	}
	
	public static SWTBotGefEditor getGefEditor(SWTGefBot bot) {
		SWTBotEditor activeEditor = bot.activeEditor();
		String title = activeEditor.getTitle();
		SWTBotGefEditor ed = bot.gefEditor(title);
		return ed;
	}

}
