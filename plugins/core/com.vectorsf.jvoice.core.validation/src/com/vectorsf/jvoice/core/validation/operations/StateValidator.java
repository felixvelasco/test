package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;

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

	public boolean validate_State_atLeastTwoEventsSwitch(State state) {

		return true;
	}

	public boolean validate_State_propertiesEventsSwitch(State state) {

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
		if (!(state.getName().startsWith("_") || Character.isLetter(initial))) {
			operationsValidator.error(state, "Name of " + state.getName() + " starts with a incorrect letter.");
		}

		for (int i = 0; i < state.getName().length(); i++) {
			char letter = state.getName().charAt(i);
			if (!(Character.isLetter(letter) || Character.isDigit(letter) || Character.toString(letter).equals(".")
					|| Character.toString(letter).equals("_") || Character.toString(letter).equals("-"))) {
				operationsValidator.error(state, "Name of " + state.getName() + " contains incorrect character.");
				break;
			}

		}

		return true;
	}
}
