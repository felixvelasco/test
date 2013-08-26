/**
 */
package com.vectorsf.jvoice.base.impl;

import com.vectorsf.jvoice.base.BasePackage;
import com.vectorsf.jvoice.base.JVBean;
import com.vectorsf.jvoice.base.JVPackage;
import com.vectorsf.jvoice.base.JVProject;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JV Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.base.impl.JVPackageImpl#getBeans <em>Beans</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.base.impl.JVPackageImpl#getOwnerProject <em>Owner Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JVPackageImpl extends NamedElementImpl implements JVPackage {
	/**
	 * The cached value of the '{@link #getBeans() <em>Beans</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeans()
	 * @generated
	 * @ordered
	 */
	protected EList<JVBean> beans;

	/**
	 * The cached value of the '{@link #getOwnerProject() <em>Owner Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerProject()
	 * @generated
	 * @ordered
	 */
	protected JVProject ownerProject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JVPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.JV_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JVBean> getBeans() {
		if (beans == null) {
			beans = new EObjectContainmentWithInverseEList<JVBean>(JVBean.class, this, BasePackage.JV_PACKAGE__BEANS, BasePackage.JV_BEAN__OWNER_PACKAGE);
		}
		return beans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVProject getOwnerProject() {
		if (ownerProject != null && ownerProject.eIsProxy()) {
			InternalEObject oldOwnerProject = (InternalEObject)ownerProject;
			ownerProject = (JVProject)eResolveProxy(oldOwnerProject);
			if (ownerProject != oldOwnerProject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BasePackage.JV_PACKAGE__OWNER_PROJECT, oldOwnerProject, ownerProject));
			}
		}
		return ownerProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVProject basicGetOwnerProject() {
		return ownerProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnerProject(JVProject newOwnerProject, NotificationChain msgs) {
		JVProject oldOwnerProject = ownerProject;
		ownerProject = newOwnerProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BasePackage.JV_PACKAGE__OWNER_PROJECT, oldOwnerProject, newOwnerProject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerProject(JVProject newOwnerProject) {
		if (newOwnerProject != ownerProject) {
			NotificationChain msgs = null;
			if (ownerProject != null)
				msgs = ((InternalEObject)ownerProject).eInverseRemove(this, BasePackage.JV_PROJECT__PACKAGES, JVProject.class, msgs);
			if (newOwnerProject != null)
				msgs = ((InternalEObject)newOwnerProject).eInverseAdd(this, BasePackage.JV_PROJECT__PACKAGES, JVProject.class, msgs);
			msgs = basicSetOwnerProject(newOwnerProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.JV_PACKAGE__OWNER_PROJECT, newOwnerProject, newOwnerProject));
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
			case BasePackage.JV_PACKAGE__BEANS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBeans()).basicAdd(otherEnd, msgs);
			case BasePackage.JV_PACKAGE__OWNER_PROJECT:
				if (ownerProject != null)
					msgs = ((InternalEObject)ownerProject).eInverseRemove(this, BasePackage.JV_PROJECT__PACKAGES, JVProject.class, msgs);
				return basicSetOwnerProject((JVProject)otherEnd, msgs);
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
			case BasePackage.JV_PACKAGE__BEANS:
				return ((InternalEList<?>)getBeans()).basicRemove(otherEnd, msgs);
			case BasePackage.JV_PACKAGE__OWNER_PROJECT:
				return basicSetOwnerProject(null, msgs);
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
			case BasePackage.JV_PACKAGE__BEANS:
				return getBeans();
			case BasePackage.JV_PACKAGE__OWNER_PROJECT:
				if (resolve) return getOwnerProject();
				return basicGetOwnerProject();
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
			case BasePackage.JV_PACKAGE__BEANS:
				getBeans().clear();
				getBeans().addAll((Collection<? extends JVBean>)newValue);
				return;
			case BasePackage.JV_PACKAGE__OWNER_PROJECT:
				setOwnerProject((JVProject)newValue);
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
			case BasePackage.JV_PACKAGE__BEANS:
				getBeans().clear();
				return;
			case BasePackage.JV_PACKAGE__OWNER_PROJECT:
				setOwnerProject((JVProject)null);
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
			case BasePackage.JV_PACKAGE__BEANS:
				return beans != null && !beans.isEmpty();
			case BasePackage.JV_PACKAGE__OWNER_PROJECT:
				return ownerProject != null;
		}
		return super.eIsSet(featureID);
	}

} //JVPackageImpl
