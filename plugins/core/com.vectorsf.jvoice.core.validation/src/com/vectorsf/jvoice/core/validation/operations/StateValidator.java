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
				operationsValidator.error(state, "State '" + state.getName() + "' does not have outgoing transitions");
			}
		}
		return true;
	}

	public boolean validate_State_nameUnique(State state) {

		Flow flow = (Flow) state.eContainer();

		for (State other : flow.getStates()) {
			if (other != state && state.getName().equals(other.getName())) {
				operationsValidator.error(state, "Duplicated state name '" + state.getName() + "'");
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

		char initial = state.getName().charAt(0);
		if (!(state.getName().startsWith("_") || Character.isJavaIdentifierStart(initial))) {
			operationsValidator.error(state, "State '" + state.getName() + "' starts with an invalid character.");
		}

		Flow flow = (Flow) state.eContainer();

		URI uri = flow.eResource().getURI();

		if (uri.isPlatformResource()) {
			List<ComponentBean> beans = flow.getBeans();

			String classbean;
			for (ComponentBean bean : beans) {
				classbean = bean.getName();
				if (classbean.equals(state.getName())) {
					operationsValidator.error(state, "State '" + state.getName()
							+ "' has the same name than an scoped bean.");
				}
			}

		}

		for (int i = 1; i < state.getName().length(); i++) {
			char letter = state.getName().charAt(i);
			if (!Character.isJavaIdentifierPart(letter)) {
				operationsValidator.error(state, "State '" + state.getName() + "' contains the invalid character '"
						+ letter + "'.");
				break;
			}

		}

		// Se crea un validacion nueva para que el nombre no coincida con ningun nombre de niguna clase del modulo.

		return true;
	}

}
