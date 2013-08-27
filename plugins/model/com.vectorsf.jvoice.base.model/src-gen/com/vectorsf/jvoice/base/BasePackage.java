/**
 */
package com.vectorsf.jvoice.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.vectorsf.jvoice.base.BaseFactory
 * @model kind="package"
 * @generated
 */
public interface BasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "base";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://base.jvoice.vectorsf.com/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "base";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasePackage eINSTANCE = com.vectorsf.jvoice.base.impl.BasePackageImpl.init();

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.base.impl.JVElementImpl <em>JV Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.base.impl.JVElementImpl
	 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getJVElement()
	 * @generated
	 */
	int JV_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_ELEMENT__ID = 0;

	/**
	 * The number of structural features of the '<em>JV Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>JV Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.base.impl.JVModelImpl <em>JV Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.base.impl.JVModelImpl
	 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getJVModel()
	 * @generated
	 */
	int JV_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODEL__PROJECTS = 0;

	/**
	 * The number of structural features of the '<em>JV Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>JV Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.base.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.base.impl.NamedElementImpl
	 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ID = JV_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = JV_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DESCRIPTION = JV_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = JV_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = JV_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.base.impl.JVProjectImpl <em>JV Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.base.impl.JVProjectImpl
	 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getJVProject()
	 * @generated
	 */
	int JV_PROJECT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT__PACKAGES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT__MODEL = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JV Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>JV Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.base.impl.JVPackageImpl <em>JV Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.base.impl.JVPackageImpl
	 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getJVPackage()
	 * @generated
	 */
	int JV_PACKAGE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PACKAGE__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PACKAGE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PACKAGE__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Beans</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PACKAGE__BEANS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PACKAGE__OWNER_PROJECT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JV Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PACKAGE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>JV Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PACKAGE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.base.impl.JVBeanImpl <em>JV Bean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.base.impl.JVBeanImpl
	 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getJVBean()
	 * @generated
	 */
	int JV_BEAN = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_BEAN__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_BEAN__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_BEAN__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Owner Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_BEAN__OWNER_PACKAGE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JV Bean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_BEAN_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JV Bean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_BEAN_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.base.JVElement <em>JV Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Element</em>'.
	 * @see com.vectorsf.jvoice.base.JVElement
	 * @generated
	 */
	EClass getJVElement();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.base.JVElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.vectorsf.jvoice.base.JVElement#getId()
	 * @see #getJVElement()
	 * @generated
	 */
	EAttribute getJVElement_Id();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.base.JVModel <em>JV Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Model</em>'.
	 * @see com.vectorsf.jvoice.base.JVModel
	 * @generated
	 */
	EClass getJVModel();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.base.JVModel#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see com.vectorsf.jvoice.base.JVModel#getProjects()
	 * @see #getJVModel()
	 * @generated
	 */
	EReference getJVModel_Projects();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.base.JVProject <em>JV Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Project</em>'.
	 * @see com.vectorsf.jvoice.base.JVProject
	 * @generated
	 */
	EClass getJVProject();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.base.JVProject#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see com.vectorsf.jvoice.base.JVProject#getPackages()
	 * @see #getJVProject()
	 * @generated
	 */
	EReference getJVProject_Packages();

	/**
	 * Returns the meta object for the container reference '{@link com.vectorsf.jvoice.base.JVProject#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Model</em>'.
	 * @see com.vectorsf.jvoice.base.JVProject#getModel()
	 * @see #getJVProject()
	 * @generated
	 */
	EReference getJVProject_Model();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.base.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see com.vectorsf.jvoice.base.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.base.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.vectorsf.jvoice.base.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.base.NamedElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.vectorsf.jvoice.base.NamedElement#getDescription()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Description();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.base.JVPackage <em>JV Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Package</em>'.
	 * @see com.vectorsf.jvoice.base.JVPackage
	 * @generated
	 */
	EClass getJVPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.base.JVPackage#getBeans <em>Beans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Beans</em>'.
	 * @see com.vectorsf.jvoice.base.JVPackage#getBeans()
	 * @see #getJVPackage()
	 * @generated
	 */
	EReference getJVPackage_Beans();

	/**
	 * Returns the meta object for the container reference '{@link com.vectorsf.jvoice.base.JVPackage#getOwnerProject <em>Owner Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner Project</em>'.
	 * @see com.vectorsf.jvoice.base.JVPackage#getOwnerProject()
	 * @see #getJVPackage()
	 * @generated
	 */
	EReference getJVPackage_OwnerProject();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.base.JVBean <em>JV Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Bean</em>'.
	 * @see com.vectorsf.jvoice.base.JVBean
	 * @generated
	 */
	EClass getJVBean();

	/**
	 * Returns the meta object for the container reference '{@link com.vectorsf.jvoice.base.JVBean#getOwnerPackage <em>Owner Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner Package</em>'.
	 * @see com.vectorsf.jvoice.base.JVBean#getOwnerPackage()
	 * @see #getJVBean()
	 * @generated
	 */
	EReference getJVBean_OwnerPackage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BaseFactory getBaseFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.base.impl.JVElementImpl <em>JV Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.base.impl.JVElementImpl
		 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getJVElement()
		 * @generated
		 */
		EClass JV_ELEMENT = eINSTANCE.getJVElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JV_ELEMENT__ID = eINSTANCE.getJVElement_Id();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.base.impl.JVModelImpl <em>JV Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.base.impl.JVModelImpl
		 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getJVModel()
		 * @generated
		 */
		EClass JV_MODEL = eINSTANCE.getJVModel();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_MODEL__PROJECTS = eINSTANCE.getJVModel_Projects();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.base.impl.JVProjectImpl <em>JV Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.base.impl.JVProjectImpl
		 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getJVProject()
		 * @generated
		 */
		EClass JV_PROJECT = eINSTANCE.getJVProject();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_PROJECT__PACKAGES = eINSTANCE.getJVProject_Packages();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_PROJECT__MODEL = eINSTANCE.getJVProject_Model();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.base.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.base.impl.NamedElementImpl
		 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__DESCRIPTION = eINSTANCE.getNamedElement_Description();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.base.impl.JVPackageImpl <em>JV Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.base.impl.JVPackageImpl
		 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getJVPackage()
		 * @generated
		 */
		EClass JV_PACKAGE = eINSTANCE.getJVPackage();

		/**
		 * The meta object literal for the '<em><b>Beans</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_PACKAGE__BEANS = eINSTANCE.getJVPackage_Beans();

		/**
		 * The meta object literal for the '<em><b>Owner Project</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_PACKAGE__OWNER_PROJECT = eINSTANCE.getJVPackage_OwnerProject();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.base.impl.JVBeanImpl <em>JV Bean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.base.impl.JVBeanImpl
		 * @see com.vectorsf.jvoice.base.impl.BasePackageImpl#getJVBean()
		 * @generated
		 */
		EClass JV_BEAN = eINSTANCE.getJVBean();

		/**
		 * The meta object literal for the '<em><b>Owner Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_BEAN__OWNER_PACKAGE = eINSTANCE.getJVBean_OwnerPackage();

	}

} //BasePackage
