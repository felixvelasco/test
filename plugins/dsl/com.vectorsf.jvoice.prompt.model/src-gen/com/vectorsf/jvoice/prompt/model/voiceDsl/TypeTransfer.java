/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type Transfer</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage#getTypeTransfer()
 * @model
 * @generated
 */
public enum TypeTransfer implements Enumerator {
	/**
	 * The '<em><b>Blind</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLIND_VALUE
	 * @generated
	 * @ordered
	 */
	BLIND(0, "blind", "blind"),

	/**
	 * The '<em><b>Consultation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSULTATION_VALUE
	 * @generated
	 * @ordered
	 */
	CONSULTATION(1, "consultation", "consultation"),

	/**
	 * The '<em><b>Bridge</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRIDGE_VALUE
	 * @generated
	 * @ordered
	 */
	BRIDGE(2, "bridge", "bridge");

	/**
	 * The '<em><b>Blind</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Blind</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLIND
	 * @model name="blind"
	 * @generated
	 * @ordered
	 */
	public static final int BLIND_VALUE = 0;

	/**
	 * The '<em><b>Consultation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Consultation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSULTATION
	 * @model name="consultation"
	 * @generated
	 * @ordered
	 */
	public static final int CONSULTATION_VALUE = 1;

	/**
	 * The '<em><b>Bridge</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bridge</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRIDGE
	 * @model name="bridge"
	 * @generated
	 * @ordered
	 */
	public static final int BRIDGE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Type Transfer</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TypeTransfer[] VALUES_ARRAY =
		new TypeTransfer[] {
			BLIND,
			CONSULTATION,
			BRIDGE,
		};

	/**
	 * A public read-only list of all the '<em><b>Type Transfer</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TypeTransfer> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type Transfer</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypeTransfer get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeTransfer result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Transfer</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypeTransfer getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeTransfer result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Transfer</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypeTransfer get(int value) {
		switch (value) {
			case BLIND_VALUE: return BLIND;
			case CONSULTATION_VALUE: return CONSULTATION;
			case BRIDGE_VALUE: return BRIDGE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TypeTransfer(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TypeTransfer
