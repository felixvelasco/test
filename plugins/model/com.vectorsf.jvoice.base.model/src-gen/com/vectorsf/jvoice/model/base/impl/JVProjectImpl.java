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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.Configuration;
import com.vectorsf.jvoice.model.base.EventHandler;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JV Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.JVProjectImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.JVProjectImpl#getModel <em>Model</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.JVProjectImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.JVProjectImpl#getHandlers <em>Handlers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class JVProjectImpl extends NamedElementImpl implements JVProject {
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
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<Configuration> configuration;

	/**
	 * The cached value of the '{@link #getHandlers() <em>Handlers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandlers()
	 * @generated
	 * @ordered
	 */
	protected EList<EventHandler> handlers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JVProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.JV_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<JVPackage> getPackages() {
		if (packages == null) {
			packages = new EObjectContainmentWithInverseEList.Resolving<JVPackage>(JVPackage.class, this, BasePackage.JV_PROJECT__PACKAGES, BasePackage.JV_PACKAGE__OWNER_PROJECT);
		}
		return packages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVModel getModel() {
		if (eContainerFeatureID() != BasePackage.JV_PROJECT__MODEL) return null;
		return (JVModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVModel basicGetModel() {
		if (eContainerFeatureID() != BasePackage.JV_PROJECT__MODEL) return null;
		return (JVModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModel(JVModel newModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newModel, BasePackage.JV_PROJECT__MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(JVModel newModel) {
		if (newModel != eInternalContainer() || (eContainerFeatureID() != BasePackage.JV_PROJECT__MODEL && newModel != null)) {
			if (EcoreUtil.isAncestor(this, newModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModel != null)
				msgs = ((InternalEObject)newModel).eInverseAdd(this, BasePackage.JV_MODEL__PROJECTS, JVModel.class, msgs);
			msgs = basicSetModel(newModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.JV_PROJECT__MODEL, newModel, newModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Configuration> getConfiguration() {
		if (configuration == null) {
			configuration = new EObjectContainmentEList.Resolving<Configuration>(Configuration.class, this, BasePackage.JV_PROJECT__CONFIGURATION);
		}
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<EventHandler> getHandlers() {
		if (handlers == null) {
			handlers = new EObjectContainmentEList.Resolving<EventHandler>(EventHandler.class, this, BasePackage.JV_PROJECT__HANDLERS);
		}
		return handlers;
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
	public Configuration getConfiguration(final String name) {
		for (Configuration conf: getConfiguration()) {
			if (conf.getName().equals(name)) {
				return conf;
			}
		}
				
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<JVProject> getReferencedProjects() {
		return BaseModel.getInstance().getVisibleProjects(this);
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
			case BasePackage.JV_PROJECT__PACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPackages()).basicAdd(otherEnd, msgs);
			case BasePackage.JV_PROJECT__MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetModel((JVModel)otherEnd, msgs);
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
			case BasePackage.JV_PROJECT__PACKAGES:
				return ((InternalEList<?>)getPackages()).basicRemove(otherEnd, msgs);
			case BasePackage.JV_PROJECT__MODEL:
				return basicSetModel(null, msgs);
			case BasePackage.JV_PROJECT__CONFIGURATION:
				return ((InternalEList<?>)getConfiguration()).basicRemove(otherEnd, msgs);
			case BasePackage.JV_PROJECT__HANDLERS:
				return ((InternalEList<?>)getHandlers()).basicRemove(otherEnd, msgs);
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
			case BasePackage.JV_PROJECT__MODEL:
				return eInternalContainer().eInverseRemove(this, BasePackage.JV_MODEL__PROJECTS, JVModel.class, msgs);
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
			case BasePackage.JV_PROJECT__PACKAGES:
				return getPackages();
			case BasePackage.JV_PROJECT__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case BasePackage.JV_PROJECT__CONFIGURATION:
				return getConfiguration();
			case BasePackage.JV_PROJECT__HANDLERS:
				return getHandlers();
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
			case BasePackage.JV_PROJECT__PACKAGES:
				getPackages().clear();
				getPackages().addAll((Collection<? extends JVPackage>)newValue);
				return;
			case BasePackage.JV_PROJECT__MODEL:
				setModel((JVModel)newValue);
				return;
			case BasePackage.JV_PROJECT__CONFIGURATION:
				getConfiguration().clear();
				getConfiguration().addAll((Collection<? extends Configuration>)newValue);
				return;
			case BasePackage.JV_PROJECT__HANDLERS:
				getHandlers().clear();
				getHandlers().addAll((Collection<? extends EventHandler>)newValue);
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
			case BasePackage.JV_PROJECT__PACKAGES:
				getPackages().clear();
				return;
			case BasePackage.JV_PROJECT__MODEL:
				setModel((JVModel)null);
				return;
			case BasePackage.JV_PROJECT__CONFIGURATION:
				getConfiguration().clear();
				return;
			case BasePackage.JV_PROJECT__HANDLERS:
				getHandlers().clear();
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
			case BasePackage.JV_PROJECT__PACKAGES:
				return packages != null && !packages.isEmpty();
			case BasePackage.JV_PROJECT__MODEL:
				return basicGetModel() != null;
			case BasePackage.JV_PROJECT__CONFIGURATION:
				return configuration != null && !configuration.isEmpty();
			case BasePackage.JV_PROJECT__HANDLERS:
				return handlers != null && !handlers.isEmpty();
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
			case BasePackage.JV_PROJECT___GET_PACKAGE__STRING:
				return getPackage((String)arguments.get(0));
			case BasePackage.JV_PROJECT___GET_CONFIGURATION__STRING:
				return getConfiguration((String)arguments.get(0));
			case BasePackage.JV_PROJECT___GET_REFERENCED_PROJECTS:
				return getReferencedProjects();
		}
		return super.eInvoke(operationID, arguments);
	}

} //JVProjectImpl
