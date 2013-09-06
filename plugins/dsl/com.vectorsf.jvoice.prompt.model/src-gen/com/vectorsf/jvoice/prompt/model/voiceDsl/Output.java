/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Output#getName <em>Name</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Output#getOutputValue <em>Output Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getOutput()
 * @model
 * @generated
 */
public interface Output extends EObject {
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
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getOutput_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Output#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Output Value</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.prompt.model.voiceDsl.OutputValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Value</em>' containment reference list.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getOutput_OutputValue()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputValue> getOutputValue();

} // Output
