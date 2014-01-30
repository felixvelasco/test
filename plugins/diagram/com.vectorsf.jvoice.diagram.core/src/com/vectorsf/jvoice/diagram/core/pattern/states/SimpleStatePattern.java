package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.func.IDirectEditing;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
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
import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;

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

	private static final String ID_MENU_IMAGE = "menuImage";

	protected static IGaService gaService = Graphiti.getGaService();

	private Set<Transition> transitions = new HashSet<>();

	private int cont = 0;

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
			// createVerticalLine(mainRectangle, CELL_WIDTH, 0, CELL_WIDTH,
			// MAIN_RECTANGLE_HEIGHT);
			// createVerticalLine(mainRectangle, CELL_WIDTH * 2, 0, CELL_WIDTH *
			// 2, MAIN_RECTANGLE_HEIGHT);
			// createVerticalLine(mainRectangle, CELL_WIDTH * 3, 0, CELL_WIDTH *
			// 3, MAIN_RECTANGLE_HEIGHT);

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
					setId(image, ID_STATE_IMAGE);
				}

				Text text = gaService.createPlainText(topRectangle, addedDomainObject.getName());
				setId(text, ID_NAME_TEXT);
				text.setStyle(getMainTextStyle());
				gaService.setLocationAndSize(text, CELL_WIDTH, 0, TEXT_WIDTH, TOP_RECTANGLE_HEIGHT);

				if (!(addedDomainObject instanceof CallFlowState) && !(addedDomainObject instanceof SwitchState)) {
					Image menuImage = gaService.createImage(topRectangle, CoreImageProvider.IMG_DROPDOWN);
					setId(menuImage, ID_MENU_IMAGE);
					gaService.setLocationAndSize(menuImage, MAIN_RECTANGLE_WIDTH - 24,
							(TOP_RECTANGLE_HEIGHT - DROPDOWN_SIZE) / 2, DROPDOWN_SIZE, DROPDOWN_SIZE);
				}
			}

		}

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);

		return outerContainerShape;

	}

	protected Polyline createVerticalLine(Rectangle mainRectangle, int x0, int y0, int x1, int y1) {
		Polyline poli = gaService.createPlainPolyline(mainRectangle, new int[] { x0, y0, x1, y1 });
		poli.setStyle(getVerticalLineStyle());
		return poli;
	}

	protected abstract String getStateImageId();

	protected Style getVerticalLineStyle() {
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

	protected Style getImageBackgroundRectangleStyle() {
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
			style = gaService.createPlainStyle(getDiagram(), TOP_RECTANGLE_STYLE);
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
	public boolean canCreate(ICreateContext context) {
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		if (flow.eResource().getURI().scheme().equals("archive")) {
			return false;
		}
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
			State ss = (State) getBusinessObjectForPictogramElement(context.getPictogramElement());
			return ss.getName();
		}
		return "";
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
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return false;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		boolean changesDone = false;

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
			State state = (State) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
			int numEvents = getFireableEvents(state).size();
			if (numEvents * IMAGE_SIZE > MAIN_RECTANGLE_WIDTH) {
				changeTopRectangleWidth(context, (IMAGE_SIZE + 2) * numEvents);
			} else {
				changeTopRectangleWidth(context, MAIN_RECTANGLE_WIDTH);
			}
			changesDone = true;
		}

		return changesDone;
	}

	public EList<String> getFireableEvents(State state) {
		return state.getFireableEvents();
	}

	public void changeTopRectangleWidth(IdLayoutContext context, int newWidth) {
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();

		// Cambiamos el tamaño del rectángulo superior
		gaService.setLocationAndSize(ga, 0, 0, newWidth, TOP_RECTANGLE_HEIGHT);

		// Colocamos el icono del menú
		for (GraphicsAlgorithm ga2 : ga.getGraphicsAlgorithmChildren()) {
			if (ga2 instanceof Image) {
				gaService.setLocationAndSize(ga2, newWidth - 24, (TOP_RECTANGLE_HEIGHT - DROPDOWN_SIZE) / 2,
						DROPDOWN_SIZE, DROPDOWN_SIZE);
			}
		}
	}

	/**
	 * Actualiza la barra de eventos que puede disparar el estado.
	 */
	public void updateFireableEvents(IdLayoutContext context) {
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();

		State state = (State) getBusinessObjectForPictogramElement(ga.getPictogramElement());
		EList<String> fireableEvents = getFireableEvents(state);

		// Ajustamos el tamaño del estado
		if (fireableEvents.size() * IMAGE_SIZE > MAIN_RECTANGLE_WIDTH) {
			Graphiti.getGaService().setLocationAndSize(ga, ga.getX(), ga.getY(),
					(IMAGE_SIZE + 2) * fireableEvents.size(), ga.getHeight());
		} else {
			Graphiti.getGaService().setLocationAndSize(ga, ga.getX(), ga.getY(), MAIN_RECTANGLE_WIDTH, ga.getHeight());
		}

		// Borra los anchors del tipo FixPointAnchor que no tienen transiciones
		// de salida
		List<Anchor> anchorsToDelete = new ArrayList<Anchor>();
		List<String> existingAnchors = new ArrayList<String>();
		PictogramElement rootPe = context.getRootPictogramElement();

		for (Anchor anchor : ((AnchorContainer) rootPe).getAnchors()) {
			if (!(anchor instanceof FixPointAnchor)) {
				continue;
			}
			if (anchor.getOutgoingConnections().isEmpty()) {
				anchorsToDelete.add(anchor);
			} else {
				existingAnchors.add(((Image) anchor.getGraphicsAlgorithm()).getId());
			}
		}

		for (Anchor anchor : anchorsToDelete) {
			Graphiti.getPeService().deletePictogramElement(anchor);
		}

		// Creamos el anchor y su imagen asociada
		for (String event : fireableEvents) {
			// No creamos los anchors que ya existen
			if (existingAnchors.contains(event)) {
				continue;
			}

			FixPointAnchor anchor = Graphiti.getPeCreateService().createFixPointAnchor((AnchorContainer) rootPe);
			// TODO Implementar que cuando haya flecha asociada al icono se muestre el icono de on y se no, el de off.
			// El imageId es el evento m�s el sufijo de on.
			Image image = gaService.createImage(anchor, event + CoreImageProvider.IMG_EVENT_ON_EXT);
			gaService.setLocationAndSize(image, 0, 0, IMAGE_SIZE, IMAGE_SIZE);
			Graphiti.getPeService().setPropertyValue(anchor, "TOOLTIP", event);
		}

		// Reordenamos los anchors
		cont = 0;
		for (Anchor anchor : ((AnchorContainer) rootPe).getAnchors()) {
			if (anchor instanceof FixPointAnchor) {
				((FixPointAnchor) anchor).setLocation(getAnchorLocation(cont++, rootPe, anchor));
			}
		}
	}

	public Point getAnchorLocation(int point, PictogramElement pe, Anchor anchor) {
		int x = point * 26;

		GraphicsAlgorithm ga = anchor.getGraphicsAlgorithm();
		if (ga instanceof Text) {
			x = cont;
			cont += ((Text) ga).getValue().length() * 7;
		}

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
			State ss = (State) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
			Text text = (Text) context.getGraphicsAlgorithm();
			if (text.getValue() != null && !text.getValue().equals(ss.getName())) {
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
	protected void postMoveShape(IMoveShapeContext context) {
		super.postMoveShape(context);
		State state = (State) getBusinessObjectForPictogramElement(context.getPictogramElement());
		InitialState initial = null;
		for (Transition transition : state.getIncomingTransitions()) {
			if (transition.getSource() instanceof InitialState) {
				initial = (InitialState) transition.getSource();
				break;
			}
		}

		if (initial != null) {
			layoutPictogramElement(Graphiti.getLinkService().getPictogramElements(getDiagram(), initial).get(0));
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
			List<Connection> allConnections = Graphiti.getPeService().getAllConnections(anchor);
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

	protected boolean isValidStateName(Flow flow, String name) {
		for (State state : flow.getStates()) {
			if (state.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}

	protected String getValidStateName(Flow flow, String name) {

		String validName = name;
		int counter = 1;
		for (;;) {
			if (isValidStateName(flow, validName)) {
				return validName;
			}
			validName = name + counter;
			counter++;
		}
	}

	public static Set<String> getAnchorNames(IdUpdateContext context) {
		Set<String> anchorNames = new HashSet<String>();

		PictogramElement pe = context.getRootPictogramElement();
		for (Anchor anchor : ((AnchorContainer) pe).getAnchors()) {
			if (!(anchor instanceof FixPointAnchor)) {
				continue;
			}
			GraphicsAlgorithm ga = anchor.getGraphicsAlgorithm();
			if (ga instanceof Image) {
				anchorNames.add(((Image) ga).getId());
			} else {
				anchorNames.add(((Text) ga).getValue());
			}
		}

		return anchorNames;
	}

}
