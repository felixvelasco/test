package com.vectorsf.jvoice.diagram.core.pattern;

import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;

public class InitialStatePattern extends StatePattern {

	private static final int MIN_WIDTH = 80;
	private static final int MIN_HEIGHT = 80;
	private static final String ID_INITIAL_PREFIX = "initialState_";
	private static final String ID_NAME_TEXT = ID_INITIAL_PREFIX + "nameText";
	private static final String ID_OUTER_RECTANGLE = ID_INITIAL_PREFIX
			+ "outerRectangle";
	private static final String ID_MAIN_CIRCLE = ID_INITIAL_PREFIX
			+ "mainCircle";

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		InitialState addedDomainObject = (InitialState) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		// Outer container (invisible)
		ContainerShape outerContainerShape = peCreateService
				.createContainerShape(targetDiagram, true);
		Rectangle outerRectangle = gaService
				.createInvisibleRectangle(outerContainerShape);
		setId(outerRectangle, ID_OUTER_RECTANGLE);
		gaService.setLocationAndSize(outerRectangle, context.getX(),
				context.getY(), Math.max(MIN_WIDTH, context.getWidth()),
				Math.max(MIN_HEIGHT, context.getHeight()));

		final int width = MIN_WIDTH;
		final int height = MIN_HEIGHT;
		ContainerShape parent = context.getTargetContainer();
		int x = context.getX();
		int y = context.getY();

		ILocation shapeLocation = Graphiti.getLayoutService()
				.getLocationRelativeToDiagram(parent);
		x += shapeLocation.getX();
		y += shapeLocation.getY();

		Ellipse circle;
		{
			final Ellipse invisibleCircle = gaService
					.createEllipse(outerContainerShape);
			invisibleCircle.setFilled(false);
			invisibleCircle.setLineVisible(false);
			gaService.setLocationAndSize(invisibleCircle, x, y, width, height);

			// create and set visible circle inside invisible circle
			circle = gaService.createEllipse(invisibleCircle);
			circle.setParentGraphicsAlgorithm(invisibleCircle);
			gaService.setLocationAndSize(circle, 0, 0, width, height);

		}
		setId(circle, ID_MAIN_CIRCLE);
		gaService.setRenderingStyle(circle,
				StatePredefinedColoredAreas.getRedWhiteAdaptions());

		// name
		Shape shape = peCreateService.createShape(outerContainerShape, false);
		Text text = gaService.createText(shape, addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setRenderingStyle(text,
				StatePredefinedColoredAreas.getRedWhiteAdaptions());
		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);
		link(shape, addedDomainObject);

		return outerContainerShape;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		boolean changesDone = false;

		Ellipse outerCircle = (Ellipse) context.getRootPictogramElement()
				.getGraphicsAlgorithm();

		if (id.equals(ID_MAIN_CIRCLE) || id.equals(ID_NAME_TEXT)) {
			GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
			if (ga.getWidth() != outerCircle.getWidth()
					|| ga.getHeight() != outerCircle.getHeight()) {
				Graphiti.getGaService().setLocationAndSize(ga, 0, 0,
						outerCircle.getWidth(), outerCircle.getHeight());
				changesDone = true;
			}
		}
		return changesDone;
	}

	@Override
	public Object[] create(ICreateContext context) {

		InitialState ss = OperationsFactory.eINSTANCE.createInitialState();
		ss.setName("Initial");

		addGraphicalRepresentation(context, ss);

		return new Object[] { ss };
	}

	@Override
	public String getCreateName() {
		return "Initial";
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			InitialState ss = (InitialState) getBusinessObjectForPictogramElement(context
					.getPictogramElement());
			Text text = (Text) context.getGraphicsAlgorithm();
			if (!text.getValue().equals(ss.getName())) {
				return Reason.createTrueReason();
			}
		}
		return Reason.createFalseReason();
	}

	@Override
	protected boolean update(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			InitialState ss = (InitialState) getBusinessObjectForPictogramElement(context
					.getPictogramElement());
			Text text = (Text) context.getGraphicsAlgorithm();
			text.setValue(ss.getName());
			return true;
		}
		return false;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof InitialState;
	}

	@Override
	protected void setValue(String value, IDirectEditingContext context,
			String id) {
		if (id.equals(ID_NAME_TEXT)) {
			InitialState ss = (InitialState) getBusinessObjectForPictogramElement(context
					.getPictogramElement());
			ss.setName(value);
			updatePictogramElement(context.getPictogramElement());
		}
	}
}
