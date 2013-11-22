package com.vectorsf.jvoice.model.operations.provider.ext;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.provider.ComponentBeanItemProvider;

public class ExtComponentBeanItemProvider extends ComponentBeanItemProvider {

	public ExtComponentBeanItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/icon_nav_bean");
	}

	@Override
	public String getText(Object object) {
		ComponentBean cBean = (ComponentBean) object;
		return cBean.getName() + " - " + cBean.getNameBean();
	}
}
