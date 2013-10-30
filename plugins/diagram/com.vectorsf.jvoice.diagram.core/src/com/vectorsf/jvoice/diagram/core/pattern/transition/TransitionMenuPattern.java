package com.vectorsf.jvoice.diagram.core.pattern.transition;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;

import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Output;

public class TransitionMenuPattern extends TransitionPattern {
	protected Output output;
	private IFeatureProvider featureProvider;

	public TransitionMenuPattern(Output menuOutput,
			IFeatureProvider in_featureProvider) {
		super(in_featureProvider);
		output = menuOutput;
		featureProvider = in_featureProvider;
	}

	@Override
	public String getCreateName() {
		return output.getName();
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		if (output != null) {

			Object boSource = featureProvider
					.getBusinessObjectForPictogramElement(context
							.getSourcePictogramElement());

			State stateOrigen = (State) boSource;

			for (Transition transition : stateOrigen.getOutgoingTransitions()) {
				if (transition.getEventName().equals(output.getName())) {
					return false;
				}
			}
		}
		return super.canCreate(context);
	}
}
