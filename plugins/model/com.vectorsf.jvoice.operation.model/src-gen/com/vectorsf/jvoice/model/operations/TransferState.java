/**
 */
package com.vectorsf.jvoice.model.operations;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transfer State</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getTransferState()
 * @model
 * @generated
 */
public interface TransferState extends LocutionState {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<String> ret = new <%org.eclipse.emf.common.util.BasicEList%><String>();\n\n<%com.vectorsf.jvoice.prompt.model.voiceDsl.TypeTransfer%> type = ((<%com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl%>) getLocution()).getTypeTransfer();\n\nret.add(\"ok\");\nret.add(\"error\");\nret.add(\"noresource\");\nret.add(\"connectionerror\");\nret.add(\"unknown\");\nret.add(\"near_end_disconnect\");\n\nif (type==TypeTransfer.CONSULTATION || type==TypeTransfer.BRIDGE) {\n\tret.add(\"noanswer\");\n\tret.add(\"busy\");\n\tret.add(\"network_busy\");\n}\n\nif (type==TypeTransfer.BRIDGE) {\n\tret.add(\"maxtime_disconnect\");\n\tret.add(\"network_disconnect\");\n\tret.add(\"far_end_disconnect\");\n}\n\nret.add(\"hangup\");\n\nreturn ret;'"
	 * @generated
	 */
	EList<String> getEvents();

} // TransferState
