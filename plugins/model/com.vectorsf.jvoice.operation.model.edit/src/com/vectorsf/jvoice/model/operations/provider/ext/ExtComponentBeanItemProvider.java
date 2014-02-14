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
		ComponentBean cBean = (ComponentBean) object;
		if (cBean.isPrototype()) {
			return getResourceLocator().getImage("full/obj16/icon_nav_bean.png");
		} else {
			return getResourceLocator().getImage("full/obj16/icon_nav_externalbean.png");
		}
	}

	@Override
	public String getText(Object object) {
		ComponentBean cBean = (ComponentBean) object;
		if (cBean.isPrototype()) {
			return cBean.getName() + " - " + cBean.getNameBean();
		} else {
			return cBean.getNameBean();
		}
	}
}
