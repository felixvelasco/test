/**
 */
package com.vectorsf.jvoice.model.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see com.vectorsf.jvoice.model.base.BaseFactory
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
	String eNS_URI = "http://base.jvoice.vectorsf.com/1.0";

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
	BasePackage eINSTANCE = com.vectorsf.jvoice.model.base.impl.BasePackageImpl.init();

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.impl.JVElementImpl <em>JV Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.impl.JVElementImpl
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVElement()
	 * @generated
	 */
	int JV_ELEMENT = 2;

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
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.impl.NamedElementImpl
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

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
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.impl.JVBeanImpl <em>JV Bean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.impl.JVBeanImpl
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVBean()
	 * @generated
	 */
	int JV_BEAN = 1;

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
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.impl.JVModelImpl <em>JV Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.impl.JVModelImpl
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVModel()
	 * @generated
	 */
	int JV_MODEL = 3;

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
	 * The operation id for the '<em>Get Project</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODEL___GET_PROJECT__STRING = 0;

	/**
	 * The number of operations of the '<em>JV Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODEL_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.impl.JVPackageImpl <em>JV Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.impl.JVPackageImpl
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVPackage()
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
	 * The feature id for the '<em><b>Owner Module</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PACKAGE__OWNER_MODULE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JV Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PACKAGE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Bean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PACKAGE___GET_BEAN__STRING = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>JV Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PACKAGE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.impl.JVProjectImpl <em>JV Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.impl.JVProjectImpl
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVProject()
	 * @generated
	 */
	int JV_PROJECT = 5;

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
	 * The feature id for the '<em><b>Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT__MODEL = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT__CONFIGURATION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Handlers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT__HANDLERS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>JV Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Referenced Projects</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT___GET_REFERENCED_PROJECTS = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Configuration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT___GET_CONFIGURATION__STRING = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>JV Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_PROJECT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.impl.StringToStringMapImpl <em>String To String Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.impl.StringToStringMapImpl
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getStringToStringMap()
	 * @generated
	 */
	int STRING_TO_STRING_MAP = 6;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To String Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To String Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STRING_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.impl.ConfigurationImpl
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.impl.JVApplicationImpl <em>JV Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.impl.JVApplicationImpl
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVApplication()
	 * @generated
	 */
	int JV_APPLICATION = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION__ID = JV_PROJECT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION__NAME = JV_PROJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION__DESCRIPTION = JV_PROJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION__MODEL = JV_PROJECT__MODEL;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION__CONFIGURATION = JV_PROJECT__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Handlers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION__HANDLERS = JV_PROJECT__HANDLERS;

	/**
	 * The feature id for the '<em><b>Module</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION__MODULE = JV_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Legacy Logger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION__LEGACY_LOGGER = JV_PROJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JV Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION_FEATURE_COUNT = JV_PROJECT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Referenced Projects</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION___GET_REFERENCED_PROJECTS = JV_PROJECT___GET_REFERENCED_PROJECTS;

	/**
	 * The operation id for the '<em>Get Configuration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION___GET_CONFIGURATION__STRING = JV_PROJECT___GET_CONFIGURATION__STRING;

	/**
	 * The number of operations of the '<em>JV Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_APPLICATION_OPERATION_COUNT = JV_PROJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.impl.JVModuleImpl <em>JV Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.impl.JVModuleImpl
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVModule()
	 * @generated
	 */
	int JV_MODULE = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE__ID = JV_PROJECT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE__NAME = JV_PROJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE__DESCRIPTION = JV_PROJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE__MODEL = JV_PROJECT__MODEL;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE__CONFIGURATION = JV_PROJECT__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Handlers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE__HANDLERS = JV_PROJECT__HANDLERS;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE__PACKAGES = JV_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Components Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE__COMPONENTS_PACKAGE = JV_PROJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JV Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE_FEATURE_COUNT = JV_PROJECT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Referenced Projects</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE___GET_REFERENCED_PROJECTS = JV_PROJECT___GET_REFERENCED_PROJECTS;

	/**
	 * The operation id for the '<em>Get Configuration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE___GET_CONFIGURATION__STRING = JV_PROJECT___GET_CONFIGURATION__STRING;

	/**
	 * The operation id for the '<em>Get Package</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE___GET_PACKAGE__STRING = JV_PROJECT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>JV Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JV_MODULE_OPERATION_COUNT = JV_PROJECT_OPERATION_COUNT + 1;


	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.impl.EventHandlerImpl <em>Event Handler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.impl.EventHandlerImpl
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getEventHandler()
	 * @generated
	 */
	int EVENT_HANDLER = 10;

	/**
	 * The feature id for the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER__EVENT = 0;

	/**
	 * The feature id for the '<em><b>Handler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER__HANDLER = 1;

	/**
	 * The number of structural features of the '<em>Event Handler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Event Handler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_HANDLER_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link com.vectorsf.jvoice.model.base.EventsEnum <em>Events Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.vectorsf.jvoice.model.base.EventsEnum
	 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getEventsEnum()
	 * @generated
	 */
	int EVENTS_ENUM = 11;

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.base.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see com.vectorsf.jvoice.model.base.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.base.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.vectorsf.jvoice.model.base.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.base.NamedElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.vectorsf.jvoice.model.base.NamedElement#getDescription()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Description();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.base.JVBean <em>JV Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Bean</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVBean
	 * @generated
	 */
	EClass getJVBean();

	/**
	 * Returns the meta object for the container reference '{@link com.vectorsf.jvoice.model.base.JVBean#getOwnerPackage <em>Owner Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner Package</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVBean#getOwnerPackage()
	 * @see #getJVBean()
	 * @generated
	 */
	EReference getJVBean_OwnerPackage();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.base.JVElement <em>JV Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Element</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVElement
	 * @generated
	 */
	EClass getJVElement();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.base.JVElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVElement#getId()
	 * @see #getJVElement()
	 * @generated
	 */
	EAttribute getJVElement_Id();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.base.JVModel <em>JV Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Model</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVModel
	 * @generated
	 */
	EClass getJVModel();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.model.base.JVModel#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVModel#getProjects()
	 * @see #getJVModel()
	 * @generated
	 */
	EReference getJVModel_Projects();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.base.JVModel#getProject(java.lang.String) <em>Get Project</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Project</em>' operation.
	 * @see com.vectorsf.jvoice.model.base.JVModel#getProject(java.lang.String)
	 * @generated
	 */
	EOperation getJVModel__GetProject__String();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.base.JVPackage <em>JV Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Package</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVPackage
	 * @generated
	 */
	EClass getJVPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.model.base.JVPackage#getBeans <em>Beans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Beans</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVPackage#getBeans()
	 * @see #getJVPackage()
	 * @generated
	 */
	EReference getJVPackage_Beans();

	/**
	 * Returns the meta object for the container reference '{@link com.vectorsf.jvoice.model.base.JVPackage#getOwnerModule <em>Owner Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner Module</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVPackage#getOwnerModule()
	 * @see #getJVPackage()
	 * @generated
	 */
	EReference getJVPackage_OwnerModule();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.base.JVPackage#getBean(java.lang.String) <em>Get Bean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Bean</em>' operation.
	 * @see com.vectorsf.jvoice.model.base.JVPackage#getBean(java.lang.String)
	 * @generated
	 */
	EOperation getJVPackage__GetBean__String();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.base.JVProject <em>JV Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Project</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVProject
	 * @generated
	 */
	EClass getJVProject();

	/**
	 * Returns the meta object for the container reference '{@link com.vectorsf.jvoice.model.base.JVProject#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Model</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVProject#getModel()
	 * @see #getJVProject()
	 * @generated
	 */
	EReference getJVProject_Model();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.model.base.JVProject#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configuration</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVProject#getConfiguration()
	 * @see #getJVProject()
	 * @generated
	 */
	EReference getJVProject_Configuration();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.model.base.JVProject#getHandlers <em>Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Handlers</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVProject#getHandlers()
	 * @see #getJVProject()
	 * @generated
	 */
	EReference getJVProject_Handlers();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.base.JVProject#getReferencedProjects() <em>Get Referenced Projects</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Referenced Projects</em>' operation.
	 * @see com.vectorsf.jvoice.model.base.JVProject#getReferencedProjects()
	 * @generated
	 */
	EOperation getJVProject__GetReferencedProjects();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.base.JVProject#getConfiguration(java.lang.String) <em>Get Configuration</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Configuration</em>' operation.
	 * @see com.vectorsf.jvoice.model.base.JVProject#getConfiguration(java.lang.String)
	 * @generated
	 */
	EOperation getJVProject__GetConfiguration__String();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To String Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To String Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getStringToStringMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToStringMap()
	 * @generated
	 */
	EAttribute getStringToStringMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToStringMap()
	 * @generated
	 */
	EAttribute getStringToStringMap_Value();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.base.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see com.vectorsf.jvoice.model.base.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the map '{@link com.vectorsf.jvoice.model.base.Configuration#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Parameters</em>'.
	 * @see com.vectorsf.jvoice.model.base.Configuration#getParameters()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Parameters();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.base.JVApplication <em>JV Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Application</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVApplication
	 * @generated
	 */
	EClass getJVApplication();

	/**
	 * Returns the meta object for the reference list '{@link com.vectorsf.jvoice.model.base.JVApplication#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Module</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVApplication#getModule()
	 * @see #getJVApplication()
	 * @generated
	 */
	EReference getJVApplication_Module();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.base.JVApplication#isLegacyLogger <em>Legacy Logger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Legacy Logger</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVApplication#isLegacyLogger()
	 * @see #getJVApplication()
	 * @generated
	 */
	EAttribute getJVApplication_LegacyLogger();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.base.JVModule <em>JV Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JV Module</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVModule
	 * @generated
	 */
	EClass getJVModule();

	/**
	 * Returns the meta object for the containment reference list '{@link com.vectorsf.jvoice.model.base.JVModule#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVModule#getPackages()
	 * @see #getJVModule()
	 * @generated
	 */
	EReference getJVModule_Packages();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.base.JVModule#getComponentsPackage <em>Components Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Components Package</em>'.
	 * @see com.vectorsf.jvoice.model.base.JVModule#getComponentsPackage()
	 * @see #getJVModule()
	 * @generated
	 */
	EAttribute getJVModule_ComponentsPackage();

	/**
	 * Returns the meta object for the '{@link com.vectorsf.jvoice.model.base.JVModule#getPackage(java.lang.String) <em>Get Package</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Package</em>' operation.
	 * @see com.vectorsf.jvoice.model.base.JVModule#getPackage(java.lang.String)
	 * @generated
	 */
	EOperation getJVModule__GetPackage__String();

	/**
	 * Returns the meta object for class '{@link com.vectorsf.jvoice.model.base.EventHandler <em>Event Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Handler</em>'.
	 * @see com.vectorsf.jvoice.model.base.EventHandler
	 * @generated
	 */
	EClass getEventHandler();

	/**
	 * Returns the meta object for the attribute '{@link com.vectorsf.jvoice.model.base.EventHandler#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event</em>'.
	 * @see com.vectorsf.jvoice.model.base.EventHandler#getEvent()
	 * @see #getEventHandler()
	 * @generated
	 */
	EAttribute getEventHandler_Event();

	/**
	 * Returns the meta object for the reference '{@link com.vectorsf.jvoice.model.base.EventHandler#getHandler <em>Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Handler</em>'.
	 * @see com.vectorsf.jvoice.model.base.EventHandler#getHandler()
	 * @see #getEventHandler()
	 * @generated
	 */
	EReference getEventHandler_Handler();

	/**
	 * Returns the meta object for enum '{@link com.vectorsf.jvoice.model.base.EventsEnum <em>Events Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Events Enum</em>'.
	 * @see com.vectorsf.jvoice.model.base.EventsEnum
	 * @generated
	 */
	EEnum getEventsEnum();

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
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.impl.NamedElementImpl
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.impl.JVBeanImpl <em>JV Bean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.impl.JVBeanImpl
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVBean()
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

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.impl.JVElementImpl <em>JV Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.impl.JVElementImpl
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVElement()
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
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.impl.JVModelImpl <em>JV Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.impl.JVModelImpl
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVModel()
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
		 * The meta object literal for the '<em><b>Get Project</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JV_MODEL___GET_PROJECT__STRING = eINSTANCE.getJVModel__GetProject__String();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.impl.JVPackageImpl <em>JV Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.impl.JVPackageImpl
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVPackage()
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
		 * The meta object literal for the '<em><b>Owner Module</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_PACKAGE__OWNER_MODULE = eINSTANCE.getJVPackage_OwnerModule();

		/**
		 * The meta object literal for the '<em><b>Get Bean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JV_PACKAGE___GET_BEAN__STRING = eINSTANCE.getJVPackage__GetBean__String();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.impl.JVProjectImpl <em>JV Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.impl.JVProjectImpl
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVProject()
		 * @generated
		 */
		EClass JV_PROJECT = eINSTANCE.getJVProject();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_PROJECT__MODEL = eINSTANCE.getJVProject_Model();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_PROJECT__CONFIGURATION = eINSTANCE.getJVProject_Configuration();

		/**
		 * The meta object literal for the '<em><b>Handlers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_PROJECT__HANDLERS = eINSTANCE.getJVProject_Handlers();

		/**
		 * The meta object literal for the '<em><b>Get Referenced Projects</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JV_PROJECT___GET_REFERENCED_PROJECTS = eINSTANCE.getJVProject__GetReferencedProjects();

		/**
		 * The meta object literal for the '<em><b>Get Configuration</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JV_PROJECT___GET_CONFIGURATION__STRING = eINSTANCE.getJVProject__GetConfiguration__String();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.impl.StringToStringMapImpl <em>String To String Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.impl.StringToStringMapImpl
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getStringToStringMap()
		 * @generated
		 */
		EClass STRING_TO_STRING_MAP = eINSTANCE.getStringToStringMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_STRING_MAP__KEY = eINSTANCE.getStringToStringMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_STRING_MAP__VALUE = eINSTANCE.getStringToStringMap_Value();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.impl.ConfigurationImpl
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__PARAMETERS = eINSTANCE.getConfiguration_Parameters();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.impl.JVApplicationImpl <em>JV Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.impl.JVApplicationImpl
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVApplication()
		 * @generated
		 */
		EClass JV_APPLICATION = eINSTANCE.getJVApplication();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_APPLICATION__MODULE = eINSTANCE.getJVApplication_Module();

		/**
		 * The meta object literal for the '<em><b>Legacy Logger</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JV_APPLICATION__LEGACY_LOGGER = eINSTANCE.getJVApplication_LegacyLogger();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.impl.JVModuleImpl <em>JV Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.impl.JVModuleImpl
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getJVModule()
		 * @generated
		 */
		EClass JV_MODULE = eINSTANCE.getJVModule();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JV_MODULE__PACKAGES = eINSTANCE.getJVModule_Packages();

		/**
		 * The meta object literal for the '<em><b>Components Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JV_MODULE__COMPONENTS_PACKAGE = eINSTANCE.getJVModule_ComponentsPackage();

		/**
		 * The meta object literal for the '<em><b>Get Package</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JV_MODULE___GET_PACKAGE__STRING = eINSTANCE.getJVModule__GetPackage__String();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.impl.EventHandlerImpl <em>Event Handler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.impl.EventHandlerImpl
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getEventHandler()
		 * @generated
		 */
		EClass EVENT_HANDLER = eINSTANCE.getEventHandler();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_HANDLER__EVENT = eINSTANCE.getEventHandler_Event();

		/**
		 * The meta object literal for the '<em><b>Handler</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_HANDLER__HANDLER = eINSTANCE.getEventHandler_Handler();

		/**
		 * The meta object literal for the '{@link com.vectorsf.jvoice.model.base.EventsEnum <em>Events Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.vectorsf.jvoice.model.base.EventsEnum
		 * @see com.vectorsf.jvoice.model.base.impl.BasePackageImpl#getEventsEnum()
		 * @generated
		 */
		EEnum EVENTS_ENUM = eINSTANCE.getEventsEnum();

	}

} //BasePackage
