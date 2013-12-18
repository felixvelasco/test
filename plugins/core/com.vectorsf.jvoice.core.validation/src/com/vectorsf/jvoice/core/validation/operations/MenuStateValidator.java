package com.vectorsf.jvoice.core.validation.operations;

import java.util.ArrayList;
import java.util.List;

import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.Transition;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Output;

public class MenuStateValidator {
	private OperationsValidator operationsValidator;

	public MenuStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_MenuState_checkOutcomingsMenuState(MenuState state) {
		if (state.getLocution().getOutputs() != null && state.getLocution().getOutputs().getOutput() != null) {
			if (state.getOutgoingTransitions().size() > state.getLocution().getOutputs().getOutput().size()) {
				operationsValidator.error(state, "State " + state.getName() + " must have "
						+ state.getLocution().getOutputs().getOutput().size() + " or less outgoing transitions");
			}
		}

		return true;
	}

	public boolean validate_MenuState_checkMenuOptions(MenuState state) {
		List<String> transitions = new ArrayList<String>();
		for (Transition t : state.getOutgoingTransitions()) {
			transitions.add(t.getEventName());
		}

		for (Output o : state.getLocution().getOutputs().getOutput()) {
			if (!transitions.contains(o.getName())) {
				operationsValidator.error(state, "Menu state " + state.getName() + " with output \"" + o.getName()
						+ "\" has no transition for this output.");
			}
		}

		for (String t : transitions) {
			boolean contains = false;
			for (Output o : state.getLocution().getOutputs().getOutput()) {
				if (t.equals(o.getName())) {
					contains = true;
					break;
				}
			}
			if (!contains) {
				operationsValidator.error(state, "Menu state " + state.getName() + " has a transition \"" + t
						+ "\" with no defined outputs.");
			}
		}

		return true;
	}
}
