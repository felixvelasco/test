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
import org.eclipse.m2e.core.ui.internal.UpdateMavenProjectJob;
import org.eclipse.swt.widgets.Shell;
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
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService()
				.getSelection();
		Object project = ((IStructuredSelection) selection).getFirstElement();

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		if (!(project instanceof JVModuleImpl) || ((IStructuredSelection) selection).size() > 1) {
			MessageDialog.openWarning(shell, "Despliegue de módulos", "Debe seleccionar un módulo");
			return null;
		}

		stopTomcat();

		installModules(selection, project, shell);

		return null;
	}

	private void installModules(ISelection selection, Object project, Shell shell) {
		try {
			if (!(project instanceof JVModuleImpl) || ((IStructuredSelection) selection).size() > 1) {
				MessageDialog.openWarning(shell, "Despliegue de módulos", "Debe seleccionar un módulo");
				return;
			}

			// Instalamos el módulo seleccionado
			ExecutePomAction action = new ExecutePomAction();
			action.setInitializationData(null, null, "clean install");
			action.launch(selection, "run");

			boolean installModule = MessageDialog.openConfirm(null, "Instalar módulo",
					"Pulse OK cuando acabe la instalación del módulo");
			if (!installModule) {
				return;
			}

			for (IProject prj : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
				if (prj.isAccessible() && prj.hasNature(JVoiceApplicationNature.NATURE_ID)) {
					ExecutePomAction action2 = new ExecutePomAction();
					action2.setInitializationData(null, null, "clean install");
					action2.launch(new StructuredSelection(prj), "run");
				}
			}

			// Cuando acabe Maven de instalar los módulos actualizamos la aplicación y arrancamos Tomcat
			boolean startTomcat = MessageDialog.openConfirm(null, "Arrancar Tomcat",
					"Pulse OK cuando acabe la instalación de la aplicación para arrancar Tomcat");

			if (!startTomcat) {
				return;
			}

			// Actualizamos las aplicaciones
			for (IProject prj : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
				if (prj.isAccessible() && prj.hasNature(JVoiceApplicationNature.NATURE_ID)) {
					new UpdateMavenProjectJob(new IProject[] { prj }, true, // offline
							false, // forceUpdateDependencies
							true, // UpdateConfiguration
							true, // cleanProjects(),
							true // refreshFromLocal()
					).schedule();
				}
			}
			startTomcat();

		} catch (Exception e) {
			log("IVRMavenLauncher.installModules(): " + e);
			e.printStackTrace();
		}
	}

	private void startTomcat() {
		try {
			ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfiguration[] launchConfigurations = manager.getLaunchConfigurations();
			if (launchConfigurations.length == 0) {
				return;
			}

			boolean existsTomcat = false;
			for (ILaunchConfiguration conf : launchConfigurations) {
				if ("org.eclipse.jst.server.tomcat.core.launchConfigurationType".equals(conf.getType().getIdentifier())) {
					DebugUITools.launch(conf.getWorkingCopy(), ILaunchManager.RUN_MODE);
					existsTomcat = true;
				}
			}

			if (!existsTomcat) {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				MessageDialog.openWarning(shell, "Tomcat",
						"No hay creada ninguna configuración de Tomcat. Cree una antes de usar el lanzador automático");
			}

		} catch (Exception e) {
			log("IVRMavenLauncher.startTomcat(): " + e);
		}
	}

	private void stopTomcat() {
		ILaunch[] launches = DebugPlugin.getDefault().getLaunchManager().getLaunches();
		if (launches == null) {
			return;
		}

		for (ILaunch launch : launches) {
			try {
				if (launch.getLaunchConfiguration().getName().contains("Tomcat")) {
					launch.terminate();
				}
			} catch (Exception e) {
				log("IVRMavenLauncher.stopTomcat(): " + e);
			}
		}
	}

	private void log(String text) {
		System.err.println(text);
		Activator.getLogger().log(IStatus.WARNING, "IVRMavenLauncher: " + text);
	}
}
