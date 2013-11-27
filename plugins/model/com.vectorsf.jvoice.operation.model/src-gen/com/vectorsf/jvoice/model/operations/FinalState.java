/**
 */
package com.vectorsf.jvoice.model.operations;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Final State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.FinalState#isFinal <em>Final</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.FinalState#getReturnExpression <em>Return Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getFinalState()
 * @model
 * @generated
 */
public interface FinalState extends State {

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getFinalState_Final()
	 * @model
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.FinalState#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Return Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Expression</em>' attribute.
	 * @see #setReturnExpression(String)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getFinalState_ReturnExpression()
	 * @model
	 * @generated
	 */
	String getReturnExpression();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.FinalState#getReturnExpression <em>Return Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Expression</em>' attribute.
	 * @see #getReturnExpression()
	 * @generated
	 */
	void setReturnExpression(String value);
} // FinalState
