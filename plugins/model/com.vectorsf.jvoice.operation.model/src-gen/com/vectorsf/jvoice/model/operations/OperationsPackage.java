/**
 */
package com.vectorsf.jvoice.model.operations;

import com.vectorsf.jvoice.model.base.BasePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.vectorsf.jvoice.model.operations.OperationsFactory
 * @model kind="package"
 * @generated
 */
public interface OperationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "operations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://jvoice.vectorsf.com/operations/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "operations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationsPackage eINSTANCE = com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.StateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getState()
	 * @generated
	 */
	int STATE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ID = BasePackage.NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = BasePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__DESCRIPTION = BasePackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INCOMING_TRANSITIONS = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING_TRANSITIONS = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NOTES = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__FIREABLE_EVENTS = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE___GET_EVENTS = BasePackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = BasePackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.TransitionImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ID = BasePackage.JV_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = BasePackage.JV_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = BasePackage.JV_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EVENT_NAME = BasePackage.JV_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = BasePackage.JV_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = BasePackage.JV_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.FlowImpl <em>Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.FlowImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getFlow()
	 * @generated
	 */
	int FLOW = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__ID = BasePackage.JV_BEAN__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__NAME = BasePackage.JV_BEAN__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__DESCRIPTION = BasePackage.JV_BEAN__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owner Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__OWNER_PACKAGE = BasePackage.JV_BEAN__OWNER_PACKAGE;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__STATES = BasePackage.JV_BEAN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__TRANSITIONS = BasePackage.JV_BEAN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__NOTES = BasePackage.JV_BEAN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Beans</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__BEANS = BasePackage.JV_BEAN_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__PARAMETERS = BasePackage.JV_BEAN_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Helper Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__HELPER_CLASS = BasePackage.JV_BEAN_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FEATURE_COUNT = BasePackage.JV_BEAN_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OPERATION_COUNT = BasePackage.JV_BEAN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.InitialStateImpl <em>Initial State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.InitialStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getInitialState()
	 * @generated
	 */
	int INITIAL_STATE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__ID = STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__DESCRIPTION = STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__INCOMING_TRANSITIONS = STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__OUTGOING_TRANSITIONS = STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__NOTES = STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE__FIREABLE_EVENTS = STATE__FIREABLE_EVENTS;

	/**
	 * The number of structural features of the '<em>Initial State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE___GET_EVENTS = STATE___GET_EVENTS;

	/**
	 * The number of operations of the '<em>Initial State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_STATE_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.FinalStateImpl <em>Final State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.FinalStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getFinalState()
	 * @generated
	 */
	int FINAL_STATE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__ID = STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__DESCRIPTION = STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__INCOMING_TRANSITIONS = STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__OUTGOING_TRANSITIONS = STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__NOTES = STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__FIREABLE_EVENTS = STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__FINAL = STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE__RETURN_EXPRESSION = STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE___GET_EVENTS = STATE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Final State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_STATE_OPERATION_COUNT = STATE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.SwitchStateImpl <em>Switch State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.SwitchStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getSwitchState()
	 * @generated
	 */
	int SWITCH_STATE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE__ID = STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE__DESCRIPTION = STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE__INCOMING_TRANSITIONS = STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE__OUTGOING_TRANSITIONS = STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE__NOTES = STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE__FIREABLE_EVENTS = STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE__CASE = STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Switch State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Case</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE___GET_CASE__STRING = STATE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE___GET_EVENTS = STATE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Switch State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_STATE_OPERATION_COUNT = STATE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.CaseImpl <em>Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.CaseImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getCase()
	 * @generated
	 */
	int CASE = 6;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__CONDITION = 0;

	/**
	 * The feature id for the '<em><b>Event Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__EVENT_NAME = 1;

	/**
	 * The number of structural features of the '<em>Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.ParameterizedState <em>Parameterized State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.ParameterizedState
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getParameterizedState()
	 * @generated
	 */
	int PARAMETERIZED_STATE = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_STATE__ID = STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_STATE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_STATE__DESCRIPTION = STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_STATE__INCOMING_TRANSITIONS = STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_STATE__OUTGOING_TRANSITIONS = STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_STATE__NOTES = STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_STATE__FIREABLE_EVENTS = STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_STATE__PARAMETERS = STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameterized State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_STATE___GET_EVENTS = STATE___GET_EVENTS;

	/**
	 * The number of operations of the '<em>Parameterized State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_STATE_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.ExecutableState <em>Executable State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.ExecutableState
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getExecutableState()
	 * @generated
	 */
	int EXECUTABLE_STATE = 19;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE__ID = PARAMETERIZED_STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE__NAME = PARAMETERIZED_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE__DESCRIPTION = PARAMETERIZED_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE__INCOMING_TRANSITIONS = PARAMETERIZED_STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE__OUTGOING_TRANSITIONS = PARAMETERIZED_STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE__NOTES = PARAMETERIZED_STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE__FIREABLE_EVENTS = PARAMETERIZED_STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE__PARAMETERS = PARAMETERIZED_STATE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE__METHOD_NAME = PARAMETERIZED_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Executable State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE_FEATURE_COUNT = PARAMETERIZED_STATE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE___GET_EVENTS = PARAMETERIZED_STATE___GET_EVENTS;

	/**
	 * The number of operations of the '<em>Executable State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_STATE_OPERATION_COUNT = PARAMETERIZED_STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.CallStateImpl <em>Call State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.CallStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getCallState()
	 * @generated
	 */
	int CALL_STATE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE__ID = EXECUTABLE_STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE__NAME = EXECUTABLE_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE__DESCRIPTION = EXECUTABLE_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE__INCOMING_TRANSITIONS = EXECUTABLE_STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE__OUTGOING_TRANSITIONS = EXECUTABLE_STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE__NOTES = EXECUTABLE_STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE__FIREABLE_EVENTS = EXECUTABLE_STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE__PARAMETERS = EXECUTABLE_STATE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE__METHOD_NAME = EXECUTABLE_STATE__METHOD_NAME;

	/**
	 * The feature id for the '<em><b>Bean</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE__BEAN = EXECUTABLE_STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Bean</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE__REFERENCED_BEAN = EXECUTABLE_STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE_FEATURE_COUNT = EXECUTABLE_STATE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE___GET_EVENTS = EXECUTABLE_STATE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Call State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATE_OPERATION_COUNT = EXECUTABLE_STATE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.CallFlowStateImpl <em>Call Flow State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.CallFlowStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getCallFlowState()
	 * @generated
	 */
	int CALL_FLOW_STATE = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE__ID = PARAMETERIZED_STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE__NAME = PARAMETERIZED_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE__DESCRIPTION = PARAMETERIZED_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE__INCOMING_TRANSITIONS = PARAMETERIZED_STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE__OUTGOING_TRANSITIONS = PARAMETERIZED_STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE__NOTES = PARAMETERIZED_STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE__FIREABLE_EVENTS = PARAMETERIZED_STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE__PARAMETERS = PARAMETERIZED_STATE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Subflow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE__SUBFLOW = PARAMETERIZED_STATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Call Flow State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE_FEATURE_COUNT = PARAMETERIZED_STATE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE___GET_EVENTS = PARAMETERIZED_STATE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Call Flow State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_FLOW_STATE_OPERATION_COUNT = PARAMETERIZED_STATE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.LocutionStateImpl <em>Locution State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.LocutionStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getLocutionState()
	 * @generated
	 */
	int LOCUTION_STATE = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE__ID = STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE__DESCRIPTION = STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE__INCOMING_TRANSITIONS = STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE__OUTGOING_TRANSITIONS = STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE__NOTES = STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE__FIREABLE_EVENTS = STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE__PARAMETERS = STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE__METHOD_NAME = STATE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Locution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE__LOCUTION = STATE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Textual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE__TEXTUAL = STATE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Locution State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE___GET_EVENTS = STATE___GET_EVENTS;

	/**
	 * The number of operations of the '<em>Locution State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCUTION_STATE_OPERATION_COUNT = STATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.PromptStateImpl <em>Prompt State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.PromptStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getPromptState()
	 * @generated
	 */
	int PROMPT_STATE = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE__ID = LOCUTION_STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE__NAME = LOCUTION_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE__DESCRIPTION = LOCUTION_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE__INCOMING_TRANSITIONS = LOCUTION_STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE__OUTGOING_TRANSITIONS = LOCUTION_STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE__NOTES = LOCUTION_STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE__FIREABLE_EVENTS = LOCUTION_STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE__PARAMETERS = LOCUTION_STATE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE__METHOD_NAME = LOCUTION_STATE__METHOD_NAME;

	/**
	 * The feature id for the '<em><b>Locution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE__LOCUTION = LOCUTION_STATE__LOCUTION;

	/**
	 * The feature id for the '<em><b>Textual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE__TEXTUAL = LOCUTION_STATE__TEXTUAL;

	/**
	 * The number of structural features of the '<em>Prompt State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE_FEATURE_COUNT = LOCUTION_STATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE___GET_EVENTS = LOCUTION_STATE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Prompt State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMPT_STATE_OPERATION_COUNT = LOCUTION_STATE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.InputStateImpl <em>Input State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.InputStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getInputState()
	 * @generated
	 */
	int INPUT_STATE = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE__ID = LOCUTION_STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE__NAME = LOCUTION_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE__DESCRIPTION = LOCUTION_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE__INCOMING_TRANSITIONS = LOCUTION_STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE__OUTGOING_TRANSITIONS = LOCUTION_STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE__NOTES = LOCUTION_STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE__FIREABLE_EVENTS = LOCUTION_STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE__PARAMETERS = LOCUTION_STATE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE__METHOD_NAME = LOCUTION_STATE__METHOD_NAME;

	/**
	 * The feature id for the '<em><b>Locution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE__LOCUTION = LOCUTION_STATE__LOCUTION;

	/**
	 * The feature id for the '<em><b>Textual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE__TEXTUAL = LOCUTION_STATE__TEXTUAL;

	/**
	 * The number of structural features of the '<em>Input State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE_FEATURE_COUNT = LOCUTION_STATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE___GET_EVENTS = LOCUTION_STATE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Input State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_STATE_OPERATION_COUNT = LOCUTION_STATE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.MenuStateImpl <em>Menu State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.MenuStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getMenuState()
	 * @generated
	 */
	int MENU_STATE = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE__ID = LOCUTION_STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE__NAME = LOCUTION_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE__DESCRIPTION = LOCUTION_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE__INCOMING_TRANSITIONS = LOCUTION_STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE__OUTGOING_TRANSITIONS = LOCUTION_STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE__NOTES = LOCUTION_STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE__FIREABLE_EVENTS = LOCUTION_STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE__PARAMETERS = LOCUTION_STATE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE__METHOD_NAME = LOCUTION_STATE__METHOD_NAME;

	/**
	 * The feature id for the '<em><b>Locution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE__LOCUTION = LOCUTION_STATE__LOCUTION;

	/**
	 * The feature id for the '<em><b>Textual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE__TEXTUAL = LOCUTION_STATE__TEXTUAL;

	/**
	 * The number of structural features of the '<em>Menu State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE_FEATURE_COUNT = LOCUTION_STATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE___GET_EVENTS = LOCUTION_STATE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Menu State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_STATE_OPERATION_COUNT = LOCUTION_STATE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.TransferStateImpl <em>Transfer State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.TransferStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getTransferState()
	 * @generated
	 */
	int TRANSFER_STATE = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE__ID = LOCUTION_STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE__NAME = LOCUTION_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE__DESCRIPTION = LOCUTION_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE__INCOMING_TRANSITIONS = LOCUTION_STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE__OUTGOING_TRANSITIONS = LOCUTION_STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE__NOTES = LOCUTION_STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE__FIREABLE_EVENTS = LOCUTION_STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE__PARAMETERS = LOCUTION_STATE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE__METHOD_NAME = LOCUTION_STATE__METHOD_NAME;

	/**
	 * The feature id for the '<em><b>Locution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE__LOCUTION = LOCUTION_STATE__LOCUTION;

	/**
	 * The feature id for the '<em><b>Textual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE__TEXTUAL = LOCUTION_STATE__TEXTUAL;

	/**
	 * The number of structural features of the '<em>Transfer State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE_FEATURE_COUNT = LOCUTION_STATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE___GET_EVENTS = LOCUTION_STATE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Transfer State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_STATE_OPERATION_COUNT = LOCUTION_STATE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.RecordStateImpl <em>Record State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.RecordStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getRecordState()
	 * @generated
	 */
	int RECORD_STATE = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE__ID = LOCUTION_STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE__NAME = LOCUTION_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE__DESCRIPTION = LOCUTION_STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE__INCOMING_TRANSITIONS = LOCUTION_STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE__OUTGOING_TRANSITIONS = LOCUTION_STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE__NOTES = LOCUTION_STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE__FIREABLE_EVENTS = LOCUTION_STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE__PARAMETERS = LOCUTION_STATE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE__METHOD_NAME = LOCUTION_STATE__METHOD_NAME;

	/**
	 * The feature id for the '<em><b>Locution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE__LOCUTION = LOCUTION_STATE__LOCUTION;

	/**
	 * The feature id for the '<em><b>Textual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE__TEXTUAL = LOCUTION_STATE__TEXTUAL;

	/**
	 * The number of structural features of the '<em>Record State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE_FEATURE_COUNT = LOCUTION_STATE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE___GET_EVENTS = LOCUTION_STATE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Record State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_STATE_OPERATION_COUNT = LOCUTION_STATE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.NoteImpl <em>Note</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.NoteImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getNote()
	 * @generated
	 */
	int NOTE = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__ID = BasePackage.JV_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__DESCRIPTION = BasePackage.JV_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__REFERENCED_STATES = BasePackage.JV_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE__NAME = BasePackage.JV_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_FEATURE_COUNT = BasePackage.JV_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Note</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_OPERATION_COUNT = BasePackage.JV_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.CustomStateImpl <em>Custom State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.CustomStateImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getCustomState()
	 * @generated
	 */
	int CUSTOM_STATE = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE__ID = STATE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE__DESCRIPTION = STATE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE__INCOMING_TRANSITIONS = STATE__INCOMING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE__OUTGOING_TRANSITIONS = STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE__NOTES = STATE__NOTES;

	/**
	 * The feature id for the '<em><b>Fireable Events</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE__FIREABLE_EVENTS = STATE__FIREABLE_EVENTS;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE__PATH = STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binding Bean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE__BINDING_BEAN = STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Custom State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Events</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE___GET_EVENTS = STATE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Custom State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_STATE_OPERATION_COUNT = STATE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.operations.impl.ComponentBeanImpl <em>Component Bean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.operations.impl.ComponentBeanImpl
	 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getComponentBean()
	 * @generated
	 */
	int COMPONENT_BEAN = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BEAN__ID = BasePackage.NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BEAN__NAME = BasePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BEAN__DESCRIPTION = BasePackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Fqdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BEAN__FQDN = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name Bean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BEAN__NAME_BEAN = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prototype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BEAN__PROTOTYPE = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Component Bean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BEAN_FEATURE_COUNT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Component Bean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_BEAN_OPERATION_COUNT = BasePackage.NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference list '{@link com.vectorsf.jvoice.model.operations.State#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
	 * @see com.vectorsf.jvoice.model.operations.State#getIncomingTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_IncomingTransitions();

	/**
	 * Returns the meta object for the reference list '{@link com.vectorsf.jvoice.model.operations.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Transitions</em>'.
	 * @see com.vectorsf.jvoice.model.operations.State#getOutgoingTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutgoingTransitions();

	/**
	 * Returns the meta object for the reference '{@link com.vectorsf.jvoice.model.operations.State#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Notes</em>'.
	 * @see com.vectorsf.jvoice.model.operations.State#getNotes()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Notes();

	/**
	 * Returns the meta object for the attribute list '{@link com.vectorsf.jvoice.model.operations.State#getFireableEvents <em>Fireable Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Fireable Events</em>'.
	 * @see com.vectorsf.jvoice.model.operations.State#getFireableEvents()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_FireableEvents();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.State#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.State#getEvents()
	 * @generated
	 */
	EOperation getState__GetEvents();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link com.vectorsf.jvoice.model.operations.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link com.vectorsf.jvoice.model.operations.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.Transition#getEventName <em>Event Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Name</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Transition#getEventName()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_EventName();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Flow
	 * @generated
	 */
	EClass getFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.model.operations.Flow#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Flow#getStates()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_States();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.model.operations.Flow#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Flow#getTransitions()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Transitions();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.model.operations.Flow#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Notes</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Flow#getNotes()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Notes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.model.operations.Flow#getBeans <em>Beans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Beans</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Flow#getBeans()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Beans();

	/**
	 * Returns the meta object for the attribute list '{@link com.vectorsf.jvoice.model.operations.Flow#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parameters</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Flow#getParameters()
	 * @see #getFlow()
	 * @generated
	 */
	EAttribute getFlow_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.Flow#getHelperClass <em>Helper Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Helper Class</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Flow#getHelperClass()
	 * @see #getFlow()
	 * @generated
	 */
	EAttribute getFlow_HelperClass();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.InitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.InitialState
	 * @generated
	 */
	EClass getInitialState();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.FinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.FinalState
	 * @generated
	 */
	EClass getFinalState();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.FinalState#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see com.vectorsf.jvoice.model.operations.FinalState#isFinal()
	 * @see #getFinalState()
	 * @generated
	 */
	EAttribute getFinalState_Final();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.FinalState#getReturnExpression <em>Return Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return Expression</em>'.
	 * @see com.vectorsf.jvoice.model.operations.FinalState#getReturnExpression()
	 * @see #getFinalState()
	 * @generated
	 */
	EAttribute getFinalState_ReturnExpression();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.FinalState#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.FinalState#getEvents()
	 * @generated
	 */
	EOperation getFinalState__GetEvents();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.SwitchState <em>Switch State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.SwitchState
	 * @generated
	 */
	EClass getSwitchState();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.model.operations.SwitchState#getCase <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Case</em>'.
	 * @see com.vectorsf.jvoice.model.operations.SwitchState#getCase()
	 * @see #getSwitchState()
	 * @generated
	 */
	EReference getSwitchState_Case();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.SwitchState#getCase(java.lang.String) <em>Get Case</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Case</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.SwitchState#getCase(java.lang.String)
	 * @generated
	 */
	EOperation getSwitchState__GetCase__String();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.SwitchState#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.SwitchState#getEvents()
	 * @generated
	 */
	EOperation getSwitchState__GetEvents();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.Case <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Case
	 * @generated
	 */
	EClass getCase();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.Case#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Case#getCondition()
	 * @see #getCase()
	 * @generated
	 */
	EAttribute getCase_Condition();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.Case#getEventName <em>Event Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Name</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Case#getEventName()
	 * @see #getCase()
	 * @generated
	 */
	EAttribute getCase_EventName();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.CallState <em>Call State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.CallState
	 * @generated
	 */
	EClass getCallState();

	/**
	 * Returns the meta object for the reference '{@link com.vectorsf.jvoice.model.operations.CallState#getBean <em>Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bean</em>'.
	 * @see com.vectorsf.jvoice.model.operations.CallState#getBean()
	 * @see #getCallState()
	 * @generated
	 */
	EReference getCallState_Bean();

	/**
	 * Returns the meta object for the reference '{@link com.vectorsf.jvoice.model.operations.CallState#getReferencedBean <em>Referenced Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Bean</em>'.
	 * @see com.vectorsf.jvoice.model.operations.CallState#getReferencedBean()
	 * @see #getCallState()
	 * @generated
	 */
	EReference getCallState_ReferencedBean();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.CallState#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.CallState#getEvents()
	 * @generated
	 */
	EOperation getCallState__GetEvents();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.CallFlowState <em>Call Flow State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Flow State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.CallFlowState
	 * @generated
	 */
	EClass getCallFlowState();

	/**
	 * Returns the meta object for the reference '{@link com.vectorsf.jvoice.model.operations.CallFlowState#getSubflow <em>Subflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subflow</em>'.
	 * @see com.vectorsf.jvoice.model.operations.CallFlowState#getSubflow()
	 * @see #getCallFlowState()
	 * @generated
	 */
	EReference getCallFlowState_Subflow();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.CallFlowState#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.CallFlowState#getEvents()
	 * @generated
	 */
	EOperation getCallFlowState__GetEvents();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.PromptState <em>Prompt State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prompt State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.PromptState
	 * @generated
	 */
	EClass getPromptState();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.PromptState#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.PromptState#getEvents()
	 * @generated
	 */
	EOperation getPromptState__GetEvents();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.InputState <em>Input State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.InputState
	 * @generated
	 */
	EClass getInputState();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.InputState#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.InputState#getEvents()
	 * @generated
	 */
	EOperation getInputState__GetEvents();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.MenuState <em>Menu State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.MenuState
	 * @generated
	 */
	EClass getMenuState();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.MenuState#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.MenuState#getEvents()
	 * @generated
	 */
	EOperation getMenuState__GetEvents();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.LocutionState <em>Locution State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Locution State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.LocutionState
	 * @generated
	 */
	EClass getLocutionState();

	/**
	 * Returns the meta object for the reference '{@link com.vectorsf.jvoice.model.operations.LocutionState#getLocution <em>Locution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Locution</em>'.
	 * @see com.vectorsf.jvoice.model.operations.LocutionState#getLocution()
	 * @see #getLocutionState()
	 * @generated
	 */
	EReference getLocutionState_Locution();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.LocutionState#isTextual <em>Textual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Textual</em>'.
	 * @see com.vectorsf.jvoice.model.operations.LocutionState#isTextual()
	 * @see #getLocutionState()
	 * @generated
	 */
	EAttribute getLocutionState_Textual();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.TransferState <em>Transfer State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transfer State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.TransferState
	 * @generated
	 */
	EClass getTransferState();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.TransferState#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.TransferState#getEvents()
	 * @generated
	 */
	EOperation getTransferState__GetEvents();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.RecordState <em>Record State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.RecordState
	 * @generated
	 */
	EClass getRecordState();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.RecordState#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.RecordState#getEvents()
	 * @generated
	 */
	EOperation getRecordState__GetEvents();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.Note <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Note</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Note
	 * @generated
	 */
	EClass getNote();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.Note#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Note#getDescription()
	 * @see #getNote()
	 * @generated
	 */
	EAttribute getNote_Description();

	/**
	 * Returns the meta object for the reference list '{@link com.vectorsf.jvoice.model.operations.Note#getReferencedStates <em>Referenced States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced States</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Note#getReferencedStates()
	 * @see #getNote()
	 * @generated
	 */
	EReference getNote_ReferencedStates();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.Note#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.vectorsf.jvoice.model.operations.Note#getName()
	 * @see #getNote()
	 * @generated
	 */
	EAttribute getNote_Name();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.CustomState <em>Custom State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.CustomState
	 * @generated
	 */
	EClass getCustomState();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.CustomState#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see com.vectorsf.jvoice.model.operations.CustomState#getPath()
	 * @see #getCustomState()
	 * @generated
	 */
	EAttribute getCustomState_Path();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.CustomState#getBindingBean <em>Binding Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binding Bean</em>'.
	 * @see com.vectorsf.jvoice.model.operations.CustomState#getBindingBean()
	 * @see #getCustomState()
	 * @generated
	 */
	EAttribute getCustomState_BindingBean();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.operations.CustomState#getEvents() <em>Get Events</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Events</em>' operation.
	 * @see com.vectorsf.jvoice.model.operations.CustomState#getEvents()
	 * @generated
	 */
	EOperation getCustomState__GetEvents();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.ComponentBean <em>Component Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Bean</em>'.
	 * @see com.vectorsf.jvoice.model.operations.ComponentBean
	 * @generated
	 */
	EClass getComponentBean();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.ComponentBean#getFqdn <em>Fqdn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fqdn</em>'.
	 * @see com.vectorsf.jvoice.model.operations.ComponentBean#getFqdn()
	 * @see #getComponentBean()
	 * @generated
	 */
	EAttribute getComponentBean_Fqdn();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.ComponentBean#getNameBean <em>Name Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Bean</em>'.
	 * @see com.vectorsf.jvoice.model.operations.ComponentBean#getNameBean()
	 * @see #getComponentBean()
	 * @generated
	 */
	EAttribute getComponentBean_NameBean();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.ComponentBean#isPrototype <em>Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prototype</em>'.
	 * @see com.vectorsf.jvoice.model.operations.ComponentBean#isPrototype()
	 * @see #getComponentBean()
	 * @generated
	 */
	EAttribute getComponentBean_Prototype();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.ParameterizedState <em>Parameterized State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.ParameterizedState
	 * @generated
	 */
	EClass getParameterizedState();

	/**
	 * Returns the meta object for the attribute list '{@link com.vectorsf.jvoice.model.operations.ParameterizedState#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parameters</em>'.
	 * @see com.vectorsf.jvoice.model.operations.ParameterizedState#getParameters()
	 * @see #getParameterizedState()
	 * @generated
	 */
	EAttribute getParameterizedState_Parameters();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.operations.ExecutableState <em>Executable State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executable State</em>'.
	 * @see com.vectorsf.jvoice.model.operations.ExecutableState
	 * @generated
	 */
	EClass getExecutableState();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.operations.ExecutableState#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see com.vectorsf.jvoice.model.operations.ExecutableState#getMethodName()
	 * @see #getExecutableState()
	 * @generated
	 */
	EAttribute getExecutableState_MethodName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OperationsFactory getOperationsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.StateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Incoming Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__INCOMING_TRANSITIONS = eINSTANCE.getState_IncomingTransitions();

		/**
		 * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUTGOING_TRANSITIONS = eINSTANCE.getState_OutgoingTransitions();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__NOTES = eINSTANCE.getState_Notes();

		/**
		 * The meta object literal for the '<em><b>Fireable Events</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__FIREABLE_EVENTS = eINSTANCE.getState_FireableEvents();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STATE___GET_EVENTS = eINSTANCE.getState__GetEvents();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.TransitionImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

		/**
		 * The meta object literal for the '<em><b>Event Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__EVENT_NAME = eINSTANCE.getTransition_EventName();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.FlowImpl <em>Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.FlowImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getFlow()
		 * @generated
		 */
		EClass FLOW = eINSTANCE.getFlow();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__STATES = eINSTANCE.getFlow_States();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__TRANSITIONS = eINSTANCE.getFlow_Transitions();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__NOTES = eINSTANCE.getFlow_Notes();

		/**
		 * The meta object literal for the '<em><b>Beans</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__BEANS = eINSTANCE.getFlow_Beans();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW__PARAMETERS = eINSTANCE.getFlow_Parameters();

		/**
		 * The meta object literal for the '<em><b>Helper Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW__HELPER_CLASS = eINSTANCE.getFlow_HelperClass();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.InitialStateImpl <em>Initial State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.InitialStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getInitialState()
		 * @generated
		 */
		EClass INITIAL_STATE = eINSTANCE.getInitialState();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.FinalStateImpl <em>Final State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.FinalStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getFinalState()
		 * @generated
		 */
		EClass FINAL_STATE = eINSTANCE.getFinalState();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FINAL_STATE__FINAL = eINSTANCE.getFinalState_Final();

		/**
		 * The meta object literal for the '<em><b>Return Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FINAL_STATE__RETURN_EXPRESSION = eINSTANCE.getFinalState_ReturnExpression();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FINAL_STATE___GET_EVENTS = eINSTANCE.getFinalState__GetEvents();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.SwitchStateImpl <em>Switch State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.SwitchStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getSwitchState()
		 * @generated
		 */
		EClass SWITCH_STATE = eINSTANCE.getSwitchState();

		/**
		 * The meta object literal for the '<em><b>Case</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_STATE__CASE = eINSTANCE.getSwitchState_Case();

		/**
		 * The meta object literal for the '<em><b>Get Case</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SWITCH_STATE___GET_CASE__STRING = eINSTANCE.getSwitchState__GetCase__String();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SWITCH_STATE___GET_EVENTS = eINSTANCE.getSwitchState__GetEvents();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.CaseImpl <em>Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.CaseImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getCase()
		 * @generated
		 */
		EClass CASE = eINSTANCE.getCase();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CASE__CONDITION = eINSTANCE.getCase_Condition();

		/**
		 * The meta object literal for the '<em><b>Event Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CASE__EVENT_NAME = eINSTANCE.getCase_EventName();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.CallStateImpl <em>Call State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.CallStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getCallState()
		 * @generated
		 */
		EClass CALL_STATE = eINSTANCE.getCallState();

		/**
		 * The meta object literal for the '<em><b>Bean</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_STATE__BEAN = eINSTANCE.getCallState_Bean();

		/**
		 * The meta object literal for the '<em><b>Referenced Bean</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_STATE__REFERENCED_BEAN = eINSTANCE.getCallState_ReferencedBean();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CALL_STATE___GET_EVENTS = eINSTANCE.getCallState__GetEvents();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.CallFlowStateImpl <em>Call Flow State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.CallFlowStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getCallFlowState()
		 * @generated
		 */
		EClass CALL_FLOW_STATE = eINSTANCE.getCallFlowState();

		/**
		 * The meta object literal for the '<em><b>Subflow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_FLOW_STATE__SUBFLOW = eINSTANCE.getCallFlowState_Subflow();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CALL_FLOW_STATE___GET_EVENTS = eINSTANCE.getCallFlowState__GetEvents();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.PromptStateImpl <em>Prompt State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.PromptStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getPromptState()
		 * @generated
		 */
		EClass PROMPT_STATE = eINSTANCE.getPromptState();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMPT_STATE___GET_EVENTS = eINSTANCE.getPromptState__GetEvents();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.InputStateImpl <em>Input State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.InputStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getInputState()
		 * @generated
		 */
		EClass INPUT_STATE = eINSTANCE.getInputState();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INPUT_STATE___GET_EVENTS = eINSTANCE.getInputState__GetEvents();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.MenuStateImpl <em>Menu State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.MenuStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getMenuState()
		 * @generated
		 */
		EClass MENU_STATE = eINSTANCE.getMenuState();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MENU_STATE___GET_EVENTS = eINSTANCE.getMenuState__GetEvents();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.LocutionStateImpl <em>Locution State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.LocutionStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getLocutionState()
		 * @generated
		 */
		EClass LOCUTION_STATE = eINSTANCE.getLocutionState();

		/**
		 * The meta object literal for the '<em><b>Locution</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCUTION_STATE__LOCUTION = eINSTANCE.getLocutionState_Locution();

		/**
		 * The meta object literal for the '<em><b>Textual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCUTION_STATE__TEXTUAL = eINSTANCE.getLocutionState_Textual();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.TransferStateImpl <em>Transfer State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.TransferStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getTransferState()
		 * @generated
		 */
		EClass TRANSFER_STATE = eINSTANCE.getTransferState();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFER_STATE___GET_EVENTS = eINSTANCE.getTransferState__GetEvents();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.RecordStateImpl <em>Record State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.RecordStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getRecordState()
		 * @generated
		 */
		EClass RECORD_STATE = eINSTANCE.getRecordState();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RECORD_STATE___GET_EVENTS = eINSTANCE.getRecordState__GetEvents();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.NoteImpl <em>Note</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.NoteImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getNote()
		 * @generated
		 */
		EClass NOTE = eINSTANCE.getNote();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTE__DESCRIPTION = eINSTANCE.getNote_Description();

		/**
		 * The meta object literal for the '<em><b>Referenced States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTE__REFERENCED_STATES = eINSTANCE.getNote_ReferencedStates();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTE__NAME = eINSTANCE.getNote_Name();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.CustomStateImpl <em>Custom State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.CustomStateImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getCustomState()
		 * @generated
		 */
		EClass CUSTOM_STATE = eINSTANCE.getCustomState();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_STATE__PATH = eINSTANCE.getCustomState_Path();

		/**
		 * The meta object literal for the '<em><b>Binding Bean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_STATE__BINDING_BEAN = eINSTANCE.getCustomState_BindingBean();

		/**
		 * The meta object literal for the '<em><b>Get Events</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CUSTOM_STATE___GET_EVENTS = eINSTANCE.getCustomState__GetEvents();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.impl.ComponentBeanImpl <em>Component Bean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.impl.ComponentBeanImpl
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getComponentBean()
		 * @generated
		 */
		EClass COMPONENT_BEAN = eINSTANCE.getComponentBean();

		/**
		 * The meta object literal for the '<em><b>Fqdn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_BEAN__FQDN = eINSTANCE.getComponentBean_Fqdn();

		/**
		 * The meta object literal for the '<em><b>Name Bean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_BEAN__NAME_BEAN = eINSTANCE.getComponentBean_NameBean();

		/**
		 * The meta object literal for the '<em><b>Prototype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_BEAN__PROTOTYPE = eINSTANCE.getComponentBean_Prototype();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.ParameterizedState <em>Parameterized State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.ParameterizedState
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getParameterizedState()
		 * @generated
		 */
		EClass PARAMETERIZED_STATE = eINSTANCE.getParameterizedState();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETERIZED_STATE__PARAMETERS = eINSTANCE.getParameterizedState_Parameters();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.operations.ExecutableState <em>Executable State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.operations.ExecutableState
		 * @see com.vectorsf.jvoice.model.operations.impl.OperationsPackageImpl#getExecutableState()
		 * @generated
		 */
		EClass EXECUTABLE_STATE = eINSTANCE.getExecutableState();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTABLE_STATE__METHOD_NAME = eINSTANCE.getExecutableState_MethodName();

	}

} //OperationsPackage
