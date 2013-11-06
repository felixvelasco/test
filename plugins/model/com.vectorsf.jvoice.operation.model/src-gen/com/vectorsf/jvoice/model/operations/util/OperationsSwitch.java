/**
 */
package com.vectorsf.jvoice.model.operations.util;

import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVElement;
import com.vectorsf.jvoice.model.base.NamedElement;

import com.vectorsf.jvoice.model.operations.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage
 * @generated
 */
public class OperationsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OperationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsSwitch() {
		if (modelPackage == null) {
			modelPackage = OperationsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OperationsPackage.STATE: {
				State state = (State)theEObject;
				T result = caseState(state);
				if (result == null) result = caseNamedElement(state);
				if (result == null) result = caseJVElement(state);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.TRANSITION: {
				Transition transition = (Transition)theEObject;
				T result = caseTransition(transition);
				if (result == null) result = caseJVElement(transition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.FLOW: {
				Flow flow = (Flow)theEObject;
				T result = caseFlow(flow);
				if (result == null) result = caseJVBean(flow);
				if (result == null) result = caseNamedElement(flow);
				if (result == null) result = caseJVElement(flow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.INITIAL_STATE: {
				InitialState initialState = (InitialState)theEObject;
				T result = caseInitialState(initialState);
				if (result == null) result = caseState(initialState);
				if (result == null) result = caseNamedElement(initialState);
				if (result == null) result = caseJVElement(initialState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.FINAL_STATE: {
				FinalState finalState = (FinalState)theEObject;
				T result = caseFinalState(finalState);
				if (result == null) result = caseState(finalState);
				if (result == null) result = caseNamedElement(finalState);
				if (result == null) result = caseJVElement(finalState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.SWITCH_STATE: {
				SwitchState switchState = (SwitchState)theEObject;
				T result = caseSwitchState(switchState);
				if (result == null) result = caseState(switchState);
				if (result == null) result = caseNamedElement(switchState);
				if (result == null) result = caseJVElement(switchState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.CASE: {
				Case case_ = (Case)theEObject;
				T result = caseCase(case_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.CALL_STATE: {
				CallState callState = (CallState)theEObject;
				T result = caseCallState(callState);
				if (result == null) result = caseState(callState);
				if (result == null) result = caseNamedElement(callState);
				if (result == null) result = caseJVElement(callState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.CALL_FLOW_STATE: {
				CallFlowState callFlowState = (CallFlowState)theEObject;
				T result = caseCallFlowState(callFlowState);
				if (result == null) result = caseState(callFlowState);
				if (result == null) result = caseNamedElement(callFlowState);
				if (result == null) result = caseJVElement(callFlowState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.PROMPT_STATE: {
				PromptState promptState = (PromptState)theEObject;
				T result = casePromptState(promptState);
				if (result == null) result = caseLocutionState(promptState);
				if (result == null) result = caseState(promptState);
				if (result == null) result = caseNamedElement(promptState);
				if (result == null) result = caseJVElement(promptState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.INPUT_STATE: {
				InputState inputState = (InputState)theEObject;
				T result = caseInputState(inputState);
				if (result == null) result = caseLocutionState(inputState);
				if (result == null) result = caseState(inputState);
				if (result == null) result = caseNamedElement(inputState);
				if (result == null) result = caseJVElement(inputState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.MENU_STATE: {
				MenuState menuState = (MenuState)theEObject;
				T result = caseMenuState(menuState);
				if (result == null) result = caseLocutionState(menuState);
				if (result == null) result = caseState(menuState);
				if (result == null) result = caseNamedElement(menuState);
				if (result == null) result = caseJVElement(menuState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.LOCUTION_STATE: {
				LocutionState locutionState = (LocutionState)theEObject;
				T result = caseLocutionState(locutionState);
				if (result == null) result = caseState(locutionState);
				if (result == null) result = caseNamedElement(locutionState);
				if (result == null) result = caseJVElement(locutionState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.TRANSFER_STATE: {
				TransferState transferState = (TransferState)theEObject;
				T result = caseTransferState(transferState);
				if (result == null) result = caseState(transferState);
				if (result == null) result = caseNamedElement(transferState);
				if (result == null) result = caseJVElement(transferState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.RECORD_STATE: {
				RecordState recordState = (RecordState)theEObject;
				T result = caseRecordState(recordState);
				if (result == null) result = caseState(recordState);
				if (result == null) result = caseNamedElement(recordState);
				if (result == null) result = caseJVElement(recordState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.NOTE: {
				Note note = (Note)theEObject;
				T result = caseNote(note);
				if (result == null) result = caseJVElement(note);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.CUSTOM_STATE: {
				CustomState customState = (CustomState)theEObject;
				T result = caseCustomState(customState);
				if (result == null) result = caseState(customState);
				if (result == null) result = caseNamedElement(customState);
				if (result == null) result = caseJVElement(customState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseState(State object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransition(Transition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlow(Flow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initial State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initial State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitialState(InitialState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Final State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFinalState(FinalState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchState(SwitchState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCase(Case object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallState(CallState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Flow State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Flow State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallFlowState(CallFlowState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prompt State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prompt State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePromptState(PromptState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputState(InputState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menu State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menu State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenuState(MenuState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Locution State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Locution State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocutionState(LocutionState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transfer State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transfer State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransferState(TransferState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Record State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Record State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecordState(RecordState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Note</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Note</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNote(Note object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomState(CustomState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JV Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JV Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJVElement(JVElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JV Bean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JV Bean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJVBean(JVBean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //OperationsSwitch
