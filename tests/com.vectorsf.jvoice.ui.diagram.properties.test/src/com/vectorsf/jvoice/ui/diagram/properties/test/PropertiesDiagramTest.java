/**
 * 
 */
package com.vectorsf.jvoice.ui.diagram.properties.test;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefViewer;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vectorsf.jvoice.base.model.service.BaseModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.fail;

/**
 * @author xIS16396
 * 
 */
public class PropertiesDiagramTest {

	private static final int LARGE_SLEEP = 100;
	protected static SWTGefBot bot = new SWTGefBot();
	private SWTBotView viewProperties;
	private SWTBotGefEditor editor;
	private SWTBotGefViewer gefViewer;

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

		SWTBotHelper.openView(bot, "General", "Properties");
		viewProperties = bot.viewByTitle("Properties");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bot.viewByTitle("Properties").close();
		if (editor != null) {
			editor.close();
		}

		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {

			try {
				SWTBotHelper.deleteProject(project);
			} catch (CoreException ce) {
				ce.printStackTrace();
				fail(ce.getMessage());
			}
		}
	}

	@Test
	public void testPropertiesFinalState() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/subFlow.jvflow",
				SWTBotHelper.getInputStreamResource("subFlow.jvflow"));
		
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		gefViewer.click("Estado_Final");

		bot.sleep(LARGE_SLEEP);

		viewProperties.setFocus();

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Estado_Final"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/test/five.jvflow"),
				is(not(nullValue())));
		
		
		SWTBotText textName = viewProperties.bot().text("Estado_Final");
		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("Estado_Final");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
		
	}

	@Test
	public void testPropertiesInitialState() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");


		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/subFlow.jvflow",
				SWTBotHelper.getInputStreamResource("subFlow.jvflow"));
		
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("Initial");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Initial"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/test/five.jvflow"),
				is(not(nullValue())));
		
		SWTBotText textName = viewProperties.bot().text("Initial");
		
		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("Initial");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesCallState() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/subFlow.jvflow",
				SWTBotHelper.getInputStreamResource("subFlow.jvflow"));
		
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("Call");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Call"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/test/five.jvflow"),
				is(not(nullValue())));
		
		SWTBotText textName = viewProperties.bot().text("Call");
		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("Call");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesSwitchState() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/subFlow.jvflow",
				SWTBotHelper.getInputStreamResource("subFlow.jvflow"));
		
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("Switch");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Switch"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/test/five.jvflow"),
				is(not(nullValue())));
		
		SWTBotText textName = viewProperties.bot().text("Switch");

		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("Switch");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesCallFlowState() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/subFlow.jvflow",
				SWTBotHelper.getInputStreamResource("subFlow.jvflow"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/otroSubFlow.jvflow",
				SWTBotHelper.getInputStreamResource("otroSubFlow.jvflow"));
		
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("subFlow");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("subFlow"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/test/five.jvflow"),
				is(not(nullValue())));
		assertThat(viewProperties.bot().text(2).getText(), is("subFlow"));
		
		viewProperties.bot().button(0).click();
		
		bot.shell("Flow Selection").activate();
		final SWTBotShell shellCreate = bot.shell("Flow Selection"); //$NON-NLS-1$
		final SWTBot dialogBot = bot.shell("Flow Selection").bot();
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().rowCount(), is(1));
		assertThat(dialogBot.button("OK").isEnabled(), is(false));
		assertThat(dialogBot.tree().getTreeItem("testNavigator"), is(not(nullValue())));
		
		dialogBot.tree().expandNode("testNavigator");
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().getTreeItem("testNavigator").rowCount(), is(1));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test"), is(not(nullValue())));
		
		dialogBot.tree().getTreeItem("testNavigator").expandNode("test");
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").rowCount(), is(3));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("five"), is(not(nullValue())));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("subFlow"), is(not(nullValue())));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("otroSubFlow"), is(not(nullValue())));
		dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("otroSubFlow").select();
		
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		
		dialogBot.button("OK").click();
		
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
						if (!shellCreate.isOpen()) {
							return true;
						}
						return false;
					}

					public String getFailureMessage() {
						return "Was expecting the 'Create' dialog to close itself";
					}
				}, 5 * 60 * 1000);
		bot.sleep(LARGE_SLEEP);
		
		assertThat(viewProperties.bot().text(2).getText(), is("otroSubFlow"));
		
		SWTBotText textName = viewProperties.bot().text("subFlow");
		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("subFlow");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesTransition() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/subFlow.jvflow",
				SWTBotHelper.getInputStreamResource("subFlow.jvflow"));
		
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("default");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("default"), is(not(nullValue())));

		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/test/five.jvflow"),
				is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Initial State:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Switch"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Final State:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Estado_Final"), is(not(nullValue())));

	}

	@Test
	public void testPropertiesMenu() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/menuVoice.voiceDsl",
				SWTBotHelper.getInputStreamResource("menuVoice.voiceDsl"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/otroMenuVoice.voiceDsl",
				SWTBotHelper.getInputStreamResource("otroMenuVoice.voiceDsl"));
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/dslFlow.jvflow",
				SWTBotHelper.getInputStreamResource("dslFlow.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("menuVoice");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("menuVoice"), is(not(nullValue())));
		SWTBotText textName = viewProperties.bot().text("menuVoice");
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/test/dslFlow.jvflow"),
				is(not(nullValue())));
		
		assertThat(viewProperties.bot().clabel("Name locution:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text(2).getText(), is("menuVoice"));
		viewProperties.bot().button(0).click();
		
		bot.shell("Menu Selection").activate();
		final SWTBotShell shellCreate = bot.shell("Menu Selection"); //$NON-NLS-1$
		final SWTBot dialogBot = bot.shell("Menu Selection").bot();
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().rowCount(), is(1));
		assertThat(dialogBot.button("OK").isEnabled(), is(false));
		assertThat(dialogBot.tree().getTreeItem("testNavigator"), is(not(nullValue())));
		
		dialogBot.tree().expandNode("testNavigator");
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().getTreeItem("testNavigator").rowCount(), is(1));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test"), is(not(nullValue())));
		
		dialogBot.tree().getTreeItem("testNavigator").expandNode("test");
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").rowCount(), is(2));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("Menu Dsl menuVoice"), is(not(nullValue())));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("Menu Dsl otroMenuVoice"), is(not(nullValue())));
		dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("Menu Dsl otroMenuVoice").select();
		
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		
		dialogBot.button("OK").click();
		
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
						if (!shellCreate.isOpen()) {
							return true;
						}
						return false;
					}

					public String getFailureMessage() {
						return "Was expecting the 'Create' dialog to close itself";
					}
				}, 5 * 60 * 1000);
		bot.sleep(LARGE_SLEEP);
		
		assertThat(viewProperties.bot().text(2).getText(), is("otroMenuVoice"));

		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("menuVoice");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesPrompt() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/outputVoice.voiceDsl",
				SWTBotHelper.getInputStreamResource("outputVoice.voiceDsl"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/otroOutputVoice.voiceDsl",
				SWTBotHelper.getInputStreamResource("otroOutputVoice.voiceDsl"));
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/dslFlow.jvflow",
				SWTBotHelper.getInputStreamResource("dslFlow.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("outputVoice");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("outputVoice"), is(not(nullValue())));
		SWTBotText textName = viewProperties.bot().text("outputVoice");
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/test/dslFlow.jvflow"),
				is(not(nullValue())));
		
		assertThat(viewProperties.bot().clabel("Name locution:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text(2).getText(), is("outputVoice"));
		viewProperties.bot().button(0).click();
		
		bot.shell("Output Selection").activate();
		final SWTBotShell shellCreate = bot.shell("Output Selection"); //$NON-NLS-1$
		final SWTBot dialogBot = bot.shell("Output Selection").bot();
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().rowCount(), is(1));
		assertThat(dialogBot.button("OK").isEnabled(), is(false));
		assertThat(dialogBot.tree().getTreeItem("testNavigator"), is(not(nullValue())));
		
		dialogBot.tree().expandNode("testNavigator");
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().getTreeItem("testNavigator").rowCount(), is(1));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test"), is(not(nullValue())));
		
		dialogBot.tree().getTreeItem("testNavigator").expandNode("test");
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").rowCount(), is(2));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("Prompt Dsl outputVoice"), is(not(nullValue())));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("Prompt Dsl otroOutputVoice"), is(not(nullValue())));
		dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("Prompt Dsl otroOutputVoice").select();
		
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		
		dialogBot.button("OK").click();
		
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
						if (!shellCreate.isOpen()) {
							return true;
						}
						return false;
					}

					public String getFailureMessage() {
						return "Was expecting the 'Create' dialog to close itself";
					}
				}, 5 * 60 * 1000);
		bot.sleep(LARGE_SLEEP);
		
		assertThat(viewProperties.bot().text(2).getText(), is("otroOutputVoice"));

		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("outputVoice");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesInput() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/inputVoice.voiceDsl",
				SWTBotHelper.getInputStreamResource("inputVoice.voiceDsl"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/otroInputVoice.voiceDsl",
				SWTBotHelper.getInputStreamResource("otroInputVoice.voiceDsl"));
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/dslFlow.jvflow",
				SWTBotHelper.getInputStreamResource("dslFlow.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("inputVoice");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("inputVoice"), is(not(nullValue())));
		SWTBotText textName = viewProperties.bot().text("inputVoice");
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/test/dslFlow.jvflow"),
				is(not(nullValue())));
		
		assertThat(viewProperties.bot().clabel("Name locution:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text(2).getText(), is("inputVoice"));
		viewProperties.bot().button(0).click();
		
		bot.shell("Input Selection").activate();
		final SWTBotShell shellCreate = bot.shell("Input Selection"); //$NON-NLS-1$
		final SWTBot dialogBot = bot.shell("Input Selection").bot();
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().rowCount(), is(1));
		assertThat(dialogBot.button("OK").isEnabled(), is(false));
		assertThat(dialogBot.tree().getTreeItem("testNavigator"), is(not(nullValue())));
		
		dialogBot.tree().expandNode("testNavigator");
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().getTreeItem("testNavigator").rowCount(), is(1));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test"), is(not(nullValue())));
		
		dialogBot.tree().getTreeItem("testNavigator").expandNode("test");
		
		bot.sleep(LARGE_SLEEP);
		
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").rowCount(), is(2));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("Input Dsl inputVoice"), is(not(nullValue())));
		assertThat(dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("Input Dsl otroInputVoice"), is(not(nullValue())));
		dialogBot.tree().getTreeItem("testNavigator").getNode("test").getNode("Input Dsl otroInputVoice").select();
		
		assertThat(dialogBot.button("OK").isEnabled(), is(true));
		
		dialogBot.button("OK").click();
		
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
						if (!shellCreate.isOpen()) {
							return true;
						}
						return false;
					}

					public String getFailureMessage() {
						return "Was expecting the 'Create' dialog to close itself";
					}
				}, 5 * 60 * 1000);
		bot.sleep(LARGE_SLEEP);
		
		assertThat(viewProperties.bot().text(2).getText(), is("otroInputVoice"));

		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("inputVoice");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}
	
	private void comunPropertiesSwitch()throws CoreException {
		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/Switch_Flow.jvflow",
				SWTBotHelper.getInputStreamResource("Switch_Flow.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("Switch");

		bot.sleep(LARGE_SLEEP);
		
		assertThat(viewProperties.bot().table().columns().get(0).toString(), equalToIgnoringCase("Condition"));
		assertThat(viewProperties.bot().table().columns().get(1).toString(), equalToIgnoringCase("EventName"));
		assertThat(viewProperties.bot().table().columnCount(), is(2));
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("default"));
		viewProperties.bot().button(0).click();
	}
	
	@Test
	public void testPropertiesSwitchCaseAdd() throws CoreException {
		comunPropertiesSwitch();
		
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("default"));
	}
	
	@Test
	public void testPropertiesSwitchCaseRemove() throws CoreException {
		comunPropertiesSwitch();
		
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("default"));
		viewProperties.bot().table().getTableItem(0).select();
		viewProperties.bot().button(1).click();
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("default"));
	}
	
	@Test
	public void testPropertiesSwitchCaseUp() throws CoreException {
		comunPropertiesSwitch();
		viewProperties.bot().button(0).click();
		
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("Case_2"));
		assertThat(viewProperties.bot().table().cell(2, 1).toString(), equalToIgnoringCase("default"));
		viewProperties.bot().table().getTableItem(1).select();
		viewProperties.bot().button(2).click();
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_2"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("Case_1"));
	}
	
	@Test
	public void testPropertiesSwitchCaseDown() throws CoreException {
		comunPropertiesSwitch();
		viewProperties.bot().button(0).click();
		
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("Case_2"));
		assertThat(viewProperties.bot().table().cell(2, 1).toString(), equalToIgnoringCase("default"));
		viewProperties.bot().table().getTableItem(0).select();
		viewProperties.bot().button(3).click();
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_2"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("Case_1"));
	}
	
	@Test
	public void testPropertiesSwitchCaseNotRemove() throws CoreException {
		comunPropertiesSwitch();
		
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("default"));
		viewProperties.bot().table().getTableItem(1).select();
		viewProperties.bot().button(1).click();
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("default"));
	}
	
	@Test
	public void testPropertiesSwitchCaseNotUp() throws CoreException {
		comunPropertiesSwitch();
		
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("default"));
		viewProperties.bot().table().getTableItem(1).select();
		viewProperties.bot().button(2).click();
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("default"));
	}
	
	@Test
	public void testPropertiesSwitchCaseNotDown() throws CoreException {
		comunPropertiesSwitch();
		
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("default"));
		viewProperties.bot().table().getTableItem(0).select();
		viewProperties.bot().button(3).click();
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("default"));
	}
	
	@Test
	public void testPropertiesSwitchCaseRename() throws CoreException {
		comunPropertiesSwitch();
		
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("default"));
		viewProperties.bot().table().click(0, 0);
		bot.sleep(LARGE_SLEEP);
		viewProperties.bot().text("").setText("holaaaaa");
		viewProperties.bot().table().click(0, 1);
		bot.sleep(LARGE_SLEEP);
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(0, 0).toString(), equalToIgnoringCase("holaaaaa"));
		
		viewProperties.bot().table().click(0, 1);
		bot.sleep(LARGE_SLEEP);
		viewProperties.bot().text("Case_1").setText("otroCase");
		viewProperties.bot().table().click(0, 0);
		bot.sleep(LARGE_SLEEP);
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("otroCase"));
		assertThat(viewProperties.bot().clabel(0).getText(), equalToIgnoringCase(""));
		
		viewProperties.bot().table().click(0, 1);
		bot.sleep(LARGE_SLEEP);
		viewProperties.bot().text("otroCase").setText("prueba Case");
		viewProperties.bot().table().click(0, 0);
		bot.sleep(LARGE_SLEEP);
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("otroCase"));
		assertThat(viewProperties.bot().clabel(0).getText(), not(equalToIgnoringCase("")));
		
		viewProperties.bot().table().click(0, 1);
		bot.sleep(LARGE_SLEEP);
		viewProperties.bot().text("otroCase").setText("nuevo_intento");
		viewProperties.bot().table().click(0, 0);
		bot.sleep(LARGE_SLEEP);
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("nuevo_intento"));
		assertThat(viewProperties.bot().clabel(0).getText(), equalToIgnoringCase(""));
		
		viewProperties.bot().table().click(0, 1);
		bot.sleep(LARGE_SLEEP);
		viewProperties.bot().text("nuevo_intento").setText("nuevo_intento/");
		viewProperties.bot().table().click(0, 0);
		bot.sleep(LARGE_SLEEP);
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("nuevo_intento"));
		assertThat(viewProperties.bot().clabel(0).getText(), not(equalToIgnoringCase("")));
		
		viewProperties.bot().table().click(0, 1);
		bot.sleep(LARGE_SLEEP);
		viewProperties.bot().text("nuevo_intento").setText("otraMas");
		viewProperties.bot().table().click(0, 0);
		bot.sleep(LARGE_SLEEP);
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("otraMas"));
		assertThat(viewProperties.bot().clabel(0).getText(), equalToIgnoringCase(""));
		
		viewProperties.bot().table().click(0, 1);
		bot.sleep(LARGE_SLEEP);
		viewProperties.bot().text("otraMas").setText("");
		viewProperties.bot().table().click(0, 0);
		bot.sleep(LARGE_SLEEP);
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("otraMas"));
		assertThat(viewProperties.bot().clabel(0).getText(), not(equalToIgnoringCase("")));
		
		viewProperties.bot().table().click(0, 1);
		bot.sleep(LARGE_SLEEP);
		viewProperties.bot().text("otraMas").setText("laUltima");
		viewProperties.bot().table().click(0, 0);
		bot.sleep(LARGE_SLEEP);
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("laUltima"));
		assertThat(viewProperties.bot().clabel(0).getText(), equalToIgnoringCase(""));
		
		viewProperties.bot().button(0).click();
		bot.sleep(LARGE_SLEEP);
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("Case_1"));
		
		viewProperties.bot().table().click(0, 1);
		bot.sleep(LARGE_SLEEP);
		viewProperties.bot().text("laUltima").setText("Case_1");
		viewProperties.bot().table().click(0, 0);
		bot.sleep(LARGE_SLEEP);
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("laUltima"));
		assertThat(viewProperties.bot().clabel(0).getText(), not(equalToIgnoringCase("")));
	}
	
	@Test
	public void testRemoveWithTransition() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/subFlow.jvflow",
				SWTBotHelper.getInputStreamResource("subFlow.jvflow"));
		
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/test/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("Switch");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_1"));
		assertThat(viewProperties.bot().table().cell(1, 1).toString(), equalToIgnoringCase("Case_2"));
		assertThat(viewProperties.bot().table().cell(2, 1).toString(), equalToIgnoringCase("default"));
		viewProperties.bot().table().getTableItem(0).select();
		viewProperties.bot().button(1).click();
		
		bot.sleep(LARGE_SLEEP);
		
		bot.shell("Confirm Delete").activate();
		final SWTBotShell shellCreate = bot.shell("Confirm Delete"); //$NON-NLS-1$
		final SWTBot dialogBot = bot.shell("Confirm Delete").bot();
		
		dialogBot.button("Yes").click();
		
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
						if (!shellCreate.isOpen()) {
							return true;
						}
						return false;
					}

					public String getFailureMessage() {
						return "Was expecting the 'Create' dialog to close itself";
					}
				}, 5 * 60 * 1000);
		bot.sleep(LARGE_SLEEP);
		
		assertThat(viewProperties.bot().table().cell(0, 1).toString(), equalToIgnoringCase("Case_2"));
		
	}
	
}
