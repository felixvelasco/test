/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Audio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getSimpleAudios <em>Simple Audios</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getCondit <em>Condit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getConditionalAudio()
 * @model
 * @generated
 */
public interface ConditionalAudio extends Audio {
	/**
	 * Returns the value of the '<em><b>Simple Audios</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Audios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Audios</em>' containment reference list.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getConditionalAudio_SimpleAudios()
	 * @model containment="true"
	 * @generated
	 */
	EList<Audio> getSimpleAudios();

	/**
	 * Returns the value of the '<em><b>Condit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condit</em>' attribute.
	 * @see #setCondit(String)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getConditionalAudio_Condit()
	 * @model
	 * @generated
	 */
	String getCondit();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getCondit <em>Condit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condit</em>' attribute.
	 * @see #getCondit()
	 * @generated
	 */
	void setCondit(String value);

} // ConditionalAudio
