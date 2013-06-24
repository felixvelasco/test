/*
* generated by Xtext
*/
package com.isb.bks.ivr.voice.dsl.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import com.isb.bks.ivr.voice.dsl.services.VoiceDslGrammarAccess;

public class VoiceDslParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private VoiceDslGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected com.isb.bks.ivr.voice.dsl.parser.antlr.internal.InternalVoiceDslParser createParser(XtextTokenStream stream) {
		return new com.isb.bks.ivr.voice.dsl.parser.antlr.internal.InternalVoiceDslParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "InputElement";
	}
	
	public VoiceDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(VoiceDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
