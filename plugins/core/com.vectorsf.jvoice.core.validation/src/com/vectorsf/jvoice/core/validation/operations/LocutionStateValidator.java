package com.vectorsf.jvoice.core.validation.operations;

import java.io.File;

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

	public boolean validate_LocutionState_checkDslsLocutionState(LocutionState lstate) {
		if (lstate.isTextual()) {
			if (lstate.getLocution() == null) {
				operationsValidator
						.error(lstate, "Definition State " + lstate.getName() + " has not a dsl associated.");
			} else {
				File rawFile = ValidatorUtils.getFile(lstate);
				if (rawFile != null) {
					String name = rawFile.getName().substring(0, rawFile.getName().indexOf("."));
					File file = new File(rawFile.getParent(), name + ".resources/" + lstate.getLocution().getName()
							+ ".voiceDsl");

					if (!file.exists()) {
						operationsValidator.error(lstate, "Locution " + lstate.getLocution() + " does not exist.");
					}
				}

			}
		}

		return true;
	}

}
