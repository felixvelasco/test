package com.vectorsf.jvoice.ui.wizard.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.fail;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCombo;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vectorsf.jvoice.base.model.service.BaseModel;

public class WizardsTest {
	private static final int LARGE_SLEEP = 3000;
	protected static SWTGefBot bot = new SWTGefBot();
	private static SWTBotView view;
	private static final String NAVIGATOR_ID = "com.vectorsf.jvoice.ui.navigator.ViewIVR";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setClassUp() throws Exception {
		SWTBotHelper.closeWelcomeView(bot);
		SWTBotHelper.openView(bot, "IVR", "Navigator IVR");

		view = bot.viewById(NAVIGATOR_ID);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		UIThreadRunnable.syncExec(new VoidResult() {
			@Override
			public void run() {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceActive();
			}
		});
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		SWTBotShell[] shells = bot.shells();
		for (int i = 0; i < shells.length; i++) {
			if (shells[i].isOpen()) {
				SWTBotShell shell = shells[i];
				if (shell.getText().contains("Container")
						|| shell.getText().contains("New Definition")
						|| shell.getText().contains("New Flow")) {
					shell.close();
				}
			}
		}
		
		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {

			try {
				while (true) {
					if (project.isSynchronized(2)) {
						try {
							SWTBotHelper.deleteProject(project);
						} catch (@SuppressWarnings("restriction") ResourceException re)
						{
							IStatus status = re.getStatus();
							System.err.println(status);
							if(status.getException()!=null){
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
	public void testCreateProject() throws CoreException {
		SWTBotHelper.createProject("baseNavigator");
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		view.bot().tree().getTreeItem("baseNavigator").contextMenu("New").menu("Module Project").click();

		bot.shell("New Module Project").activate();
		final SWTBotShell shellCreate = bot.shell("New Module Project"); //$NON-NLS-1$
		final SWTBot dialogBot = shellCreate.bot();
		assertThat(dialogBot.button("Finish").isEnabled(), is(false));
		assertThat(dialogBot.text(0).getText(), is(""));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		SWTBotText text = dialogBot.text(0);
		text.setText("proyectoSWTBOT");
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		text.setText("baseNavigator");
		assertThat(dialogBot.button("Finish").isEnabled(), is(false));
		text.setText("proyectoSWTBOT");
		dialogBot.button("Finish").click();
		
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (view.bot().tree().getAllItems().length==2) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 5 * 60 * 1000);
		
//		// Esperamos a que el wizard de creación se cierre
//		bot.waitUntil(new DefaultCondition() {
//			public boolean test() throws Exception {
//						if (!shellCreate.isOpen()) {
//							return true;
//						}
//						return false;
//					}
//
//					public String getFailureMessage() {
//						return "Was expecting the 'Create' dialog to close itself";
//					}
//				}, 5 * 60 * 1000);
		bot.sleep(LARGE_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
	}
	
	@Test
	public void testCreateApplicationProject() throws CoreException {
		SWTBotHelper.createProject("baseNavigator");
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		view.bot().tree().getTreeItem("baseNavigator").contextMenu("New").menu("Application Project").click();

		bot.shell("New Application Project").activate();
		final SWTBotShell shellCreate = bot.shell("New Application Project"); //$NON-NLS-1$
		final SWTBot dialogBot = bot.shell("New Application Project").bot();
		assertThat(dialogBot.button("Finish").isEnabled(), is(false));
		assertThat(dialogBot.text(0).getText(), is(""));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		SWTBotText text = dialogBot.text(0);
		text.setText("proyectoSWTBOT");
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		text.setText("baseNavigator");
		assertThat(dialogBot.button("Finish").isEnabled(), is(false));
		text.setText("proyectoSWTBOT");
		dialogBot.button("Finish").click();
		// Esperamos a que el wizard de creación se cierre
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
						if (!shellCreate.isOpen()) {
							return true;
						}
						return false;
					}

					public String getFailureMessage() {
						return "Was expecting the 'Create' dialog to close itself";
					}
				}, 5 * 60 * 1000);
		bot.sleep(LARGE_SLEEP);
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
	}
	
	@Test
	public void testCreatePackageBrowse() throws CoreException {
		SWTBotHelper.createProject("baseNavigator");
		IProject base2 = SWTBotHelper.createProject("baseNavigator2");
		SWTBotHelper.createFolders(base2, BaseModel.JV_PATH + "/paquetePrueba");
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		//el proyecto tiene las dependencias maven y el paquete java
		assertThat(view.bot().tree().expandNode("baseNavigator").getItems(), is(arrayWithSize(2)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getItems(), is(arrayWithSize(3)));
		view.bot().tree().getTreeItem("baseNavigator").contextMenu("New").menu("Package").click();
		bot.shell("New Package").activate();
		final SWTBotShell shellCreate = bot.shell("New Package"); //$NON-NLS-1$
		final SWTBot dialogBot = bot.shell("New Package").bot();
		
		assertThat(dialogBot.button("Finish").isEnabled(), is(false));
		assertThat(dialogBot.text(0).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is(""));
		SWTBotText text = dialogBot.text(1);
		text.setText("paquetePrueba");
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button("Browse...").click();
		
		openBrowseProject();
		
		assertThat(dialogBot.text(0).getText(), is("baseNavigator2"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(false));
		text.setText("otroPaquete");
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button("Finish").click();
		// Esperamos a que el wizard de creación se cierre
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getItems(), is(arrayWithSize(2)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getItems(), is(arrayWithSize(4)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("otroPaquete"), is(not(nullValue())));
	}
	
	@Test
	public void testCreatePackageSimple() throws CoreException {
		SWTBotHelper.createProject("baseNavigator");
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().expandNode("baseNavigator").getItems(), is(arrayWithSize(2)));
		view.bot().tree().getTreeItem("baseNavigator").contextMenu("New").menu("Package").click();
		bot.shell("New Package").activate();
		final SWTBotShell shellCreate = bot.shell("New Package"); //$NON-NLS-1$
		final SWTBot dialogBot = bot.shell("New Package").bot();
		
		assertThat(dialogBot.button("Finish").isEnabled(), is(false));
		assertThat(dialogBot.text(0).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is(""));
		SWTBotText text = dialogBot.text(1);
		text.setText("paquetePrueba");
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button("Finish").click();
		// Esperamos a que el wizard de creación se cierre
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getItems(), is(arrayWithSize(3)));
	}
	
	@Test
	public void testFlowSimple() throws CoreException {
		UnProjectOnePack();
		
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		final SWTBot dialogBot = bot.shell("New Flow").bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		dialogBot.text(0).setText("flow");
		assertThat(dialogBot.text(0).getText(), is("flow"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		SWTBotText text = dialogBot.text(0);
		text.setText("");
		assertThat(dialogBot.button("Finish").isEnabled(), is(false));
		text.setText("flujoPrueba/");
		assertThat(dialogBot.button("Finish").isEnabled(), is(false));
		text.setText("flujoPrueba");
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button("Finish").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
	}
	
	@Test
	public void testFlowOneBrowse() throws CoreException {
		DosProjectOnePack();
		
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		final SWTBot dialogBot = bot.shell("New Flow").bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(0).click();

		openBrowseProject();
		
		assertThat(dialogBot.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button("Finish").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(0)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
	}
	
	@Test
	public void testFlowTwoBrowse() throws CoreException {

		DosProjectTwoPack();
		
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		final SWTBot dialogBot = shellCreate.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(2).click();
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
	
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate2 = bot.shell("New Flow"); //$NON-NLS-1$
		final SWTBot dialogBot2 = shellCreate2.bot();
		assertThat(dialogBot2.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot2.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot2.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		dialogBot2.button(0).click();
		
		openBrowseProject();
		
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		
		dialogBot2.button(1).click();

		openBrowsePackage();
		
		assertThat(dialogBot2.text(2).getText(), is("segundoPaquete"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		
		dialogBot2.button("Finish").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate2.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("otroPaquete").getItems(), is(arrayWithSize(0)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("segundoPaquete").getItems(), is(arrayWithSize(1)));
	}
	
	@Test
	public void testMenuSimple() throws CoreException {
		DosProjectOnePack();
		bot.sleep(LARGE_SLEEP);
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		final SWTBot dialogBot = shellCreate.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button("Finish").click();
		bot.sleep(LARGE_SLEEP);
		bot.sleep(LARGE_SLEEP);
		view.bot().tree().getTreeItem("baseNavigator").expandNode("paquetePrueba");
		bot.sleep(LARGE_SLEEP);
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba")
				.getNode("newJVoice").contextMenu("New").menu("Definition")
				.click();
		bot.shell("New Definition").activate();
		final SWTBotShell shellCreate2 = bot.shell("New Definition"); //$NON-NLS-1$
		final SWTBot dialogBot2 = bot.shell("New Definition").bot();
		assertThat(dialogBot2.label("DSL name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(0).getText(), is("newDefinition"));
		assertThat(dialogBot2.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot2.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.comboBox().items(), is(arrayWithSize(4)));
		assertThat(dialogBot2.comboBox().selection(), is("Menu"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		SWTBotText text = dialogBot2.text(0);
		text.setText("");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("menuPrueba/");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("menuPrueba");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		dialogBot2.button("Finish").click();
		
		bot.sleep(LARGE_SLEEP);
		
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate2.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		},  3 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").expand().getItems()[0].getText(), is("newJVoice"));
	}
	
	@Test
	public void testMenuOneBrowse() throws CoreException {
		DosProjectOnePack();
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		SWTBot dialogBot = shellCreate.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(2).click();
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
		view.bot().tree().getTreeItem("baseNavigator2").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreateFlow = bot.shell("New Flow"); //$NON-NLS-1$
		dialogBot =shellCreateFlow.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(2).click();
		
		
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreateFlow.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
		view.bot().tree().getTreeItem("baseNavigator")
				.expandNode("paquetePrueba").getNode("newJVoice")
				.contextMenu("New").menu("Definition").click();
		bot.shell("New Definition").activate();
		final SWTBotShell shellCreate3 = bot.shell("New Definition"); //$NON-NLS-1$
		final SWTBot dialogBot3 = shellCreate3.bot();
		assertThat(dialogBot3.label("DSL name:"), is(not(nullValue())));
		assertThat(dialogBot3.text(0).getText(), is("newDefinition"));
		assertThat(dialogBot3.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot3.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot3.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot3.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot3.label("Diagram name:"), is(not(nullValue())));
		assertThat(dialogBot3.text(3).getText(), is("newJVoice"));
		assertThat(dialogBot3.comboBox().items(), is(arrayWithSize(4)));
		assertThat(dialogBot3.button("Finish").isEnabled(), is(true));
		dialogBot3.button("Finish").click();
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate3.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
		
		view.bot().tree().getTreeItem("baseNavigator")
				.expandNode("paquetePrueba").getNode("newJVoice")
				.contextMenu("New").menu("Definition").click();
		bot.shell("New Definition").activate();
		final SWTBotShell shellCreate2 = bot.shell("New Definition"); //$NON-NLS-1$
		final SWTBot dialogBot2 = bot.shell("New Definition").bot();
		assertThat(dialogBot2.label("DSL name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(0).getText(), is("newDefinition"));
		assertThat(dialogBot2.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot2.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.label("Diagram name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(3).getText(), is("newJVoice"));
		assertThat(dialogBot2.comboBox().items(), is(arrayWithSize(4)));
		assertThat(dialogBot2.comboBox().selection(), is("Menu"));
		
		dialogBot2.button(0).click();
		openBrowseProject();
		
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		
		dialogBot2.button(1).click();


		bot.shell("Container Selection").activate();
		final SWTBotShell shellPackage = bot.shell("Container Selection"); //$NON-NLS-1$
		SWTBot selectBot = shellPackage.bot();
		assertThat(selectBot.table().rowCount(), is(1));
		selectBot.button("OK").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellPackage.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 );
		
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		
		dialogBot2.button(2).click();
		
		openBrowseFlow();
		
		assertThat(dialogBot2.text(3).getText(), is("newJVoice"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		
		SWTBotText text = dialogBot2.text(0);
		text.setText("");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("menuPrueba/");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("menuPrueba");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		
		dialogBot2.button("Finish").click();
		
		bot.sleep(LARGE_SLEEP);
		
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate2.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 3 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
//		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("paquetePrueba").expand().getItems()[0].getText(), is("menuPrueba"));

	}
	
	@Test
	public void testMenuTwoBrowse() throws CoreException {

		DosProjectTwoPack();
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		SWTBot dialogBot =shellCreate.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(2).click();
		
		
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
		
		view.bot().tree().getTreeItem("baseNavigator2").getNode("segundoPaquete").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreateFlow = bot.shell("New Flow"); //$NON-NLS-1$
		dialogBot =shellCreateFlow.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("segundoPaquete"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(2).click();
		
		
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreateFlow.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
		view.bot().tree().getTreeItem("baseNavigator").expandNode("paquetePrueba").getNode("newJVoice").contextMenu("New").menu("Locution").click();
		bot.shell("New Definition").activate();
		final SWTBotShell shellCreate2 = bot.shell("New Definition"); //$NON-NLS-1$
		final SWTBot dialogBot2 = bot.shell("New Definition").bot();
		assertThat(dialogBot2.label("DSL name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(0).getText(), is("newDefinition"));
		assertThat(dialogBot2.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot2.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.comboBox().items(), is(arrayWithSize(4)));
		assertThat(dialogBot2.comboBox().selection(), is("Menu"));
		dialogBot2.button(0).click();
		
		openBrowseProject();
		
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		
		dialogBot2.button(1).click();

		openBrowsePackage();
		
		assertThat(dialogBot2.text(2).getText(), is("segundoPaquete"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		
		dialogBot2.button(2).click();
		
		openBrowseFlow();
		
		assertThat(dialogBot2.text(3).getText(), is("newJVoice"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		
		SWTBotText text = dialogBot2.text(0);
		text.setText("");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("menuPrueba/");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("menuPrueba");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		
		
		dialogBot2.button("Finish").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate2.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("otroPaquete").getItems(), is(arrayWithSize(0)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("segundoPaquete").getItems(), is(arrayWithSize(1)));
//		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("segundoPaquete").expand().getItems()[0].getText(), is("menuPrueba"));
	}
	
	@Test
	public void testInputSimple() throws CoreException {
		DosProjectOnePack();
		bot.sleep(LARGE_SLEEP);
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		final SWTBot dialogBot = shellCreate.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button("Finish").click();
		bot.sleep(LARGE_SLEEP);
		bot.sleep(LARGE_SLEEP);
		view.bot().tree().getTreeItem("baseNavigator").expandNode("paquetePrueba");
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").getNode("newJVoice").contextMenu("New").menu("Locution").click();
		bot.shell("New Locution").activate();
		final SWTBotShell shellCreate2 = bot.shell("New Definition"); //$NON-NLS-1$
		final SWTBot dialogBot2 = bot.shell("New Locution").bot();
		assertThat(dialogBot2.label("DSL name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(0).getText(), is("newDefinition"));
		assertThat(dialogBot2.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot2.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.comboBox().items(), is(arrayWithSize(4)));
		assertThat(dialogBot2.comboBox().selection(), is("Menu"));
		SWTBotCombo combo = dialogBot2.comboBox();
		combo.setSelection(1);
		assertThat(dialogBot2.comboBox().selection(), is("Input"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		SWTBotText text = dialogBot2.text(0);
		text.setText("");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("inputPrueba/");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("inputPrueba");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		dialogBot2.button("Finish").click();
		
		bot.sleep(LARGE_SLEEP);
		
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate2.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 3 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
//		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").expand().getItems()[0].getText(), is("newJVoice"));
	}
	
	@Test
	public void testInputOneBrowse() throws CoreException {
		DosProjectOnePack();
		bot.sleep(LARGE_SLEEP);
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		final SWTBot dialogBot = shellCreate.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button("Finish").click();
		bot.sleep(LARGE_SLEEP);
		bot.sleep(LARGE_SLEEP);
		view.bot().tree().getTreeItem("baseNavigator").expandNode("paquetePrueba");
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		view.bot().tree().getTreeItem("baseNavigator").expandNode("paquetePrueba").getNode("newJVoice").contextMenu("New").menu("Locution").click();
		bot.shell("New Locution").activate();
		final SWTBotShell shellCreate2 = bot.shell("New Definition"); //$NON-NLS-1$
		final SWTBot dialogBot2 = shellCreate2.bot();
		assertThat(dialogBot2.label("DSL name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(0).getText(), is("newDefinition"));
		assertThat(dialogBot2.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot2.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.comboBox().items(), is(arrayWithSize(4)));
		assertThat(dialogBot2.comboBox().selection(), is("Menu"));
		
		SWTBotCombo combo = dialogBot2.comboBox();
		combo.setSelection(1);
		assertThat(dialogBot2.comboBox().selection(), is("Input"));
		
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		dialogBot2.button("Finish").click();

		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate2.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
     	assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("paquetePrueba").getItems(), is(arrayWithSize(0)));
 

	}
	
	@Test
	public void testInputTwoBrowse() throws CoreException {

		DosProjectTwoPack();
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		SWTBot dialogBot = shellCreate.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(2).click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
		view.bot().tree().getTreeItem("baseNavigator2").getNode("segundoPaquete").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreateFlow = bot.shell("New Flow"); //$NON-NLS-1$
		dialogBot =shellCreateFlow.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("segundoPaquete"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(2).click();
		
		
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreateFlow.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
		
		view.bot().tree().getTreeItem("baseNavigator").expandNode("paquetePrueba").getNode("newJVoice").contextMenu("New").menu("Locution").click();
		bot.shell("New Locution").activate();
		final SWTBotShell shellCreate2 = bot.shell("New Definition"); //$NON-NLS-1$
		final SWTBot dialogBot2 = bot.shell("New Locution").bot();
		assertThat(dialogBot2.label("DSL name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(0).getText(), is("newDefinition"));
		assertThat(dialogBot2.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot2.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.comboBox().items(), is(arrayWithSize(4)));
		assertThat(dialogBot2.comboBox().selection(), is("Menu"));
		
		SWTBotCombo combo = dialogBot2.comboBox();
		combo.setSelection(1);
		assertThat(dialogBot2.comboBox().selection(), is("Input"));
		
		dialogBot2.button(0).click();
		
		openBrowseProject();
		
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		
		dialogBot2.button(1).click();

		openBrowsePackage();
		
		assertThat(dialogBot2.text(2).getText(), is("segundoPaquete"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		
		dialogBot2.button(2).click();
		
		openBrowseFlow();
		
		assertThat(dialogBot2.text(3).getText(), is("newJVoice"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		
		SWTBotText text = dialogBot2.text(0);
		text.setText("");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("inputPrueba/");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("inputPrueba");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		
		
		dialogBot2.button("Finish").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate2.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("otroPaquete").getItems(), is(arrayWithSize(0)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("segundoPaquete").getItems(), is(arrayWithSize(1)));
//		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("segundoPaquete").expand().getItems()[0].getText(), is("newJVoice"));
	}
	
	@Test
	public void testOutputSimple() throws CoreException {
		UnProjectOnePack();
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		final SWTBot dialogBot = shellCreate.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(2).click();

		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 60 * 60 * 1000);
		view.bot().tree().getTreeItem("baseNavigator").expandNode("paquetePrueba").getNode("newJVoice").contextMenu("New").menu("Locution").click();
		bot.shell("New Locution").activate();
		final SWTBotShell shellCreate2 = bot.shell("New Definition"); //$NON-NLS-1$
		final SWTBot dialogBot2 = bot.shell("New Locution").bot();
		assertThat(dialogBot2.label("DSL name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(0).getText(), is("newDefinition"));
		assertThat(dialogBot2.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot2.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.comboBox().items(), is(arrayWithSize(4)));
		assertThat(dialogBot2.comboBox().selection(), is("Menu"));
		SWTBotCombo combo = dialogBot2.comboBox();
		combo.setSelection(2);
		assertThat(dialogBot2.comboBox().selection(), is("Output"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		SWTBotText text = dialogBot2.text(0);
		text.setText("");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("outputPrueba/");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("outputPrueba");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		dialogBot2.button("Finish").click();
		
		bot.sleep(LARGE_SLEEP);
		
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate2.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 60 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
//		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").expand().getItems()[0].getText(), is("newJVoice"));
	}
	
	@Test
	public void testOutputOneBrowse() throws CoreException {
		DosProjectOnePack();
		
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		SWTBot dialogBot = shellCreate.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(2).click();
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
		
		view.bot().tree().getTreeItem("baseNavigator2").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreateFlow = bot.shell("New Flow"); //$NON-NLS-1$
		dialogBot =shellCreateFlow.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(2).click();
		
		
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreateFlow.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
		view.bot().tree().getTreeItem("baseNavigator").expandNode("paquetePrueba").getNode("newJVoice").contextMenu("New").menu("Locution").click();
	
		bot.shell("New Locution").activate();
		final SWTBotShell shellCreate2 = bot.shell("New Locution"); //$NON-NLS-1$
		final SWTBot dialogBot2 = bot.shell("New Locution").bot();
		assertThat(dialogBot2.label("DSL name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(0).getText(), is("newDefinition"));
		assertThat(dialogBot2.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot2.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.label("Diagram name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(3).getText(), is("newJVoice"));
		assertThat(dialogBot2.comboBox().items(), is(arrayWithSize(4)));
		assertThat(dialogBot2.comboBox().selection(), is("Menu"));
		
		SWTBotCombo combo = dialogBot2.comboBox();
		combo.setSelection(2);
		assertThat(dialogBot2.comboBox().selection(), is("Output"));
		
		dialogBot2.button(0).click();
		openBrowseProject();
		
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		
		dialogBot2.button(1).click();


		bot.shell("Container Selection").activate();
		final SWTBotShell shellPackage = bot.shell("Container Selection"); //$NON-NLS-1$
		SWTBot selectBot = shellPackage.bot();
		assertThat(selectBot.table().rowCount(), is(1));
		selectBot.button("OK").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellPackage.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 );
		
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		
		dialogBot2.button(2).click();
		
		openBrowseFlow();
		
		assertThat(dialogBot2.text(3).getText(), is("newJVoice"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		
		
		SWTBotText text = dialogBot2.text(0);
		text.setText("");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("outputPrueba/");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("outputPrueba");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		
		dialogBot2.button("Finish").click();
		
		bot.sleep(LARGE_SLEEP);
		
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate2.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 60 * 60 * 1000);
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
//		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("paquetePrueba").expand().getItems()[0].getText(), is("outputPrueba"));

	}
	
	@Test
	public void testOutputTwoBrowse() throws CoreException {

		DosProjectOnePack();
		bot.sleep(LARGE_SLEEP);
		view.bot().tree().getTreeItem("baseNavigator").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreate = bot.shell("New Flow"); //$NON-NLS-1$
		SWTBot dialogBot = shellCreate.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button("Finish").click();
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
		
		view.bot().tree().getTreeItem("baseNavigator2").getNode("paquetePrueba").contextMenu("New").menu("Flow").click();
		bot.shell("New Flow").activate();
		final SWTBotShell shellCreateFlow = bot.shell("New Flow"); //$NON-NLS-1$
		dialogBot =shellCreateFlow.bot();
		assertThat(dialogBot.label("Flow name:"), is(not(nullValue())));
		assertThat(dialogBot.text(0).getText(), is("newJVoice"));
		assertThat(dialogBot.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot.button("Finish").isEnabled(), is(true));
		dialogBot.button(2).click();
		bot.sleep(LARGE_SLEEP);
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreateFlow.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting newJVoice to be created";
			}
		}, 3*60 * 1000);
		
		view.bot().tree().getTreeItem("baseNavigator").expandNode("paquetePrueba").getNode("newJVoice").contextMenu("New").menu("Locution").click();
		bot.shell("New Locution").activate();
		final SWTBotShell shellCreate2 = bot.shell("New Definition"); //$NON-NLS-1$
		final SWTBot dialogBot2 = bot.shell("New Locution").bot();
		assertThat(dialogBot2.label("DSL name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(0).getText(), is("newDefinition"));
		assertThat(dialogBot2.label("Project name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator"));
		assertThat(dialogBot2.label("Package name:"), is(not(nullValue())));
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.comboBox().items(), is(arrayWithSize(4)));
		assertThat(dialogBot2.comboBox().selection(), is("Menu"));
		
		SWTBotCombo combo = dialogBot2.comboBox();
		combo.setSelection(2);
		assertThat(dialogBot2.comboBox().selection(), is("Output"));
		
		dialogBot2.button(0).click();
		
		bot.sleep(LARGE_SLEEP);
		openBrowseProject();
		
		assertThat(dialogBot2.text(1).getText(), is("baseNavigator2"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		
		dialogBot2.button(1).click();

		bot.sleep(LARGE_SLEEP);
		bot.shell("Container Selection").activate();
		final SWTBotShell shellPackage = bot.shell("Container Selection"); //$NON-NLS-1$
		SWTBot selectBot = shellPackage.bot();
		assertThat(selectBot.table().rowCount(), is(1));
		selectBot.button("OK").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellPackage.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 );
		
		assertThat(dialogBot2.text(2).getText(), is("paquetePrueba"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		
		dialogBot2.button(2).click();
		
		openBrowseFlow();
		
		assertThat(dialogBot2.text(3).getText(), is("newJVoice"));
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		
		
		SWTBotText text = dialogBot2.text(0);
		text.setText("");
		dialogBot2.text(1).setText("baseNavigator");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("outputPrueba/");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(false));
		text.setText("outputPrueba");
		assertThat(dialogBot2.button("Finish").isEnabled(), is(true));
		dialogBot2.button("Finish").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellCreate2.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 );
		assertThat(view.bot().tree().expandNode("baseNavigator").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("paquetePrueba").getItems(), is(arrayWithSize(1)));
//		assertThat(view.bot().tree().expandNode("baseNavigator2").getNode("segundoPaquete").expand().getItems()[0].getText(), is("outputPrueba"));
	}
	
	private void openBrowseProject(){
		bot.shell("Container Selection").activate();
		final SWTBotShell shellProject = bot.shell("Container Selection"); //$NON-NLS-1$
		SWTBot selectBot = shellProject.bot();
		
		assertThat(selectBot.table().rowCount(), is(2));
		assertThat(selectBot.table().getTableItem(0).getText(), is("baseNavigator"));
		assertThat(selectBot.table().getTableItem(1).getText(), is("baseNavigator2"));
		selectBot.table().getTableItem(1).select();
		selectBot.button("OK").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellProject.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 );
	}
	
	private void openBrowsePackage(){
		bot.shell("Container Selection").activate();
		final SWTBotShell shellPackage = bot.shell("Container Selection"); //$NON-NLS-1$
		SWTBot selectBot = shellPackage.bot();
		assertThat(selectBot.table().rowCount(), is(2));
		if(selectBot.table().getTableItem(0).getText().equals("segundoPaquete")){
			selectBot.table().getTableItem(0).select();
			selectBot.table().getTableItem(0).click();
		}else{
			selectBot.table().getTableItem(1).select();
			selectBot.table().getTableItem(1).click();
		}
		selectBot.button("OK").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellPackage.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 );
	}
	
	private void openBrowseFlow(){
		bot.shell("Container Selection").activate();
		final SWTBotShell shellFlow = bot.shell("Container Selection"); //$NON-NLS-1$
		SWTBot selectBot = shellFlow.bot();
		assertThat(selectBot.table().rowCount(), is(1));
		selectBot.button("OK").click();
		bot.waitUntil(new DefaultCondition() {
			public boolean test() throws Exception {
				if (!shellFlow.isOpen()) {
					return true;
				}
				return false;
			}
			public String getFailureMessage() {
				return "Was expecting the 'Create' dialog to close itself";
			}
		}, 5 * 60 );
	}
	
	private void DosProjectOnePack() throws CoreException{
		IProject base = SWTBotHelper.createProject("baseNavigator");
		SWTBotHelper.createFolders(base, BaseModel.JV_PATH + "/paquetePrueba");
		IProject base2 = SWTBotHelper.createProject("baseNavigator2");
		SWTBotHelper.createFolders(base2, BaseModel.JV_PATH + "/paquetePrueba");
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		bot.sleep(LARGE_SLEEP);
		assertThat(view.bot().tree().expandNode("baseNavigator").getItems(), is(arrayWithSize(3)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getItems(), is(arrayWithSize(3)));
	}
	
	private void DosProjectTwoPack() throws CoreException{
		IProject base = SWTBotHelper.createProject("baseNavigator");
		SWTBotHelper.createFolders(base, BaseModel.JV_PATH + "/paquetePrueba");
		IProject base2 = SWTBotHelper.createProject("baseNavigator2");
		SWTBotHelper.createFolders(base2, BaseModel.JV_PATH + "/otroPaquete");
		SWTBotHelper.createFolders(base2, BaseModel.JV_PATH + "/segundoPaquete");
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(2)));
		bot.sleep(LARGE_SLEEP);
		assertThat(view.bot().tree().expandNode("baseNavigator").getItems(), is(arrayWithSize(3)));
		assertThat(view.bot().tree().expandNode("baseNavigator2").getItems(), is(arrayWithSize(4)));
	}
	
	private void UnProjectOnePack() throws CoreException{
		IProject base = SWTBotHelper.createProject("baseNavigator");
		SWTBotHelper.createFolders(base, BaseModel.JV_PATH + "/paquetePrueba");
		assertThat(view.bot().tree().getAllItems(), is(arrayWithSize(1)));
		bot.sleep(LARGE_SLEEP);
		assertThat(view.bot().tree().expandNode("baseNavigator").getItems(), is(arrayWithSize(3)));
	}
}
