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
	protected AbstractElementAlias match_Audios_RightCurlyBracketKeyword_3_1_a;
	protected AbstractElementAlias match_Audios_RightCurlyBracketKeyword_3_1_a_or___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a__;
	protected AbstractElementAlias match_Audios___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a;
	protected AbstractElementAlias match_Audios___RightCurlyBracketKeyword_3_1_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p;
	protected AbstractElementAlias match_Audios___RightCurlyBracketKeyword_3_1_a_NoinputKeyword_3_0_0_ColonKeyword_3_0_1__q_or___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a_NoinputKeyword_3_0_0_ColonKeyword_3_0_1__;
	protected AbstractElementAlias match_Audios___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a_MatchKeyword_1_0_ColonKeyword_1_1__q;
	protected AbstractElementAlias match_Audios___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a_NomatchKeyword_2_0_ColonKeyword_2_1__q;
	protected AbstractElementAlias match_Audios___RightCurlyBracketKeyword_3_1_p___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__p;
	protected AbstractElementAlias match_Audios_____AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a__q;
	protected AbstractElementAlias match_Audios_____RightCurlyBracketKeyword_3_1_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p_MainKeyword_0_2_0_ColonKeyword_0_2_1__q;
	protected AbstractElementAlias match_Member_SemicolonKeyword_2_0_3_q;
	protected AbstractElementAlias match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a;
	protected AbstractElementAlias match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p;
	protected AbstractElementAlias match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q;
	protected AbstractElementAlias match_XBlockExpression_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias match_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q;
	protected AbstractElementAlias match_XExpressionInClosure_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q;
	protected AbstractElementAlias match_XImportDeclaration_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (VoiceDslGrammarAccess) access;
		match_Audios_RightCurlyBracketKeyword_3_1_a = new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1());
		match_Audios_RightCurlyBracketKeyword_3_1_a_or___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1())), new GroupAlias(true, true, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()))), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1())), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()));
		match_Audios___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()));
		match_Audios___RightCurlyBracketKeyword_3_1_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p = new GroupAlias(true, false, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()));
		match_Audios___RightCurlyBracketKeyword_3_1_a_NoinputKeyword_3_0_0_ColonKeyword_3_0_1__q_or___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a_NoinputKeyword_3_0_0_ColonKeyword_3_0_1__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1())), new GroupAlias(true, true, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()))), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getNoinputKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_3_0_1())), new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getNoinputKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_3_0_1())));
		match_Audios___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a_MatchKeyword_1_0_ColonKeyword_1_1__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1())), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getMatchKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_1_1()));
		match_Audios___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a_NomatchKeyword_2_0_ColonKeyword_2_1__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1())), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getNomatchKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_2_1()));
		match_Audios___RightCurlyBracketKeyword_3_1_p___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__p = new GroupAlias(true, false, new TokenAlias(true, false, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1())));
		match_Audios_____AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a__q = new GroupAlias(false, true, new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1())), new GroupAlias(true, true, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1()))), new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()));
		match_Audios_____RightCurlyBracketKeyword_3_1_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p_MainKeyword_0_2_0_ColonKeyword_0_2_1__q = new GroupAlias(false, true, new GroupAlias(true, false, new TokenAlias(true, true, grammarAccess.getAudiosAccess().getRightCurlyBracketKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getAudiosKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getLeftCurlyBracketKeyword_0_1())), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getMainKeyword_0_2_0()), new TokenAlias(false, false, grammarAccess.getAudiosAccess().getColonKeyword_0_2_1()));
		match_Member_SemicolonKeyword_2_0_3_q = new TokenAlias(false, true, grammarAccess.getMemberAccess().getSemicolonKeyword_2_0_3());
		match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a = new TokenAlias(true, true, grammarAccess.getXAnnotationElementValueAccess().getLeftParenthesisKeyword_7_0());
		match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p = new TokenAlias(true, false, grammarAccess.getXAnnotationElementValueAccess().getLeftParenthesisKeyword_7_0());
		match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXAnnotationAccess().getLeftParenthesisKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getXAnnotationAccess().getRightParenthesisKeyword_3_2()));
		match_XBlockExpression_SemicolonKeyword_2_1_q = new TokenAlias(false, true, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
		match_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXConstructorCallAccess().getLeftParenthesisKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2()));
		match_XExpressionInClosure_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
		match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()));
		match_XImportDeclaration_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getArrayBracketsRule())
			return getArrayBracketsToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * ArrayBrackets :
	 * 	'[' ']'
	 * ;
	 */
	protected String getArrayBracketsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
	}
	
	/**
	 * OpSingleAssign:
	 * 	'='
	 * ;
	 */
	protected String getOpSingleAssignToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Audios_RightCurlyBracketKeyword_3_1_a.equals(syntax))
				emit_Audios_RightCurlyBracketKeyword_3_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios_RightCurlyBracketKeyword_3_1_a_or___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a__.equals(syntax))
				emit_Audios_RightCurlyBracketKeyword_3_1_a_or___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a.equals(syntax))
				emit_Audios___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___RightCurlyBracketKeyword_3_1_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p.equals(syntax))
				emit_Audios___RightCurlyBracketKeyword_3_1_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___RightCurlyBracketKeyword_3_1_a_NoinputKeyword_3_0_0_ColonKeyword_3_0_1__q_or___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a_NoinputKeyword_3_0_0_ColonKeyword_3_0_1__.equals(syntax))
				emit_Audios___RightCurlyBracketKeyword_3_1_a_NoinputKeyword_3_0_0_ColonKeyword_3_0_1__q_or___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a_NoinputKeyword_3_0_0_ColonKeyword_3_0_1__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a_MatchKeyword_1_0_ColonKeyword_1_1__q.equals(syntax))
				emit_Audios___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a_MatchKeyword_1_0_ColonKeyword_1_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a_NomatchKeyword_2_0_ColonKeyword_2_1__q.equals(syntax))
				emit_Audios___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a_NomatchKeyword_2_0_ColonKeyword_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios___RightCurlyBracketKeyword_3_1_p___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__p.equals(syntax))
				emit_Audios___RightCurlyBracketKeyword_3_1_p___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios_____AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a__q.equals(syntax))
				emit_Audios_____AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Audios_____RightCurlyBracketKeyword_3_1_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p_MainKeyword_0_2_0_ColonKeyword_0_2_1__q.equals(syntax))
				emit_Audios_____RightCurlyBracketKeyword_3_1_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p_MainKeyword_0_2_0_ColonKeyword_0_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Member_SemicolonKeyword_2_0_3_q.equals(syntax))
				emit_Member_SemicolonKeyword_2_0_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a.equals(syntax))
				emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p.equals(syntax))
				emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q.equals(syntax))
				emit_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XBlockExpression_SemicolonKeyword_2_1_q.equals(syntax))
				emit_XBlockExpression_SemicolonKeyword_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q.equals(syntax))
				emit_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XExpressionInClosure_SemicolonKeyword_1_1_q.equals(syntax))
				emit_XExpressionInClosure_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q.equals(syntax))
				emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XImportDeclaration_SemicolonKeyword_2_q.equals(syntax))
				emit_XImportDeclaration_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     '}'* | ('}'* ('audios' '{')+ ('}'* ('audios' '{')+)* '}'*)
	 */
	protected void emit_Audios_RightCurlyBracketKeyword_3_1_a_or___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('audios' '{' '}'*)*
	 */
	protected void emit_Audios___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('}'* 'audios' '{')+
	 */
	protected void emit_Audios___RightCurlyBracketKeyword_3_1_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     ('}'* 'noinput' ':')? | 
	     (
	         '}'* 
	         ('audios' '{')+ 
	         ('}'* ('audios' '{')+)* 
	         '}'* 
	         'noinput' 
	         ':'
	     )
	 )
	 */
	protected void emit_Audios___RightCurlyBracketKeyword_3_1_a_NoinputKeyword_3_0_0_ColonKeyword_3_0_1__q_or___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a_NoinputKeyword_3_0_0_ColonKeyword_3_0_1__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('}'* ('audios' '{' '}'*)* 'match' ':')?
	 */
	protected void emit_Audios___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a_MatchKeyword_1_0_ColonKeyword_1_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('}'* ('audios' '{' '}'*)* 'nomatch' ':')?
	 */
	protected void emit_Audios___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1_RightCurlyBracketKeyword_3_1_a__a_NomatchKeyword_2_0_ColonKeyword_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('}'+ ('audios' '{')+)+
	 */
	protected void emit_Audios___RightCurlyBracketKeyword_3_1_p___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (('audios' '{')+ ('}'* ('audios' '{')+)* '}'*)?
	 */
	protected void emit_Audios_____AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p___RightCurlyBracketKeyword_3_1_a___AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p__a_RightCurlyBracketKeyword_3_1_a__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (('}'* 'audios' '{')+ 'main' ':')?
	 */
	protected void emit_Audios_____RightCurlyBracketKeyword_3_1_a_AudiosKeyword_0_0_LeftCurlyBracketKeyword_0_1__p_MainKeyword_0_2_0_ColonKeyword_0_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_Member_SemicolonKeyword_2_0_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_XAnnotationElementValue_LeftParenthesisKeyword_7_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_XAnnotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XBlockExpression_SemicolonKeyword_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_XConstructorCall___LeftParenthesisKeyword_4_0_RightParenthesisKeyword_4_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XExpressionInClosure_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XImportDeclaration_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
