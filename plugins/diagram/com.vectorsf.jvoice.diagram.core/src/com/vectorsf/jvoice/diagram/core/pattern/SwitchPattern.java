package com.vectorsf.jvoice.diagram.core.pattern;

import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
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

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.SwitchState;

public class SwitchPattern extends StatePattern {

	private static final int MIN_WIDTH = 120;
	private static final int MIN_HEIGHT = 80;
	private static final String ID_SWITCH_PREFIX = "switchState_";
	private static final String ID_NAME_TEXT = ID_SWITCH_PREFIX + "nameText";
	private static final String ID_OUTER_RECTANGLE = ID_SWITCH_PREFIX
			+ "outerRectangle";
	private static final String ID_MAIN_RECTANGLE = ID_SWITCH_PREFIX
			+ "mainRectangle";
	private static final String ID_CASE_POLYGON = ID_SWITCH_PREFIX
			+ "casePolygon";

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		SwitchState addedDomainObject = (SwitchState) context.getNewObject();
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

		// Default end point
		Polygon endPoint = gaService.createPlainPolygon(outerRectangle,
				new int[] { 0, 0, 20, 40, 40, 0 });
		setId(endPoint, ID_CASE_POLYGON);
		setIndex(endPoint, 0);
		endPoint.setFilled(true);
		gaService.setRenderingStyle(endPoint,
				StatePredefinedColoredAreas.getGreenWhiteAdaptions());

		// Main contents area
		Rectangle mainRectangle = gaService.createRectangle(outerRectangle);
		setId(mainRectangle, ID_MAIN_RECTANGLE);
		mainRectangle.setFilled(true);
		gaService.setRenderingStyle(mainRectangle,
				StatePredefinedColoredAreas.getGreenWhiteAdaptions());

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
	protected boolean layout(IdLayoutContext context, String id) {
		boolean changesDone = false;

		Rectangle outerRectangle = (Rectangle) context
				.getRootPictogramElement().getGraphicsAlgorithm();

		if (id.equals(ID_MAIN_RECTANGLE) || id.equals(ID_NAME_TEXT)) {
			GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
			if (ga.getWidth() != outerRectangle.getWidth()
					|| ga.getHeight() != outerRectangle.getHeight() - 20) {
				Graphiti.getGaService().setLocationAndSize(ga, 0, 0,
						outerRectangle.getWidth(),
						outerRectangle.getHeight() - 20);
				changesDone = true;
			}
		}
		if (id.equals(ID_CASE_POLYGON)) {
			GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
			int x = outerRectangle.getWidth() / 2 - 20;
			int y = outerRectangle.getHeight() - 40;
			if (ga.getX() != x || ga.getY() != y) {
				Graphiti.getGaService().setLocationAndSize(ga, x, y, 40, 40);
				changesDone = true;
			}
		}

		return changesDone;
	}

	@Override
	public Object[] create(ICreateContext context) {
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		SwitchState ss = OperationsFactory.eINSTANCE.createSwitchState();
		ss.setName("Switch");
		flow.getStates().add(ss);

		addGraphicalRepresentation(context, ss);

		return new Object[] { ss };
	}

	@Override
	public String getCreateName() {
		return "Switch";
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			SwitchState ss = (SwitchState) getBusinessObjectForPictogramElement(context
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
			SwitchState ss = (SwitchState) getBusinessObjectForPictogramElement(context
					.getPictogramElement());
			Text text = (Text) context.getGraphicsAlgorithm();
			text.setValue(ss.getName());
			return true;
		}
		return false;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof SwitchState;
	}

	@Override
	protected void setValue(String value, IDirectEditingContext context,
			String id) {
		if (id.equals(ID_NAME_TEXT)) {
			SwitchState ss = (SwitchState) getBusinessObjectForPictogramElement(context
					.getPictogramElement());
			ss.setName(value);
			updatePictogramElement(context.getPictogramElement());
		}
	}
}
