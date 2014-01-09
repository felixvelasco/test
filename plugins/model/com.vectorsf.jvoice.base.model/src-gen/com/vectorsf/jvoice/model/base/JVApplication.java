/**
 */
package com.vectorsf.jvoice.model.base;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JV Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVApplication#getModule <em>Module</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVApplication#isLegacyLogger <em>Legacy Logger</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVApplication()
 * @model
 * @generated
 */
public interface JVApplication extends JVProject {
	/**
	 * Returns the value of the '<em><b>Module</b></em>' reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.base.JVModule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' reference list.
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVApplication_Module()
	 * @model
	 * @generated
	 */
	List<JVModule> getModule();

	/**
	 * Returns the value of the '<em><b>Legacy Logger</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Legacy Logger</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Legacy Logger</em>' attribute.
	 * @see #setLegacyLogger(boolean)
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVApplication_LegacyLogger()
	 * @model default="true"
	 * @generated
	 */
	boolean isLegacyLogger();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.base.JVApplication#isLegacyLogger <em>Legacy Logger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Legacy Logger</em>' attribute.
	 * @see #isLegacyLogger()
	 * @generated
	 */
	void setLegacyLogger(boolean value);

} // JVApplication
