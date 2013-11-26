/**
 */
package com.vectorsf.jvoice.model.base.impl;

import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.EventHandler;
import com.vectorsf.jvoice.model.base.EventsEnum;
import com.vectorsf.jvoice.model.base.JVBean;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Handler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.EventHandlerImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.EventHandlerImpl#getHandler <em>Handler</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventHandlerImpl extends MinimalEObjectImpl.Container implements EventHandler {
	/**
	 * The default value of the '{@link #getEvent() <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected static final EventsEnum EVENT_EDEFAULT = EventsEnum.BUSY;

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected EventsEnum event = EVENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHandler() <em>Handler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandler()
	 * @generated
	 * @ordered
	 */
	protected JVBean handler;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventHandlerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.EVENT_HANDLER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsEnum getEvent() {
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(EventsEnum newEvent) {
		EventsEnum oldEvent = event;
		event = newEvent == null ? EVENT_EDEFAULT : newEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.EVENT_HANDLER__EVENT, oldEvent, event));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVBean getHandler() {
		if (handler != null && handler.eIsProxy()) {
			InternalEObject oldHandler = (InternalEObject)handler;
			handler = (JVBean)eResolveProxy(oldHandler);
			if (handler != oldHandler) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BasePackage.EVENT_HANDLER__HANDLER, oldHandler, handler));
			}
		}
		return handler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVBean basicGetHandler() {
		return handler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHandler(JVBean newHandler) {
		JVBean oldHandler = handler;
		handler = newHandler;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.EVENT_HANDLER__HANDLER, oldHandler, handler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.EVENT_HANDLER__EVENT:
				return getEvent();
			case BasePackage.EVENT_HANDLER__HANDLER:
				if (resolve) return getHandler();
				return basicGetHandler();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BasePackage.EVENT_HANDLER__EVENT:
				setEvent((EventsEnum)newValue);
				return;
			case BasePackage.EVENT_HANDLER__HANDLER:
				setHandler((JVBean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BasePackage.EVENT_HANDLER__EVENT:
				setEvent(EVENT_EDEFAULT);
				return;
			case BasePackage.EVENT_HANDLER__HANDLER:
				setHandler((JVBean)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BasePackage.EVENT_HANDLER__EVENT:
				return event != EVENT_EDEFAULT;
			case BasePackage.EVENT_HANDLER__HANDLER:
				return handler != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (event: ");
		result.append(event);
		result.append(')');
		return result.toString();
	}

} //EventHandlerImpl
