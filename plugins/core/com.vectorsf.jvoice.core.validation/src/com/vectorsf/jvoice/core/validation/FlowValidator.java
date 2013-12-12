package com.vectorsf.jvoice.core.validation;

import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;

public class FlowValidator {

	private OperationsValidator operationsValidator;

	public FlowValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_Flow_oneInitialState(Flow flow) {
		int initialCount = 0;
		for (State state : flow.getStates()) {
			if (state instanceof InitialState) {
				initialCount++;
			}
		}
		if (initialCount == 0) {
			operationsValidator.error(flow, "No initial state found");

		} else if (initialCount > 1) {
			operationsValidator.error(flow, "Too many initial states found");
		}
		return true;
	}

	public boolean validate_Flow_someFinalState(Flow flow) {
		for (State state : flow.getStates()) {
			if (state instanceof FinalState) {
				return true;
			}
		}
		operationsValidator.error(flow, "No final state found");
		return true;
	}

	public boolean validate_Flow_distintNameParameter(Flow flow) {

		return true;
	}

}
