/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl.impl;

import com.vectorsf.jvoice.prompt.model.voiceDsl.Audio;
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Audio</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionalAudioImpl#getSimpleA <em>Simple A</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionalAudioImpl#getCondit <em>Condit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalAudioImpl extends AudioImpl implements ConditionalAudio {
	/**
	 * The cached value of the '{@link #getSimpleA() <em>Simple A</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleA()
	 * @generated
	 * @ordered
	 */
	protected Audio simpleA;

	/**
	 * The default value of the '{@link #getCondit() <em>Condit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondit()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondit() <em>Condit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondit()
	 * @generated
	 * @ordered
	 */
	protected String condit = CONDIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalAudioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VoiceDslPackage.Literals.CONDITIONAL_AUDIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Audio getSimpleA() {
		return simpleA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleA(Audio newSimpleA, NotificationChain msgs) {
		Audio oldSimpleA = simpleA;
		simpleA = newSimpleA;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_A, oldSimpleA, newSimpleA);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleA(Audio newSimpleA) {
		if (newSimpleA != simpleA) {
			NotificationChain msgs = null;
			if (simpleA != null)
				msgs = ((InternalEObject)simpleA).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_A, null, msgs);
			if (newSimpleA != null)
				msgs = ((InternalEObject)newSimpleA).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_A, null, msgs);
			msgs = basicSetSimpleA(newSimpleA, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_A, newSimpleA, newSimpleA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondit() {
		return condit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondit(String newCondit) {
		String oldCondit = condit;
		condit = newCondit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.CONDITIONAL_AUDIO__CONDIT, oldCondit, condit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_A:
				return basicSetSimpleA(null, msgs);
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
			case VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_A:
				return getSimpleA();
			case VoiceDslPackage.CONDITIONAL_AUDIO__CONDIT:
				return getCondit();
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
			case VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_A:
				setSimpleA((Audio)newValue);
				return;
			case VoiceDslPackage.CONDITIONAL_AUDIO__CONDIT:
				setCondit((String)newValue);
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
			case VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_A:
				setSimpleA((Audio)null);
				return;
			case VoiceDslPackage.CONDITIONAL_AUDIO__CONDIT:
				setCondit(CONDIT_EDEFAULT);
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
			case VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_A:
				return simpleA != null;
			case VoiceDslPackage.CONDITIONAL_AUDIO__CONDIT:
				return CONDIT_EDEFAULT == null ? condit != null : !CONDIT_EDEFAULT.equals(condit);
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
		result.append(" (condit: ");
		result.append(condit);
		result.append(')');
		return result.toString();
	}

} //ConditionalAudioImpl
