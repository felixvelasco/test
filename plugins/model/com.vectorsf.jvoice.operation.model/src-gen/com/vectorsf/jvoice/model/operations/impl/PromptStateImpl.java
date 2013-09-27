/**
 */
package com.vectorsf.jvoice.model.operations.impl;

import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.PromptState;

import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prompt State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.PromptStateImpl#getLocution <em>Locution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PromptStateImpl extends StateImpl implements PromptState {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PromptStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.PROMPT_STATE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationsPackage.PROMPT_STATE__LOCUTION, oldLocution, locution));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.PROMPT_STATE__LOCUTION, oldLocution, locution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.PROMPT_STATE__LOCUTION:
				if (resolve) return getLocution();
				return basicGetLocution();
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
			case OperationsPackage.PROMPT_STATE__LOCUTION:
				setLocution((VoiceDsl)newValue);
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
			case OperationsPackage.PROMPT_STATE__LOCUTION:
				setLocution((VoiceDsl)null);
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
			case OperationsPackage.PROMPT_STATE__LOCUTION:
				return locution != null;
		}
		return super.eIsSet(featureID);
	}

} //PromptStateImpl