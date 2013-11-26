/**
 */
package com.vectorsf.jvoice.model.operations;

import com.vectorsf.jvoice.model.base.JVBean;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.CallState#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.CallState#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.CallState#getBean <em>Bean</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCallState()
 * @model
 * @generated
 */
public interface CallState extends State {

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCallState_Parameters()
	 * @model
	 * @generated
	 */
	EList<EObject> getParameters();

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
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCallState_MethodName()
	 * @model
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.CallState#getMethodName <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Name</em>' attribute.
	 * @see #getMethodName()
	 * @generated
	 */
	void setMethodName(String value);

	/**
	 * Returns the value of the '<em><b>Bean</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bean</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bean</em>' reference.
	 * @see #setBean(JVBean)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCallState_Bean()
	 * @model
	 * @generated
	 */
	JVBean getBean();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.CallState#getBean <em>Bean</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bean</em>' reference.
	 * @see #getBean()
	 * @generated
	 */
	void setBean(JVBean value);
} // CallState
