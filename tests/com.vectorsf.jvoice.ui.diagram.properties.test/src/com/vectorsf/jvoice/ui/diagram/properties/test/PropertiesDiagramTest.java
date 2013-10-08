/**
 * 
 */
package com.vectorsf.jvoice.ui.diagram.properties.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.fail;

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
import com.vectorsf.jvoice.ui.diagram.properties.test.SWTBotHelper;

/**
 * @author xIS16396
 *
 */
public class PropertiesDiagramTest {

	private static final int LARGE_SLEEP = 100;
	private static final String NAVIGATOR_ID = "com.vectorsf.jvoice.ui.navigator.ViewIVR";
	protected static SWTGefBot bot = new SWTGefBot();
	private SWTBotView view;
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
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell()
						.forceActive();
			}
		});

		SWTBotHelper.openView(bot, "General", "Properties");
		viewProperties = bot.viewByTitle("Properties");
		SWTBotHelper.openView(bot, "IVR", "Navigator IVR");
		view = bot.viewById(NAVIGATOR_ID);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bot.viewByTitle("Properties").close();
		bot.viewById(NAVIGATOR_ID).close();
		if (editor != null) {
			editor.close();
		}

		for (IProject project : ResourcesPlugin.getWorkspace().getRoot()
				.getProjects()) {

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
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		SWTBotHelper.openFile(file);
		bot.sleep(LARGE_SLEEP);
		

		editor = SWTBotHelper.getGefEditor(bot);
		gefViewer = editor.getSWTBotGefViewer();
		
		bot.sleep(LARGE_SLEEP);

		gefViewer.click("Final");
		
		bot.sleep(LARGE_SLEEP);
		
		viewProperties.setFocus();
		
		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("Final"), is(not(nullValue())));
		SWTBotText textName = viewProperties.bot().text("Final");
		assertThat(viewProperties.bot().ccomboBox("Switch_Final"), is(not(nullValue())));
		SWTBotCCombo transitions = viewProperties.bot().ccomboBox("Switch_Final");
		assertThat(transitions.itemCount(), is(2));
		transitions.setSelection(1);
		assertThat(viewProperties.bot().ccomboBox("empty_Final"), is(not(nullValue())));
		textName.setFocus();
		textName.setText("otro");
		transitions.setFocus();
		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
		assertThat(viewProperties.bot().text("/testNavigator/" + BaseModel.JV_PATH + "/several/packages/inside/five.jvflow"), is(not(nullValue())));
		assertThat(viewProperties.bot().clabel("Incoming Transitions:"), is(not(nullValue())));
	}
	
//	@Test
//	public void testPropertiesInitialState() throws CoreException {
//		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));
//
//		IProject project = SWTBotHelper.createProject("testNavigator");
//		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH
//				+ "/several/packages/inside/five.jvflow",
//				SWTBotHelper.getInputStreamResource("five.jvflow"));
//
//		SWTBotHelper.openFile(file);
//		bot.sleep(LARGE_SLEEP);
//		
//
//		editor = SWTBotHelper.getGefEditor(bot);
//		gefViewer = editor.getSWTBotGefViewer();
//		
//		bot.sleep(LARGE_SLEEP);
//		viewProperties.setFocus();
//
//		gefViewer.click("Initial");
//		
//		bot.sleep(LARGE_SLEEP);
//		
//		assertThat(viewProperties.bot().clabel("Name:"), is(not(nullValue())));
//		assertThat(viewProperties.bot().text("Initial"), is(not(nullValue())));
//		SWTBotText textName = viewProperties.bot().text("Initial");
//		assertThat(viewProperties.bot().clabel("Path:"), is(not(nullValue())));
//		assertThat(viewProperties.bot().text("/testNavigator/" + BaseModel.JV_PATH + "/several/packages/inside/five.jvflow"), is(not(nullValue())));
//		assertThat(viewProperties.bot().clabel("Out Transitions: "), is(not(nullValue())));
//		assertThat(viewProperties.bot().text("Initial_Call"), is(not(nullValue())));
//		textName.setFocus();
//		textName.setText("otro");
//		gefViewer.click("Initial");
//		assertThat(viewProperties.bot().text("otro"), is(not(nullValue())));
//	}
}
