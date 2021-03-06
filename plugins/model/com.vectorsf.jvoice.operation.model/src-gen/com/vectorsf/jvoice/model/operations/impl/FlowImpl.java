/**
 */
package com.vectorsf.jvoice.model.operations.impl;

import com.vectorsf.jvoice.model.base.impl.JVBeanImpl;

import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.Note;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.FlowImpl#getStates <em>States</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.FlowImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.FlowImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.FlowImpl#getBeans <em>Beans</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.FlowImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.impl.FlowImpl#getHelperClass <em>Helper Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlowImpl extends JVBeanImpl implements Flow {
	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transitions;

	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected EList<Note> notes;

	/**
	 * The cached value of the '{@link #getBeans() <em>Beans</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeans()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentBean> beans;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<String> parameters;

	/**
	 * The default value of the '{@link #getHelperClass() <em>Helper Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelperClass()
	 * @generated
	 * @ordered
	 */
	protected static final String HELPER_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHelperClass() <em>Helper Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelperClass()
	 * @generated
	 * @ordered
	 */
	protected String helperClass = HELPER_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, OperationsPackage.FLOW__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<Transition>(Transition.class, this, OperationsPackage.FLOW__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Note> getNotes() {
		if (notes == null) {
			notes = new EObjectContainmentEList<Note>(Note.class, this, OperationsPackage.FLOW__NOTES);
		}
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentBean> getBeans() {
		if (beans == null) {
			beans = new EObjectContainmentEList<ComponentBean>(ComponentBean.class, this, OperationsPackage.FLOW__BEANS);
		}
		return beans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getParameters() {
		if (parameters == null) {
			parameters = new EDataTypeUniqueEList<String>(String.class, this, OperationsPackage.FLOW__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHelperClass() {
		return helperClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHelperClass(String newHelperClass) {
		String oldHelperClass = helperClass;
		helperClass = newHelperClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.FLOW__HELPER_CLASS, oldHelperClass, helperClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationsPackage.FLOW__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case OperationsPackage.FLOW__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
			case OperationsPackage.FLOW__NOTES:
				return ((InternalEList<?>)getNotes()).basicRemove(otherEnd, msgs);
			case OperationsPackage.FLOW__BEANS:
				return ((InternalEList<?>)getBeans()).basicRemove(otherEnd, msgs);
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
			case OperationsPackage.FLOW__STATES:
				return getStates();
			case OperationsPackage.FLOW__TRANSITIONS:
				return getTransitions();
			case OperationsPackage.FLOW__NOTES:
				return getNotes();
			case OperationsPackage.FLOW__BEANS:
				return getBeans();
			case OperationsPackage.FLOW__PARAMETERS:
				return getParameters();
			case OperationsPackage.FLOW__HELPER_CLASS:
				return getHelperClass();
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
			case OperationsPackage.FLOW__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case OperationsPackage.FLOW__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case OperationsPackage.FLOW__NOTES:
				getNotes().clear();
				getNotes().addAll((Collection<? extends Note>)newValue);
				return;
			case OperationsPackage.FLOW__BEANS:
				getBeans().clear();
				getBeans().addAll((Collection<? extends ComponentBean>)newValue);
				return;
			case OperationsPackage.FLOW__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends String>)newValue);
				return;
			case OperationsPackage.FLOW__HELPER_CLASS:
				setHelperClass((String)newValue);
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
			case OperationsPackage.FLOW__STATES:
				getStates().clear();
				return;
			case OperationsPackage.FLOW__TRANSITIONS:
				getTransitions().clear();
				return;
			case OperationsPackage.FLOW__NOTES:
				getNotes().clear();
				return;
			case OperationsPackage.FLOW__BEANS:
				getBeans().clear();
				return;
			case OperationsPackage.FLOW__PARAMETERS:
				getParameters().clear();
				return;
			case OperationsPackage.FLOW__HELPER_CLASS:
				setHelperClass(HELPER_CLASS_EDEFAULT);
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
			case OperationsPackage.FLOW__STATES:
				return states != null && !states.isEmpty();
			case OperationsPackage.FLOW__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case OperationsPackage.FLOW__NOTES:
				return notes != null && !notes.isEmpty();
			case OperationsPackage.FLOW__BEANS:
				return beans != null && !beans.isEmpty();
			case OperationsPackage.FLOW__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case OperationsPackage.FLOW__HELPER_CLASS:
				return HELPER_CLASS_EDEFAULT == null ? helperClass != null : !HELPER_CLASS_EDEFAULT.equals(helperClass);
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
		result.append(" (parameters: ");
		result.append(parameters);
		result.append(", helperClass: ");
		result.append(helperClass);
		result.append(')');
		return result.toString();
	}

} //FlowImpl
