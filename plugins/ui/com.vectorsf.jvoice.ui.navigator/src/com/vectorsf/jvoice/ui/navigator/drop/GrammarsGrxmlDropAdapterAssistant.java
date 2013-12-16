package com.vectorsf.jvoice.ui.navigator.drop;

public class GrammarsGrxmlDropAdapterAssistant extends
		FileCommonDropAdapterAssistant {
	public GrammarsGrxmlDropAdapterAssistant(String inType, String inDirBase) {
		super(inType, inDirBase);
	}

	public GrammarsGrxmlDropAdapterAssistant() {
		super("grxml", "/src/main/resources/grammars");
	}
}
