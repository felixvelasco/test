/**
 */
package Generic_BKS.impl;

import Generic_BKS.*;

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
public class Generic_BKSFactoryImpl extends EFactoryImpl implements Generic_BKSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Generic_BKSFactory init() {
		try {
			Generic_BKSFactory theGeneric_BKSFactory = (Generic_BKSFactory)EPackage.Registry.INSTANCE.getEFactory(Generic_BKSPackage.eNS_URI);
			if (theGeneric_BKSFactory != null) {
				return theGeneric_BKSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Generic_BKSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generic_BKSFactoryImpl() {
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
			case Generic_BKSPackage.FLOW: return createFlow();
			case Generic_BKSPackage.CONDITIONAL: return createConditional();
			case Generic_BKSPackage.CALL_WS: return createCallWS();
			case Generic_BKSPackage.CALL_FACADE: return createCallFacade();
			case Generic_BKSPackage.INITIAL: return createInitial();
			case Generic_BKSPackage.END: return createEnd();
			case Generic_BKSPackage.TRANSITION: return createTransition();
			case Generic_BKSPackage.EVENT: return createEvent();
			case Generic_BKSPackage.SUB_FLOW: return createSubFlow();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
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
	public Conditional createConditional() {
		ConditionalImpl conditional = new ConditionalImpl();
		return conditional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallWS createCallWS() {
		CallWSImpl callWS = new CallWSImpl();
		return callWS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallFacade createCallFacade() {
		CallFacadeImpl callFacade = new CallFacadeImpl();
		return callFacade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Initial createInitial() {
		InitialImpl initial = new InitialImpl();
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public End createEnd() {
		EndImpl end = new EndImpl();
		return end;
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
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubFlow createSubFlow() {
		SubFlowImpl subFlow = new SubFlowImpl();
		return subFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generic_BKSPackage getGeneric_BKSPackage() {
		return (Generic_BKSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Generic_BKSPackage getPackage() {
		return Generic_BKSPackage.eINSTANCE;
	}

} //Generic_BKSFactoryImpl
