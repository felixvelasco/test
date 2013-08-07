/**
 */
package types;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Enumeration Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see types.TypesPackage#getJvmEnumerationLiteral()
 * @model
 * @generated
 */
public interface JvmEnumerationLiteral extends EObject, JvmField {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmEnumerationType getEnumType();

} // JvmEnumerationLiteral
