/**
 */
package com.vectorsf.jvoice.model.operations;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.CustomState#getPath <em>Path</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.CustomState#getBindingBean <em>Binding Bean</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCustomState()
 * @model
 * @generated
 */
public interface CustomState extends State {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCustomState_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.CustomState#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Binding Bean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding Bean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding Bean</em>' attribute.
	 * @see #setBindingBean(String)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCustomState_BindingBean()
	 * @model
	 * @generated
	 */
	String getBindingBean();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.CustomState#getBindingBean <em>Binding Bean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding Bean</em>' attribute.
	 * @see #getBindingBean()
	 * @generated
	 */
	void setBindingBean(String value);

} // CustomState
