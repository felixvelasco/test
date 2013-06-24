package com.isb.bks.ivr.voice.dsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.isb.bks.ivr.voice.dsl.services.VoiceDslGrammarAccess;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Audio;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Audios;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Condition;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Initial;
import com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Match;
import com.isb.bks.ivr.voice.dsl.voiceDsl.NoInput;
import com.isb.bks.ivr.voice.dsl.voiceDsl.NoMatch;
import com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class VoiceDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private VoiceDslGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == VoiceDslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case VoiceDslPackage.AUDIO:
				if(context == grammarAccess.getConditionalAudioRule()) {
					sequence_ConditionalAudio(context, (Audio) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSimpleAudioRule()) {
					sequence_SimpleAudio(context, (Audio) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.AUDIOS:
				if(context == grammarAccess.getAudiosRule()) {
					sequence_Audios(context, (Audios) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.CONDITION:
				if(context == grammarAccess.getConditionRule()) {
					sequence_Condition(context, (Condition) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.CONFIGURATION:
				if(context == grammarAccess.getConfigurationRule()) {
					sequence_Configuration(context, (Configuration) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.GRAMMAR:
				if(context == grammarAccess.getGrammarRule()) {
					sequence_Grammar(context, (Grammar) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.INITIAL:
				if(context == grammarAccess.getInitialRule()) {
					sequence_Initial(context, (Initial) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.INPUT_ELEMENT:
				if(context == grammarAccess.getInputElementRule()) {
					sequence_InputElement(context, (InputElement) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.MATCH:
				if(context == grammarAccess.getMatchRule()) {
					sequence_Match(context, (Match) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.NO_INPUT:
				if(context == grammarAccess.getNoInputRule()) {
					sequence_NoInput(context, (NoInput) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.NO_MATCH:
				if(context == grammarAccess.getNoMatchRule()) {
					sequence_NoMatch(context, (NoMatch) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (initial=Initial noMatch=NoMatch? noInput=NoInput? match=Match?)
	 */
	protected void sequence_Audios(EObject context, Audios semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     count=INT
	 */
	protected void sequence_Condition(EObject context, Condition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VoiceDslPackage.Literals.CONDITION__COUNT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VoiceDslPackage.Literals.CONDITION__COUNT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConditionAccess().getCountINTTerminalRuleCall_1_0(), semanticObject.getCount());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Condition? (audio+=SimpleAudio | audio+=SimpleAudio+))
	 */
	protected void sequence_ConditionalAudio(EObject context, Audio semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID maxNoInput=INT? maxNoMAtch=INT? maxAttempts=INT?)
	 */
	protected void sequence_Configuration(EObject context, Configuration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((mode='voice' | mode='dtmf') builtin?='builtin'? src=STRING)
	 */
	protected void sequence_Grammar(EObject context, Grammar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     audio+=SimpleAudio+
	 */
	protected void sequence_Initial(EObject context, Initial semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (configuration=Configuration grammatics=Grammar? audios=Audios?)
	 */
	protected void sequence_InputElement(EObject context, InputElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     audio+=SimpleAudio+
	 */
	protected void sequence_Match(EObject context, Match semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     audio+=ConditionalAudio+
	 */
	protected void sequence_NoInput(EObject context, NoInput semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     audio+=ConditionalAudio+
	 */
	protected void sequence_NoMatch(EObject context, NoMatch semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dontBargeIn?='nobarge'? tts=STRING? src=STRING?)
	 */
	protected void sequence_SimpleAudio(EObject context, Audio semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
