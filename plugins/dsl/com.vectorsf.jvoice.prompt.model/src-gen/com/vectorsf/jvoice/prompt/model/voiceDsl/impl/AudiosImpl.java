/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl.impl;

import com.vectorsf.jvoice.prompt.model.voiceDsl.Audio;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Audios;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Audios</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudiosImpl#getMainAudios <em>Main Audios</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudiosImpl#getNoMatchAudios <em>No Match Audios</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudiosImpl#getNoInputAudios <em>No Input Audios</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudiosImpl#getMatchAudios <em>Match Audios</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AudiosImpl extends MinimalEObjectImpl.Container implements Audios {
	/**
	 * The cached value of the '{@link #getMainAudios() <em>Main Audios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainAudios()
	 * @generated
	 * @ordered
	 */
	protected EList<Audio> mainAudios;

	/**
	 * The cached value of the '{@link #getNoMatchAudios() <em>No Match Audios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoMatchAudios()
	 * @generated
	 * @ordered
	 */
	protected EList<Audio> noMatchAudios;

	/**
	 * The cached value of the '{@link #getNoInputAudios() <em>No Input Audios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoInputAudios()
	 * @generated
	 * @ordered
	 */
	protected EList<Audio> noInputAudios;

	/**
	 * The cached value of the '{@link #getMatchAudios() <em>Match Audios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchAudios()
	 * @generated
	 * @ordered
	 */
	protected EList<Audio> matchAudios;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AudiosImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VoiceDslPackage.Literals.AUDIOS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Audio> getMainAudios() {
		if (mainAudios == null) {
			mainAudios = new EObjectContainmentEList<Audio>(Audio.class, this, VoiceDslPackage.AUDIOS__MAIN_AUDIOS);
		}
		return mainAudios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Audio> getNoMatchAudios() {
		if (noMatchAudios == null) {
			noMatchAudios = new EObjectContainmentEList<Audio>(Audio.class, this, VoiceDslPackage.AUDIOS__NO_MATCH_AUDIOS);
		}
		return noMatchAudios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Audio> getNoInputAudios() {
		if (noInputAudios == null) {
			noInputAudios = new EObjectContainmentEList<Audio>(Audio.class, this, VoiceDslPackage.AUDIOS__NO_INPUT_AUDIOS);
		}
		return noInputAudios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Audio> getMatchAudios() {
		if (matchAudios == null) {
			matchAudios = new EObjectContainmentEList<Audio>(Audio.class, this, VoiceDslPackage.AUDIOS__MATCH_AUDIOS);
		}
		return matchAudios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VoiceDslPackage.AUDIOS__MAIN_AUDIOS:
				return ((InternalEList<?>)getMainAudios()).basicRemove(otherEnd, msgs);
			case VoiceDslPackage.AUDIOS__NO_MATCH_AUDIOS:
				return ((InternalEList<?>)getNoMatchAudios()).basicRemove(otherEnd, msgs);
			case VoiceDslPackage.AUDIOS__NO_INPUT_AUDIOS:
				return ((InternalEList<?>)getNoInputAudios()).basicRemove(otherEnd, msgs);
			case VoiceDslPackage.AUDIOS__MATCH_AUDIOS:
				return ((InternalEList<?>)getMatchAudios()).basicRemove(otherEnd, msgs);
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
			case VoiceDslPackage.AUDIOS__MAIN_AUDIOS:
				return getMainAudios();
			case VoiceDslPackage.AUDIOS__NO_MATCH_AUDIOS:
				return getNoMatchAudios();
			case VoiceDslPackage.AUDIOS__NO_INPUT_AUDIOS:
				return getNoInputAudios();
			case VoiceDslPackage.AUDIOS__MATCH_AUDIOS:
				return getMatchAudios();
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
			case VoiceDslPackage.AUDIOS__MAIN_AUDIOS:
				getMainAudios().clear();
				getMainAudios().addAll((Collection<? extends Audio>)newValue);
				return;
			case VoiceDslPackage.AUDIOS__NO_MATCH_AUDIOS:
				getNoMatchAudios().clear();
				getNoMatchAudios().addAll((Collection<? extends Audio>)newValue);
				return;
			case VoiceDslPackage.AUDIOS__NO_INPUT_AUDIOS:
				getNoInputAudios().clear();
				getNoInputAudios().addAll((Collection<? extends Audio>)newValue);
				return;
			case VoiceDslPackage.AUDIOS__MATCH_AUDIOS:
				getMatchAudios().clear();
				getMatchAudios().addAll((Collection<? extends Audio>)newValue);
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
			case VoiceDslPackage.AUDIOS__MAIN_AUDIOS:
				getMainAudios().clear();
				return;
			case VoiceDslPackage.AUDIOS__NO_MATCH_AUDIOS:
				getNoMatchAudios().clear();
				return;
			case VoiceDslPackage.AUDIOS__NO_INPUT_AUDIOS:
				getNoInputAudios().clear();
				return;
			case VoiceDslPackage.AUDIOS__MATCH_AUDIOS:
				getMatchAudios().clear();
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
			case VoiceDslPackage.AUDIOS__MAIN_AUDIOS:
				return mainAudios != null && !mainAudios.isEmpty();
			case VoiceDslPackage.AUDIOS__NO_MATCH_AUDIOS:
				return noMatchAudios != null && !noMatchAudios.isEmpty();
			case VoiceDslPackage.AUDIOS__NO_INPUT_AUDIOS:
				return noInputAudios != null && !noInputAudios.isEmpty();
			case VoiceDslPackage.AUDIOS__MATCH_AUDIOS:
				return matchAudios != null && !matchAudios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AudiosImpl
