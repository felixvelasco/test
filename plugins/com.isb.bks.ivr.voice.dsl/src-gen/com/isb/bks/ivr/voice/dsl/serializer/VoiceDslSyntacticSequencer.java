package com.isb.bks.ivr.voice.dsl.serializer;

import com.google.inject.Inject;
import com.isb.bks.ivr.voice.dsl.services.VoiceDslGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class VoiceDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected VoiceDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Audios_RightCurlyBracketKeyword_3_1_a;
	protected AbstractElementAlias match_Audios_RightCurlyBracketKeyword_3_1_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (VoiceDslGrammarAccess) access;
		match_Audios_RightCurlyBracketKeyword_3_1_a = new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1());
		match_Audios_RightCurlyBracketKeyword_3_1_p = new TokenAlias(true, false, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1());
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
			if(match_Audios_RightCurlyBracketKeyword_3_1_a.equals(syntax))
				emit_Audios_RightCurlyBracketKeyword_3_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios_RightCurlyBracketKeyword_3_1_p.equals(syntax))
				emit_Audios_RightCurlyBracketKeyword_3_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '}'*
	 */
	protected void emit_Audios_RightCurlyBracketKeyword_3_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '}'+
	 */
	protected void emit_Audios_RightCurlyBracketKeyword_3_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
