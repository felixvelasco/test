/**
 */
package com.vectorsf.jvoice.model.operations.impl;

import com.vectorsf.jvoice.model.operations.ExecutableState;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

import com.vectorsf.jvoice.model.operations.ParameterizedState;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Locution State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.LocutionStateImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.LocutionStateImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.LocutionStateImpl#getLocution <em>Locution</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.LocutionStateImpl#isTextual <em>Textual</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LocutionStateImpl extends StateImpl implements LocutionState {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<String> parameters;
	/**
	 * The default value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected String methodName = METHOD_NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getLocution() <em>Locution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocution()
	 * @generated
	 * @ordered
	 */
	protected VoiceDsl locution;

	/**
	 * The default value of the '{@link #isTextual() <em>Textual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTextual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TEXTUAL_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isTextual() <em>Textual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTextual()
	 * @generated
	 * @ordered
	 */
	protected boolean textual = TEXTUAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocutionStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.LOCUTION_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getParameters() {
		if (parameters == null) {
			parameters = new EDataTypeEList<String>(String.class, this, OperationsPackage.LOCUTION_STATE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodName(String newMethodName) {
		String oldMethodName = methodName;
		methodName = newMethodName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.LOCUTION_STATE__METHOD_NAME, oldMethodName, methodName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoiceDsl getLocution() {
		if (locution != null && locution.eIsProxy()) {
			InternalEObject oldLocution = (InternalEObject)locution;
			locution = (VoiceDsl)eResolveProxy(oldLocution);
			if (locution != oldLocution) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationsPackage.LOCUTION_STATE__LOCUTION, oldLocution, locution));
			}
		}
		return locution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoiceDsl basicGetLocution() {
		return locution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocution(VoiceDsl newLocution) {
		VoiceDsl oldLocution = locution;
		locution = newLocution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.LOCUTION_STATE__LOCUTION, oldLocution, locution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTextual() {
		return textual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextual(boolean newTextual) {
		boolean oldTextual = textual;
		textual = newTextual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.LOCUTION_STATE__TEXTUAL, oldTextual, textual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.LOCUTION_STATE__PARAMETERS:
				return getParameters();
			case OperationsPackage.LOCUTION_STATE__METHOD_NAME:
				return getMethodName();
			case OperationsPackage.LOCUTION_STATE__LOCUTION:
				if (resolve) return getLocution();
				return basicGetLocution();
			case OperationsPackage.LOCUTION_STATE__TEXTUAL:
				return isTextual();
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
			case OperationsPackage.LOCUTION_STATE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends String>)newValue);
				return;
			case OperationsPackage.LOCUTION_STATE__METHOD_NAME:
				setMethodName((String)newValue);
				return;
			case OperationsPackage.LOCUTION_STATE__LOCUTION:
				setLocution((VoiceDsl)newValue);
				return;
			case OperationsPackage.LOCUTION_STATE__TEXTUAL:
				setTextual((Boolean)newValue);
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
			case OperationsPackage.LOCUTION_STATE__PARAMETERS:
				getParameters().clear();
				return;
			case OperationsPackage.LOCUTION_STATE__METHOD_NAME:
				setMethodName(METHOD_NAME_EDEFAULT);
				return;
			case OperationsPackage.LOCUTION_STATE__LOCUTION:
				setLocution((VoiceDsl)null);
				return;
			case OperationsPackage.LOCUTION_STATE__TEXTUAL:
				setTextual(TEXTUAL_EDEFAULT);
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
			case OperationsPackage.LOCUTION_STATE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case OperationsPackage.LOCUTION_STATE__METHOD_NAME:
				return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
			case OperationsPackage.LOCUTION_STATE__LOCUTION:
				return locution != null;
			case OperationsPackage.LOCUTION_STATE__TEXTUAL:
				return textual != TEXTUAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ParameterizedState.class) {
			switch (derivedFeatureID) {
				case OperationsPackage.LOCUTION_STATE__PARAMETERS: return OperationsPackage.PARAMETERIZED_STATE__PARAMETERS;
				default: return -1;
			}
		}
		if (baseClass == ExecutableState.class) {
			switch (derivedFeatureID) {
				case OperationsPackage.LOCUTION_STATE__METHOD_NAME: return OperationsPackage.EXECUTABLE_STATE__METHOD_NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ParameterizedState.class) {
			switch (baseFeatureID) {
				case OperationsPackage.PARAMETERIZED_STATE__PARAMETERS: return OperationsPackage.LOCUTION_STATE__PARAMETERS;
				default: return -1;
			}
		}
		if (baseClass == ExecutableState.class) {
			switch (baseFeatureID) {
				case OperationsPackage.EXECUTABLE_STATE__METHOD_NAME: return OperationsPackage.LOCUTION_STATE__METHOD_NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (parameters: ");
		result.append(parameters);
		result.append(", methodName: ");
		result.append(methodName);
		result.append(", textual: ");
		result.append(textual);
		result.append(')');
		return result.toString();
	}

} //LocutionStateImpl
