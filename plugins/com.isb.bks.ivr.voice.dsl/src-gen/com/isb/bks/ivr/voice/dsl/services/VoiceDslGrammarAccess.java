/*
* generated by Xtext
*/
package com.isb.bks.ivr.voice.dsl.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class VoiceDslGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class InputElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InputElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cConfigurationAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cConfigurationConfigurationParserRuleCall_0_0 = (RuleCall)cConfigurationAssignment_0.eContents().get(0);
		private final Assignment cGrammaticsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cGrammaticsGrammarParserRuleCall_1_0 = (RuleCall)cGrammaticsAssignment_1.eContents().get(0);
		private final Assignment cAudiosAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cAudiosAudiosParserRuleCall_2_0 = (RuleCall)cAudiosAssignment_2.eContents().get(0);
		
		//InputElement:
		//	configuration=Configuration grammatics=Grammar? audios=Audios?;
		public ParserRule getRule() { return rule; }

		//configuration=Configuration grammatics=Grammar? audios=Audios?
		public Group getGroup() { return cGroup; }

		//configuration=Configuration
		public Assignment getConfigurationAssignment_0() { return cConfigurationAssignment_0; }

		//Configuration
		public RuleCall getConfigurationConfigurationParserRuleCall_0_0() { return cConfigurationConfigurationParserRuleCall_0_0; }

		//grammatics=Grammar?
		public Assignment getGrammaticsAssignment_1() { return cGrammaticsAssignment_1; }

		//Grammar
		public RuleCall getGrammaticsGrammarParserRuleCall_1_0() { return cGrammaticsGrammarParserRuleCall_1_0; }

		//audios=Audios?
		public Assignment getAudiosAssignment_2() { return cAudiosAssignment_2; }

		//Audios
		public RuleCall getAudiosAudiosParserRuleCall_2_0() { return cAudiosAudiosParserRuleCall_2_0; }
	}

	public class GrammarElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Grammar");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cGrammarKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cModeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cModeAlternatives_1_0 = (Alternatives)cModeAssignment_1.eContents().get(0);
		private final Keyword cModeVoiceKeyword_1_0_0 = (Keyword)cModeAlternatives_1_0.eContents().get(0);
		private final Keyword cModeDtmfKeyword_1_0_1 = (Keyword)cModeAlternatives_1_0.eContents().get(1);
		private final Assignment cBuiltinAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cBuiltinBuiltinKeyword_2_0 = (Keyword)cBuiltinAssignment_2.eContents().get(0);
		private final Assignment cSrcAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cSrcSTRINGTerminalRuleCall_3_0 = (RuleCall)cSrcAssignment_3.eContents().get(0);
		
		//Grammar:
		//	"grammar" mode=("voice" | "dtmf") builtin?="builtin"? src=STRING;
		public ParserRule getRule() { return rule; }

		//"grammar" mode=("voice" | "dtmf") builtin?="builtin"? src=STRING
		public Group getGroup() { return cGroup; }

		//"grammar"
		public Keyword getGrammarKeyword_0() { return cGrammarKeyword_0; }

		//mode=("voice" | "dtmf")
		public Assignment getModeAssignment_1() { return cModeAssignment_1; }

		//"voice" | "dtmf"
		public Alternatives getModeAlternatives_1_0() { return cModeAlternatives_1_0; }

		//"voice"
		public Keyword getModeVoiceKeyword_1_0_0() { return cModeVoiceKeyword_1_0_0; }

		//"dtmf"
		public Keyword getModeDtmfKeyword_1_0_1() { return cModeDtmfKeyword_1_0_1; }

		//builtin?="builtin"?
		public Assignment getBuiltinAssignment_2() { return cBuiltinAssignment_2; }

		//"builtin"
		public Keyword getBuiltinBuiltinKeyword_2_0() { return cBuiltinBuiltinKeyword_2_0; }

		//src=STRING
		public Assignment getSrcAssignment_3() { return cSrcAssignment_3; }

		//STRING
		public RuleCall getSrcSTRINGTerminalRuleCall_3_0() { return cSrcSTRINGTerminalRuleCall_3_0; }
	}

	public class ConfigurationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Configuration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInputnameKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cMaxNoInputKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cMaxNoInputAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cMaxNoInputINTTerminalRuleCall_2_1_0 = (RuleCall)cMaxNoInputAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cMaxNoMatchKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cMaxNoMAtchAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cMaxNoMAtchINTTerminalRuleCall_3_1_0 = (RuleCall)cMaxNoMAtchAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cMaxAttemptsKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cMaxAttemptsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cMaxAttemptsINTTerminalRuleCall_4_1_0 = (RuleCall)cMaxAttemptsAssignment_4_1.eContents().get(0);
		
		//Configuration:
		//	"inputname" name=ID ("maxNoInput" maxNoInput=INT)? ("maxNoMatch" maxNoMAtch=INT)? ("maxAttempts" maxAttempts=INT)?;
		public ParserRule getRule() { return rule; }

		//"inputname" name=ID ("maxNoInput" maxNoInput=INT)? ("maxNoMatch" maxNoMAtch=INT)? ("maxAttempts" maxAttempts=INT)?
		public Group getGroup() { return cGroup; }

		//"inputname"
		public Keyword getInputnameKeyword_0() { return cInputnameKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//("maxNoInput" maxNoInput=INT)?
		public Group getGroup_2() { return cGroup_2; }

		//"maxNoInput"
		public Keyword getMaxNoInputKeyword_2_0() { return cMaxNoInputKeyword_2_0; }

		//maxNoInput=INT
		public Assignment getMaxNoInputAssignment_2_1() { return cMaxNoInputAssignment_2_1; }

		//INT
		public RuleCall getMaxNoInputINTTerminalRuleCall_2_1_0() { return cMaxNoInputINTTerminalRuleCall_2_1_0; }

		//("maxNoMatch" maxNoMAtch=INT)?
		public Group getGroup_3() { return cGroup_3; }

		//"maxNoMatch"
		public Keyword getMaxNoMatchKeyword_3_0() { return cMaxNoMatchKeyword_3_0; }

		//maxNoMAtch=INT
		public Assignment getMaxNoMAtchAssignment_3_1() { return cMaxNoMAtchAssignment_3_1; }

		//INT
		public RuleCall getMaxNoMAtchINTTerminalRuleCall_3_1_0() { return cMaxNoMAtchINTTerminalRuleCall_3_1_0; }

		//("maxAttempts" maxAttempts=INT)?
		public Group getGroup_4() { return cGroup_4; }

		//"maxAttempts"
		public Keyword getMaxAttemptsKeyword_4_0() { return cMaxAttemptsKeyword_4_0; }

		//maxAttempts=INT
		public Assignment getMaxAttemptsAssignment_4_1() { return cMaxAttemptsAssignment_4_1; }

		//INT
		public RuleCall getMaxAttemptsINTTerminalRuleCall_4_1_0() { return cMaxAttemptsINTTerminalRuleCall_4_1_0; }
	}

	public class AudiosElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Audios");
		private final UnorderedGroup cUnorderedGroup = (UnorderedGroup)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cUnorderedGroup.eContents().get(0);
		private final Keyword cAudiosKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Assignment cInitialAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cInitialInitialParserRuleCall_0_2_0 = (RuleCall)cInitialAssignment_0_2.eContents().get(0);
		private final Assignment cNoMatchAssignment_1 = (Assignment)cUnorderedGroup.eContents().get(1);
		private final RuleCall cNoMatchNoMatchParserRuleCall_1_0 = (RuleCall)cNoMatchAssignment_1.eContents().get(0);
		private final Assignment cNoInputAssignment_2 = (Assignment)cUnorderedGroup.eContents().get(2);
		private final RuleCall cNoInputNoInputParserRuleCall_2_0 = (RuleCall)cNoInputAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cUnorderedGroup.eContents().get(3);
		private final Assignment cMatchAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cMatchMatchParserRuleCall_3_0_0 = (RuleCall)cMatchAssignment_3_0.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		
		//Audios:
		//	"audios" "{" initial=Initial & noMatch=NoMatch? & noInput=NoInput? & match=Match? "}";
		public ParserRule getRule() { return rule; }

		//"audios" "{" initial=Initial & noMatch=NoMatch? & noInput=NoInput? & match=Match? "}"
		public UnorderedGroup getUnorderedGroup() { return cUnorderedGroup; }

		//"audios" "{" initial=Initial
		public Group getGroup_0() { return cGroup_0; }

		//"audios"
		public Keyword getAudiosKeyword_0_0() { return cAudiosKeyword_0_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_0_1() { return cLeftCurlyBracketKeyword_0_1; }

		//initial=Initial
		public Assignment getInitialAssignment_0_2() { return cInitialAssignment_0_2; }

		//Initial
		public RuleCall getInitialInitialParserRuleCall_0_2_0() { return cInitialInitialParserRuleCall_0_2_0; }

		//noMatch=NoMatch?
		public Assignment getNoMatchAssignment_1() { return cNoMatchAssignment_1; }

		//NoMatch
		public RuleCall getNoMatchNoMatchParserRuleCall_1_0() { return cNoMatchNoMatchParserRuleCall_1_0; }

		//noInput=NoInput?
		public Assignment getNoInputAssignment_2() { return cNoInputAssignment_2; }

		//NoInput
		public RuleCall getNoInputNoInputParserRuleCall_2_0() { return cNoInputNoInputParserRuleCall_2_0; }

		//match=Match? "}"
		public Group getGroup_3() { return cGroup_3; }

		//match=Match?
		public Assignment getMatchAssignment_3_0() { return cMatchAssignment_3_0; }

		//Match
		public RuleCall getMatchMatchParserRuleCall_3_0_0() { return cMatchMatchParserRuleCall_3_0_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3_1() { return cRightCurlyBracketKeyword_3_1; }
	}

	public class NoInputElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NoInput");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNoinputKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cAudioAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cAudioConditionalAudioParserRuleCall_2_0 = (RuleCall)cAudioAssignment_2.eContents().get(0);
		
		//NoInput:
		//	"noinput" ":" audio+=ConditionalAudio+;
		public ParserRule getRule() { return rule; }

		//"noinput" ":" audio+=ConditionalAudio+
		public Group getGroup() { return cGroup; }

		//"noinput"
		public Keyword getNoinputKeyword_0() { return cNoinputKeyword_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//audio+=ConditionalAudio+
		public Assignment getAudioAssignment_2() { return cAudioAssignment_2; }

		//ConditionalAudio
		public RuleCall getAudioConditionalAudioParserRuleCall_2_0() { return cAudioConditionalAudioParserRuleCall_2_0; }
	}

	public class NoMatchElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NoMatch");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNomatchKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cAudioAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cAudioConditionalAudioParserRuleCall_2_0 = (RuleCall)cAudioAssignment_2.eContents().get(0);
		
		//NoMatch:
		//	"nomatch" ":" audio+=ConditionalAudio+;
		public ParserRule getRule() { return rule; }

		//"nomatch" ":" audio+=ConditionalAudio+
		public Group getGroup() { return cGroup; }

		//"nomatch"
		public Keyword getNomatchKeyword_0() { return cNomatchKeyword_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//audio+=ConditionalAudio+
		public Assignment getAudioAssignment_2() { return cAudioAssignment_2; }

		//ConditionalAudio
		public RuleCall getAudioConditionalAudioParserRuleCall_2_0() { return cAudioConditionalAudioParserRuleCall_2_0; }
	}

	public class MatchElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Match");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cMatchKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cAudioAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cAudioSimpleAudioParserRuleCall_2_0 = (RuleCall)cAudioAssignment_2.eContents().get(0);
		
		//Match:
		//	"match" ":" audio+=SimpleAudio+;
		public ParserRule getRule() { return rule; }

		//"match" ":" audio+=SimpleAudio+
		public Group getGroup() { return cGroup; }

		//"match"
		public Keyword getMatchKeyword_0() { return cMatchKeyword_0; }

		//":"
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//audio+=SimpleAudio+
		public Assignment getAudioAssignment_2() { return cAudioAssignment_2; }

		//SimpleAudio
		public RuleCall getAudioSimpleAudioParserRuleCall_2_0() { return cAudioSimpleAudioParserRuleCall_2_0; }
	}

	public class InitialElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Initial");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cInitialAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cInitialKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cAudioAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cAudioSimpleAudioParserRuleCall_3_0 = (RuleCall)cAudioAssignment_3.eContents().get(0);
		
		//Initial:
		//	{Initial} "initial" ":" audio+=SimpleAudio+;
		public ParserRule getRule() { return rule; }

		//{Initial} "initial" ":" audio+=SimpleAudio+
		public Group getGroup() { return cGroup; }

		//{Initial}
		public Action getInitialAction_0() { return cInitialAction_0; }

		//"initial"
		public Keyword getInitialKeyword_1() { return cInitialKeyword_1; }

		//":"
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//audio+=SimpleAudio+
		public Assignment getAudioAssignment_3() { return cAudioAssignment_3; }

		//SimpleAudio
		public RuleCall getAudioSimpleAudioParserRuleCall_3_0() { return cAudioSimpleAudioParserRuleCall_3_0; }
	}

	public class SimpleAudioElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SimpleAudio");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAudioAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cSayKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cDontBargeInAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cDontBargeInNobargeKeyword_2_0 = (Keyword)cDontBargeInAssignment_2.eContents().get(0);
		private final Assignment cTtsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cTtsSTRINGTerminalRuleCall_3_0 = (RuleCall)cTtsAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cSrcKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cSrcAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cSrcSTRINGTerminalRuleCall_4_1_0 = (RuleCall)cSrcAssignment_4_1.eContents().get(0);
		
		//SimpleAudio returns Audio:
		//	{Audio} "say" dontBargeIn?="nobarge"? tts=STRING? ("src" src=STRING)?;
		public ParserRule getRule() { return rule; }

		//{Audio} "say" dontBargeIn?="nobarge"? tts=STRING? ("src" src=STRING)?
		public Group getGroup() { return cGroup; }

		//{Audio}
		public Action getAudioAction_0() { return cAudioAction_0; }

		//"say"
		public Keyword getSayKeyword_1() { return cSayKeyword_1; }

		//dontBargeIn?="nobarge"?
		public Assignment getDontBargeInAssignment_2() { return cDontBargeInAssignment_2; }

		//"nobarge"
		public Keyword getDontBargeInNobargeKeyword_2_0() { return cDontBargeInNobargeKeyword_2_0; }

		//tts=STRING?
		public Assignment getTtsAssignment_3() { return cTtsAssignment_3; }

		//STRING
		public RuleCall getTtsSTRINGTerminalRuleCall_3_0() { return cTtsSTRINGTerminalRuleCall_3_0; }

		//("src" src=STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//"src"
		public Keyword getSrcKeyword_4_0() { return cSrcKeyword_4_0; }

		//src=STRING
		public Assignment getSrcAssignment_4_1() { return cSrcAssignment_4_1; }

		//STRING
		public RuleCall getSrcSTRINGTerminalRuleCall_4_1_0() { return cSrcSTRINGTerminalRuleCall_4_1_0; }
	}

	public class ConditionalAudioElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConditionalAudio");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cConditionAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cConditionConditionParserRuleCall_0_0_0 = (RuleCall)cConditionAssignment_0_0.eContents().get(0);
		private final Keyword cEqualsSignGreaterThanSignKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cAudioAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cAudioSimpleAudioParserRuleCall_1_0_0 = (RuleCall)cAudioAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cAudioAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cAudioSimpleAudioParserRuleCall_1_1_1_0 = (RuleCall)cAudioAssignment_1_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_1_1_2 = (Keyword)cGroup_1_1.eContents().get(2);
		
		//ConditionalAudio returns Audio:
		//	(condition=Condition "=>")? (audio+=SimpleAudio | "{" audio+=SimpleAudio+ "}");
		public ParserRule getRule() { return rule; }

		//(condition=Condition "=>")? (audio+=SimpleAudio | "{" audio+=SimpleAudio+ "}")
		public Group getGroup() { return cGroup; }

		//(condition=Condition "=>")?
		public Group getGroup_0() { return cGroup_0; }

		//condition=Condition
		public Assignment getConditionAssignment_0_0() { return cConditionAssignment_0_0; }

		//Condition
		public RuleCall getConditionConditionParserRuleCall_0_0_0() { return cConditionConditionParserRuleCall_0_0_0; }

		//"=>"
		public Keyword getEqualsSignGreaterThanSignKeyword_0_1() { return cEqualsSignGreaterThanSignKeyword_0_1; }

		//audio+=SimpleAudio | "{" audio+=SimpleAudio+ "}"
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//audio+=SimpleAudio
		public Assignment getAudioAssignment_1_0() { return cAudioAssignment_1_0; }

		//SimpleAudio
		public RuleCall getAudioSimpleAudioParserRuleCall_1_0_0() { return cAudioSimpleAudioParserRuleCall_1_0_0; }

		//"{" audio+=SimpleAudio+ "}"
		public Group getGroup_1_1() { return cGroup_1_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1_1_0() { return cLeftCurlyBracketKeyword_1_1_0; }

		//audio+=SimpleAudio+
		public Assignment getAudioAssignment_1_1_1() { return cAudioAssignment_1_1_1; }

		//SimpleAudio
		public RuleCall getAudioSimpleAudioParserRuleCall_1_1_1_0() { return cAudioSimpleAudioParserRuleCall_1_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_1_1_2() { return cRightCurlyBracketKeyword_1_1_2; }
	}

	public class ConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Condition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCountKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cCountAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cCountINTTerminalRuleCall_1_0 = (RuleCall)cCountAssignment_1.eContents().get(0);
		
		//Condition:
		//	"count" count=INT;
		public ParserRule getRule() { return rule; }

		//"count" count=INT
		public Group getGroup() { return cGroup; }

		//"count"
		public Keyword getCountKeyword_0() { return cCountKeyword_0; }

		//count=INT
		public Assignment getCountAssignment_1() { return cCountAssignment_1; }

		//INT
		public RuleCall getCountINTTerminalRuleCall_1_0() { return cCountINTTerminalRuleCall_1_0; }
	}
	
	
	private InputElementElements pInputElement;
	private GrammarElements pGrammar;
	private ConfigurationElements pConfiguration;
	private AudiosElements pAudios;
	private NoInputElements pNoInput;
	private NoMatchElements pNoMatch;
	private MatchElements pMatch;
	private InitialElements pInitial;
	private SimpleAudioElements pSimpleAudio;
	private ConditionalAudioElements pConditionalAudio;
	private ConditionElements pCondition;
	
	private final Grammar grammar;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public VoiceDslGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("com.isb.bks.ivr.voice.dsl.VoiceDsl".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//InputElement:
	//	configuration=Configuration grammatics=Grammar? audios=Audios?;
	public InputElementElements getInputElementAccess() {
		return (pInputElement != null) ? pInputElement : (pInputElement = new InputElementElements());
	}
	
	public ParserRule getInputElementRule() {
		return getInputElementAccess().getRule();
	}

	//Grammar:
	//	"grammar" mode=("voice" | "dtmf") builtin?="builtin"? src=STRING;
	public GrammarElements getGrammarAccess() {
		return (pGrammar != null) ? pGrammar : (pGrammar = new GrammarElements());
	}
	
	public ParserRule getGrammarRule() {
		return getGrammarAccess().getRule();
	}

	//Configuration:
	//	"inputname" name=ID ("maxNoInput" maxNoInput=INT)? ("maxNoMatch" maxNoMAtch=INT)? ("maxAttempts" maxAttempts=INT)?;
	public ConfigurationElements getConfigurationAccess() {
		return (pConfiguration != null) ? pConfiguration : (pConfiguration = new ConfigurationElements());
	}
	
	public ParserRule getConfigurationRule() {
		return getConfigurationAccess().getRule();
	}

	//Audios:
	//	"audios" "{" initial=Initial & noMatch=NoMatch? & noInput=NoInput? & match=Match? "}";
	public AudiosElements getAudiosAccess() {
		return (pAudios != null) ? pAudios : (pAudios = new AudiosElements());
	}
	
	public ParserRule getAudiosRule() {
		return getAudiosAccess().getRule();
	}

	//NoInput:
	//	"noinput" ":" audio+=ConditionalAudio+;
	public NoInputElements getNoInputAccess() {
		return (pNoInput != null) ? pNoInput : (pNoInput = new NoInputElements());
	}
	
	public ParserRule getNoInputRule() {
		return getNoInputAccess().getRule();
	}

	//NoMatch:
	//	"nomatch" ":" audio+=ConditionalAudio+;
	public NoMatchElements getNoMatchAccess() {
		return (pNoMatch != null) ? pNoMatch : (pNoMatch = new NoMatchElements());
	}
	
	public ParserRule getNoMatchRule() {
		return getNoMatchAccess().getRule();
	}

	//Match:
	//	"match" ":" audio+=SimpleAudio+;
	public MatchElements getMatchAccess() {
		return (pMatch != null) ? pMatch : (pMatch = new MatchElements());
	}
	
	public ParserRule getMatchRule() {
		return getMatchAccess().getRule();
	}

	//Initial:
	//	{Initial} "initial" ":" audio+=SimpleAudio+;
	public InitialElements getInitialAccess() {
		return (pInitial != null) ? pInitial : (pInitial = new InitialElements());
	}
	
	public ParserRule getInitialRule() {
		return getInitialAccess().getRule();
	}

	//SimpleAudio returns Audio:
	//	{Audio} "say" dontBargeIn?="nobarge"? tts=STRING? ("src" src=STRING)?;
	public SimpleAudioElements getSimpleAudioAccess() {
		return (pSimpleAudio != null) ? pSimpleAudio : (pSimpleAudio = new SimpleAudioElements());
	}
	
	public ParserRule getSimpleAudioRule() {
		return getSimpleAudioAccess().getRule();
	}

	//ConditionalAudio returns Audio:
	//	(condition=Condition "=>")? (audio+=SimpleAudio | "{" audio+=SimpleAudio+ "}");
	public ConditionalAudioElements getConditionalAudioAccess() {
		return (pConditionalAudio != null) ? pConditionalAudio : (pConditionalAudio = new ConditionalAudioElements());
	}
	
	public ParserRule getConditionalAudioRule() {
		return getConditionalAudioAccess().getRule();
	}

	//Condition:
	//	"count" count=INT;
	public ConditionElements getConditionAccess() {
		return (pCondition != null) ? pCondition : (pCondition = new ConditionElements());
	}
	
	public ParserRule getConditionRule() {
		return getConditionAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
