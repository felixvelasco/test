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
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCCombo;
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
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/several/packages/inside/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		gefViewer.click("Final");

		bot.sleep(LARGE_SLEEP);

		viewProperties.setFocus();

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Final"), is(not(nullValue())));
		SWTBotText textName = viewProperties.bot().text("Final");
		assertThat(viewProperties.bot().ccomboBox("Switch_Final"), is(not(nullValue())));
		SWTBotCCombo transitions = viewProperties.bot().ccomboBox("Switch_Final");
		assertThat(transitions.itemCount(), is(3));
		transitions.setSelection(1);
		assertThat(viewProperties.bot().ccomboBox("inputDSL_Final"), is(not(nullValue())));
		transitions.setSelection(2);
		assertThat(viewProperties.bot().ccomboBox("promptDSL_Final"), is(not(nullValue())));
		textName.setFocus();
		textName.setText("otro");
		transitions.setFocus();
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/several/packages/inside/five.jvflow"),
				is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Incoming Transitions:"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesInitialState() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/several/packages/inside/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("Inicial");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Inicial"), is(not(nullValue())));
		SWTBotText textName = viewProperties.bot().text("Inicial");
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/several/packages/inside/five.jvflow"),
				is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Out Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("Inicial_Call"), is(not(nullValue())));
		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("Inicial");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesCallState() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/several/packages/inside/five.jvflow",
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
		SWTBotText textName = viewProperties.bot().text("Call");
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/several/packages/inside/five.jvflow"),
				is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Incoming Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("Inicial_Call"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Out Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("Call_Switch"), is(not(nullValue())));
		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("Call");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesSwitchState() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/several/packages/inside/five.jvflow",
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
		SWTBotText textName = viewProperties.bot().text("Switch");
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/several/packages/inside/five.jvflow"),
				is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Incoming Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("Call_Switch"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Out Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("Switch_Final"), is(not(nullValue())));
		SWTBotCCombo transitions = viewProperties.bot().ccomboBox("Switch_Final");
		assertThat(transitions.itemCount(), is(2));
		transitions.setSelection(1);
		assertThat(viewProperties.bot().ccomboBox("Switch_empty"), is(not(nullValue())));
		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("Switch");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesCallFlowState() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/several/packages/inside/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("empty");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("empty"), is(not(nullValue())));
		SWTBotText textName = viewProperties.bot().text("empty");
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/several/packages/inside/five.jvflow"),
				is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Incoming Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("Switch_empty"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Out Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("empty_menuDSL"), is(not(nullValue())));
		SWTBotCCombo transitions = viewProperties.bot().ccomboBox("empty_menuDSL");
		assertThat(transitions.itemCount(), is(3));
		transitions.setSelection(1);
		assertThat(viewProperties.bot().ccomboBox("empty_inputDSL"), is(not(nullValue())));
		transitions.setSelection(2);
		assertThat(viewProperties.bot().ccomboBox("empty_promptDSL"), is(not(nullValue())));
		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("empty");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesTransition() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/several/packages/inside/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("Inicial_Call");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Inicial_Call"), is(not(nullValue())));
		SWTBotText textName = viewProperties.bot().text("Inicial_Call");
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/several/packages/inside/five.jvflow"),
				is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Initial State:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Inicial"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Final State:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Call"), is(not(nullValue())));

		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("Inicial_Call");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesMenu() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/several/packages/inside/dslFlow.jvflow",
				SWTBotHelper.getInputStreamResource("dslFlow.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("menuDSL");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("menuDSL"), is(not(nullValue())));
		SWTBotText textName = viewProperties.bot().text("menuDSL");
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/several/packages/inside/dslFlow.jvflow"),
				is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Incoming Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("inputDSL_menuDSL"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Out Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("none"), is(not(nullValue())));

		SWTBotCCombo transitions = viewProperties.bot().ccomboBox("inputDSL_menuDSL");

		assertThat(transitions.itemCount(), is(2));
		transitions.setSelection(1);
		assertThat(viewProperties.bot().ccomboBox("promptDSL_menuDSL"), is(not(nullValue())));

		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("menuDSL");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesPrompt() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/several/packages/inside/dslFlow.jvflow",
				SWTBotHelper.getInputStreamResource("dslFlow.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("promptDSL");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("promptDSL"), is(not(nullValue())));
		SWTBotText textName = viewProperties.bot().text("promptDSL");
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/several/packages/inside/dslFlow.jvflow"),
				is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Incoming Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("inputDSL_promptDSL"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Out Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("promptDSL_menuDSL"), is(not(nullValue())));

		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("promptDSL");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}

	@Test
	public void testPropertiesInput() throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/several/packages/inside/dslFlow.jvflow",
				SWTBotHelper.getInputStreamResource("dslFlow.jvflow"));

		bot.sleep(LARGE_SLEEP);

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();

		bot.sleep(LARGE_SLEEP);
		viewProperties.setFocus();

		gefViewer.click("inputDSL");

		bot.sleep(LARGE_SLEEP);

		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("inputDSL"), is(not(nullValue())));
		SWTBotText textName = viewProperties.bot().text("inputDSL");
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(
				viewProperties.bot().text(
						"/testNavigator/" + BaseModel.JV_PATH + "/several/packages/inside/dslFlow.jvflow"),
				is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Incoming Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("none"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Out Transitions:"), is(not(nullValue())));
		assertThat(viewProperties.bot().ccomboBox("inputDSL_promptDSL"), is(not(nullValue())));

		SWTBotCCombo transitions = viewProperties.bot().ccomboBox("inputDSL_promptDSL");
		assertThat(transitions.itemCount(), is(2));
		transitions.setSelection(1);
		assertThat(viewProperties.bot().ccomboBox("inputDSL_menuDSL"), is(not(nullValue())));

		textName.setFocus();
		textName.setText("otro");
		gefViewer.click("inputDSL");
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
	}
	
	private void comunPropertiesSwitch()throws CoreException {
		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH + "/several/packages/inside/Swicth_Flow.jvflow",
				SWTBotHelper.getInputStreamResource("Swicth_Flow.jvflow"));

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
	}
}
