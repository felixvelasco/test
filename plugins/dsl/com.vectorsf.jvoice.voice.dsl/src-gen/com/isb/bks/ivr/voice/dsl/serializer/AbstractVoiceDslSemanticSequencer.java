package com.isb.bks.ivr.voice.dsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.isb.bks.ivr.voice.dsl.services.VoiceDslGrammarAccess;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Audio;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Audios;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Condition;
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio;
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConfigValue;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Configuration;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Grammars;
import com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Output;
import com.vectorsf.jvoice.prompt.model.voiceDsl.OutputValue;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs;
import com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage;
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
public abstract class AbstractVoiceDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private VoiceDslGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == VoiceDslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case VoiceDslPackage.AUDIO:
				if(context == grammarAccess.getConditionalAudioRule() ||
				   context == grammarAccess.getSimpleAudioRule()) {
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
			case VoiceDslPackage.CONDITIONAL_AUDIO:
				if(context == grammarAccess.getConditionalAudioRule()) {
					sequence_ConditionalAudio(context, (ConditionalAudio) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.CONFIG_VALUE:
				if(context == grammarAccess.getConfigValueRule()) {
					sequence_ConfigValue(context, (ConfigValue) semanticObject); 
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
			case VoiceDslPackage.GRAMMARS:
				if(context == grammarAccess.getGrammarsRule()) {
					sequence_Grammars(context, (Grammars) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.INPUT_DSL:
				if(context == grammarAccess.getInputDslRule() ||
				   context == grammarAccess.getVoiceDslRule()) {
					sequence_InputDsl(context, (InputDsl) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.MENU_DSL:
				if(context == grammarAccess.getMenuDslRule() ||
				   context == grammarAccess.getVoiceDslRule()) {
					sequence_MenuDsl(context, (MenuDsl) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.OUTPUT:
				if(context == grammarAccess.getOutputRule()) {
					sequence_Output(context, (Output) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.OUTPUT_VALUE:
				if(context == grammarAccess.getOutputValueRule()) {
					sequence_OutputValue(context, (OutputValue) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.OUTPUTS:
				if(context == grammarAccess.getOutputsRule()) {
					sequence_Outputs(context, (Outputs) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.PROMPT_DSL:
				if(context == grammarAccess.getPromptDslRule() ||
				   context == grammarAccess.getVoiceDslRule()) {
					sequence_PromptDsl(context, (PromptDsl) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.RECORD_DSL:
				if(context == grammarAccess.getRecordDslRule() ||
				   context == grammarAccess.getVoiceDslRule()) {
					sequence_RecordDsl(context, (RecordDsl) semanticObject); 
					return; 
				}
				else break;
			case VoiceDslPackage.TRANSFER_DSL:
				if(context == grammarAccess.getTransferDslRule() ||
				   context == grammarAccess.getVoiceDslRule()) {
					sequence_TransferDsl(context, (TransferDsl) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (mainAudios+=ConditionalAudio* matchAudios+=ConditionalAudio* noMatchAudios+=ConditionalAudio* noInputAudios+=ConditionalAudio*)
	 */
	protected void sequence_Audios(EObject context, Audios semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID condition=INT)
	 */
	protected void sequence_Condition(EObject context, Condition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VoiceDslPackage.Literals.CONDITION__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VoiceDslPackage.Literals.CONDITION__CONDITION));
			if(transientValues.isValueTransient(semanticObject, VoiceDslPackage.Literals.CONDITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VoiceDslPackage.Literals.CONDITION__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConditionAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getConditionAccess().getConditionINTTerminalRuleCall_3_0(), semanticObject.getCondition());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (condit=STRING simpleAudios+=SimpleAudio+)
	 */
	protected void sequence_ConditionalAudio(EObject context, ConditionalAudio semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID value=ConfigValueValue)
	 */
	protected void sequence_ConfigValue(EObject context, ConfigValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, VoiceDslPackage.Literals.CONFIG_VALUE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VoiceDslPackage.Literals.CONFIG_VALUE__NAME));
			if(transientValues.isValueTransient(semanticObject, VoiceDslPackage.Literals.CONFIG_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, VoiceDslPackage.Literals.CONFIG_VALUE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConfigValueAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getConfigValueAccess().getValueConfigValueValueParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (configValue+=ConfigValue*)
	 */
	protected void sequence_Configuration(EObject context, Configuration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((mode='voice' | mode='dtmf' | mode='voicedtmf') expr?='expr'? src=STRING)
	 */
	protected void sequence_Grammar(EObject context, Grammar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (grammatics+=Grammar*)
	 */
	protected void sequence_Grammars(EObject context, Grammars semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID configuration=Configuration grammars=Grammars conditions+=Condition* audios=Audios)
	 */
	protected void sequence_InputDsl(EObject context, InputDsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         configuration=Configuration 
	 *         grammars=Grammars 
	 *         conditions+=Condition* 
	 *         audios=Audios 
	 *         outputs=Outputs
	 *     )
	 */
	protected void sequence_MenuDsl(EObject context, MenuDsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=STRING | value='*')
	 */
	protected void sequence_OutputValue(EObject context, OutputValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID outputValue+=OutputValue outputValue+=OutputValue*)
	 */
	protected void sequence_Output(EObject context, Output semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     output+=Output+
	 */
	protected void sequence_Outputs(EObject context, Outputs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID configuration=Configuration conditions+=Condition* audios=Audios)
	 */
	protected void sequence_PromptDsl(EObject context, PromptDsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID fileName=STRING configuration=Configuration conditions+=Condition* audios=Audios)
	 */
	protected void sequence_RecordDsl(EObject context, RecordDsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (src=STRING? (tts=STRING | (interpretation=Interpretation format=STRING? tts=STRING))?)
	 */
	protected void sequence_SimpleAudio(EObject context, Audio semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (name=ID | name=ID | name=ID) 
	 *         destination=STRING 
	 *         audioTransfer=STRING? 
	 *         maxTime=STRING? 
	 *         timeout=STRING? 
	 *         conditions+=Condition? 
	 *         audios=Audios
	 *     )
	 */
	protected void sequence_TransferDsl(EObject context, TransferDsl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
