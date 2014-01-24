package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.*;
import org.eclipse.graphiti.features.impl.*;
import org.eclipse.graphiti.func.IDirectEditing;
import org.eclipse.graphiti.mm.algorithms.*;
import org.eclipse.graphiti.mm.algorithms.impl.ImageImpl;
import org.eclipse.graphiti.mm.algorithms.styles.*;
import org.eclipse.graphiti.mm.pictograms.*;
import org.eclipse.graphiti.pattern.id.*;
import org.eclipse.graphiti.services.*;
import org.eclipse.graphiti.util.*;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.*;

public abstract class SimpleStatePattern extends IdPattern {
    protected static final int DROPDOWN_SIZE = 12;

    protected static final int IMAGE_SIZE = 24;

    protected static final String ID_NAME_TEXT = "nameText";

    protected static final String ID_MAIN_FIGURE = "mainFigure";

    protected static final String ID_TOP_RECTANGLE = "topRectangle";

    protected static final String ID_STATE_IMAGE = "stateImage";

    protected static final int CELL_WIDTH = 45;

    protected static final int TOP_RECTANGLE_HEIGHT = 28;

    protected static final int MAIN_RECTANGLE_WIDTH = CELL_WIDTH * 4;

    protected static final int MAIN_RECTANGLE_HEIGHT = TOP_RECTANGLE_HEIGHT + 30;

    protected static final int TEXT_WIDTH = MAIN_RECTANGLE_WIDTH - CELL_WIDTH
	    - DROPDOWN_SIZE - 12;

    protected static final IColorConstant MAIN_RECTANGLE_BACKGROUND = new ColorConstant(
	    "eeeeee");

    protected static final IColorConstant MAIN_RECTANGLE_BORDER = new ColorConstant(
	    "5878a1");

    protected static final IColorConstant MAIN_RECTANGLE_SEPARATOR_COLOR = new ColorConstant(
	    "dedede");

    protected static final IColorConstant IMAGE_BACKGROUND = new ColorConstant(
	    "294c7b");

    protected static final IColorConstant TEXT_BACKGROUND = new ColorConstant(
	    "3564a2");

    protected static final String MAIN_RECTANGLE_STYLE = "mainRectangleStyle";

    protected static final String TOP_RECTANGLE_STYLE = "topRectangleStyle";

    protected static final String IMAGE_RECTANGLE_STYLE = "imageRectangleStyle";

    protected static final String MAIN_TEXT_STYLE = "mainTextStyle";

    protected static final String VERTICAL_LINE_STYLE = "verticalLineStyle";

    private static final String ID_MENU_IMAGE = "menuImage";

    protected static IGaService gaService = Graphiti.getGaService();

    private Set<Transition> transitions = new HashSet<>();

    @Override
    protected PictogramElement doAdd(IAddContext context) {

	State addedDomainObject = (State) context.getNewObject();
	IPeCreateService peCreateService = Graphiti.getPeCreateService();

	ContainerShape outerContainerShape = peCreateService
		.createContainerShape(getDiagram(), true);

	Rectangle mainRectangle = gaService
		.createPlainRectangle(outerContainerShape);
	setId(mainRectangle, ID_MAIN_FIGURE);
	mainRectangle.setStyle(getMainRectangleStyle());
	gaService.setLocationAndSize(mainRectangle, context.getX(),
		context.getY(), MAIN_RECTANGLE_WIDTH, MAIN_RECTANGLE_HEIGHT);

	{
	    // createVerticalLine(mainRectangle, CELL_WIDTH, 0, CELL_WIDTH,
	    // MAIN_RECTANGLE_HEIGHT);
	    // createVerticalLine(mainRectangle, CELL_WIDTH * 2, 0, CELL_WIDTH *
	    // 2, MAIN_RECTANGLE_HEIGHT);
	    // createVerticalLine(mainRectangle, CELL_WIDTH * 3, 0, CELL_WIDTH *
	    // 3, MAIN_RECTANGLE_HEIGHT);

	    Rectangle topRectangle = gaService
		    .createPlainRectangle(mainRectangle);
	    setId(topRectangle, ID_TOP_RECTANGLE);
	    topRectangle.setStyle(getTopRectangleStyle());
	    gaService.setLocationAndSize(topRectangle, 0, 0,
		    MAIN_RECTANGLE_WIDTH, TOP_RECTANGLE_HEIGHT);

	    {
		Rectangle imageBackgroundRectangle = gaService
			.createPlainRectangle(topRectangle);
		imageBackgroundRectangle
			.setStyle(getImageBackgroundRectangleStyle());
		gaService.setLocationAndSize(imageBackgroundRectangle, 0, 0,
			CELL_WIDTH, TOP_RECTANGLE_HEIGHT);

		{
		    Image image = gaService.createImage(
			    imageBackgroundRectangle, getStateImageId());
		    gaService.setLocationAndSize(image,
			    (CELL_WIDTH - IMAGE_SIZE) / 2,
			    (TOP_RECTANGLE_HEIGHT - IMAGE_SIZE) / 2,
			    IMAGE_SIZE, IMAGE_SIZE);
		    setId(image, ID_STATE_IMAGE);
		}

		Text text = gaService.createPlainText(topRectangle,
			addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setStyle(getMainTextStyle());
		gaService.setLocationAndSize(text, CELL_WIDTH, 0, TEXT_WIDTH,
			TOP_RECTANGLE_HEIGHT);

		Image menuImage = gaService.createImage(topRectangle,
			CoreImageProvider.IMG_DROPDOWN);
		setId(menuImage, ID_MENU_IMAGE);
		gaService.setLocationAndSize(menuImage,
			MAIN_RECTANGLE_WIDTH - 24,
			(TOP_RECTANGLE_HEIGHT - DROPDOWN_SIZE) / 2,
			DROPDOWN_SIZE, DROPDOWN_SIZE);
	    }

	}

	peCreateService.createChopboxAnchor(outerContainerShape);

	link(outerContainerShape, addedDomainObject);

	return outerContainerShape;

    }

    protected Polyline createVerticalLine(Rectangle mainRectangle, int x0,
	    int y0, int x1, int y1) {
	Polyline poli = gaService.createPlainPolyline(mainRectangle, new int[] {
		x0, y0, x1, y1 });
	poli.setStyle(getVerticalLineStyle());
	return poli;
    }

    protected abstract String getStateImageId();

    protected Style getVerticalLineStyle() {
	Style style = gaService.findStyle(getDiagram(), VERTICAL_LINE_STYLE);
	if (style == null) {
	    style = gaService.createPlainStyle(getDiagram(),
		    VERTICAL_LINE_STYLE);
	    style.setForeground(manageColor(MAIN_RECTANGLE_SEPARATOR_COLOR));
	    style.setLineVisible(true);
	    style.setLineStyle(LineStyle.SOLID);
	    style.setLineWidth(1);
	}
	return style;
    }

    protected Style getImageBackgroundRectangleStyle() {
	Style style = gaService.findStyle(getDiagram(), IMAGE_RECTANGLE_STYLE);
	if (style == null) {
	    style = gaService.createPlainStyle(getDiagram(),
		    IMAGE_RECTANGLE_STYLE);
	    style.setBackground(manageColor(IMAGE_BACKGROUND));
	    style.setLineVisible(false);
	    style.setLineWidth(0);
	    style.setFilled(true);
	}
	return style;
    }

    protected Style getMainTextStyle() {
	Style style = gaService.findStyle(getDiagram(), MAIN_TEXT_STYLE);
	if (style == null) {
	    style = gaService.createPlainStyle(getDiagram(), MAIN_TEXT_STYLE);
	    style.setForeground(manageColor(IColorConstant.WHITE));
	    style.setFont(manageFont("Arial", 12));
	    style.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
	    style.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
	    style.setLineVisible(false);
	    style.setFilled(false);
	}
	return style;
    }

    protected Style getTopRectangleStyle() {
	Style style = gaService.findStyle(getDiagram(), TOP_RECTANGLE_STYLE);
	if (style == null) {
	    style = gaService.createPlainStyle(getDiagram(),
		    TOP_RECTANGLE_STYLE);
	    style.setBackground(manageColor(TEXT_BACKGROUND));
	    style.setLineVisible(false);
	    style.setLineWidth(0);
	    style.setFilled(true);
	}
	return style;
    }

    protected Style getMainRectangleStyle() {
	Style style = gaService.findStyle(getDiagram(), MAIN_RECTANGLE_STYLE);
	if (style == null) {
	    style = gaService.createPlainStyle(getDiagram(),
		    MAIN_RECTANGLE_STYLE);
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
    protected String getInitialValue(IDirectEditingContext context, String id) {
	if (id.equals(ID_NAME_TEXT)) {
	    State ss = (State) getBusinessObjectForPictogramElement(context
		    .getPictogramElement());
	    return ss.getName();
	}
	return "";
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

    @Override
    public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
	return false;
    }

    @Override
    protected boolean layout(IdLayoutContext context, String id) {
	boolean changesDone = false;

	GraphicsAlgorithm gaOuter = context.getRootPictogramElement()
		.getGraphicsAlgorithm();

	// TODO : Resize state if name is too long
	// if (id.equals(ID_MAIN_FIGURE) || id.equals(ID_NAME_TEXT)) {
	// GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
	// if (ga.getWidth() != gaOuter.getWidth() || ga.getHeight() !=
	// gaOuter.getHeight()) {
	// Graphiti.getGaService().setLocationAndSize(ga, 0, 0,
	// gaOuter.getWidth(), gaOuter.getHeight());
	// changesDone = true;
	// }
	// }

	if (id.equals(ID_MAIN_FIGURE)) {
	    updateFireableEvents(context);
	    changesDone = true;
	}

	// Cambiamos el tamaño del rectángulo superior y la posición del icono
	// del menú
	if (id.equals(ID_TOP_RECTANGLE)) {
	    int newWidth = MAIN_RECTANGLE_WIDTH;

	    State state = (State) getBusinessObjectForPictogramElement(context
		    .getRootPictogramElement());
	    int numEvents = state.getFireableEvents().size();
	    if (numEvents * IMAGE_SIZE > MAIN_RECTANGLE_WIDTH) {
		newWidth = (IMAGE_SIZE + 2) * numEvents;
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		gaService.setLocationAndSize(ga, 0, 0, newWidth,
			TOP_RECTANGLE_HEIGHT);

		// Colocamos el icono del menú
		for (GraphicsAlgorithm ga2 : ga.getGraphicsAlgorithmChildren()) {
		    if (ga2 instanceof ImageImpl) {
			gaService.setLocationAndSize(ga2, newWidth - 24,
				(TOP_RECTANGLE_HEIGHT - DROPDOWN_SIZE) / 2,
				DROPDOWN_SIZE, DROPDOWN_SIZE);
		    }
		}
	    } else {
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		gaService.setLocationAndSize(ga, 0, 0, MAIN_RECTANGLE_WIDTH,
			TOP_RECTANGLE_HEIGHT);

		// Colocamos el icono del menú
		for (GraphicsAlgorithm ga2 : ga.getGraphicsAlgorithmChildren()) {
		    if (ga2 instanceof ImageImpl) {
			gaService.setLocationAndSize(ga2, MAIN_RECTANGLE_WIDTH - 24,
				(TOP_RECTANGLE_HEIGHT - DROPDOWN_SIZE) / 2,
				DROPDOWN_SIZE, DROPDOWN_SIZE);
		    }
		}
		changesDone = true;
	    }
	}

	return changesDone;
    }

    /**
     * Actualiza la barra de eventos que puede disparar el estado.
     */
    private void updateFireableEvents(IdLayoutContext context) {
	GraphicsAlgorithm ga = context.getGraphicsAlgorithm();

	State state = (State) getBusinessObjectForPictogramElement(ga
		.getPictogramElement());
	EList<String> fireableEvents = state.getFireableEvents();

	// Ajustamos el tamaño del estado
	if (fireableEvents.size() * IMAGE_SIZE > MAIN_RECTANGLE_WIDTH) {
	    Graphiti.getGaService().setLocationAndSize(ga, ga.getX(),
		    ga.getY(), (IMAGE_SIZE + 2) * fireableEvents.size(),
		    ga.getHeight());
	} else {
	    Graphiti.getGaService().setLocationAndSize(ga, ga.getX(),
		    ga.getY(), MAIN_RECTANGLE_WIDTH, ga.getHeight());
	}

	// Borra los anchors del tipo FixPointAnchor que no tienen transiciones
	// de salida
	List<Anchor> anchorsToDelete = new ArrayList<Anchor>();
	List<String> existingAnchors = new ArrayList<String>();
	for (Anchor anchor : ((AnchorContainer) context
		.getRootPictogramElement()).getAnchors()) {
	    if (!(anchor instanceof FixPointAnchor)) {
		continue;
	    }

	    if (anchor.getOutgoingConnections().isEmpty()) {
		anchorsToDelete.add(anchor);
	    } else {
		existingAnchors.add(((ImageImpl) anchor.getGraphicsAlgorithm())
			.getId());
	    }
	}

	for (Anchor anchor : anchorsToDelete) {
	    Graphiti.getPeService().deletePictogramElement(anchor);
	}

	// Creamos el anchor y su imagen asociada
	int cont = existingAnchors.size();
	for (String event : fireableEvents) {
	    // No creamos los anchors que ya existen
	    if (existingAnchors.contains(event)) {
		continue;
	    }

	    FixPointAnchor anchor = Graphiti
		    .getPeCreateService()
		    .createFixPointAnchor(
			    (AnchorContainer) context.getRootPictogramElement());
	    anchor.setLocation(getImageLocation(cont++,
		    context.getRootPictogramElement()));

	    // Creamos la imagen del evento dentro del anchor
	    Image image = gaService.createImage(anchor, event);
	    gaService.setLocationAndSize(image, 0, 0, IMAGE_SIZE, IMAGE_SIZE);
	    image.setId(event);
	    Graphiti.getPeService().setPropertyValue(anchor, "TOOLTIP", event);
	}

	// Reordenamos los anchors
	cont = 0;
	for (Anchor anchor : ((AnchorContainer) context
		.getRootPictogramElement()).getAnchors()) {
	    if (anchor instanceof FixPointAnchor) {
		((FixPointAnchor) anchor).setLocation(getImageLocation(cont++,
			context.getRootPictogramElement()));
	    }
	}
    }

    public static Point getImageLocation(int point, PictogramElement pe) {
	int x = point * 26;
	int y = pe.getGraphicsAlgorithm().getHeight() - 16 - 10;

	return Graphiti.getGaCreateService().createPoint(x, y);
    }

    public static Point createOutPoint2(int point, PictogramElement pe) {
	// Valores: 16 del tamaño del icono y 7 del margen derecho
	int middle = (pe.getGraphicsAlgorithm().getWidth() - 16) / 2;

	int signo = point % 2 == 0 ? 1 : -1;
	int x = middle + signo * ((point + 1) / 2) * 26;
	int y = pe.getGraphicsAlgorithm().getHeight() - 16 - 7;

	return Graphiti.getGaCreateService().createPoint(x, y);
    }

    @Override
    protected IReason updateNeeded(IdUpdateContext context, String id) {
	if (id.equals(ID_NAME_TEXT)) {
	    State ss = (State) getBusinessObjectForPictogramElement(context
		    .getRootPictogramElement());
	    Text text = (Text) context.getGraphicsAlgorithm();
	    if (text.getValue() != null
		    && !text.getValue().equals(ss.getName())) {
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

	// updateFireableEvents(context);

	return false;
    }

    @Override
    protected void postMoveShape(IMoveShapeContext context) {
	super.postMoveShape(context);
	State state = (State) getBusinessObjectForPictogramElement(context
		.getPictogramElement());
	InitialState initial = null;
	for (Transition transition : state.getIncomingTransitions()) {
	    if (transition.getSource() instanceof InitialState) {
		initial = (InitialState) transition.getSource();
		break;
	    }
	}

	if (initial != null) {
	    layoutPictogramElement(Graphiti.getLinkService()
		    .getPictogramElements(getDiagram(), initial).get(0));
	}

    }

    @Override
    public boolean canResizeShape(IResizeShapeContext context) {
	return false;
    }

    @Override
    public boolean canDelete(IDeleteContext context) {
	if (super.canDelete(context)) {
	    PictogramElement pictogramElement = context.getPictogramElement();
	    State bo = (State) getBusinessObjectForPictogramElement(pictogramElement);

	    for (Transition tr : bo.getIncomingTransitions()) {
		if (tr.getSource() instanceof InitialState) {
		    return false;
		}
	    }
	    return true;
	} else {
	    return false;
	}
    }

    @Override
    protected IRemoveFeature createRemoveFeature(IRemoveContext context) {
	return new StateRemoveFeature(getFeatureProvider());
    }

    @Override
    protected boolean avoidNegativeCoordinates() {
	return true;
    }

    private final class StateRemoveFeature extends DefaultRemoveFeature {
	private StateRemoveFeature(IFeatureProvider fp) {
	    super(fp);
	}

	@Override
	public void preRemove(IRemoveContext context) {
	    super.preRemove(context);
	    SimpleStatePattern.this.preRemove(context);
	}

	@Override
	public void postRemove(IRemoveContext context) {
	    SimpleStatePattern.this.postRemove(context);
	    super.postRemove(context);
	}

	@Override
	protected void removeAllConnections(Anchor anchor) {
	    List<Connection> allConnections = Graphiti.getPeService()
		    .getAllConnections(anchor);
	    for (Connection connection : allConnections) {
		Object bo = getBusinessObjectForPictogramElement(connection);
		if (bo instanceof Transition) {
		    addTransitionToRemove((Transition) bo);
		}
	    }
	    super.removeAllConnections(anchor);
	}
    }

    public void addTransitionToRemove(Transition trans) {
	transitions.add(trans);
    }

    @Override
    public void preRemove(IRemoveContext context) {
	super.preRemove(context);
	transitions.clear();
    }

    @Override
    public void postRemove(IRemoveContext context) {
	super.postRemove(context);
	for (Transition trans : transitions) {
	    EcoreUtil.delete(trans);
	}
	transitions.clear();
    }
}
