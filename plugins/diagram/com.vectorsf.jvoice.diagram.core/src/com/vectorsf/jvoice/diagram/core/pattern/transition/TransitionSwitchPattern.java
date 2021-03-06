package com.vectorsf.jvoice.diagram.core.pattern.transition;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

public class TransitionSwitchPattern extends TransitionPattern {

	protected IPeService peService;
	protected IGaService gaService;
	protected Case cas;

	protected final IColorConstant CONNECTION_COLOR = new ColorConstant("bcbcbc");
	private IFeatureProvider featureProvider;

	public TransitionSwitchPattern(Case ca, IFeatureProvider in_featureProvider) {
		super(in_featureProvider);
		featureProvider = in_featureProvider;
		peService = Graphiti.getPeService();
		gaService = Graphiti.getGaService();
		cas = ca;
	}

	public TransitionSwitchPattern(IFeatureProvider in_featureProvider) {
		super(in_featureProvider);
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
		return context.getNewObject() instanceof Transition && context instanceof IAddConnectionContext;

	}

	@Override
	public PictogramElement add(IAddContext context) {
		Transition transition = (Transition) context.getNewObject();

		if (context instanceof IAddConnectionContext) {

			Anchor anchor = ((IAddConnectionContext) context).getSourceAnchor();
			//
			if (anchor == null) {
				Anchor chopboxAnchor = peService.getChopboxAnchor(context.getTargetContainer());
				if (chopboxAnchor != null) {
					anchor = chopboxAnchor;
				} else {
					anchor = peService.createChopboxAnchor(context.getTargetContainer());
				}
			}
			Connection connection = peService.createFreeFormConnection(getDiagram());
			connection.setStart(anchor);
			connection.setEnd(((IAddConnectionContext) context).getTargetAnchor());

			Polyline polylineFinal = gaService.createPolyline(connection);
			polylineFinal.setLineWidth(2);

			polylineFinal.setForeground(manageColor(CONNECTION_COLOR));

			ConnectionDecorator cd;
			cd = peService.createConnectionDecorator(connection, false, 1.0, true);
			createArrow(cd);

			link(connection, transition);
			return connection;
		}
		return null;
	}

	@Override
	protected Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {
		Polygon polyligone = gaService.createPolygon(gaContainer, new int[] { -7, 4, 2, 0, -7, -4, -1, 0, -7, 4, -3, 0,
				-7, -4, -5, 0, -7, 4 });

		polyligone.setForeground(manageColor(CONNECTION_COLOR));
		polyligone.setBackground(manageColor(CONNECTION_COLOR));

		polyligone.setLineWidth(1);

		return polyligone;

	}

	@Override
	public Connection create(ICreateConnectionContext context) {

		State sourceState = getState(context.getSourceAnchor());
		State targetState = getState(context.getTargetAnchor());

		if (sourceState == null || targetState == null) {
			return null;
		}

		Transition transition = OperationsFactory.eINSTANCE.createTransition();
		transition.setSource(sourceState);
		transition.setEventName(getCreateName());
		transition.setTarget(targetState);

		targetState.getIncomingTransitions().add(transition);
		sourceState.getOutgoingTransitions().add(transition);

		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		flow.getTransitions().add(transition);

		AddConnectionContext addContextInicial = new AddConnectionContext(context.getSourceAnchor(),
				context.getTargetAnchor());
		addContextInicial.setNewObject(transition);
		addContextInicial.setTargetContainer((ContainerShape) context.getSourcePictogramElement());

		Connection connection = (Connection) add(addContextInicial);
		layoutPictogramElement(connection);
		return connection;

	}

	@Override
	protected State getState(Anchor anchor) {

		if (anchor != null) {
			State object = (State) getBusinessObjectForPictogramElement(anchor.getParent());
			return object;
		}
		return null;
	}

	@Override
	public String getCreateName() {
		if (cas != null) {
			return cas.getEventName();
		} else {
			return "Transition";
		}
	}

	@Override
	public String getCreateDescription() {
		return "Transition Description";
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {

		if (cas != null) {
			Object boSource = featureProvider.getBusinessObjectForPictogramElement(context.getSourcePictogramElement());

			State stateOrigen = (State) boSource;

			for (Transition transition : stateOrigen.getOutgoingTransitions()) {
				if (transition.getEventName().equals(cas.getEventName())) {
					return false;
				}
			}
		}
		return super.canCreate(context);
	}

}
