/**
 */
package com.vectorsf.jvoice.base;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JV Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.base.JVProject#getPackages <em>Packages</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.base.JVProject#getModel <em>Model</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.base.JVProject#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.base.BasePackage#getJVProject()
 * @model
 * @generated
 */
public interface JVProject extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.base.JVPackage}.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.base.JVPackage#getOwnerProject <em>Owner Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see com.vectorsf.jvoice.base.BasePackage#getJVProject_Packages()
	 * @see com.vectorsf.jvoice.base.JVPackage#getOwnerProject
	 * @model opposite="ownerProject" containment="true"
	 * @generated
	 */
	List<JVPackage> getPackages();

	/**
	 * Returns the value of the '<em><b>Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.base.JVModel#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' container reference.
	 * @see #setModel(JVModel)
	 * @see com.vectorsf.jvoice.base.BasePackage#getJVProject_Model()
	 * @see com.vectorsf.jvoice.base.JVModel#getProjects
	 * @model opposite="projects" transient="false"
	 * @generated
	 */
	JVModel getModel();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.base.JVProject#getModel <em>Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' container reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(JVModel value);

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.base.Configuration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference list.
	 * @see com.vectorsf.jvoice.base.BasePackage#getJVProject_Configuration()
	 * @model containment="true"
	 * @generated
	 */
	List<Configuration> getConfiguration();

} // JVProject
