/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transfer Dsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getDestination <em>Destination</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getAudioTransfer <em>Audio Transfer</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getMaxTime <em>Max Time</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getTypeTransfer <em>Type Transfer</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getTransferDsl()
 * @model
 * @generated
 */
public interface TransferDsl extends VoiceDsl {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' attribute.
	 * @see #setDestination(String)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getTransferDsl_Destination()
	 * @model default=""
	 * @generated
	 */
	String getDestination();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getDestination <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' attribute.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(String value);

	/**
	 * Returns the value of the '<em><b>Audio Transfer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Audio Transfer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Audio Transfer</em>' attribute.
	 * @see #setAudioTransfer(String)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getTransferDsl_AudioTransfer()
	 * @model
	 * @generated
	 */
	String getAudioTransfer();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getAudioTransfer <em>Audio Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Audio Transfer</em>' attribute.
	 * @see #getAudioTransfer()
	 * @generated
	 */
	void setAudioTransfer(String value);

	/**
	 * Returns the value of the '<em><b>Max Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Time</em>' attribute.
	 * @see #setMaxTime(String)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getTransferDsl_MaxTime()
	 * @model
	 * @generated
	 */
	String getMaxTime();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getMaxTime <em>Max Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Time</em>' attribute.
	 * @see #getMaxTime()
	 * @generated
	 */
	void setMaxTime(String value);

	/**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(String)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getTransferDsl_Timeout()
	 * @model
	 * @generated
	 */
	String getTimeout();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
	void setTimeout(String value);

	/**
	 * Returns the value of the '<em><b>Type Transfer</b></em>' attribute.
	 * The literals are from the enumeration {@link com.vectorsf.jvoice.prompt.model.voiceDsl.TypeTransfer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Transfer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Transfer</em>' attribute.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.TypeTransfer
	 * @see #setTypeTransfer(TypeTransfer)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getTransferDsl_TypeTransfer()
	 * @model
	 * @generated
	 */
	TypeTransfer getTypeTransfer();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl#getTypeTransfer <em>Type Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Transfer</em>' attribute.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.TypeTransfer
	 * @see #getTypeTransfer()
	 * @generated
	 */
	void setTypeTransfer(TypeTransfer value);

} // TransferDsl
