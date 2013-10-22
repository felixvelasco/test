package com.vectorsf.jvoice.ui.diagram.properties.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.vectorsf.jvoice.model.operations.Case;

public class CaseLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {}

	@Override
	public void dispose() {}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
	    Case caso = (Case) element;
	    switch (columnIndex) {
	    case 0:
	      return caso.getCondition();
	    case 1:
	      return caso.getEventName();
	    }
	    return null;
	}

}
