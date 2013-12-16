package com.vectorsf.jvoice.ui.edit.provider;

public class GrammarsContentProvider extends FileContentProvider {

	public GrammarsContentProvider() {
		super("/src/main/resources/grammars");
		// TODO Auto-generated constructor stub
	}

	public GrammarsContentProvider(String inPath) {
		super(inPath);
		// TODO Auto-generated constructor stub
	}

}
