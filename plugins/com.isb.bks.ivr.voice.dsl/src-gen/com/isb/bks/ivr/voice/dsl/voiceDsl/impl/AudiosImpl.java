/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl.impl;

import com.isb.bks.ivr.voice.dsl.voiceDsl.Audios;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Initial;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Match;
import com.isb.bks.ivr.voice.dsl.voiceDsl.NoInput;
import com.isb.bks.ivr.voice.dsl.voiceDsl.NoMatch;
import com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Audios</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudiosImpl#getInitial <em>Initial</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudiosImpl#getNoMatch <em>No Match</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudiosImpl#getNoInput <em>No Input</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.AudiosImpl#getMatch <em>Match</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AudiosImpl extends MinimalEObjectImpl.Container implements Audios
{
  /**
   * The cached value of the '{@link #getInitial() <em>Initial</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitial()
   * @generated
   * @ordered
   */
  protected Initial initial;

  /**
   * The cached value of the '{@link #getNoMatch() <em>No Match</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNoMatch()
   * @generated
   * @ordered
   */
  protected NoMatch noMatch;

  /**
   * The cached value of the '{@link #getNoInput() <em>No Input</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNoInput()
   * @generated
   * @ordered
   */
  protected NoInput noInput;

  /**
   * The cached value of the '{@link #getMatch() <em>Match</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMatch()
   * @generated
   * @ordered
   */
  protected Match match;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AudiosImpl()
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
    return VoiceDslPackage.Literals.AUDIOS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Initial getInitial()
  {
    return initial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitial(Initial newInitial, NotificationChain msgs)
  {
    Initial oldInitial = initial;
    initial = newInitial;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIOS__INITIAL, oldInitial, newInitial);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitial(Initial newInitial)
  {
    if (newInitial != initial)
    {
      NotificationChain msgs = null;
      if (initial != null)
        msgs = ((InternalEObject)initial).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.AUDIOS__INITIAL, null, msgs);
      if (newInitial != null)
        msgs = ((InternalEObject)newInitial).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.AUDIOS__INITIAL, null, msgs);
      msgs = basicSetInitial(newInitial, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIOS__INITIAL, newInitial, newInitial));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NoMatch getNoMatch()
  {
    return noMatch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNoMatch(NoMatch newNoMatch, NotificationChain msgs)
  {
    NoMatch oldNoMatch = noMatch;
    noMatch = newNoMatch;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIOS__NO_MATCH, oldNoMatch, newNoMatch);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNoMatch(NoMatch newNoMatch)
  {
    if (newNoMatch != noMatch)
    {
      NotificationChain msgs = null;
      if (noMatch != null)
        msgs = ((InternalEObject)noMatch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.AUDIOS__NO_MATCH, null, msgs);
      if (newNoMatch != null)
        msgs = ((InternalEObject)newNoMatch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.AUDIOS__NO_MATCH, null, msgs);
      msgs = basicSetNoMatch(newNoMatch, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIOS__NO_MATCH, newNoMatch, newNoMatch));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NoInput getNoInput()
  {
    return noInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNoInput(NoInput newNoInput, NotificationChain msgs)
  {
    NoInput oldNoInput = noInput;
    noInput = newNoInput;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIOS__NO_INPUT, oldNoInput, newNoInput);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNoInput(NoInput newNoInput)
  {
    if (newNoInput != noInput)
    {
      NotificationChain msgs = null;
      if (noInput != null)
        msgs = ((InternalEObject)noInput).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.AUDIOS__NO_INPUT, null, msgs);
      if (newNoInput != null)
        msgs = ((InternalEObject)newNoInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.AUDIOS__NO_INPUT, null, msgs);
      msgs = basicSetNoInput(newNoInput, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIOS__NO_INPUT, newNoInput, newNoInput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Match getMatch()
  {
    return match;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMatch(Match newMatch, NotificationChain msgs)
  {
    Match oldMatch = match;
    match = newMatch;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIOS__MATCH, oldMatch, newMatch);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMatch(Match newMatch)
  {
    if (newMatch != match)
    {
      NotificationChain msgs = null;
      if (match != null)
        msgs = ((InternalEObject)match).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.AUDIOS__MATCH, null, msgs);
      if (newMatch != null)
        msgs = ((InternalEObject)newMatch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.AUDIOS__MATCH, null, msgs);
      msgs = basicSetMatch(newMatch, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIOS__MATCH, newMatch, newMatch));
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
      case VoiceDslPackage.AUDIOS__INITIAL:
        return basicSetInitial(null, msgs);
      case VoiceDslPackage.AUDIOS__NO_MATCH:
        return basicSetNoMatch(null, msgs);
      case VoiceDslPackage.AUDIOS__NO_INPUT:
        return basicSetNoInput(null, msgs);
      case VoiceDslPackage.AUDIOS__MATCH:
        return basicSetMatch(null, msgs);
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
      case VoiceDslPackage.AUDIOS__INITIAL:
        return getInitial();
      case VoiceDslPackage.AUDIOS__NO_MATCH:
        return getNoMatch();
      case VoiceDslPackage.AUDIOS__NO_INPUT:
        return getNoInput();
      case VoiceDslPackage.AUDIOS__MATCH:
        return getMatch();
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
      case VoiceDslPackage.AUDIOS__INITIAL:
        setInitial((Initial)newValue);
        return;
      case VoiceDslPackage.AUDIOS__NO_MATCH:
        setNoMatch((NoMatch)newValue);
        return;
      case VoiceDslPackage.AUDIOS__NO_INPUT:
        setNoInput((NoInput)newValue);
        return;
      case VoiceDslPackage.AUDIOS__MATCH:
        setMatch((Match)newValue);
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
      case VoiceDslPackage.AUDIOS__INITIAL:
        setInitial((Initial)null);
        return;
      case VoiceDslPackage.AUDIOS__NO_MATCH:
        setNoMatch((NoMatch)null);
        return;
      case VoiceDslPackage.AUDIOS__NO_INPUT:
        setNoInput((NoInput)null);
        return;
      case VoiceDslPackage.AUDIOS__MATCH:
        setMatch((Match)null);
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
      case VoiceDslPackage.AUDIOS__INITIAL:
        return initial != null;
      case VoiceDslPackage.AUDIOS__NO_MATCH:
        return noMatch != null;
      case VoiceDslPackage.AUDIOS__NO_INPUT:
        return noInput != null;
      case VoiceDslPackage.AUDIOS__MATCH:
        return match != null;
    }
    return super.eIsSet(featureID);
  }

} //AudiosImpl
