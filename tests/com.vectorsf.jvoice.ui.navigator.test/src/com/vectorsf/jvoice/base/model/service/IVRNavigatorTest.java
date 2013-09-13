/**
 * 
 */
package com.vectorsf.jvoice.base.model.service;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import static org.junit.Assert.fail;

/**
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class IVRNavigatorTest {

	private static final int SMALL_SLEEP = 200;
	private static final String NAVIGATOR_ID = "com.vectorsf.jvoice.ui.navigator.ViewIVR";
	protected static SWTGefBot bot = new SWTGefBot();
	private SWTBotView view;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setClassUp() throws Exception {
		SWTBotHelper.closeWelcomeView(bot);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
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
	@After
	public void tearDown() throws Exception {
		bot.viewById(NAVIGATOR_ID).close();

		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			try {
				SWTBotHelper.deleteProject(project);
			} catch (CoreException ce) {
				fail(ce.getMessage());
			}
		}
	}

	@Test
	public void testCreateProjects() throws CoreException {
		assertThat(view.bot().tree().rowCount(), is(0));

		SWTBotHelper.createProject("testNavigator");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().rowCount(), is(1));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator").expand().getItems(), is(emptyArray()));

		SWTBotHelper.createProject("testNavigator2");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().rowCount(), is(2));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator").expand().getItems(), is(emptyArray()));

		assertThat(view.bot().tree().getTreeItem("testNavigator2"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator2").expand().getItems(), is(emptyArray()));

	}

	@Test
	public void testDeleteProjects() throws CoreException {
		assertThat(view.bot().tree().rowCount(), is(0));

		final IProject project1 = SWTBotHelper.createProject("testNavigator");
		final IProject project2 = SWTBotHelper.createProject("testNavigator2");

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().rowCount(), is(2));

		SWTBotHelper.deleteProject(project2);

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().rowCount(), is(1));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));

		SWTBotHelper.deleteProject(project1);

		bot.sleep(SMALL_SLEEP);
		assertThat(view.bot().tree().rowCount(), is(0));

	}
}
