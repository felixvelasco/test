/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl.impl;

import com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar;
import com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grammar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.GrammarImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.GrammarImpl#isBuiltin <em>Builtin</em>}</li>
 *   <li>{@link com.isb.bks.ivr.voice.dsl.voiceDsl.impl.GrammarImpl#getSrc <em>Src</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GrammarImpl extends MinimalEObjectImpl.Container implements Grammar {
	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final String MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected String mode = MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #isBuiltin() <em>Builtin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBuiltin()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BUILTIN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBuiltin() <em>Builtin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBuiltin()
	 * @generated
	 * @ordered
	 */
	protected boolean builtin = BUILTIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getSrc() <em>Src</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc()
	 * @generated
	 * @ordered
	 */
	protected static final String SRC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSrc() <em>Src</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc()
	 * @generated
	 * @ordered
	 */
	protected String src = SRC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GrammarImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VoiceDslPackage.Literals.GRAMMAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(String newMode) {
		String oldMode = mode;
		mode = newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.GRAMMAR__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBuiltin() {
		return builtin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuiltin(boolean newBuiltin) {
		boolean oldBuiltin = builtin;
		builtin = newBuiltin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.GRAMMAR__BUILTIN, oldBuiltin, builtin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrc(String newSrc) {
		String oldSrc = src;
		src = newSrc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.GRAMMAR__SRC, oldSrc, src));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VoiceDslPackage.GRAMMAR__MODE:
				return getMode();
			case VoiceDslPackage.GRAMMAR__BUILTIN:
				return isBuiltin();
			case VoiceDslPackage.GRAMMAR__SRC:
				return getSrc();
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
			case VoiceDslPackage.GRAMMAR__MODE:
				setMode((String)newValue);
				return;
			case VoiceDslPackage.GRAMMAR__BUILTIN:
				setBuiltin((Boolean)newValue);
				return;
			case VoiceDslPackage.GRAMMAR__SRC:
				setSrc((String)newValue);
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
			case VoiceDslPackage.GRAMMAR__MODE:
				setMode(MODE_EDEFAULT);
				return;
			case VoiceDslPackage.GRAMMAR__BUILTIN:
				setBuiltin(BUILTIN_EDEFAULT);
				return;
			case VoiceDslPackage.GRAMMAR__SRC:
				setSrc(SRC_EDEFAULT);
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
			case VoiceDslPackage.GRAMMAR__MODE:
				return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
			case VoiceDslPackage.GRAMMAR__BUILTIN:
				return builtin != BUILTIN_EDEFAULT;
			case VoiceDslPackage.GRAMMAR__SRC:
				return SRC_EDEFAULT == null ? src != null : !SRC_EDEFAULT.equals(src);
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
		result.append(" (mode: ");
		result.append(mode);
		result.append(", builtin: ");
		result.append(builtin);
		result.append(", src: ");
		result.append(src);
		result.append(')');
		return result.toString();
	}

} //GrammarImpl
