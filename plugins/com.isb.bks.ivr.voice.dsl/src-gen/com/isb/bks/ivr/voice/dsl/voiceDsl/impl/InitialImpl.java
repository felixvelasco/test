/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl.impl;

import com.isb.bks.ivr.voice.dsl.voiceDsl.Audio;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Initial;
import com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Initial</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InitialImpl#getAudio <em>Audio</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InitialImpl extends MinimalEObjectImpl.Container implements Initial
{
  /**
   * The cached value of the '{@link #getAudio() <em>Audio</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAudio()
   * @generated
   * @ordered
   */
  protected EList<Audio> audio;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InitialImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return VoiceDslPackage.Literals.INITIAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Audio> getAudio()
  {
    if (audio == null)
    {
      audio = new EObjectContainmentEList<Audio>(Audio.class, this, VoiceDslPackage.INITIAL__AUDIO);
    }
    return audio;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case VoiceDslPackage.INITIAL__AUDIO:
        return ((InternalEList<?>)getAudio()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case VoiceDslPackage.INITIAL__AUDIO:
        return getAudio();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VoiceDslPackage.INITIAL__AUDIO:
        getAudio().clear();
        getAudio().addAll((Collection<? extends Audio>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case VoiceDslPackage.INITIAL__AUDIO:
        getAudio().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case VoiceDslPackage.INITIAL__AUDIO:
        return audio != null && !audio.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InitialImpl
