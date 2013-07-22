/**
 */
package Core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Core.LogicalPackage#getBeans <em>Beans</em>}</li>
 * </ul>
 * </p>
 *
 * @see Core.CorePackage#getLogicalPackage()
 * @model
 * @generated
 */
public interface LogicalPackage extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Beans</b></em>' containment reference list.
	 * The list contents are of type {@link Core.Bean}.
	 * It is bidirectional and its opposite is '{@link Core.Bean#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Beans</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Beans</em>' containment reference list.
	 * @see Core.CorePackage#getLogicalPackage_Beans()
	 * @see Core.Bean#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<Bean> getBeans();

} // LogicalPackage
