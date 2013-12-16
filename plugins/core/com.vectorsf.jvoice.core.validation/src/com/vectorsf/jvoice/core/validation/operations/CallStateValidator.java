package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;

public class CallStateValidator {
	private OperationsValidator operationsValidator;

	public CallStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_CallState_methodInstanceBeanExecutionState(CallState state) {

		Flow flow = (Flow) state.eContainer();
		boolean existbean = false;
		for (ComponentBean bean : flow.getBeans()) {
			if (bean == state.getBean()) {
				existbean = true;
			}
		}
		if (!existbean) {
			operationsValidator.error(state, "Instance Bean  " + state.getBean() + " not found");
		}

		return true;
	}
}
