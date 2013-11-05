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
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.RecordState;

public class RecordStatePattern extends StatePattern {
	private static final String RECORD = "Record";
	private static int MIN_WIDTH = 100;
	private static int MIN_HEIGHT = 60;

	@Override
	protected PictogramElement doAdd(IAddContext context) {

		RecordState addedDomainObject = (RecordState) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		ContainerShape outerContainerShape = peCreateService.createContainerShape(getDiagram(), true);

		Rectangle mainRectangle = gaService.createRectangle(outerContainerShape);
		setId(mainRectangle, ID_MAIN_FIGURE);
		mainRectangle.setFilled(true);
		gaService.setRenderingStyle(mainRectangle,
				StatePredefinedColoredAreas.getAdaptedGradientColoredAreas(IPredefinedRenderingStyle.LIGHT_GRAY_ID));
		gaService.setLocationAndSize(mainRectangle, context.getX(), context.getY(),
				Math.max(MIN_WIDTH, context.getWidth()), Math.max(MIN_HEIGHT, context.getHeight()));

		Text text = gaService.createText(mainRectangle, addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);

		return outerContainerShape;

	}

	@Override
	public Object[] create(ICreateContext context) {

		RecordState rs = OperationsFactory.eINSTANCE.createRecordState();
		rs.setName(RECORD);
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		flow.getStates().add(rs);

		addGraphicalRepresentation(context, rs);

		return new Object[] { rs };
	}

	@Override
	public String getCreateName() {
		return RECORD;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof RecordState;
	}
}
