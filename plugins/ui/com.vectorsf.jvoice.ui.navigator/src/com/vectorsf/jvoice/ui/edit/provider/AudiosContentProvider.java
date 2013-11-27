package com.vectorsf.jvoice.ui.edit.provider;

public class AudiosContentProvider extends FileContentProvider {

	public AudiosContentProvider() {
		super("/src/main/resources/audios");
		// TODO Auto-generated constructor stub
	}

	public AudiosContentProvider(String inPath) {
		super(inPath);
		// TODO Auto-generated constructor stub
	}

}
