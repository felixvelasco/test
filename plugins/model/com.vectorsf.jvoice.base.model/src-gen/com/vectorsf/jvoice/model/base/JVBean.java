/**
 */
package com.vectorsf.jvoice.model.base;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JV Bean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVBean#getOwnerPackage <em>Owner Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVBean()
 * @model abstract="true"
 * @generated
 */
public interface JVBean extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owner Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.model.base.JVPackage#getBeans <em>Beans</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Package</em>' container reference.
	 * @see #setOwnerPackage(JVPackage)
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVBean_OwnerPackage()
	 * @see com.vectorsf.jvoice.model.base.JVPackage#getBeans
	 * @model opposite="beans"
	 * @generated
	 */
	JVPackage getOwnerPackage();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.base.JVBean#getOwnerPackage <em>Owner Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Package</em>' container reference.
	 * @see #getOwnerPackage()
	 * @generated
	 */
	void setOwnerPackage(JVPackage value);

} // JVBean
