/**
 */
package com.vectorsf.jvoice.model.base;

import java.util.List;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JV Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVModule#getPackages <em>Packages</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.model.base.JVModule#getComponentsPackage <em>Components Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVModule()
 * @model
 * @generated
 */
public interface JVModule extends JVProject {

	/**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link com.vectorsf.jvoice.model.base.JVPackage}.
	 * It is bidirectional and its opposite is '{@link com.vectorsf.jvoice.model.base.JVPackage#getOwnerModule <em>Owner Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVModule_Packages()
	 * @see com.vectorsf.jvoice.model.base.JVPackage#getOwnerModule
	 * @model opposite="ownerModule" containment="true" resolveProxies="true" transient="true"
	 * @generated
	 */
	List<JVPackage> getPackages();

	/**
	 * Returns the value of the '<em><b>Components Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components Package</em>' attribute.
	 * @see #setComponentsPackage(String)
	 * @see com.vectorsf.jvoice.model.base.BasePackage#getJVModule_ComponentsPackage()
	 * @model
	 * @generated
	 */
	String getComponentsPackage();

	/**
	 * Sets the value of the '{@link com.vectorsf.jvoice.model.base.JVModule#getComponentsPackage <em>Components Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Components Package</em>' attribute.
	 * @see #getComponentsPackage()
	 * @generated
	 */
	void setComponentsPackage(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for (JVPackage pck: getPackages())\n{\n\tif (pck.getName().equals(name)) {\n\t\treturn pck;\n\t}\n}\n\nreturn null;'"
	 * @generated
	 */
	JVPackage getPackage(String name);
} // JVModule
