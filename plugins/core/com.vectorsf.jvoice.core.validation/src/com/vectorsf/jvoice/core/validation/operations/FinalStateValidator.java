package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.model.operations.FinalState;

public class FinalStateValidator {
	private OperationsValidator operationsValidator;

	public FinalStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_FinalState_noOutcomingFinalState(FinalState state) {
		if (!state.getOutgoingTransitions().isEmpty()) {
			operationsValidator.error(state, "State " + state.getName() + " have outgoing transitions");
		}
		return true;
	}

}
