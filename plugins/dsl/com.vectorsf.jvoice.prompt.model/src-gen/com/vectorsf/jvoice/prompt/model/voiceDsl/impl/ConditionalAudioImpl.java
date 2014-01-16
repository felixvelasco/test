/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl.impl;

import com.vectorsf.jvoice.prompt.model.voiceDsl.Audio;
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Audio</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionalAudioImpl#getSimpleAudios <em>Simple Audios</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.ConditionalAudioImpl#getCondit <em>Condit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalAudioImpl extends AudioImpl implements ConditionalAudio {
	/**
	 * The cached value of the '{@link #getSimpleAudios() <em>Simple Audios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleAudios()
	 * @generated
	 * @ordered
	 */
	protected EList<Audio> simpleAudios;

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
	public EList<Audio> getSimpleAudios() {
		if (simpleAudios == null) {
			simpleAudios = new EObjectContainmentEList<Audio>(Audio.class, this, VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_AUDIOS);
		}
		return simpleAudios;
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
			case VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_AUDIOS:
				return ((InternalEList<?>)getSimpleAudios()).basicRemove(otherEnd, msgs);
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
			case VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_AUDIOS:
				return getSimpleAudios();
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_AUDIOS:
				getSimpleAudios().clear();
				getSimpleAudios().addAll((Collection<? extends Audio>)newValue);
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
			case VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_AUDIOS:
				getSimpleAudios().clear();
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
			case VoiceDslPackage.CONDITIONAL_AUDIO__SIMPLE_AUDIOS:
				return simpleAudios != null && !simpleAudios.isEmpty();
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
