/**
 */
package types;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Generic Array Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmGenericArrayTypeReference#getComponentType <em>Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see types.TypesPackage#getJvmGenericArrayTypeReference()
 * @model
 * @generated
 */
public interface JvmGenericArrayTypeReference extends EObject, JvmTypeReference {
	/**
	 * Returns the value of the '<em><b>Component Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Type</em>' containment reference.
	 * @see #setComponentType(JvmTypeReference)
	 * @see types.TypesPackage#getJvmGenericArrayTypeReference_ComponentType()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getComponentType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmGenericArrayTypeReference#getComponentType <em>Component Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Type</em>' containment reference.
	 * @see #getComponentType()
	 * @generated
	 */
	void setComponentType(JvmTypeReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getDimensions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmArrayType getType();

} // JvmGenericArrayTypeReference
