package com.vectorsf.jvoice.base.provider.ext;

import org.eclipse.emf.common.notify.Adapter;

import com.vectorsf.jvoice.model.base.provider.BaseItemProviderAdapterFactory;

public class ExtBaseItemProviderAdapterFactory extends BaseItemProviderAdapterFactory {

	@Override
	public Adapter createJVModuleAdapter() {
		if (jvModuleItemProvider == null) {
			jvModuleItemProvider = new ExtJVModuleItemProvider(this);
		}

		return jvModuleItemProvider;
	}

	@Override
	public Adapter createJVApplicationAdapter() {
		if (jvApplicationItemProvider == null) {
			jvApplicationItemProvider = new ExtJVApplicationItemProvider(this);
		}

		return jvApplicationItemProvider;
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
