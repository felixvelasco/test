/**
 */
package com.vectorsf.jvoice.model.operations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Flow State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.CallFlowState#getSubflow <em>Subflow</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCallFlowState()
 * @model
 * @generated
 */
public interface CallFlowState extends ParameterizedState {
	/**
	 * Returns the value of the '<em><b>Subflow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subflow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subflow</em>' reference.
	 * @see #setSubflow(Flow)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getCallFlowState_Subflow()
	 * @model
	 * @generated
	 */
	Flow getSubflow();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.CallFlowState#getSubflow <em>Subflow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subflow</em>' reference.
	 * @see #getSubflow()
	 * @generated
	 */
	void setSubflow(Flow value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<String> list = new <%org.eclipse.emf.common.util.BasicEList%><String>();\r\n\r\nfor(State state: getSubflow().getStates()) {\r\n\tif (state instanceof <%com.vectorsf.jvoice.model.operations.FinalState%> && !((FinalState)state).isFinal()) {\r\n\t\tlist.add(state.getName());\r\n\t}\r\n}\r\nreturn list;\r\r\n'"
	 * @generated
	 */
	EList<String> getEvents();

} // CallFlowState
