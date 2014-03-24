/**
 * 
 */
package com.vectorsf.jvoice.base.model.service;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.finders.ContextMenuHelper;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
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
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createApplicationProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteApplicationProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.getInputStreamResource;

/**
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class NavigatorActionsTest {

	private static final int SMALL_SLEEP = 300;
	private static final int MEDIUM_SLEEP = 2000;
	private static final int LARGE_SLEEP = 10000;
	private static final int EXTRA_LARGE_SLEEP = 20000;
	private static final String NAVIGATOR_ID = "com.vectorsf.jvoice.ui.navigator.ViewIVR";
	protected static SWTGefBot bot = new SWTGefBot();
	private static SWTBotView view;
	public static final Bundle bundle = Platform.getBundle("com.vectorsf.jvoice.ui.navigator");
	private SWTBotGefEditor editor;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setClassUp() throws Exception {
		SWTBotHelper.closeWelcomeView(bot);
		SWTBotHelper.openView(bot, "IVR", "Navigator IVR");

		view = bot.viewById(NAVIGATOR_ID);
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
		createFile(project1, BaseModel.JV_PATH + "/several/packages/inside/newLocution.voiceDsl",
				getInputStreamResource(bundle, "newLocution.voiceDsl"));
		createFile(project1, BaseModel.JV_PATH + "/several/packages/inside/here/three.jvflow",
				getInputStreamResource(bundle, "three.jvflow"));
		createFile(project1, BaseModel.JV_PATH + "/several/packages/inside/here/four.jvflow",
				getInputStreamResource(bundle, "four.jvflow"));
		createFile(project1, BaseModel.JV_PATH + "/other/packages/inside/one.jvflow",
				getInputStreamResource(bundle, "one.jvflow"));

		UIThreadRunnable.syncExec(new VoidResult() {
			@Override
			public void run() {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceActive();
			}
		});

		view.bot().tree().expandNode("testNavigator", "several.packages.inside");
		view.bot().tree().expandNode("testNavigator", "several.packages.inside.here");
		view.bot().tree().expandNode("testNavigator", "other.packages.inside");

		LocalSelectionTransfer.getTransfer().setSelection(null);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		// bot.viewById(NAVIGATOR_ID).close();

		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			while (true) {
				if (project.isSynchronized(2)) {
					try {
						deleteProject(project);
					} catch (ResourceException re) {
						IStatus status = re.getStatus();
						System.err.println(status);
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
	}

	@Test
	public void testCopyPackage() throws Exception {

		createProject("testNavigator2");
		bot.sleep(MEDIUM_SLEEP);

		JVModule project1 = (JVModule) BaseModel.getInstance().getModel().getProject("testNavigator");
		JVModule project2 = (JVModule) BaseModel.getInstance().getModel().getProject("testNavigator2");
		assertThat(project2.getPackages(), not(hasPackageNamed("several.packages.inside.here")));

		SWTBotTreeItem project1Item = view.bot().tree().getTreeItem("testNavigator");
		SWTBotTreeItem project2Item = view.bot().tree().getTreeItem("testNavigator2");
		assertThat(project1Item.contextMenu("Paste"), hasProperty("enabled", is(false)));
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

		JVModule project = (JVModule) BaseModel.getInstance().getModel().getProject("testNavigator");
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

		JVModule project = (JVModule) BaseModel.getInstance().getModel().getProject("testNavigator");
		bot.sleep(MEDIUM_SLEEP);
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

	@Test
	public void testOpenBean() throws Exception {

		long oldValue = SWTBotPreferences.TIMEOUT;
		SWTBotPreferences.TIMEOUT = LARGE_SLEEP;
		SWTBotTreeItem here = view.bot().tree().getTreeItem("testNavigator").getNode("several.packages.inside")
				.getNode("one").select();
		assertThat(here.contextMenu("Open"), hasProperty("enabled", is(true)));

		view.bot().tree().getTreeItem("testNavigator").getNode("several.packages.inside").getNode("one").select()
				.contextMenu("Open").click();

		editor = getGefEditor();
		assertThat(editor, is(not(nullValue())));
		editor.close();

		SWTBotPreferences.TIMEOUT = oldValue;
	}

	@Test
	public void testCopyPackageToApplication() throws Exception {

		IProject project = createApplicationProject("testNavigatorApplication");
		bot.sleep(SMALL_SLEEP);

		SWTBotTreeItem project1Item = view.bot().tree().getTreeItem("testNavigator");
		SWTBotTreeItem project2Item = view.bot().tree().getTreeItem("testNavigatorApplication");
		assertThat(project1Item.contextMenu("Paste"), hasProperty("enabled", is(false)));
		assertThat(project2Item.contextMenu("Paste"), hasProperty("enabled", is(false)));

		project1Item.getNode("several.packages.inside").select().contextMenu("Copy").click();
		
		assertThat(project2Item.contextMenu("Paste"), hasProperty("enabled", is(false)));

		deleteApplicationProject(project);
	}

	@Test
	public void testDeleteBean() throws Exception {

		JVModule project1 = (JVModule) BaseModel.getInstance().getModel().getProject("testNavigator");
		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside"));
		assertThat(project1.getPackage("several.packages.inside").getBeans(), hasBeanNamed("one"));
		assertThat(project1.getPackage("several.packages.inside").getBeans(), hasBeanNamed("two"));

		SWTBotTreeItem project1Item = view.bot().tree().getTreeItem("testNavigator").getNode("several.packages.inside")
				.getNode("two").select();

		assertThat(project1Item.contextMenu("Delete"), hasProperty("enabled", is(true)));

		project1Item.contextMenu("Delete").click();

		bot.sleep(MEDIUM_SLEEP);

		SWTBot dialogBot = null;
		bot.shell("Delete").activate();
		dialogBot = bot.shell("Delete").bot();
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		assertThat(dialogBot.button("Cancel").isEnabled(), is(true));
		assertThat(dialogBot.button("Preview >").isEnabled(), is(true));
		dialogBot.button("Cancel").click();

		assertThat(project1.getPackage("several.packages.inside").getBeans(),
				both(hasBeanNamed("one")).and(hasBeanNamed("two")));

		project1Item.contextMenu("Delete").click();
		delete();

		bot.sleep(MEDIUM_SLEEP);
		assertThat(project1.getPackage("several.packages.inside").getBeans(), not(hasBeanNamed("two")));
		assertThat(project1.getPackage("several.packages.inside").getBeans(), hasBeanNamed("one"));

		deleteWindow();

	}

	@Test
	public void testDeleteTwoBean() throws Exception {

		JVModule project1 = (JVModule) BaseModel.getInstance().getModel().getProject("testNavigator");
		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside.here"));
		assertThat(project1.getPackage("several.packages.inside").getBeans(), hasBeanNamed("one"));
		assertThat(project1.getPackage("several.packages.inside").getBeans(), hasBeanNamed("two"));

		bot.sleep(MEDIUM_SLEEP);
		view.bot().tree().getTreeItem("testNavigator").getNode("several.packages.inside").select("one", "two");
		new SWTBotMenu(ContextMenuHelper.contextMenu(view.bot().tree(), "Delete")).click();

		SWTBot dialogBot = null;
		bot.shell("Delete").activate();
		dialogBot = bot.shell("Delete").bot();
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		assertThat(dialogBot.button("Cancel").isEnabled(), is(true));
		assertThat(dialogBot.button("Preview >").isEnabled(), is(true));
		dialogBot.button("Cancel").click();

		assertThat(project1.getPackage("several.packages.inside").getBeans(), hasBeanNamed("two"));

		view.bot().tree().getTreeItem("testNavigator").getNode("several.packages.inside").select("one", "two");
		new SWTBotMenu(ContextMenuHelper.contextMenu(view.bot().tree(), "Delete")).click();

		delete();

		bot.sleep(MEDIUM_SLEEP);
		assertThat(project1.getPackage("several.packages.inside").getBeans(), not(hasBeanNamed("one")));
		assertThat(project1.getPackage("several.packages.inside").getBeans(), not(hasBeanNamed("two")));

		deleteWindow();

	}

	@Test
	public void testDeletePackage() throws Exception {

		JVModule project1 = (JVModule) BaseModel.getInstance().getModel().getProject("testNavigator");
		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside"));
		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside.here"));
		assertThat(project1.getPackage("several.packages.inside.here").getBeans(), hasBeanNamed("three"));
		assertThat(project1.getPackage("several.packages.inside.here").getBeans(), hasBeanNamed("four"));

		SWTBotTreeItem project1Item = view.bot().tree().getTreeItem("testNavigator")
				.getNode("several.packages.inside.here").select();

		assertThat(project1Item.contextMenu("Delete"), hasProperty("enabled", is(true)));

		project1Item.contextMenu("Delete").click();

		bot.sleep(MEDIUM_SLEEP);

		SWTBot dialogBot = null;
		bot.shell("Delete").activate();
		dialogBot = bot.shell("Delete").bot();
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		assertThat(dialogBot.button("Cancel").isEnabled(), is(true));
		assertThat(dialogBot.button("Preview >").isEnabled(), is(true));
		dialogBot.button("Cancel").click();

		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside.here"));

		project1Item.contextMenu("Delete").click();
		delete();

		bot.sleep(MEDIUM_SLEEP);
		assertThat(project1.getPackages(), not(hasPackageNamed("several.packages.inside.here")));
		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside"));
		assertThat(project1.getPackage("several.packages.inside").getBeans(), hasBeanNamed("two"));
		assertThat(project1.getPackage("several.packages.inside").getBeans(), hasBeanNamed("one"));

		deleteWindow();

	}

	@Test
	public void testDeleteTwoPackages() throws Exception {

		JVModule project1 = (JVModule) BaseModel.getInstance().getModel().getProject("testNavigator");
		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside"));
		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside.here"));
		assertThat(project1.getPackages(), hasPackageNamed("other.packages.inside"));

		bot.sleep(MEDIUM_SLEEP);
		view.bot().tree().getTreeItem("testNavigator").select("several.packages.inside.here", "other.packages.inside");
		new SWTBotMenu(ContextMenuHelper.contextMenu(view.bot().tree(), "Delete")).click();

		SWTBot dialogBot = null;
		bot.shell("Delete").activate();
		dialogBot = bot.shell("Delete").bot();
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		assertThat(dialogBot.button("Cancel").isEnabled(), is(true));
		assertThat(dialogBot.button("Preview >").isEnabled(), is(true));
		dialogBot.button("Cancel").click();

		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside.here"));
		assertThat(project1.getPackages(), hasPackageNamed("other.packages.inside"));

		bot.sleep(MEDIUM_SLEEP);
		view.bot().tree().getTreeItem("testNavigator").select("several.packages.inside.here", "other.packages.inside");
		new SWTBotMenu(ContextMenuHelper.contextMenu(view.bot().tree(), "Delete")).click();

		delete();

		bot.sleep(MEDIUM_SLEEP);
		assertThat(project1.getPackages(), not(hasPackageNamed("several.packages.inside.here")));
		assertThat(project1.getPackages(), not(hasPackageNamed("other.packages.inside")));
		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside"));

		deleteWindow();

	}

	@Test
	public void testDeleteProject() throws Exception {

		createProject("testNavigator3");
		bot.sleep(MEDIUM_SLEEP);

		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator3"), is(not(nullValue())));

		SWTBotTreeItem project1Item = view.bot().tree().getTreeItem("testNavigator").select();
		assertThat(project1Item.contextMenu("Delete"), hasProperty("enabled", is(true)));

		System.err.println("Voy a dar al delete la primera vez, la de palo");
		project1Item.contextMenu("Delete").click();

		bot.sleep(MEDIUM_SLEEP);
		SWTBot dialogBot = null;
		bot.shell("Delete").activate();
		dialogBot = bot.shell("Delete").bot();
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		assertThat(dialogBot.button("Cancel").isEnabled(), is(true));
		assertThat(dialogBot.button("Preview >").isEnabled(), is(true));
		dialogBot.button("Cancel").click();

		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator3"), is(not(nullValue())));
		System.err.println("Voy a dar al delete");

		ResourcesPlugin.getWorkspace().getRoot().getProject("testNavigator")
				.refreshLocal(IResource.DEPTH_INFINITE, null);
		project1Item.contextMenu("Delete").click();
		System.err.println("Le he dado");
		deleteWithCheck();

		bot.sleep(LARGE_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator3"), is(not(nullValue())));

		System.err.println("Voy al deleteWindow");
		deleteWindow();

	}

	@Test
	public void testDeleteTwoProject() throws Exception {

		createProject("testNavigator3");
		bot.sleep(MEDIUM_SLEEP);

		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator3"), is(not(nullValue())));

		view.bot().tree().select("testNavigator", "testNavigator3");

		new SWTBotMenu(ContextMenuHelper.contextMenu(view.bot().tree(), "Delete")).click();

		SWTBot dialogBot = null;
		bot.shell("Delete").activate();
		dialogBot = bot.shell("Delete").bot();
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		assertThat(dialogBot.button("Cancel").isEnabled(), is(true));
		assertThat(dialogBot.button("Preview >").isEnabled(), is(true));
		dialogBot.button("Cancel").click();

		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"), is(not(nullValue())));
		assertThat(view.bot().tree().getTreeItem("testNavigator3"), is(not(nullValue())));

		ResourcesPlugin.getWorkspace().getRoot().getProject("testNavigator")
				.refreshLocal(IResource.DEPTH_INFINITE, null);
		ResourcesPlugin.getWorkspace().getRoot().getProject("testNavigator3")
				.refreshLocal(IResource.DEPTH_INFINITE, null);

		new SWTBotMenu(ContextMenuHelper.contextMenu(view.bot().tree(), "Delete")).click();
		deleteWithCheck();

		bot.sleep(MEDIUM_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(0)));

		deleteWindow();

	}

	@Test
	public void testCopyTwoPackage() throws Exception {

		createProject("testNavigator2");
		bot.sleep(SMALL_SLEEP);

		JVModule project1 = (JVModule) BaseModel.getInstance().getModel().getProject("testNavigator");
		JVModule project2 = (JVModule) BaseModel.getInstance().getModel().getProject("testNavigator2");
		assertThat(project2.getPackages(), not(hasPackageNamed("several.packages.inside.here")));
		assertThat(project2.getPackages(), not(hasPackageNamed("other.packages.inside")));

		SWTBotTreeItem project1Item = view.bot().tree().getTreeItem("testNavigator");
		SWTBotTreeItem project2Item = view.bot().tree().getTreeItem("testNavigator2");
		assertThat(project1Item.contextMenu("Paste"), hasProperty("enabled", is(false)));
		assertThat(project2Item.contextMenu("Paste"), hasProperty("enabled", is(false)));

		project1Item.select("several.packages.inside.here", "other.packages.inside");

		new SWTBotMenu(ContextMenuHelper.contextMenu(view.bot().tree(), "Copy")).click();

		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside"));
		assertThat(project1.getPackages(), hasPackageNamed("other.packages.inside"));
		assertThat(project2.getPackages(), not(hasPackageNamed("several.packages.inside")));
		assertThat(project2.getPackages(), not(hasPackageNamed("other.packages.inside")));

		assertThat(project2Item.contextMenu("Paste"), hasProperty("enabled", is(true)));
		project2Item.contextMenu("Paste").click();

		bot.sleep(MEDIUM_SLEEP);
		assertThat(project1.getPackages(), hasPackageNamed("several.packages.inside"));
		assertThat(project1.getPackages(), hasPackageNamed("other.packages.inside"));

		bot.sleep(MEDIUM_SLEEP);
		SWTBotTreeItem[] itemsAtTesNavigator = view.bot().tree().expandNode("testNavigator").getItems();
		assertThat(itemsAtTesNavigator, hasInArrayNamed("several.packages.inside"));
		assertThat(itemsAtTesNavigator, hasInArrayNamed("other.packages.inside"));
		assertThat(project2.getPackages(), hasPackageNamed("several.packages.inside"));
		assertThat(project2.getPackages(), hasPackageNamed("other.packages.inside"));

	}
	
	@Test
	public void testOpenPom() throws Exception {
		
		bot.sleep(LARGE_SLEEP);
		view.bot().tree().getTreeItem("testNavigator").contextMenu("Maven").menu("Open Pom").click();
			
		bot.sleep(EXTRA_LARGE_SLEEP);
		SWTBotEditor activeEditor = bot.activeEditor();		
		assertThat(activeEditor.getTitle(), is("testNavigator/pom.xml"));

	}
	
	@Test
	public void testRenameProject() throws Exception {
		
		IProject project2 = createProject("testNavigator2");
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		bot.sleep(EXTRA_LARGE_SLEEP);
		view.bot().tree().getTreeItem("testNavigator2").contextMenu("Rename").click();
			
		bot.sleep(LARGE_SLEEP);
		bot.shell("Rename Resource").activate();
		final SWTBotShell shellCreate = bot.shell("Rename Resource"); //$NON-NLS-1$
		final SWTBot dialogBot = shellCreate.bot();
		assertThat(dialogBot.text(0).getText(), is("testNavigator2"));
		assertThat(dialogBot.button("OK").isEnabled(), is(false));
		SWTBotText text = dialogBot.text(0);
		text.setText("Navigator");
		assertThat(dialogBot.button("OK").isEnabled(), is(true));		
		dialogBot.button("OK").click();
		
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (view.bot().tree().getAllItems().length==2) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 15 * 60 * 1000);
		
		bot.sleep(EXTRA_LARGE_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		assertThat(view.bot().tree().getTreeItem("Navigator"), is(notNullValue()));
	
	}

	public SWTBotGefEditor getGefEditor() {
		SWTBotEditor activeEditor = bot.activeEditor();
		String title = activeEditor.getTitle();
		SWTBotGefEditor ed = bot.gefEditor(title);
		return ed;
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

	/**
	 * 
	 */
	protected void delete() {
		SWTBot dialogBot;
		bot.shell("Delete").activate();
		final SWTBotShell shellCreate = bot.shell("Delete"); //$NON-NLS-1$
		dialogBot = bot.shell("Delete").bot();
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		assertThat(dialogBot.button("Cancel").isEnabled(), is(true));
		assertThat(dialogBot.button("Preview >").isEnabled(), is(true));
		dialogBot.button("OK").click();
		bot.waitUntil(new DefaultCondition() {
			@Override
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}

			@Override
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 30 * 1000);
	}

	/**
	 * 
	 */
	protected void deleteWithCheck() {
		SWTBot dialogBot;
		bot.shell("Delete").activate();
		final SWTBotShell shellCreate = bot.shell("Delete"); //$NON-NLS-1$
		dialogBot = bot.shell("Delete").bot();
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		assertThat(dialogBot.button("Cancel").isEnabled(), is(true));
		assertThat(dialogBot.button("Preview >").isEnabled(), is(true));
		assertThat(dialogBot.checkBox().isEnabled(), is(true));
		dialogBot.checkBox().click();
		dialogBot.button("OK").click();
		bot.sleep(LARGE_SLEEP);
		deleteWindow();
		bot.waitUntil(new DefaultCondition() {
			@Override
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}

			@Override
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 * 1000);
		deleteWindow();
	}

	/**
	 * Metodo para borrar la ventana Delete en caso de que aparezca para eliminar la carpeta target.
	 */
	protected void deleteWindow() {
		System.err.println("1");
		SWTBot dialogBot;
		try {
			if (bot.shells().length > 0) {
				for (SWTBotShell shell : bot.shells()) {
					System.err.println("Shell : >>" + shell.getText() + "<<");
					if (shell.getText().equals("Delete")) {
						bot.shell("Delete");
						bot.shell("Delete").activate();
						final SWTBotShell shellCreate = bot.shell("Delete"); //$NON-NLS-1$
						dialogBot = bot.shell("Delete").bot();
						try {
							for (int i = 0; i > -1; i++) {
								SWTBotButton button = dialogBot.button(i);
								System.out.println("==> Boton numero " + i);
								System.out.println(button.getText());
								System.out.println(button.getId());
								System.out.println("===============");
							}
						} catch (WidgetNotFoundException w) {

						}

						dialogBot.button("Continue").click();
						bot.waitUntil(new DefaultCondition() {
							@Override
							public boolean test() throws Exception {
								if (!shellCreate.isOpen()) {
									return true;
								}
								return false;
							}

							@Override
							public String getFailureMessage() {
								return "Was expecting the 'Create' dialog to close itself";
							}
						}, 5 * 60 * 1000);

					}

				}

			}

		} catch (WidgetNotFoundException wnfe) {
			// Ignorada
		}
	}

}
