package com.isb.bks.ivr.voice.dsl.serializer;

import com.google.inject.Inject;
import com.isb.bks.ivr.voice.dsl.services.VoiceDslGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractVoiceDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected VoiceDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Audios_RightCurlyBracketKeyword_4_a;
	protected AbstractElementAlias match_Audios_RightCurlyBracketKeyword_4_a_or___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_4_a__;
	protected AbstractElementAlias match_Audios___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a;
	protected AbstractElementAlias match_Audios___RightCurlyBracketKeyword_4_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p;
	protected AbstractElementAlias match_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_MatchKeyword_1_0_ColonKeyword_1_1__q;
	protected AbstractElementAlias match_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_NoinputKeyword_3_0_ColonKeyword_3_1__q;
	protected AbstractElementAlias match_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_NomatchKeyword_2_0_ColonKeyword_2_1__q;
	protected AbstractElementAlias match_Audios_____RightCurlyBracketKeyword_4_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p_MainKeyword_0_2_0_ColonKeyword_0_2_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (VoiceDslGrammarAccess) access;
		match_Audios_RightCurlyBracketKeyword_4_a = new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4());
		match_Audios_RightCurlyBracketKeyword_4_a_or___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_4_a__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4()), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1())), new GroupAlias(true, true, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4()), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()))), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4())), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4()));
		match_Audios___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4()));
		match_Audios___RightCurlyBracketKeyword_4_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p = new GroupAlias(true, false, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()));
		match_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_MatchKeyword_1_0_ColonKeyword_1_1__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4())), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getMatchKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_1_1()));
		match_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_NoinputKeyword_3_0_ColonKeyword_3_1__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4())), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getNoinputKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_3_1()));
		match_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_NomatchKeyword_2_0_ColonKeyword_2_1__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4())), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getNomatchKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_2_1()));
		match_Audios_____RightCurlyBracketKeyword_4_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p_MainKeyword_0_2_0_ColonKeyword_0_2_1__q = new GroupAlias(false, true, new GroupAlias(true, false, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_4()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1())), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getMainKeyword_0_2_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_0_2_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Audios_RightCurlyBracketKeyword_4_a.equals(syntax))
				emit_Audios_RightCurlyBracketKeyword_4_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios_RightCurlyBracketKeyword_4_a_or___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_4_a__.equals(syntax))
				emit_Audios_RightCurlyBracketKeyword_4_a_or___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_4_a__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a.equals(syntax))
				emit_Audios___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___RightCurlyBracketKeyword_4_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p.equals(syntax))
				emit_Audios___RightCurlyBracketKeyword_4_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_MatchKeyword_1_0_ColonKeyword_1_1__q.equals(syntax))
				emit_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_MatchKeyword_1_0_ColonKeyword_1_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_NoinputKeyword_3_0_ColonKeyword_3_1__q.equals(syntax))
				emit_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_NoinputKeyword_3_0_ColonKeyword_3_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_NomatchKeyword_2_0_ColonKeyword_2_1__q.equals(syntax))
				emit_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_NomatchKeyword_2_0_ColonKeyword_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios_____RightCurlyBracketKeyword_4_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p_MainKeyword_0_2_0_ColonKeyword_0_2_1__q.equals(syntax))
				emit_Audios_____RightCurlyBracketKeyword_4_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p_MainKeyword_0_2_0_ColonKeyword_0_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '}'*
	 */
	protected void emit_Audios_RightCurlyBracketKeyword_4_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('}'* ('audios' '{')+ ('}'* ('audios' '{')+)* '}'*) | '}'*
	 */
	protected void emit_Audios_RightCurlyBracketKeyword_4_a_or___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_4_a__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('audios' '{' '}'*)*
	 */
	protected void emit_Audios___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('}'* 'audios' '{')+
	 */
	protected void emit_Audios___RightCurlyBracketKeyword_4_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('}'* ('audios' '{' '}'*)* 'match' ':')?
	 */
	protected void emit_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_MatchKeyword_1_0_ColonKeyword_1_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('}'* ('audios' '{' '}'*)* 'noinput' ':')?
	 */
	protected void emit_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_NoinputKeyword_3_0_ColonKeyword_3_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('}'* ('audios' '{' '}'*)* 'nomatch' ':')?
	 */
	protected void emit_Audios___RightCurlyBracketKeyword_4_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_4_a__a_NomatchKeyword_2_0_ColonKeyword_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (('}'* 'audios' '{')+ 'main' ':')?
	 */
	protected void emit_Audios_____RightCurlyBracketKeyword_4_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p_MainKeyword_0_2_0_ColonKeyword_0_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
