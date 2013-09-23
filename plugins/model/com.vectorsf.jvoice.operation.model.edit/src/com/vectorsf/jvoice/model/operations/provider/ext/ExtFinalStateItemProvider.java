package com.vectorsf.jvoice.model.operations.provider.ext;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.provider.FinalStateItemProvider;

public class ExtFinalStateItemProvider extends FinalStateItemProvider {

	public ExtFinalStateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public String getText(Object object) {
		String label = ((FinalState)object).getName();
		return label ;
	}
}
