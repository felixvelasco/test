package com.vectorsf.jvoice.ui.diagram.properties.dialogs;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl;

public class ValidatorMenu implements ISelectionStatusValidator {

	@Override
	public IStatus validate(Object[] selection) {
		if (selection.length > 0) {
			if (selection[0] instanceof MenuDsl) {
				return Status.OK_STATUS;
			} else {
				return new Status(IStatus.ERROR,
						"com.vectorsf.jvoice.diagram.core", "Select a menu");
			}
		} else {
			return new Status(IStatus.ERROR,
					"com.vectorsf.jvoice.diagram.core", "Select a menu");
		}
	}
}
