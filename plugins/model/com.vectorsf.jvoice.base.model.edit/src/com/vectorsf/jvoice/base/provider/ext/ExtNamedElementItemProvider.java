package com.vectorsf.jvoice.base.provider.ext;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.model.base.NamedElement;
import com.vectorsf.jvoice.model.base.provider.NamedElementItemProvider;

public class ExtNamedElementItemProvider extends NamedElementItemProvider {
	public ExtNamedElementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String label = ((NamedElement)object).getName();
		return label;
	}
}
