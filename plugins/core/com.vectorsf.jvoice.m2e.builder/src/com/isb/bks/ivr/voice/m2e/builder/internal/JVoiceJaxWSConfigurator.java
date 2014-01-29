package com.isb.bks.ivr.voice.m2e.builder.internal;

import org.apache.maven.plugin.MojoExecution;
import org.eclipse.m2e.core.lifecyclemapping.model.IPluginExecutionMetadata;
import org.eclipse.m2e.core.project.IMavenProjectFacade;
import org.eclipse.m2e.core.project.configurator.AbstractBuildParticipant;
import org.eclipse.m2e.jdt.AbstractSourcesGenerationProjectConfigurator;

public class JVoiceJaxWSConfigurator extends

AbstractSourcesGenerationProjectConfigurator {

	@Override
	public AbstractBuildParticipant getBuildParticipant(

	IMavenProjectFacade projectFacade, MojoExecution execution,

	IPluginExecutionMetadata executionMetadata) {

		return new JVoiceJaxWSBuildParticipant(execution);

	}

	@Override
	protected String getOutputFolderParameterName() {
		return "sourceRoot";
	}

}