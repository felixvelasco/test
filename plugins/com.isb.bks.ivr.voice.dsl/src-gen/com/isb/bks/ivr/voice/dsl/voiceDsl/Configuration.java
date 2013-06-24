/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getName <em>Name</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxNoInput <em>Max No Input</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxNoMAtch <em>Max No MAtch</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxAttempts <em>Max Attempts</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getConfiguration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Max No Input</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max No Input</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max No Input</em>' attribute.
   * @see #setMaxNoInput(int)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getConfiguration_MaxNoInput()
   * @model
   * @generated
   */
  int getMaxNoInput();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxNoInput <em>Max No Input</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max No Input</em>' attribute.
   * @see #getMaxNoInput()
   * @generated
   */
  void setMaxNoInput(int value);

  /**
   * Returns the value of the '<em><b>Max No MAtch</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max No MAtch</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max No MAtch</em>' attribute.
   * @see #setMaxNoMAtch(int)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getConfiguration_MaxNoMAtch()
   * @model
   * @generated
   */
  int getMaxNoMAtch();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxNoMAtch <em>Max No MAtch</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max No MAtch</em>' attribute.
   * @see #getMaxNoMAtch()
   * @generated
   */
  void setMaxNoMAtch(int value);

  /**
   * Returns the value of the '<em><b>Max Attempts</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Attempts</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Attempts</em>' attribute.
   * @see #setMaxAttempts(int)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getConfiguration_MaxAttempts()
   * @model
   * @generated
   */
  int getMaxAttempts();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration#getMaxAttempts <em>Max Attempts</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Attempts</em>' attribute.
   * @see #getMaxAttempts()
   * @generated
   */
  void setMaxAttempts(int value);

} // Configuration
