package com.vectorsf.jvoice.diagram.core.pattern.transition;

import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

public class TransitionCallFlowPattern extends TransitionPattern {
	protected State state;

	public TransitionCallFlowPattern(State stateFinal,
			IFeatureProvider in_featureProvider) {
		super(in_featureProvider);
		state = stateFinal;
	}

	@Override
	public String getCreateName() {
		return state.getName();
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		if (state != null) {
			Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
			List<Transition> transitions = flow.getTransitions();
			for (Transition transition : transitions) {
				if (transition.getEventName().equals(state.getName())) {
					return false;
				}
			}
		}
		return super.canCreate(context);
	}
}
