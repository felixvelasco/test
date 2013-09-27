/**
 */
package com.vectorsf.jvoice.model.base;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JV Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVModel#getProjects <em>Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVModel()
 * @model
 * @generated
 */
public interface JVModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.base.JVProject}.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.model.base.JVProject#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVModel_Projects()
	 * @see com.vectorsf.jvoice.model.base.JVProject#getModel
	 * @model opposite="model" containment="true" resolveProxies="true"
	 * @generated
	 */
	List<JVProject> getProjects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for (JVProject project: getProjects())\n{\n\tif (project.getName().equals(name)) {\n\t\treturn project;\n\t}\n}\n\nreturn null;'"
	 * @generated
	 */
	JVProject getProject(String name);

} // JVModel
