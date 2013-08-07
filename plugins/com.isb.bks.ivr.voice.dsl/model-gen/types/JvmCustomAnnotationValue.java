/**
 */
package types;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmAnnotationValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Custom Annotation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmCustomAnnotationValue#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see types.TypesPackage#getJvmCustomAnnotationValue()
 * @model
 * @generated
 */
public interface JvmCustomAnnotationValue extends EObject, JvmAnnotationValue {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see types.TypesPackage#getJvmCustomAnnotationValue_Values()
	 * @model unique="false" transient="true"
	 * @generated
	 */
	EList<Object> getValues();

} // JvmCustomAnnotationValue
