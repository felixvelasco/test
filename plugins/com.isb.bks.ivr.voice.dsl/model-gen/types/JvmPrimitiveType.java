/**
 */
package types;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmComponentType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmPrimitiveType#getSimpleName <em>Simple Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see types.TypesPackage#getJvmPrimitiveType()
 * @model
 * @generated
 */
public interface JvmPrimitiveType extends EObject, JvmComponentType {
	/**
	 * Returns the value of the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name</em>' attribute.
	 * @see #setSimpleName(String)
	 * @see types.TypesPackage#getJvmPrimitiveType_SimpleName()
	 * @model
	 * @generated
	 */
	String getSimpleName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmPrimitiveType#getSimpleName <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name</em>' attribute.
	 * @see #getSimpleName()
	 * @generated
	 */
	void setSimpleName(String value);

} // JvmPrimitiveType
