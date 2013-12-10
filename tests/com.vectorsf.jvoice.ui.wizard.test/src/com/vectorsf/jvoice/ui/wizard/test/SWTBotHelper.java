package com.vectorsf.jvoice.ui.wizard.test;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

import com.vectorsf.jvoice.core.project.JVoiceProjectConfigurator;

public class SWTBotHelper {
	public static void closeWelcomeView(SWTWorkbenchBot bot) {
		try {
			bot.viewByTitle("Welcome").close();
		} catch (WidgetNotFoundException e) {
			// do nothing
		}
	}

	public static void openView(SWTWorkbenchBot bot, String node, String view) {
		bot.menu("Window").menu("Show View").menu("Other...").click();
		SWTBotShell shell1 = bot.shell("Show View");
		shell1.activate();
		bot.tree().expandNode(node).select(view);
		bot.button("OK").click();

	}

	public static void deleteProject(final IProject project) throws CoreException {
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				try {
					project.delete(true, true, monitor);
				} catch (Exception e) {
					for (int i = 0; i < 10; i++) {
						project.delete(true, true, monitor);
					}
				}
			}

		});
	}

	public static void executeWksRunnable(IWorkspaceRunnable runnable) throws CoreException {
		ResourcesPlugin.getWorkspace().run(runnable, null);
	}

	public static void openPerspective(SWTWorkbenchBot bot, String perspective) {
		bot.menu("Window").menu("Open Perspective").menu("Other...").click();
		SWTBotShell openPerspectiveShell = bot.shell("Open Perspective");
		openPerspectiveShell.activate();
		bot.table().select(perspective);
		bot.button("OK").click();

	}

	public static IProject createProject(final String name) throws CoreException {
		return JVoiceProjectConfigurator.createProject(name, name, name, "test module", new NullProgressMonitor());
	}

	public static SWTBotGefEditor getGefEditor(SWTBot dialogBot) {
		SWTBotEditor activeEditor = ((SWTWorkbenchBot) dialogBot).activeEditor();
		String title = activeEditor.getTitle();
		SWTBotGefEditor ed = ((SWTGefBot) dialogBot).gefEditor(title);
		return ed;
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

	public static void executeWksRunnable(IWorkspaceRunnable runnable, ISchedulingRule rule) throws CoreException {
		ResourcesPlugin.getWorkspace().run(runnable, rule, IWorkspace.AVOID_UPDATE, null);
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

}
