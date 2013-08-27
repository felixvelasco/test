package com.vectorsf.jvoice.base.provider.ext;

import org.eclipse.emf.common.notify.Adapter;

import com.vectorsf.jvoice.base.provider.BaseItemProviderAdapterFactory;

public class ExtBaseItemProviderAdapterFactory extends
		BaseItemProviderAdapterFactory {

	@Override
	public Adapter createJVProjectAdapter() {
		if (jvProjectItemProvider == null) {
			jvProjectItemProvider = new ExtJVProjectItemProvider(this);
		}

		return jvProjectItemProvider;
	}
}
