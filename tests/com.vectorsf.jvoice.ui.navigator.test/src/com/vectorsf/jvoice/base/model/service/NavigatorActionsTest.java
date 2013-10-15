/**
 * 
 */
package com.vectorsf.jvoice.base.model.service;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.finders.ContextMenuHelper;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.PlatformUI;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osgi.framework.Bundle;

import com.vectorsf.jvoice.base.test.SWTBotHelper;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.getInputStreamResource;

/**
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class NavigatorActionsTest {

	private static final int SMALL_SLEEP = 300;
	private static final int MEDIUM_SLEEP = 1000;
	private static final String NAVIGATOR_ID = "com.vectorsf.jvoice.ui.navigator.ViewIVR";
	protected static SWTGefBot bot = new SWTGefBot();
	private SWTBotView view;
	public static final Bundle bundle = Platform.getBundle("com.vectorsf.jvoice.ui.navigator");

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
		final IProject project1 = createProject("testNavigator");

		createFile(project1, BaseModel.JV_PATH + "/several/packages/inside/one.jvflow",
				getInputStreamResource(bundle, "one.jvflow"));
		createFile(project1, BaseModel.JV_PATH + "/several/packages/inside/two.jvflow",
				getInputStreamResource(bundle, "two.jvflow"));
		createFile(project1, BaseModel.JV_PATH + "/several/packages/inside/here/three.jvflow",
				getInputStreamResource(bundle, "three.jvflow"));
		createFile(project1, BaseModel.JV_PATH + "/several/packages/inside/here/four.jvflow",
				getInputStreamResource(bundle, "four.jvflow"));

		UIThreadRunnable.syncExec(new VoidResult() {
			@Override
			public void run() {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceActive();
			}
		});

		SWTBotHelper.openView(bot, "IVR", "Navigator IVR");

		view = bot.viewById(NAVIGATOR_ID);

		view.bot().tree().expandNode("testNavigator", "several.packages.inside");
		view.bot().tree().expandNode("testNavigator", "several.packages.inside.here");

		LocalSelectionTransfer.getTransfer().setSelection(null);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bot.viewById(NAVIGATOR_ID).close();

		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			deleteProject(project);
		}
	}

	@Test
	public void testCopyPackage() throws Exception {

		createProject("testNavigator2");
		bot.sleep(SMALL_SLEEP);

		JVProject project1 = BaseModel.getInstance().getModel().getProject("testNavigator");
		JVProject project2 = BaseModel.getInstance().getModel().getProject("testNavigator2");
		assertThat(project2.getPackages(), not(hasPackageNamed("several.packages.inside.here")));

		SWTBotTreeItem project1Item = view.bot().tree().getTreeItem("testNavigator");
		SWTBotTreeItem project2Item = view.bot().tree().getTreeItem("testNavigator2");
		assertThat(project2Item.contextMenu("Paste"), hasProperty("enabled", is(false)));

		project1Item.expand().getNode("several.packages.inside.here").contextMenu("Copy").click();

		assertThat(project2Item.contextMenu("Paste"), hasProperty("enabled", is(true)));
		project2Item.contextMenu("Paste").click();

		bot.sleep(MEDIUM_SLEEP);
		assertThat(project1.getPackage("several.packages.inside.here").getBeans(),
				both(hasBeanNamed("three")).and(hasBeanNamed("four")));
		assertThat(project2.getPackages(), hasPackageNamed("several.packages.inside.here"));
		assertThat(project2.getPackage("several.packages.inside.here").getBeans(),
				both(hasBeanNamed("three")).and(hasBeanNamed("four")));

		assertThat(view.bot().tree().expandNode("testNavigator2").getItems(),
				hasInArrayNamed("several.packages.inside.here"));

		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside.here").getItems(),
				both(hasInArrayNamed("three")).and(hasInArrayNamed("four")));
		assertThat(view.bot().tree().expandNode("testNavigator2", "several.packages.inside.here").getItems(),
				both(hasInArrayNamed("three")).and(hasInArrayNamed("four")));

	}

	@Test
	public void testCopyBean() throws Exception {

		SWTBotTreeItem here = view.bot().tree().getTreeItem("testNavigator").getNode("several.packages.inside.here")
				.select();
		assertThat(here.contextMenu("Paste"), hasProperty("enabled", is(false)));

		JVProject project = BaseModel.getInstance().getModel().getProject("testNavigator");
		view.bot().tree().getTreeItem("testNavigator").getNode("several.packages.inside").getNode("one").select()
				.contextMenu("Copy").click();
		assertThat(project.getPackage("several.packages.inside").getBeans(), hasBeanNamed("one"));
		assertThat(project.getPackage("several.packages.inside.here").getBeans(), not(hasBeanNamed("one")));
		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside").getItems(),
				hasInArrayNamed("one"));
		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside.here").getItems(),
				not(hasInArrayNamed("one")));

		assertThat(here.contextMenu("Paste"), hasProperty("enabled", is(true)));
		here.contextMenu("Paste").click();

		bot.sleep(MEDIUM_SLEEP);
		assertThat(project.getPackage("several.packages.inside").getBeans(), hasBeanNamed("one"));
		assertThat(project.getPackage("several.packages.inside.here").getBeans(), hasBeanNamed("one"));
		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside").getItems(),
				hasInArrayNamed("one"));
		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside.here").getItems(),
				hasInArrayNamed("one"));

	}

	@Test
	public void testCopyTwoBeans() throws Exception {

		SWTBotTreeItem here = view.bot().tree().getTreeItem("testNavigator").getNode("several.packages.inside.here")
				.select();
		assertThat(here.contextMenu("Paste"), hasProperty("enabled", is(false)));

		JVProject project = BaseModel.getInstance().getModel().getProject("testNavigator");
		view.bot().tree().getTreeItem("testNavigator").getNode("several.packages.inside").select("one", "two");
		// Workaround for e4 (see http://www.eclipse.org/forums/index.php/t/11863/)
		new SWTBotMenu(ContextMenuHelper.contextMenu(view.bot().tree(), "Copy")).click();
		assertThat(project.getPackage("several.packages.inside").getBeans(), hasBeanNamed("one"));
		assertThat(project.getPackage("several.packages.inside").getBeans(), hasBeanNamed("two"));
		assertThat(project.getPackage("several.packages.inside.here").getBeans(), not(hasBeanNamed("one")));
		assertThat(project.getPackage("several.packages.inside.here").getBeans(), not(hasBeanNamed("two")));
		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside").getItems(),
				hasInArrayNamed("one"));
		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside").getItems(),
				hasInArrayNamed("two"));
		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside.here").getItems(),
				not(hasInArrayNamed("one")));
		assertThat(view.bot().tree().expandNode("testNavigator", "several.packages.inside.here").getItems(),
				not(hasInArrayNamed("two")));

		assertThat(here.contextMenu("Paste"), hasProperty("enabled", is(true)));
		here.contextMenu("Paste").click();

		bot.sleep(MEDIUM_SLEEP);
		assertThat(project.getPackage("several.packages.inside").getBeans(), hasBeanNamed("one"));
		assertThat(project.getPackage("several.packages.inside").getBeans(), hasBeanNamed("two"));
		assertThat(project.getPackage("several.packages.inside.here").getBeans(), hasBeanNamed("one"));
		assertThat(project.getPackage("several.packages.inside.here").getBeans(), hasBeanNamed("two"));

		SWTBotTreeItem[] itemsAtSeveralPackagesInside = view.bot().tree()
				.expandNode("testNavigator", "several.packages.inside").getItems();
		SWTBotTreeItem[] itemsAtSeveralPackagesInsideHere = view.bot().tree()
				.expandNode("testNavigator", "several.packages.inside.here").getItems();
		assertThat(itemsAtSeveralPackagesInside, hasInArrayNamed("one"));
		assertThat(itemsAtSeveralPackagesInside, hasInArrayNamed("two"));
		assertThat(itemsAtSeveralPackagesInsideHere, is(arrayWithSize(4)));
		assertThat(itemsAtSeveralPackagesInsideHere, hasInArrayNamed("one"));
		assertThat(itemsAtSeveralPackagesInsideHere, hasInArrayNamed("two"));
		assertThat(itemsAtSeveralPackagesInsideHere, hasInArrayNamed("three"));
		assertThat(itemsAtSeveralPackagesInsideHere, hasInArrayNamed("four"));
	}

	@Test
	public void testMenuItems() throws Exception {

		SWTBotTreeItem navigator = view.bot().tree().getTreeItem("testNavigator").select();
		assertThat(navigator.contextMenu("New"), hasProperty("enabled", is(true)));
		assertThat(navigator.contextMenu("Paste"), hasProperty("enabled", is(false)));
		assertThat(navigator.contextMenu("Delete"), hasProperty("enabled", is(true)));
		assertThat(navigator.contextMenu("Copy"), hasProperty("enabled", is(false)));

		SWTBotTreeItem spinside = navigator.getNode("several.packages.inside").select();
		assertThat(spinside.contextMenu("New"), hasProperty("enabled", is(true)));
		assertThat(spinside.contextMenu("Paste"), hasProperty("enabled", is(false)));
		assertThat(spinside.contextMenu("Delete"), hasProperty("enabled", is(true)));
		assertThat(spinside.contextMenu("Copy"), hasProperty("enabled", is(true)));

		SWTBotTreeItem two = spinside.getNode("two").select();
		assertThat(two.contextMenu("New"), hasProperty("enabled", is(true)));
		assertThat(two.contextMenu("Paste"), hasProperty("enabled", is(false)));
		assertThat(two.contextMenu("Delete"), hasProperty("enabled", is(true)));
		assertThat(two.contextMenu("Copy"), hasProperty("enabled", is(true)));
	}

	private Matcher<Iterable<? super JVBean>> hasBeanNamed(String name) {
		Matcher<Iterable<? super JVBean>> hasItem = hasItem(Matchers.<JVBean> hasProperty("name", is(name)));
		return hasItem;
	}

	private Matcher<Iterable<? super JVPackage>> hasPackageNamed(String name) {
		Matcher<Iterable<? super JVPackage>> hasItem = hasItem(Matchers.<JVPackage> hasProperty("name", is(name)));
		return hasItem;
	}

	private Matcher<Object[]> hasInArrayNamed(String name) {
		Matcher<Object[]> hasItem = hasItemInArray(hasProperty("text", is(name)));
		return hasItem;
	}
}
