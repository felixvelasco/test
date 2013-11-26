package com.vectorsf.jvoice.ui.edit.validators;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

public class ValidatorExecuteBean implements ISelectionStatusValidator {

	@Override
	public IStatus validate(Object[] selection) {
		if (selection.length > 0) {
			if (!(selection[0] instanceof IMethod)) {
				return new Status(IStatus.ERROR,
						"com.vectorsf.jvoice.ui.navigator", "Select a method");
			} else {
				return Status.OK_STATUS;
			}
		} else {
			return new Status(IStatus.ERROR,
					"com.vectorsf.jvoice.ui.navigator", "Select a method");
		}
	}
}
