/**
 */
package IVR;

import Generic_BKS.State;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prompt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link IVR.Prompt#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see IVR.IVRPackage#getPrompt()
 * @model
 * @generated
 */
public interface Prompt extends State {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' reference.
	 * @see #setText(Literal)
	 * @see IVR.IVRPackage#getPrompt_Text()
	 * @model
	 * @generated
	 */
	Literal getText();

	/**
	 * Sets the value of the '{@link IVR.Prompt#getText <em>Text</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' reference.
	 * @see #getText()
	 * @generated
	 */
	void setText(Literal value);

} // Prompt
