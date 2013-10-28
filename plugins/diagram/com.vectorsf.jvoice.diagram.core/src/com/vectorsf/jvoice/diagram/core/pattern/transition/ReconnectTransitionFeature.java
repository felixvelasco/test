package com.vectorsf.jvoice.diagram.core.pattern.transition;

import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.vectorsf.jvoice.diagram.core.features.CoreFeatureProvider;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

public class ReconnectTransitionFeature extends DefaultReconnectionFeature {

	private CoreFeatureProvider fp;

	public ReconnectTransitionFeature(CoreFeatureProvider fp) {
		super(fp);
		this.fp = fp;
	}

	@Override
	public CoreFeatureProvider getFeatureProvider() {
		return fp;
	}

	@Override
	public boolean canReconnect(IReconnectionContext context) {
		if (context.getReconnectType().equals(
				ReconnectionContext.RECONNECT_SOURCE)) {
			return false;
		}

		PictogramElement targetPictogramElement = context
				.getTargetPictogramElement();
		if (!(targetPictogramElement instanceof ContainerShape)) {
			return false;
		}

		Object targetBO = getBusinessObjectForPictogramElement(targetPictogramElement);
		if (targetBO instanceof InitialState) {
			return false;
		}

		return super.canReconnect(context);
	}

	@Override
	public void preReconnect(IReconnectionContext context) {
		Connection connection = context.getConnection();
		PictogramElement targetPictogramElement = context
				.getTargetPictogramElement();

		Transition transition = (Transition) getBusinessObjectForPictogramElement(connection);
		State targetState = (State) getBusinessObjectForPictogramElement(targetPictogramElement);

		State oldTargetState = transition.getTarget();
		oldTargetState.getIncomingTransitions().remove(transition);
		transition.setTarget(targetState);
		targetState.getIncomingTransitions().add(transition);
	}

	@Override
	public void postReconnect(IReconnectionContext context) {
		layoutPictogramElement(context.getConnection());
	}
}
