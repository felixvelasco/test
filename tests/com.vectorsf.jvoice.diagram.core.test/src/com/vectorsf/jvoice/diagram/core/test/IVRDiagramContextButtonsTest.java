package com.vectorsf.jvoice.diagram.core.test;

import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.getInputStreamResource;
import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.asyncExec;
import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.syncExec;
import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellIsActive;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.graphiti.ui.internal.contextbuttons.ContextButton;
import org.eclipse.graphiti.ui.internal.contextbuttons.ContextButtonPad;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
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
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

/**
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class IVRDiagramContextButtonsTest {

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
	public void testRemoveFinalState() throws Exception {
		removeState("Final");

	}

	@Test
	public void testRemoveInitialState() throws Exception {
		removeState("Initial");

	}

	@Test
	public void testRemoveSwitchState() throws Exception {
		removeState("Switch");
	}

	@Test
	public void testRemoveCallState() throws Exception {
		removeState("Call");
	}

	@Test
	public void testRemoveCallFlowState() throws Exception {
		removeState("empty");
	}

	@Test
	public void testCancelDeleteFinalState() throws Exception {
		cancelDeleteState("Final");

	}

	@Test
	public void testCancelDeleteInitialState() throws Exception {
		cancelDeleteState("Initial");

	}

	@Test
	public void testCancelDeleteSwitchState() throws Exception {
		cancelDeleteState("Switch");
	}

	@Test
	public void testCancelDeleteCallState() throws Exception {
		cancelDeleteState("Call");
	}

	@Test
	public void testCancelDeleteCallFlowState() throws Exception {
		cancelDeleteState("empty");
	}

	@Test
	public void testDeleteFinalState() throws Exception {
		deleteState("Final");

	}

	@Test
	public void testDeleteInitialState() throws Exception {
		deleteState("Initial");

	}

	@Test
	public void testDeleteSwitchState() throws Exception {
		deleteState("Switch");
	}

	@Test
	public void testDeleteCallState() throws Exception {
		deleteState("Call");
	}

	@Test
	public void testDeleteCallFlowState() throws Exception {
		deleteState("empty");
	}

	@Test
	public void testCreateTransitionCallPrompt() throws Exception {
		createTransition("Call", "Prompt", 375, 79, 116, 210);
	}

	@Test
	public void testCreateTransitionPromptMenu() throws Exception {
		createTransition("Prompt", "Menu", 221, 185, 330, 310);
	}

	@Test
	public void testCreateTransitionInputMenu() throws Exception {
		createTransition("Input", "Menu", 400, 185, 330, 310);
	}

	@Test
	public void testCreateTransitionEmptyPrompt() throws Exception {
		createTransition("empty", "Prompt", 550, 70, 116, 210);
	}

	@Test
	public void testCreateTransitionSwitchFinal() throws Exception {
		createTransition("Switch", "Final", 550, 185, 141, 336);
	}

	@Test
	public void testCreateTransitionMenuInput() throws Exception {
		createTransition("Menu", "Input", 425, 278, 320, 210);
	}

	@Test
	public void testCreateTransitionInitialPrompt() throws Exception {
		createTransition("Initial", "Prompt", 181, 81, 120, 210);
	}

	public void createTransition(final String sourceName, String targetName,
			final int initialx, final int initialy, final int finalx,
			final int finaly) throws Exception {
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
		SWTBotGefEditPart entity = editor.getEditPart(sourceName);
		entity.click();
		syncExec(new VoidResult() {

			@Override
			public void run() {
				IDiagramContainerUI diagramEditor = (IDiagramContainerUI) editor
						.getReference().getEditor(true);
				diagramEditor.getDiagramBehavior().getMouseLocation().x = initialx;
				diagramEditor.getDiagramBehavior().getMouseLocation().y = initialy;

				GraphicalViewer graphicalViewer = (GraphicalViewer) diagramEditor
						.getAdapter(GraphicalViewer.class);
				final Control control = graphicalViewer.getControl();
				assertThat(control, instanceOf(FigureCanvas.class));
				final FigureCanvas canvas = (FigureCanvas) control;
				try {
					Point p = canvas.toDisplay(0, 0);
					Robot robot = new Robot();
					robot.mouseMove(p.x + initialx, p.y + initialy);

				} catch (AWTException e) {
				}
			}
		});
		bot.sleep(LARGE_SLEEP);
		syncExec(new VoidResult() {

			@Override
			public void run() {
				IDiagramContainerUI diagramEditor = (IDiagramContainerUI) editor
						.getReference().getEditor(true);
				diagramEditor.getDiagramBehavior().getMouseLocation().x = initialx;
				diagramEditor.getDiagramBehavior().getMouseLocation().y = initialy;

				GraphicalViewer graphicalViewer = (GraphicalViewer) diagramEditor
						.getAdapter(GraphicalViewer.class);
				final Control control = graphicalViewer.getControl();
				assertThat(control, instanceOf(FigureCanvas.class));
				final FigureCanvas canvas = (FigureCanvas) control;
				try {
					Point p = canvas.toDisplay(0, 0);
					Robot robot = new Robot();
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

					robot.mouseMove(p.x + finalx, p.y + finaly);

					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				} catch (AWTException e) {
				}
			}
		});

		editor.save();

		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		Flow flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);

		Matcher<Iterable<? super Transition>> hasTransition = hasTransition(
				sourceName, targetName);

		assertThat(flow.getTransitions(), hasTransition);

	}

	private Matcher<Iterable<? super Transition>> hasTransition(
			String sourceName, String targetName) {
		return Matchers
				.<Transition> hasItem(both(
						hasProperty("source",
								hasProperty("name", is(sourceName)))).and(
						hasProperty("target",
								hasProperty("name", is(targetName)))));
	}

	public void deleteState(String stateName) throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				getInputStreamResource(bundle, "five.jvflow"));
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
		entity.click();
		pressEntityContextButton(entity, "Delete");

		bot.waitUntil(shellIsActive("Confirm Delete"), 10000);
		SWTBotShell shell = bot.shell("Confirm Delete");

		shell.bot().button("Yes").click();

		bot.sleep(SMALL_SLEEP);
		entity = editor.getEditPart(stateName);

		assertThat(entity, nullValue());
		editor.save();
		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		Flow flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);

		Matcher<Iterable<? super State>> hasItemWithNameStateName = hasStateNamed(stateName);
		assertThat(flow.getStates(), not(hasItemWithNameStateName));

	}

	public void cancelDeleteState(String stateName) throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				getInputStreamResource(bundle, "five.jvflow"));
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
		entity.click();
		pressEntityContextButton(entity, "Delete");

		bot.waitUntil(shellIsActive("Confirm Delete"), 10000);
		SWTBotShell shell = bot.shell("Confirm Delete");

		shell.bot().button("No").click();

		entity = editor.getEditPart(stateName);

		assertThat(entity, notNullValue());

		editor.save();
		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		Flow flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);

		Matcher<Iterable<? super State>> hasItemWithNameStateName = hasStateNamed(stateName);
		assertThat(flow.getStates(), hasItemWithNameStateName);

	}

	public void removeState(String stateName) throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/five.jvflow",
				getInputStreamResource(bundle, "five.jvflow"));
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
		entity.click();
		pressEntityContextButton(entity, "Remove");

		bot.sleep(SMALL_SLEEP);
		entity = editor.getEditPart(stateName);

		assertThat(entity, nullValue());
		editor.save();
		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		Flow flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);

		Matcher<Iterable<? super State>> hasItemWithNameStateName = hasStateNamed(stateName);
		assertThat(flow.getStates(), hasItemWithNameStateName);

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
		assertThat(contextButtonPad, notNullValue());
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
