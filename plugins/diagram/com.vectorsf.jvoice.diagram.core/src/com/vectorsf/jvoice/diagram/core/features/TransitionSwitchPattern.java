package com.vectorsf.jvoice.diagram.core.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IConnectionContext;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.vectorsf.jvoice.diagram.core.pattern.TransitionPattern;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;

public class TransitionSwitchPattern extends TransitionPattern {

	public TransitionSwitchPattern(IFeatureProvider in_featureProvider) {
		super(in_featureProvider);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return context.getNewObject() instanceof Transition
				&& getState(((IConnectionContext) context).getSourceAnchor()) instanceof SwitchState
				&& context instanceof IAddConnectionContext;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		Transition transition = (Transition) context.getNewObject();

		if (context instanceof IAddConnectionContext) {

			Anchor anchor = ((IAddConnectionContext) context).getSourceAnchor();
			if (anchor == null) {
				Anchor chopboxAnchor = peService.getChopboxAnchor(context
						.getTargetContainer());
				if (chopboxAnchor != null) {
					anchor = chopboxAnchor;
				} else {
					anchor = peService.createChopboxAnchor(context
							.getTargetContainer());
				}
			}
			Connection connection = peService
					.createFreeFormConnection(getDiagram());
			connection.setStart(anchor);
			connection.setEnd(((IAddConnectionContext) context)
					.getTargetAnchor());

			Polyline polylineFinal = gaService.createPolyline(connection);
			polylineFinal.setLineWidth(2);

			polylineFinal.setForeground(manageColor(CONNECTION_COLOR));

			ConnectionDecorator cd;
			cd = peService.createConnectionDecorator(connection, false, 1.0,
					true);
			createArrow(cd);

			link(connection, transition);
			return connection;
		}
		return null;
	}
}
