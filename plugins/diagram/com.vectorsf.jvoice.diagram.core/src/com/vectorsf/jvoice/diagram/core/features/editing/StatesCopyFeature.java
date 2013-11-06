package com.vectorsf.jvoice.diagram.core.features.editing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractCopyFeature;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.PromptState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;

public class StatesCopyFeature extends AbstractCopyFeature {

	public StatesCopyFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void copy(ICopyContext context) {

		PictogramElement[] pes = context.getPictogramElements();
		Collection<EObject> copies = new ArrayList<EObject>();
		Collection<EObject> copiesTrans = new ArrayList<EObject>();
		// Copiamos todos los objetos de negocio de los pictogram elements
		for (PictogramElement pe : pes) {

			if (pe instanceof ContainerShape) {
				EObject eObject = (EObject) getBusinessObjectForPictogramElement(pe);
				copies.add(eObject);
			}

		}
		// Comprobamos si hay alguna transicion entre dos estados que se hayan copiado
		for (EObject copy : copies) {
			if (isState(copy)) {
				State state = (State) copy;
				List<Transition> transitions = state.getOutgoingTransitions();
				for (Transition transition : transitions) {
					for (EObject c : copies) {
						if (isState(c)) {
							State sta = (State) c;
							if (transition.getTarget().getName().equals(sta.getName())) {
								copiesTrans.add(transition);
							}
						}
					}
				}
			}
		}

		copies.addAll(copiesTrans);
		putToClipboard(copies.toArray());
	}

	@Override
	public boolean canCopy(ICopyContext context) {
		return true;
	}

	private boolean isState(Object object) {
		if (object instanceof CallFlowState || object instanceof CallState || object instanceof FinalState
				|| object instanceof InitialState || object instanceof InputState || object instanceof MenuState
				|| object instanceof PromptState || object instanceof SwitchState || object instanceof CustomState) {
			return true;
		}
		return false;
	}

}
