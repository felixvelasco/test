/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl.util;

import com.isb.bks.ivr.voice.dsl.voiceDsl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage
 * @generated
 */
public class VoiceDslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static VoiceDslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VoiceDslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = VoiceDslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VoiceDslSwitch<Adapter> modelSwitch =
    new VoiceDslSwitch<Adapter>()
    {
      @Override
      public Adapter caseInputElement(InputElement object)
      {
        return createInputElementAdapter();
      }
      @Override
      public Adapter caseGrammar(Grammar object)
      {
        return createGrammarAdapter();
      }
      @Override
      public Adapter caseConfiguration(Configuration object)
      {
        return createConfigurationAdapter();
      }
      @Override
      public Adapter caseAudios(Audios object)
      {
        return createAudiosAdapter();
      }
      @Override
      public Adapter caseNoInput(NoInput object)
      {
        return createNoInputAdapter();
      }
      @Override
      public Adapter caseNoMatch(NoMatch object)
      {
        return createNoMatchAdapter();
      }
      @Override
      public Adapter caseMatch(Match object)
      {
        return createMatchAdapter();
      }
      @Override
      public Adapter caseInitial(Initial object)
      {
        return createInitialAdapter();
      }
      @Override
      public Adapter caseAudio(Audio object)
      {
        return createAudioAdapter();
      }
      @Override
      public Adapter caseCondition(Condition object)
      {
        return createConditionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement <em>Input Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement
   * @generated
   */
  public Adapter createInputElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar <em>Grammar</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar
   * @generated
   */
  public Adapter createGrammarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration <em>Configuration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration
   * @generated
   */
  public Adapter createConfigurationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios <em>Audios</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audios
   * @generated
   */
  public Adapter createAudiosAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.NoInput <em>No Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.NoInput
   * @generated
   */
  public Adapter createNoInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.NoMatch <em>No Match</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.NoMatch
   * @generated
   */
  public Adapter createNoMatchAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Match <em>Match</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Match
   * @generated
   */
  public Adapter createMatchAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Initial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Initial
   * @generated
   */
  public Adapter createInitialAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio <em>Audio</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Audio
   * @generated
   */
  public Adapter createAudioAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Condition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.Condition
   * @generated
   */
  public Adapter createConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //VoiceDslAdapterFactory
