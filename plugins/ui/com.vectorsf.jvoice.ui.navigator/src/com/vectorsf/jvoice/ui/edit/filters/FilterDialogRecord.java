package com.vectorsf.jvoice.ui.edit.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl;

public class FilterDialogRecord extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof JVProject || element instanceof JVPackage) {
			return true;
		}
		if (element instanceof RecordDsl) {
			return true;
		}

		return false;
	}

}
