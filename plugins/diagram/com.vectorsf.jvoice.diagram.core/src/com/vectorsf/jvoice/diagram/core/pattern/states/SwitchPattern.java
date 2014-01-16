package com.vectorsf.jvoice.diagram.core.pattern.states;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.diagram.core.pattern.StatePredefinedColoredAreas;
import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.SwitchState;

public class SwitchPattern extends StatePattern {

	private static final String SWITCH = "Switch";
	private static final int MIN_WIDTH = 120;
	private static final int MIN_HEIGHT = 80;
	private static final String ID_CASE_POLYGON = "casePolygon";

	@Override
	protected PictogramElement doAdd(IAddContext context) {

		SwitchState addedDomainObject = (SwitchState) context.getNewObject();
		Case caseDefault = OperationsFactory.eINSTANCE.createCase();
		// Se comprueba de que exista un estado default por si estamos copiando un switch.
		Boolean nohaydefault = false;
		EList<Case> listCase = addedDomainObject.getCase();
		for (Case cases : listCase) {
			if (cases.getEventName().equals("default")) {
				nohaydefault = true;
				break;
			}
		}
		if (!nohaydefault) {
			caseDefault.setEventName("default");
			addedDomainObject.getCase().add(caseDefault);
		}
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		// Outer container (invisible)
		ContainerShape outerContainerShape = peCreateService.createContainerShape(getDiagram(), true);
		Rectangle outerRectangle = gaService.createInvisibleRectangle(outerContainerShape);
		gaService.setLocationAndSize(outerRectangle, context.getX(), context.getY(),
				Math.max(MIN_WIDTH, context.getWidth()), Math.max(MIN_HEIGHT, context.getHeight()));

		// Default end point
		Polygon endPoint = gaService.createPlainPolygon(outerRectangle, new int[] { 0, 0, 20, 40, 40, 0 });
		setId(endPoint, ID_CASE_POLYGON);
		setIndex(endPoint, 0);
		endPoint.setFilled(true);
		gaService.setRenderingStyle(endPoint, StatePredefinedColoredAreas.getGreenWhiteAdaptions());

		// Main contents area,
		// this comment is to know if its true that Jose Luis is reading
		// comments.
		Rectangle mainRectangle = gaService.createRectangle(outerRectangle);
		setId(mainRectangle, ID_MAIN_FIGURE);
		mainRectangle.setFilled(true);
		gaService.setRenderingStyle(mainRectangle, StatePredefinedColoredAreas.getGreenWhiteAdaptions());

		Text text = gaService.createText(mainRectangle, addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);

		return outerContainerShape;

	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		boolean changesDone = false;

		Rectangle outerRectangle = (Rectangle) context.getRootPictogramElement().getGraphicsAlgorithm();

		if (id.equals(ID_MAIN_FIGURE) || id.equals(ID_NAME_TEXT)) {
			GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
			if (ga.getWidth() != outerRectangle.getWidth() || ga.getHeight() != outerRectangle.getHeight() - 20) {
				Graphiti.getGaService().setLocationAndSize(ga, 0, 0, outerRectangle.getWidth(),
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
		ss.setName(SWITCH);
		flow.getStates().add(ss);

		addGraphicalRepresentation(context, ss);

		return new Object[] { ss };
	}

	@Override
	public String getCreateName() {
		return SWITCH;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof SwitchState;
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_SWITCH;
	}

	@Override
	public String getCreateLargeImageId() {
		return CoreImageProvider.IMG_LARGE_PALETTE_SWITCH;
	}
}
