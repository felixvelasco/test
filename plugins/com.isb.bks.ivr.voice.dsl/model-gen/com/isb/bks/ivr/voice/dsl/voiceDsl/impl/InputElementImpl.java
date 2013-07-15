/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl.impl;

import com.isb.bks.ivr.voice.dsl.voiceDsl.Audio;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar;
import com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement;
import com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getGrammatics <em>Grammatics</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getMaxNoInput <em>Max No Input</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getMaxNoMatch <em>Max No Match</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getMaxAttempts <em>Max Attempts</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getInitialAudios <em>Initial Audios</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getNoMatchAudios <em>No Match Audios</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getNoInputAudios <em>No Input Audios</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.InputElementImpl#getMatchAudios <em>Match Audios</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputElementImpl extends MinimalEObjectImpl.Container implements InputElement {
	/**
	 * The cached value of the '{@link #getGrammatics() <em>Grammatics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrammatics()
	 * @generated
	 * @ordered
	 */
	protected Grammar grammatics;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxNoInput() <em>Max No Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNoInput()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_NO_INPUT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxNoInput() <em>Max No Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNoInput()
	 * @generated
	 * @ordered
	 */
	protected int maxNoInput = MAX_NO_INPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxNoMatch() <em>Max No Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNoMatch()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_NO_MATCH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxNoMatch() <em>Max No Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxNoMatch()
	 * @generated
	 * @ordered
	 */
	protected int maxNoMatch = MAX_NO_MATCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxAttempts() <em>Max Attempts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAttempts()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_ATTEMPTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxAttempts() <em>Max Attempts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxAttempts()
	 * @generated
	 * @ordered
	 */
	protected int maxAttempts = MAX_ATTEMPTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInitialAudios() <em>Initial Audios</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialAudios()
	 * @generated
	 * @ordered
	 */
	protected EList<Audio> initialAudios;

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
	protected InputElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VoiceDslPackage.Literals.INPUT_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Grammar getGrammatics() {
		return grammatics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGrammatics(Grammar newGrammatics, NotificationChain msgs) {
		Grammar oldGrammatics = grammatics;
		grammatics = newGrammatics;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS, oldGrammatics, newGrammatics);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrammatics(Grammar newGrammatics) {
		if (newGrammatics != grammatics) {
			NotificationChain msgs = null;
			if (grammatics != null)
				msgs = ((InternalEObject)grammatics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS, null, msgs);
			if (newGrammatics != null)
				msgs = ((InternalEObject)newGrammatics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS, null, msgs);
			msgs = basicSetGrammatics(newGrammatics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS, newGrammatics, newGrammatics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxNoInput() {
		return maxNoInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxNoInput(int newMaxNoInput) {
		int oldMaxNoInput = maxNoInput;
		maxNoInput = newMaxNoInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__MAX_NO_INPUT, oldMaxNoInput, maxNoInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxNoMatch() {
		return maxNoMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxNoMatch(int newMaxNoMatch) {
		int oldMaxNoMatch = maxNoMatch;
		maxNoMatch = newMaxNoMatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__MAX_NO_MATCH, oldMaxNoMatch, maxNoMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxAttempts() {
		return maxAttempts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxAttempts(int newMaxAttempts) {
		int oldMaxAttempts = maxAttempts;
		maxAttempts = newMaxAttempts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.INPUT_ELEMENT__MAX_ATTEMPTS, oldMaxAttempts, maxAttempts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Audio> getInitialAudios() {
		if (initialAudios == null) {
			initialAudios = new EObjectContainmentEList<Audio>(Audio.class, this, VoiceDslPackage.INPUT_ELEMENT__INITIAL_AUDIOS);
		}
		return initialAudios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Audio> getNoMatchAudios() {
		if (noMatchAudios == null) {
			noMatchAudios = new EObjectContainmentEList<Audio>(Audio.class, this, VoiceDslPackage.INPUT_ELEMENT__NO_MATCH_AUDIOS);
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
			noInputAudios = new EObjectContainmentEList<Audio>(Audio.class, this, VoiceDslPackage.INPUT_ELEMENT__NO_INPUT_AUDIOS);
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
			matchAudios = new EObjectContainmentEList<Audio>(Audio.class, this, VoiceDslPackage.INPUT_ELEMENT__MATCH_AUDIOS);
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
			case VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS:
				return basicSetGrammatics(null, msgs);
			case VoiceDslPackage.INPUT_ELEMENT__INITIAL_AUDIOS:
				return ((InternalEList<?>)getInitialAudios()).basicRemove(otherEnd, msgs);
			case VoiceDslPackage.INPUT_ELEMENT__NO_MATCH_AUDIOS:
				return ((InternalEList<?>)getNoMatchAudios()).basicRemove(otherEnd, msgs);
			case VoiceDslPackage.INPUT_ELEMENT__NO_INPUT_AUDIOS:
				return ((InternalEList<?>)getNoInputAudios()).basicRemove(otherEnd, msgs);
			case VoiceDslPackage.INPUT_ELEMENT__MATCH_AUDIOS:
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
			case VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS:
				return getGrammatics();
			case VoiceDslPackage.INPUT_ELEMENT__NAME:
				return getName();
			case VoiceDslPackage.INPUT_ELEMENT__MAX_NO_INPUT:
				return getMaxNoInput();
			case VoiceDslPackage.INPUT_ELEMENT__MAX_NO_MATCH:
				return getMaxNoMatch();
			case VoiceDslPackage.INPUT_ELEMENT__MAX_ATTEMPTS:
				return getMaxAttempts();
			case VoiceDslPackage.INPUT_ELEMENT__INITIAL_AUDIOS:
				return getInitialAudios();
			case VoiceDslPackage.INPUT_ELEMENT__NO_MATCH_AUDIOS:
				return getNoMatchAudios();
			case VoiceDslPackage.INPUT_ELEMENT__NO_INPUT_AUDIOS:
				return getNoInputAudios();
			case VoiceDslPackage.INPUT_ELEMENT__MATCH_AUDIOS:
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
			case VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS:
				setGrammatics((Grammar)newValue);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__MAX_NO_INPUT:
				setMaxNoInput((Integer)newValue);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__MAX_NO_MATCH:
				setMaxNoMatch((Integer)newValue);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__MAX_ATTEMPTS:
				setMaxAttempts((Integer)newValue);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__INITIAL_AUDIOS:
				getInitialAudios().clear();
				getInitialAudios().addAll((Collection<? extends Audio>)newValue);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__NO_MATCH_AUDIOS:
				getNoMatchAudios().clear();
				getNoMatchAudios().addAll((Collection<? extends Audio>)newValue);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__NO_INPUT_AUDIOS:
				getNoInputAudios().clear();
				getNoInputAudios().addAll((Collection<? extends Audio>)newValue);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__MATCH_AUDIOS:
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
			case VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS:
				setGrammatics((Grammar)null);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__MAX_NO_INPUT:
				setMaxNoInput(MAX_NO_INPUT_EDEFAULT);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__MAX_NO_MATCH:
				setMaxNoMatch(MAX_NO_MATCH_EDEFAULT);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__MAX_ATTEMPTS:
				setMaxAttempts(MAX_ATTEMPTS_EDEFAULT);
				return;
			case VoiceDslPackage.INPUT_ELEMENT__INITIAL_AUDIOS:
				getInitialAudios().clear();
				return;
			case VoiceDslPackage.INPUT_ELEMENT__NO_MATCH_AUDIOS:
				getNoMatchAudios().clear();
				return;
			case VoiceDslPackage.INPUT_ELEMENT__NO_INPUT_AUDIOS:
				getNoInputAudios().clear();
				return;
			case VoiceDslPackage.INPUT_ELEMENT__MATCH_AUDIOS:
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
			case VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS:
				return grammatics != null;
			case VoiceDslPackage.INPUT_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VoiceDslPackage.INPUT_ELEMENT__MAX_NO_INPUT:
				return maxNoInput != MAX_NO_INPUT_EDEFAULT;
			case VoiceDslPackage.INPUT_ELEMENT__MAX_NO_MATCH:
				return maxNoMatch != MAX_NO_MATCH_EDEFAULT;
			case VoiceDslPackage.INPUT_ELEMENT__MAX_ATTEMPTS:
				return maxAttempts != MAX_ATTEMPTS_EDEFAULT;
			case VoiceDslPackage.INPUT_ELEMENT__INITIAL_AUDIOS:
				return initialAudios != null && !initialAudios.isEmpty();
			case VoiceDslPackage.INPUT_ELEMENT__NO_MATCH_AUDIOS:
				return noMatchAudios != null && !noMatchAudios.isEmpty();
			case VoiceDslPackage.INPUT_ELEMENT__NO_INPUT_AUDIOS:
				return noInputAudios != null && !noInputAudios.isEmpty();
			case VoiceDslPackage.INPUT_ELEMENT__MATCH_AUDIOS:
				return matchAudios != null && !matchAudios.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", maxNoInput: ");
		result.append(maxNoInput);
		result.append(", maxNoMatch: ");
		result.append(maxNoMatch);
		result.append(", maxAttempts: ");
		result.append(maxAttempts);
		result.append(')');
		return result.toString();
	}

} //InputElementImpl
