package com.isb.bks.ivr.voice.m2e.builder.internal;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.MojoExecution;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.embedder.IMaven;
import org.eclipse.m2e.core.project.configurator.MojoExecutionBuildParticipant;
import org.sonatype.plexus.build.incremental.BuildContext;

public class JVoiceApplicationBuildParticipant extends MojoExecutionBuildParticipant {

	public JVoiceApplicationBuildParticipant(MojoExecution execution) {
		super(execution, true);
	}

	@Override
	public Set<IProject> build(int kind, IProgressMonitor monitor) throws Exception {
		IMaven maven = MavenPlugin.getMaven();
		BuildContext buildContext = getBuildContext();

		// execute mojo
		super.build(kind, monitor);

		// tell m2e builder to refresh generated files
		MavenProject currentProject = getSession().getCurrentProject();
		File generated = maven.getMojoParameterValue(currentProject, getMojoExecution(), "outputDirectory", File.class,
				monitor);

		if (generated != null) {
			buildContext.refresh(generated);
		}

		// refreshes /src/main/webapp/resources directory if exists
		File webAppResources = new File(currentProject.getBasedir() + "/src/main/webapp/resources");

		if (webAppResources != null) {
			buildContext.refresh(webAppResources);
		}

		int index = currentProject.getResources().size();
		String resourceDir;
		// refreshes each resources directory
		for (int i = 0; i < index; i++) {
			resourceDir = currentProject.getResources().get(i).getDirectory();
			buildContext.refresh(new File(resourceDir));
		}

		// Busco los módulos de los que depende la aplicación para
		// que funcione bien el hotdeploy de m2e-wtp.
		Set<IProject> dependentProjects = new HashSet<IProject>();
		getDependentProjects(currentProject, dependentProjects);

		return dependentProjects;
	}

	/**
	 * Buscar recursivamente los proyectos referenciados por la aplicación.
	 */
	private void getDependentProjects(MavenProject currentProject, Set<IProject> dependentProjects) {
		for (Dependency dependency : currentProject.getDependencies()) {
			IProject prj = ResourcesPlugin.getWorkspace().getRoot().getProject(dependency.getArtifactId());

			if (prj.exists()) {
				dependentProjects.add(prj);
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@Añado: " + prj.getName());

				currentProject = MavenPlugin.getMavenProjectRegistry().getProject(prj).getMavenProject();
				if (currentProject != null) {
					getDependentProjects(currentProject, dependentProjects);
				} else {
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ null: " + prj.getName());
				}
			}
		}
	}
}