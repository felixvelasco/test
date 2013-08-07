/**
 */
package types;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Annotation Annotation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see types.TypesPackage#getJvmAnnotationAnnotationValue()
 * @model
 * @generated
 */
public interface JvmAnnotationAnnotationValue extends EObject, JvmAnnotationValue {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmAnnotationReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see types.TypesPackage#getJvmAnnotationAnnotationValue_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmAnnotationReference> getValues();

} // JvmAnnotationAnnotationValue
