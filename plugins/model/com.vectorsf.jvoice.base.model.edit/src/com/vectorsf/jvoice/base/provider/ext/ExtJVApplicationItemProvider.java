package com.vectorsf.jvoice.base.provider.ext;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.base.provider.JVApplicationItemProvider;

public class ExtJVApplicationItemProvider extends JVApplicationItemProvider {

	public ExtJVApplicationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String label = ((JVProject) object).getName() + " application";
		return label;
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/JVProject.png");
	}
}