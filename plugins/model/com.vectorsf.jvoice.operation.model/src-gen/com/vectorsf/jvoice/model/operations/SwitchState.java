/**
 */
package com.vectorsf.jvoice.model.operations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.SwitchState#getCase <em>Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getSwitchState()
 * @model
 * @generated
 */
public interface SwitchState extends State {
	/**
	 * Returns the value of the '<em><b>Case</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.operations.Case}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case</em>' containment reference list.
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getSwitchState_Case()
	 * @model containment="true"
	 * @generated
	 */
	EList<Case> getCase();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for (Case switchCase: getCase()) {\r\n\tif (switchCase.getEventName().equals(name)) {\r\n\t\treturn switchCase;\r\n\t}\r\n}\r\n\t\t\r\nreturn null;'"
	 * @generated
	 */
	Case getCase(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<String> ret = new <%org.eclipse.emf.common.util.BasicEList%><String>();\n\nfor (Case current: getCase()) {\n\tret.add(current.getEventName());\n}\n\nreturn ret;'"
	 * @generated
	 */
	EList<String> getEvents();

} // SwitchState
