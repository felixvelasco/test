package com.isb.bks.ivr.voice.dsl.serializer;

import com.google.inject.Inject;
import com.isb.bks.ivr.voice.dsl.services.VoiceDslGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractVoiceDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected VoiceDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Audios___MainKeyword_3_0_0_ColonKeyword_3_0_1__q;
	protected AbstractElementAlias match_Audios___MatchKeyword_3_1_0_ColonKeyword_3_1_1__q;
	protected AbstractElementAlias match_Audios___NoinputKeyword_3_3_0_ColonKeyword_3_3_1__q;
	protected AbstractElementAlias match_Audios___NomatchKeyword_3_2_0_ColonKeyword_3_2_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (VoiceDslGrammarAccess) access;
		match_Audios___MainKeyword_3_0_0_ColonKeyword_3_0_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getMainKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_3_0_1()));
		match_Audios___MatchKeyword_3_1_0_ColonKeyword_3_1_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getMatchKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_3_1_1()));
		match_Audios___NoinputKeyword_3_3_0_ColonKeyword_3_3_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getNoinputKeyword_3_3_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_3_3_1()));
		match_Audios___NomatchKeyword_3_2_0_ColonKeyword_3_2_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getNomatchKeyword_3_2_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_3_2_1()));
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
			if(match_Audios___MainKeyword_3_0_0_ColonKeyword_3_0_1__q.equals(syntax))
				emit_Audios___MainKeyword_3_0_0_ColonKeyword_3_0_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___MatchKeyword_3_1_0_ColonKeyword_3_1_1__q.equals(syntax))
				emit_Audios___MatchKeyword_3_1_0_ColonKeyword_3_1_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___NoinputKeyword_3_3_0_ColonKeyword_3_3_1__q.equals(syntax))
				emit_Audios___NoinputKeyword_3_3_0_ColonKeyword_3_3_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___NomatchKeyword_3_2_0_ColonKeyword_3_2_1__q.equals(syntax))
				emit_Audios___NomatchKeyword_3_2_0_ColonKeyword_3_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('main' ':')?
	 */
	protected void emit_Audios___MainKeyword_3_0_0_ColonKeyword_3_0_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('match' ':')?
	 */
	protected void emit_Audios___MatchKeyword_3_1_0_ColonKeyword_3_1_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('noinput' ':')?
	 */
	protected void emit_Audios___NoinputKeyword_3_3_0_ColonKeyword_3_3_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('nomatch' ':')?
	 */
	protected void emit_Audios___NomatchKeyword_3_2_0_ColonKeyword_3_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
