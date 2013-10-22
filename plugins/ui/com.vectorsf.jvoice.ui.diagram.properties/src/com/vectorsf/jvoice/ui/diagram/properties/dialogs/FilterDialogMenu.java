package com.vectorsf.jvoice.ui.diagram.properties.dialogs;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl;

public class FilterDialogMenu extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof JVProject
				|| element instanceof JVPackage) {
			return true;
		}
		if (element instanceof MenuDsl) {
			return true;
		}

		return false;
	}
}
