package com.vectorsf.jvoice.core.validation.operations;

import java.util.ArrayList;
import java.util.List;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;
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

	public boolean validate_State_outcomingSubflowState(State state) {
		List<String> finalStatesNames = new ArrayList<String>();
		if (state instanceof CallFlowState) {
			for (State subflowStates : ((CallFlowState) state).getSubflow().getStates()) {
				if (subflowStates instanceof FinalState) {
					finalStatesNames.add(subflowStates.getName());
				}
			}

			for (Transition t : state.getOutgoingTransitions()) {
				if (!finalStatesNames.contains(t.getEventName())) {
					operationsValidator.warning(state,
							"State " + state.getName() + " has final state \"" + t.getEventName() + "\" in subflow");
				}
			}

			for (String f : finalStatesNames) {
				boolean contains = false;
				for (Transition t : state.getOutgoingTransitions()) {
					if (f.equals(t.getEventName())) {
						contains = true;
						break;
					}
				}
				if (!contains) {
					operationsValidator.error(state, "State " + state.getName() + " has no transition for event \"" + f
							+ "\" defined in subflow.");
				}
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

		if (state instanceof CallState) {
			CallState callState = (CallState) state;
			Flow flow = (Flow) state.eContainer();
			boolean existbean = false;
			for (ComponentBean bean : flow.getBeans()) {
				if (bean.getNameBean().equals(callState.getBean().getNameBean())) {
					existbean = true;
				}
			}
			if (!existbean) {
				operationsValidator.error(state, "Instance Bean  " + callState.getBean() + " not found");
			}

		}

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
