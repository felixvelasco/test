/**
 */
package com.vectorsf.jvoice.model.base;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Handler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.EventHandler#getEvent <em>Event</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.EventHandler#getHandler <em>Handler</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.base.BasePackage#getEventHandler()
 * @model
 * @generated
 */
public interface EventHandler extends EObject {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' attribute.
	 * The literals are from the enumeration {@link com.vectorsf.jvoice.model.base.EventsEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' attribute.
	 * @see com.vectorsf.jvoice.model.base.EventsEnum
	 * @see #setEvent(EventsEnum)
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getEventHandler_Event()
	 * @model
	 * @generated
	 */
	EventsEnum getEvent();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.base.EventHandler#getEvent <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' attribute.
	 * @see com.vectorsf.jvoice.model.base.EventsEnum
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(EventsEnum value);

	/**
	 * Returns the value of the '<em><b>Handler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handler</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handler</em>' reference.
	 * @see #setHandler(JVBean)
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getEventHandler_Handler()
	 * @model
	 * @generated
	 */
	JVBean getHandler();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.base.EventHandler#getHandler <em>Handler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handler</em>' reference.
	 * @see #getHandler()
	 * @generated
	 */
	void setHandler(JVBean value);

} // EventHandler
