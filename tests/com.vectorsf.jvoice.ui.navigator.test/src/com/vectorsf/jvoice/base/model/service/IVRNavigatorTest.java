/**
 * 
 */
package com.vectorsf.jvoice.base.model.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.m2e.core.internal.builder.BuildDebugHook;
import org.eclipse.m2e.core.internal.builder.MavenBuilder;
import org.eclipse.m2e.core.project.IMavenProjectFacade;
import org.eclipse.m2e.core.project.configurator.AbstractBuildParticipant;
import org.eclipse.m2e.core.project.configurator.MojoExecutionKey;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.PlatformUI;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osgi.framework.Bundle;

import com.vectorsf.jvoice.base.test.SWTBotHelper;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import static com.vectorsf.jvoice.base.test.ResourcesHelper.createApplicationProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFolders;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteApplicationProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteFolder;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.getInputStreamResource;

/**
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
@Ignore
public class IVRNavigatorTest {

	/*
	 * Clase para que sepamos que se han terminado de ejecutar todos los procesos de Maven y asi poder hacer el borrado
	 * de los proyectos creados.
	 */
	@SuppressWarnings("restriction")
	public static class MyHook implements BuildDebugHook {

		public AtomicInteger count = new AtomicInteger(0);

		@Override
		public void buildStart(IMavenProjectFacade projectFacade, int kind, Map<String, String> args,
				Map<MojoExecutionKey, List<AbstractBuildParticipant>> participants, IResourceDelta delta,
				IProgressMonitor monitor) {

			for (List<AbstractBuildParticipant> list : participants.values()) {
				// System.err.println("Subimos a " + count.addAndGet(list.size()));
			}
		}

		@Override
		public void buildParticipant(IMavenProjectFacade projectFacade, MojoExecutionKey mojoExecutionKey,
				AbstractBuildParticipant participant, Set<File> files, IProgressMonitor monitor) {
			synchronized (this) {
				int value = count.decrementAndGet();
				// System.out.println("Bajamos a " + value);
				if (value == 0) {
					notifyAll();
				}
			}
		}
	}

	private static final int SMALL_SLEEP = 300;
	private static final int MEDIUM_SLEEP = 2000;
	private static final String NAVIGATOR_ID = "com.vectorsf.jvoice.ui.navigator.ViewIVR";
	protected static SWTGefBot bot = new SWTGefBot();
	private SWTBotView view;
	@SuppressWarnings("unchecked")
	private final Matcher<Object[]> arrayContainingTextOne = arrayContaining(hasProperty("text", is("one")));
	@SuppressWarnings("unchecked")
	private final Matcher<Object[]> arrayContainingTextTwo = arrayContaining(hasProperty("text", is("two")));
	public static final Bundle bundle = Platform.getBundle("com.vectorsf.jvoice.ui.navigator");
	private MyHook hook;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setClassUp() throws Exception {
		SWTBotHelper.closeWelcomeView(bot);
		InstanceScope.INSTANCE.getNode("org.eclipse.m2e.core").putBoolean("eclipse.m2.debugOutput", false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("restriction")
	@Before
	public void setUp() throws Exception {
		hook = new MyHook();
		MavenBuilder.addDebugHook(hook);
		UIThreadRunnable.syncExec(new VoidResult() {
			@Override
			public void run() {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceActive();
			}
		});

		SWTBotHelper.openView(bot, "IVR", "Navigator IVR");

		view = bot.viewById(NAVIGATOR_ID);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("restriction")
	@After
	public void tearDown() throws Exception {

		synchronized (hook) {
			int value = hook.count.get();
			if (value != 0) {
				hook.wait(10000);
			}
		}

		MavenBuilder.removeDebugHook(hook);

		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			while (true) {

				if (project.isSynchronized(2)) {
					try {
						deleteProject(project);

					} catch (ResourceException re) {
						IStatus status = re.getStatus();
						// System.err.println(status);
						if (status.getException() != null) {
							status.getException().printStackTrace();
						}
						throw re;
					}
					break;
				} else {
					project.refreshLocal(2, null);
					Thread.sleep(3000);
				}
			}
		}
		bot.viewById(NAVIGATOR_ID).close();
	}

	@Test
	public void testCreateProjects() throws CoreException {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		createProject("testNavigator");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator").expand().getItems(), is(arrayWithSize(2)));

		createProject("testNavigator2");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator").expand().getItems(), is(arrayWithSize(2)));

		assertThat(view.bot().tree().getTreeItem("testNavigator2"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator2").expand().getItems(), is(arrayWithSize(2)));
	}

	@Test
	public void testDeleteProjects() throws CoreException {
		assertThat(view.bot().tree().rowCount(), is(0));

		final IProject project1 = createProject("testNavigator");
		final IProject project2 = createProject("testNavigator2");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));

		deleteProject(project2);

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));

		deleteProject(project1);

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(0)));

	}

	@Test
	public void testCreateApplicationProjects() throws CoreException {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		createApplicationProject("Navigator");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("Navigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("Navigator").expand().getItems(), is(arrayWithSize(1)));

		createApplicationProject("Navigator2");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		assertThat(view.bot().tree().getTreeItem("Navigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("Navigator").expand().getItems(), is(arrayWithSize(1)));

		assertThat(view.bot().tree().getTreeItem("Navigator2"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("Navigator2").expand().getItems(), is(arrayWithSize(1)));

	}

	@Test
	public void testDeleteApplicationProjects() throws CoreException {
		assertThat(view.bot().tree().rowCount(), is(0));

		final IProject project1 = createProject("testNavigator");
		final IProject project2 = createProject("testNavigator2");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));

		deleteApplicationProject(project2);

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));

		deleteApplicationProject(project1);

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(0)));

	}

	@Test
	public void testCreateFolders() throws CoreException {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		createFolders(project, BaseModel.JV_PATH + "/several/packages/inside");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator").expand().getItems(),
				hasItemInArray(hasProperty("text", is("several.packages.inside"))));

	}

	@Test
	public void testFilterFolders() throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		createFolders(project, BaseModel.JV_PATH + "/several/packages/inside");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		SWTBotTreeItem[] items = view.bot().tree().getTreeItem("testNavigator").expand().getItems();
		assertThat(items, hasItemInArray(hasProperty("text", is("several.packages.inside"))));
		assertThat(items, not(hasItemInArray(hasProperty("text", is("several.packages")))));
		assertThat(items, not(hasItemInArray(hasProperty("text", is("several")))));

		createFile(project, BaseModel.JV_PATH + "/several/packages/one.jvflow",
				getInputStreamResource(bundle, "one.jvflow"));

		bot.sleep(MEDIUM_SLEEP);

		items = view.bot().tree().getTreeItem("testNavigator").expand().getItems();
		assertThat(items, hasItemInArray(hasProperty("text", is("several.packages.inside"))));
		assertThat(items, hasItemInArray(hasProperty("text", is("several.packages"))));
		assertThat(items, not(hasItemInArray(hasProperty("text", is("several")))));

	}

	@Test
	public void testDeleteFolders() throws CoreException {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));
		IProject project = createProject("testNavigator");
		createFolders(project, BaseModel.JV_PATH + "/several/packages/inside");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator").expand().getItems(),
				hasItemInArray(hasProperty("text", is("several.packages.inside"))));

		createFolders(project, BaseModel.JV_PATH + "/otros/nuevos");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator").expand().getItems(),
				hasItemInArray(hasProperty("text", is("otros.nuevos"))));

		deleteFolder(project, BaseModel.JV_PATH + "/otros/nuevos");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator").expand().getItems(),
				hasItemInArray(hasProperty("text", is("several.packages.inside"))));

		assertThat(view.bot().tree().getTreeItem("testNavigator").expand().getItems(),
				not(hasItemInArray(hasProperty("text", is("otros.nuevos")))));
		assertThat(view.bot().tree().getTreeItem("testNavigator").expand().getItems(),
				hasItemInArray(hasProperty("text", is("otros"))));

	}

	@Test
	public void testCreateFiles() throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		createFile(project, BaseModel.JV_PATH + "/several/packages/inside/one.jvflow",
				getInputStreamResource(bundle, "one.jvflow"));

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside").getItems(),
				is(arrayContainingTextOne));

	}

	@Test
	public void testDeleteFiles() throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		final IProject project1 = createProject("testNavigator");
		final IProject project2 = createProject("testNavigator2");

		createFile(project1, BaseModel.JV_PATH + "/several/packages/inside/one.jvflow",
				getInputStreamResource(bundle, "one.jvflow"));
		createFile(project2, BaseModel.JV_PATH + "/several/packages/inside/two.jvflow",
				getInputStreamResource(bundle, "two.jvflow"));

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside").getItems(),
				is(arrayContainingTextOne));

		String ruta = BaseModel.JV_PATH + "/several/packages/inside/one.jvflow";
		deleteFile(project1, ruta);

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside").getItems(),
				is(not(arrayContainingTextOne)));
		assertThat(view.bot().tree().getTreeItem("testNavigator2"), is(not(nullValue())));
		assertThat(view.bot().tree().expandNode("testNavigator2", "several.packages.inside").getItems(),
				is(arrayContainingTextTwo));

	}

}
