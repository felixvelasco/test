package com.vectorsf.jvoice.core.validation;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;

public class TestValidator extends AbstractPolymorphicValidator {

	public boolean validate_Flow_oneInitialState(Flow flow, DiagnosticChain diagnostics) {
		int initialCount = 0;
		for (State state : flow.getStates()) {
			if (state instanceof InitialState) {
				initialCount++;
			}
		}
		if (initialCount == 0) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, EcoreUtil.getURI(flow).toPlatformString(true), -1,
					"No initial state found", new Object[] {}));
		} else if (initialCount > 1) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, EcoreUtil.getURI(flow).toPlatformString(true), -1,
					"Too many initial states found", new Object[] {}));
		}
		return initialCount == 1;
	}

	public boolean validate_Flow_someFinalState(Flow flow, DiagnosticChain diagnostics) {
		for (State state : flow.getStates()) {
			if (state instanceof FinalState) {
				return true;
			}
		}
		diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, EcoreUtil.getURI(flow).toPlatformString(true), -1,
				"No final state found", new Object[] {}));
		return false;
	}

	public boolean validate_State_incoming(State state, DiagnosticChain diagnostics) {
		if (state instanceof InitialState) {
			return true;
		}

		boolean valid = !state.getIncomingTransitions().isEmpty();
		if (!valid) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, EcoreUtil.getURI(state).toPlatformString(true), -1,
					"State " + state.getName() + " does not have incoming transitions", new Object[] {}));
		}

		return valid;
	}

}
