/**
 */
package types;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmComponentType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmArrayType#getComponentType <em>Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see types.TypesPackage#getJvmArrayType()
 * @model
 * @generated
 */
public interface JvmArrayType extends EObject, JvmComponentType {
	/**
	 * Returns the value of the '<em><b>Component Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmComponentType#getArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Type</em>' container reference.
	 * @see #setComponentType(JvmComponentType)
	 * @see types.TypesPackage#getJvmArrayType_ComponentType()
	 * @see org.eclipse.xtext.common.types.JvmComponentType#getArrayType
	 * @model opposite="arrayType" resolveProxies="false" transient="false"
	 * @generated
	 */
	JvmComponentType getComponentType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmArrayType#getComponentType <em>Component Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Type</em>' container reference.
	 * @see #getComponentType()
	 * @generated
	 */
	void setComponentType(JvmComponentType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getDimensions();

} // JvmArrayType
