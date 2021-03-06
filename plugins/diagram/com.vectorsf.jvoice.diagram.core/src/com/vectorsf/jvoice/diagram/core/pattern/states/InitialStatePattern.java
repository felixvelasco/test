package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.List;

import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdPattern;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.State;

public class InitialStatePattern extends IdPattern {

	private static final String INITIAL = "Initial";
	private static final int WIDTH = 556;
	private static final int HEIGHT = 3;
	private static final String ID_ROUNDED_RECTANGLE = "roundedRectangle";
	private static final IColorConstant BACKGROUND_COLOR = new ColorConstant("0083a9");

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		InitialState addedDomainObject = (InitialState) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		ContainerShape outerContainerShape = peCreateService.createContainerShape(getDiagram(), true);

		Polygon polygon = gaService.createPlainPolygon(outerContainerShape, new int[] { 0, 0, 556, 0, 553, 2, 284, 2,
				278, 8, 272, 2, 2, 2 });

		setId(polygon, ID_ROUNDED_RECTANGLE);
		polygon.setBackground(manageColor(BACKGROUND_COLOR));
		polygon.setFilled(true);
		polygon.setLineVisible(false);
		polygon.setLineWidth(0);
		gaService.setLocationAndSize(polygon, context.getX(), 0, WIDTH, HEIGHT);

		peCreateService.createChopboxAnchor(outerContainerShape);
		link(outerContainerShape, addedDomainObject);

		return outerContainerShape;
	}

	@Override
	public boolean isPaletteApplicable() {
		return false;
	}

	@Override
	public Object[] create(ICreateContext context) {

		InitialState is = OperationsFactory.eINSTANCE.createInitialState();
		is.setName(INITIAL);
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		flow.getStates().add(is);

		addGraphicalRepresentation(context, is);

		return new Object[] { is };
	}

	@Override
	public String getCreateName() {
		return INITIAL;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof InitialState;
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (context.getTargetContainer() instanceof Diagram) {
			Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
			List<State> states = flow.getStates();
			for (State sta : states) {
				if (sta instanceof InitialState) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		if (id.equals(ID_ROUNDED_RECTANGLE)) {
			GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
			int midPoint = ga.getX() + ga.getWidth() / 2;

			InitialState state = (InitialState) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
			State next = state.getOutgoingTransitions().isEmpty() ? null : state.getOutgoingTransitions().get(0)
					.getTarget();
			if (next == null) {
				return false;
			}

			PictogramElement nextPe = Graphiti.getLinkService().getPictogramElements(getDiagram(), next).get(0);
			GraphicsAlgorithm nextGa = nextPe.getGraphicsAlgorithm();
			int nextMidPoint = nextGa.getX() + nextGa.getWidth() / 2;

			int newX = ga.getX() + nextMidPoint - midPoint;
			ga.setX(newX);

			return newX != 0;

		}
		return false;
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		return Reason.createFalseReason();
	}

	@Override
	protected boolean update(IdUpdateContext context, String id) {
		return false;
	}

	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		return false;
	}

	@Override
	public boolean canMoveShape(IMoveShapeContext context) {
		return super.canMoveShape(context) && context.getDeltaY() == 0;
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		return false;
	}

}
