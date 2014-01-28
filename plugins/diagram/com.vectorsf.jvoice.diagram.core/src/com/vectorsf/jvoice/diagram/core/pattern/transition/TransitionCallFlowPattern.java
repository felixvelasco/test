package com.vectorsf.jvoice.diagram.core.pattern.transition;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.mm.algorithms.*;
import org.eclipse.graphiti.mm.pictograms.*;

import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

public class TransitionCallFlowPattern extends TransitionPattern {
    protected State state;
    private IFeatureProvider featureProvider;
    private String eventName;

    public TransitionCallFlowPattern(State stateFinal,
	    IFeatureProvider in_featureProvider) {
	super(in_featureProvider);
	state = stateFinal;
	featureProvider = in_featureProvider;
	eventName = state.getName();
    }

    @Override
    public String getCreateName() {
	return eventName;
	// return state.getName();
    }

    @Override
    public boolean canCreate(ICreateConnectionContext context) {
	if (state != null) {

	    PictogramElement pe = context.getSourcePictogramElement();

	    // Al crear la transición desde el evento lo que llega es un
	    // FixPointAnchor
	    if (pe instanceof FixPointAnchor) {
		GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
		
		if(ga instanceof Image)
			eventName = ((Image) ga).getId();
		else
			eventName = ((Text) ga).getValue();
		pe = ((FixPointAnchor) pe).getParent();
	    }

	    Object boSource = featureProvider
		    .getBusinessObjectForPictogramElement(pe);

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
