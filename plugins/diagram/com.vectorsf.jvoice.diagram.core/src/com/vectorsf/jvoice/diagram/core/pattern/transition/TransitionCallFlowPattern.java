package com.vectorsf.jvoice.diagram.core.pattern.transition;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;

import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

public class TransitionCallFlowPattern extends TransitionPattern {
	protected State state;
	private IFeatureProvider featureProvider;

	public TransitionCallFlowPattern(State stateFinal,
			IFeatureProvider in_featureProvider) {
		super(in_featureProvider);
		state = stateFinal;
		featureProvider = in_featureProvider;
	}

	@Override
	public String getCreateName() {
		return state.getName();
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		if (state != null) {

			Object boSource = featureProvider
					.getBusinessObjectForPictogramElement(context
							.getSourcePictogramElement());

			State stateOrigen = (State) boSource;

			for (Transition transition : stateOrigen.getOutgoingTransitions()) {
				if (transition.getEventName().equals(state.getName())) {
					return false;
				}
			}
		}
		return super.canCreate(context);
	}
}
