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

public class JVoiceJaxWSBuildParticipant extends MojoExecutionBuildParticipant {

	public JVoiceJaxWSBuildParticipant(MojoExecution execution) {
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
				.getCurrentProject(), getMojoExecution(), "sourceRoot",
				File.class, monitor);
		if (generated != null) {
			buildContext.refresh(generated);
		}

		return result;
	}
}
