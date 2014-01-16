/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl.impl;

import com.vectorsf.jvoice.prompt.model.voiceDsl.Audio;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Interpretation;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Audio</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudioImpl#isDontBargeIn <em>Dont Barge In</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudioImpl#getTts <em>Tts</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudioImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudioImpl#getInterpretation <em>Interpretation</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.AudioImpl#getFormat <em>Format</em>}</li>
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
	 * The default value of the '{@link #getInterpretation() <em>Interpretation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterpretation()
	 * @generated
	 * @ordered
	 */
	protected static final Interpretation INTERPRETATION_EDEFAULT = Interpretation.STRING;

	/**
	 * The cached value of the '{@link #getInterpretation() <em>Interpretation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterpretation()
	 * @generated
	 * @ordered
	 */
	protected Interpretation interpretation = INTERPRETATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

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
	public Interpretation getInterpretation() {
		return interpretation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterpretation(Interpretation newInterpretation) {
		Interpretation oldInterpretation = interpretation;
		interpretation = newInterpretation == null ? INTERPRETATION_EDEFAULT : newInterpretation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIO__INTERPRETATION, oldInterpretation, interpretation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.AUDIO__FORMAT, oldFormat, format));
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
			case VoiceDslPackage.AUDIO__INTERPRETATION:
				return getInterpretation();
			case VoiceDslPackage.AUDIO__FORMAT:
				return getFormat();
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
			case VoiceDslPackage.AUDIO__INTERPRETATION:
				setInterpretation((Interpretation)newValue);
				return;
			case VoiceDslPackage.AUDIO__FORMAT:
				setFormat((String)newValue);
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
			case VoiceDslPackage.AUDIO__INTERPRETATION:
				setInterpretation(INTERPRETATION_EDEFAULT);
				return;
			case VoiceDslPackage.AUDIO__FORMAT:
				setFormat(FORMAT_EDEFAULT);
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
			case VoiceDslPackage.AUDIO__INTERPRETATION:
				return interpretation != INTERPRETATION_EDEFAULT;
			case VoiceDslPackage.AUDIO__FORMAT:
				return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
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
		result.append(", interpretation: ");
		result.append(interpretation);
		result.append(", format: ");
		result.append(format);
		result.append(')');
		return result.toString();
	}

} //AudioImpl
