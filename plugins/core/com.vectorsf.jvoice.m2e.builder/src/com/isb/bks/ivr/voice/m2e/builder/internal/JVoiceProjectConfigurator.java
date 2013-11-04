package com.isb.bks.ivr.voice.m2e.builder.internal;

import org.apache.maven.plugin.MojoExecution;
import org.eclipse.core.runtime.*;
import org.eclipse.m2e.core.lifecyclemapping.model.IPluginExecutionMetadata;
import org.eclipse.m2e.core.project.IMavenProjectFacade;
import org.eclipse.m2e.core.project.configurator.*;

public class JVoiceProjectConfigurator extends AbstractProjectConfigurator
{

	@Override
	public AbstractBuildParticipant getBuildParticipant(IMavenProjectFacade projectFacade, MojoExecution execution,
		IPluginExecutionMetadata executionMetadata)
	{
		return new JVoiceBuildParticipant(execution);
	}

	@Override
	public void configure(ProjectConfigurationRequest request, IProgressMonitor monitor) throws CoreException
	{
	}

}