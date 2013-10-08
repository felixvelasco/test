package com.vectorsf.jvoice.diagram.core.pattern.states;

import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import com.vectorsf.jvoice.diagram.core.pattern.StatePredefinedColoredAreas;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;

public class InitialStatePattern extends StatePattern {

	private static final int MIN_WIDTH = 60;
	private static final int MIN_HEIGHT = 60;
	private static final String ID_INITIAL_PREFIX = "initialState_";
	private static final String ID_MAIN_CIRCLE = ID_INITIAL_PREFIX
			+ "mainCircle";

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		InitialState addedDomainObject = (InitialState) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		final int width = MIN_WIDTH;
		final int height = MIN_HEIGHT;
		ContainerShape outerContainerShape = peCreateService
				.createContainerShape(getDiagram(), true);
		Ellipse circle;
		{

			circle = gaService.createEllipse(outerContainerShape);
			gaService.setLocationAndSize(circle, context.getX(),
					context.getY(), width, height);
		}
		gaService.setRenderingStyle(circle,
				StatePredefinedColoredAreas.getRedWhiteAdaptions());
		setId(circle, ID_MAIN_CIRCLE);

		Text text = gaService.createText(circle, addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setRenderingStyle(text,
				StatePredefinedColoredAreas.getRedWhiteAdaptions());
		gaService.setLocationAndSize(text, 0, 0, width, height);
		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);

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

		InitialState is = OperationsFactory.eINSTANCE.createInitialState();
		is.setName("Initial");
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		flow.getStates().add(is);

		addGraphicalRepresentation(context, is);

		return new Object[] { is };
	}

	@Override
	public String getCreateName() {
		return "Initial";
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			InitialState ss = (InitialState) getBusinessObjectForPictogramElement(context
					.getRootPictogramElement());
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
					.getRootPictogramElement());
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
