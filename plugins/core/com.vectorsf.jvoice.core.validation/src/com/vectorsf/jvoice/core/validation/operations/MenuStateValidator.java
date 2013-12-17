package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.model.operations.MenuState;

public class MenuStateValidator {
	private OperationsValidator operationsValidator;

	public MenuStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_MenuState_checkOutcomingsMenuState(MenuState state) {
		if (state.getLocution().getOutputs() != null && state.getLocution().getOutputs().getOutput() != null) {
			if (state.getOutgoingTransitions().size() > state.getLocution().getOutputs().getOutput().size()) {
				operationsValidator.error(state, "State " + state.getName() + " must have "
						+ state.getLocution().getOutputs().getOutput().size() + " or less outgoing transitions");
			}
		}
		return true;
	}
}
