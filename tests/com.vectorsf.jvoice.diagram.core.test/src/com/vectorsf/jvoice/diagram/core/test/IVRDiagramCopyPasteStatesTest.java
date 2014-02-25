package com.vectorsf.jvoice.diagram.core.test;

import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.getInputStreamResource;
import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.syncExec;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
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
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

/**
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class IVRDiagramCopyPasteStatesTest {

	private static final int LARGE_SLEEP = 1000;
	private static final String NAVIGATOR_ID = "com.vectorsf.jvoice.ui.navigator.ViewIVR";
	protected static SWTGefBot bot = new SWTGefBot();
	private SWTBotView view;
	private SWTBotGefEditor editor;
	private IProject project;
	private IFile flowFile;

	public static final Bundle bundle = Platform
			.getBundle("com.vectorsf.jvoice.diagram.core.test");

	private static final String PROJECT_NAME = "testNavigator";
	private static final String PACKAGE_PATH = "/several/packages/inside/";
	private static final String FLOW_NAME = "everyState.jvflow";
	private static final String FLOW_RESOURCES_FOLDER = "everyState.resources/";

	// Nombres de los estados del flujo de prueba.
	private static final String OUTPUT_STATE_NAME = "Output";
	private static final String INPUT_STATE_NAME = "Input";
	private static final String MENU_STATE_NAME = "Menu";
	private static final String RECORD_STATE_NAME = "Record";
	private static final String TRANSFER_STATE_NAME = "Transfer";
	private static final String CUSTOM_STATE_NAME = "Custom";
	private static final String EXECUTE_STATE_NAME = "test";
	private static final String SUBFLOW_STATE_NAME = "empty";
	private static final String FINAL_STATE_NAME = "Final";
	private static final String INITIAL_STATE_NAME = "Initial";
	private static final String SWITCH_STATE_NAME = "Switch";

	// Nombres de los resources asociados a los estados del flujo de prueba.
	private static final String OUTPUT_RES_NAME = "Output";
	private static final String INPUT_RES_NAME = "Input";
	private static final String MENU_RES_NAME = "Menu";
	private static final String RECORD_RES_NAME = "Record";
	private static final String TRANSFER_RES_NAME = "Transfer";
	private static final String CUSTOM_RES_NAME = "Custom";
	private static final String EXECUTE_RES_NAME = "TestExecute";
	private static final String SUBFLOW_RES_NAME = "empty";

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

		// Comprobamos que al empezar el test no haya ningún proyecto creado.
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		// Creamos el proyecto de prueba
		project = createProject(PROJECT_NAME);

		// Creamos el flujo de prueba
		flowFile = createFile(project, BaseModel.JV_PATH + PACKAGE_PATH
				+ FLOW_NAME,
				getInputStreamResource(bundle, "flows/" + FLOW_NAME));

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
	public void testCopyPasteSubflow() throws Exception {

		// Creamos el recurso asociado al estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + SUBFLOW_RES_NAME + ".jvflow",
				getInputStreamResource(bundle, "flows/" + SUBFLOW_RES_NAME
						+ ".jvflow"));

		copyPasteState(1, SUBFLOW_STATE_NAME);

		Flow flow = getFlow();

		assertThat(flow.getStates(), hasStateNamed("CopyOf"
				+ SUBFLOW_STATE_NAME));
		// TODO comprobar que se ha copiado el voiceDsl

	}

	@Test
	public void testCopyPasteOutput() throws Exception {

		// Creamos el recurso asociado al estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ OUTPUT_RES_NAME + ".voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/" + OUTPUT_RES_NAME
						+ ".voiceDsl"));

		copyPasteState(1, OUTPUT_STATE_NAME);

		Flow flow = getFlow();

		assertThat(flow.getStates(),
				hasStateNamed("CopyOf" + OUTPUT_STATE_NAME));
		// TODO comprobar que se ha copiado el voiceDsl
	}

	@Test
	public void testCopyPasteMenu() throws Exception {

		// Creamos el recurso asociado al estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ MENU_RES_NAME + ".voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/" + MENU_RES_NAME
						+ ".voiceDsl"));

		copyPasteState(1, MENU_STATE_NAME);

		Flow flow = getFlow();

		assertThat(flow.getStates(), hasStateNamed("CopyOf" + MENU_STATE_NAME));
		// TODO comprobar que se ha copiado el voiceDsl

	}

	@Test
	public void testCopyPasteInput() throws Exception {
		// Creamos el recurso (voiceDsl) asociado al estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ INPUT_RES_NAME + ".voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/" + INPUT_RES_NAME
						+ ".voiceDsl"));

		copyPasteState(1, INPUT_STATE_NAME);

		Flow flow = getFlow();

		assertThat(flow.getStates(), hasStateNamed("CopyOf" + INPUT_STATE_NAME));
		// TODO comprobar que se ha copiado el voiceDsl
	}

	@Test
	public void testCopyPasteRecord() throws Exception {
		// Creamos el recurso (voiceDsl) asociado al estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ RECORD_RES_NAME + ".voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/" + RECORD_RES_NAME
						+ ".voiceDsl"));

		copyPasteState(1, RECORD_STATE_NAME);

		Flow flow = getFlow();

		assertThat(flow.getStates(),
				hasStateNamed("CopyOf" + RECORD_STATE_NAME));
		// TODO comprobar que se ha copiado el voiceDsl
	}

	@Test
	public void testCopyPasteTransfer() throws Exception {
		// Creamos el recurso (voiceDsl) asociado al estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ TRANSFER_RES_NAME + ".voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/" + TRANSFER_RES_NAME
						+ ".voiceDsl"));

		copyPasteState(1, TRANSFER_STATE_NAME);

		Flow flow = getFlow();

		assertThat(flow.getStates(), hasStateNamed("CopyOf"
				+ TRANSFER_STATE_NAME));
		// TODO comprobar que se ha copiado el voiceDsl
	}

	@Test
	public void testCopyPasteCustom() throws Exception {
		// Creamos el recurso (jsp) asociado al estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ CUSTOM_RES_NAME + ".jsp",
				getInputStreamResource(bundle, "jsps/" + CUSTOM_RES_NAME
						+ ".jsp"));

		copyPasteState(1, CUSTOM_STATE_NAME);

		Flow flow = getFlow();

		assertThat(flow.getStates(),
				hasStateNamed("CopyOf" + CUSTOM_STATE_NAME));
		// TODO comprobar que se ha copiado la jsp
	}

	@Test
	public void testCopyPasteExecute() throws Exception {

		copyPasteState(1, EXECUTE_STATE_NAME);

		Flow flow = getFlow();

		assertThat(flow.getStates(), hasStateNamed("CopyOf"
				+ EXECUTE_STATE_NAME));

	}

	@Test
	public void testCopyPasteSwitch() throws Exception {
		copyPasteState(1, SWITCH_STATE_NAME);

		Flow flow = getFlow();

		assertThat(flow.getStates(),
				hasStateNamed("CopyOf" + SWITCH_STATE_NAME));
	}

	@Test
	public void testCopyPasteFinal() throws Exception {

		copyPasteState(1, FINAL_STATE_NAME);

		Flow flow = getFlow();

		assertThat(flow.getStates(), hasStateNamed("CopyOf" + FINAL_STATE_NAME));

	}

	@Test
	public void testCopyPasteInitial() throws Exception {

		copyPasteState(1, INITIAL_STATE_NAME);

		Flow flow = getFlow();

		assertThat(flow.getStates(), not(hasStateNamed("CopyOf"
				+ INITIAL_STATE_NAME)));

	}

	public void copyPasteState(final int numCopies, final String stateName)
			throws Exception {

		openFile(flowFile);

		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();

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

		bot.sleep(LARGE_SLEEP);

		editor.clickContextMenu("Copy");

		for (int i = 0; i < numCopies; i++) {
			editor.click(20, 20);
			editor.clickContextMenu("Paste");
			// TODO si se guarda los tests tardan mucho más. Faltaría comprobar
			// que no
			// sea necesario guardar para que la prueba sea válida.
			// editor.save();
		}
	}

	@Test
	@Ignore
	// TODO
	public void testCopyPasteAllStates() throws Exception {

		openFile(flowFile);

		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();

		final List<SWTBotGefEditPart> elements = new ArrayList<SWTBotGefEditPart>();

		elements.add(editor.getEditPart("Final"));
		elements.add(editor.getEditPart("Call"));
		elements.add(editor.getEditPart("empty"));
		elements.add(editor.getEditPart("Switch"));
		elements.add(editor.getEditPart("Menu"));
		elements.add(editor.getEditPart("Input"));
		elements.add(editor.getEditPart("Prompt"));

		syncExec(new VoidResult() {
			@Override
			public void run() {
				IDiagramContainerUI diagramEditor = (IDiagramContainerUI) editor
						.getReference().getEditor(true);
				diagramEditor.getDiagramBehavior().getMouseLocation().x = 115;
				diagramEditor.getDiagramBehavior().getMouseLocation().y = 80;
				editor.selectedEditParts();
				editor.select(elements);
			}
		});
		bot.sleep(LARGE_SLEEP);

		editor.clickContextMenu("Copy");
		editor.click(20, 20);
		editor.clickContextMenu("Paste");

		editor.save();
		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		Flow flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);
		Matcher<Iterable<? super State>> hasItemWithNameStateName = null;

		hasItemWithNameStateName = hasStateNamed("CopyOfFinal");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("CopyOfempty");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("CopyOfSwitch");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("CopyOfMenu");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("CopyOfCall");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("CopyOfPrompt");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("CopyOfInput");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		Matcher<Iterable<? super Transition>> hasTransition = hasTransition(
				"CopyOfCall", "CopyOfempty");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("CopyOfempty", "CopyOfSwitch");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("CopyOfSwitch", "CopyOfMenu");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("CopyOfSwitch", "CopyOfPrompt");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("CopyOfPrompt", "CopyOfInput");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("CopyOfMenu", "CopyOfFinal");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("CopyOfInput", "CopyOfFinal");
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

	private Matcher<Iterable<? super State>> hasStateNamed(String stateName) {
		return Matchers.<State> hasItem(hasProperty("name", is(stateName)));
	}

	public SWTBotGefEditor getGefEditor() {
		SWTBotEditor activeEditor = bot.activeEditor();
		String title = activeEditor.getTitle();
		SWTBotGefEditor ed = bot.gefEditor(title);
		return ed;
	}

	private Flow getFlow() {

		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		Flow flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);

		return flow;
	}

}