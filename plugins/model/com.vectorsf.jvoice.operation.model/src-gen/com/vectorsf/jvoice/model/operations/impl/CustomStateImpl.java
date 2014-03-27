/**
 */
package com.vectorsf.jvoice.model.operations.impl;

import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.State;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.CustomStateImpl#getPath <em>Path</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.CustomStateImpl#getBindingBean <em>Binding Bean</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomStateImpl extends StateImpl implements CustomState {
	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getBindingBean() <em>Binding Bean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingBean()
	 * @generated
	 * @ordered
	 */
	protected static final String BINDING_BEAN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBindingBean() <em>Binding Bean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindingBean()
	 * @generated
	 * @ordered
	 */
	protected String bindingBean = BINDING_BEAN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.CUSTOM_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.CUSTOM_STATE__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBindingBean() {
		return bindingBean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindingBean(String newBindingBean) {
		String oldBindingBean = bindingBean;
		bindingBean = newBindingBean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.CUSTOM_STATE__BINDING_BEAN, oldBindingBean, bindingBean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEvents() {
		EList<String> ret = new BasicEList<String>();
		
		ret.add("ok");
		
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.CUSTOM_STATE__PATH:
				return getPath();
			case OperationsPackage.CUSTOM_STATE__BINDING_BEAN:
				return getBindingBean();
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
			case OperationsPackage.CUSTOM_STATE__PATH:
				setPath((String)newValue);
				return;
			case OperationsPackage.CUSTOM_STATE__BINDING_BEAN:
				setBindingBean((String)newValue);
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
			case OperationsPackage.CUSTOM_STATE__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case OperationsPackage.CUSTOM_STATE__BINDING_BEAN:
				setBindingBean(BINDING_BEAN_EDEFAULT);
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
			case OperationsPackage.CUSTOM_STATE__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case OperationsPackage.CUSTOM_STATE__BINDING_BEAN:
				return BINDING_BEAN_EDEFAULT == null ? bindingBean != null : !BINDING_BEAN_EDEFAULT.equals(bindingBean);
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
				case OperationsPackage.STATE___GET_EVENTS: return OperationsPackage.CUSTOM_STATE___GET_EVENTS;
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
			case OperationsPackage.CUSTOM_STATE___GET_EVENTS:
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
		result.append(" (path: ");
		result.append(path);
		result.append(", bindingBean: ");
		result.append(bindingBean);
		result.append(')');
		return result.toString();
	}

} //CustomStateImpl
