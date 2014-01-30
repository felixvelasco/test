package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Image;
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

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Output;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class MenuStatePattern extends LocutionStatePattern {

	private static final String MENU = "Menu";
	private int cont = 0;

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
			State state = (State) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
			if (getStateWith(state) > MAIN_RECTANGLE_WIDTH) {
				changeTopRectangleWidth(context, getStateWith(state));
			} else {
				changeTopRectangleWidth(context, MAIN_RECTANGLE_WIDTH);
			}
			changesDone = true;
		}

		return changesDone;
	}

	public int getStateWith(State state) {
		int numLetters = 0;
		for (String string : getFireableEvents(state)) {
			numLetters += string.length();
		}

		return numLetters * 7;
	}

	@Override
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

	/**
	 * Actualiza la barra de eventos que puede disparar el estado.
	 */
	@Override
	public void updateFireableEvents(IdLayoutContext context) {
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();

		State state = (State) getBusinessObjectForPictogramElement(ga.getPictogramElement());

		// Ajustamos el tamaño del estado
		if (getStateWith(state) > MAIN_RECTANGLE_WIDTH) {
			Graphiti.getGaService().setLocationAndSize(ga, ga.getX(), ga.getY(), getStateWith(state), ga.getHeight());
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
				GraphicsAlgorithm ga2 = anchor.getGraphicsAlgorithm();
				if (ga2 instanceof Image) {
					existingAnchors.add(((Image) ga2).getId());
				} else {
					existingAnchors.add(((Text) ga2).getValue());
				}
			}
		}

		for (Anchor anchor : anchorsToDelete) {
			Graphiti.getPeService().deletePictogramElement(anchor);
		}

		// Creamos el anchor y su imagen asociada
		for (String event : getFireableEvents(state)) {
			// No creamos los anchors que ya existen
			if (existingAnchors.contains(event)) {
				continue;
			}

			FixPointAnchor anchor = Graphiti.getPeCreateService().createFixPointAnchor((AnchorContainer) rootPe);

			// Creamos la imagen o el texto del evento dentro del anchor
			Text text = gaService.createText(anchor, event);
			gaService.setLocationAndSize(text, 0, 0, event.length() * 7, IMAGE_SIZE);
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

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			// Obtenemos los nombres de las options
			MenuState state = (MenuState) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
			Set<String> optionNames = new HashSet<String>();
			for (Output c : state.getLocution().getOutputs().getOutput()) {
				optionNames.add(c.getName());
			}

			// Si se modifica las options en el fichero hay que actualizar el estado.
			if (!optionNames.equals(SimpleStatePattern.getAnchorNames(context))) {
				return Reason.createTrueReason();
			}
		}

		return super.updateNeeded(context, id);
	}

}
