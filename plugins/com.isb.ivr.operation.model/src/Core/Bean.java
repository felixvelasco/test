/**
 */
package Core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Core.Bean#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see Core.CorePackage#getBean()
 * @model
 * @generated
 */
public interface Bean extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Core.LogicalPackage#getBeans <em>Beans</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(LogicalPackage)
	 * @see Core.CorePackage#getBean_Owner()
	 * @see Core.LogicalPackage#getBeans
	 * @model opposite="beans" transient="false"
	 * @generated
	 */
	LogicalPackage getOwner();

	/**
	 * Sets the value of the '{@link Core.Bean#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(LogicalPackage value);

} // Bean
