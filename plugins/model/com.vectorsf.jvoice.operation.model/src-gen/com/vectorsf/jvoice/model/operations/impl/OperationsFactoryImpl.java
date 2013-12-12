/**
 */
package com.vectorsf.jvoice.model.operations.impl;

import com.vectorsf.jvoice.model.operations.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationsFactoryImpl extends EFactoryImpl implements OperationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OperationsFactory init() {
		try {
			OperationsFactory theOperationsFactory = (OperationsFactory)EPackage.Registry.INSTANCE.getEFactory(OperationsPackage.eNS_URI);
			if (theOperationsFactory != null) {
				return theOperationsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OperationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OperationsPackage.TRANSITION: return createTransition();
			case OperationsPackage.FLOW: return createFlow();
			case OperationsPackage.INITIAL_STATE: return createInitialState();
			case OperationsPackage.FINAL_STATE: return createFinalState();
			case OperationsPackage.SWITCH_STATE: return createSwitchState();
			case OperationsPackage.CASE: return createCase();
			case OperationsPackage.CALL_STATE: return createCallState();
			case OperationsPackage.CALL_FLOW_STATE: return createCallFlowState();
			case OperationsPackage.PROMPT_STATE: return createPromptState();
			case OperationsPackage.INPUT_STATE: return createInputState();
			case OperationsPackage.MENU_STATE: return createMenuState();
			case OperationsPackage.TRANSFER_STATE: return createTransferState();
			case OperationsPackage.RECORD_STATE: return createRecordState();
			case OperationsPackage.NOTE: return createNote();
			case OperationsPackage.CUSTOM_STATE: return createCustomState();
			case OperationsPackage.COMPONENT_BEAN: return createComponentBean();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow createFlow() {
		FlowImpl flow = new FlowImpl();
		return flow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialState createInitialState() {
		InitialStateImpl initialState = new InitialStateImpl();
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalState createFinalState() {
		FinalStateImpl finalState = new FinalStateImpl();
		return finalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchState createSwitchState() {
		SwitchStateImpl switchState = new SwitchStateImpl();
		return switchState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Case createCase() {
		CaseImpl case_ = new CaseImpl();
		return case_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallState createCallState() {
		CallStateImpl callState = new CallStateImpl();
		return callState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallFlowState createCallFlowState() {
		CallFlowStateImpl callFlowState = new CallFlowStateImpl();
		return callFlowState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PromptState createPromptState() {
		PromptStateImpl promptState = new PromptStateImpl();
		return promptState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputState createInputState() {
		InputStateImpl inputState = new InputStateImpl();
		return inputState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuState createMenuState() {
		MenuStateImpl menuState = new MenuStateImpl();
		return menuState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransferState createTransferState() {
		TransferStateImpl transferState = new TransferStateImpl();
		return transferState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordState createRecordState() {
		RecordStateImpl recordState = new RecordStateImpl();
		return recordState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Note createNote() {
		NoteImpl note = new NoteImpl();
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomState createCustomState() {
		CustomStateImpl customState = new CustomStateImpl();
		return customState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentBean createComponentBean() {
		ComponentBeanImpl componentBean = new ComponentBeanImpl();
		return componentBean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsPackage getOperationsPackage() {
		return (OperationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OperationsPackage getPackage() {
		return OperationsPackage.eINSTANCE;
	}

} //OperationsFactoryImpl
