package com.vectorsf.jvoice.core.validation;

import com.vectorsf.jvoice.model.operations.ComponentBean;

public class BeanValidator extends AbstractPolymorphicValidator {

	public boolean validate_ComponentBean_distintNameScopedBean(ComponentBean bean) {

		return true;
	}
}
