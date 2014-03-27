/**
 */
package com.vectorsf.jvoice.model.operations.impl;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.State;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Flow State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.CallFlowStateImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.CallFlowStateImpl#getSubflow <em>Subflow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallFlowStateImpl extends StateImpl implements CallFlowState {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<String> parameters;

	/**
	 * The cached value of the '{@link #getSubflow() <em>Subflow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubflow()
	 * @generated
	 * @ordered
	 */
	protected Flow subflow;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallFlowStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.CALL_FLOW_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getParameters() {
		if (parameters == null) {
			parameters = new EDataTypeEList<String>(String.class, this, OperationsPackage.CALL_FLOW_STATE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow basicGetSubflow() {
		return subflow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubflow(Flow newSubflow) {
		Flow oldSubflow = subflow;
		subflow = newSubflow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.CALL_FLOW_STATE__SUBFLOW, oldSubflow, subflow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEvents() {
		EList<String> list = new BasicEList<String>();
		
		for(State state: getSubflow().getStates()) {
			if (state instanceof FinalState && !((FinalState)state).isFinal()) {
				list.add(state.getName());
			}
		}
		return list;
		
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.CALL_FLOW_STATE__PARAMETERS:
				return getParameters();
			case OperationsPackage.CALL_FLOW_STATE__SUBFLOW:
				if (resolve) return getSubflow();
				return basicGetSubflow();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperationsPackage.CALL_FLOW_STATE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends String>)newValue);
				return;
			case OperationsPackage.CALL_FLOW_STATE__SUBFLOW:
				setSubflow((Flow)newValue);
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
			case OperationsPackage.CALL_FLOW_STATE__PARAMETERS:
				getParameters().clear();
				return;
			case OperationsPackage.CALL_FLOW_STATE__SUBFLOW:
				setSubflow((Flow)null);
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
			case OperationsPackage.CALL_FLOW_STATE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case OperationsPackage.CALL_FLOW_STATE__SUBFLOW:
				return subflow != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (parameters: ");
		result.append(parameters);
		result.append(')');
		return result.toString();
	}

} //CallFlowStateImpl
