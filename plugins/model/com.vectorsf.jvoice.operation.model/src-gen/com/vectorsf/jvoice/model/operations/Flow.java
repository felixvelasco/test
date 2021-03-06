/**
 */
package com.vectorsf.jvoice.model.operations;

import com.vectorsf.jvoice.model.base.JVBean;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.operations.Flow#getStates <em>States</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.Flow#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.Flow#getNotes <em>Notes</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.Flow#getBeans <em>Beans</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.Flow#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.operations.Flow#getHelperClass <em>Helper Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getFlow()
 * @model
 * @generated
 */
public interface Flow extends JVBean {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.operations.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getFlow_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.operations.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getFlow_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Notes</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.operations.Note}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notes</em>' containment reference list.
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getFlow_Notes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Note> getNotes();

	/**
	 * Returns the value of the '<em><b>Beans</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.operations.ComponentBean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Beans</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Beans</em>' containment reference list.
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getFlow_Beans()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentBean> getBeans();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' attribute list.
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getFlow_Parameters()
	 * @model
	 * @generated
	 */
	EList<String> getParameters();

	/**
	 * Returns the value of the '<em><b>Helper Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Helper Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helper Class</em>' attribute.
	 * @see #setHelperClass(String)
	 * @see com.vectorsf.jvoice.model.operations.OperationsPackage#getFlow_HelperClass()
	 * @model
	 * @generated
	 */
	String getHelperClass();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.operations.Flow#getHelperClass <em>Helper Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Helper Class</em>' attribute.
	 * @see #getHelperClass()
	 * @generated
	 */
	void setHelperClass(String value);

} // Flow
