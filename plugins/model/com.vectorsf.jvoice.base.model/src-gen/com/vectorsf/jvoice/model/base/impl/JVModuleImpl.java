/**
 */
package com.vectorsf.jvoice.model.base.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JV Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.JVModuleImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.JVModuleImpl#getComponentsPackage <em>Components Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JVModuleImpl extends JVProjectImpl implements JVModule {
	/**
	 * The cached value of the '{@link #getPackages() <em>Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<JVPackage> packages;

	/**
	 * The default value of the '{@link #getComponentsPackage() <em>Components Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentsPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENTS_PACKAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getComponentsPackage() <em>Components Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentsPackage()
	 * @generated
	 * @ordered
	 */
	protected String componentsPackage = COMPONENTS_PACKAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JVModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.JV_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<JVPackage> getPackages() {
		if (packages == null) {
			packages = new EObjectContainmentWithInverseEList.Resolving<JVPackage>(JVPackage.class, this, BasePackage.JV_MODULE__PACKAGES, BasePackage.JV_PACKAGE__OWNER_MODULE);
		}
		return packages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponentsPackage() {
		return componentsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentsPackage(String newComponentsPackage) {
		String oldComponentsPackage = componentsPackage;
		componentsPackage = newComponentsPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.JV_MODULE__COMPONENTS_PACKAGE, oldComponentsPackage, componentsPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVPackage getPackage(final String name) {
		for (JVPackage pck: getPackages()) {
			if (pck.getName().equals(name)) {
				return pck;
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.JV_MODULE__PACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPackages()).basicAdd(otherEnd, msgs);
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
			case BasePackage.JV_MODULE__PACKAGES:
				return ((InternalEList<?>)getPackages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.JV_MODULE__PACKAGES:
				return getPackages();
			case BasePackage.JV_MODULE__COMPONENTS_PACKAGE:
				return getComponentsPackage();
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
			case BasePackage.JV_MODULE__PACKAGES:
				getPackages().clear();
				getPackages().addAll((Collection<? extends JVPackage>)newValue);
				return;
			case BasePackage.JV_MODULE__COMPONENTS_PACKAGE:
				setComponentsPackage((String)newValue);
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
			case BasePackage.JV_MODULE__PACKAGES:
				getPackages().clear();
				return;
			case BasePackage.JV_MODULE__COMPONENTS_PACKAGE:
				setComponentsPackage(COMPONENTS_PACKAGE_EDEFAULT);
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
			case BasePackage.JV_MODULE__PACKAGES:
				return packages != null && !packages.isEmpty();
			case BasePackage.JV_MODULE__COMPONENTS_PACKAGE:
				return COMPONENTS_PACKAGE_EDEFAULT == null ? componentsPackage != null : !COMPONENTS_PACKAGE_EDEFAULT.equals(componentsPackage);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BasePackage.JV_MODULE___GET_PACKAGE__STRING:
				return getPackage((String)arguments.get(0));
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
		result.append(" (componentsPackage: ");
		result.append(componentsPackage);
		result.append(')');
		return result.toString();
	}

} //JVModuleImpl
