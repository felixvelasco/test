/**
 */
package com.vectorsf.jvoice.model.operations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu State</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getMenuState()
 * @model
 * @generated
 */
public interface MenuState extends LocutionState {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<String> ret = new <%org.eclipse.emf.common.util.BasicEList%><String>();\r\n\r\nret.add(\"error\");\r\nret.add(\"noresource\");\r\nret.add(\"maxattempts\");\r\nret.add(\"maxnoinput\");\r\nret.add(\"maxnomatch\");\r\nret.add(\"hangup\");\r\n\r\nreturn ret;'"
	 * @generated
	 */
	EList<String> getEvents();

} // MenuState
