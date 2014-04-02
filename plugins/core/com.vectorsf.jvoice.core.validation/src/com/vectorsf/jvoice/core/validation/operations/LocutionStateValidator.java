package com.vectorsf.jvoice.core.validation.operations;

import java.io.File;

import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import com.vectorsf.jvoice.core.operation.helper.FlowService;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.PromptState;
import com.vectorsf.jvoice.model.operations.RecordState;
import com.vectorsf.jvoice.model.operations.TransferState;

public class LocutionStateValidator {

	private OperationsValidator operationsValidator;

	public LocutionStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_LocutionState_checkGrammars(LocutionState lstate) {

		return true;
	}

	public boolean validate_LocutionState_checkOutcomingsLocution(LocutionState lstate) {

		return true;
	}

	public boolean validate_LocutionState_checkDslsLocutionState(LocutionState lstate) {
		if (lstate.isTextual()) {
			if (lstate.getLocution() == null) {
				operationsValidator
						.error(lstate, "Definition State " + lstate.getName() + " has not a dsl associated.");
			} else {
				File rawFile = ValidatorUtils.getFile(lstate);
				if (rawFile != null) {
					String name = rawFile.getName().substring(0, rawFile.getName().indexOf("."));
					File file = new File(rawFile.getParent(), name + ".resources/" + lstate.getLocution().getName()
							+ ".voiceDsl");

					if (!file.exists()) {
						operationsValidator.error(lstate, "Locution " + lstate.getLocution() + " does not exist.");
					}
				}

			}
		}

		return true;
	}

	// Comprobación para los estados programáticos del metodo y su salida.
	public boolean validate_LocutionState_checkMethodLocution(LocutionState lstate) {

		if (!lstate.isTextual()) {

			Flow flow = (Flow) lstate.eContainer();

			boolean exist = false;
			boolean returnOk = false;
			try {
				IType helperType = FlowService.getHelperType(flow);
				for (IMethod method : helperType.getMethods()) {
					String declaredReturnType = method.getReturnType()
							.substring(1, method.getReturnType().length() - 1);
					String nameMethod = method.getElementName();
					// Vamos a comprobar que el resultado metodo existe y que el tipo devuelto es el correcto.
					if (nameMethod.equals(lstate.getMethodName())) {
						exist = true;
						if (declaredReturnType.equals(getTypeLocution(lstate))) {
							returnOk = true;
							break;

						}
					}
				}
			} catch (JavaModelException e1) {
				e1.printStackTrace();
			}

			if (!exist) {
				operationsValidator.error(lstate,
						"Missing method '" + lstate.getMethodName() + "' in state '" + lstate.getName() + "'.");
			}

			if (!returnOk) {
				operationsValidator.error(lstate, "The return object of method '" + lstate.getMethodName()
						+ "' in state '" + lstate.getName() + "' is not correct.");
			}

		} else {
			operationsValidator.error(lstate, "The state '" + lstate.getName() + "' has no associated Method.'");
		}

		return true;
	}

	private String getTypeLocution(LocutionState lstate) {
		if (lstate instanceof InputState) {
			return "Input";
		} else if (lstate instanceof PromptState) {
			return "Output";
		} else if (lstate instanceof TransferState) {
			return "Transfer";
		} else if (lstate instanceof RecordState) {
			return "Record";
		}
		return null;
	}

}
