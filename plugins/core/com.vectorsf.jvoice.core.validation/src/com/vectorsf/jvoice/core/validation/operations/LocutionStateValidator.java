package com.vectorsf.jvoice.core.validation.operations;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import com.vectorsf.jvoice.model.operations.LocutionState;

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
		if (lstate.getLocution() == null) {
			operationsValidator.error(lstate, "Definition State " + lstate.getName() + " has not a dsl associated.");
		} else {
			File rawFile = getFileLocution(lstate);
			if (rawFile != null) {
				String name = rawFile.getName().substring(0, rawFile.getName().indexOf("."));
				File file = new File(rawFile.getParent(), name + ".resources/" + lstate.getLocution().getName()
						+ ".voiceDsl");

				if (!file.exists()) {
					operationsValidator.error(lstate, "Locution " + lstate.getLocution() + " does not exist.");
				}
			}

		}

		return true;
	}

	/**
	 * @param lstate
	 * @return
	 */
	protected File getFileLocution(LocutionState lstate) {
		URI uri = lstate.eResource().getURI();

		File rawFile = null;
		if (uri.isPlatformResource()) {
			IPath rawPath = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true))
					.getRawLocation();

			rawFile = rawPath.toFile();
		}
		return rawFile;
	}

}
