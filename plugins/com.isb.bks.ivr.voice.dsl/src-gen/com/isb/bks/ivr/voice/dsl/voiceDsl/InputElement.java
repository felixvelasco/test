/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getGrammatics <em>Grammatics</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getAudios <em>Audios</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement()
 * @model
 * @generated
 */
public interface InputElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Configuration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Configuration</em>' containment reference.
   * @see #setConfiguration(Configuration)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_Configuration()
   * @model containment="true"
   * @generated
   */
  Configuration getConfiguration();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getConfiguration <em>Configuration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Configuration</em>' containment reference.
   * @see #getConfiguration()
   * @generated
   */
  void setConfiguration(Configuration value);

  /**
   * Returns the value of the '<em><b>Grammatics</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Grammatics</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Grammatics</em>' containment reference.
   * @see #setGrammatics(Grammar)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_Grammatics()
   * @model containment="true"
   * @generated
   */
  Grammar getGrammatics();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getGrammatics <em>Grammatics</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Grammatics</em>' containment reference.
   * @see #getGrammatics()
   * @generated
   */
  void setGrammatics(Grammar value);

  /**
   * Returns the value of the '<em><b>Audios</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Audios</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Audios</em>' containment reference.
   * @see #setAudios(Audios)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_Audios()
   * @model containment="true"
   * @generated
   */
  Audios getAudios();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getAudios <em>Audios</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Audios</em>' containment reference.
   * @see #getAudios()
   * @generated
   */
  void setAudios(Audios value);

} // InputElement
