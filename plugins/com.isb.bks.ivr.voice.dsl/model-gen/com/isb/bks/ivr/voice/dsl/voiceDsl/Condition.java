/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Condition#getCount <em>Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getCondition()
 * @model
 * @generated
 */
public interface Condition extends EObject {
	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(int)
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getCondition_Count()
	 * @model
	 * @generated
	 */
	int getCount();

	/**
	 * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Condition#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(int value);

} // Condition
