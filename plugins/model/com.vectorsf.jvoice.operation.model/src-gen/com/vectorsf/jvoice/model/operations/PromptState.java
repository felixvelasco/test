/**
 */
package com.vectorsf.jvoice.model.operations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prompt State</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getPromptState()
 * @model
 * @generated
 */
public interface PromptState extends LocutionState {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<String> ret = new <%org.eclipse.emf.common.util.BasicEList%><String>();\n\nret.add(\"ok\");\nret.add(\"hangup\");\n\nreturn ret;'"
	 * @generated
	 */
	EList<String> getEvents();

} // PromptState
