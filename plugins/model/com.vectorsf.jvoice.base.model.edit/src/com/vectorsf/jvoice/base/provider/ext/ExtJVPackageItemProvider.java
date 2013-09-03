package com.vectorsf.jvoice.base.provider.ext;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.provider.JVPackageItemProvider;;

public class ExtJVPackageItemProvider extends JVPackageItemProvider {

	public ExtJVPackageItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String label = ((JVPackage)object).getName();
		return label;
	}
}
