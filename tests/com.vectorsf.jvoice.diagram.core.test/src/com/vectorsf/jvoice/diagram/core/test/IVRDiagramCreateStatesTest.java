package com.vectorsf.jvoice.diagram.core.test;

import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.getInputStreamResource;
import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellIsActive;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefViewer;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
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
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;

/**
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class IVRDiagramCreateStatesTest {

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

		SWTBotShell[] shells = bot.shells();
		for (int i = 0; i < shells.length; i++) {
			if (shells[i].isOpen()) {
				SWTBotShell shell = shells[i];
				if (shell.getText().contains("Input")
						|| shell.getText().contains("Menu")
						|| shell.getText().contains("Flow")
						|| shell.getText().contains("Menu")) {
					shell.close();
				}
			}
		}

		for (IProject project : ResourcesPlugin.getWorkspace().getRoot()
				.getProjects()) {

			try {
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
			} catch (CoreException ce) {
				ce.printStackTrace();
				fail(ce.getMessage());
			}
		}
	}

	@Test
	public void testCreateCallFlowState() throws CoreException {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		IFile file = null;
		try {
			createFile(project, BaseModel.JV_PATH
					+ "/several/packages/inside/five.jvflow",
					getInputStreamResource(bundle, "five.jvflow"));
			file = createFile(project, BaseModel.JV_PATH
					+ "/several/packages/inside/empty.jvflow",
					getInputStreamResource(bundle, "empty.jvflow"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		gefViewer = editor.getSWTBotGefViewer();

		gefViewer.activateTool("SubFlow");
		gefViewer.drag(55, 55, 150, 100);

		bot.waitUntil(Conditions.shellIsActive("Flow Selection"));
		bot.sleep(LARGE_SLEEP);
		SWTBotTreeItem selected = bot.tree()
				.expandNode("testNavigator", "several.packages.inside", "five")
				.select();
		selected.doubleClick();
		editor.save();

		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		Flow flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);

		Matcher<Iterable<? super State>> hasItemWithNameStateName = hasStateNamed("five");
		assertThat(flow.getStates(), hasItemWithNameStateName);

	}

	@Test
	public void testCreateCallState() throws Exception {
		createState("Call");
	}

	@Test
	public void testCreateSwitchState() throws Exception {
		createState("Switch");
	}

	@Test
	public void testCreateInitialState() throws Exception {
		createState("Initial");
	}

	@Test
	public void testCreateFinalState() throws Exception {
		createState("Final");
	}

	public void createState(String stateName) throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		final IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/empty.jvflow",
				getInputStreamResource(bundle, "empty.jvflow"));

		bot.sleep(SMALL_SLEEP);

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
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		gefViewer = editor.getSWTBotGefViewer();

		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		Flow flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);

		Matcher<Iterable<? super State>> hasItemWithNameStateName = hasStateNamed(stateName);
		assertThat(flow.getStates(), not(hasItemWithNameStateName));

		gefViewer.activateTool(stateName);
		gefViewer.drag(55, 55, 150, 100);
		editor.save();
		assertThat(flow.getStates(), hasItemWithNameStateName);

		if (stateName.equals("Initial")) {
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
			bot.sleep(LARGE_SLEEP);

			editor = getGefEditor();
			gefViewer = editor.getSWTBotGefViewer();

			diaEditor = (DiagramEditor) editor.getReference().getEditor(true);
			diagram = diaEditor.getDiagramTypeProvider().getDiagram();
			flow = (Flow) Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(diagram);

			hasItemWithNameStateName = hasStateNamed(stateName);
			assertThat(flow.getStates(), hasItemWithNameStateName);

			gefViewer.activateTool(stateName);
			gefViewer.drag(55, 55, 150, 100);
			editor.save();
			boolean exists = false;
			boolean exists2Initial = false;
			for (State state : flow.getStates()) {
				if (state instanceof InitialState) {
					if (exists == true) {
						exists2Initial = true;
					}
				}
			}
			assertThat(exists2Initial, is(false));
		}

	}

	@Test
	public void testCreatePromptState() throws Exception {
		createLocutionState("Output");
	}

	@Test
	public void testCreateInputState() throws Exception {
		createLocutionState("Input");
	}

	@Test
	public void testCreateMenuState() throws Exception {
		createLocutionState("Menu");
	}

	@Test
	public void testCancelCreatePromptState() throws Exception {
		cancelCreateLocutionState("Output");
	}

	@Test
	public void testCancelCreateInputState() throws Exception {
		cancelCreateLocutionState("Input");
	}

	@Test
	public void testCancelCreateMenuState() throws Exception {
		cancelCreateLocutionState("Menu");
	}

	public void createLocutionState(String stateName) throws Exception {

		IProject project = createProject("testNavigator");
		final IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				getInputStreamResource(bundle, "five.jvflow"));
		createFile(project, BaseModel.JV_PATH + "/several/packages/inside/"
				+ stateName + ".voiceDsl",
				getInputStreamResource(bundle, stateName + ".voiceDsl"));

		bot.sleep(LARGE_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"),
				is(not(nullValue())));
		assertThat(
				view.bot().tree()
						.expandNode("testNavigator", "several.packages.inside")
						.getItems(), is(not(nullValue())));
		JVBean bean = BaseModel.getInstance().getModel()
				.getProject("testNavigator")
				.getPackage("several.packages.inside").getBean("five");
		assertThat(bean, is(instanceOf(Flow.class)));
		Flow flow = (Flow) bean;

		Matcher<Iterable<? super State>> hasItemWithNameStateName = hasStateNamed(stateName);
		assertThat(flow.getStates(), not(hasItemWithNameStateName));

		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();

		SWTBotGefViewer gefViewer = editor.getSWTBotGefViewer();

		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);
		assertThat(flow.getStates(), not(hasItemWithNameStateName));

		gefViewer = editor.getSWTBotGefViewer();

		gefViewer.activateTool(stateName);
		gefViewer.drag(55, 55, 150, 100);
		bot.sleep(SMALL_SLEEP);

		bot.waitUntil(shellIsActive(stateName + " Selection"), 10000);
		SWTBotShell shell = bot.shell(stateName + " Selection");

		shell.bot().tree()
				.expandNode("testNavigator", "several.packages.inside")
				.getNode(stateName).select();
		shell.bot().button("OK").click();

		editor.save();

		assertThat(flow.getStates(), hasItemWithNameStateName);

	}

	public void cancelCreateLocutionState(String stateName) throws Exception {

		IProject project = createProject("testNavigator");
		final IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				getInputStreamResource(bundle, "five.jvflow"));
		createFile(project, BaseModel.JV_PATH + "/several/packages/inside/"
				+ stateName + ".voiceDsl",
				getInputStreamResource(bundle, stateName + ".voiceDsl"));

		bot.sleep(LARGE_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().getTreeItem("testNavigator"),
				is(not(nullValue())));
		assertThat(
				view.bot().tree()
						.expandNode("testNavigator", "several.packages.inside")
						.getItems(), is(not(nullValue())));
		JVBean bean = BaseModel.getInstance().getModel()
				.getProject("testNavigator")
				.getPackage("several.packages.inside").getBean("five");
		assertThat(bean, is(instanceOf(Flow.class)));
		Flow flow = (Flow) bean;

		Matcher<Iterable<? super State>> hasItemWithNameStateName = hasStateNamed(stateName);
		assertThat(flow.getStates(), not(hasItemWithNameStateName));

		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();

		SWTBotGefViewer gefViewer = editor.getSWTBotGefViewer();

		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);
		assertThat(flow.getStates(), not(hasItemWithNameStateName));

		gefViewer = editor.getSWTBotGefViewer();
		gefViewer.activateTool(stateName);
		gefViewer.drag(55, 55, 150, 100);

		bot.waitUntil(shellIsActive(stateName + " Selection"), 10000);
		SWTBotShell shell = bot.shell(stateName + " Selection");

		shell.bot().button("Cancel").click();

		assertThat(flow.getStates(), not(hasItemWithNameStateName));

		editor.save();
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

	public SWTBotGefEditor getGefEditor() {
		SWTBotEditor activeEditor = bot.activeEditor();
		String title = activeEditor.getTitle();
		SWTBotGefEditor ed = bot.gefEditor(title);
		return ed;
	}

}
