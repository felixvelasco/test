package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.navigator.CommonNavigator;

import com.vectorsf.jvoice.base.model.service.BaseModel;

public class IVRNavigator extends CommonNavigator {

	@Override
	protected Object getInitialInput() {
		return BaseModel.getInstance().getModel();
	}

	@Override
	public void selectReveal(ISelection selection) {
		super.selectReveal(selection);
	}
}
