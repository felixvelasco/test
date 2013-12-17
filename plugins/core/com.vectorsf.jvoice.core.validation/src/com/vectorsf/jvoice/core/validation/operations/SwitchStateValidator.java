package com.vectorsf.jvoice.core.validation.operations;

import java.util.ArrayList;
import java.util.List;

import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;

public class SwitchStateValidator {

	private OperationsValidator operationsValidator;

	public SwitchStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_SwitchState_atLeastTwoEventsSwitch(SwitchState state) {
		if (state.getCase().size() < 2) {
			operationsValidator.error(state, "Switch " + state.getName() + " must have 2 or more cases.");
		}
		return true;
	}

	public boolean validate_SwitchState_propertiesEventsSwitch(SwitchState state) {
		List<String> transitionsCases = new ArrayList<String>();
		for (Transition t : state.getOutgoingTransitions()) {
			transitionsCases.add(t.getEventName());
		}

		for (Case c : state.getCase()) {
			if (!transitionsCases.contains(c.getEventName())) {
				operationsValidator.error(state, "Switch state " + state.getName() + " with case \"" + c.getEventName()
						+ "\" has no sate transition for this case.");
			}
		}

		for (String t : transitionsCases) {
			boolean contains = false;
			for (Case c : state.getCase()) {
				if (t.equals(c.getEventName())) {
					contains = true;
					break;
				}
			}
			if (!contains) {
				operationsValidator.error(state, "Switch state " + state.getName() + " has a transition \"" + t
						+ "\" with no defined case.");
			}
		}
		return true;
	}
}
