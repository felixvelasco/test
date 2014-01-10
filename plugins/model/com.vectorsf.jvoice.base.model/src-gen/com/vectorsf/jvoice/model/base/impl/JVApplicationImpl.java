/**
 */
package com.vectorsf.jvoice.model.base.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.JVApplication;
import com.vectorsf.jvoice.model.base.JVModule;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JV Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.JVApplicationImpl#getModule <em>Module</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.impl.JVApplicationImpl#isLegacyLogger <em>Legacy Logger</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JVApplicationImpl extends JVProjectImpl implements JVApplication {
	/**
	 * The cached value of the '{@link #getModule() <em>Module</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModule()
	 * @generated
	 * @ordered
	 */
	protected EList<JVModule> module;

	/**
	 * The default value of the '{@link #isLegacyLogger() <em>Legacy Logger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLegacyLogger()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LEGACY_LOGGER_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isLegacyLogger() <em>Legacy Logger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLegacyLogger()
	 * @generated
	 * @ordered
	 */
	protected boolean legacyLogger = LEGACY_LOGGER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JVApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.JV_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<JVModule> getModule() {
		if (module == null) {
			module = new EObjectResolvingEList<JVModule>(JVModule.class, this, BasePackage.JV_APPLICATION__MODULE);
		}
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLegacyLogger() {
		return legacyLogger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLegacyLogger(boolean newLegacyLogger) {
		boolean oldLegacyLogger = legacyLogger;
		legacyLogger = newLegacyLogger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.JV_APPLICATION__LEGACY_LOGGER, oldLegacyLogger, legacyLogger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.JV_APPLICATION__MODULE:
				return getModule();
			case BasePackage.JV_APPLICATION__LEGACY_LOGGER:
				return isLegacyLogger();
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
			case BasePackage.JV_APPLICATION__MODULE:
				getModule().clear();
				getModule().addAll((Collection<? extends JVModule>)newValue);
				return;
			case BasePackage.JV_APPLICATION__LEGACY_LOGGER:
				setLegacyLogger((Boolean)newValue);
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
			case BasePackage.JV_APPLICATION__MODULE:
				getModule().clear();
				return;
			case BasePackage.JV_APPLICATION__LEGACY_LOGGER:
				setLegacyLogger(LEGACY_LOGGER_EDEFAULT);
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
			case BasePackage.JV_APPLICATION__MODULE:
				return module != null && !module.isEmpty();
			case BasePackage.JV_APPLICATION__LEGACY_LOGGER:
				return legacyLogger != LEGACY_LOGGER_EDEFAULT;
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
		result.append(" (legacyLogger: ");
		result.append(legacyLogger);
		result.append(')');
		return result.toString();
	}

} //JVApplicationImpl
