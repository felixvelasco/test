package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.core.validation.AbstractPolymorphicValidator;

public class OperationsValidator extends AbstractPolymorphicValidator {

	private FlowValidator flowValidator;
	private StateValidator stateValidator;
	private BeanValidator beanValidator;
	private LocutionStateValidator dslValidator;
	private CallStateValidator callValidator;
	private InitialStateValidator initialValidator;
	private CallFlowStateValidator callFlowValidator;
	private FinalStateValidator finalValidator;
	private SwitchStateValidator switchStateValidator;

	public OperationsValidator() {
		this.flowValidator = new FlowValidator(this);
		this.stateValidator = new StateValidator(this);
		this.beanValidator = new BeanValidator(this);
		this.dslValidator = new LocutionStateValidator(this);
		this.callValidator = new CallStateValidator(this);
		this.initialValidator = new InitialStateValidator(this);
		this.callFlowValidator = new CallFlowStateValidator(this);
		this.finalValidator = new FinalStateValidator(this);
		this.switchStateValidator = new SwitchStateValidator(this);
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

	public CallStateValidator getCallStateValidator() {
		return callValidator;
	}

	public InitialStateValidator getInitialStateValidator() {
		return initialValidator;
	}

	public CallFlowStateValidator getCallFlowStateValidator() {
		return callFlowValidator;
	}

	public FinalStateValidator getFinalStateValidator() {
		return finalValidator;
	}

	public SwitchStateValidator getSwitchStateValidator() {
		return switchStateValidator;
	}
}
