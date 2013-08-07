/**
 */
package types.impl;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;

import types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Generic Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link types.impl.JvmGenericTypeImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link types.impl.JvmGenericTypeImpl#isInterface <em>Interface</em>}</li>
 *   <li>{@link types.impl.JvmGenericTypeImpl#isStrictFloatingPoint <em>Strict Floating Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JvmGenericTypeImpl extends JvmDeclaredTypeImpl implements JvmGenericType {
	/**
	 * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeParameter> typeParameters;

	/**
	 * The default value of the '{@link #isInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INTERFACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterface()
	 * @generated
	 * @ordered
	 */
	protected boolean interface_ = INTERFACE_EDEFAULT;

	/**
	 * The default value of the '{@link #isStrictFloatingPoint() <em>Strict Floating Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrictFloatingPoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STRICT_FLOATING_POINT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStrictFloatingPoint() <em>Strict Floating Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrictFloatingPoint()
	 * @generated
	 * @ordered
	 */
	protected boolean strictFloatingPoint = STRICT_FLOATING_POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmGenericTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_GENERIC_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeParameter> getTypeParameters() {
		if (typeParameters == null) {
			typeParameters = new EObjectContainmentWithInverseEList<JvmTypeParameter>(JvmTypeParameter.class, this, TypesPackage.JVM_GENERIC_TYPE__TYPE_PARAMETERS, TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR);
		}
		return typeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInterface() {
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface(boolean newInterface) {
		boolean oldInterface = interface_;
		interface_ = newInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_GENERIC_TYPE__INTERFACE, oldInterface, interface_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStrictFloatingPoint() {
		return strictFloatingPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrictFloatingPoint(boolean newStrictFloatingPoint) {
		boolean oldStrictFloatingPoint = strictFloatingPoint;
		strictFloatingPoint = newStrictFloatingPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_GENERIC_TYPE__STRICT_FLOATING_POINT, oldStrictFloatingPoint, strictFloatingPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterable<JvmTypeReference> getExtendedInterfaces() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getExtendedClass() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInstantiateable() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterable<JvmConstructor> getDeclaredConstructors() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_GENERIC_TYPE__TYPE_PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypeParameters()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_GENERIC_TYPE__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.JVM_GENERIC_TYPE__TYPE_PARAMETERS:
				return getTypeParameters();
			case TypesPackage.JVM_GENERIC_TYPE__INTERFACE:
				return isInterface();
			case TypesPackage.JVM_GENERIC_TYPE__STRICT_FLOATING_POINT:
				return isStrictFloatingPoint();
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
			case TypesPackage.JVM_GENERIC_TYPE__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends JvmTypeParameter>)newValue);
				return;
			case TypesPackage.JVM_GENERIC_TYPE__INTERFACE:
				setInterface((Boolean)newValue);
				return;
			case TypesPackage.JVM_GENERIC_TYPE__STRICT_FLOATING_POINT:
				setStrictFloatingPoint((Boolean)newValue);
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
			case TypesPackage.JVM_GENERIC_TYPE__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case TypesPackage.JVM_GENERIC_TYPE__INTERFACE:
				setInterface(INTERFACE_EDEFAULT);
				return;
			case TypesPackage.JVM_GENERIC_TYPE__STRICT_FLOATING_POINT:
				setStrictFloatingPoint(STRICT_FLOATING_POINT_EDEFAULT);
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
			case TypesPackage.JVM_GENERIC_TYPE__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case TypesPackage.JVM_GENERIC_TYPE__INTERFACE:
				return interface_ != INTERFACE_EDEFAULT;
			case TypesPackage.JVM_GENERIC_TYPE__STRICT_FLOATING_POINT:
				return strictFloatingPoint != STRICT_FLOATING_POINT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == JvmTypeParameterDeclarator.class) {
			switch (derivedFeatureID) {
				case TypesPackage.JVM_GENERIC_TYPE__TYPE_PARAMETERS: return TypesPackage.JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == JvmTypeParameterDeclarator.class) {
			switch (baseFeatureID) {
				case TypesPackage.JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS: return TypesPackage.JVM_GENERIC_TYPE__TYPE_PARAMETERS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TypesPackage.JVM_GENERIC_TYPE___GET_EXTENDED_INTERFACES:
				return getExtendedInterfaces();
			case TypesPackage.JVM_GENERIC_TYPE___GET_EXTENDED_CLASS:
				return getExtendedClass();
			case TypesPackage.JVM_GENERIC_TYPE___IS_INSTANTIATEABLE:
				return isInstantiateable();
			case TypesPackage.JVM_GENERIC_TYPE___GET_DECLARED_CONSTRUCTORS:
				return getDeclaredConstructors();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (interface: ");
		result.append(interface_);
		result.append(", strictFloatingPoint: ");
		result.append(strictFloatingPoint);
		result.append(')');
		return result.toString();
	}

} //JvmGenericTypeImpl
