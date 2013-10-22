/**
 */
package com.vectorsf.jvoice.model.base;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JV Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVApplication#getModule <em>Module</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVApplication()
 * @model
 * @generated
 */
public interface JVApplication extends JVProject {
	/**
	 * Returns the value of the '<em><b>Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' reference.
	 * @see #setModule(JVModule)
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVApplication_Module()
	 * @model
	 * @generated
	 */
	JVModule getModule();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.base.JVApplication#getModule <em>Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' reference.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(JVModule value);

} // JVApplication
