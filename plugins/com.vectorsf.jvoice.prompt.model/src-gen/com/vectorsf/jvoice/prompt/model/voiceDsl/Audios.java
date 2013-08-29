/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Audios</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getMainAudios <em>Main Audios</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getNoMatchAudios <em>No Match Audios</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getNoInputAudios <em>No Input Audios</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audios#getMatchAudios <em>Match Audios</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getAudios()
 * @model
 * @generated
 */
public interface Audios extends EObject {
	/**
	 * Returns the value of the '<em><b>Main Audios</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Audios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Audios</em>' containment reference list.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getAudios_MainAudios()
	 * @model containment="true"
	 * @generated
	 */
	EList<Audio> getMainAudios();

	/**
	 * Returns the value of the '<em><b>No Match Audios</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Match Audios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Match Audios</em>' containment reference list.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getAudios_NoMatchAudios()
	 * @model containment="true"
	 * @generated
	 */
	EList<Audio> getNoMatchAudios();

	/**
	 * Returns the value of the '<em><b>No Input Audios</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Input Audios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Input Audios</em>' containment reference list.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getAudios_NoInputAudios()
	 * @model containment="true"
	 * @generated
	 */
	EList<Audio> getNoInputAudios();

	/**
	 * Returns the value of the '<em><b>Match Audios</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match Audios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match Audios</em>' containment reference list.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getAudios_MatchAudios()
	 * @model containment="true"
	 * @generated
	 */
	EList<Audio> getMatchAudios();

} // Audios
