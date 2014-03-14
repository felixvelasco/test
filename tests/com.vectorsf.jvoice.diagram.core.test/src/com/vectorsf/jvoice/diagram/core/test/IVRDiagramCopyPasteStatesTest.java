package com.vectorsf.jvoice.diagram.core.test;

import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.getInputStreamResource;
import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.syncExec;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
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
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefViewer;
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

	private static final int SMALL_SLEEP = 200;
	private static final int LARGE_SLEEP = 1200;
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
	public void testCopyPasteCallFlow() throws Exception {
		copyPasteState(1, "empty", 390, 75);
	}

	@Test
	public void test2CopyPasteCall() throws Exception {
		copyPasteState(2, "test", 80, 195);
	}

	@Test
	public void test3CopyPasteFinal() throws Exception {
		copyPasteState(3, "Final", 105, 300);
	}

	@Test
	public void test4CopyPasteOutput() throws Exception {
		copyPasteState(4, "Output", 390, 185);
	}

	@Test
	public void test5CopyPasteMenu() throws Exception {
		copyPasteState(5, "Menu", 390, 300);
	}

	@Test
	public void test6CopyPasteInput() throws Exception {
		copyPasteState(6, "Input", 80, 195);
	}

	@Test
	public void test7CopyPasteCustom() throws Exception {
		copyPasteState(7, "Custom", 105, 300);
	}

	@Test
	public void test8CopyPasteSwitch() throws Exception {
		copyPasteState(8, "Switch", 390, 185);
	}

	@Test
	public void test9CopyPasteRecord() throws Exception {
		copyPasteState(9, "Record", 105, 300);
	}

	@Test
	public void test10CopyPasteTransfer() throws Exception {
		copyPasteState(10, "Transfer", 105, 300);
	}

	@Test
	public void testCopyPasteCall() throws Exception {
		copyPasteState(1, "test", 80, 195);
	}

	@Test
	public void testCopyPasteOutput() throws Exception {
		copyPasteState(1, "Output", 226, 195);
	}

	@Test
	public void testCopyPasteMenu() throws Exception {
		copyPasteState(1, "Menu", 385, 300);
	}

	@Test
	public void testCopyPasteInput() throws Exception {
		copyPasteState(1, "Input", 75, 195);
	}

	@Test
	public void testCopyPasteSwitch() throws Exception {
		copyPasteState(1, "Switch", 390, 185);
	}

	@Test
	public void testCopyPasteFinal() throws Exception {
		copyPasteState(1, "Final", 105, 300);
	}

	@Test
	public void testCopyPasteCustom() throws Exception {
		copyPasteState(1, "Custom", 105, 300);
	}

	@Test
	public void testCopyPasteRecord() throws Exception {
		copyPasteState(1, "Record", 105, 300);
	}

	@Test
	public void testCopyPasteTransfer() throws Exception {
		copyPasteState(1, "Transfer", 105, 300);
	}

	public void copyPasteState(final int numCopies, final String stateName,
			final int x, final int y) throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/copyState.jvflow",
				getInputStreamResource(bundle, "flows/copyState.jvflow"));
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

		SWTBotGefEditor stateEditor = editor.select(stateName);
		stateEditor.clickContextMenu("Copy");
		for (int i = 0; i < numCopies; i++) {
			editor.click(20, 20);
			stateEditor.clickContextMenu("Paste");

			editor.save();
			DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
					.getEditor(true);
			Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
			Flow flow = (Flow) Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(diagram);
			Matcher<Iterable<? super State>> hasItemWithNameStateName = null;

			hasItemWithNameStateName = hasStateNamed(stateName + (i + 1));

			bot.sleep(SMALL_SLEEP);
			assertThat(flow.getStates(), hasItemWithNameStateName);

		}
	}

	@Test
	public void testCopyPasteAllStates() throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/copyState.jvflow",
				getInputStreamResource(bundle, "flows/copyState.jvflow"));
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
		gefViewer = editor.getSWTBotGefViewer();

		final List<SWTBotGefEditPart> elements = new ArrayList<SWTBotGefEditPart>();

		elements.add(editor.getEditPart("Final"));
		elements.add(editor.getEditPart("test"));
		elements.add(editor.getEditPart("empty"));
		elements.add(editor.getEditPart("Switch"));
		elements.add(editor.getEditPart("Menu"));
		elements.add(editor.getEditPart("Input"));
		elements.add(editor.getEditPart("Output"));
		elements.add(editor.getEditPart("Record"));
		elements.add(editor.getEditPart("Transfer"));
		elements.add(editor.getEditPart("Custom"));

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
		editor.click(10, 10);
		editor.clickContextMenu("Paste");
		bot.sleep(SMALL_SLEEP);

		editor.save();
		DiagramEditor diaEditor = (DiagramEditor) editor.getReference()
				.getEditor(true);
		Diagram diagram = diaEditor.getDiagramTypeProvider().getDiagram();
		Flow flow = (Flow) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(diagram);
		Matcher<Iterable<? super State>> hasItemWithNameStateName = null;

		hasItemWithNameStateName = hasStateNamed("Final1");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("empty1");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("Switch1");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("Menu1");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("test1");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("Output1");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		hasItemWithNameStateName = hasStateNamed("Input1");
		assertThat(flow.getStates(), hasItemWithNameStateName);
		Matcher<Iterable<? super Transition>> hasTransition = hasTransition(
				"test1", "empty1");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("empty1", "Switch1");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("Switch1", "Menu1");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("Switch1", "Output1");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("Output1", "Input1");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("Input1", "Final1");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("Menu1", "Transfer1");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("Menu1", "Record1");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("Record1", "Custom1");
		assertThat(flow.getTransitions(), hasTransition);
		hasTransition = hasTransition("Custom1", "Final1");
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

	public SWTBotGefEditor getGefEditor() {
		SWTBotEditor activeEditor = bot.activeEditor();
		String title = activeEditor.getTitle();
		SWTBotGefEditor ed = bot.gefEditor(title);
		return ed;
	}

}