package com.vectorsf.jvoice.diagram.core.pattern;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.AbstractConnectionPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

public class TransitionPattern extends AbstractConnectionPattern {

	private IPeService peService;
	private IGaService gaService;

	private final IColorConstant CONNECTION_COLOR = new ColorConstant("bcbcbc");
	private IFeatureProvider featureProvider;

	public TransitionPattern(IFeatureProvider in_featureProvider) {
		featureProvider = in_featureProvider;
		peService = Graphiti.getPeService();
		gaService = Graphiti.getGaService();
	}

	@Override
	public IFeatureProvider getFeatureProvider() {
		return featureProvider;
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return context.getNewObject() instanceof Transition
				&& context instanceof IAddConnectionContext;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		Transition transition = (Transition) context.getNewObject();

		if (context instanceof IAddConnectionContext) {

			Anchor anchor = ((IAddConnectionContext) context).getSourceAnchor();
			//
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

			link(connection, transition);
			return connection;
		}
		return null;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Transition ss = OperationsFactory.eINSTANCE.createTransition();
		ss.setEventName("trans_1");
		addGraphicalRepresentation(context, ss);
		return null;
	}

	@Override
	public String getCreateName() {
		return "Transition";
	}

	@Override
	public String getCreateDescription() {
		return "Transition Description";
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		Object boTarget = featureProvider
				.getBusinessObjectForPictogramElement(context
						.getTargetPictogramElement());
		return boTarget instanceof State && !(boTarget instanceof InitialState);

	}

}
