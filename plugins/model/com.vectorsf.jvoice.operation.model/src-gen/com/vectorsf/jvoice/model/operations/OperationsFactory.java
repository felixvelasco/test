/**
 */
package com.vectorsf.jvoice.model.operations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage
 * @generated
 */
public interface OperationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationsFactory eINSTANCE = com.vectorsf.jvoice.model.operations.impl.OperationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
	Transition createTransition();

	/**
	 * Returns a new object of class '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow</em>'.
	 * @generated
	 */
	Flow createFlow();

	/**
	 * Returns a new object of class '<em>Initial State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initial State</em>'.
	 * @generated
	 */
	InitialState createInitialState();

	/**
	 * Returns a new object of class '<em>Final State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Final State</em>'.
	 * @generated
	 */
	FinalState createFinalState();

	/**
	 * Returns a new object of class '<em>Switch State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch State</em>'.
	 * @generated
	 */
	SwitchState createSwitchState();

	/**
	 * Returns a new object of class '<em>Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Case</em>'.
	 * @generated
	 */
	Case createCase();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OperationsPackage getOperationsPackage();

} //OperationsFactory