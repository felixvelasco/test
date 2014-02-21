package com.vectorsf.jvoice.diagram.core.test;

import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.getInputStreamResource;
import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.syncExec;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;
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
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osgi.framework.Bundle;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.base.test.SWTBotHelper;

/**
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class IVRDiagramOpenStatesTest {

	private static final int LARGE_SLEEP = 1000;
	private static final String NAVIGATOR_ID = "com.vectorsf.jvoice.ui.navigator.ViewIVR";
	protected static SWTGefBot bot = new SWTGefBot();
	private SWTBotView view;
	private SWTBotGefEditor editor;
	private IProject project;
	private IFile flowFile;

	private static final String PROJECT_NAME = "testNavigator";
	private static final String PACKAGE_PATH = "/several/packages/inside/";
	private static final String FLOW_NAME = "everyState.jvflow";
	private static final String FLOW_RESOURCES_FOLDER = "everyState.resources/";
	private static final String COMPONENTS_PATH = "/com/isb/testNavigator/components/";

	// Nombres de los estados del flujo de prueba.
	private static final String OUTPUT_STATE_NAME = "Output";
	private static final String INPUT_STATE_NAME = "Input";
	private static final String MENU_STATE_NAME = "Menu";
	private static final String RECORD_STATE_NAME = "Record";
	private static final String TRANSFER_STATE_NAME = "Transfer";
	private static final String CUSTOM_STATE_NAME = "Custom";
	private static final String EXECUTE_STATE_NAME = "test";
	private static final String SUBFLOW_STATE_NAME = "empty";

	// Nombres de los resources asociados a los estados del flujo de prueba.
	private static final String OUTPUT_RES_NAME = "Output";
	private static final String INPUT_RES_NAME = "Input";
	private static final String MENU_RES_NAME = "Menu";
	private static final String RECORD_RES_NAME = "Record";
	private static final String TRANSFER_RES_NAME = "Transfer";
	private static final String CUSTOM_RES_NAME = "Custom";
	private static final String EXECUTE_RES_NAME = "TestExecute";
	private static final String SUBFLOW_RES_NAME = "empty";

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

		// Comprobamos que al empezar el test no haya ningún proyecto creado.
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		// Cremos el proyecto de prueba
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
	public void testOpenSubflow() throws Exception {

		// Creamos el recurso que debe abrirse al abrir (doble-click) el estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + SUBFLOW_RES_NAME + ".jvflow",
				getInputStreamResource(bundle, "flows/" + SUBFLOW_RES_NAME
						+ ".jvflow"));

		// Abrimos el estado
		openState(SUBFLOW_STATE_NAME);

		// Comprobamos que se ha abierto el recurso asociado al estado
		assertThat(isOpen(SUBFLOW_RES_NAME), is(true));

	}

	@Test
	public void testOpenMenu() throws Exception {

		// Creamos el recurso que debe abrirse al abrir (doble-click) el estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ MENU_RES_NAME + ".voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/" + MENU_RES_NAME
						+ ".voiceDsl"));
		// Abrimos el estado
		openState(MENU_STATE_NAME);

		// Comprobamos que se ha abierto el recurso asociado al estado
		assertThat(isOpen(MENU_RES_NAME), is(true));

	}

	@Test
	public void testOpenInput() throws Exception {

		// Creamos el recurso que debe abrirse al abrir (doble-click) el estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ INPUT_RES_NAME + ".voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/" + INPUT_RES_NAME
						+ ".voiceDsl"));

		// Abrimos el estado
		openState(INPUT_STATE_NAME);

		// Comprobamos que se ha abierto el recurso asociado al estado
		assertThat(isOpen(INPUT_RES_NAME), is(true));

	}

	@Test
	public void testOpenOutput() throws Exception {

		// Creamos el recurso que debe abrirse al abrir (doble-click) el estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ OUTPUT_RES_NAME + ".voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/" + OUTPUT_RES_NAME
						+ ".voiceDsl"));

		// Abrimos el estado
		openState(OUTPUT_STATE_NAME);

		// Comprobamos que se ha abierto el recurso asociado al estado
		assertThat(isOpen(OUTPUT_RES_NAME), is(true));

	}

	@Test
	public void testOpenRecord() throws Exception {

		// Creamos el recurso que debería abrirse al abrir (doble-click) el
		// estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ RECORD_RES_NAME + ".voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/" + RECORD_RES_NAME
						+ ".voiceDsl"));
		// Abrimos el estado
		openState(RECORD_STATE_NAME);

		// Comprobamos que se ha abierto el recurso asociado al estado
		assertThat(isOpen(RECORD_RES_NAME), is(true));

	}

	@Test
	public void testOpenTransfer() throws Exception {

		// Creamos el recurso que debería abrirse al abrir (doble-click) el
		// estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ TRANSFER_RES_NAME + ".voiceDsl",
				getInputStreamResource(bundle, "voiceDsls/" + TRANSFER_RES_NAME
						+ ".voiceDsl"));

		// Abrimos el estado
		openState(TRANSFER_STATE_NAME);

		// Comprobamos que se ha abierto el recurso asociado al estado
		assertThat(isOpen(TRANSFER_RES_NAME), is(true));

	}

	@Test
	public void testOpenCustom() throws Exception {

		// Creamos el recurso que debería abrirse al abrir (doble-click) el
		// estado.
		createFile(
				project,
				BaseModel.JV_PATH + PACKAGE_PATH + FLOW_RESOURCES_FOLDER
						+ CUSTOM_RES_NAME + ".jsp",
				getInputStreamResource(bundle, "jsps/" + CUSTOM_RES_NAME
						+ ".jsp"));

		// Abrimos el estado
		openState(CUSTOM_STATE_NAME);

		// Comprobamos que se ha abierto el recurso asociado al estado
		assertThat(isOpen(CUSTOM_RES_NAME), is(true));

	}

	@Test
	public void testOpenExecute() throws Exception {

		// Creamos el recurso que debería abrirse al abrir (doble-click) el
		// estado.
		createFile(
				project,
				BaseModel.JAVA_SOURCES_PATH + COMPONENTS_PATH
						+ EXECUTE_RES_NAME + ".java",
				getInputStreamResource(bundle, "components/" + EXECUTE_RES_NAME
						+ ".java"));

		// Abrimos el estado
		openState(EXECUTE_STATE_NAME);

		// Comprobamos que se ha abierto el recurso asociado al estado
		assertThat(isOpen(EXECUTE_RES_NAME), is(true));

	}

	public void openState(final String stateName) throws Exception {

		openFile(flowFile);

		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();

		syncExec(new VoidResult() {
			@Override
			public void run() {

				// Recuperamos la figura asociada el estado que queremos abrir
				// para poner el ratón sobre la figura y poder seleccionarlo y
				// posteriormente hacer doble-click. Esto es necesario por la
				// implementación de graphiti.
				SWTBotGefEditPart entity = editor.getEditPart(stateName);
				final IFigure figure = ((GraphicalEditPart) entity.part())
						.getFigure();
				final Rectangle bounds = figure.getBounds().getCopy();
				figure.translateToAbsolute(bounds);

				IDiagramContainerUI diagramEditor = (IDiagramContainerUI) editor
						.getReference().getEditor(true);
				diagramEditor.getDiagramBehavior().getMouseLocation().x = bounds.x;
				diagramEditor.getDiagramBehavior().getMouseLocation().y = bounds.y;

				// Seleccionamos el estado
				editor.select(stateName);
			}
		});

		bot.sleep(LARGE_SLEEP);

		// Doble click sobre el estado para abrirlo
		editor.doubleClick(stateName);

	}

	private Boolean isOpen(String resourceName) {

		// Comprobamos que esté abierta una ventana que contenga el nombre
		// del recurso que debería haberse abierto.
		SWTBotShell[] shells = bot.shells();
		boolean hasShell = false;
		for (int i = 0; i < shells.length; i++) {
			if (shells[i].isOpen()) {
				SWTBotShell shell = shells[i];
				if (shell.getText().contains(resourceName)) {
					hasShell = true;
					break;
				}
			}
		}
		return hasShell;
	}

	public SWTBotGefEditor getGefEditor() {
		SWTBotEditor activeEditor = bot.activeEditor();
		String title = activeEditor.getTitle();
		SWTBotGefEditor ed = bot.gefEditor(title);
		return ed;
	}

}
