/**
 */
package com.vectorsf.jvoice.model.operations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.MenuState#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getMenuState()
 * @model
 * @generated
 */
public interface MenuState extends LocutionState {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' attribute list.
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getMenuState_Options()
	 * @model
	 * @generated
	 */
	EList<String> getOptions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<String> ret = new <%org.eclipse.emf.common.util.BasicEList%><String>();\r\n\r\nret.add(\"error\");\r\nret.add(\"noresource\");\r\nret.add(\"maxattempts\");\r\nret.add(\"maxnoinput\");\r\nret.add(\"maxnomatch\");\r\nret.add(\"hangup\");\r\n\r\nreturn ret;'"
	 * @generated
	 */
	EList<String> getEvents();

} // MenuState
