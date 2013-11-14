/**
 */
package com.vectorsf.jvoice.model.base;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.vectorsf.jvoice.model.base.BasePackage
 * @generated
 */
public interface BaseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BaseFactory eINSTANCE = com.vectorsf.jvoice.model.base.impl.BaseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Element</em>'.
	 * @generated
	 */
	NamedElement createNamedElement();

	/**
	 * Returns a new object of class '<em>JV Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JV Element</em>'.
	 * @generated
	 */
	JVElement createJVElement();

	/**
	 * Returns a new object of class '<em>JV Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JV Model</em>'.
	 * @generated
	 */
	JVModel createJVModel();

	/**
	 * Returns a new object of class '<em>JV Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JV Package</em>'.
	 * @generated
	 */
	JVPackage createJVPackage();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns a new object of class '<em>JV Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JV Application</em>'.
	 * @generated
	 */
	JVApplication createJVApplication();

	/**
	 * Returns a new object of class '<em>JV Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JV Module</em>'.
	 * @generated
	 */
	JVModule createJVModule();

	/**
	 * Returns a new object of class '<em>Event Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Handler</em>'.
	 * @generated
	 */
	EventHandler createEventHandler();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BasePackage getBasePackage();

} //BaseFactory
