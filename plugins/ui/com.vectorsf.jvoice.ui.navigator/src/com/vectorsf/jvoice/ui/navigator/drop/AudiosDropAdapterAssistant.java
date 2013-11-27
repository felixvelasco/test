package com.vectorsf.jvoice.ui.navigator.drop;

public class AudiosDropAdapterAssistant extends FileCommonDropAdapterAssistant {
	public AudiosDropAdapterAssistant(String inType, String inDirBase) {
		super(inType, inDirBase);
	}

	public AudiosDropAdapterAssistant() {
		super("wav", "/src/main/resources/audios");
	}
}
