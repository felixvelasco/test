package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.model.operations.LocutionState;

public class LocutionStateValidator {

	private OperationsValidator operationsValidator;

	public LocutionStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_LocutionState_checkGrammars(LocutionState lstate) {

		return true;
	}

	public boolean validate_LocutionState_checkOutcomingsLocution(LocutionState lstate) {

		return true;
	}

	public boolean validate_LocutionState_checkOutcomingsMenuState(LocutionState lstate) {

		return true;
	}
}
