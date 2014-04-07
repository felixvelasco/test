package com.vectorsf.jvoice.diagram.core.updater;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.embedder.IMavenConfiguration;
import org.eclipse.m2e.core.internal.IMavenConstants;
import org.eclipse.m2e.core.project.IMavenProjectRegistry;
import org.eclipse.m2e.core.project.IProjectConfigurationManager;
import org.eclipse.m2e.core.project.MavenUpdateRequest;
import org.eclipse.m2e.core.project.ResolverConfiguration;
import org.eclipse.m2e.core.ui.internal.Messages;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * La mayor parte del código se ha copiado de la clase ChangeNatureAction.
 */
public class ChangeWorkspaceResolutionAction implements IObjectActionDelegate, IExecutableExtension {

	public static final String ID_ENABLE_WORKSPACE = "org.eclipse.m2e.enableWorkspaceResolutionAction"; //$NON-NLS-1$

	public static final String ID_DISABLE_WORKSPACE = "org.eclipse.m2e.disableWorkspaceResolutionAction"; //$NON-NLS-1$

	public static final int ENABLE_WORKSPACE = 1;

	public static final int DISABLE_WORKSPACE = 2;

	private ISelection selection;

	private int option;

	IProject _project;

	public ChangeWorkspaceResolutionAction() {
		this(null, ENABLE_WORKSPACE);
	}

	/**
	 * Creamos un constructor al que le pasamos el proyecto.
	 */
	public ChangeWorkspaceResolutionAction(IProject project, int option) {
		this.option = option;
		_project = project;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement
	 * , java.lang.String, java.lang.Object)
	 */
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) {
		if (data != null) {
			if ("enableWorkspaceResolution".equals(data)) {//$NON-NLS-1$
				option = ENABLE_WORKSPACE;
			}
			if ("disableWorkspaceResolution".equals(data)) {//$NON-NLS-1$
				option = DISABLE_WORKSPACE;
			}
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	@Override
	public void run(IAction action) {
		Set<IProject> projects = new LinkedHashSet<IProject>();
		projects.add(_project);
		new UpdateJob(projects, option).schedule();
	}

	static class UpdateJob extends WorkspaceJob {
		private final Set<IProject> projects;

		private final int option;

		private final IProjectConfigurationManager importManager;

		private final IMavenProjectRegistry projectManager;

		private final IMavenConfiguration mavenConfiguration;

		public UpdateJob(Set<IProject> projects, int option) {
			super(Messages.ChangeNatureAction_job_changing);
			this.projects = projects;
			this.option = option;

			this.importManager = MavenPlugin.getProjectConfigurationManager();
			this.projectManager = MavenPlugin.getMavenProjectRegistry();

			this.mavenConfiguration = MavenPlugin.getMavenConfiguration();
		}

		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor) {
			MultiStatus status = null;
			for (IProject project : projects) {
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}

				monitor.subTask(project.getName());

				try {
					changeNature(project, monitor);
				} catch (CoreException ex) {
					if (status == null) {
						status = new MultiStatus(IMavenConstants.PLUGIN_ID, IStatus.ERROR,
								Messages.ChangeNatureAction_status_error, null);
					}
					status.add(ex.getStatus());
				}
			}

			boolean offline = mavenConfiguration.isOffline();
			boolean updateSnapshots = false;
			projectManager.refresh(new MavenUpdateRequest(projects.toArray(new IProject[projects.size()]), //
					offline, updateSnapshots));

			return status != null ? status : Status.OK_STATUS;
		}

		private void changeNature(final IProject project, IProgressMonitor monitor) throws CoreException {
			IProjectConfigurationManager configurationManager = MavenPlugin.getProjectConfigurationManager();

			final ResolverConfiguration configuration = configurationManager.getResolverConfiguration(project);

			boolean updateSourceFolders = false;

			switch (option) {
			case ENABLE_WORKSPACE:
				configuration.setResolveWorkspaceProjects(true);
				break;
			case DISABLE_WORKSPACE:
				configuration.setResolveWorkspaceProjects(false);
				break;
			}

			configurationManager.setResolverConfiguration(project, configuration);

			if (updateSourceFolders) {
				importManager.updateProjectConfiguration(project, monitor);
			}
		}
	}

}
