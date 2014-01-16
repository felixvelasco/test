/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Audio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#isDontBargeIn <em>Dont Barge In</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getTts <em>Tts</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getSrc <em>Src</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getInterpretation <em>Interpretation</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getFormat <em>Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getAudio()
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
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getAudio_DontBargeIn()
	 * @model
	 * @generated
	 */
	boolean isDontBargeIn();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#isDontBargeIn <em>Dont Barge In</em>}' attribute.
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
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getAudio_Tts()
	 * @model
	 * @generated
	 */
	String getTts();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getTts <em>Tts</em>}' attribute.
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
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getAudio_Src()
	 * @model
	 * @generated
	 */
	String getSrc();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getSrc <em>Src</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src</em>' attribute.
	 * @see #getSrc()
	 * @generated
	 */
	void setSrc(String value);

	/**
	 * Returns the value of the '<em><b>Interpretation</b></em>' attribute.
	 * The literals are from the enumeration {@link com.vectorsf.jvoice.prompt.model.voiceDsl.Interpretation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpretation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpretation</em>' attribute.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Interpretation
	 * @see #setInterpretation(Interpretation)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getAudio_Interpretation()
	 * @model
	 * @generated
	 */
	Interpretation getInterpretation();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getInterpretation <em>Interpretation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpretation</em>' attribute.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Interpretation
	 * @see #getInterpretation()
	 * @generated
	 */
	void setInterpretation(Interpretation value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getAudio_Format()
	 * @model
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

} // Audio
