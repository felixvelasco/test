package com.vectorsf.jvoice.diagram.core.test;

import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.getInputStreamResource;
import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.syncExec;
import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellIsActive;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefViewer;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osgi.framework.Bundle;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.base.test.SWTBotHelper;
import com.vectorsf.jvoice.model.operations.State;

/**
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class IVRDiagramOpenStatesTest {

	private static final int SMALL_SLEEP = 200;
	private static final int LARGE_SLEEP = 1000;
	private static final String NAVIGATOR_ID = "com.vectorsf.jvoice.ui.navigator.ViewIVR";
	protected static SWTGefBot bot = new SWTGefBot();
	private SWTBotView view;
	private SWTBotGefEditor editor;
	private SWTBotGefViewer gefViewer;
	@SuppressWarnings("unchecked")
	private final Matcher<Object[]> arrayContainingTextOne = arrayContaining(hasProperty(
			"text", is("one")));
	@SuppressWarnings("unchecked")
	private final Matcher<Object[]> arrayContainingTextTwo = arrayContaining(hasProperty(
			"text", is("two")));

	public static final Bundle bundle = Platform
			.getBundle("com.vectorsf.jvoice.diagram.core.test");

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

		SWTBotHelper.openView(bot, "IVR", "Navigator IVR");

		view = bot.viewById(NAVIGATOR_ID);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bot.viewById(NAVIGATOR_ID).close();
		if (editor != null) {
			editor.close();
		}

		for (IProject project : ResourcesPlugin.getWorkspace().getRoot()
				.getProjects()) {

			try {
				deleteProject(project);
			} catch (CoreException ce) {
				ce.printStackTrace();
				fail(ce.getMessage());
			}
		}
	}

	private void openFile(final IFile file) {
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

	private Matcher<Iterable<? super State>> hasStateNamed(String stateName) {
		return Matchers.<State> hasItem(hasProperty("name", is(stateName)));
	}

	@Test
	public void testOpenCallFlow() throws Exception {
		openState("empty", 425, 65);
	}

	@Test
	public void testOpenMenu() throws Exception {
		openState("Menu", 305, 275);
	}

	@Test
	public void testOpenInput() throws Exception {
		openState("Input", 265, 175);
	}

	@Test
	public void testOpenPrompt() throws Exception {
		openState("Prompt", 90, 175);
	}

	public void openState(final String stateName, final int x, final int y)
			throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/six.jvflow",
				getInputStreamResource(bundle, "six.jvflow"));
		createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/empty.jvflow",
				getInputStreamResource(bundle, "empty.jvflow"));
		createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Menu.voiceDsl",
				getInputStreamResource(bundle, "Menu.voiceDsl"));
		createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Input.voiceDsl",
				getInputStreamResource(bundle, "Input.voiceDsl"));
		createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Prompt.voiceDsl",
				getInputStreamResource(bundle, "Prompt.voiceDsl"));
		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		gefViewer = editor.getSWTBotGefViewer();

		SWTBotGefEditPart entity = editor.getEditPart(stateName);

		syncExec(new VoidResult() {

			@Override
			public void run() {

				IDiagramContainerUI diagramEditor = (IDiagramContainerUI) editor
						.getReference().getEditor(true);
				diagramEditor.getDiagramBehavior().getMouseLocation().x = x;
				diagramEditor.getDiagramBehavior().getMouseLocation().y = y;
				editor.select(stateName);
			}
		});
		bot.sleep(LARGE_SLEEP);
		editor.doubleClick(stateName);
		if (stateName != "empty") {
			bot.waitUntil(shellIsActive("Add Xtext Nature"), 10000);
			if (shellIsActive("Add Xtext Nature") != null) {
				SWTBotShell shell = bot.shell("Add Xtext Nature");
				shell.bot().button("Yes").click();
			}
		}

		editor.save();

		SWTBotShell[] shells = bot.shells();
		boolean hasShell = false;
		for (int i = 0; i < shells.length; i++) {
			if (shells[i].isOpen()) {
				SWTBotShell shell = shells[i];
				if (shell.getText().contains(stateName)) {
					hasShell = true;
				}
			}
		}
		assertThat(hasShell, is(true));
	}

	public SWTBotGefEditor getGefEditor() {
		SWTBotEditor activeEditor = bot.activeEditor();
		String title = activeEditor.getTitle();
		SWTBotGefEditor ed = bot.gefEditor(title);
		return ed;
	}

}
