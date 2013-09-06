/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Audio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getCondit <em>Condit</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getSimpleA <em>Simple A</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getConditionalAudio()
 * @model
 * @generated
 */
public interface ConditionalAudio extends Audio {
	/**
	 * Returns the value of the '<em><b>Condit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condit</em>' containment reference.
	 * @see #setCondit(XExpression)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getConditionalAudio_Condit()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getCondit();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getCondit <em>Condit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condit</em>' containment reference.
	 * @see #getCondit()
	 * @generated
	 */
	void setCondit(XExpression value);

	/**
	 * Returns the value of the '<em><b>Simple A</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple A</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple A</em>' containment reference.
	 * @see #setSimpleA(Audio)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getConditionalAudio_SimpleA()
	 * @model containment="true"
	 * @generated
	 */
	Audio getSimpleA();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio#getSimpleA <em>Simple A</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple A</em>' containment reference.
	 * @see #getSimpleA()
	 * @generated
	 */
	void setSimpleA(Audio value);

} // ConditionalAudio
