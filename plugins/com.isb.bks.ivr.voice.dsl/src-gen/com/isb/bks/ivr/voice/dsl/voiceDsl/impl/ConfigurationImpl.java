/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl.impl;

import com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration;
import com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConfigurationImpl#getMaxNoInput <em>Max No Input</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConfigurationImpl#getMaxNoMAtch <em>Max No MAtch</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.ConfigurationImpl#getMaxAttempts <em>Max Attempts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends MinimalEObjectImpl.Container implements Configuration
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getMaxNoInput() <em>Max No Input</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxNoInput()
   * @generated
   * @ordered
   */
  protected static final int MAX_NO_INPUT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMaxNoInput() <em>Max No Input</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxNoInput()
   * @generated
   * @ordered
   */
  protected int maxNoInput = MAX_NO_INPUT_EDEFAULT;

  /**
   * The default value of the '{@link #getMaxNoMAtch() <em>Max No MAtch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxNoMAtch()
   * @generated
   * @ordered
   */
  protected static final int MAX_NO_MATCH_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMaxNoMAtch() <em>Max No MAtch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxNoMAtch()
   * @generated
   * @ordered
   */
  protected int maxNoMAtch = MAX_NO_MATCH_EDEFAULT;

  /**
   * The default value of the '{@link #getMaxAttempts() <em>Max Attempts</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxAttempts()
   * @generated
   * @ordered
   */
  protected static final int MAX_ATTEMPTS_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMaxAttempts() <em>Max Attempts</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxAttempts()
   * @generated
   * @ordered
   */
  protected int maxAttempts = MAX_ATTEMPTS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConfigurationImpl()
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
    return VoiceDslPackage.Literals.CONFIGURATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.CONFIGURATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMaxNoInput()
  {
    return maxNoInput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaxNoInput(int newMaxNoInput)
  {
    int oldMaxNoInput = maxNoInput;
    maxNoInput = newMaxNoInput;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.CONFIGURATION__MAX_NO_INPUT, oldMaxNoInput, maxNoInput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMaxNoMAtch()
  {
    return maxNoMAtch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaxNoMAtch(int newMaxNoMAtch)
  {
    int oldMaxNoMAtch = maxNoMAtch;
    maxNoMAtch = newMaxNoMAtch;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.CONFIGURATION__MAX_NO_MATCH, oldMaxNoMAtch, maxNoMAtch));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMaxAttempts()
  {
    return maxAttempts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaxAttempts(int newMaxAttempts)
  {
    int oldMaxAttempts = maxAttempts;
    maxAttempts = newMaxAttempts;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.CONFIGURATION__MAX_ATTEMPTS, oldMaxAttempts, maxAttempts));
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
      case VoiceDslPackage.CONFIGURATION__NAME:
        return getName();
      case VoiceDslPackage.CONFIGURATION__MAX_NO_INPUT:
        return getMaxNoInput();
      case VoiceDslPackage.CONFIGURATION__MAX_NO_MATCH:
        return getMaxNoMAtch();
      case VoiceDslPackage.CONFIGURATION__MAX_ATTEMPTS:
        return getMaxAttempts();
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
      case VoiceDslPackage.CONFIGURATION__NAME:
        setName((String)newValue);
        return;
      case VoiceDslPackage.CONFIGURATION__MAX_NO_INPUT:
        setMaxNoInput((Integer)newValue);
        return;
      case VoiceDslPackage.CONFIGURATION__MAX_NO_MATCH:
        setMaxNoMAtch((Integer)newValue);
        return;
      case VoiceDslPackage.CONFIGURATION__MAX_ATTEMPTS:
        setMaxAttempts((Integer)newValue);
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
      case VoiceDslPackage.CONFIGURATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case VoiceDslPackage.CONFIGURATION__MAX_NO_INPUT:
        setMaxNoInput(MAX_NO_INPUT_EDEFAULT);
        return;
      case VoiceDslPackage.CONFIGURATION__MAX_NO_MATCH:
        setMaxNoMAtch(MAX_NO_MATCH_EDEFAULT);
        return;
      case VoiceDslPackage.CONFIGURATION__MAX_ATTEMPTS:
        setMaxAttempts(MAX_ATTEMPTS_EDEFAULT);
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
      case VoiceDslPackage.CONFIGURATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case VoiceDslPackage.CONFIGURATION__MAX_NO_INPUT:
        return maxNoInput != MAX_NO_INPUT_EDEFAULT;
      case VoiceDslPackage.CONFIGURATION__MAX_NO_MATCH:
        return maxNoMAtch != MAX_NO_MATCH_EDEFAULT;
      case VoiceDslPackage.CONFIGURATION__MAX_ATTEMPTS:
        return maxAttempts != MAX_ATTEMPTS_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", maxNoInput: ");
    result.append(maxNoInput);
    result.append(", maxNoMAtch: ");
    result.append(maxNoMAtch);
    result.append(", maxAttempts: ");
    result.append(maxAttempts);
    result.append(')');
    return result.toString();
  }

} //ConfigurationImpl
