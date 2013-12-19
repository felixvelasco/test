package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.model.operations.ComponentBean;

public class ComponentBeanValidator {
	private OperationsValidator operationsValidator;

	public ComponentBeanValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_ComponentBean_formatNameState(ComponentBean bean) {
		if (bean.getName().length() > 30) {
			operationsValidator.error(bean, "Name of Component Bean" + bean.getName() + " is too long.");
		}

		char initial = bean.getName().charAt(0);
		if (!Character.isLetter(initial)) {
			operationsValidator.error(bean, "Name of Component Bean" + bean.getName()
					+ " starts with a incorrect letter.");
		}

		for (int i = 0; i < bean.getName().length(); i++) {
			char letter = bean.getName().charAt(i);
			if (!(Character.isLetter(letter) || Character.isDigit(letter))) {
				operationsValidator.error(bean, "Name of Component Bean " + bean.getName()
						+ " contains incorrect character.");
				break;
			}

		}

		return true;
	}

}
