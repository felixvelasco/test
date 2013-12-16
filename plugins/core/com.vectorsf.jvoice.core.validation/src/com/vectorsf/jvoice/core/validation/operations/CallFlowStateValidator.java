package com.vectorsf.jvoice.core.validation.operations;

import java.util.ArrayList;
import java.util.List;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

public class CallFlowStateValidator {
	private OperationsValidator operationsValidator;

	public CallFlowStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_CallFlowState_outcomingSubflowState(CallFlowState state) {
		List<String> finalStatesNames = new ArrayList<String>();
		for (State subflowStates : state.getSubflow().getStates()) {
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

		return true;
	}
}
