package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.model.operations.ComponentBean;

public class BeanValidator {
	private OperationsValidator operationsValidator;

	public BeanValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_ComponentBean_distintNameScopedBean(ComponentBean bean) {

		return true;
	}
}
