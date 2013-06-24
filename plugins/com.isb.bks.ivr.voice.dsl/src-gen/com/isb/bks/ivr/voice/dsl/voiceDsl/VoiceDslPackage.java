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
public interface VoiceDslPackage extends EPackage
{
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
  String eNS_URI = "http://www.isb.com/bks/ivr/voice/dsl/VoiceDsl";

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
   * The feature id for the '<em><b>Configuration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_ELEMENT__CONFIGURATION = 0;

  /**
   * The feature id for the '<em><b>Grammatics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_ELEMENT__GRAMMATICS = 1;

  /**
   * The feature id for the '<em><b>Audios</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_ELEMENT__AUDIOS = 2;

  /**
   * The number of structural features of the '<em>Input Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_ELEMENT_FEATURE_COUNT = 3;

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
   * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConfigurationImpl <em>Configuration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConfigurationImpl
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getConfiguration()
   * @generated
   */
  int CONFIGURATION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIGURATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Max No Input</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIGURATION__MAX_NO_INPUT = 1;

  /**
   * The feature id for the '<em><b>Max No MAtch</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIGURATION__MAX_NO_MATCH = 2;

  /**
   * The feature id for the '<em><b>Max Attempts</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIGURATION__MAX_ATTEMPTS = 3;

  /**
   * The number of structural features of the '<em>Configuration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIGURATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudiosImpl <em>Audios</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudiosImpl
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getAudios()
   * @generated
   */
  int AUDIOS = 3;

  /**
   * The feature id for the '<em><b>Initial</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUDIOS__INITIAL = 0;

  /**
   * The feature id for the '<em><b>No Match</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUDIOS__NO_MATCH = 1;

  /**
   * The feature id for the '<em><b>No Input</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUDIOS__NO_INPUT = 2;

  /**
   * The feature id for the '<em><b>Match</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUDIOS__MATCH = 3;

  /**
   * The number of structural features of the '<em>Audios</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUDIOS_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.NoInputImpl <em>No Input</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.NoInputImpl
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getNoInput()
   * @generated
   */
  int NO_INPUT = 4;

  /**
   * The feature id for the '<em><b>Audio</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NO_INPUT__AUDIO = 0;

  /**
   * The number of structural features of the '<em>No Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NO_INPUT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.NoMatchImpl <em>No Match</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.NoMatchImpl
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getNoMatch()
   * @generated
   */
  int NO_MATCH = 5;

  /**
   * The feature id for the '<em><b>Audio</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NO_MATCH__AUDIO = 0;

  /**
   * The number of structural features of the '<em>No Match</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NO_MATCH_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.MatchImpl <em>Match</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.MatchImpl
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getMatch()
   * @generated
   */
  int MATCH = 6;

  /**
   * The feature id for the '<em><b>Audio</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATCH__AUDIO = 0;

  /**
   * The number of structural features of the '<em>Match</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATCH_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InitialImpl <em>Initial</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InitialImpl
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getInitial()
   * @generated
   */
  int INITIAL = 7;

  /**
   * The feature id for the '<em><b>Audio</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL__AUDIO = 0;

  /**
   * The number of structural features of the '<em>Initial</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INITIAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudioImpl <em>Audio</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudioImpl
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getAudio()
   * @generated
   */
  int AUDIO = 8;

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
   * The feature id for the '<em><b>Audio</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUDIO__AUDIO = 4;

  /**
   * The number of structural features of the '<em>Audio</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUDIO_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConditionImpl <em>Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConditionImpl
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getCondition()
   * @generated
   */
  int CONDITION = 9;

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
   * Returns the meta object for the containment reference '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getConfiguration <em>Configuration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Configuration</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getConfiguration()
   * @see #getInputElement()
   * @generated
   */
  EReference getInputElement_Configuration();

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
   * Returns the meta object for the containment reference '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getAudios <em>Audios</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Audios</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getAudios()
   * @see #getInputElement()
   * @generated
   */
  EReference getInputElement_Audios();

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
   * Returns the meta object for class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration <em>Configuration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Configuration</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration
   * @generated
   */
  EClass getConfiguration();

  /**
   * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getName()
   * @see #getConfiguration()
   * @generated
   */
  EAttribute getConfiguration_Name();

  /**
   * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxNoInput <em>Max No Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Max No Input</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxNoInput()
   * @see #getConfiguration()
   * @generated
   */
  EAttribute getConfiguration_MaxNoInput();

  /**
   * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxNoMAtch <em>Max No MAtch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Max No MAtch</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxNoMAtch()
   * @see #getConfiguration()
   * @generated
   */
  EAttribute getConfiguration_MaxNoMAtch();

  /**
   * Returns the meta object for the attribute '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxAttempts <em>Max Attempts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Max Attempts</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxAttempts()
   * @see #getConfiguration()
   * @generated
   */
  EAttribute getConfiguration_MaxAttempts();

  /**
   * Returns the meta object for class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios <em>Audios</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Audios</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audios
   * @generated
   */
  EClass getAudios();

  /**
   * Returns the meta object for the containment reference '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getInitial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initial</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getInitial()
   * @see #getAudios()
   * @generated
   */
  EReference getAudios_Initial();

  /**
   * Returns the meta object for the containment reference '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getNoMatch <em>No Match</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>No Match</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getNoMatch()
   * @see #getAudios()
   * @generated
   */
  EReference getAudios_NoMatch();

  /**
   * Returns the meta object for the containment reference '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getNoInput <em>No Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>No Input</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getNoInput()
   * @see #getAudios()
   * @generated
   */
  EReference getAudios_NoInput();

  /**
   * Returns the meta object for the containment reference '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getMatch <em>Match</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Match</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getMatch()
   * @see #getAudios()
   * @generated
   */
  EReference getAudios_Match();

  /**
   * Returns the meta object for class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.NoInput <em>No Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>No Input</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.NoInput
   * @generated
   */
  EClass getNoInput();

  /**
   * Returns the meta object for the containment reference list '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.NoInput#getAudio <em>Audio</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Audio</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.NoInput#getAudio()
   * @see #getNoInput()
   * @generated
   */
  EReference getNoInput_Audio();

  /**
   * Returns the meta object for class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.NoMatch <em>No Match</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>No Match</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.NoMatch
   * @generated
   */
  EClass getNoMatch();

  /**
   * Returns the meta object for the containment reference list '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.NoMatch#getAudio <em>Audio</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Audio</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.NoMatch#getAudio()
   * @see #getNoMatch()
   * @generated
   */
  EReference getNoMatch_Audio();

  /**
   * Returns the meta object for class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Match <em>Match</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Match</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Match
   * @generated
   */
  EClass getMatch();

  /**
   * Returns the meta object for the containment reference list '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Match#getAudio <em>Audio</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Audio</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Match#getAudio()
   * @see #getMatch()
   * @generated
   */
  EReference getMatch_Audio();

  /**
   * Returns the meta object for class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Initial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Initial</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Initial
   * @generated
   */
  EClass getInitial();

  /**
   * Returns the meta object for the containment reference list '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Initial#getAudio <em>Audio</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Audio</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Initial#getAudio()
   * @see #getInitial()
   * @generated
   */
  EReference getInitial_Audio();

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
   * Returns the meta object for the containment reference list '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getAudio <em>Audio</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Audio</em>'.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getAudio()
   * @see #getAudio()
   * @generated
   */
  EReference getAudio_Audio();

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
  interface Literals
  {
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
     * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_ELEMENT__CONFIGURATION = eINSTANCE.getInputElement_Configuration();

    /**
     * The meta object literal for the '<em><b>Grammatics</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_ELEMENT__GRAMMATICS = eINSTANCE.getInputElement_Grammatics();

    /**
     * The meta object literal for the '<em><b>Audios</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_ELEMENT__AUDIOS = eINSTANCE.getInputElement_Audios();

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
     * The meta object literal for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConfigurationImpl <em>Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConfigurationImpl
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getConfiguration()
     * @generated
     */
    EClass CONFIGURATION = eINSTANCE.getConfiguration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONFIGURATION__NAME = eINSTANCE.getConfiguration_Name();

    /**
     * The meta object literal for the '<em><b>Max No Input</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONFIGURATION__MAX_NO_INPUT = eINSTANCE.getConfiguration_MaxNoInput();

    /**
     * The meta object literal for the '<em><b>Max No MAtch</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONFIGURATION__MAX_NO_MATCH = eINSTANCE.getConfiguration_MaxNoMAtch();

    /**
     * The meta object literal for the '<em><b>Max Attempts</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONFIGURATION__MAX_ATTEMPTS = eINSTANCE.getConfiguration_MaxAttempts();

    /**
     * The meta object literal for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudiosImpl <em>Audios</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudiosImpl
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getAudios()
     * @generated
     */
    EClass AUDIOS = eINSTANCE.getAudios();

    /**
     * The meta object literal for the '<em><b>Initial</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUDIOS__INITIAL = eINSTANCE.getAudios_Initial();

    /**
     * The meta object literal for the '<em><b>No Match</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUDIOS__NO_MATCH = eINSTANCE.getAudios_NoMatch();

    /**
     * The meta object literal for the '<em><b>No Input</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUDIOS__NO_INPUT = eINSTANCE.getAudios_NoInput();

    /**
     * The meta object literal for the '<em><b>Match</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUDIOS__MATCH = eINSTANCE.getAudios_Match();

    /**
     * The meta object literal for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.NoInputImpl <em>No Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.NoInputImpl
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getNoInput()
     * @generated
     */
    EClass NO_INPUT = eINSTANCE.getNoInput();

    /**
     * The meta object literal for the '<em><b>Audio</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NO_INPUT__AUDIO = eINSTANCE.getNoInput_Audio();

    /**
     * The meta object literal for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.NoMatchImpl <em>No Match</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.NoMatchImpl
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getNoMatch()
     * @generated
     */
    EClass NO_MATCH = eINSTANCE.getNoMatch();

    /**
     * The meta object literal for the '<em><b>Audio</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NO_MATCH__AUDIO = eINSTANCE.getNoMatch_Audio();

    /**
     * The meta object literal for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.MatchImpl <em>Match</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.MatchImpl
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getMatch()
     * @generated
     */
    EClass MATCH = eINSTANCE.getMatch();

    /**
     * The meta object literal for the '<em><b>Audio</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATCH__AUDIO = eINSTANCE.getMatch_Audio();

    /**
     * The meta object literal for the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InitialImpl <em>Initial</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InitialImpl
     * @see com.isb.bks.ivr.voice.dsl.voiceDsl.impl.VoiceDslPackageImpl#getInitial()
     * @generated
     */
    EClass INITIAL = eINSTANCE.getInitial();

    /**
     * The meta object literal for the '<em><b>Audio</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INITIAL__AUDIO = eINSTANCE.getInitial_Audio();

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
     * The meta object literal for the '<em><b>Audio</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUDIO__AUDIO = eINSTANCE.getAudio_Audio();

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
