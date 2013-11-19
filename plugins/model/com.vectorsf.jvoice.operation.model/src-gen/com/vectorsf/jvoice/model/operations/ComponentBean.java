/**
 */
package com.vectorsf.jvoice.model.operations;

import com.vectorsf.jvoice.model.base.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Bean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.ComponentBean#getFqdn <em>Fqdn</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getComponentBean()
 * @model
 * @generated
 */
public interface ComponentBean extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Fqdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fqdn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fqdn</em>' attribute.
	 * @see #setFqdn(String)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getComponentBean_Fqdn()
	 * @model
	 * @generated
	 */
	String getFqdn();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.ComponentBean#getFqdn <em>Fqdn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fqdn</em>' attribute.
	 * @see #getFqdn()
	 * @generated
	 */
	void setFqdn(String value);

} // ComponentBean
