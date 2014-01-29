package com.vectorsf.jvoice.core.validation.operations;

import java.util.List;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;

public class StateValidator {

	private OperationsValidator operationsValidator;

	public StateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_State_incoming(State state) {
		if (!(state instanceof InitialState)) {

			if (state.getIncomingTransitions().isEmpty()) {
				operationsValidator.error(state, "State " + state.getName() + " does not have incoming transitions");
			}
		}

		return true;
	}

	public boolean validate_State_outcoming(State state) {
		if (!(state instanceof FinalState)) {

			if (state.getOutgoingTransitions().isEmpty()) {
				operationsValidator.error(state, "State " + state.getName() + " does not have outgoing transitions");
			}
		}
		return true;
	}

	public boolean validate_State_eventTransitions(State state) {

		return true;
	}

	public boolean validate_State_methodFlowExecutionState(State state) {

		return true;
	}

	public boolean validate_State_eventOkOnlyExecutionState(State state) {

		return true;
	}

	public boolean validate_State_exceptionEventsExecutionState(State state) {

		return true;
	}

	public boolean validate_State_oneOutcomingCustomState(State state) {

		return true;
	}

	public boolean validate_State_oneOutcomingNotesState(State state) {

		return true;
	}

	public boolean validate_State_formatNameState(State state) {
		if (state.getName().length() > 30) {
			operationsValidator.error(state, "Name of " + state.getName() + " is too long.");
		}

		char initial = state.getName().charAt(0);
		if (!(state.getName().startsWith("_") || Character.isJavaLetter(initial))) {
			operationsValidator.error(state, "Name of " + state.getName() + " starts with a incorrect letter.");
		}

		for (int i = 1; i < state.getName().length(); i++) {
			char letter = state.getName().charAt(i);
			if (!Character.isJavaLetterOrDigit(letter)) {
				operationsValidator.error(state, "Name of " + state.getName() + " contains incorrect character.");
				break;
			}

		}

		return true;
	}

	public boolean validate_State_eventOkOnlyState(State state) {
		if (!(state instanceof SwitchState || state instanceof MenuState || state instanceof CallFlowState || state instanceof FinalState)) {
			List<Transition> transitions = state.getOutgoingTransitions();
			if (transitions.size() > 1) {
				operationsValidator.error(state, "State " + state.getName() + " has more than 1 outgoing transitions.");
			} else {
				if (!transitions.isEmpty() && !transitions.get(0).getEventName().equalsIgnoreCase("OK")) {
					operationsValidator.error(state, "State " + state.getName() + " must have an \"ok\" event.");
				}
			}
		}
		return true;
	}
}
