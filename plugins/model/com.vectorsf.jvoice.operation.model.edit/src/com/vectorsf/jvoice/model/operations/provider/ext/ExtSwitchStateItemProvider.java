package com.vectorsf.jvoice.model.operations.provider.ext;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.provider.SwitchStateItemProvider;

public class ExtSwitchStateItemProvider extends SwitchStateItemProvider {

	public ExtSwitchStateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public String getText(Object object) {
		String label = ((SwitchState)object).getName();
		return label ;
	}
}
