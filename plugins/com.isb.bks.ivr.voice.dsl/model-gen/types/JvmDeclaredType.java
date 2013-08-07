/**
 */
package types;

import java.lang.Iterable;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Declared Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#getMembers <em>Members</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#getPackageName <em>Package Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see types.TypesPackage#getJvmDeclaredType()
 * @model abstract="true"
 * @generated
 */
public interface JvmDeclaredType extends EObject, JvmMember, JvmComponentType {
	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Types</em>' containment reference list.
	 * @see types.TypesPackage#getJvmDeclaredType_SuperTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getSuperTypes();

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmMember}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmMember#getDeclaringType <em>Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see types.TypesPackage#getJvmDeclaredType_Members()
	 * @see org.eclipse.xtext.common.types.JvmMember#getDeclaringType
	 * @model opposite="declaringType" containment="true"
	 * @generated
	 */
	EList<JvmMember> getMembers();

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see types.TypesPackage#getJvmDeclaredType_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmDeclaredType#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static</em>' attribute.
	 * @see #setStatic(boolean)
	 * @see types.TypesPackage#getJvmDeclaredType_Static()
	 * @model
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmDeclaredType#isStatic <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see types.TypesPackage#getJvmDeclaredType_Final()
	 * @model
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmDeclaredType#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see types.TypesPackage#getJvmDeclaredType_PackageName()
	 * @model
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmDeclaredType#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="types.Iterable<types.JvmOperation>" required="true"
	 * @generated
	 */
	Iterable<JvmOperation> getDeclaredOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="types.Iterable<types.JvmField>" required="true"
	 * @generated
	 */
	Iterable<JvmField> getDeclaredFields();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns all the fields and operations with the given simple name.</p>
	 * <p>Overridden features will not be returned.</p>
	 * <!-- end-model-doc -->
	 * @model dataType="types.Iterable<types.JvmFeature>" required="true"
	 * @generated
	 */
	Iterable<JvmFeature> findAllFeaturesByName(String simpleName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns all the fields and operations of this type.</p>
	 * <p>Overridden features will not be returned.</p>
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="types.Iterable<types.JvmFeature>" required="true"
	 * @generated
	 */
	Iterable<JvmFeature> getAllFeatures();

} // JvmDeclaredType
