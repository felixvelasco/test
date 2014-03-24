package com.vectorsf.jvoice.ui.wizard.create;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.URL;

import org.eclipse.core.runtime.Platform;

import com.google.inject.Injector;
import com.isb.bks.ivr.voice.dsl.services.VoiceDslGrammarAccess;
import com.isb.bks.ivr.voice.dsl.ui.internal.VoiceDslActivator;
import com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.ui.wizard.Activator;

public enum DefinitionHelper {

	INPUT(InputDsl.class, "basicInput", "input"), MENU(MenuDsl.class, "basicMenu", "menu"), OUTPUT(PromptDsl.class,
			"basicOutput", "output"), RECORD(RecordDsl.class, "basicRecord", "record"), TRANSFER(TransferDsl.class,
			"basicBlindTransfer", "blindTransfer");

	Class<? extends VoiceDsl> clazz;
	String resName;
	String prefix;

	private static VoiceDslGrammarAccess access;
	private static String STATIC_DSLS_LOCATION = "res/voiceDsls/";
	private static String STATIC_DSLS_EXT = ".voiceDsl";

	static {
		Injector injector = VoiceDslActivator.getInstance().getInjector(
				VoiceDslActivator.COM_ISB_BKS_IVR_VOICE_DSL_VOICEDSL);

		access = injector.getInstance(VoiceDslGrammarAccess.class);
	}

	private DefinitionHelper(Class<? extends VoiceDsl> clazz, String resName, String prefix) {
		this.clazz = clazz;
		this.resName = resName;
		this.prefix = prefix;

	}

	public Class<? extends VoiceDsl> getDefClass() {
		return clazz;
	}

	public InputStream getInputStreamFromFile(String elementName) {
		URL resUrl;
		InputStream resIs = null;
		resUrl = Platform.getBundle(Activator.PLUGIN_ID).getResource(STATIC_DSLS_LOCATION + resName + STATIC_DSLS_EXT);
		try {
			if (resUrl != null) {
				resIs = resUrl.openConnection().getInputStream();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String escapedName = access.findKeywords(elementName).isEmpty() ? elementName : "^" + elementName;
		String contents = prefix + " " + escapedName + "\n\n";

		InputStream source = new ByteArrayInputStream(contents.getBytes());
		if (resIs != null) {
			source = new SequenceInputStream(source, resIs);
		}

		return source;
	}
}