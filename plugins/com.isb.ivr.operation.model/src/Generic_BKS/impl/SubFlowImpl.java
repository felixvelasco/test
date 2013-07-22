/**
 */
package Generic_BKS.impl;

import Generic_BKS.Flow;
import Generic_BKS.Generic_BKSPackage;
import Generic_BKS.SubFlow;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Generic_BKS.impl.SubFlowImpl#getCalledFlow <em>Called Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubFlowImpl extends StateImpl implements SubFlow {
	/**
	 * The cached value of the '{@link #getCalledFlow() <em>Called Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalledFlow()
	 * @generated
	 * @ordered
	 */
	protected Flow calledFlow;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Generic_BKSPackage.Literals.SUB_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow getCalledFlow() {
		if (calledFlow != null && calledFlow.eIsProxy()) {
			InternalEObject oldCalledFlow = (InternalEObject)calledFlow;
			calledFlow = (Flow)eResolveProxy(oldCalledFlow);
			if (calledFlow != oldCalledFlow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Generic_BKSPackage.SUB_FLOW__CALLED_FLOW, oldCalledFlow, calledFlow));
			}
		}
		return calledFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow basicGetCalledFlow() {
		return calledFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalledFlow(Flow newCalledFlow) {
		Flow oldCalledFlow = calledFlow;
		calledFlow = newCalledFlow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Generic_BKSPackage.SUB_FLOW__CALLED_FLOW, oldCalledFlow, calledFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Generic_BKSPackage.SUB_FLOW__CALLED_FLOW:
				if (resolve) return getCalledFlow();
				return basicGetCalledFlow();
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
			case Generic_BKSPackage.SUB_FLOW__CALLED_FLOW:
				setCalledFlow((Flow)newValue);
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
			case Generic_BKSPackage.SUB_FLOW__CALLED_FLOW:
				setCalledFlow((Flow)null);
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
			case Generic_BKSPackage.SUB_FLOW__CALLED_FLOW:
				return calledFlow != null;
		}
		return super.eIsSet(featureID);
	}

} //SubFlowImpl
