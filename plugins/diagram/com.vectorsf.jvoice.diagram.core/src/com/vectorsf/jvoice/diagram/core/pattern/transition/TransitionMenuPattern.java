package com.vectorsf.jvoice.diagram.core.pattern.transition;

import org.eclipse.graphiti.features.IFeatureProvider;

import com.vectorsf.jvoice.prompt.model.voiceDsl.Output;

public class TransitionMenuPattern extends TransitionPattern {
	protected Output output;

	public TransitionMenuPattern(Output menuOutput,
			IFeatureProvider in_featureProvider) {
		super(in_featureProvider);
		output = menuOutput;
	}

	@Override
	public String getCreateName() {
		return output.getName();
	}
}
