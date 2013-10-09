package com.vectorsf.jvoice.diagram.core.pattern.states;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IPredefinedRenderingStyle;

import com.vectorsf.jvoice.diagram.core.pattern.StatePredefinedColoredAreas;
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;

public class CallStatePattern extends StatePattern {

	private static final String CALL = "Call";
	private static int MIN_WIDTH = 120;
	private static int MIN_HEIGHT = 60;

	@Override
	protected PictogramElement doAdd(IAddContext context) {

		CallState addedDomainObject = (CallState) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		ContainerShape outerContainerShape = peCreateService
				.createContainerShape(getDiagram(), true);

		Rectangle mainRectangle = gaService
				.createRectangle(outerContainerShape);
		setId(mainRectangle, ID_MAIN_FIGURE);
		mainRectangle.setFilled(true);
		gaService
				.setRenderingStyle(
						mainRectangle,
						StatePredefinedColoredAreas
								.getAdaptedGradientColoredAreas(IPredefinedRenderingStyle.BLUE_WHITE_GLOSS_ID));
		gaService.setLocationAndSize(mainRectangle, context.getX(),
				context.getY(), Math.max(MIN_WIDTH, context.getWidth()),
				Math.max(MIN_HEIGHT, context.getHeight()));

		Text text = gaService.createText(mainRectangle,
				addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);

		return outerContainerShape;

	}

	@Override
	public Object[] create(ICreateContext context) {

		CallState cs = OperationsFactory.eINSTANCE.createCallState();
		cs.setName(CALL);
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		flow.getStates().add(cs);

		addGraphicalRepresentation(context, cs);

		return new Object[] { cs };
	}

	@Override
	public String getCreateName() {
		return CALL;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof CallState;
	}

}
