package com.vectorsf.jvoice.core.project;

import org.apache.maven.model.Model;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.project.ProjectImportConfiguration;

public final class JVoiceProjectConfigurator {

	private JVoiceProjectConfigurator() {
	}

	public static void configureProject(final IProject project) throws CoreException {
		assert project.exists();

		ResourcesPlugin.getWorkspace()
				.run(new AddJVoiceNatureRunnable(project), project, IWorkspace.AVOID_UPDATE, null);

	}

	public static IProject createProject(final String groupId, final String artifactId, final String projectName)
			throws CoreException {
		final IProject result[] = new IProject[1];
		IWorkspaceRunnable action = new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
				MavenPlugin.getProjectConfigurationManager().createSimpleProject(project, null,
						getModel(groupId, artifactId, projectName),
						new String[] { "src/main/java", "src/main/resources/jv" }, new ProjectImportConfiguration(),
						monitor);

				result[0] = project;
			}
		};
		ResourcesPlugin.getWorkspace().run(action, null);
		IProject project = result[0];
		ResourcesPlugin.getWorkspace().run(new AddJVoiceNatureRunnable(project), null);

		return result[0];
	}

	private static Model getModel(String groupId, String artifactId, String projectName) {
		Model model = new Model();
		model.setModelVersion("4.0.0"); //$NON-NLS-1$

		model.setGroupId(groupId);
		model.setArtifactId(artifactId);
		model.setVersion("1.0.0");
		model.setPackaging("jar");

		model.setName(projectName);

		return model;
	}

	private static final class AddJVoiceNatureRunnable implements IWorkspaceRunnable {
		private final IProject project;

		private AddJVoiceNatureRunnable(IProject project) {
			this.project = project;
		}

		@Override
		public void run(IProgressMonitor monitor) throws CoreException {
			IProjectDescription description = project.getDescription();
			String[] natureIds = description.getNatureIds();

			String[] newNatureIds = new String[natureIds.length + 1];
			System.arraycopy(natureIds, 0, newNatureIds, 1, natureIds.length);
			newNatureIds[0] = JVoiceProjectNature.NATURE_ID;
			description.setNatureIds(newNatureIds);

			this.project.setDescription(description, null);
		}
	}

}
