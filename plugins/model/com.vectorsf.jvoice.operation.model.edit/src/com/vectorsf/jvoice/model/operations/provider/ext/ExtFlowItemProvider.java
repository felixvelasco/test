package com.vectorsf.jvoice.model.operations.provider.ext;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.provider.FlowItemProvider;

public class ExtFlowItemProvider extends FlowItemProvider {

	public ExtFlowItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public String getText(Object object) {
		String label = ((Flow)object).getName();
		return label ;
	}
}
