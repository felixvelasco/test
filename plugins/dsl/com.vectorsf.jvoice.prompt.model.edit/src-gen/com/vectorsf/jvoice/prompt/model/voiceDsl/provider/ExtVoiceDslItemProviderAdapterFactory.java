package com.vectorsf.jvoice.prompt.model.voiceDsl.provider;

import org.eclipse.emf.common.notify.Adapter;

public class ExtVoiceDslItemProviderAdapterFactory extends VoiceDslItemProviderAdapterFactory {

	@Override
	public Adapter createVoiceDslAdapter() {
		if (voiceDslItemProvider == null) {
			voiceDslItemProvider = new ExtVoiceDslItemProvider(this);
		}

		return voiceDslItemProvider;
	}

}
