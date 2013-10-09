package com.vectorsf.jvoice.diagram.core.pattern.states;

import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.impl.ResizeShapeContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.func.IDirectEditing;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdPattern;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.graphiti.services.Graphiti;

import com.vectorsf.jvoice.model.operations.State;

public class StatePattern extends IdPattern {

	protected static final String ID_NAME_TEXT = "nameText";
	protected static final String ID_MAIN_FIGURE = "mainFigure";
	protected static final int MIN_WIDTH = 100;
	protected static final int MIN_HEIGHT = 60;

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context);
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
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
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
	protected PictogramElement doAdd(IAddContext context) {
		return null;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return false;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		boolean changesDone = false;

		GraphicsAlgorithm gaOuter = context.getRootPictogramElement()
				.getGraphicsAlgorithm();

		if (id.equals(ID_MAIN_FIGURE) || id.equals(ID_NAME_TEXT)) {
			GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
			if (ga.getWidth() != gaOuter.getWidth()
					|| ga.getHeight() != gaOuter.getHeight()) {
				Graphiti.getGaService().setLocationAndSize(ga, 0, 0,
						gaOuter.getWidth(), gaOuter.getHeight());
				changesDone = true;
			}
		}

		return changesDone;
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			State ss = (State) getBusinessObjectForPictogramElement(context
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
			State ss = (State) getBusinessObjectForPictogramElement(context
					.getRootPictogramElement());
			Text text = (Text) context.getGraphicsAlgorithm();
			text.setValue(ss.getName());
			return true;
		}
		return false;
	}

	@Override
	protected void setValue(String value, IDirectEditingContext context,
			String id) {
		if (id.equals(ID_NAME_TEXT)) {
			State ss = (State) getBusinessObjectForPictogramElement(context
					.getPictogramElement());
			ss.setName(value);
			updatePictogramElement(context.getPictogramElement());
		}
	}

}
