package com.vectorsf.jvoice.ui.edit.validators;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl;

public class ValidatorTransfer implements ISelectionStatusValidator {

	@Override
	public IStatus validate(Object[] selection) {
		if (selection.length > 0) {
			if (selection[0] instanceof TransferDsl) {
				return Status.OK_STATUS;
			} else {
				return new Status(IStatus.ERROR,
						"com.vectorsf.jvoice.diagram.core",
						"Select an transfer");
			}

		} else {
			return new Status(IStatus.ERROR,
					"com.vectorsf.jvoice.diagram.core", "Select an transfer");
		}
	}

}
