/**
 */
package types;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmAnnotationValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Char Annotation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmCharAnnotationValue#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see types.TypesPackage#getJvmCharAnnotationValue()
 * @model
 * @generated
 */
public interface JvmCharAnnotationValue extends EObject, JvmAnnotationValue {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Character}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see types.TypesPackage#getJvmCharAnnotationValue_Values()
	 * @model unique="false"
	 * @generated
	 */
	EList<Character> getValues();

} // JvmCharAnnotationValue
