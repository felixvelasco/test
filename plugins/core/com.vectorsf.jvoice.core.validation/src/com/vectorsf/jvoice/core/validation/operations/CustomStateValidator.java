package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.model.operations.CustomState;

public class CustomStateValidator {
	private OperationsValidator operationsValidator;

	public CustomStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_CustomState_oneOutcomingCustomState(CustomState state) {

		if (state.getOutgoingTransitions().size() > 1) {
			operationsValidator.error(state, "State " + state.getName() + " has more than one outgoing transition");
		}

		return true;
	}
}
