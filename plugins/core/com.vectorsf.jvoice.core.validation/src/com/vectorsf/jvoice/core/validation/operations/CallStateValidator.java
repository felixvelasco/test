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

	public boolean validate_CallState_noEmptyParams(CallState state) {
		for (String param : state.getParameters()) {
			if (param.trim().isEmpty()) {
				operationsValidator.error(state, "Parameters in Call State must not be empty.");
				// Se utiliza un "break" para que solo aparezca un mensaje por
				// estado, ya que no se puede poner el nombre del parametro vacio
				// y por tanto, no se puede poner un mensaje por parametro.
				break;
			}
		}
		return true;
	}
}
