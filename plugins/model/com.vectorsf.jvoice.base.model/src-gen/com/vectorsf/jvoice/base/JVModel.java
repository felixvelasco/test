/**
 */
package com.vectorsf.jvoice.base;

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
 *   <li>{@link com.vectorsf.jvoice.base.JVModel#getProjects <em>Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.base.BasePackage#getJVModel()
 * @model
 * @generated
 */
public interface JVModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.base.JVProject}.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.base.JVProject#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see com.vectorsf.jvoice.base.BasePackage#getJVModel_Projects()
	 * @see com.vectorsf.jvoice.base.JVProject#getModel
	 * @model opposite="model" containment="true"
	 * @generated
	 */
	List<JVProject> getProjects();

} // JVModel
