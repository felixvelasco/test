package com.vectorsf.jvoice.prompt.model.voiceDsl.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class ExtPromptDslItemProvider extends PromptDslItemProvider {

	public ExtPromptDslItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/VoiceDsl.png");
	}

	@Override
	public String getText(Object object) {
		return ((VoiceDsl) object).getName();
	}

}
