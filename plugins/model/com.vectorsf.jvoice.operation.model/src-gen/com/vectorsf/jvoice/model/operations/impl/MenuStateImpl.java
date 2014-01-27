/**
 */
package com.vectorsf.jvoice.model.operations.impl;

import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

import com.vectorsf.jvoice.model.operations.State;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MenuStateImpl extends LocutionStateImpl implements MenuState {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.MENU_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEvents() {
				org.eclipse.emf.common.util.BasicEList<String> list = new org.eclipse.emf.common.util.BasicEList<String>();
				list.add("busy");
				list.add("conn_error");
				list.add("error");
				list.add("far_end_disc");
				list.add("hangup");
				list.add("match");
				list.add("maxatt");
				list.add("maxtime");
				list.add("netw_busy");
				list.add("netw_disconnect");
				list.add("noanswer");
				list.add("noinput");
				list.add("nomatch");
				list.add("noresource");
				list.add("recorded");
				list.add("record_unsup");
				list.add("success");
				list.add("transferred");
				list.add("unknown");
		
				return list;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == State.class) {
			switch (baseOperationID) {
				case OperationsPackage.STATE___GET_EVENTS: return OperationsPackage.MENU_STATE___GET_EVENTS;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OperationsPackage.MENU_STATE___GET_EVENTS:
				return getEvents();
		}
		return super.eInvoke(operationID, arguments);
	}

} //MenuStateImpl
