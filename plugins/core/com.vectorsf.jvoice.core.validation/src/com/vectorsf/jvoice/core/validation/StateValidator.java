package com.vectorsf.jvoice.core.validation;

import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;

public class StateValidator extends AbstractPolymorphicValidator {

	public boolean validate_State_incoming(State state) {
		if (!(state instanceof InitialState)) {

			if (state.getIncomingTransitions().isEmpty()) {
				error(state, "State " + state.getName() + " does not have incoming transitions");
			}
		}

		return true;
	}

	public boolean validate_State_outcoming(State state) {

		return true;
	}

	public boolean validate_State_outcomingSubflowState(State state) {

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

	public boolean validate_State_noOutcomingFinalState(State state) {

		return true;
	}

	public boolean validate_State_noIncomingInitialState(State state) {

		return true;
	}

	public boolean validate_State_methodFlowExecutionState(State state) {

		return true;
	}

	public boolean validate_State_methodInstanceBeanExecutionState(State state) {

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
}
