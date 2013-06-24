/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Audios</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getInitial <em>Initial</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getNoMatch <em>No Match</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getNoInput <em>No Input</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getMatch <em>Match</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getAudios()
 * @model
 * @generated
 */
public interface Audios extends EObject
{
  /**
   * Returns the value of the '<em><b>Initial</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial</em>' containment reference.
   * @see #setInitial(Initial)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getAudios_Initial()
   * @model containment="true"
   * @generated
   */
  Initial getInitial();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getInitial <em>Initial</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial</em>' containment reference.
   * @see #getInitial()
   * @generated
   */
  void setInitial(Initial value);

  /**
   * Returns the value of the '<em><b>No Match</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>No Match</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>No Match</em>' containment reference.
   * @see #setNoMatch(NoMatch)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getAudios_NoMatch()
   * @model containment="true"
   * @generated
   */
  NoMatch getNoMatch();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getNoMatch <em>No Match</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>No Match</em>' containment reference.
   * @see #getNoMatch()
   * @generated
   */
  void setNoMatch(NoMatch value);

  /**
   * Returns the value of the '<em><b>No Input</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>No Input</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>No Input</em>' containment reference.
   * @see #setNoInput(NoInput)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getAudios_NoInput()
   * @model containment="true"
   * @generated
   */
  NoInput getNoInput();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getNoInput <em>No Input</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>No Input</em>' containment reference.
   * @see #getNoInput()
   * @generated
   */
  void setNoInput(NoInput value);

  /**
   * Returns the value of the '<em><b>Match</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Match</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Match</em>' containment reference.
   * @see #setMatch(Match)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getAudios_Match()
   * @model containment="true"
   * @generated
   */
  Match getMatch();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audios#getMatch <em>Match</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Match</em>' containment reference.
   * @see #getMatch()
   * @generated
   */
  void setMatch(Match value);

} // Audios
