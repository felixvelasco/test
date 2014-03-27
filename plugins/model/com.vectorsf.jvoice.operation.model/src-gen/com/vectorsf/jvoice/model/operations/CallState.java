/**
 */
package com.vectorsf.jvoice.model.operations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.CallState#getBean <em>Bean</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.CallState#getReferencedBean <em>Referenced Bean</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCallState()
 * @model
 * @generated
 */
public interface CallState extends ExecutableState {
	/**
	 * Returns the value of the '<em><b>Bean</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bean</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bean</em>' reference.
	 * @see #setBean(ComponentBean)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCallState_Bean()
	 * @model
	 * @generated
	 */
	ComponentBean getBean();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.CallState#getBean <em>Bean</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bean</em>' reference.
	 * @see #getBean()
	 * @generated
	 */
	void setBean(ComponentBean value);

	/**
	 * Returns the value of the '<em><b>Referenced Bean</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Bean</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Bean</em>' reference.
	 * @see #setReferencedBean(ComponentBean)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCallState_ReferencedBean()
	 * @model
	 * @generated
	 */
	ComponentBean getReferencedBean();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.CallState#getReferencedBean <em>Referenced Bean</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Bean</em>' reference.
	 * @see #getReferencedBean()
	 * @generated
	 */
	void setReferencedBean(ComponentBean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<String> ret = new <%org.eclipse.emf.common.util.BasicEList%><String>();\n\nret.add(\"ok\");\nret.add(\"error\");\n\n\nreturn ret;'"
	 * @generated
	 */
	EList<String> getEvents();

} // CallState
