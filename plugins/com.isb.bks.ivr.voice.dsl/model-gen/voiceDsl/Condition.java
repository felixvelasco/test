/**
 */
package voiceDsl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link voiceDsl.Condition#getCondition <em>Condition</em>}</li>
 *   <li>{@link voiceDsl.Condition#getName <em>Name</em>}</li>
 *   <li>{@link voiceDsl.Condition#getExpre <em>Expre</em>}</li>
 * </ul>
 * </p>
 *
 * @see voiceDsl.VoiceDslPackage#getCondition()
 * @model
 * @generated
 */
public interface Condition extends EObject {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(int)
	 * @see voiceDsl.VoiceDslPackage#getCondition_Condition()
	 * @model
	 * @generated
	 */
	int getCondition();

	/**
	 * Sets the value of the '{@link voiceDsl.Condition#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see voiceDsl.VoiceDslPackage#getCondition_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link voiceDsl.Condition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Expre</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expre</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expre</em>' containment reference.
	 * @see #setExpre(XExpression)
	 * @see voiceDsl.VoiceDslPackage#getCondition_Expre()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpre();

	/**
	 * Sets the value of the '{@link voiceDsl.Condition#getExpre <em>Expre</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expre</em>' containment reference.
	 * @see #getExpre()
	 * @generated
	 */
	void setExpre(XExpression value);

} // Condition
