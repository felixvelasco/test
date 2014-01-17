package com.vectorsf.jvoice.prompt.model.voiceDsl.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class ExtInputDslItemProvider extends InputDslItemProvider {

	public ExtInputDslItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/icon_nav_input.png");
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
