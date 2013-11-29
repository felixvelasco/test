package com.vectorsf.jvoice.ui.navigator.drop;

public class WSDLDropAdapterAssistant extends FileCommonDropAdapterAssistant {
	public WSDLDropAdapterAssistant(String inType, String inDirBase) {
		super(inType, inDirBase);
	}

	public WSDLDropAdapterAssistant() {
		super("wsdl", "/src/main/resources/META-INF/wsdl");
	}
}
