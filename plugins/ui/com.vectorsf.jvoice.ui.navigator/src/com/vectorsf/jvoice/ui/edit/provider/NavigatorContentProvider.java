package com.vectorsf.jvoice.ui.edit.provider;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

public class NavigatorContentProvider extends AdapterFactoryContentProvider {

	public NavigatorContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}
}
