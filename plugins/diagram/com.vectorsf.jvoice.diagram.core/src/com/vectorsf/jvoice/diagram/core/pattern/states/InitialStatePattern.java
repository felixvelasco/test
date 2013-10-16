package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.List;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IPredefinedRenderingStyle;

import com.vectorsf.jvoice.diagram.core.pattern.StatePredefinedColoredAreas;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.State;

public class InitialStatePattern extends StatePattern {

	private static final String INITIAL = "Initial";
	private static final int MIN_WIDTH = 60;
	private static final int MIN_HEIGHT = 60;

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		InitialState addedDomainObject = (InitialState) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		ContainerShape outerContainerShape = peCreateService
				.createContainerShape(getDiagram(), true);

		RoundedRectangle circle = gaService.createRoundedRectangle(
				outerContainerShape, 60, 60);

		setId(circle, ID_MAIN_FIGURE);
		circle.setFilled(true);
		gaService
				.setRenderingStyle(
						circle,
						StatePredefinedColoredAreas
								.getAdaptedGradientColoredAreas(IPredefinedRenderingStyle.LIGHT_GRAY_ID));
		gaService.setLocationAndSize(circle, context.getX(), context.getY(),
				Math.max(MIN_WIDTH, context.getWidth()),
				Math.max(MIN_HEIGHT, context.getHeight()));

		Text text = gaService.createText(circle, addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);

		return outerContainerShape;
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

}
