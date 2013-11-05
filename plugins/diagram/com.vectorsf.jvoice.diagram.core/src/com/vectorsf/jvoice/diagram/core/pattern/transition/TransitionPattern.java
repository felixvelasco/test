package com.vectorsf.jvoice.diagram.core.pattern.transition;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IConnectionContext;
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
import org.eclipse.graphiti.pattern.AbstractConnectionPattern;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;

public class TransitionPattern extends AbstractConnectionPattern {

	protected IPeService peService;
	protected IGaService gaService;

	protected final IColorConstant CONNECTION_COLOR = new ColorConstant("bcbcbc");
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
		State sourceState = getState(((IConnectionContext) context).getSourceAnchor());
		return context.getNewObject() instanceof Transition && !(sourceState instanceof SwitchState)
				&& context instanceof IAddConnectionContext;

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

		Connection connection = (Connection) getFeatureProvider().addIfPossible(addContextInicial);
		layoutPictogramElement(connection);
		return connection;

	}

	protected State getState(Anchor anchor) {

		if (anchor != null) {
			State object = (State) getBusinessObjectForPictogramElement(anchor.getParent());
			return object;
		}
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
		Object boTarget = featureProvider.getBusinessObjectForPictogramElement(context.getTargetPictogramElement());
		Object boSource = featureProvider.getBusinessObjectForPictogramElement(context.getSourcePictogramElement());

		if (boTarget instanceof State) {
			State finalTarget = (State) boTarget;
			State initialSource = (State) boSource;
			if (!(finalTarget instanceof InitialState)) {
				if (!(initialSource instanceof InitialState && initialSource.getOutgoingTransitions().size() > 0)) {
					if (initialSource != finalTarget) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
