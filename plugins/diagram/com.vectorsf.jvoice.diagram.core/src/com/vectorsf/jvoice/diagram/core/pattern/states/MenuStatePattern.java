package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IPeService;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;
import com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Output;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class MenuStatePattern extends LocutionStatePattern {

	private static final String MENU = "Menu";
	private int acum = 0;

	@Override
	public String getCreateName() {
		return MENU;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof MenuState || mainBusinessObject instanceof MenuDsl
				&& isDslFromTargetFlow((MenuDsl) mainBusinessObject);
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_MENU;
	}

	@Override
	public String getCreateLargeImageId() {
		return CoreImageProvider.IMG_LARGE_PALETTE_MENU;
	}

	@Override
	protected String getStateImageId() {
		return CoreImageProvider.IMG_STATE_MENU;
	}

	@Override
	protected LocutionState createMainState() {
		return OperationsFactory.eINSTANCE.createMenuState();
	}

	@Override
	protected String getTitle() {
		return "Menu Selection";
	}

	@Override
	protected String getDescription() {
		return "Select a menu:";
	}

	@Override
	protected Class<? extends VoiceDsl> getMainType() {
		return MenuDsl.class;
	}

	/**
	 * Los eventos del estado Menu son los outputs más los eventos especiales.
	 */
	@Override
	public EList<String> getFireableEvents(State state) {
		EList<String> outputNames = new BasicEList<String>();
		MenuState menuState = (MenuState) state;

		VoiceDsl locution = menuState.getLocution();
		if (locution != null) {
			Outputs locutionOutputs = locution.getOutputs();
			if (locutionOutputs != null) {
				for (Output output : locutionOutputs.getOutput()) {
					outputNames.add(output.getName());
				}
			}
		}

		outputNames.addAll(state.getFireableEvents());

		return outputNames;
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
			int stateWidth = getStateWidth(context);
			if (stateWidth > MAIN_RECTANGLE_WIDTH) {
				changeTopRectangleWidth(context, stateWidth);
			} else {
				changeTopRectangleWidth(context, MAIN_RECTANGLE_WIDTH);
			}
			changesDone = true;
		}

		return changesDone;
	}

	@Override
	public int getEventsWidth(State state) {
		int size = MARGIN;
		for (String string : getFireableEvents(state)) {
			size += calculateTextWidth(string);
			size += MARGIN;
		}

		return size;
	}

	@Override
	public Point getAnchorLocation(int index, PictogramElement pe, Anchor anchor) {
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

	@Override
	protected void createVerticalLine(Rectangle mainRectangle, int index) {
		// Do nothing
	}

	/**
	 * Actualiza la barra de eventos que puede disparar el estado.
	 */
	@Override
	public void updateFireableEvents(IdLayoutContext context) {
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		IPeService peService = Graphiti.getPeService();

		// Ajustamos el tamaño del estado
		int stateWidth = getStateWidth(context);
		stateWidth = stateWidth > MAIN_RECTANGLE_WIDTH ? stateWidth : MAIN_RECTANGLE_WIDTH;
		gaService.setLocationAndSize(ga, ga.getX(), ga.getY(), stateWidth, ga.getHeight());
		GraphicsAlgorithm gaText = (GraphicsAlgorithm) findById(context.getRootPictogramElement(), ID_NAME_TEXT);
		gaService.setSize(gaText, stateWidth - TEXT_MARGIN, gaText.getHeight());

		// Borra los anchors del tipo FixPointAnchor que no tienen transiciones
		// de salida
		List<Anchor> anchorsToDelete = new ArrayList<Anchor>();
		Map<String, Anchor> existingAnchors = new HashMap<>();
		PictogramElement rootPe = context.getRootPictogramElement();

		State state = (State) getBusinessObjectForPictogramElement(ga.getPictogramElement());
		List<String> fireableEvents = getFireableEvents(state);

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
		for (String event : fireableEvents) {
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

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			// Obtenemos los nombres de las options
			MenuState state = (MenuState) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
			if (state == null || state.getLocution() == null || state.getLocution().getOutputs() == null) {
				return super.updateNeeded(context, id);
			}

			Set<String> optionNames = new HashSet<String>();
			for (Output c : state.getLocution().getOutputs().getOutput()) {
				optionNames.add(c.getName());
			}

			// Si se modifica las options en el fichero hay que actualizar el estado.
			Set<String> anchorNames = SimpleStatePattern.getAnchorNames(context);
			anchorNames.removeAll(state.getFireableEvents());
			if (!optionNames.equals(anchorNames)) {
				return Reason.createTrueReason("The menu options have changed, please update the state");
			}
		}

		return super.updateNeeded(context, id);
	}

}
