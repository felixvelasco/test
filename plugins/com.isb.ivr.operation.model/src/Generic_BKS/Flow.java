/**
 */
package Generic_BKS;

import Core.Bean;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Generic_BKS.Flow#getStates <em>States</em>}</li>
 *   <li>{@link Generic_BKS.Flow#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see Generic_BKS.Generic_BKSPackage#getFlow()
 * @model
 * @generated
 */
public interface Flow extends Bean {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link Generic_BKS.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see Generic_BKS.Generic_BKSPackage#getFlow_States()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link Generic_BKS.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see Generic_BKS.Generic_BKSPackage#getFlow_Transitions()
	 * @model containment="true" required="true" upper="4"
	 * @generated
	 */
	EList<Transition> getTransitions();

} // Flow
