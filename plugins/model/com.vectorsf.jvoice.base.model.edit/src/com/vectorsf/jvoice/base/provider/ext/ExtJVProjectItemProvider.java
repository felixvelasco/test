package com.vectorsf.jvoice.base.provider.ext;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.base.provider.JVProjectItemProvider;;

public class ExtJVProjectItemProvider extends JVProjectItemProvider {

	public ExtJVProjectItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String label = ((JVProject)object).getName();
		return label;
	}
}
