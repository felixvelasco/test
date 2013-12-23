package com.vectorsf.jvoice.diagram.core.pattern.transition;

import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import com.vectorsf.jvoice.diagram.core.features.CoreFeatureProvider;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
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

		PictogramElement targetPictogramElement = context.getTargetPictogramElement();

		Connection connection = context.getConnection();
		Transition transition = (Transition) getBusinessObjectForPictogramElement(connection);
		State oldTargetState = transition.getSource();
		Object targetBO = getBusinessObjectForPictogramElement(targetPictogramElement);

		if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {

			if (!(targetPictogramElement instanceof ContainerShape)) {
				return false;
			}

			State finalState = transition.getTarget();

			if (!(targetBO instanceof State)) {
				return false;
			}

			if ((State) targetBO == finalState) {
				return false;
			}

			if (oldTargetState instanceof LocutionState || targetBO instanceof LocutionState) {
				return false;
			} else if (oldTargetState instanceof SwitchState || targetBO instanceof SwitchState) {
				return false;
			} else if (targetBO instanceof FinalState) {
				return false;
			} else if (oldTargetState instanceof InitialState || targetBO instanceof InitialState) {
				return false;
			} else {
				return super.canReconnect(context);
			}

		}

		if (!(targetPictogramElement instanceof ContainerShape)) {
			return false;
		}

		if (!(targetBO instanceof State)) {
			return false;
		}

		if (targetBO instanceof InitialState) {
			return false;
		}

		if ((State) targetBO == oldTargetState) {
			return false;
		}

		return super.canReconnect(context);
	}

	@Override
	public void preReconnect(IReconnectionContext context) {
		Connection connection = context.getConnection();
		PictogramElement targetPictogramElement = context.getTargetPictogramElement();

		Transition transition = (Transition) getBusinessObjectForPictogramElement(connection);
		State targetState = (State) getBusinessObjectForPictogramElement(targetPictogramElement);

		if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
			transition.setSource(targetState);
		} else {
			transition.setTarget(targetState);
		}

	}

	@Override
	public void postReconnect(IReconnectionContext context) {
		layoutPictogramElement(context.getConnection());
		Transition transition = (Transition) getBusinessObjectForPictogramElement(context.getConnection());

		if (transition.getSource() instanceof InitialState) {
			layoutPictogramElement(Graphiti.getLinkService().getPictogramElements(getDiagram(), transition.getSource())
					.get(0));
		}

	}
}
