/**
 */
package com.vectorsf.jvoice.model.operations.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.vectorsf.jvoice.model.operations.*;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Call Flow State</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.vectorsf.jvoice.model.operations.impl.CallFlowStateImpl#getSubflow <em>Subflow</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CallFlowStateImpl extends ParameterizedStateImpl implements CallFlowState {
	/**
	 * The cached value of the '{@link #getSubflow() <em>Subflow</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSubflow()
	 * @generated
	 * @ordered
	 */
	protected Flow subflow;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CallFlowStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.CALL_FLOW_STATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Flow getSubflow() {
		if (subflow != null && subflow.eIsProxy()) {
			InternalEObject oldSubflow = (InternalEObject)subflow;
			subflow = (Flow)eResolveProxy(oldSubflow);
			if (subflow != oldSubflow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationsPackage.CALL_FLOW_STATE__SUBFLOW, oldSubflow, subflow));
			}
		}
		return subflow;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Flow basicGetSubflow() {
		return subflow;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSubflow(Flow newSubflow) {
		Flow oldSubflow = subflow;
		subflow = newSubflow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.CALL_FLOW_STATE__SUBFLOW, oldSubflow, subflow));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getEvents() {
				org.eclipse.emf.common.util.BasicEList<String> list = new org.eclipse.emf.common.util.BasicEList<String>();
				list.add("busy");
				list.add("conn_error");
				list.add("error");
				list.add("far_end_disc");
				list.add("hangup");
				list.add("match");
				list.add("maxatt");
				list.add("maxtime");
				list.add("netw_busy");
				list.add("netw_disconnect");
				list.add("noanswer");
				list.add("noinput");
				list.add("nomatch");
				list.add("noresource");
				list.add("recorded");
				list.add("record_unsup");
				list.add("success");
				list.add("transferred");
				list.add("unknown");
		
				return list;
		
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.CALL_FLOW_STATE__SUBFLOW:
				if (resolve) return getSubflow();
				return basicGetSubflow();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperationsPackage.CALL_FLOW_STATE__SUBFLOW:
				setSubflow((Flow)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OperationsPackage.CALL_FLOW_STATE__SUBFLOW:
				setSubflow((Flow)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OperationsPackage.CALL_FLOW_STATE__SUBFLOW:
				return subflow != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == State.class) {
			switch (baseOperationID) {
				case OperationsPackage.STATE___GET_EVENTS: return OperationsPackage.CALL_FLOW_STATE___GET_EVENTS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OperationsPackage.CALL_FLOW_STATE___GET_EVENTS:
				return getEvents();
		}
		return super.eInvoke(operationID, arguments);
	}

} // CallFlowStateImpl
