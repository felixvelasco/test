package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.core.validation.AbstractPolymorphicValidator;

public class OperationsValidator extends AbstractPolymorphicValidator {

	private FlowValidator flowValidator;
	private StateValidator stateValidator;
	private BeanValidator beanValidator;
	private LocutionStateValidator dslValidator;

	public OperationsValidator() {
		this.flowValidator = new FlowValidator(this);
		this.stateValidator = new StateValidator(this);
		this.beanValidator = new BeanValidator(this);
		this.dslValidator = new LocutionStateValidator(this);
	}

	public FlowValidator getFlowValidator() {
		return flowValidator;
	}

	public StateValidator getStateValidator() {
		return stateValidator;
	}

	public BeanValidator getComponentBeanValidator() {
		return beanValidator;
	}

	public LocutionStateValidator getLocutionStateValidator() {
		return dslValidator;
	}
}
