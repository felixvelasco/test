/**
 */
package Core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Core.FlowElement#getFlow <em>Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @see Core.CorePackage#getFlowElement()
 * @model
 * @generated
 */
public interface FlowElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Flow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flow</em>' attribute.
	 * @see #setFlow(String)
	 * @see Core.CorePackage#getFlowElement_Flow()
	 * @model
	 * @generated
	 */
	String getFlow();

	/**
	 * Sets the value of the '{@link Core.FlowElement#getFlow <em>Flow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flow</em>' attribute.
	 * @see #getFlow()
	 * @generated
	 */
	void setFlow(String value);

} // FlowElement
