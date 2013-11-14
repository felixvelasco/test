/**
 */
package com.vectorsf.jvoice.model.base.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JV Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.JVPackageImpl#getBeans <em>Beans</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.JVPackageImpl#getOwnerModule <em>Owner Module</em>}</li>
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
	public List<JVBean> getBeans() {
		if (beans == null) {
			beans = new EObjectContainmentWithInverseEList.Resolving<JVBean>(JVBean.class, this, BasePackage.JV_PACKAGE__BEANS, BasePackage.JV_BEAN__OWNER_PACKAGE);
		}
		return beans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVModule getOwnerModule() {
		if (eContainerFeatureID() != BasePackage.JV_PACKAGE__OWNER_MODULE) return null;
		return (JVModule)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVModule basicGetOwnerModule() {
		if (eContainerFeatureID() != BasePackage.JV_PACKAGE__OWNER_MODULE) return null;
		return (JVModule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnerModule(JVModule newOwnerModule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwnerModule, BasePackage.JV_PACKAGE__OWNER_MODULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerModule(JVModule newOwnerModule) {
		if (newOwnerModule != eInternalContainer() || (eContainerFeatureID() != BasePackage.JV_PACKAGE__OWNER_MODULE && newOwnerModule != null)) {
			if (EcoreUtil.isAncestor(this, newOwnerModule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwnerModule != null)
				msgs = ((InternalEObject)newOwnerModule).eInverseAdd(this, BasePackage.JV_MODULE__PACKAGES, JVModule.class, msgs);
			msgs = basicSetOwnerModule(newOwnerModule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.JV_PACKAGE__OWNER_MODULE, newOwnerModule, newOwnerModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVBean getBean(final String name) {
		for (JVBean bean: getBeans()) {
			if (bean.getName().equals(name)) {
				return bean;
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
			case BasePackage.JV_PACKAGE__BEANS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBeans()).basicAdd(otherEnd, msgs);
			case BasePackage.JV_PACKAGE__OWNER_MODULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwnerModule((JVModule)otherEnd, msgs);
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
			case BasePackage.JV_PACKAGE__OWNER_MODULE:
				return basicSetOwnerModule(null, msgs);
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
			case BasePackage.JV_PACKAGE__OWNER_MODULE:
				return eInternalContainer().eInverseRemove(this, BasePackage.JV_MODULE__PACKAGES, JVModule.class, msgs);
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
			case BasePackage.JV_PACKAGE__BEANS:
				return getBeans();
			case BasePackage.JV_PACKAGE__OWNER_MODULE:
				if (resolve) return getOwnerModule();
				return basicGetOwnerModule();
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
			case BasePackage.JV_PACKAGE__OWNER_MODULE:
				setOwnerModule((JVModule)newValue);
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
			case BasePackage.JV_PACKAGE__OWNER_MODULE:
				setOwnerModule((JVModule)null);
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
			case BasePackage.JV_PACKAGE__OWNER_MODULE:
				return basicGetOwnerModule() != null;
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
			case BasePackage.JV_PACKAGE___GET_BEAN__STRING:
				return getBean((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //JVPackageImpl
