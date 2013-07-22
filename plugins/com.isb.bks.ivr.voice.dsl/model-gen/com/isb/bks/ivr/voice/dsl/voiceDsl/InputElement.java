/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getGrammatics <em>Grammatics</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getName <em>Name</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxNoInput <em>Max No Input</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxNoMatch <em>Max No Match</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxAttempts <em>Max Attempts</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getInitialAudios <em>Initial Audios</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getNoMatchAudios <em>No Match Audios</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getNoInputAudios <em>No Input Audios</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMatchAudios <em>Match Audios</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getConditions <em>Conditions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement()
 * @model
 * @generated
 */
public interface InputElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Grammatics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grammatics</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grammatics</em>' containment reference.
	 * @see #setGrammatics(Grammar)
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_Grammatics()
	 * @model containment="true"
	 * @generated
	 */
	Grammar getGrammatics();

	/**
	 * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getGrammatics <em>Grammatics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grammatics</em>' containment reference.
	 * @see #getGrammatics()
	 * @generated
	 */
	void setGrammatics(Grammar value);

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
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Max No Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max No Input</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max No Input</em>' attribute.
	 * @see #setMaxNoInput(int)
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_MaxNoInput()
	 * @model
	 * @generated
	 */
	int getMaxNoInput();

	/**
	 * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxNoInput <em>Max No Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max No Input</em>' attribute.
	 * @see #getMaxNoInput()
	 * @generated
	 */
	void setMaxNoInput(int value);

	/**
	 * Returns the value of the '<em><b>Max No Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max No Match</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max No Match</em>' attribute.
	 * @see #setMaxNoMatch(int)
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_MaxNoMatch()
	 * @model
	 * @generated
	 */
	int getMaxNoMatch();

	/**
	 * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxNoMatch <em>Max No Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max No Match</em>' attribute.
	 * @see #getMaxNoMatch()
	 * @generated
	 */
	void setMaxNoMatch(int value);

	/**
	 * Returns the value of the '<em><b>Max Attempts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Attempts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Attempts</em>' attribute.
	 * @see #setMaxAttempts(int)
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_MaxAttempts()
	 * @model
	 * @generated
	 */
	int getMaxAttempts();

	/**
	 * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement#getMaxAttempts <em>Max Attempts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Attempts</em>' attribute.
	 * @see #getMaxAttempts()
	 * @generated
	 */
	void setMaxAttempts(int value);

	/**
	 * Returns the value of the '<em><b>Initial Audios</b></em>' containment reference list.
	 * The list contents are of type {@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Audios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Audios</em>' containment reference list.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_InitialAudios()
	 * @model containment="true"
	 * @generated
	 */
	EList<Audio> getInitialAudios();

	/**
	 * Returns the value of the '<em><b>No Match Audios</b></em>' containment reference list.
	 * The list contents are of type {@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Match Audios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Match Audios</em>' containment reference list.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_NoMatchAudios()
	 * @model containment="true"
	 * @generated
	 */
	EList<Audio> getNoMatchAudios();

	/**
	 * Returns the value of the '<em><b>No Input Audios</b></em>' containment reference list.
	 * The list contents are of type {@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Input Audios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Input Audios</em>' containment reference list.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_NoInputAudios()
	 * @model containment="true"
	 * @generated
	 */
	EList<Audio> getNoInputAudios();

	/**
	 * Returns the value of the '<em><b>Match Audios</b></em>' containment reference list.
	 * The list contents are of type {@link com.isb.bks.ivr.voice.dsl.voiceDsl.Audio}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match Audios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match Audios</em>' containment reference list.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_MatchAudios()
	 * @model containment="true"
	 * @generated
	 */
	EList<Audio> getMatchAudios();

	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link com.isb.bks.ivr.voice.dsl.voiceDsl.Condition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' containment reference list.
	 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getInputElement_Conditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Condition> getConditions();

} // InputElement
