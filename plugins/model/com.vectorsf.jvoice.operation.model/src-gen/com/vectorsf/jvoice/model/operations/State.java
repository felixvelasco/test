/**
 */
package com.vectorsf.jvoice.model.operations;

import com.vectorsf.jvoice.model.base.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.State#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.State#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.State#getNotes <em>Notes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getState()
 * @model abstract="true"
 * @generated
 */
public interface State extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.operations.Transition}.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.model.operations.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getState_IncomingTransitions()
	 * @see com.vectorsf.jvoice.model.operations.Transition#getTarget
	 * @model opposite="target" required="true"
	 * @generated
	 */
	EList<Transition> getIncomingTransitions();

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.operations.Transition}.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.model.operations.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' reference list.
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getState_OutgoingTransitions()
	 * @see com.vectorsf.jvoice.model.operations.Transition#getSource
	 * @model opposite="source" required="true"
	 * @generated
	 */
	EList<Transition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Notes</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.model.operations.Note#getReferencedStates <em>Referenced States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notes</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notes</em>' reference.
	 * @see #setNotes(Note)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getState_Notes()
	 * @see com.vectorsf.jvoice.model.operations.Note#getReferencedStates
	 * @model opposite="referencedStates"
	 * @generated
	 */
	Note getNotes();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.State#getNotes <em>Notes</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notes</em>' reference.
	 * @see #getNotes()
	 * @generated
	 */
	void setNotes(Note value);

} // State
