package com.vectorsf.jvoice.core.validation;

import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.State;

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

	/*****************************************/
	/****** VALIDACIONES DE LOS FLUJOS *******/
	/*****************************************/

	public boolean validate_Flow_oneInitialState(Flow flow) {
		return flowValidator.validate_Flow_oneInitialState(flow);
	}

	public boolean validate_Flow_someFinalState(Flow flow) {
		return flowValidator.validate_Flow_someFinalState(flow);
	}

	public boolean validate_Flow_distintNameParameter(Flow flow) {
		return flowValidator.validate_Flow_distintNameParameter(flow);
	}

	/*****************************************/
	/****** VALIDACIONES DE LOS ESTADOS ******/
	/*****************************************/

	public boolean validate_State_incoming(State state) {
		return stateValidator.validate_State_incoming(state);
	}

	public boolean validate_State_outcoming(State state) {
		return stateValidator.validate_State_outcoming(state);
	}

	public boolean validate_State_outcomingSubflowState(State state) {
		return stateValidator.validate_State_outcomingSubflowState(state);
	}

	public boolean validate_State_eventTransitions(State state) {
		return stateValidator.validate_State_eventTransitions(state);
	}

	public boolean validate_State_atLeastTwoEventsSwitch(State state) {
		return stateValidator.validate_State_atLeastTwoEventsSwitch(state);
	}

	public boolean validate_State_propertiesEventsSwitch(State state) {
		return stateValidator.validate_State_propertiesEventsSwitch(state);
	}

	public boolean validate_State_noOutcomingFinalState(State state) {
		return stateValidator.validate_State_noOutcomingFinalState(state);
	}

	public boolean validate_State_noIncomingInitialState(State state) {
		return stateValidator.validate_State_noIncomingInitialState(state);
	}

	public boolean validate_State_methodFlowExecutionState(State state) {
		return stateValidator.validate_State_methodFlowExecutionState(state);
	}

	public boolean validate_State_methodInstanceBeanExecutionState(State state) {
		return stateValidator.validate_State_methodInstanceBeanExecutionState(state);
	}

	public boolean validate_State_eventOkOnlyExecutionState(State state) {
		return stateValidator.validate_State_eventOkOnlyExecutionState(state);
	}

	public boolean validate_State_exceptionEventsExecutionState(State state) {
		return stateValidator.validate_State_exceptionEventsExecutionState(state);
	}

	public boolean validate_State_oneOutcomingCustomState(State state) {
		return stateValidator.validate_State_oneOutcomingCustomState(state);
	}

	public boolean validate_State_oneOutcomingNotesState(State state) {
		return stateValidator.validate_State_oneOutcomingNotesState(state);
	}

	/*****************************************/
	/****** VALIDACIONES DE LOS BEANS *******/
	/*****************************************/
	public boolean validate_ComponentBean_distintNameScopedBean(ComponentBean bean) {
		return beanValidator.validate_ComponentBean_distintNameScopedBean(bean);
	}

	/*****************************************/
	/****** VALIDACIONES DE LAS LOCUCIONES ***/
	/*****************************************/

	public boolean validate_LocutionState_checkWav(LocutionState lstate) {
		return dslValidator.validate_LocutionState_checkWav(lstate);
	}

	public boolean validate_LocutionState_checkGrammars(LocutionState lstate) {
		return dslValidator.validate_LocutionState_checkGrammars(lstate);
	}

	public boolean validate_LocutionState_checkOutcomingsLocution(LocutionState lstate) {
		return dslValidator.validate_LocutionState_checkOutcomingsLocution(lstate);
	}

	public boolean validate_LocutionState_checkOutcomingsMenuState(LocutionState lstate) {
		return dslValidator.validate_LocutionState_checkOutcomingsMenuState(lstate);
	}
}
