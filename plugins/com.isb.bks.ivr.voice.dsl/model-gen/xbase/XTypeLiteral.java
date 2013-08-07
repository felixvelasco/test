/**
 */
package xbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmType;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XType Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XTypeLiteral#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XTypeLiteral#getArrayDimensions <em>Array Dimensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see xbase.XbasePackage#getXTypeLiteral()
 * @model
 * @generated
 */
public interface XTypeLiteral extends EObject, XExpression {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(JvmType)
	 * @see xbase.XbasePackage#getXTypeLiteral_Type()
	 * @model required="true"
	 * @generated
	 */
	JvmType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XTypeLiteral#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmType value);

	/**
	 * Returns the value of the '<em><b>Array Dimensions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Dimensions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Dimensions</em>' attribute list.
	 * @see xbase.XbasePackage#getXTypeLiteral_ArrayDimensions()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getArrayDimensions();

} // XTypeLiteral
