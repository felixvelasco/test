/**
 */
package xbase;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAssignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XAssignment#getAssignable <em>Assignable</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAssignment#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAssignment#isExplicitStatic <em>Explicit Static</em>}</li>
 * </ul>
 * </p>
 *
 * @see xbase.XbasePackage#getXAssignment()
 * @model
 * @generated
 */
public interface XAssignment extends EObject, XAbstractFeatureCall {
	/**
	 * Returns the value of the '<em><b>Assignable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignable</em>' containment reference.
	 * @see #setAssignable(XExpression)
	 * @see xbase.XbasePackage#getXAssignment_Assignable()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getAssignable();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAssignment#getAssignable <em>Assignable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignable</em>' containment reference.
	 * @see #getAssignable()
	 * @generated
	 */
	void setAssignable(XExpression value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(XExpression)
	 * @see xbase.XbasePackage#getXAssignment_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAssignment#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

	/**
	 * Returns the value of the '<em><b>Explicit Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicit Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Static</em>' attribute.
	 * @see #setExplicitStatic(boolean)
	 * @see xbase.XbasePackage#getXAssignment_ExplicitStatic()
	 * @model
	 * @generated
	 */
	boolean isExplicitStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAssignment#isExplicitStatic <em>Explicit Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Static</em>' attribute.
	 * @see #isExplicitStatic()
	 * @generated
	 */
	void setExplicitStatic(boolean value);

} // XAssignment
