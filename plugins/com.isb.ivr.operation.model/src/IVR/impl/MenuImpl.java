/**
 */
package IVR.impl;

import Generic_BKS.impl.StateImpl;

import IVR.IVRPackage;
import IVR.Literal;
import IVR.Menu;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link IVR.impl.MenuImpl#getTexts <em>Texts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MenuImpl extends StateImpl implements Menu {
	/**
	 * The cached value of the '{@link #getTexts() <em>Texts</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTexts()
	 * @generated
	 * @ordered
	 */
	protected Literal texts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IVRPackage.Literals.MENU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal getTexts() {
		if (texts != null && texts.eIsProxy()) {
			InternalEObject oldTexts = (InternalEObject)texts;
			texts = (Literal)eResolveProxy(oldTexts);
			if (texts != oldTexts) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IVRPackage.MENU__TEXTS, oldTexts, texts));
			}
		}
		return texts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal basicGetTexts() {
		return texts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTexts(Literal newTexts) {
		Literal oldTexts = texts;
		texts = newTexts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IVRPackage.MENU__TEXTS, oldTexts, texts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IVRPackage.MENU__TEXTS:
				if (resolve) return getTexts();
				return basicGetTexts();
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
			case IVRPackage.MENU__TEXTS:
				setTexts((Literal)newValue);
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
			case IVRPackage.MENU__TEXTS:
				setTexts((Literal)null);
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
			case IVRPackage.MENU__TEXTS:
				return texts != null;
		}
		return super.eIsSet(featureID);
	}

} //MenuImpl
