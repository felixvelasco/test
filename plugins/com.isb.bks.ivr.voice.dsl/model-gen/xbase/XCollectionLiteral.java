/**
 */
package xbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XCollection Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XCollectionLiteral#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see xbase.XbasePackage#getXCollectionLiteral()
 * @model abstract="true"
 * @generated
 */
public interface XCollectionLiteral extends EObject, XExpression {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see xbase.XbasePackage#getXCollectionLiteral_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getElements();

} // XCollectionLiteral
