package com.vectorsf.jvoice.base.provider.ext;

import org.eclipse.emf.common.notify.Adapter;

import com.vectorsf.jvoice.model.base.provider.BaseItemProviderAdapterFactory;
import com.vectorsf.jvoice.model.base.provider.JVModuleItemProvider;

public class ExtBaseItemProviderAdapterFactory extends
		BaseItemProviderAdapterFactory {

	@Override
	public Adapter createJVProjectAdapter() {
		Adapter jvModuleItemProvider = null;
		if (jvModuleItemProvider == null) {
			jvModuleItemProvider = new JVModuleItemProvider(this);
		}
		// if (jvApplicationItemProvider == null) {
		// jvApplicationItemProvider = new JVApplicationItemProvider(this);
		// }

		return jvModuleItemProvider;
	}

	@Override
	public Adapter createJVPackageAdapter() {
		if (jvPackageItemProvider == null) {
			jvPackageItemProvider = new ExtJVPackageItemProvider(this);
		}

		return jvPackageItemProvider;
	}

	@Override
	public Adapter createNamedElementAdapter() {
		if (namedElementItemProvider == null) {
			namedElementItemProvider = new ExtNamedElementItemProvider(this);
		}

		return namedElementItemProvider;
	}

	@Override
	public Adapter createConfigurationAdapter() {
		if (configurationItemProvider == null) {
			configurationItemProvider = new ExtConfigurationItemProvider(this);
		}

		return configurationItemProvider;
	}

}
