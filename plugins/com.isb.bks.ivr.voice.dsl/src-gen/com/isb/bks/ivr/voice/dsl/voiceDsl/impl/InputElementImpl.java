/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl.impl;

import com.isb.bks.ivr.voice.dsl.voiceDsl.Audios;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar;
import com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement;
import com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getGrammatics <em>Grammatics</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getAudios <em>Audios</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputElementImpl extends MinimalEObjectImpl.Container implements InputElement
{
  /**
   * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConfiguration()
   * @generated
   * @ordered
   */
  protected Configuration configuration;

  /**
   * The cached value of the '{@link #getGrammatics() <em>Grammatics</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGrammatics()
   * @generated
   * @ordered
   */
  protected Grammar grammatics;

  /**
   * The cached value of the '{@link #getAudios() <em>Audios</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAudios()
   * @generated
   * @ordered
   */
  protected Audios audios;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InputElementImpl()
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
    return VoiceDslPackage.Literals.INPUT_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Configuration getConfiguration()
  {
    return configuration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConfiguration(Configuration newConfiguration, NotificationChain msgs)
  {
    Configuration oldConfiguration = configuration;
    configuration = newConfiguration;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__CONFIGURATION, oldConfiguration, newConfiguration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConfiguration(Configuration newConfiguration)
  {
    if (newConfiguration != configuration)
    {
      NotificationChain msgs = null;
      if (configuration != null)
        msgs = ((InternalEObject)configuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.INPUT_ELEMENT__CONFIGURATION, null, msgs);
      if (newConfiguration != null)
        msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.INPUT_ELEMENT__CONFIGURATION, null, msgs);
      msgs = basicSetConfiguration(newConfiguration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__CONFIGURATION, newConfiguration, newConfiguration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Grammar getGrammatics()
  {
    return grammatics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGrammatics(Grammar newGrammatics, NotificationChain msgs)
  {
    Grammar oldGrammatics = grammatics;
    grammatics = newGrammatics;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS, oldGrammatics, newGrammatics);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGrammatics(Grammar newGrammatics)
  {
    if (newGrammatics != grammatics)
    {
      NotificationChain msgs = null;
      if (grammatics != null)
        msgs = ((InternalEObject)grammatics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS, null, msgs);
      if (newGrammatics != null)
        msgs = ((InternalEObject)newGrammatics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS, null, msgs);
      msgs = basicSetGrammatics(newGrammatics, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS, newGrammatics, newGrammatics));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Audios getAudios()
  {
    return audios;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAudios(Audios newAudios, NotificationChain msgs)
  {
    Audios oldAudios = audios;
    audios = newAudios;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__AUDIOS, oldAudios, newAudios);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAudios(Audios newAudios)
  {
    if (newAudios != audios)
    {
      NotificationChain msgs = null;
      if (audios != null)
        msgs = ((InternalEObject)audios).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.INPUT_ELEMENT__AUDIOS, null, msgs);
      if (newAudios != null)
        msgs = ((InternalEObject)newAudios).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.INPUT_ELEMENT__AUDIOS, null, msgs);
      msgs = basicSetAudios(newAudios, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__AUDIOS, newAudios, newAudios));
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
      case VoiceDslPackage.INPUT_ELEMENT__CONFIGURATION:
        return basicSetConfiguration(null, msgs);
      case VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS:
        return basicSetGrammatics(null, msgs);
      case VoiceDslPackage.INPUT_ELEMENT__AUDIOS:
        return basicSetAudios(null, msgs);
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
      case VoiceDslPackage.INPUT_ELEMENT__CONFIGURATION:
        return getConfiguration();
      case VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS:
        return getGrammatics();
      case VoiceDslPackage.INPUT_ELEMENT__AUDIOS:
        return getAudios();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VoiceDslPackage.INPUT_ELEMENT__CONFIGURATION:
        setConfiguration((Configuration)newValue);
        return;
      case VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS:
        setGrammatics((Grammar)newValue);
        return;
      case VoiceDslPackage.INPUT_ELEMENT__AUDIOS:
        setAudios((Audios)newValue);
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
      case VoiceDslPackage.INPUT_ELEMENT__CONFIGURATION:
        setConfiguration((Configuration)null);
        return;
      case VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS:
        setGrammatics((Grammar)null);
        return;
      case VoiceDslPackage.INPUT_ELEMENT__AUDIOS:
        setAudios((Audios)null);
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
      case VoiceDslPackage.INPUT_ELEMENT__CONFIGURATION:
        return configuration != null;
      case VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS:
        return grammatics != null;
      case VoiceDslPackage.INPUT_ELEMENT__AUDIOS:
        return audios != null;
    }
    return super.eIsSet(featureID);
  }

} //InputElementImpl
