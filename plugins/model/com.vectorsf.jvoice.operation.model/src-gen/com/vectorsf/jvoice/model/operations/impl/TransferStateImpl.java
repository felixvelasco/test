/**
 */
package com.vectorsf.jvoice.model.operations.impl;

import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.TransferState;
import com.vectorsf.jvoice.model.operations.TypeTransfer;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transfer State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.TransferStateImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.TransferStateImpl#getAudioTransfer <em>Audio Transfer</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.TransferStateImpl#getMaxTime <em>Max Time</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.TransferStateImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.TransferStateImpl#getTypeTransfer <em>Type Transfer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransferStateImpl extends StateImpl implements TransferState {
	/**
	 * The default value of the '{@link #getDestination() <em>Destination</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTINATION_EDEFAULT = null;

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
	protected static final Date MAX_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxTime() <em>Max Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTime()
	 * @generated
	 * @ordered
	 */
	protected Date maxTime = MAX_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final Date TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected Date timeout = TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeTransfer() <em>Type Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeTransfer()
	 * @generated
	 * @ordered
	 */
	protected static final TypeTransfer TYPE_TRANSFER_EDEFAULT = TypeTransfer.BLIND;

	/**
	 * The cached value of the '{@link #getTypeTransfer() <em>Type Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeTransfer()
	 * @generated
	 * @ordered
	 */
	protected TypeTransfer typeTransfer = TYPE_TRANSFER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransferStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.TRANSFER_STATE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.TRANSFER_STATE__DESTINATION, oldDestination, destination));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.TRANSFER_STATE__AUDIO_TRANSFER, oldAudioTransfer, audioTransfer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getMaxTime() {
		return maxTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxTime(Date newMaxTime) {
		Date oldMaxTime = maxTime;
		maxTime = newMaxTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.TRANSFER_STATE__MAX_TIME, oldMaxTime, maxTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getTimeout() {
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeout(Date newTimeout) {
		Date oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.TRANSFER_STATE__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeTransfer getTypeTransfer() {
		return typeTransfer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeTransfer(TypeTransfer newTypeTransfer) {
		TypeTransfer oldTypeTransfer = typeTransfer;
		typeTransfer = newTypeTransfer == null ? TYPE_TRANSFER_EDEFAULT : newTypeTransfer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.TRANSFER_STATE__TYPE_TRANSFER, oldTypeTransfer, typeTransfer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.TRANSFER_STATE__DESTINATION:
				return getDestination();
			case OperationsPackage.TRANSFER_STATE__AUDIO_TRANSFER:
				return getAudioTransfer();
			case OperationsPackage.TRANSFER_STATE__MAX_TIME:
				return getMaxTime();
			case OperationsPackage.TRANSFER_STATE__TIMEOUT:
				return getTimeout();
			case OperationsPackage.TRANSFER_STATE__TYPE_TRANSFER:
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
			case OperationsPackage.TRANSFER_STATE__DESTINATION:
				setDestination((String)newValue);
				return;
			case OperationsPackage.TRANSFER_STATE__AUDIO_TRANSFER:
				setAudioTransfer((String)newValue);
				return;
			case OperationsPackage.TRANSFER_STATE__MAX_TIME:
				setMaxTime((Date)newValue);
				return;
			case OperationsPackage.TRANSFER_STATE__TIMEOUT:
				setTimeout((Date)newValue);
				return;
			case OperationsPackage.TRANSFER_STATE__TYPE_TRANSFER:
				setTypeTransfer((TypeTransfer)newValue);
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
			case OperationsPackage.TRANSFER_STATE__DESTINATION:
				setDestination(DESTINATION_EDEFAULT);
				return;
			case OperationsPackage.TRANSFER_STATE__AUDIO_TRANSFER:
				setAudioTransfer(AUDIO_TRANSFER_EDEFAULT);
				return;
			case OperationsPackage.TRANSFER_STATE__MAX_TIME:
				setMaxTime(MAX_TIME_EDEFAULT);
				return;
			case OperationsPackage.TRANSFER_STATE__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case OperationsPackage.TRANSFER_STATE__TYPE_TRANSFER:
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
			case OperationsPackage.TRANSFER_STATE__DESTINATION:
				return DESTINATION_EDEFAULT == null ? destination != null : !DESTINATION_EDEFAULT.equals(destination);
			case OperationsPackage.TRANSFER_STATE__AUDIO_TRANSFER:
				return AUDIO_TRANSFER_EDEFAULT == null ? audioTransfer != null : !AUDIO_TRANSFER_EDEFAULT.equals(audioTransfer);
			case OperationsPackage.TRANSFER_STATE__MAX_TIME:
				return MAX_TIME_EDEFAULT == null ? maxTime != null : !MAX_TIME_EDEFAULT.equals(maxTime);
			case OperationsPackage.TRANSFER_STATE__TIMEOUT:
				return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals(timeout);
			case OperationsPackage.TRANSFER_STATE__TYPE_TRANSFER:
				return typeTransfer != TYPE_TRANSFER_EDEFAULT;
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

} //TransferStateImpl
