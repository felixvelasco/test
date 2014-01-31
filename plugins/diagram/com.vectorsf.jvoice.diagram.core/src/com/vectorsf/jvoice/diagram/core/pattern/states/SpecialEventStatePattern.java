package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;

public class SpecialEventStatePattern extends SimpleStatePattern {

	public static final String FONT_NAME = "Arial";
	public static final int FONT_SIZE = 8;
	public static final int MARGIN = 10;
	public static final IColorConstant TEXT_COLOR_ON = new ColorConstant("7b91a4");
	public static final IColorConstant TEXT_COLOR_OFF = new ColorConstant("afc1d1");

	public int acum;

	/**
	 * Sobreescribe el método porque los eventos del estado Switch son los eventos de los Cases asociados.
	 */
	@Override
	public EList<String> getFireableEvents(State state) {
		EList<String> caseEventNames = new BasicEList<String>();
		for (Case c : ((SwitchState) state).getCase()) {
			caseEventNames.add(c.getEventName());
		}

		return caseEventNames;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		boolean changesDone = false;

		if (id.equals(ID_MAIN_FIGURE)) {
			updateFireableEvents(context);
			changesDone = true;
		}

		// Cambiamos el tamaño del rectángulo superior y la posición del icono
		// del menú
		if (id.equals(ID_TOP_RECTANGLE)) {
			State state = (State) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
			int stateWidth = getStateWidth(state);
			if (stateWidth > MAIN_RECTANGLE_WIDTH) {
				changeTopRectangleWidth(context, stateWidth);
			} else {
				changeTopRectangleWidth(context, MAIN_RECTANGLE_WIDTH);
			}
			changesDone = true;
		}

		return changesDone;
	}

	public int getStateWidth(State state) {
		int size = MARGIN;
		for (String string : getFireableEvents(state)) {
			size += calculateTextWidth(string);
			size += MARGIN;
		}

		return size;
	}

	@Override
	public Point getAnchorLocation(int point, PictogramElement pe, Anchor anchor) {
		int x = acum;

		GraphicsAlgorithm ga = anchor.getGraphicsAlgorithm();
		if (ga instanceof Text) {
			acum += calculateTextWidth((Text) ga);
			acum += MARGIN;
		} else {
			acum += 26;
		}

		int y = pe.getGraphicsAlgorithm().getHeight() - 16 - 10;

		return Graphiti.getGaCreateService().createPoint(x, y);
	}

	/**
	 * Actualiza la barra de eventos que puede disparar el estado.
	 */
	@Override
	public void updateFireableEvents(IdLayoutContext context) {
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		IPeService peService = Graphiti.getPeService();

		State state = (State) getBusinessObjectForPictogramElement(ga.getPictogramElement());
		List<String> fireableEvents = getFireableEvents(state);

		// Ajustamos el tamaño del estado
		int stateWidth = getStateWidth(state);
		if (stateWidth > MAIN_RECTANGLE_WIDTH) {
			Graphiti.getGaService().setLocationAndSize(ga, ga.getX(), ga.getY(), stateWidth, ga.getHeight());
		} else {
			Graphiti.getGaService().setLocationAndSize(ga, ga.getX(), ga.getY(), MAIN_RECTANGLE_WIDTH, ga.getHeight());
		}

		// Borra los anchors del tipo FixPointAnchor que no tienen transiciones
		// de salida
		List<Anchor> anchorsToDelete = new ArrayList<Anchor>();
		Map<String, Anchor> existingAnchors = new HashMap<>();
		PictogramElement rootPe = context.getRootPictogramElement();

		for (Anchor anchor : ((AnchorContainer) rootPe).getAnchors()) {
			if (!(anchor instanceof FixPointAnchor)) {
				continue;
			}
			String eventName = peService.getPropertyValue(anchor, EVENT_NAME);
			if (anchor.getOutgoingConnections().isEmpty() && !fireableEvents.contains(eventName)) {
				anchorsToDelete.add(anchor);
			} else {
				existingAnchors.put(eventName, anchor);
			}
		}

		for (Anchor anchor : anchorsToDelete) {
			peService.deletePictogramElement(anchor);
		}

		// Creamos el anchor y su imagen asociada
		for (String event : getFireableEvents(state)) {
			// No creamos los anchors que ya existen
			if (existingAnchors.containsKey(event)) {
				boolean found = false;
				for (Transition outTransitions : state.getOutgoingTransitions()) {
					if (outTransitions.getEventName().equals(event)) {
						found = true;
						break;
					}
				}
				Text text = (Text) existingAnchors.get(event).getGraphicsAlgorithm();
				if (found) {
					text.setForeground(manageColor(TEXT_COLOR_ON));
				} else if (!found) {
					text.setForeground(manageColor(TEXT_COLOR_OFF));
				}
			} else {

				FixPointAnchor anchor = Graphiti.getPeCreateService().createFixPointAnchor((AnchorContainer) rootPe);

				// Creamos la imagen o el texto del evento dentro del anchor
				Text text = gaService.createText(anchor, event);
				text.setFont(manageFont(FONT_NAME, FONT_SIZE));
				text.setForeground(manageColor(TEXT_COLOR_OFF));
				int textWidth = calculateTextWidth(text);

				gaService.setLocationAndSize(text, 0, 0, textWidth, IMAGE_SIZE);
				peService.setPropertyValue(anchor, "TOOLTIP", event);
				peService.setPropertyValue(anchor, EVENT_NAME, event);
			}
		}

		// Reordenamos los anchors
		acum = MARGIN;
		int index = 0;
		for (Anchor anchor : ((AnchorContainer) rootPe).getAnchors()) {
			if (anchor instanceof FixPointAnchor) {
				((FixPointAnchor) anchor).setLocation(getAnchorLocation(index++, rootPe, anchor));
			}
		}
	}

	private int calculateTextWidth(Text text) {
		IDimension textDimension = GraphitiUi.getUiLayoutService().calculateTextSize(text.getValue(), text.getFont());
		return textDimension.getWidth();
	}

	private int calculateTextWidth(String text) {
		IDimension textDimension = GraphitiUi.getUiLayoutService().calculateTextSize(text,
				manageFont(FONT_NAME, FONT_SIZE));
		return textDimension.getWidth();
	}

	@Override
	protected String getStateImageId() {
		return "";
	}
}
