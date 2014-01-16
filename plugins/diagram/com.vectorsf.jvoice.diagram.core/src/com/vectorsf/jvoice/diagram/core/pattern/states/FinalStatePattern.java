package com.vectorsf.jvoice.diagram.core.pattern.states;

import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeCreateService;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.State;

public class FinalStatePattern extends SimpleStatePattern {

	private static final String FINAL = "Final";

	protected static final String FINAL_TEXT_STYLE = "finalTextStyle";

	protected static final String ID_STATE_IMAGE = "stateImage";

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		State addedDomainObject = (State) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();

		ContainerShape outerContainerShape = peCreateService.createContainerShape(getDiagram(), true);

		Rectangle mainRectangle = gaService.createPlainRectangle(outerContainerShape);
		setId(mainRectangle, ID_MAIN_FIGURE);
		mainRectangle.setStyle(getMainRectangleStyle());
		gaService.setLocationAndSize(mainRectangle, context.getX(), context.getY(), MAIN_RECTANGLE_WIDTH,
				TOP_RECTANGLE_HEIGHT);

		{

			Rectangle imageBackgroundRectangle = gaService.createPlainRectangle(mainRectangle);
			imageBackgroundRectangle.setStyle(getImageBackgroundRectangleStyle());
			gaService.setLocationAndSize(imageBackgroundRectangle, 0, 0, CELL_WIDTH, TOP_RECTANGLE_HEIGHT);

			{
				Image image = gaService.createImage(imageBackgroundRectangle, getStateImageId());
				gaService.setLocationAndSize(image, (CELL_WIDTH - IMAGE_SIZE) / 2,
						(TOP_RECTANGLE_HEIGHT - IMAGE_SIZE) / 2, IMAGE_SIZE, IMAGE_SIZE);
				setId(image, ID_STATE_IMAGE);
			}

			Text text = gaService.createPlainText(mainRectangle, addedDomainObject.getName());
			setId(text, ID_NAME_TEXT);
			text.setStyle(getFinalTextStyle());
			gaService.setLocationAndSize(text, CELL_WIDTH, 0, TEXT_WIDTH, TOP_RECTANGLE_HEIGHT);

		}

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);

		return outerContainerShape;
	}

	protected Style getFinalTextStyle() {
		Style style = gaService.findStyle(getDiagram(), FINAL_TEXT_STYLE);
		if (style == null) {
			style = gaService.createPlainStyle(getDiagram(), FINAL_TEXT_STYLE);
			style.setForeground(manageColor(TEXT_BACKGROUND));
			style.setFont(manageFont("Arial", 12));
			style.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			style.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			style.setLineVisible(false);
			style.setFilled(false);
		}
		return style;
	}

	@Override
	public Object[] create(ICreateContext context) {

		FinalState fs = OperationsFactory.eINSTANCE.createFinalState();
		fs.setName(FINAL);
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		flow.getStates().add(fs);

		addGraphicalRepresentation(context, fs);

		return new Object[] { fs };
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		FinalState finalState = (FinalState) getBusinessObjectForPictogramElement(context.getRootPictogramElement());

		if (id.equals(ID_MAIN_FIGURE)) {
			GraphicsAlgorithm gaOuter = context.getRootPictogramElement().getGraphicsAlgorithm();
			int currentWidth = gaOuter.getWidth();
			int newWidth = finalState.isFinal() ? CELL_WIDTH : MAIN_RECTANGLE_WIDTH;
			if (newWidth == currentWidth) {
				return false;
			} else {
				gaOuter.setWidth(newWidth);
				return true;
			}
		} else if (id.equals(ID_STATE_IMAGE)) {
			Image image = (Image) context.getGraphicsAlgorithm();
			String currentImage = image.getId();
			String newImage = finalState.isFinal() ? CoreImageProvider.IMG_STATE_HANGUP
					: CoreImageProvider.IMG_STATE_FINAL;
			if (currentImage.equals(newImage)) {
				return false;
			} else {
				image.setId(newImage);
				return true;
			}
		}
		return false;
	}

	@Override
	public String getCreateName() {
		return FINAL;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof FinalState;
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_FINAL;
	}

	@Override
	public String getCreateLargeImageId() {
		return CoreImageProvider.IMG_LARGE_PALETTE_FINAL;
	}

	@Override
	protected String getStateImageId() {
		return CoreImageProvider.IMG_STATE_FINAL;
	}
}
