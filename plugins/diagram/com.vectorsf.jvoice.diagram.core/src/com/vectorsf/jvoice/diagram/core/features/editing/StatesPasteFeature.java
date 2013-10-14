package com.vectorsf.jvoice.diagram.core.features.editing;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.PromptState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;

public class StatesPasteFeature extends AbstractPasteFeature {

	public StatesPasteFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void paste(IPasteContext context) {
		Object[] copies = getCopiesFromClipBoard(context);
		Map<State, PictogramElement> hm = new HashMap<State, PictogramElement>();
		for (Object copy : copies) {
			AddContext ac = new AddContext();
			if (isState(copy)) {
				State state = (State) copy;
				state.setName(generateName(((State) copy).getName(), context));
				Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
				flow.getStates().add(state);
				copy = state;
				ac.setLocation(context.getX(), context.getY());
				ac.setTargetContainer(getDiagram());
				if (copy != null) {
					PictogramElement pe = addGraphicalRepresentation(ac, copy);
					hm.put(state, pe);
				}
			}

		}
		for (Object copy : copies) {

			if (copy instanceof Transition) {

				Transition transition = (Transition) copy;

				State sourceState = transition.getSource();
				State targetState = transition.getTarget();
				Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
				flow.getTransitions().add(transition);
				PictogramElement[] pes = context.getPictogramElements();
				if (pes[0] instanceof Diagram) {
					PictogramElement peSource = hm.get(sourceState);
					ContainerShape csSource = (ContainerShape) peSource;
					PictogramElement peTarget = hm.get(targetState);
					ContainerShape csTarget = (ContainerShape) peTarget;
					AddConnectionContext addContextInicial = new AddConnectionContext(
							csSource.getAnchors().get(0), csTarget.getAnchors()
									.get(0));
					addContextInicial.setNewObject(transition);
					addContextInicial
							.setTargetContainer((ContainerShape) peSource);

					Connection connection = (Connection) getFeatureProvider()
							.addIfPossible(addContextInicial);
					layoutPictogramElement(connection);
				}

			}
		}

	}

	@Override
	public boolean canPaste(IPasteContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes.length != 1
				|| !(pes[0] instanceof Diagram
						|| pes[0] instanceof ContainerShape || pes[0] instanceof Transition)) {
			return false;
		}

		Object[] fromClipboard = getFromClipboard();
		if (fromClipboard == null || fromClipboard.length == 0) {
			return false;
		}
		for (Object object : fromClipboard) {
			if (!isState(object) && !(object instanceof Transition)) {
				return false;
			}
		}
		return true;
	}

	private boolean isState(Object object) {
		if (object instanceof CallFlowState || object instanceof CallState
				|| object instanceof FinalState
				|| object instanceof InitialState
				|| object instanceof InputState || object instanceof MenuState
				|| object instanceof PromptState
				|| object instanceof SwitchState) {
			return true;
		}
		return false;
	}

	private String generateName(String stateName, IPasteContext context) {

		PictogramElement[] pes = context.getPictogramElements();
		if (pes.length != 0) {
			if (pes[0] instanceof Diagram) {
				Diagram diagram = (Diagram) pes[0];
				String name = "CopyOf" + stateName;
				int repeated = 0;
				for (int i = 0; i < diagram.getChildren().size(); i++) {
					Shape shape = diagram.getChildren().get(i);
					State state = (State) getBusinessObjectForPictogramElement(shape);
					if (state.getName().equals(name)) {
						int k = repeated + 2;
						name = "Copy" + k + "Of" + stateName;
						repeated++;
						i = 0;
					}

				}
				return name;
			} else {
				String name = "CopyOf" + stateName;
				int repeated = 0;
				for (int i = 0; i < pes.length; i++) {
					if (pes[i] instanceof Shape
							&& !(pes[i] instanceof ConnectionDecorator)) {
						Shape shape = (Shape) pes[i];
						State state = (State) getBusinessObjectForPictogramElement(shape);
						if (state != null) {
							if (state.getName().equals(name)) {
								int k = repeated + 2;
								name = "Copy" + k + "Of" + stateName;
								repeated++;
								i = 0;
							}
						}
					}

				}
				return name;

			}
		}
		return "CopyOf";
	}
}
