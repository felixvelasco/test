package com.vectorsf.jvoice.base.provider.ext;

import org.eclipse.emf.common.notify.Adapter;

import com.vectorsf.jvoice.model.base.provider.BaseItemProviderAdapterFactory;
import com.vectorsf.jvoice.model.base.provider.ConfigurationItemProvider;
import com.vectorsf.jvoice.model.base.provider.JVPackageItemProvider;
import com.vectorsf.jvoice.model.base.provider.NamedElementItemProvider;

public class ExtBaseItemProviderAdapterFactory extends BaseItemProviderAdapterFactory {

	@Override
	public Adapter createJVProjectAdapter() {
		if (jvProjectItemProvider == null) {
			jvProjectItemProvider = new ExtJVProjectItemProvider(this);
		}

		return jvProjectItemProvider;
	}

	@Override
	public Adapter createJVPackageAdapter() {
		if (jvPackageItemProvider == null) {
			jvPackageItemProvider = new JVPackageItemProvider(this);
		}

		return jvPackageItemProvider;
	}

	@Override
	public Adapter createNamedElementAdapter() {
		if (namedElementItemProvider == null) {
			namedElementItemProvider = new NamedElementItemProvider(this);
		}

		return namedElementItemProvider;
	}

	@Override
	public Adapter createConfigurationAdapter() {
		if (configurationItemProvider == null) {
			configurationItemProvider = new ConfigurationItemProvider(this);
		}

		return configurationItemProvider;
	}

}
