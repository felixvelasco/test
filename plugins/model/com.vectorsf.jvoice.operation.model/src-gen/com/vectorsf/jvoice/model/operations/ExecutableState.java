/**
 */
package com.vectorsf.jvoice.model.operations;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Executable State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.ExecutableState#getMethodName <em>Method Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getExecutableState()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ExecutableState extends ParameterizedState {
	/**
	 * Returns the value of the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Name</em>' attribute.
	 * @see #setMethodName(String)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getExecutableState_MethodName()
	 * @model
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.ExecutableState#getMethodName <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Name</em>' attribute.
	 * @see #getMethodName()
	 * @generated
	 */
	void setMethodName(String value);

} // ExecutableState
