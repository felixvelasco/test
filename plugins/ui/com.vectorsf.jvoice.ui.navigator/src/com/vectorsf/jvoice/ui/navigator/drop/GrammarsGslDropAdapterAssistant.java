package com.vectorsf.jvoice.ui.navigator.drop;

public class GrammarsGslDropAdapterAssistant extends
		FileCommonDropAdapterAssistant {
	public GrammarsGslDropAdapterAssistant(String inType, String inDirBase) {
		super(inType, inDirBase);
	}

	public GrammarsGslDropAdapterAssistant() {
		super("gsl", "/src/main/resources/grammars");
	}
}
