/**
 */
package com.vectorsf.jvoice.model.operations;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transfer State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.TransferState#getDestination <em>Destination</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.TransferState#getAudioTransfer <em>Audio Transfer</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.TransferState#getMaxTime <em>Max Time</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.TransferState#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.TransferState#getTypeTransfer <em>Type Transfer</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getTransferState()
 * @model
 * @generated
 */
public interface TransferState extends State {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' attribute.
	 * @see #setDestination(String)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getTransferState_Destination()
	 * @model
	 * @generated
	 */
	String getDestination();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.TransferState#getDestination <em>Destination</em>}' attribute.
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
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getTransferState_AudioTransfer()
	 * @model
	 * @generated
	 */
	String getAudioTransfer();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.TransferState#getAudioTransfer <em>Audio Transfer</em>}' attribute.
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
	 * @see #setMaxTime(int)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getTransferState_MaxTime()
	 * @model
	 * @generated
	 */
	int getMaxTime();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.TransferState#getMaxTime <em>Max Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Time</em>' attribute.
	 * @see #getMaxTime()
	 * @generated
	 */
	void setMaxTime(int value);

	/**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(int)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getTransferState_Timeout()
	 * @model
	 * @generated
	 */
	int getTimeout();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.TransferState#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
	void setTimeout(int value);

	/**
	 * Returns the value of the '<em><b>Type Transfer</b></em>' attribute.
	 * The literals are from the enumeration {@link com.vectorsf.jvoice.model.operations.TypeTransfer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Transfer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Transfer</em>' attribute.
	 * @see com.vectorsf.jvoice.model.operations.TypeTransfer
	 * @see #setTypeTransfer(TypeTransfer)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getTransferState_TypeTransfer()
	 * @model
	 * @generated
	 */
	TypeTransfer getTypeTransfer();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.TransferState#getTypeTransfer <em>Type Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Transfer</em>' attribute.
	 * @see com.vectorsf.jvoice.model.operations.TypeTransfer
	 * @see #getTypeTransfer()
	 * @generated
	 */
	void setTypeTransfer(TypeTransfer value);

} // TransferState
