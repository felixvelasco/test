/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl.impl;

import com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transfer Dsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.TransferDslImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.TransferDslImpl#getAudioTransfer <em>Audio Transfer</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.TransferDslImpl#getMaxTime <em>Max Time</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.TransferDslImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.TransferDslImpl#getTypeTransfer <em>Type Transfer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransferDslImpl extends VoiceDslImpl implements TransferDsl {
	/**
	 * The default value of the '{@link #getDestination() <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTINATION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected String destination = DESTINATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAudioTransfer() <em>Audio Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudioTransfer()
	 * @generated
	 * @ordered
	 */
	protected static final String AUDIO_TRANSFER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAudioTransfer() <em>Audio Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudioTransfer()
	 * @generated
	 * @ordered
	 */
	protected String audioTransfer = AUDIO_TRANSFER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxTime() <em>Max Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTime()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxTime() <em>Max Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTime()
	 * @generated
	 * @ordered
	 */
	protected String maxTime = MAX_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected String timeout = TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeTransfer() <em>Type Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeTransfer()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_TRANSFER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeTransfer() <em>Type Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeTransfer()
	 * @generated
	 * @ordered
	 */
	protected String typeTransfer = TYPE_TRANSFER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransferDslImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VoiceDslPackage.Literals.TRANSFER_DSL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(String newDestination) {
		String oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.TRANSFER_DSL__DESTINATION, oldDestination, destination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAudioTransfer() {
		return audioTransfer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAudioTransfer(String newAudioTransfer) {
		String oldAudioTransfer = audioTransfer;
		audioTransfer = newAudioTransfer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.TRANSFER_DSL__AUDIO_TRANSFER, oldAudioTransfer, audioTransfer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxTime() {
		return maxTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxTime(String newMaxTime) {
		String oldMaxTime = maxTime;
		maxTime = newMaxTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.TRANSFER_DSL__MAX_TIME, oldMaxTime, maxTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimeout() {
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeout(String newTimeout) {
		String oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.TRANSFER_DSL__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeTransfer() {
		return typeTransfer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeTransfer(String newTypeTransfer) {
		String oldTypeTransfer = typeTransfer;
		typeTransfer = newTypeTransfer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.TRANSFER_DSL__TYPE_TRANSFER, oldTypeTransfer, typeTransfer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VoiceDslPackage.TRANSFER_DSL__DESTINATION:
				return getDestination();
			case VoiceDslPackage.TRANSFER_DSL__AUDIO_TRANSFER:
				return getAudioTransfer();
			case VoiceDslPackage.TRANSFER_DSL__MAX_TIME:
				return getMaxTime();
			case VoiceDslPackage.TRANSFER_DSL__TIMEOUT:
				return getTimeout();
			case VoiceDslPackage.TRANSFER_DSL__TYPE_TRANSFER:
				return getTypeTransfer();
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
			case VoiceDslPackage.TRANSFER_DSL__DESTINATION:
				setDestination((String)newValue);
				return;
			case VoiceDslPackage.TRANSFER_DSL__AUDIO_TRANSFER:
				setAudioTransfer((String)newValue);
				return;
			case VoiceDslPackage.TRANSFER_DSL__MAX_TIME:
				setMaxTime((String)newValue);
				return;
			case VoiceDslPackage.TRANSFER_DSL__TIMEOUT:
				setTimeout((String)newValue);
				return;
			case VoiceDslPackage.TRANSFER_DSL__TYPE_TRANSFER:
				setTypeTransfer((String)newValue);
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
			case VoiceDslPackage.TRANSFER_DSL__DESTINATION:
				setDestination(DESTINATION_EDEFAULT);
				return;
			case VoiceDslPackage.TRANSFER_DSL__AUDIO_TRANSFER:
				setAudioTransfer(AUDIO_TRANSFER_EDEFAULT);
				return;
			case VoiceDslPackage.TRANSFER_DSL__MAX_TIME:
				setMaxTime(MAX_TIME_EDEFAULT);
				return;
			case VoiceDslPackage.TRANSFER_DSL__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case VoiceDslPackage.TRANSFER_DSL__TYPE_TRANSFER:
				setTypeTransfer(TYPE_TRANSFER_EDEFAULT);
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
			case VoiceDslPackage.TRANSFER_DSL__DESTINATION:
				return DESTINATION_EDEFAULT == null ? destination != null : !DESTINATION_EDEFAULT.equals(destination);
			case VoiceDslPackage.TRANSFER_DSL__AUDIO_TRANSFER:
				return AUDIO_TRANSFER_EDEFAULT == null ? audioTransfer != null : !AUDIO_TRANSFER_EDEFAULT.equals(audioTransfer);
			case VoiceDslPackage.TRANSFER_DSL__MAX_TIME:
				return MAX_TIME_EDEFAULT == null ? maxTime != null : !MAX_TIME_EDEFAULT.equals(maxTime);
			case VoiceDslPackage.TRANSFER_DSL__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case VoiceDslPackage.TRANSFER_DSL__TYPE_TRANSFER:
				return TYPE_TRANSFER_EDEFAULT == null ? typeTransfer != null : !TYPE_TRANSFER_EDEFAULT.equals(typeTransfer);
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
		result.append(" (destination: ");
		result.append(destination);
		result.append(", audioTransfer: ");
		result.append(audioTransfer);
		result.append(", maxTime: ");
		result.append(maxTime);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", typeTransfer: ");
		result.append(typeTransfer);
		result.append(')');
		return result.toString();
	}

} //TransferDslImpl
