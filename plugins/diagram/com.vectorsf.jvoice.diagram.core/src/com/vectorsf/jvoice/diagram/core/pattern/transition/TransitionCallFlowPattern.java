package com.vectorsf.jvoice.diagram.core.pattern.transition;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import com.vectorsf.jvoice.diagram.core.pattern.states.SimpleStatePattern;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

public class TransitionCallFlowPattern extends TransitionPattern {
	protected State state;
	private IFeatureProvider featureProvider;
	private String eventName;

	public TransitionCallFlowPattern(State state, IFeatureProvider featureProvider) {
		super(featureProvider);
		this.state = state;
		this.featureProvider = featureProvider;
	}

	@Override
	public String getCreateName() {
		return eventName;
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		if (state != null) {

			PictogramElement pe = context.getSourcePictogramElement();

			// Al crear la transición desde el evento lo que llega es un
			// FixPointAnchor
			if (pe instanceof FixPointAnchor) {
				GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();

				if (ga instanceof Image) {
					eventName = Graphiti.getPeService().getPropertyValue(pe, SimpleStatePattern.EVENT_NAME);
				} else {
					eventName = ((Text) ga).getValue();
				}
				pe = ((FixPointAnchor) pe).getParent();
			}

			Object boSource = featureProvider.getBusinessObjectForPictogramElement(pe);

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
