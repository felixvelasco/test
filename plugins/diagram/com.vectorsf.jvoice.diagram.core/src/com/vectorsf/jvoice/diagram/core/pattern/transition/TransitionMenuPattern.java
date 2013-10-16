package com.vectorsf.jvoice.diagram.core.pattern.transition;

import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.Transition;
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

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		if (output != null) {
			Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
			List<Transition> transitions = flow.getTransitions();
			for (Transition transition : transitions) {
				if (transition.getEventName().equals(output.getName())) {
					return false;
				}
			}
		}
		return super.canCreate(context);
	}
}
