package com.vectorsf.jvoice.core.validation.operations;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.Flow;

public class CustomStateValidator {
	private OperationsValidator operationsValidator;

	public CustomStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_CustomState_oneOutcomingCustomState(CustomState state) {

		if (state.getOutgoingTransitions().size() > 1) {
			operationsValidator.error(state, "State " + state.getName() + " has more than one outgoing transition");
		}

		return true;
	}

	public boolean validate_CustomState_checkPathCustomState(CustomState state) {

		if (state.getPath().isEmpty()) {
			operationsValidator.error(state, "State " + state.getName() + " doesn't have a referenced jsp");
		}

		Flow flujo = (Flow) state.eContainer();
		URI uri = state.eContainer().eResource().getURI();
		File rawFile = null;
		if (uri.isPlatformResource()) {
			IPath rawPath = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true))
					.getRawLocation();

			rawFile = rawPath.toFile();
			File parent = rawFile.getParentFile();
			File resources = new File(parent, flujo.getName() + ".resources");
			File jsp = new File(resources, state.getPath());
			if (!jsp.exists()) {
				operationsValidator.error(state, state.getPath() + " not found in " + resources.getPath());
			}
		}

		return true;
	}
}
