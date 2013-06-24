/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>No Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.NoInput#getAudio <em>Audio</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getNoInput()
 * @model
 * @generated
 */
public interface NoInput extends EObject
{
  /**
   * Returns the value of the '<em><b>Audio</b></em>' containment reference list.
   * The list contents are of type {@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Audio</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Audio</em>' containment reference list.
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getNoInput_Audio()
   * @model containment="true"
   * @generated
   */
  EList<Audio> getAudio();

} // NoInput
