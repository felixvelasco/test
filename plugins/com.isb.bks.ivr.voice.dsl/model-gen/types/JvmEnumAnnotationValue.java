/**
 */
package types;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Enum Annotation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmEnumAnnotationValue#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see types.TypesPackage#getJvmEnumAnnotationValue()
 * @model
 * @generated
 */
public interface JvmEnumAnnotationValue extends EObject, JvmAnnotationValue {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmEnumerationLiteral}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' reference list.
	 * @see types.TypesPackage#getJvmEnumAnnotationValue_Values()
	 * @model
	 * @generated
	 */
	EList<JvmEnumerationLiteral> getValues();

} // JvmEnumAnnotationValue
