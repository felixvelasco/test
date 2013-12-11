package com.vectorsf.jvoice.core.validation;

import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;

public class FlowValidator extends AbstractPolymorphicValidator {

	public boolean validate_Flow_oneInitialState(Flow flow) {
		int initialCount = 0;
		for (State state : flow.getStates()) {
			if (state instanceof InitialState) {
				initialCount++;
			}
		}
		if (initialCount == 0) {
			error(flow, "No initial state found");

		} else if (initialCount > 1) {
			error(flow, "Too many initial states found");
		}
		return initialCount == 1;
	}

	public boolean validate_Flow_someFinalState(Flow flow) {
		for (State state : flow.getStates()) {
			if (state instanceof FinalState) {
				return true;
			}
		}
		error(flow, "No final state found");
		return false;
	}

	public boolean validate_State_incoming(State state) {
		if (state instanceof InitialState) {
			return true;
		}

		boolean valid = !state.getIncomingTransitions().isEmpty();
		if (!valid) {
			error(state, "State " + state.getName() + " does not have incoming transitions");
		}

		return valid;
	}

	public boolean validate_LocutionState_incoming(State LocationState) {
		return true;
	}

}
