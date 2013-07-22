/**
 */
package Generic_BKS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Generic_BKS.SubFlow#getCalledFlow <em>Called Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @see Generic_BKS.Generic_BKSPackage#getSubFlow()
 * @model
 * @generated
 */
public interface SubFlow extends State {
	/**
	 * Returns the value of the '<em><b>Called Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Flow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Flow</em>' reference.
	 * @see #setCalledFlow(Flow)
	 * @see Generic_BKS.Generic_BKSPackage#getSubFlow_CalledFlow()
	 * @model
	 * @generated
	 */
	Flow getCalledFlow();

	/**
	 * Sets the value of the '{@link Generic_BKS.SubFlow#getCalledFlow <em>Called Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Flow</em>' reference.
	 * @see #getCalledFlow()
	 * @generated
	 */
	void setCalledFlow(Flow value);

} // SubFlow
