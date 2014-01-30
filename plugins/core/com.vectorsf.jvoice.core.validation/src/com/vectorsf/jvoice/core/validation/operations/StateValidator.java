package com.vectorsf.jvoice.core.validation.operations;

import java.util.List;

import org.eclipse.emf.common.util.URI;

import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;

public class StateValidator {

	private OperationsValidator operationsValidator;

	public StateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_State_incoming(State state) {
		if (!(state instanceof InitialState)) {

			if (state.getIncomingTransitions().isEmpty()) {
				operationsValidator.error(state, "State " + state.getName() + " does not have incoming transitions");
			}
		}

		return true;
	}

	public boolean validate_State_outcoming(State state) {
		if (!(state instanceof FinalState)) {

			if (state.getOutgoingTransitions().isEmpty()) {
				operationsValidator.error(state, "State " + state.getName() + " does not have outgoing transitions");
			}
		}
		return true;
	}

	public boolean validate_State_eventTransitions(State state) {

		return true;
	}

	public boolean validate_State_methodFlowExecutionState(State state) {

		return true;
	}

	public boolean validate_State_eventOkOnlyExecutionState(State state) {

		return true;
	}

	public boolean validate_State_exceptionEventsExecutionState(State state) {

		return true;
	}

	public boolean validate_State_oneOutcomingCustomState(State state) {

		return true;
	}

	public boolean validate_State_oneOutcomingNotesState(State state) {

		return true;
	}

	public boolean validate_State_formatNameState(State state) {
		if (state.getName().length() > 30) {
			operationsValidator.error(state, "Name of " + state.getName() + " is too long.");
		}

		char initial = state.getName().charAt(0);
		if (!(state.getName().startsWith("_") || Character.isJavaIdentifierStart(initial))) {
			operationsValidator.error(state, "Name of " + state.getName() + " starts with a incorrect letter.");
		}

		Flow flow = (Flow) state.eContainer();

		URI uri = flow.eResource().getURI();

		if (uri.isPlatformResource()) {
			List<ComponentBean> beans = flow.getBeans();

			String classbean;
			for (ComponentBean bean : beans) {
				classbean = bean.getName();
				if (classbean.equals(state.getName())) {
					operationsValidator.error(state, "Name of state " + state.getName() + " exists as bean");
				}
			}

		}

		for (int i = 1; i < state.getName().length(); i++) {
			char letter = state.getName().charAt(i);
			if (!Character.isJavaIdentifierPart(letter)) {
				operationsValidator.error(state, "Name of " + state.getName() + " contains incorrect character.");
				break;
			}

		}

		// Se crea un validacion nueva para que el nombre no coincida con ningun nombre de niguna clase del modulo.

		return true;
	}

}
