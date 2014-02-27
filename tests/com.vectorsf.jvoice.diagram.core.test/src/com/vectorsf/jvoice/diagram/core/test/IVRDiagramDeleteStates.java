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
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.fail;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
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
public class IVRDiagramDeleteStates {

	private static final int SMALL_SLEEP = 200;
	private static final int LARGE_SLEEP = 1000;
	private static final String NAVIGATOR_ID = "com.vectorsf.jvoice.ui.navigator.ViewIVR";
	private static final String PROJECT_NAME = "testProject";
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
	public void testCancelDeleteFinalState() throws Exception {
		cancelDeleteState("FinalState");

	}

	@Test
	public void testCancelDeleteSwitchState() throws Exception {
		cancelDeleteState("Switch");
	}

	@Test
	public void testCancelDeleteCallState() throws Exception {
		cancelDeleteState("Subflow");
	}

	@Test
	public void testCancelDeleteCustom() throws Exception {
		cancelDeleteState("Custom");
	}

	@Test
	public void testCancelDeleteCallFlowState() throws Exception {
		cancelDeleteState("Call");
	}

	@Test
	public void testCancelDeleteOutput() throws Exception {
		cancelDeleteState("Output");
	}

	@Test
	public void testCancelDeleteInput() throws Exception {
		cancelDeleteState("Input");
	}

	@Test
	public void testCancelDeleteMenu() throws Exception {
		cancelDeleteState("Menu");
	}

	@Test
	public void testCancelDeleteTransfer() throws Exception {
		cancelDeleteState("Transfer");
	}

	@Test
	public void testCancelDeleteRecord() throws Exception {
		cancelDeleteState("Record");
	}

	@Test
	public void testDeleteFinalState() throws Exception {
		deleteState("FinalState");

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
		deleteState("Subflow");
	}

	@Test
	public void testDeleteTransfer() throws Exception {
		deleteState("Transfer");
	}

	@Test
	public void testDeleteCustom() throws Exception {
		deleteState("Custom");
	}

	@Test
	public void testDeleteRecord() throws Exception {
		deleteState("Record");
	}

	@Test
	public void testDeleteInput() throws Exception {
		deleteState("Input");
	}

	@Test
	public void testDeleteMenu() throws Exception {
		deleteState("Menu");
	}

	@Test
	public void testDeleteOutput() throws Exception {
		deleteState("Output");
	}

	public void deleteState(final String stateName) throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		// Creamos el proyecto
		IProject project = createProject(PROJECT_NAME);
		IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/deleteCancel.jvflow",
				getInputStreamResource(bundle, "flows/deleteCancel.jvflow"));
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

		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		gefViewer = editor.getSWTBotGefViewer();

		SWTBotGefEditPart entity = editor.getEditPart(stateName);

		syncExec(new VoidResult() {

			@Override
			public void run() {

				// Recuperamos la figura asociada el estado que queremos copiar
				// para poner el ratón sobre la figura y poder seleccionarlo.
				// Esto es necesario por la implementación de graphiti.
				SWTBotGefEditPart entity = editor.getEditPart(stateName);
				final IFigure figure = ((GraphicalEditPart) entity.part())
						.getFigure();
				final Rectangle bounds = figure.getBounds().getCopy();
				figure.translateToAbsolute(bounds);

				IDiagramContainerUI diagramEditor = (IDiagramContainerUI) editor
						.getReference().getEditor(true);
				diagramEditor.getDiagramBehavior().getMouseLocation().x = bounds.x;
				diagramEditor.getDiagramBehavior().getMouseLocation().y = bounds.y;

				editor.select(stateName);

			}
		});

		SWTBotGefEditor stateEditor = editor.select(stateName);
		if (stateName.equals("Switch")) {
			assertThat(stateEditor.clickContextMenu("Delete"),
					hasProperty("active", is(false)));

		} else {
			stateEditor.clickContextMenu("Delete");

			bot.waitUntil(shellIsActive("Confirm Delete"), 20000);
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
			Matcher<Iterable<? super Transition>> hasTransitionWithState = hasTransitionWithState(stateName);
			assertThat(flow.getTransitions(), not(hasTransitionWithState));

		}

	}

	private Matcher<Iterable<? super Transition>> hasTransitionWithState(
			String stateName) {
		return Matchers.<Transition> hasItem(either(
				hasProperty("source", hasProperty("name", is(stateName)))).or(
				hasProperty("target", hasProperty("name", is(stateName)))));
	}

	public void cancelDeleteState(final String stateName) throws Exception {

		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/deleteCancel.jvflow",
				getInputStreamResource(bundle, "flows/deleteCancel.jvflow"));
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

		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		gefViewer = editor.getSWTBotGefViewer();

		boolean checkTransitions = false;
		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		Flow flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);
		for (State state : flow.getStates()) {
			if (state.getIncomingTransitions() != null
					|| state.getOutgoingTransitions() != null) {
				checkTransitions = true;
			}
		}
		SWTBotGefEditPart entity = editor.getEditPart(stateName);

		syncExec(new VoidResult() {

			@Override
			public void run() {

				// Recuperamos la figura asociada el estado que queremos copiar
				// para poner el ratón sobre la figura y poder seleccionarlo.
				// Esto es necesario por la implementación de graphiti.
				SWTBotGefEditPart entity = editor.getEditPart(stateName);
				final IFigure figure = ((GraphicalEditPart) entity.part())
						.getFigure();
				final Rectangle bounds = figure.getBounds().getCopy();
				figure.translateToAbsolute(bounds);

				IDiagramContainerUI diagramEditor = (IDiagramContainerUI) editor
						.getReference().getEditor(true);
				diagramEditor.getDiagramBehavior().getMouseLocation().x = bounds.x;
				diagramEditor.getDiagramBehavior().getMouseLocation().y = bounds.y;

				editor.select(stateName);

			}
		});

		SWTBotGefEditor stateEditor = editor.select(stateName);
		if (stateName.equals("Switch")) {
			assertThat(stateEditor.clickContextMenu("Delete"),
					hasProperty("active", is(false)));

		} else {
			stateEditor.clickContextMenu("Delete");

			bot.waitUntil(shellIsActive("Confirm Delete"), 20000);
			SWTBotShell shell = bot.shell("Confirm Delete");

			shell.bot().button("No").click();

			entity = editor.getEditPart(stateName);

			assertThat(entity, notNullValue());

			editor.save();

			diaEditor = (DiagramEditor) editor.getReference().getEditor(true);
			diagram = diaEditor.getDiagramTypeProvider().getDiagram();
			flow = (Flow) Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(diagram);
			Matcher<Iterable<? super State>> hasItemWithNameStateName = hasStateNamed(stateName);
			assertThat(flow.getStates(), hasItemWithNameStateName);
			if (checkTransitions) {
				Matcher<Iterable<? super Transition>> hasTransitionWithState = hasTransitionWithState(stateName);
				assertThat(flow.getTransitions(), hasTransitionWithState);
			}
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