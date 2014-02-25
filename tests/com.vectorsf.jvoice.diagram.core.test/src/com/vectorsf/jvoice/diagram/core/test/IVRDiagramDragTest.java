package com.vectorsf.jvoice.diagram.core.test;

import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFile;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.getInputStreamResource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import java.util.List;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefViewer;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotToolbarButton;
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
public class IVRDiagramDragTest {

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

	private Matcher<Iterable<? super State>> hasStateNamed(String stateName) {
		return Matchers.<State> hasItem(hasProperty("name", is(stateName)));
	}

	@Test
	public void testDragSwitch() throws Exception {
		dragState("Switch");
	}

	@Test
	public void testDragOutput() throws Exception {
		dragState("Output");
	}

	@Test
	public void testDragFinal() throws Exception {
		dragState("Final");
	}

	@Test
	public void testDragCall() throws Exception {
		dragState("Call");
	}

	@Test
	public void testDragCallFlow() throws Exception {
		dragState("Subflow");
	}

	@Test
	public void testDragInput() throws Exception {
		dragState("Input");
	}

	@Test
	public void testDragMenu() throws Exception {
		dragState("Menu");
	}

	@Test
	public void testDragTransfer() throws Exception {
		dragState("Transfer");
	}

	@Test
	public void testDragRecord() throws Exception {
		dragState("Record");
	}

	@Test
	public void testDragCustom() throws Exception {
		dragState("Custom");
	}

	public void dragState(String stateName) throws Exception {
		assertThat(view.bot().tree().getAllItems(), is(emptyArray()));

		IProject project = createProject("testNavigator");
		IFile file = createFile(project, BaseModel.JV_PATH
				+ "/several/packages/inside/dragState.jvflow",
				getInputStreamResource(bundle, "flows/dragState.jvflow"));

		openFile(file);
		bot.sleep(LARGE_SLEEP);

		editor = getGefEditor();
		List<SWTBotToolbarButton> buttons = editor.getToolbarButtons();
		bot.sleep(SMALL_SLEEP);
		editor.drag(stateName, 90, 90);
		editor.drag(stateName, 120, 70);
		bot.sleep(SMALL_SLEEP);

	}

	public SWTBotGefEditor getGefEditor() {
		SWTBotEditor activeEditor = bot.activeEditor();
		String title = activeEditor.getTitle();
		SWTBotGefEditor ed = bot.gefEditor(title);
		return ed;
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

}
