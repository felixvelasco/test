package com.vectorsf.jvoice.diagram.core.updateModules;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.m2e.actions.ExecutePomAction;
import org.eclipse.ui.PlatformUI;

import com.vectorsf.jvoice.core.project.JVoiceApplicationNature;
import com.vectorsf.jvoice.diagram.core.Activator;
import com.vectorsf.jvoice.model.base.impl.JVModuleImpl;

/**
 * Acción para reinstalar los módulos seleccionados. Para Tomcat, instala los módulos seleccionados, la aplicación y
 * arranca Tomcat.
 */
public class IVRMavenLauncher extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		stopTomcat();
		installModules();
		// startTomcat();

		return null;
	}

	private void startTomcat() {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		try {
			ILaunchConfiguration[] confs = manager.getLaunchConfigurations();
			for (ILaunchConfiguration conf : confs) {
				if ("org.eclipse.jst.server.tomcat.core.launchConfigurationType".equals(conf.getType().getIdentifier())) {
					System.out.println("Arranco: " + conf.getType().getIdentifier());
					DebugUITools.launch(conf.getWorkingCopy(), ILaunchManager.RUN_MODE);
				}
			}
		} catch (Exception e) {
			System.err.println("InstallModulesAction.startTomcat(): " + e);
		}
	}

	public void stopTomcat() {
		for (ILaunch launch : DebugPlugin.getDefault().getLaunchManager().getLaunches()) {
			try {
				if (launch.getLaunchConfiguration().getName().contains("Tomcat")) {
					System.out.println("Paramos Tomcat");
					launch.terminate();
				}
			} catch (Exception e) {
				System.err.println("InstallModulesAction.stopTomcat(): " + e);
			}
		}
	}

	private void installModules() {

		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService()
				.getSelection();

		try {
			Object project = ((IStructuredSelection) selection).getFirstElement();
			if (!(project instanceof JVModuleImpl)) {
				MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						"Despliegue de módulos", "No hay ningún módulo seleccionado");
				return;
			}

			ExecutePomAction action = new ExecutePomAction();
			action.setInitializationData(null, null, "clean install");
			action.launch(selection, "run");

			for (IProject prj : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
				if (prj.hasNature(JVoiceApplicationNature.NATURE_ID)) {
					ExecutePomAction action2 = new ExecutePomAction();
					action2.setInitializationData(null, null, "install");
					action2.launch(new StructuredSelection(prj), "run");
				}
			}
		} catch (Exception e) {
			System.err.println("InstallModulesAction.installModules(): " + e);
		}
	}

	private void log(String text) {
		System.err.println(text);
		Activator.getLogger().log(IStatus.WARNING, "Actualizador de versiones: " + text);
	}
}
