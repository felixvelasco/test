package com.vectorsf.jvoice.model.operations.provider.ext;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.provider.InitialStateItemProvider;

public class ExtInitialStateItemProvider extends InitialStateItemProvider {

	public ExtInitialStateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public String getText(Object object) {
		String label = ((InitialState)object).getName();
		return label ;
	}
}
