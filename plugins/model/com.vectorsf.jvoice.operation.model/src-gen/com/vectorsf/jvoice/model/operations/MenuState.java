/**
 */
package com.vectorsf.jvoice.model.operations;

import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.MenuState#getLocution <em>Locution</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getMenuState()
 * @model
 * @generated
 */
public interface MenuState extends State {
	/**
	 * Returns the value of the '<em><b>Locution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locution</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locution</em>' reference.
	 * @see #setLocution(VoiceDsl)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getMenuState_Locution()
	 * @model
	 * @generated
	 */
	VoiceDsl getLocution();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.MenuState#getLocution <em>Locution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Locution</em>' reference.
	 * @see #getLocution()
	 * @generated
	 */
	void setLocution(VoiceDsl value);

} // MenuState
