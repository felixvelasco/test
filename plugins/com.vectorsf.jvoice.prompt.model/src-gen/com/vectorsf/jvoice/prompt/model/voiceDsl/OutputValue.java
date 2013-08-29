/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.OutputValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getOutputValue()
 * @model
 * @generated
 */
public interface OutputValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getOutputValue_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.OutputValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // OutputValue
