package com.vectorsf.jvoice.ui.diagram.properties.dialogs;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl;

public class ValidatorInput implements ISelectionStatusValidator {

	@Override
	public IStatus validate(Object[] selection) {
		if (selection.length > 0) {
			if (selection[0] instanceof InputDsl) {
				return Status.OK_STATUS;
			} else {
				return new Status(IStatus.ERROR,
						"com.vectorsf.jvoice.diagram.core", "Select an input");
			}

		} else {
			return new Status(IStatus.ERROR,
					"com.vectorsf.jvoice.diagram.core", "Select an input");
		}
	}
}
