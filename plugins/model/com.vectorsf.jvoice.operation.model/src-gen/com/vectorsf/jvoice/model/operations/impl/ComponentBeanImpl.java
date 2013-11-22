/**
 */
package com.vectorsf.jvoice.model.operations.impl;

import com.vectorsf.jvoice.model.base.impl.NamedElementImpl;

import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Bean</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.ComponentBeanImpl#getFqdn <em>Fqdn</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.ComponentBeanImpl#getNameBean <em>Name Bean</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentBeanImpl extends NamedElementImpl implements ComponentBean {
	/**
	 * The default value of the '{@link #getFqdn() <em>Fqdn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFqdn()
	 * @generated
	 * @ordered
	 */
	protected static final String FQDN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFqdn() <em>Fqdn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFqdn()
	 * @generated
	 * @ordered
	 */
	protected String fqdn = FQDN_EDEFAULT;

	/**
	 * The default value of the '{@link #getNameBean() <em>Name Bean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameBean()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_BEAN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNameBean() <em>Name Bean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameBean()
	 * @generated
	 * @ordered
	 */
	protected String nameBean = NAME_BEAN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentBeanImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.COMPONENT_BEAN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFqdn() {
		return fqdn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFqdn(String newFqdn) {
		String oldFqdn = fqdn;
		fqdn = newFqdn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.COMPONENT_BEAN__FQDN, oldFqdn, fqdn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNameBean() {
		return nameBean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameBean(String newNameBean) {
		String oldNameBean = nameBean;
		nameBean = newNameBean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.COMPONENT_BEAN__NAME_BEAN, oldNameBean, nameBean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.COMPONENT_BEAN__FQDN:
				return getFqdn();
			case OperationsPackage.COMPONENT_BEAN__NAME_BEAN:
				return getNameBean();
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
			case OperationsPackage.COMPONENT_BEAN__FQDN:
				setFqdn((String)newValue);
				return;
			case OperationsPackage.COMPONENT_BEAN__NAME_BEAN:
				setNameBean((String)newValue);
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
			case OperationsPackage.COMPONENT_BEAN__FQDN:
				setFqdn(FQDN_EDEFAULT);
				return;
			case OperationsPackage.COMPONENT_BEAN__NAME_BEAN:
				setNameBean(NAME_BEAN_EDEFAULT);
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
			case OperationsPackage.COMPONENT_BEAN__FQDN:
				return FQDN_EDEFAULT == null ? fqdn != null : !FQDN_EDEFAULT.equals(fqdn);
			case OperationsPackage.COMPONENT_BEAN__NAME_BEAN:
				return NAME_BEAN_EDEFAULT == null ? nameBean != null : !NAME_BEAN_EDEFAULT.equals(nameBean);
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
		result.append(" (fqdn: ");
		result.append(fqdn);
		result.append(", nameBean: ");
		result.append(nameBean);
		result.append(')');
		return result.toString();
	}

} //ComponentBeanImpl
