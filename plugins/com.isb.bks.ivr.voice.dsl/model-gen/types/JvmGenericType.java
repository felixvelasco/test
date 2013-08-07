/**
 */
package types;

import java.lang.Iterable;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Generic Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmGenericType#isInterface <em>Interface</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmGenericType#isStrictFloatingPoint <em>Strict Floating Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see types.TypesPackage#getJvmGenericType()
 * @model
 * @generated
 */
public interface JvmGenericType extends EObject, JvmDeclaredType, JvmTypeParameterDeclarator {
	/**
	 * Returns the value of the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' attribute.
	 * @see #setInterface(boolean)
	 * @see types.TypesPackage#getJvmGenericType_Interface()
	 * @model
	 * @generated
	 */
	boolean isInterface();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmGenericType#isInterface <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' attribute.
	 * @see #isInterface()
	 * @generated
	 */
	void setInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Strict Floating Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strict Floating Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strict Floating Point</em>' attribute.
	 * @see #setStrictFloatingPoint(boolean)
	 * @see types.TypesPackage#getJvmGenericType_StrictFloatingPoint()
	 * @model
	 * @generated
	 */
	boolean isStrictFloatingPoint();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmGenericType#isStrictFloatingPoint <em>Strict Floating Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strict Floating Point</em>' attribute.
	 * @see #isStrictFloatingPoint()
	 * @generated
	 */
	void setStrictFloatingPoint(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="types.Iterable<types.JvmTypeReference>"
	 * @generated
	 */
	Iterable<JvmTypeReference> getExtendedInterfaces();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmTypeReference getExtendedClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isInstantiateable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="types.Iterable<types.JvmConstructor>" required="true"
	 * @generated
	 */
	Iterable<JvmConstructor> getDeclaredConstructors();

} // JvmGenericType
