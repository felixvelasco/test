/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grammar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#getMode <em>Mode</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#isBuiltin <em>Builtin</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#getSrc <em>Src</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getGrammar()
 * @model
 * @generated
 */
public interface Grammar extends EObject
{
  /**
   * Returns the value of the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mode</em>' attribute.
   * @see #setMode(String)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getGrammar_Mode()
   * @model
   * @generated
   */
  String getMode();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#getMode <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mode</em>' attribute.
   * @see #getMode()
   * @generated
   */
  void setMode(String value);

  /**
   * Returns the value of the '<em><b>Builtin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Builtin</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Builtin</em>' attribute.
   * @see #setBuiltin(boolean)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getGrammar_Builtin()
   * @model
   * @generated
   */
  boolean isBuiltin();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#isBuiltin <em>Builtin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Builtin</em>' attribute.
   * @see #isBuiltin()
   * @generated
   */
  void setBuiltin(boolean value);

  /**
   * Returns the value of the '<em><b>Src</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Src</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Src</em>' attribute.
   * @see #setSrc(String)
   * @see com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage#getGrammar_Src()
   * @model
   * @generated
   */
  String getSrc();

  /**
   * Sets the value of the '{@link com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar#getSrc <em>Src</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Src</em>' attribute.
   * @see #getSrc()
   * @generated
   */
  void setSrc(String value);

} // Grammar
