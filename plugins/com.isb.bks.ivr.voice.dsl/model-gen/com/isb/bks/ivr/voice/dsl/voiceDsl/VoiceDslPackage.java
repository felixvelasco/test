/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslFactory
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
	VoiceDslPackage eINSTANCE = com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl <em>Input Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getInputElement()
	 * @generated
	 */
	int INPUT_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Grammatics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ELEMENT__GRAMMATICS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Max No Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ELEMENT__MAX_NO_INPUT = 2;

	/**
	 * The feature id for the '<em><b>Max No Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ELEMENT__MAX_NO_MATCH = 3;

	/**
	 * The feature id for the '<em><b>Max Attempts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ELEMENT__MAX_ATTEMPTS = 4;

	/**
	 * The feature id for the '<em><b>Initial Audios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ELEMENT__INITIAL_AUDIOS = 5;

	/**
	 * The feature id for the '<em><b>No Match Audios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ELEMENT__NO_MATCH_AUDIOS = 6;

	/**
	 * The feature id for the '<em><b>No Input Audios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ELEMENT__NO_INPUT_AUDIOS = 7;

	/**
	 * The feature id for the '<em><b>Match Audios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ELEMENT__MATCH_AUDIOS = 8;

	/**
	 * The number of structural features of the '<em>Input Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ELEMENT_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.GrammarImpl <em>Grammar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.GrammarImpl
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getGrammar()
	 * @generated
	 */
	int GRAMMAR = 1;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR__MODE = 0;

	/**
	 * The feature id for the '<em><b>Builtin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR__BUILTIN = 1;

	/**
	 * The feature id for the '<em><b>Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR__SRC = 2;

	/**
	 * The number of structural features of the '<em>Grammar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMAR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudioImpl <em>Audio</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudioImpl
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getAudio()
	 * @generated
	 */
	int AUDIO = 2;

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
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO__CONDITION = 3;

	/**
	 * The number of structural features of the '<em>Audio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUDIO_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConditionImpl
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 3;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__COUNT = 0;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement <em>Input Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Element</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement
	 * @generated
	 */
	EClass getInputElement();

	/**
	 * Returns the meta object for the containment reference '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getGrammatics <em>Grammatics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Grammatics</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getGrammatics()
	 * @see #getInputElement()
	 * @generated
	 */
	EReference getInputElement_Grammatics();

	/**
	 * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getName()
	 * @see #getInputElement()
	 * @generated
	 */
	EAttribute getInputElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxNoInput <em>Max No Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max No Input</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxNoInput()
	 * @see #getInputElement()
	 * @generated
	 */
	EAttribute getInputElement_MaxNoInput();

	/**
	 * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxNoMatch <em>Max No Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max No Match</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxNoMatch()
	 * @see #getInputElement()
	 * @generated
	 */
	EAttribute getInputElement_MaxNoMatch();

	/**
	 * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxAttempts <em>Max Attempts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Attempts</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxAttempts()
	 * @see #getInputElement()
	 * @generated
	 */
	EAttribute getInputElement_MaxAttempts();

	/**
	 * Returns the meta object for the containment reference list '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getInitialAudios <em>Initial Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Initial Audios</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getInitialAudios()
	 * @see #getInputElement()
	 * @generated
	 */
	EReference getInputElement_InitialAudios();

	/**
	 * Returns the meta object for the containment reference list '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getNoMatchAudios <em>No Match Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>No Match Audios</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getNoMatchAudios()
	 * @see #getInputElement()
	 * @generated
	 */
	EReference getInputElement_NoMatchAudios();

	/**
	 * Returns the meta object for the containment reference list '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getNoInputAudios <em>No Input Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>No Input Audios</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getNoInputAudios()
	 * @see #getInputElement()
	 * @generated
	 */
	EReference getInputElement_NoInputAudios();

	/**
	 * Returns the meta object for the containment reference list '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMatchAudios <em>Match Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Match Audios</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMatchAudios()
	 * @see #getInputElement()
	 * @generated
	 */
	EReference getInputElement_MatchAudios();

	/**
	 * Returns the meta object for class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar <em>Grammar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammar</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar
	 * @generated
	 */
	EClass getGrammar();

	/**
	 * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#getMode()
	 * @see #getGrammar()
	 * @generated
	 */
	EAttribute getGrammar_Mode();

	/**
	 * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#isBuiltin <em>Builtin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Builtin</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#isBuiltin()
	 * @see #getGrammar()
	 * @generated
	 */
	EAttribute getGrammar_Builtin();

	/**
	 * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#getSrc()
	 * @see #getGrammar()
	 * @generated
	 */
	EAttribute getGrammar_Src();

	/**
	 * Returns the meta object for class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio <em>Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Audio</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audio
	 * @generated
	 */
	EClass getAudio();

	/**
	 * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#isDontBargeIn <em>Dont Barge In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dont Barge In</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#isDontBargeIn()
	 * @see #getAudio()
	 * @generated
	 */
	EAttribute getAudio_DontBargeIn();

	/**
	 * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getTts <em>Tts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tts</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getTts()
	 * @see #getAudio()
	 * @generated
	 */
	EAttribute getAudio_Tts();

	/**
	 * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getSrc()
	 * @see #getAudio()
	 * @generated
	 */
	EAttribute getAudio_Src();

	/**
	 * Returns the meta object for the containment reference '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getCondition()
	 * @see #getAudio()
	 * @generated
	 */
	EReference getAudio_Condition();

	/**
	 * Returns the meta object for class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Condition#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Condition#getCount()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Count();

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
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl <em>Input Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl
		 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getInputElement()
		 * @generated
		 */
		EClass INPUT_ELEMENT = eINSTANCE.getInputElement();

		/**
		 * The meta object literal for the '<em><b>Grammatics</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_ELEMENT__GRAMMATICS = eINSTANCE.getInputElement_Grammatics();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_ELEMENT__NAME = eINSTANCE.getInputElement_Name();

		/**
		 * The meta object literal for the '<em><b>Max No Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_ELEMENT__MAX_NO_INPUT = eINSTANCE.getInputElement_MaxNoInput();

		/**
		 * The meta object literal for the '<em><b>Max No Match</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_ELEMENT__MAX_NO_MATCH = eINSTANCE.getInputElement_MaxNoMatch();

		/**
		 * The meta object literal for the '<em><b>Max Attempts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_ELEMENT__MAX_ATTEMPTS = eINSTANCE.getInputElement_MaxAttempts();

		/**
		 * The meta object literal for the '<em><b>Initial Audios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_ELEMENT__INITIAL_AUDIOS = eINSTANCE.getInputElement_InitialAudios();

		/**
		 * The meta object literal for the '<em><b>No Match Audios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_ELEMENT__NO_MATCH_AUDIOS = eINSTANCE.getInputElement_NoMatchAudios();

		/**
		 * The meta object literal for the '<em><b>No Input Audios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_ELEMENT__NO_INPUT_AUDIOS = eINSTANCE.getInputElement_NoInputAudios();

		/**
		 * The meta object literal for the '<em><b>Match Audios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_ELEMENT__MATCH_AUDIOS = eINSTANCE.getInputElement_MatchAudios();

		/**
		 * The meta object literal for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.GrammarImpl <em>Grammar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.GrammarImpl
		 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getGrammar()
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
		 * The meta object literal for the '<em><b>Builtin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR__BUILTIN = eINSTANCE.getGrammar_Builtin();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMAR__SRC = eINSTANCE.getGrammar_Src();

		/**
		 * The meta object literal for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudioImpl <em>Audio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudioImpl
		 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getAudio()
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
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUDIO__CONDITION = eINSTANCE.getAudio_Condition();

		/**
		 * The meta object literal for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConditionImpl
		 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__COUNT = eINSTANCE.getCondition_Count();

	}

} //VoiceDslPackage
