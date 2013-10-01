package com.vectorsf.jvoice.prompt.model.voiceDsl.provider;

import org.eclipse.emf.common.notify.Adapter;

public class ExtVoiceDslItemProviderAdapterFactory extends VoiceDslItemProviderAdapterFactory {

	@Override
	public Adapter createMenuDslAdapter() {
		if (menuDslItemProvider == null) {
			menuDslItemProvider = new ExtMenuDslItemProvider(this);
		}

		return menuDslItemProvider;
	}

	@Override
	public Adapter createInputDslAdapter() {
		if (inputDslItemProvider == null) {
			inputDslItemProvider = new ExtInputDslItemProvider(this);
		}

		return inputDslItemProvider;
	}

	@Override
	public Adapter createPromptDslAdapter() {
		if (promptDslItemProvider == null) {
			promptDslItemProvider = new ExtPromptDslItemProvider(this);
		}

		return promptDslItemProvider;
	}
}
