/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl;

import com.vectorsf.jvoice.model.base.BasePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslFactory
 * @model kind="package"
 * @generated
 */
public interface VoiceDslPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "voiceDsl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.isb.com/bks/ivr/voice/dsl/VoiceDsl/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "voiceDsl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VoiceDslPackage eINSTANCE = com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl <em>Voice Dsl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getVoiceDsl()
	 * @generated
	 */
	int VOICE_DSL = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__ID = BasePackage.JV_BEAN__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__NAME = BasePackage.JV_BEAN__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__DESCRIPTION = BasePackage.JV_BEAN__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owner Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__OWNER_PACKAGE = BasePackage.JV_BEAN__OWNER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__CONFIGURATION = BasePackage.JV_BEAN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__CONDITIONS = BasePackage.JV_BEAN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Audios</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__AUDIOS = BasePackage.JV_BEAN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__GRAMMARS = BasePackage.JV_BEAN_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__OUTPUTS = BasePackage.JV_BEAN_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Voice Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL_FEATURE_COUNT = BasePackage.JV_BEAN_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Voice Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL_OPERATION_COUNT = BasePackage.JV_BEAN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConfigurationImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Config Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__CONFIG_VALUE = 0;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION___GET_VALUE__STRING = 0;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConfigValueImpl <em>Config Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConfigValueImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getConfigValue()
	 * @generated
	 */
	int CONFIG_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_VALUE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Config Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_VALUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Config Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.GrammarImpl <em>Grammar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.GrammarImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getGrammar()
	 * @generated
	 */
	int GRAMMAR = 3;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR__MODE = 0;

	/**
	 * The feature id for the '<em><b>Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR__SRC = 1;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR__EXPR = 2;

	/**
	 * The number of structural features of the '<em>Grammar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Grammar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 4;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__NAME = 1;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudiosImpl <em>Audios</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudiosImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getAudios()
	 * @generated
	 */
	int AUDIOS = 5;

	/**
	 * The feature id for the '<em><b>Main Audios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIOS__MAIN_AUDIOS = 0;

	/**
	 * The feature id for the '<em><b>No Match Audios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIOS__NO_MATCH_AUDIOS = 1;

	/**
	 * The feature id for the '<em><b>No Input Audios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIOS__NO_INPUT_AUDIOS = 2;

	/**
	 * The feature id for the '<em><b>Match Audios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIOS__MATCH_AUDIOS = 3;

	/**
	 * The number of structural features of the '<em>Audios</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIOS_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Audios</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIOS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudioImpl <em>Audio</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudioImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getAudio()
	 * @generated
	 */
	int AUDIO = 6;

	/**
	 * The feature id for the '<em><b>Dont Barge In</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO__DONT_BARGE_IN = 0;

	/**
	 * The feature id for the '<em><b>Tts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO__TTS = 1;

	/**
	 * The feature id for the '<em><b>Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO__SRC = 2;

	/**
	 * The feature id for the '<em><b>Interpretation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO__INTERPRETATION = 3;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO__FORMAT = 4;

	/**
	 * The number of structural features of the '<em>Audio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Audio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionalAudioImpl <em>Conditional Audio</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionalAudioImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getConditionalAudio()
	 * @generated
	 */
	int CONDITIONAL_AUDIO = 7;

	/**
	 * The feature id for the '<em><b>Dont Barge In</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_AUDIO__DONT_BARGE_IN = AUDIO__DONT_BARGE_IN;

	/**
	 * The feature id for the '<em><b>Tts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_AUDIO__TTS = AUDIO__TTS;

	/**
	 * The feature id for the '<em><b>Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_AUDIO__SRC = AUDIO__SRC;

	/**
	 * The feature id for the '<em><b>Interpretation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_AUDIO__INTERPRETATION = AUDIO__INTERPRETATION;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_AUDIO__FORMAT = AUDIO__FORMAT;

	/**
	 * The feature id for the '<em><b>Simple Audios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_AUDIO__SIMPLE_AUDIOS = AUDIO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_AUDIO__CONDIT = AUDIO_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Conditional Audio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_AUDIO_FEATURE_COUNT = AUDIO_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Conditional Audio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_AUDIO_OPERATION_COUNT = AUDIO_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputValueImpl <em>Output Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputValueImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getOutputValue()
	 * @generated
	 */
	int OUTPUT_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VALUE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Output Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VALUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Output Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputsImpl <em>Outputs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputsImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getOutputs()
	 * @generated
	 */
	int OUTPUTS = 9;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUTS__OUTPUT = 0;

	/**
	 * The number of structural features of the '<em>Outputs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUTS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Outputs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.GrammarsImpl <em>Grammars</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.GrammarsImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getGrammars()
	 * @generated
	 */
	int GRAMMARS = 10;

	/**
	 * The feature id for the '<em><b>Grammatics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMARS__GRAMMATICS = 0;

	/**
	 * The number of structural features of the '<em>Grammars</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMARS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Grammars</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMARS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputImpl <em>Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getOutput()
	 * @generated
	 */
	int OUTPUT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Output Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT__OUTPUT_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.InputDslImpl <em>Input Dsl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.InputDslImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getInputDsl()
	 * @generated
	 */
	int INPUT_DSL = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DSL__ID = VOICE_DSL__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DSL__NAME = VOICE_DSL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DSL__DESCRIPTION = VOICE_DSL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owner Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DSL__OWNER_PACKAGE = VOICE_DSL__OWNER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DSL__CONFIGURATION = VOICE_DSL__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DSL__CONDITIONS = VOICE_DSL__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Audios</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DSL__AUDIOS = VOICE_DSL__AUDIOS;

	/**
	 * The feature id for the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DSL__GRAMMARS = VOICE_DSL__GRAMMARS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DSL__OUTPUTS = VOICE_DSL__OUTPUTS;

	/**
	 * The number of structural features of the '<em>Input Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DSL_FEATURE_COUNT = VOICE_DSL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Input Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DSL_OPERATION_COUNT = VOICE_DSL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.MenuDslImpl <em>Menu Dsl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.MenuDslImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getMenuDsl()
	 * @generated
	 */
	int MENU_DSL = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_DSL__ID = VOICE_DSL__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_DSL__NAME = VOICE_DSL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_DSL__DESCRIPTION = VOICE_DSL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owner Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_DSL__OWNER_PACKAGE = VOICE_DSL__OWNER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_DSL__CONFIGURATION = VOICE_DSL__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_DSL__CONDITIONS = VOICE_DSL__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Audios</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_DSL__AUDIOS = VOICE_DSL__AUDIOS;

	/**
	 * The feature id for the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_DSL__GRAMMARS = VOICE_DSL__GRAMMARS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_DSL__OUTPUTS = VOICE_DSL__OUTPUTS;

	/**
	 * The number of structural features of the '<em>Menu Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_DSL_FEATURE_COUNT = VOICE_DSL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Menu Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_DSL_OPERATION_COUNT = VOICE_DSL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.PromptDslImpl <em>Prompt Dsl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.PromptDslImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getPromptDsl()
	 * @generated
	 */
	int PROMPT_DSL = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_DSL__ID = VOICE_DSL__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_DSL__NAME = VOICE_DSL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_DSL__DESCRIPTION = VOICE_DSL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owner Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_DSL__OWNER_PACKAGE = VOICE_DSL__OWNER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_DSL__CONFIGURATION = VOICE_DSL__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_DSL__CONDITIONS = VOICE_DSL__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Audios</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_DSL__AUDIOS = VOICE_DSL__AUDIOS;

	/**
	 * The feature id for the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_DSL__GRAMMARS = VOICE_DSL__GRAMMARS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_DSL__OUTPUTS = VOICE_DSL__OUTPUTS;

	/**
	 * The number of structural features of the '<em>Prompt Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_DSL_FEATURE_COUNT = VOICE_DSL_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Prompt Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_DSL_OPERATION_COUNT = VOICE_DSL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.RecordDslImpl <em>Record Dsl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.RecordDslImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getRecordDsl()
	 * @generated
	 */
	int RECORD_DSL = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL__ID = VOICE_DSL__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL__NAME = VOICE_DSL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL__DESCRIPTION = VOICE_DSL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owner Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL__OWNER_PACKAGE = VOICE_DSL__OWNER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL__CONFIGURATION = VOICE_DSL__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL__CONDITIONS = VOICE_DSL__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Audios</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL__AUDIOS = VOICE_DSL__AUDIOS;

	/**
	 * The feature id for the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL__GRAMMARS = VOICE_DSL__GRAMMARS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL__OUTPUTS = VOICE_DSL__OUTPUTS;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL__FILE_NAME = VOICE_DSL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Record Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL_FEATURE_COUNT = VOICE_DSL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Record Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_DSL_OPERATION_COUNT = VOICE_DSL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.TransferDslImpl <em>Transfer Dsl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.TransferDslImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getTransferDsl()
	 * @generated
	 */
	int TRANSFER_DSL = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__ID = VOICE_DSL__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__NAME = VOICE_DSL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__DESCRIPTION = VOICE_DSL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owner Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__OWNER_PACKAGE = VOICE_DSL__OWNER_PACKAGE;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__CONFIGURATION = VOICE_DSL__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__CONDITIONS = VOICE_DSL__CONDITIONS;

	/**
	 * The feature id for the '<em><b>Audios</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__AUDIOS = VOICE_DSL__AUDIOS;

	/**
	 * The feature id for the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__GRAMMARS = VOICE_DSL__GRAMMARS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__OUTPUTS = VOICE_DSL__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__DESTINATION = VOICE_DSL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Audio Transfer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__AUDIO_TRANSFER = VOICE_DSL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__MAX_TIME = VOICE_DSL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__TIMEOUT = VOICE_DSL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type Transfer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL__TYPE_TRANSFER = VOICE_DSL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transfer Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL_FEATURE_COUNT = VOICE_DSL_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Transfer Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DSL_OPERATION_COUNT = VOICE_DSL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Interpretation <em>Interpretation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Interpretation
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getInterpretation()
	 * @generated
	 */
	int INTERPRETATION = 17;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TypeTransfer <em>Type Transfer</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.TypeTransfer
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getTypeTransfer()
	 * @generated
	 */
	int TYPE_TRANSFER = 18;


	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl <em>Voice Dsl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Voice Dsl</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl
	 * @generated
	 */
	EClass getVoiceDsl();

	/**
	 * Returns the meta object for the containment reference '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getConfiguration()
	 * @see #getVoiceDsl()
	 * @generated
	 */
	EReference getVoiceDsl_Configuration();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getConditions()
	 * @see #getVoiceDsl()
	 * @generated
	 */
	EReference getVoiceDsl_Conditions();

	/**
	 * Returns the meta object for the containment reference '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getAudios <em>Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Audios</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getAudios()
	 * @see #getVoiceDsl()
	 * @generated
	 */
	EReference getVoiceDsl_Audios();

	/**
	 * Returns the meta object for the containment reference '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getGrammars <em>Grammars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Grammars</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getGrammars()
	 * @see #getVoiceDsl()
	 * @generated
	 */
	EReference getVoiceDsl_Grammars();

	/**
	 * Returns the meta object for the containment reference '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Outputs</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getOutputs()
	 * @see #getVoiceDsl()
	 * @generated
	 */
	EReference getVoiceDsl_Outputs();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Configuration#getConfigValue <em>Config Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Config Value</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Configuration#getConfigValue()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_ConfigValue();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Configuration#getValue(java.lang.String) <em>Get Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Value</em>' operation.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Configuration#getValue(java.lang.String)
	 * @generated
	 */
	EOperation getConfiguration__GetValue__String();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConfigValue <em>Config Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Value</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.ConfigValue
	 * @generated
	 */
	EClass getConfigValue();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConfigValue#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.ConfigValue#getName()
	 * @see #getConfigValue()
	 * @generated
	 */
	EAttribute getConfigValue_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConfigValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.ConfigValue#getValue()
	 * @see #getConfigValue()
	 * @generated
	 */
	EAttribute getConfigValue_Value();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar <em>Grammar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar
	 * @generated
	 */
	EClass getGrammar();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar#getMode()
	 * @see #getGrammar()
	 * @generated
	 */
	EAttribute getGrammar_Mode();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar#getSrc()
	 * @see #getGrammar()
	 * @generated
	 */
	EAttribute getGrammar_Src();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar#isExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expr</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar#isExpr()
	 * @see #getGrammar()
	 * @generated
	 */
	EAttribute getGrammar_Expr();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Condition#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Condition#getCondition()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Condition();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Condition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Condition#getName()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Name();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audios <em>Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Audios</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audios
	 * @generated
	 */
	EClass getAudios();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getMainAudios <em>Main Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Main Audios</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getMainAudios()
	 * @see #getAudios()
	 * @generated
	 */
	EReference getAudios_MainAudios();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getNoMatchAudios <em>No Match Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>No Match Audios</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getNoMatchAudios()
	 * @see #getAudios()
	 * @generated
	 */
	EReference getAudios_NoMatchAudios();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getNoInputAudios <em>No Input Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>No Input Audios</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getNoInputAudios()
	 * @see #getAudios()
	 * @generated
	 */
	EReference getAudios_NoInputAudios();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getMatchAudios <em>Match Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Match Audios</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getMatchAudios()
	 * @see #getAudios()
	 * @generated
	 */
	EReference getAudios_MatchAudios();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio <em>Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Audio</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audio
	 * @generated
	 */
	EClass getAudio();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#isDontBargeIn <em>Dont Barge In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dont Barge In</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#isDontBargeIn()
	 * @see #getAudio()
	 * @generated
	 */
	EAttribute getAudio_DontBargeIn();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getTts <em>Tts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tts</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getTts()
	 * @see #getAudio()
	 * @generated
	 */
	EAttribute getAudio_Tts();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getSrc()
	 * @see #getAudio()
	 * @generated
	 */
	EAttribute getAudio_Src();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getInterpretation <em>Interpretation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interpretation</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getInterpretation()
	 * @see #getAudio()
	 * @generated
	 */
	EAttribute getAudio_Interpretation();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getFormat()
	 * @see #getAudio()
	 * @generated
	 */
	EAttribute getAudio_Format();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio <em>Conditional Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Audio</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio
	 * @generated
	 */
	EClass getConditionalAudio();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getSimpleAudios <em>Simple Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Simple Audios</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getSimpleAudios()
	 * @see #getConditionalAudio()
	 * @generated
	 */
	EReference getConditionalAudio_SimpleAudios();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getCondit <em>Condit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condit</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getCondit()
	 * @see #getConditionalAudio()
	 * @generated
	 */
	EAttribute getConditionalAudio_Condit();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.OutputValue <em>Output Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Value</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.OutputValue
	 * @generated
	 */
	EClass getOutputValue();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.OutputValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.OutputValue#getValue()
	 * @see #getOutputValue()
	 * @generated
	 */
	EAttribute getOutputValue_Value();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outputs</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs
	 * @generated
	 */
	EClass getOutputs();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs#getOutput()
	 * @see #getOutputs()
	 * @generated
	 */
	EReference getOutputs_Output();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Grammars <em>Grammars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammars</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Grammars
	 * @generated
	 */
	EClass getGrammars();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Grammars#getGrammatics <em>Grammatics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Grammatics</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Grammars#getGrammatics()
	 * @see #getGrammars()
	 * @generated
	 */
	EReference getGrammars_Grammatics();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Output
	 * @generated
	 */
	EClass getOutput();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Output#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Output#getName()
	 * @see #getOutput()
	 * @generated
	 */
	EAttribute getOutput_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Output#getOutputValue <em>Output Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Value</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Output#getOutputValue()
	 * @see #getOutput()
	 * @generated
	 */
	EReference getOutput_OutputValue();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl <em>Input Dsl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Dsl</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl
	 * @generated
	 */
	EClass getInputDsl();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl <em>Menu Dsl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Dsl</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl
	 * @generated
	 */
	EClass getMenuDsl();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl <em>Prompt Dsl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prompt Dsl</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl
	 * @generated
	 */
	EClass getPromptDsl();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl <em>Record Dsl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record Dsl</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl
	 * @generated
	 */
	EClass getRecordDsl();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl#getFileName()
	 * @see #getRecordDsl()
	 * @generated
	 */
	EAttribute getRecordDsl_FileName();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl <em>Transfer Dsl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transfer Dsl</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl
	 * @generated
	 */
	EClass getTransferDsl();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getDestination()
	 * @see #getTransferDsl()
	 * @generated
	 */
	EAttribute getTransferDsl_Destination();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getAudioTransfer <em>Audio Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Audio Transfer</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getAudioTransfer()
	 * @see #getTransferDsl()
	 * @generated
	 */
	EAttribute getTransferDsl_AudioTransfer();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getMaxTime <em>Max Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Time</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getMaxTime()
	 * @see #getTransferDsl()
	 * @generated
	 */
	EAttribute getTransferDsl_MaxTime();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timeout</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getTimeout()
	 * @see #getTransferDsl()
	 * @generated
	 */
	EAttribute getTransferDsl_Timeout();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getTypeTransfer <em>Type Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Transfer</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getTypeTransfer()
	 * @see #getTransferDsl()
	 * @generated
	 */
	EAttribute getTransferDsl_TypeTransfer();

	/**
	 * Returns the meta object for enum '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Interpretation <em>Interpretation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Interpretation</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Interpretation
	 * @generated
	 */
	EEnum getInterpretation();

	/**
	 * Returns the meta object for enum '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TypeTransfer <em>Type Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Transfer</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.TypeTransfer
	 * @generated
	 */
	EEnum getTypeTransfer();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VoiceDslFactory getVoiceDslFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl <em>Voice Dsl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getVoiceDsl()
		 * @generated
		 */
		EClass VOICE_DSL = eINSTANCE.getVoiceDsl();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOICE_DSL__CONFIGURATION = eINSTANCE.getVoiceDsl_Configuration();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOICE_DSL__CONDITIONS = eINSTANCE.getVoiceDsl_Conditions();

		/**
		 * The meta object literal for the '<em><b>Audios</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOICE_DSL__AUDIOS = eINSTANCE.getVoiceDsl_Audios();

		/**
		 * The meta object literal for the '<em><b>Grammars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOICE_DSL__GRAMMARS = eINSTANCE.getVoiceDsl_Grammars();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOICE_DSL__OUTPUTS = eINSTANCE.getVoiceDsl_Outputs();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConfigurationImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Config Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__CONFIG_VALUE = eINSTANCE.getConfiguration_ConfigValue();

		/**
		 * The meta object literal for the '<em><b>Get Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONFIGURATION___GET_VALUE__STRING = eINSTANCE.getConfiguration__GetValue__String();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConfigValueImpl <em>Config Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConfigValueImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getConfigValue()
		 * @generated
		 */
		EClass CONFIG_VALUE = eINSTANCE.getConfigValue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG_VALUE__NAME = eINSTANCE.getConfigValue_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG_VALUE__VALUE = eINSTANCE.getConfigValue_Value();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.GrammarImpl <em>Grammar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.GrammarImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getGrammar()
		 * @generated
		 */
		EClass GRAMMAR = eINSTANCE.getGrammar();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR__MODE = eINSTANCE.getGrammar_Mode();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR__SRC = eINSTANCE.getGrammar_Src();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR__EXPR = eINSTANCE.getGrammar_Expr();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__CONDITION = eINSTANCE.getCondition_Condition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__NAME = eINSTANCE.getCondition_Name();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudiosImpl <em>Audios</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudiosImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getAudios()
		 * @generated
		 */
		EClass AUDIOS = eINSTANCE.getAudios();

		/**
		 * The meta object literal for the '<em><b>Main Audios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUDIOS__MAIN_AUDIOS = eINSTANCE.getAudios_MainAudios();

		/**
		 * The meta object literal for the '<em><b>No Match Audios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUDIOS__NO_MATCH_AUDIOS = eINSTANCE.getAudios_NoMatchAudios();

		/**
		 * The meta object literal for the '<em><b>No Input Audios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUDIOS__NO_INPUT_AUDIOS = eINSTANCE.getAudios_NoInputAudios();

		/**
		 * The meta object literal for the '<em><b>Match Audios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUDIOS__MATCH_AUDIOS = eINSTANCE.getAudios_MatchAudios();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudioImpl <em>Audio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudioImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getAudio()
		 * @generated
		 */
		EClass AUDIO = eINSTANCE.getAudio();

		/**
		 * The meta object literal for the '<em><b>Dont Barge In</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO__DONT_BARGE_IN = eINSTANCE.getAudio_DontBargeIn();

		/**
		 * The meta object literal for the '<em><b>Tts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO__TTS = eINSTANCE.getAudio_Tts();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO__SRC = eINSTANCE.getAudio_Src();

		/**
		 * The meta object literal for the '<em><b>Interpretation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO__INTERPRETATION = eINSTANCE.getAudio_Interpretation();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUDIO__FORMAT = eINSTANCE.getAudio_Format();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionalAudioImpl <em>Conditional Audio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionalAudioImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getConditionalAudio()
		 * @generated
		 */
		EClass CONDITIONAL_AUDIO = eINSTANCE.getConditionalAudio();

		/**
		 * The meta object literal for the '<em><b>Simple Audios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_AUDIO__SIMPLE_AUDIOS = eINSTANCE.getConditionalAudio_SimpleAudios();

		/**
		 * The meta object literal for the '<em><b>Condit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_AUDIO__CONDIT = eINSTANCE.getConditionalAudio_Condit();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputValueImpl <em>Output Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputValueImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getOutputValue()
		 * @generated
		 */
		EClass OUTPUT_VALUE = eINSTANCE.getOutputValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT_VALUE__VALUE = eINSTANCE.getOutputValue_Value();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputsImpl <em>Outputs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputsImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getOutputs()
		 * @generated
		 */
		EClass OUTPUTS = eINSTANCE.getOutputs();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUTS__OUTPUT = eINSTANCE.getOutputs_Output();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.GrammarsImpl <em>Grammars</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.GrammarsImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getGrammars()
		 * @generated
		 */
		EClass GRAMMARS = eINSTANCE.getGrammars();

		/**
		 * The meta object literal for the '<em><b>Grammatics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAMMARS__GRAMMATICS = eINSTANCE.getGrammars_Grammatics();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputImpl <em>Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.OutputImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getOutput()
		 * @generated
		 */
		EClass OUTPUT = eINSTANCE.getOutput();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT__NAME = eINSTANCE.getOutput_Name();

		/**
		 * The meta object literal for the '<em><b>Output Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT__OUTPUT_VALUE = eINSTANCE.getOutput_OutputValue();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.InputDslImpl <em>Input Dsl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.InputDslImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getInputDsl()
		 * @generated
		 */
		EClass INPUT_DSL = eINSTANCE.getInputDsl();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.MenuDslImpl <em>Menu Dsl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.MenuDslImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getMenuDsl()
		 * @generated
		 */
		EClass MENU_DSL = eINSTANCE.getMenuDsl();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.PromptDslImpl <em>Prompt Dsl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.PromptDslImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getPromptDsl()
		 * @generated
		 */
		EClass PROMPT_DSL = eINSTANCE.getPromptDsl();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.RecordDslImpl <em>Record Dsl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.RecordDslImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getRecordDsl()
		 * @generated
		 */
		EClass RECORD_DSL = eINSTANCE.getRecordDsl();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD_DSL__FILE_NAME = eINSTANCE.getRecordDsl_FileName();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.TransferDslImpl <em>Transfer Dsl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.TransferDslImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getTransferDsl()
		 * @generated
		 */
		EClass TRANSFER_DSL = eINSTANCE.getTransferDsl();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER_DSL__DESTINATION = eINSTANCE.getTransferDsl_Destination();

		/**
		 * The meta object literal for the '<em><b>Audio Transfer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER_DSL__AUDIO_TRANSFER = eINSTANCE.getTransferDsl_AudioTransfer();

		/**
		 * The meta object literal for the '<em><b>Max Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER_DSL__MAX_TIME = eINSTANCE.getTransferDsl_MaxTime();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER_DSL__TIMEOUT = eINSTANCE.getTransferDsl_Timeout();

		/**
		 * The meta object literal for the '<em><b>Type Transfer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFER_DSL__TYPE_TRANSFER = eINSTANCE.getTransferDsl_TypeTransfer();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Interpretation <em>Interpretation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Interpretation
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getInterpretation()
		 * @generated
		 */
		EEnum INTERPRETATION = eINSTANCE.getInterpretation();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TypeTransfer <em>Type Transfer</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.TypeTransfer
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getTypeTransfer()
		 * @generated
		 */
		EEnum TYPE_TRANSFER = eINSTANCE.getTypeTransfer();

	}

} //VoiceDslPackage
