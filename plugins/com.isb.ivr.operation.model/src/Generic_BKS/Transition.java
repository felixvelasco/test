/**
 */
package Generic_BKS;

import Core.FlowElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Generic_BKS.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link Generic_BKS.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link Generic_BKS.Transition#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see Generic_BKS.Generic_BKSPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends FlowElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link Generic_BKS.State#getOutTransactions <em>Out Transactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(State)
	 * @see Generic_BKS.Generic_BKSPackage#getTransition_Source()
	 * @see Generic_BKS.State#getOutTransactions
	 * @model opposite="outTransactions" required="true"
	 * @generated
	 */
	State getSource();

	/**
	 * Sets the value of the '{@link Generic_BKS.Transition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(State value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link Generic_BKS.State#getInTransactions <em>In Transactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(State)
	 * @see Generic_BKS.Generic_BKSPackage#getTransition_Target()
	 * @see Generic_BKS.State#getInTransactions
	 * @model opposite="inTransactions" required="true"
	 * @generated
	 */
	State getTarget();

	/**
	 * Sets the value of the '{@link Generic_BKS.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(State value);

	/**
	 * Returns the value of the '<em><b>Events</b></em>' reference list.
	 * The list contents are of type {@link Generic_BKS.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' reference list.
	 * @see Generic_BKS.Generic_BKSPackage#getTransition_Events()
	 * @model required="true"
	 * @generated
	 */
	EList<Event> getEvents();

} // Transition
