/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Audio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#isDontBargeIn <em>Dont Barge In</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getTts <em>Tts</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getSrc <em>Src</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getAudio()
 * @model
 * @generated
 */
public interface Audio extends EObject {
	/**
	 * Returns the value of the '<em><b>Dont Barge In</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dont Barge In</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dont Barge In</em>' attribute.
	 * @see #setDontBargeIn(boolean)
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getAudio_DontBargeIn()
	 * @model
	 * @generated
	 */
	boolean isDontBargeIn();

	/**
	 * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#isDontBargeIn <em>Dont Barge In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dont Barge In</em>' attribute.
	 * @see #isDontBargeIn()
	 * @generated
	 */
	void setDontBargeIn(boolean value);

	/**
	 * Returns the value of the '<em><b>Tts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tts</em>' attribute.
	 * @see #setTts(String)
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getAudio_Tts()
	 * @model
	 * @generated
	 */
	String getTts();

	/**
	 * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getTts <em>Tts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tts</em>' attribute.
	 * @see #getTts()
	 * @generated
	 */
	void setTts(String value);

	/**
	 * Returns the value of the '<em><b>Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src</em>' attribute.
	 * @see #setSrc(String)
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getAudio_Src()
	 * @model
	 * @generated
	 */
	String getSrc();

	/**
	 * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getSrc <em>Src</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src</em>' attribute.
	 * @see #getSrc()
	 * @generated
	 */
	void setSrc(String value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Condition)
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getAudio_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Condition getCondition();

	/**
	 * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Condition value);

} // Audio
