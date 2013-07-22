/**
 */
package Generic_BKS.impl;

import Core.impl.FlowElementImpl;

import Generic_BKS.Generic_BKSPackage;
import Generic_BKS.State;
import Generic_BKS.Transition;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Generic_BKS.impl.StateImpl#getInTransactions <em>In Transactions</em>}</li>
 *   <li>{@link Generic_BKS.impl.StateImpl#getOutTransactions <em>Out Transactions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StateImpl extends FlowElementImpl implements State {
	/**
	 * The cached value of the '{@link #getInTransactions() <em>In Transactions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTransactions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> inTransactions;

	/**
	 * The cached value of the '{@link #getOutTransactions() <em>Out Transactions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutTransactions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outTransactions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Generic_BKSPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getInTransactions() {
		if (inTransactions == null) {
			inTransactions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, Generic_BKSPackage.STATE__IN_TRANSACTIONS, Generic_BKSPackage.TRANSITION__TARGET);
		}
		return inTransactions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutTransactions() {
		if (outTransactions == null) {
			outTransactions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, Generic_BKSPackage.STATE__OUT_TRANSACTIONS, Generic_BKSPackage.TRANSITION__SOURCE);
		}
		return outTransactions;
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
			case Generic_BKSPackage.STATE__IN_TRANSACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInTransactions()).basicAdd(otherEnd, msgs);
			case Generic_BKSPackage.STATE__OUT_TRANSACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutTransactions()).basicAdd(otherEnd, msgs);
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
			case Generic_BKSPackage.STATE__IN_TRANSACTIONS:
				return ((InternalEList<?>)getInTransactions()).basicRemove(otherEnd, msgs);
			case Generic_BKSPackage.STATE__OUT_TRANSACTIONS:
				return ((InternalEList<?>)getOutTransactions()).basicRemove(otherEnd, msgs);
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
			case Generic_BKSPackage.STATE__IN_TRANSACTIONS:
				return getInTransactions();
			case Generic_BKSPackage.STATE__OUT_TRANSACTIONS:
				return getOutTransactions();
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
			case Generic_BKSPackage.STATE__IN_TRANSACTIONS:
				getInTransactions().clear();
				getInTransactions().addAll((Collection<? extends Transition>)newValue);
				return;
			case Generic_BKSPackage.STATE__OUT_TRANSACTIONS:
				getOutTransactions().clear();
				getOutTransactions().addAll((Collection<? extends Transition>)newValue);
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
			case Generic_BKSPackage.STATE__IN_TRANSACTIONS:
				getInTransactions().clear();
				return;
			case Generic_BKSPackage.STATE__OUT_TRANSACTIONS:
				getOutTransactions().clear();
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
			case Generic_BKSPackage.STATE__IN_TRANSACTIONS:
				return inTransactions != null && !inTransactions.isEmpty();
			case Generic_BKSPackage.STATE__OUT_TRANSACTIONS:
				return outTransactions != null && !outTransactions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateImpl
