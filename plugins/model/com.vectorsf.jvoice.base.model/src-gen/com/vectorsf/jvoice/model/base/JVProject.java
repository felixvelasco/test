/**
 */
package com.vectorsf.jvoice.model.base;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JV Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVProject#getModel <em>Model</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVProject#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVProject#getHandlers <em>Handlers</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVProject()
 * @model abstract="true"
 * @generated
 */
public interface JVProject extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.model.base.JVModel#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' container reference.
	 * @see #setModel(JVModel)
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVProject_Model()
	 * @see com.vectorsf.jvoice.model.base.JVModel#getProjects
	 * @model opposite="projects" transient="false"
	 * @generated
	 */
	JVModel getModel();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.base.JVProject#getModel <em>Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' container reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(JVModel value);

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.base.Configuration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference list.
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVProject_Configuration()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	List<Configuration> getConfiguration();

	/**
	 * Returns the value of the '<em><b>Handlers</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.base.EventHandler}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handlers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handlers</em>' containment reference list.
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVProject_Handlers()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	List<EventHandler> getHandlers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return <%com.vectorsf.jvoice.base.model.service.BaseModel%>.getInstance().getVisibleProjects(this);'"
	 * @generated
	 */
	List<JVProject> getReferencedProjects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for (Configuration conf: getConfiguration()) {\r\n\tif (conf.getName().equals(name)) {\r\n\t\treturn conf;\r\n\t}\r\n}\r\n\t\t\r\nreturn null;'"
	 * @generated
	 */
	Configuration getConfiguration(String name);

} // JVProject
