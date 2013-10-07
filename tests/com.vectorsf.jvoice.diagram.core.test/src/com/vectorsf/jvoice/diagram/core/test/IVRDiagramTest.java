package com.vectorsf.jvoice.diagram.core.test;

import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.asyncExec;
import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellIsActive;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.internal.contextbuttons.ContextButton;
import org.eclipse.graphiti.ui.internal.contextbuttons.ContextButtonPad;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
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
import org.eclipse.swtbot.swt.finder.widgets.SWTBotToolbarButton;
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

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.State;

/**
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class IVRDiagramTest {

	private static final int SMALL_SLEEP = 200;
	private static final int LARGE_SLEEP = 100;
	private static final String NAVIGATOR_ID = "com.vectorsf.jvoice.ui.navigator.ViewIVR";
	private static final String DIAGRAM_ID = "org.eclipse.graphiti.ui.editor.DiagramEditor";
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
				SWTBotHelper.deleteProject(project);
			} catch (CoreException ce) {
				ce.printStackTrace();
				fail(ce.getMessage());
			}
		}
	}

	@Test
	public void testCreateCallFlowState() throws CoreException {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/empty.jvflow",
				SWTBotHelper.getInputStreamResource("empty.jvflow"));

		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		gefViewer = editor.getSWTBotGefViewer();

		gefViewer.activateTool("CallFlow");
		gefViewer.drag(55, 55, 150, 100);

		bot.waitUntil(Conditions.shellIsActive("Flow Selection"));
		bot.sleep(LARGE_SLEEP);
		SWTBotTreeItem selected = bot
				.tree()
				.expandNode("testNavigator", "several.packages.inside", "empty")
				.select();
		selected.doubleClick();
		editor.save();

		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		Flow flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);

		Matcher<Iterable<? super State>> hasItemWithNameStateName = hasStateNamed("empty");
		assertThat(flow.getStates(), not(hasItemWithNameStateName));

	}

	@Test
	public void testCreateCallState() throws CoreException {
		createState("Call");
	}

	@Test
	public void testCreateSwitchState() throws CoreException {
		createState("Switch");
	}

	@Test
	public void testCreateInitialState() throws CoreException {
		createState("Initial");
	}

	@Test
	public void testCreateFinalState() throws CoreException {
		createState("Final");
	}

	public void createState(String stateName) throws CoreException {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = SWTBotHelper.createProject("testNavigator");
		final IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/empty.jvflow",
				SWTBotHelper.getInputStreamResource("empty.jvflow"));

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

		assertThat(flow.getStates(), hasItemWithNameStateName);

		editor.save();

	}

	@Test
	public void testCreatePromptState() throws CoreException {
		createLocutionState("Prompt");
	}

	@Test
	public void testCreateInputState() throws CoreException {
		createLocutionState("Input");
	}

	@Test
	public void testCreateMenuState() throws CoreException {
		createLocutionState("Menu");
	}

	public void createLocutionState(String stateName) throws CoreException {

		IProject project = SWTBotHelper.createProject("testNavigator");
		final IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/" + stateName + ".voiceDsl",
				SWTBotHelper.getInputStreamResource(stateName + ".voiceDsl"));

		bot.sleep(SMALL_SLEEP);
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

		gefViewer.activateTool(stateName);
		gefViewer.drag(55, 55, 150, 100);
		bot.sleep(SMALL_SLEEP);

		bot.waitUntil(shellIsActive(stateName + " Selection"), 10000);
		shell = bot.shell(stateName + " Selection");

		shell.bot().tree()
				.expandNode("testNavigator", "several.packages.inside")
				.getNode(stateName).select();
		shell.bot().button("OK").click();

		editor.save();

		assertThat(flow.getStates(), hasItemWithNameStateName);

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
	public void testOpenCallFlow() throws CoreException {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/empty.jvflow",
				SWTBotHelper.getInputStreamResource("empty.jvflow"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Menu.voiceDsl",
				SWTBotHelper.getInputStreamResource("Menu.voiceDsl"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Input.voiceDsl",
				SWTBotHelper.getInputStreamResource("Input.voiceDsl"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Prompt.voiceDsl",
				SWTBotHelper.getInputStreamResource("Prompt.voiceDsl"));
		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		gefViewer = editor.getSWTBotGefViewer();

		editor.getEditPart("empty").activateDirectEdit("empty");
		editor.getEditPart("empty").click();

		editor.save();
	}

	@Test
	public void testDragState() throws CoreException {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));

		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		List<SWTBotToolbarButton> buttons = editor.getToolbarButtons();
		bot.sleep(SMALL_SLEEP);
		editor.drag("Switch", 90, 90);
		bot.sleep(SMALL_SLEEP);

	}

	@Test
	public void testRemoveFinalState() throws CoreException {
		removeState("Final");

	}

	@Test
	public void testRemoveInitialState() throws CoreException {
		removeState("Initial");

	}

	@Test
	public void testRemoveSwitchState() throws CoreException {
		removeState("Switch");
	}

	@Test
	public void testRemoveCallState() throws CoreException {
		removeState("Call");
	}

	@Test
	public void testRemoveCallFlowState() throws CoreException {
		removeState("empty");
	}

	@Test
	public void testDeleteFinalState() throws CoreException {
		deleteState("Final");

	}

	@Test
	public void testDeleteInitialState() throws CoreException {
		deleteState("Initial");

	}

	@Test
	public void testDeleteSwitchState() throws CoreException {
		deleteState("Switch");
	}

	@Test
	public void testDeleteCallState() throws CoreException {
		deleteState("Call");
	}

	@Test
	public void testDeleteCallFlowState() throws CoreException {
		deleteState("empty");
	}

	public void deleteState(String stateName) throws CoreException {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/empty.jvflow",
				SWTBotHelper.getInputStreamResource("empty.jvflow"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Menu.voiceDsl",
				SWTBotHelper.getInputStreamResource("Menu.voiceDsl"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Input.voiceDsl",
				SWTBotHelper.getInputStreamResource("Input.voiceDsl"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Prompt.voiceDsl",
				SWTBotHelper.getInputStreamResource("Prompt.voiceDsl"));

		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		gefViewer = editor.getSWTBotGefViewer();

		SWTBotGefEditPart entity = editor.getEditPart(stateName);
		entity.click();
		pressEntityContextButton(entity, "Delete");

		bot.waitUntil(shellIsActive("Confirm Delete"), 10000);
		SWTBotShell shell = bot.shell("Confirm Delete");

		shell.bot().button("No").click();

		entity = editor.getEditPart(stateName);
		assertNotNull("State must not be deleted", entity);

		pressEntityContextButton(entity, "Delete");

		bot.waitUntil(shellIsActive("Confirm Delete"), 10000);
		shell = bot.shell("Confirm Delete");

		shell.bot().button("Yes").click();

		bot.sleep(SMALL_SLEEP);
		entity = editor.getEditPart(stateName);
		assertNull("State must be deleted", entity);
		editor.save();
		JVModel model = BaseModel.getInstance().getModel();
		JVProject proj = model.getProject("testNavigator");
		JVPackage pack = proj.getPackage("several.packages.inside");
		JVBean bean = pack.getBean("five");
		if (bean instanceof Flow) {
			Flow flow = (Flow) bean;
			List<State> states = flow.getStates();
			boolean exists = false;
			for (State state : states) {
				if (state.getName().equals(stateName)) {
					exists = true;
				}
			}
			assertFalse("State does exist  in model", exists);
		}

	}

	public void removeState(String stateName) throws CoreException {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = SWTBotHelper.createProject("testNavigator");
		IFile file = SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				SWTBotHelper.getInputStreamResource("five.jvflow"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/empty.jvflow",
				SWTBotHelper.getInputStreamResource("empty.jvflow"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Menu.voiceDsl",
				SWTBotHelper.getInputStreamResource("Menu.voiceDsl"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Input.voiceDsl",
				SWTBotHelper.getInputStreamResource("Input.voiceDsl"));
		SWTBotHelper.createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Prompt.voiceDsl",
				SWTBotHelper.getInputStreamResource("Prompt.voiceDsl"));

		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		gefViewer = editor.getSWTBotGefViewer();

		SWTBotGefEditPart entity = editor.getEditPart(stateName);
		entity.click();
		pressEntityContextButton(entity, "Remove");

		bot.sleep(SMALL_SLEEP);
		entity = editor.getEditPart(stateName);
		assertNull("State must be removed", entity);
		editor.save();
		JVModel model = BaseModel.getInstance().getModel();
		JVProject proj = model.getProject("testNavigator");
		JVPackage pack = proj.getPackage("several.packages.inside");
		JVBean bean = pack.getBean("five");
		if (bean instanceof Flow) {
			Flow flow = (Flow) bean;
			List<State> states = flow.getStates();
			boolean exists = false;
			for (State state : states) {
				if (state.getName().equals(stateName)) {
					exists = true;
				}
			}
			assertTrue("State does not exist in model", exists);
		}

	}

	public void pressEntityContextButton(SWTBotGefEditPart part,
			String contextButtonName) {
		pressContextButton(part, contextButtonName);
	}

	private void pressContextButton(SWTBotGefEditPart part,
			String contextButtonName) {
		editor.click(0, 0);
		editor.click(part);

		ContextButtonPad contextButtonPad = getContextButtonPad();
		assertNotNull(contextButtonPad);
		for (final Object button : contextButtonPad.getChildren()) {
			if (((ContextButton) button).getEntry().getText()
					.equals(contextButtonName)) {
				asyncExec(new VoidResult() {
					@Override
					public void run() {
						((ContextButton) button).doClick();

					}
				});
			}
		}
	}

	private ContextButtonPad getContextButtonPad() {
		SWTBotGefEditPart root = editor.rootEditPart();
		IFigure layer = ((ScalableFreeformRootEditPart) root.part())
				.getLayer(LayerConstants.HANDLE_LAYER);
		ContextButtonPad contextButtonPad = null;
		for (Object o : layer.getChildren()) {
			if (o instanceof ContextButtonPad) {
				contextButtonPad = (ContextButtonPad) o;
				break;
			}
		}
		return contextButtonPad;
	}

	public SWTBotGefEditor getGefEditor() {
		SWTBotEditor activeEditor = bot.activeEditor();
		String title = activeEditor.getTitle();
		SWTBotGefEditor ed = bot.gefEditor(title);
		return ed;
	}

}
