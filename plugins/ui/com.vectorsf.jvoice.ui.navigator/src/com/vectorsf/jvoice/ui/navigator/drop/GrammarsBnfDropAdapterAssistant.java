package com.vectorsf.jvoice.ui.navigator.drop;

public class GrammarsBnfDropAdapterAssistant extends
		FileCommonDropAdapterAssistant {
	public GrammarsBnfDropAdapterAssistant(String inType, String inDirBase) {
		super(inType, inDirBase);
	}

	public GrammarsBnfDropAdapterAssistant() {
		super("bnf", "/src/main/resources/grammars");
	}
}
