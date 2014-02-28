package com.vectorsf.jvoice.diagram.core.test;

import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.getInputStreamResource;
import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.asyncExec;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.fail;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.graphiti.ui.internal.contextbuttons.ContextButton;
import org.eclipse.graphiti.ui.internal.contextbuttons.ContextButtonPad;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osgi.framework.Bundle;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.base.test.SWTBotHelper;
import com.vectorsf.jvoice.model.operations.Flow;
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
	public static final Bundle bundle = Platform
			.getBundle("com.vectorsf.jvoice.diagram.core.test");

	private static final String COMPONENTS_PATH = "/com/isb/testNavigator/components/";

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

	@Test
	public void testCreateTransitionCallSubflow() throws Exception {
		createTransition("test", "empty", 120, 90, 120, 170);
	}

	@Test
	@Ignore
	public void testCreateTransitionSubflowTransfer() throws Exception {
		createTransition("empty", "Transfer", 80, 200, 120, 270);
	}

	@Test
	@Ignore
	public void testCreateTransitionTransferOutput() throws Exception {
		createTransition("Transfer", "Output", 120, 290, 310, 270);
	}

	@Test
	@Ignore
	public void testCreateTransitionOutputMenu() throws Exception {
		createTransition("Output", "Menu", 320, 290, 325, 170);
	}

	@Test
	@Ignore
	public void testCreateTransitionMenuSwitch() throws Exception {
		createTransition("Menu", "Switch", 240, 200, 325, 70);
	}

	@Test
	@Ignore
	public void testCreateTransitionSwitchInput() throws Exception {
		createTransition("Switch", "Input", 240, 90, 570, 70);
	}

	@Test
	@Ignore
	public void testCreateTransitionInputRecord() throws Exception {
		createTransition("Input", "Record", 90, 570, 170, 570);
	}

	@Test
	@Ignore
	public void testCreateTransitionRecordCustom() throws Exception {
		createTransition("Record", "Custom", 570, 200, 370, 570);
	}

	@Test
	@Ignore
	public void testCreateTransitionCustomFinal() throws Exception {
		createTransition("Custom", "Final", 570, 290, 400, 370);
	}

	public void createTransition(final String sourceName, String targetName,
			final int initialx, final int initialy, final int finalx,
			final int finaly) throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		IFile file;
		file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/ConnectionState.jvflow",
				getInputStreamResource(bundle, "flows/ConnectionState.jvflow"));
		createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/empty.jvflow",
				getInputStreamResource(bundle, "flows/empty.jvflow"));
		createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Menu.voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/Menu.voiceDsl"));
		createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Input.voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/Input.voiceDsl"));
		createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Output.voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/Output.voiceDsl"));
		createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Record.voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/Record.voiceDsl"));
		createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Transfer.voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/Transfer.voiceDsl"));
		createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/Custom.jsp",
				getInputStreamResource(bundle, "jsps/Custom.jsp"));
		createFile(project, BaseModel.JAVA_SOURCES_PATH + COMPONENTS_PATH
				+ "TestExecute.java",
				getInputStreamResource(bundle, "components/TestExecute.java"));

		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		editor.getSWTBotGefViewer();

		IDiagramContainerUI diagramEditor = (IDiagramContainerUI) editor
				.getReference().getEditor(true);
		diagramEditor.getDiagramBehavior().getMouseLocation().x = initialx;
		diagramEditor.getDiagramBehavior().getMouseLocation().y = initialy;

		editor.drag(initialx, initialy, finalx, finaly);
		diagramEditor.getDiagramBehavior().getMouseLocation().x = finalx;
		diagramEditor.getDiagramBehavior().getMouseLocation().y = finaly;
		editor.click(finalx, finaly);
		bot.sleep(LARGE_SLEEP);
		//
		// syncExec(new VoidResult() {
		//
		// @Override
		// public void run() {
		// IDiagramContainerUI diagramEditor = (IDiagramContainerUI) editor
		// .getReference().getEditor(true);
		// diagramEditor.getDiagramBehavior().getMouseLocation().x = initialx;
		// diagramEditor.getDiagramBehavior().getMouseLocation().y = initialy;
		//
		// GraphicalViewer graphicalViewer = (GraphicalViewer) diagramEditor
		// .getAdapter(GraphicalViewer.class);
		// final Control control = graphicalViewer.getControl();
		// assertThat(control, instanceOf(FigureCanvas.class));
		// final FigureCanvas canvas = (FigureCanvas) control;
		// try {
		// Point p = canvas.toDisplay(0, 0);
		// Robot robot = new Robot();
		// robot.mouseMove(p.x + initialx, p.y + initialy);
		//
		// } catch (AWTException e) {
		// }
		// }
		// });
		// bot.sleep(LARGE_SLEEP);
		// syncExec(new VoidResult() {
		//
		// @Override
		// public void run() {
		// IDiagramContainerUI diagramEditor = (IDiagramContainerUI) editor
		// .getReference().getEditor(true);
		// diagramEditor.getDiagramBehavior().getMouseLocation().x = initialx;
		// diagramEditor.getDiagramBehavior().getMouseLocation().y = initialy;
		//
		// GraphicalViewer graphicalViewer = (GraphicalViewer) diagramEditor
		// .getAdapter(GraphicalViewer.class);
		// final Control control = graphicalViewer.getControl();
		// assertThat(control, instanceOf(FigureCanvas.class));
		// final FigureCanvas canvas = (FigureCanvas) control;
		// try {
		// Point p = canvas.toDisplay(0, 0);
		// Robot robot = new Robot();
		// robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		//
		// robot.mouseMove(p.x + finalx, p.y + finaly);
		// // bot.sleep(SMALL_SLEEP);
		// robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		// } catch (AWTException e) {
		// }
		// }
		// });

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
