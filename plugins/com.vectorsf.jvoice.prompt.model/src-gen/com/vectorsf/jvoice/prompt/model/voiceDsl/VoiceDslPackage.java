/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__PROPERTIES = 2;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__CONDITIONS = 3;

	/**
	 * The feature id for the '<em><b>Audios</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__AUDIOS = 4;

	/**
	 * The feature id for the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__GRAMMARS = 5;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL__OUTPUTS = 6;

	/**
	 * The number of structural features of the '<em>Voice Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Voice Dsl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOICE_DSL_OPERATION_COUNT = 0;

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
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = 0;

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
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.PropertyImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionImpl
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 5;

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
	int AUDIOS = 6;

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
	int AUDIO = 7;

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
	 * The number of structural features of the '<em>Audio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_FEATURE_COUNT = 3;

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
	int CONDITIONAL_AUDIO = 8;

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
	 * The feature id for the '<em><b>Condit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_AUDIO__CONDIT = AUDIO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple A</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_AUDIO__SIMPLE_A = AUDIO_FEATURE_COUNT + 1;

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
	int OUTPUT_VALUE = 9;

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
	int OUTPUTS = 10;

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
	int GRAMMARS = 11;

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
	int OUTPUT = 12;

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
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl <em>Voice Dsl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Voice Dsl</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl
	 * @generated
	 */
	EClass getVoiceDsl();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getName()
	 * @see #getVoiceDsl()
	 * @generated
	 */
	EAttribute getVoiceDsl_Name();

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
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getProperties()
	 * @see #getVoiceDsl()
	 * @generated
	 */
	EReference getVoiceDsl_Properties();

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
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

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
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio <em>Conditional Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Audio</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio
	 * @generated
	 */
	EClass getConditionalAudio();

	/**
	 * Returns the meta object for the containment reference '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getCondit <em>Condit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condit</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getCondit()
	 * @see #getConditionalAudio()
	 * @generated
	 */
	EReference getConditionalAudio_Condit();

	/**
	 * Returns the meta object for the containment reference '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getSimpleA <em>Simple A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Simple A</em>'.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getSimpleA()
	 * @see #getConditionalAudio()
	 * @generated
	 */
	EReference getConditionalAudio_SimpleA();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOICE_DSL__NAME = eINSTANCE.getVoiceDsl_Name();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOICE_DSL__CONFIGURATION = eINSTANCE.getVoiceDsl_Configuration();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOICE_DSL__PROPERTIES = eINSTANCE.getVoiceDsl_Properties();

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
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.PropertyImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

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
		 * The meta object literal for the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionalAudioImpl <em>Conditional Audio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionalAudioImpl
		 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslPackageImpl#getConditionalAudio()
		 * @generated
		 */
		EClass CONDITIONAL_AUDIO = eINSTANCE.getConditionalAudio();

		/**
		 * The meta object literal for the '<em><b>Condit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_AUDIO__CONDIT = eINSTANCE.getConditionalAudio_Condit();

		/**
		 * The meta object literal for the '<em><b>Simple A</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_AUDIO__SIMPLE_A = eINSTANCE.getConditionalAudio_SimpleA();

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

	}

} //VoiceDslPackage
