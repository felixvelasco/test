package com.vectorsf.jvoice.diagram.core.pattern;

import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.func.IDirectEditing;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdPattern;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;

public class FinalStatePattern extends IdPattern {

	private static final int MIN_WIDTH = 100;
	private static final int MIN_HEIGHT = 60;
	private static final String ID_FINAL_PREFIX = "finalState_";
	private static final String ID_NAME_TEXT = ID_FINAL_PREFIX + "nameText";
	private static final String ID_OUTER_RECTANGLE = ID_FINAL_PREFIX
			+ "outerRectangle";
	private static final String ID_MAIN_RECTANGLE = ID_FINAL_PREFIX
			+ "mainRectangle";

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context);
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		FinalState addedDomainObject = (FinalState) context.getNewObject();
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

		// Main contents area
		Rectangle mainRectangle = gaService.createRectangle(outerRectangle);
		setId(mainRectangle, ID_MAIN_RECTANGLE);
		mainRectangle.setFilled(true);
		gaService.setRenderingStyle(mainRectangle,
				FinalStatePredefinedColoredAreas.getGreenWhiteAdaptions());

		// File name
		Shape shape = peCreateService.createShape(outerContainerShape, false);
		Text text = gaService.createText(shape, addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);
		link(shape, addedDomainObject);

		return outerContainerShape;
	}

	@Override
	public void resizeShape(IResizeShapeContext context) {
		if (context.getWidth() < MIN_WIDTH || context.getHeight() < MIN_HEIGHT) {
			ResizeShapeContext context2 = new ResizeShapeContext(
					context.getShape());
			context2.setWidth(Math.max(MIN_WIDTH, context.getWidth()));
			context2.setHeight(Math.max(MIN_HEIGHT, context.getHeight()));
			context2.setX(context.getX());
			context2.setY(context.getY());
			context2.setDirection(context.getDirection());
			super.resizeShape(context2);
		} else {
			super.resizeShape(context);
		}
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		boolean changesDone = false;

		Rectangle outerRectangle = (Rectangle) context
				.getRootPictogramElement().getGraphicsAlgorithm();

		if (id.equals(ID_MAIN_RECTANGLE) || id.equals(ID_NAME_TEXT)) {
			GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
			if (ga.getWidth() != outerRectangle.getWidth()
					|| ga.getHeight() != outerRectangle.getHeight()) {
				Graphiti.getGaService().setLocationAndSize(ga, 0, 0,
						outerRectangle.getWidth(), outerRectangle.getHeight());
				changesDone = true;
			}
		}

		return changesDone;
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {

		FinalState ss = OperationsFactory.eINSTANCE.createFinalState();
		ss.setName("Final");

		addGraphicalRepresentation(context, ss);

		return new Object[] { ss };
	}

	@Override
	public String getCreateName() {
		return "Final";
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			FinalState ss = (FinalState) getBusinessObjectForPictogramElement(context
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
			FinalState ss = (FinalState) getBusinessObjectForPictogramElement(context
					.getPictogramElement());
			Text text = (Text) context.getGraphicsAlgorithm();
			text.setValue(ss.getName());
			return true;
		}
		return false;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof FinalState;
	}

	@Override
	protected boolean canDirectEdit(IDirectEditingContext context, String id) {
		return id.equals(ID_NAME_TEXT);
	}

	@Override
	public int getEditingType() {
		return IDirectEditing.TYPE_TEXT;
	}

	@Override
	protected void setValue(String value, IDirectEditingContext context,
			String id) {
		if (id.equals(ID_NAME_TEXT)) {
			FinalState ss = (FinalState) getBusinessObjectForPictogramElement(context
					.getPictogramElement());
			ss.setName(value);
			updatePictogramElement(context.getPictogramElement());
		}
	}
}
