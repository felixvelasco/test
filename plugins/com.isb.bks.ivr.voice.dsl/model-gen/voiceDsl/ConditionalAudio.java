/**
 */
package voiceDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Audio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link voiceDsl.ConditionalAudio#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see voiceDsl.VoiceDslPackage#getConditionalAudio()
 * @model
 * @generated
 */
public interface ConditionalAudio extends Audio {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(Condition)
	 * @see voiceDsl.VoiceDslPackage#getConditionalAudio_Condition()
	 * @model
	 * @generated
	 */
	Condition getCondition();

	/**
	 * Sets the value of the '{@link voiceDsl.ConditionalAudio#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Condition value);

} // ConditionalAudio
