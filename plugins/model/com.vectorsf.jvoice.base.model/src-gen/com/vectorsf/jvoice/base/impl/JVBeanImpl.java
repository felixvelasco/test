/**
 */
package com.vectorsf.jvoice.base.impl;

import com.vectorsf.jvoice.base.BasePackage;
import com.vectorsf.jvoice.base.JVBean;
import com.vectorsf.jvoice.base.JVPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JV Bean</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.base.impl.JVBeanImpl#getOwnerPackage <em>Owner Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class JVBeanImpl extends NamedElementImpl implements JVBean {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JVBeanImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.JV_BEAN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVPackage getOwnerPackage() {
		if (eContainerFeatureID() != BasePackage.JV_BEAN__OWNER_PACKAGE) return null;
		return (JVPackage)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnerPackage(JVPackage newOwnerPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwnerPackage, BasePackage.JV_BEAN__OWNER_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerPackage(JVPackage newOwnerPackage) {
		if (newOwnerPackage != eInternalContainer() || (eContainerFeatureID() != BasePackage.JV_BEAN__OWNER_PACKAGE && newOwnerPackage != null)) {
			if (EcoreUtil.isAncestor(this, newOwnerPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwnerPackage != null)
				msgs = ((InternalEObject)newOwnerPackage).eInverseAdd(this, BasePackage.JV_PACKAGE__BEANS, JVPackage.class, msgs);
			msgs = basicSetOwnerPackage(newOwnerPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.JV_BEAN__OWNER_PACKAGE, newOwnerPackage, newOwnerPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.JV_BEAN__OWNER_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwnerPackage((JVPackage)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.JV_BEAN__OWNER_PACKAGE:
				return basicSetOwnerPackage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case BasePackage.JV_BEAN__OWNER_PACKAGE:
				return eInternalContainer().eInverseRemove(this, BasePackage.JV_PACKAGE__BEANS, JVPackage.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.JV_BEAN__OWNER_PACKAGE:
				return getOwnerPackage();
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
			case BasePackage.JV_BEAN__OWNER_PACKAGE:
				setOwnerPackage((JVPackage)newValue);
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
			case BasePackage.JV_BEAN__OWNER_PACKAGE:
				setOwnerPackage((JVPackage)null);
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
			case BasePackage.JV_BEAN__OWNER_PACKAGE:
				return getOwnerPackage() != null;
		}
		return super.eIsSet(featureID);
	}

} //JVBeanImpl
