package com.vectorsf.jvoice.core.validation.operations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import com.vectorsf.jvoice.core.operation.helper.FlowService;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.Transition;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Output;

public class MenuStateValidator {
	private OperationsValidator operationsValidator;
	private final String PATH = "src/main/java";

	public MenuStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_MenuState_checkMenuOptions(MenuState state) {
		List<String> transitions = new ArrayList<String>();
		for (Transition t : state.getOutgoingTransitions()) {
			transitions.add(t.getEventName());
		}

		if (state.isTextual()) {
			if (state.getLocution() != null) {
				for (Output o : state.getLocution().getOutputs().getOutput()) {
					if (!transitions.contains(o.getName())) {
						operationsValidator.error(state, "Missing transition for option '" + o.getName()
								+ "' in state '" + state.getName() + "'.");
					}
				}
			} else {
				operationsValidator.error(state, "Definition State " + state.getName() + " has not a dsl associated.");
			}
		}

		return true;
	}

	public boolean validate_MenuState_checkMenuMethod(MenuState state) {

		if (!state.isTextual()) {

			Flow flow = (Flow) state.eContainer();

			boolean exist = false;
			boolean returnOk = false;
			try {
				IType helperType = FlowService.getHelperType(flow);
				for (IMethod method : helperType.getMethods()) {
					String declaredReturnType = method.getReturnType()
							.substring(1, method.getReturnType().length() - 1);
					String nameMethod = method.getElementName();
					// Vamos a comprobar que el resultado metodo existe y que el tipo devuelto es el correcto.
					if (nameMethod.equals(state.getMethodName())) {
						exist = true;
						if (declaredReturnType.equals("Menu")) {
							returnOk = true;
							break;

						}
					}
				}
			} catch (JavaModelException e1) {
				e1.printStackTrace();
			}

			if (!exist) {
				operationsValidator.error(state,
						"Missing method '" + state.getMethodName() + "' in state '" + state.getName() + "'.");
			}

			if (!returnOk) {
				operationsValidator.error(state, "The return object of of method '" + state.getMethodName()
						+ "' in state '" + state.getName() + "' is not correct.");
			}

		} else {
			operationsValidator.error(state, "The state '" + state.getName() + "' has no associated Method.'");
		}

		return true;
	}

}
