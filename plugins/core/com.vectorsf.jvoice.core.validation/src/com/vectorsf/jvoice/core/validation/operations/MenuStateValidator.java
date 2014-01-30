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

		return true;
	}
}
