/**
 */
package Generic_BKS;

import Core.FlowElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Generic_BKS.State#getInTransactions <em>In Transactions</em>}</li>
 *   <li>{@link Generic_BKS.State#getOutTransactions <em>Out Transactions</em>}</li>
 * </ul>
 * </p>
 *
 * @see Generic_BKS.Generic_BKSPackage#getState()
 * @model abstract="true"
 * @generated
 */
public interface State extends FlowElement {
	/**
	 * Returns the value of the '<em><b>In Transactions</b></em>' reference list.
	 * The list contents are of type {@link Generic_BKS.Transition}.
	 * It is bidirectional and its opposite is '{@link Generic_BKS.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Transactions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Transactions</em>' reference list.
	 * @see Generic_BKS.Generic_BKSPackage#getState_InTransactions()
	 * @see Generic_BKS.Transition#getTarget
	 * @model opposite="target" required="true"
	 * @generated
	 */
	EList<Transition> getInTransactions();

	/**
	 * Returns the value of the '<em><b>Out Transactions</b></em>' reference list.
	 * The list contents are of type {@link Generic_BKS.Transition}.
	 * It is bidirectional and its opposite is '{@link Generic_BKS.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Transactions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Transactions</em>' reference list.
	 * @see Generic_BKS.Generic_BKSPackage#getState_OutTransactions()
	 * @see Generic_BKS.Transition#getSource
	 * @model opposite="source" required="true"
	 * @generated
	 */
	EList<Transition> getOutTransactions();

} // State
