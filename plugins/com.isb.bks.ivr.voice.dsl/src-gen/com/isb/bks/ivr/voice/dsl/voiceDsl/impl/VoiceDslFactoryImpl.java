/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl.impl;

import com.isb.bks.ivr.voice.dsl.voiceDsl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VoiceDslFactoryImpl extends EFactoryImpl implements VoiceDslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VoiceDslFactory init()
  {
    try
    {
      VoiceDslFactory theVoiceDslFactory = (VoiceDslFactory)EPackage.Registry.INSTANCE.getEFactory(VoiceDslPackage.eNS_URI);
      if (theVoiceDslFactory != null)
      {
        return theVoiceDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new VoiceDslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VoiceDslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case VoiceDslPackage.INPUT_ELEMENT: return createInputElement();
      case VoiceDslPackage.GRAMMAR: return createGrammar();
      case VoiceDslPackage.CONFIGURATION: return createConfiguration();
      case VoiceDslPackage.AUDIOS: return createAudios();
      case VoiceDslPackage.NO_INPUT: return createNoInput();
      case VoiceDslPackage.NO_MATCH: return createNoMatch();
      case VoiceDslPackage.MATCH: return createMatch();
      case VoiceDslPackage.INITIAL: return createInitial();
      case VoiceDslPackage.AUDIO: return createAudio();
      case VoiceDslPackage.CONDITION: return createCondition();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputElement createInputElement()
  {
    InputElementImpl inputElement = new InputElementImpl();
    return inputElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Grammar createGrammar()
  {
    GrammarImpl grammar = new GrammarImpl();
    return grammar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Configuration createConfiguration()
  {
    ConfigurationImpl configuration = new ConfigurationImpl();
    return configuration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Audios createAudios()
  {
    AudiosImpl audios = new AudiosImpl();
    return audios;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NoInput createNoInput()
  {
    NoInputImpl noInput = new NoInputImpl();
    return noInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NoMatch createNoMatch()
  {
    NoMatchImpl noMatch = new NoMatchImpl();
    return noMatch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Match createMatch()
  {
    MatchImpl match = new MatchImpl();
    return match;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Initial createInitial()
  {
    InitialImpl initial = new InitialImpl();
    return initial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Audio createAudio()
  {
    AudioImpl audio = new AudioImpl();
    return audio;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Condition createCondition()
  {
    ConditionImpl condition = new ConditionImpl();
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VoiceDslPackage getVoiceDslPackage()
  {
    return (VoiceDslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static VoiceDslPackage getPackage()
  {
    return VoiceDslPackage.eINSTANCE;
  }

} //VoiceDslFactoryImpl
