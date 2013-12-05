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
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
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

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.State;

public abstract class SimpleStatePattern extends IdPattern {

	private static final int DROPDOWN_SIZE = 12;
	private static final int IMAGE_SIZE = 24;
	protected static final String ID_NAME_TEXT = "nameText";
	protected static final String ID_MAIN_FIGURE = "mainFigure";
	protected static final String ID_TOP_RECTANGLE = "topRectangle";

	protected static final int CELL_WIDTH = 45;
	protected static final int TOP_RECTANGLE_HEIGHT = 28;
	protected static final int MAIN_RECTANGLE_WIDTH = CELL_WIDTH * 4;
	protected static final int MAIN_RECTANGLE_HEIGHT = TOP_RECTANGLE_HEIGHT + 30;
	protected static final int TEXT_WIDTH = MAIN_RECTANGLE_WIDTH - CELL_WIDTH - DROPDOWN_SIZE - 12;

	protected static final IColorConstant MAIN_RECTANGLE_BACKGROUND = new ColorConstant("eeeeee");
	protected static final IColorConstant MAIN_RECTANGLE_BORDER = new ColorConstant("5878a1");
	protected static final IColorConstant MAIN_RECTANGLE_SEPARATOR_COLOR = new ColorConstant("dedede");
	protected static final IColorConstant IMAGE_BACKGROUND = new ColorConstant("294c7b");
	protected static final IColorConstant TEXT_BACKGROUND = new ColorConstant("3564a2");

	protected static final String MAIN_RECTANGLE_STYLE = "mainRectangleStyle";
	protected static final String TOP_RECTANGLE_STYLE = "topRectangleStyle";
	protected static final String IMAGE_RECTANGLE_STYLE = "imageRectangleStyle";
	protected static final String MAIN_TEXT_STYLE = "mainTextStyle";
	protected static final String VERTICAL_LINE_STYLE = "verticalLineStyle";

	private static IGaService gaService = Graphiti.getGaService();

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context);
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {

		State addedDomainObject = (State) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();

		ContainerShape outerContainerShape = peCreateService.createContainerShape(getDiagram(), true);

		Rectangle mainRectangle = gaService.createPlainRectangle(outerContainerShape);
		setId(mainRectangle, ID_MAIN_FIGURE);
		mainRectangle.setStyle(getMainRectangleStyle());
		gaService.setLocationAndSize(mainRectangle, context.getX(), context.getY(), MAIN_RECTANGLE_WIDTH,
				MAIN_RECTANGLE_HEIGHT);

		{
			createVerticalLine(mainRectangle, CELL_WIDTH, 0, CELL_WIDTH, MAIN_RECTANGLE_HEIGHT);
			createVerticalLine(mainRectangle, CELL_WIDTH * 2, 0, CELL_WIDTH * 2, MAIN_RECTANGLE_HEIGHT);
			createVerticalLine(mainRectangle, CELL_WIDTH * 3, 0, CELL_WIDTH * 3, MAIN_RECTANGLE_HEIGHT);

			Rectangle topRectangle = gaService.createPlainRectangle(mainRectangle);
			setId(topRectangle, ID_TOP_RECTANGLE);
			topRectangle.setStyle(getTopRectangleStyle());
			gaService.setLocationAndSize(topRectangle, 0, 0, MAIN_RECTANGLE_WIDTH, TOP_RECTANGLE_HEIGHT);

			{
				Rectangle imageBackgroundRectangle = gaService.createPlainRectangle(topRectangle);
				imageBackgroundRectangle.setStyle(getImageBackgroundRectangleStyle());
				gaService.setLocationAndSize(imageBackgroundRectangle, 0, 0, CELL_WIDTH, TOP_RECTANGLE_HEIGHT);

				{
					Image image = gaService.createImage(imageBackgroundRectangle, getStateImageId());
					gaService.setLocationAndSize(image, (CELL_WIDTH - IMAGE_SIZE) / 2,
							(TOP_RECTANGLE_HEIGHT - IMAGE_SIZE) / 2, IMAGE_SIZE, IMAGE_SIZE);
				}

				Text text = gaService.createPlainText(topRectangle, addedDomainObject.getName());
				setId(text, ID_NAME_TEXT);
				text.setStyle(getMainTextStyle());
				gaService.setLocationAndSize(text, CELL_WIDTH, 0, TEXT_WIDTH, TOP_RECTANGLE_HEIGHT);

				Image image = gaService.createImage(topRectangle, CoreImageProvider.IMG_DROPDOWN);
				gaService.setLocationAndSize(image, MAIN_RECTANGLE_WIDTH - 24,
						(TOP_RECTANGLE_HEIGHT - DROPDOWN_SIZE) / 2, DROPDOWN_SIZE, DROPDOWN_SIZE);
			}
		}

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);

		return outerContainerShape;

	}

	private Polyline createVerticalLine(Rectangle mainRectangle, int x0, int y0, int x1, int y1) {
		Polyline poli = gaService.createPlainPolyline(mainRectangle, new int[] { x0, y0, x1, y1 });
		poli.setStyle(getVerticalLineStyle());
		return poli;
	}

	protected abstract String getStateImageId();

	private Style getVerticalLineStyle() {
		Style style = gaService.findStyle(getDiagram(), VERTICAL_LINE_STYLE);
		if (style == null) {
			style = gaService.createPlainStyle(getDiagram(), VERTICAL_LINE_STYLE);
			style.setForeground(manageColor(MAIN_RECTANGLE_SEPARATOR_COLOR));
			style.setLineVisible(true);
			style.setLineStyle(LineStyle.SOLID);
			style.setLineWidth(1);
		}
		return style;
	}

	private Style getImageBackgroundRectangleStyle() {
		Style style = gaService.findStyle(getDiagram(), IMAGE_RECTANGLE_STYLE);
		if (style == null) {
			style = gaService.createPlainStyle(getDiagram(), IMAGE_RECTANGLE_STYLE);
			style.setBackground(manageColor(IMAGE_BACKGROUND));
			style.setLineVisible(false);
			style.setLineWidth(0);
			style.setFilled(true);
		}
		return style;
	}

	private Style getMainTextStyle() {
		Style style = gaService.findStyle(getDiagram(), MAIN_TEXT_STYLE);
		if (style == null) {
			style = gaService.createPlainStyle(getDiagram(), MAIN_TEXT_STYLE);
			style.setForeground(manageColor(IColorConstant.WHITE));
			style.setFont(manageFont("HelveticaNeue Light", 12));
			style.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			style.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			style.setLineVisible(false);
			style.setFilled(false);
		}
		return style;
	}

	private Style getTopRectangleStyle() {
		Style style = gaService.findStyle(getDiagram(), TOP_RECTANGLE_STYLE);
		if (style == null) {
			style = gaService.createPlainStyle(getDiagram(), TOP_RECTANGLE_STYLE);
			style.setBackground(manageColor(TEXT_BACKGROUND));
			style.setLineVisible(false);
			style.setLineWidth(0);
			style.setFilled(true);
		}
		return style;
	}

	private Style getMainRectangleStyle() {
		Style style = gaService.findStyle(getDiagram(), MAIN_RECTANGLE_STYLE);
		if (style == null) {
			style = gaService.createPlainStyle(getDiagram(), MAIN_RECTANGLE_STYLE);
			style.setForeground(manageColor(MAIN_RECTANGLE_BORDER));
			style.setBackground(manageColor(MAIN_RECTANGLE_BACKGROUND));
			style.setLineStyle(LineStyle.SOLID);
			style.setLineVisible(true);
			style.setLineWidth(1);
			style.setFilled(true);
		}
		return style;
	}

	@Override
	public void resizeShape(IResizeShapeContext context) {
		if (context.getWidth() < MAIN_RECTANGLE_WIDTH || context.getHeight() < MAIN_RECTANGLE_HEIGHT) {
			ResizeShapeContext context2 = new ResizeShapeContext(context.getShape());
			context2.setWidth(Math.max(MAIN_RECTANGLE_WIDTH, context.getWidth()));
			context2.setHeight(Math.max(MAIN_RECTANGLE_HEIGHT, context.getHeight()));
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
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return false;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		boolean changesDone = false;

		GraphicsAlgorithm gaOuter = context.getRootPictogramElement().getGraphicsAlgorithm();

		// TODO : Resize state if name is too long
		// if (id.equals(ID_MAIN_FIGURE) || id.equals(ID_NAME_TEXT)) {
		// GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		// if (ga.getWidth() != gaOuter.getWidth() || ga.getHeight() != gaOuter.getHeight()) {
		// Graphiti.getGaService().setLocationAndSize(ga, 0, 0, gaOuter.getWidth(), gaOuter.getHeight());
		// changesDone = true;
		// }
		// }

		return changesDone;
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			State ss = (State) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
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
			State ss = (State) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
			Text text = (Text) context.getGraphicsAlgorithm();
			text.setValue(ss.getName());
			return true;
		}
		return false;
	}

	@Override
	protected void setValue(String value, IDirectEditingContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			State ss = (State) getBusinessObjectForPictogramElement(context.getPictogramElement());
			ss.setName(value);
			updatePictogramElement(context.getPictogramElement());
		}
	}

	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		return false;
	}
}