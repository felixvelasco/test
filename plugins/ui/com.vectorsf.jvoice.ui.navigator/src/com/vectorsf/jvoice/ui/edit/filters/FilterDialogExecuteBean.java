package com.vectorsf.jvoice.ui.edit.filters;

import org.eclipse.jdt.core.IMethod;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.vectorsf.jvoice.model.operations.ComponentBean;

public class FilterDialogExecuteBean extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof ComponentBean || element instanceof IMethod) {
			return true;
		}
		return false;
	}

}
