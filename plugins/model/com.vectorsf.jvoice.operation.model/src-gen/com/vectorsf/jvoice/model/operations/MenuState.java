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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\torg.eclipse.emf.common.util.BasicEList<String> list = new org.eclipse.emf.common.util.BasicEList<String>();\r\n\t\tlist.add(\"busy\");\r\n\t\tlist.add(\"conn_error\");\r\n\t\tlist.add(\"error\");\r\n\t\tlist.add(\"far_end_disc\");\r\n\t\tlist.add(\"hangup\");\r\n\t\tlist.add(\"match\");\r\n\t\tlist.add(\"maxatt\");\r\n\t\tlist.add(\"maxtime\");\r\n\t\tlist.add(\"netw_busy\");\r\n\t\tlist.add(\"netw_disconnect\");\r\n\t\tlist.add(\"noanswer\");\r\n\t\tlist.add(\"noinput\");\r\n\t\tlist.add(\"nomatch\");\r\n\t\tlist.add(\"noresource\");\r\n\t\tlist.add(\"recorded\");\r\n\t\tlist.add(\"record_unsup\");\r\n\t\tlist.add(\"success\");\r\n\t\tlist.add(\"transferred\");\r\n\t\tlist.add(\"unknown\");\r\n\r\n\t\treturn list;\r\n'"
	 * @generated
	 */
	EList<String> getEvents();
} // MenuState
