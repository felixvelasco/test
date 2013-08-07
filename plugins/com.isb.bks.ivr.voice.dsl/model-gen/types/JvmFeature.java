/**
 */
package types;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmMember;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see types.TypesPackage#getJvmFeature()
 * @model abstract="true"
 * @generated
 */
public interface JvmFeature extends EObject, JvmMember {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns <code>true</code> if the feature is a static field or static operation.</p>
	 * 
	 * @since 2.4
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStatic();

} // JvmFeature
