package com.vectorsf.jvoice.voice.dsl.tests;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.xpect.runner.XpectRunner;
import org.xpect.xtext.lib.tests.XtextTests;

import com.isb.bks.ivr.voice.dsl.VoiceDslStandaloneSetup;

@RunWith(XpectRunner.class)
public class MyXtextTest extends XtextTests {

	@BeforeClass
	public static void setup() {
		VoiceDslStandaloneSetup.doSetup();
	}
}