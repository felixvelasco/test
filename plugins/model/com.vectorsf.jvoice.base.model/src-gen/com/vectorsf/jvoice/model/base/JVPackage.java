/**
 */
package com.vectorsf.jvoice.model.base;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JV Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVPackage#getBeans <em>Beans</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVPackage#getOwnerProject <em>Owner Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVPackage()
 * @model
 * @generated
 */
public interface JVPackage extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Beans</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.base.JVBean}.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.model.base.JVBean#getOwnerPackage <em>Owner Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Beans</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Beans</em>' containment reference list.
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVPackage_Beans()
	 * @see com.vectorsf.jvoice.model.base.JVBean#getOwnerPackage
	 * @model opposite="ownerPackage" containment="true" resolveProxies="true"
	 * @generated
	 */
	List<JVBean> getBeans();

	/**
	 * Returns the value of the '<em><b>Owner Project</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.model.base.JVProject#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Project</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Project</em>' container reference.
	 * @see #setOwnerProject(JVProject)
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVPackage_OwnerProject()
	 * @see com.vectorsf.jvoice.model.base.JVProject#getPackages
	 * @model opposite="packages" transient="false"
	 * @generated
	 */
	JVProject getOwnerProject();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.base.JVPackage#getOwnerProject <em>Owner Project</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Project</em>' container reference.
	 * @see #getOwnerProject()
	 * @generated
	 */
	void setOwnerProject(JVProject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for (JVBean bean: getBeans()) {\r\n\tif (bean.getName().equals(name)) {\r\n\t\treturn bean;\r\n\t}\r\n}\r\n\t\t\r\nreturn null;'"
	 * @generated
	 */
	JVBean getBean(String name);

} // JVPackage
