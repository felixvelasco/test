/**
 */
package com.vectorsf.jvoice.model.operations.util;

import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVElement;
import com.vectorsf.jvoice.model.base.NamedElement;

import com.vectorsf.jvoice.model.operations.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage
 * @generated
 */
public class OperationsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OperationsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OperationsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationsSwitch<Adapter> modelSwitch =
		new OperationsSwitch<Adapter>() {
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseTransition(Transition object) {
				return createTransitionAdapter();
			}
			@Override
			public Adapter caseFlow(Flow object) {
				return createFlowAdapter();
			}
			@Override
			public Adapter caseInitialState(InitialState object) {
				return createInitialStateAdapter();
			}
			@Override
			public Adapter caseFinalState(FinalState object) {
				return createFinalStateAdapter();
			}
			@Override
			public Adapter caseSwitchState(SwitchState object) {
				return createSwitchStateAdapter();
			}
			@Override
			public Adapter caseCase(Case object) {
				return createCaseAdapter();
			}
			@Override
			public Adapter caseCallState(CallState object) {
				return createCallStateAdapter();
			}
			@Override
			public Adapter caseCallFlowState(CallFlowState object) {
				return createCallFlowStateAdapter();
			}
			@Override
			public Adapter casePromptState(PromptState object) {
				return createPromptStateAdapter();
			}
			@Override
			public Adapter caseInputState(InputState object) {
				return createInputStateAdapter();
			}
			@Override
			public Adapter caseMenuState(MenuState object) {
				return createMenuStateAdapter();
			}
			@Override
			public Adapter caseLocutionState(LocutionState object) {
				return createLocutionStateAdapter();
			}
			@Override
			public Adapter caseTransferState(TransferState object) {
				return createTransferStateAdapter();
			}
			@Override
			public Adapter caseRecordState(RecordState object) {
				return createRecordStateAdapter();
			}
			@Override
			public Adapter caseNote(Note object) {
				return createNoteAdapter();
			}
			@Override
			public Adapter caseCustomState(CustomState object) {
				return createCustomStateAdapter();
			}
			@Override
			public Adapter caseComponentBean(ComponentBean object) {
				return createComponentBeanAdapter();
			}
			@Override
			public Adapter caseJVElement(JVElement object) {
				return createJVElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseJVBean(JVBean object) {
				return createJVBeanAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.Flow
	 * @generated
	 */
	public Adapter createFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.InitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.InitialState
	 * @generated
	 */
	public Adapter createInitialStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.FinalState
	 * @generated
	 */
	public Adapter createFinalStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.SwitchState <em>Switch State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.SwitchState
	 * @generated
	 */
	public Adapter createSwitchStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.Case <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.Case
	 * @generated
	 */
	public Adapter createCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.CallState <em>Call State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.CallState
	 * @generated
	 */
	public Adapter createCallStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.CallFlowState <em>Call Flow State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.CallFlowState
	 * @generated
	 */
	public Adapter createCallFlowStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.PromptState <em>Prompt State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.PromptState
	 * @generated
	 */
	public Adapter createPromptStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.InputState <em>Input State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.InputState
	 * @generated
	 */
	public Adapter createInputStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.MenuState <em>Menu State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.MenuState
	 * @generated
	 */
	public Adapter createMenuStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.LocutionState <em>Locution State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.LocutionState
	 * @generated
	 */
	public Adapter createLocutionStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.TransferState <em>Transfer State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.TransferState
	 * @generated
	 */
	public Adapter createTransferStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.RecordState <em>Record State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.RecordState
	 * @generated
	 */
	public Adapter createRecordStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.Note <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.Note
	 * @generated
	 */
	public Adapter createNoteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.CustomState <em>Custom State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.CustomState
	 * @generated
	 */
	public Adapter createCustomStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.operations.ComponentBean <em>Component Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.operations.ComponentBean
	 * @generated
	 */
	public Adapter createComponentBeanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.base.JVElement <em>JV Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.base.JVElement
	 * @generated
	 */
	public Adapter createJVElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.base.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.base.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.base.JVBean <em>JV Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.base.JVBean
	 * @generated
	 */
	public Adapter createJVBeanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //OperationsAdapterFactory
