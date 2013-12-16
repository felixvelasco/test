package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.model.operations.InitialState;

public class InitialStateValidator {
	private OperationsValidator operationsValidator;

	public InitialStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_InitialState_noIncomingInitialState(InitialState state) {
		if (!state.getIncomingTransitions().isEmpty()) {
			operationsValidator.error(state, "State " + state.getName() + " have incoming transitions");
		}
		return true;
	}

}
