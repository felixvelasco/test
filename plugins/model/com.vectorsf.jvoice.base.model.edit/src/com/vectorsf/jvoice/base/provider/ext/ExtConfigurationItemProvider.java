package com.vectorsf.jvoice.base.provider.ext;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.model.base.Configuration;
import com.vectorsf.jvoice.model.base.provider.ConfigurationItemProvider;

public class ExtConfigurationItemProvider extends ConfigurationItemProvider {

	public ExtConfigurationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String label = ((Configuration)object).getName();
		return label;
	}
}
