package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVProject;

public class JVBeanContentProvider extends AdapterFactoryContentProvider {

	public JVBeanContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object[] getElements(Object object) {
		@SuppressWarnings("unchecked")
		List<JVProject> projects = (List<JVProject>) object;

		Object[] os = projects.toArray();

		return os;

	}

	@Override
	public boolean hasChildren(Object object) {
		if (object instanceof JVBean) {
			return false;
		}
		return super.hasChildren(object);
	}

}
