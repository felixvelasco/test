/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl;

import com.vectorsf.jvoice.model.base.JVBean;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Voice Dsl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getConditions <em>Conditions</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getAudios <em>Audios</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getGrammars <em>Grammars</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getVariables <em>Variables</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getVoiceDsl()
 * @model
 * @generated
 */
public interface VoiceDsl extends JVBean {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference.
	 * @see #setConfiguration(Configuration)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getVoiceDsl_Configuration()
	 * @model containment="true"
	 * @generated
	 */
	Configuration getConfiguration();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getConfiguration <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' containment reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(Configuration value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.prompt.model.voiceDsl.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getVoiceDsl_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.prompt.model.voiceDsl.Condition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' containment reference list.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getVoiceDsl_Conditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Condition> getConditions();

	/**
	 * Returns the value of the '<em><b>Audios</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Audios</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Audios</em>' containment reference.
	 * @see #setAudios(Audios)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getVoiceDsl_Audios()
	 * @model containment="true"
	 * @generated
	 */
	Audios getAudios();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getAudios <em>Audios</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Audios</em>' containment reference.
	 * @see #getAudios()
	 * @generated
	 */
	void setAudios(Audios value);

	/**
	 * Returns the value of the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grammars</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grammars</em>' containment reference.
	 * @see #setGrammars(Grammars)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getVoiceDsl_Grammars()
	 * @model containment="true"
	 * @generated
	 */
	Grammars getGrammars();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getGrammars <em>Grammars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grammars</em>' containment reference.
	 * @see #getGrammars()
	 * @generated
	 */
	void setGrammars(Grammars value);

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference.
	 * @see #setOutputs(Outputs)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getVoiceDsl_Outputs()
	 * @model containment="true"
	 * @generated
	 */
	Outputs getOutputs();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getOutputs <em>Outputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outputs</em>' containment reference.
	 * @see #getOutputs()
	 * @generated
	 */
	void setOutputs(Outputs value);

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference.
	 * @see #setVariables(Variables)
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getVoiceDsl_Variables()
	 * @model containment="true"
	 * @generated
	 */
	Variables getVariables();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl#getVariables <em>Variables</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variables</em>' containment reference.
	 * @see #getVariables()
	 * @generated
	 */
	void setVariables(Variables value);

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.prompt.model.voiceDsl.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getVoiceDsl_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getTypes();

} // VoiceDsl
