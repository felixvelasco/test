/**
 */
package IVR;

import Generic_BKS.State;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link IVR.Menu#getTexts <em>Texts</em>}</li>
 * </ul>
 * </p>
 *
 * @see IVR.IVRPackage#getMenu()
 * @model
 * @generated
 */
public interface Menu extends State {
	/**
	 * Returns the value of the '<em><b>Texts</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Texts</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texts</em>' reference.
	 * @see #setTexts(Literal)
	 * @see IVR.IVRPackage#getMenu_Texts()
	 * @model
	 * @generated
	 */
	Literal getTexts();

	/**
	 * Sets the value of the '{@link IVR.Menu#getTexts <em>Texts</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texts</em>' reference.
	 * @see #getTexts()
	 * @generated
	 */
	void setTexts(Literal value);

} // Menu
