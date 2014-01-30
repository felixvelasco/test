package com.vectorsf.jvoice.m2e.builder.internal;

import java.io.File;
import java.util.Set;

import org.apache.maven.plugin.MojoExecution;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.embedder.IMaven;
import org.eclipse.m2e.core.project.configurator.MojoExecutionBuildParticipant;
import org.sonatype.plexus.build.incremental.BuildContext;

public class JVoiceApplicationBuildParticipant extends
		MojoExecutionBuildParticipant {

	public JVoiceApplicationBuildParticipant(MojoExecution execution) {
		super(execution, true);
	}

	@Override
	public Set<IProject> build(int kind, IProgressMonitor monitor)
			throws Exception {
		IMaven maven = MavenPlugin.getMaven();
		BuildContext buildContext = getBuildContext();

		// execute mojo
		Set<IProject> result = super.build(kind, monitor);

		// tell m2e builder to refresh generated files
		File generated = maven.getMojoParameterValue(getSession()
				.getCurrentProject(), getMojoExecution(), "outputDirectory",
				File.class, monitor);

		if (generated != null) {
			buildContext.refresh(generated);
		}

		// refreshes /src/main/webapp/resources directory if exists
		File webAppResources = new File(getSession().getCurrentProject()
				.getBasedir() + "/src/main/webapp/resources");

		if (webAppResources != null) {
			buildContext.refresh(webAppResources);
		}

		int index = getSession().getCurrentProject().getResources().size();
		String resourceDir;
		// refreshes each resources directory
		for (int i = 0; i < index; i++) {
			resourceDir = getSession().getCurrentProject().getResources()
					.get(i).getDirectory();
			buildContext.refresh(new File(resourceDir));
		}

		return result;
	}
}