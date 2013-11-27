/**
 */
package com.vectorsf.jvoice.model.operations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Call State</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.CallStateImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.CallStateImpl#getBean <em>Bean</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallStateImpl extends ParameterizedStateImpl implements CallState {
	/**
	 * The default value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected String methodName = METHOD_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBean() <em>Bean</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getBean()
	 * @generated
	 * @ordered
	 */
	protected ComponentBean bean;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CallStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.CALL_STATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMethodName() {
		return methodName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMethodName(String newMethodName) {
		String oldMethodName = methodName;
		methodName = newMethodName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.CALL_STATE__METHOD_NAME, oldMethodName, methodName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentBean getBean() {
		if (bean != null && bean.eIsProxy()) {
			InternalEObject oldBean = (InternalEObject)bean;
			bean = (ComponentBean)eResolveProxy(oldBean);
			if (bean != oldBean) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationsPackage.CALL_STATE__BEAN, oldBean, bean));
			}
		}
		return bean;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentBean basicGetBean() {
		return bean;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBean(ComponentBean newBean) {
		ComponentBean oldBean = bean;
		bean = newBean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.CALL_STATE__BEAN, oldBean, bean));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.CALL_STATE__METHOD_NAME:
				return getMethodName();
			case OperationsPackage.CALL_STATE__BEAN:
				if (resolve) return getBean();
				return basicGetBean();
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
			case OperationsPackage.CALL_STATE__METHOD_NAME:
				setMethodName((String)newValue);
				return;
			case OperationsPackage.CALL_STATE__BEAN:
				setBean((ComponentBean)newValue);
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
			case OperationsPackage.CALL_STATE__METHOD_NAME:
				setMethodName(METHOD_NAME_EDEFAULT);
				return;
			case OperationsPackage.CALL_STATE__BEAN:
				setBean((ComponentBean)null);
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
			case OperationsPackage.CALL_STATE__METHOD_NAME:
				return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
			case OperationsPackage.CALL_STATE__BEAN:
				return bean != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (methodName: ");
		result.append(methodName);
		result.append(')');
		return result.toString();
	}

} // CallStateImpl
