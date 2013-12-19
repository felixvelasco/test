package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.core.validation.AbstractPolymorphicValidator;

public class OperationsValidator extends AbstractPolymorphicValidator {

	private FlowValidator flowValidator;
	private StateValidator stateValidator;
	private LocutionStateValidator dslValidator;
	private CallStateValidator callValidator;
	private CustomStateValidator customValidator;
	private InitialStateValidator initialValidator;
	private CallFlowStateValidator callFlowValidator;
	private FinalStateValidator finalValidator;
	private SwitchStateValidator switchStateValidator;
	private NoteValidator noteValidator;
	private MenuStateValidator menuStateValidator;
	private ComponentBeanValidator componentBeanValidator;

	public OperationsValidator() {
		this.flowValidator = new FlowValidator(this);
		this.stateValidator = new StateValidator(this);
		this.dslValidator = new LocutionStateValidator(this);
		this.callValidator = new CallStateValidator(this);
		this.customValidator = new CustomStateValidator(this);
		this.initialValidator = new InitialStateValidator(this);
		this.callFlowValidator = new CallFlowStateValidator(this);
		this.finalValidator = new FinalStateValidator(this);
		this.switchStateValidator = new SwitchStateValidator(this);
		this.noteValidator = new NoteValidator(this);
		this.menuStateValidator = new MenuStateValidator(this);
		this.componentBeanValidator = new ComponentBeanValidator(this);
	}

	public FlowValidator getFlowValidator() {
		return flowValidator;
	}

	public StateValidator getStateValidator() {
		return stateValidator;
	}

	public LocutionStateValidator getLocutionStateValidator() {
		return dslValidator;
	}

	public CallStateValidator getCallStateValidator() {
		return callValidator;
	}

	public CustomStateValidator getCustomStateValidator() {
		return customValidator;
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

	public NoteValidator getNoteValidator() {
		return noteValidator;
	}

	public MenuStateValidator getMenuStateValidator() {
		return menuStateValidator;
	}

	public ComponentBeanValidator getComponentBeanValidator() {
		return componentBeanValidator;
	}

}
