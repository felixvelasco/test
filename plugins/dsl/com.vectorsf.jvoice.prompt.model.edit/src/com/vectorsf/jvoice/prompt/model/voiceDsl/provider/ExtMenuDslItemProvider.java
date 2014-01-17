package com.vectorsf.jvoice.prompt.model.voiceDsl.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class ExtMenuDslItemProvider extends MenuDslItemProvider {

	public ExtMenuDslItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/icon_nav_menu.png");
	}

	@Override
	public String getText(Object object) {
		return ((VoiceDsl) object).getName();
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			childrenFeatures = new ArrayList<>();
		}
		return childrenFeatures;
	}
}
