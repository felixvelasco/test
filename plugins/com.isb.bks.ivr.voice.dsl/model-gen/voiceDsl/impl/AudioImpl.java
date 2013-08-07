/**
 */
package voiceDsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import voiceDsl.Audio;
import voiceDsl.VoiceDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Audio</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link voiceDsl.impl.AudioImpl#isDontBargeIn <em>Dont Barge In</em>}</li>
 *   <li>{@link voiceDsl.impl.AudioImpl#getTts <em>Tts</em>}</li>
 *   <li>{@link voiceDsl.impl.AudioImpl#getSrc <em>Src</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AudioImpl extends MinimalEObjectImpl.Container implements Audio {
	/**
	 * The default value of the '{@link #isDontBargeIn() <em>Dont Barge In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDontBargeIn()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DONT_BARGE_IN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDontBargeIn() <em>Dont Barge In</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDontBargeIn()
	 * @generated
	 * @ordered
	 */
	protected boolean dontBargeIn = DONT_BARGE_IN_EDEFAULT;

	/**
	 * The default value of the '{@link #getTts() <em>Tts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTts()
	 * @generated
	 * @ordered
	 */
	protected static final String TTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTts() <em>Tts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTts()
	 * @generated
	 * @ordered
	 */
	protected String tts = TTS_EDEFAULT;

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
	protected AudioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VoiceDslPackage.Literals.AUDIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDontBargeIn() {
		return dontBargeIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDontBargeIn(boolean newDontBargeIn) {
		boolean oldDontBargeIn = dontBargeIn;
		dontBargeIn = newDontBargeIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIO__DONT_BARGE_IN, oldDontBargeIn, dontBargeIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTts() {
		return tts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTts(String newTts) {
		String oldTts = tts;
		tts = newTts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIO__TTS, oldTts, tts));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIO__SRC, oldSrc, src));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VoiceDslPackage.AUDIO__DONT_BARGE_IN:
				return isDontBargeIn();
			case VoiceDslPackage.AUDIO__TTS:
				return getTts();
			case VoiceDslPackage.AUDIO__SRC:
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
			case VoiceDslPackage.AUDIO__DONT_BARGE_IN:
				setDontBargeIn((Boolean)newValue);
				return;
			case VoiceDslPackage.AUDIO__TTS:
				setTts((String)newValue);
				return;
			case VoiceDslPackage.AUDIO__SRC:
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
			case VoiceDslPackage.AUDIO__DONT_BARGE_IN:
				setDontBargeIn(DONT_BARGE_IN_EDEFAULT);
				return;
			case VoiceDslPackage.AUDIO__TTS:
				setTts(TTS_EDEFAULT);
				return;
			case VoiceDslPackage.AUDIO__SRC:
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
			case VoiceDslPackage.AUDIO__DONT_BARGE_IN:
				return dontBargeIn != DONT_BARGE_IN_EDEFAULT;
			case VoiceDslPackage.AUDIO__TTS:
				return TTS_EDEFAULT == null ? tts != null : !TTS_EDEFAULT.equals(tts);
			case VoiceDslPackage.AUDIO__SRC:
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
		result.append(" (dontBargeIn: ");
		result.append(dontBargeIn);
		result.append(", tts: ");
		result.append(tts);
		result.append(", src: ");
		result.append(src);
		result.append(')');
		return result.toString();
	}

} //AudioImpl
