/**
 */
package com.vectorsf.jvoice.model.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Events Handler</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.vectorsf.jvoice.model.base.BasePackage#getEventsHandler()
 * @model
 * @generated
 */
public enum EventsHandler implements Enumerator {
	/**
	 * The '<em><b>Busy</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUSY_VALUE
	 * @generated
	 * @ordered
	 */
	BUSY(0, "busy", "busy"),

	/**
	 * The '<em><b>Connectionerror</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONNECTIONERROR_VALUE
	 * @generated
	 * @ordered
	 */
	CONNECTIONERROR(1, "connectionerror", "connectionerror"),

	/**
	 * The '<em><b>Error</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR_VALUE
	 * @generated
	 * @ordered
	 */
	ERROR(2, "error", "error"),

	/**
	 * The '<em><b>Far end disconnect</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAR_END_DISCONNECT_VALUE
	 * @generated
	 * @ordered
	 */
	FAR_END_DISCONNECT(3, "far_end_disconnect", "far_end_disconnect"),

	/**
	 * The '<em><b>Hangup</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HANGUP_VALUE
	 * @generated
	 * @ordered
	 */
	HANGUP(4, "hangup", "hangup"),

	/**
	 * The '<em><b>Maxtime disconnect</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAXTIME_DISCONNECT_VALUE
	 * @generated
	 * @ordered
	 */
	MAXTIME_DISCONNECT(5, "maxtime_disconnect", "maxtime_disconnect"),

	/**
	 * The '<em><b>Max Attempts</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAX_ATTEMPTS_VALUE
	 * @generated
	 * @ordered
	 */
	MAX_ATTEMPTS(6, "maxAttempts", "maxAttempts"),

	/**
	 * The '<em><b>Max No Input</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAX_NO_INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	MAX_NO_INPUT(7, "maxNoInput", "maxNoInput"),

	/**
	 * The '<em><b>Max No Match</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAX_NO_MATCH_VALUE
	 * @generated
	 * @ordered
	 */
	MAX_NO_MATCH(8, "maxNoMatch", "maxNoMatch"),

	/**
	 * The '<em><b>Near end disconnect</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEAR_END_DISCONNECT_VALUE
	 * @generated
	 * @ordered
	 */
	NEAR_END_DISCONNECT(9, "near_end_disconnect", "near_end_disconnect"),

	/**
	 * The '<em><b>Network busy</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORK_BUSY_VALUE
	 * @generated
	 * @ordered
	 */
	NETWORK_BUSY(10, "network_busy", "network_busy"),

	/**
	 * The '<em><b>Network disconnect</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NETWORK_DISCONNECT_VALUE
	 * @generated
	 * @ordered
	 */
	NETWORK_DISCONNECT(11, "network_disconnect", "network_disconnect"),

	/**
	 * The '<em><b>Noanswer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOANSWER_VALUE
	 * @generated
	 * @ordered
	 */
	NOANSWER(12, "noanswer", "noanswer"),

	/**
	 * The '<em><b>Noresource</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORESOURCE_VALUE
	 * @generated
	 * @ordered
	 */
	NORESOURCE(13, "noresource", "noresource"),

	/**
	 * The '<em><b>Recordunsupported</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECORDUNSUPPORTED_VALUE
	 * @generated
	 * @ordered
	 */
	RECORDUNSUPPORTED(14, "recordunsupported", "recordunsupported"),

	/**
	 * The '<em><b>Unknown</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	UNKNOWN(15, "unknown", "unknown");

	/**
	 * The '<em><b>Busy</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Busy</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUSY
	 * @model name="busy"
	 * @generated
	 * @ordered
	 */
	public static final int BUSY_VALUE = 0;

	/**
	 * The '<em><b>Connectionerror</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Connectionerror</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONNECTIONERROR
	 * @model name="connectionerror"
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTIONERROR_VALUE = 1;

	/**
	 * The '<em><b>Error</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Error</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ERROR
	 * @model name="error"
	 * @generated
	 * @ordered
	 */
	public static final int ERROR_VALUE = 2;

	/**
	 * The '<em><b>Far end disconnect</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Far end disconnect</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAR_END_DISCONNECT
	 * @model name="far_end_disconnect"
	 * @generated
	 * @ordered
	 */
	public static final int FAR_END_DISCONNECT_VALUE = 3;

	/**
	 * The '<em><b>Hangup</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hangup</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HANGUP
	 * @model name="hangup"
	 * @generated
	 * @ordered
	 */
	public static final int HANGUP_VALUE = 4;

	/**
	 * The '<em><b>Maxtime disconnect</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Maxtime disconnect</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAXTIME_DISCONNECT
	 * @model name="maxtime_disconnect"
	 * @generated
	 * @ordered
	 */
	public static final int MAXTIME_DISCONNECT_VALUE = 5;

	/**
	 * The '<em><b>Max Attempts</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Max Attempts</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAX_ATTEMPTS
	 * @model name="maxAttempts"
	 * @generated
	 * @ordered
	 */
	public static final int MAX_ATTEMPTS_VALUE = 6;

	/**
	 * The '<em><b>Max No Input</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Max No Input</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAX_NO_INPUT
	 * @model name="maxNoInput"
	 * @generated
	 * @ordered
	 */
	public static final int MAX_NO_INPUT_VALUE = 7;

	/**
	 * The '<em><b>Max No Match</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Max No Match</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAX_NO_MATCH
	 * @model name="maxNoMatch"
	 * @generated
	 * @ordered
	 */
	public static final int MAX_NO_MATCH_VALUE = 8;

	/**
	 * The '<em><b>Near end disconnect</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Near end disconnect</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEAR_END_DISCONNECT
	 * @model name="near_end_disconnect"
	 * @generated
	 * @ordered
	 */
	public static final int NEAR_END_DISCONNECT_VALUE = 9;

	/**
	 * The '<em><b>Network busy</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Network busy</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NETWORK_BUSY
	 * @model name="network_busy"
	 * @generated
	 * @ordered
	 */
	public static final int NETWORK_BUSY_VALUE = 10;

	/**
	 * The '<em><b>Network disconnect</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Network disconnect</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NETWORK_DISCONNECT
	 * @model name="network_disconnect"
	 * @generated
	 * @ordered
	 */
	public static final int NETWORK_DISCONNECT_VALUE = 11;

	/**
	 * The '<em><b>Noanswer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Noanswer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOANSWER
	 * @model name="noanswer"
	 * @generated
	 * @ordered
	 */
	public static final int NOANSWER_VALUE = 12;

	/**
	 * The '<em><b>Noresource</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Noresource</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NORESOURCE
	 * @model name="noresource"
	 * @generated
	 * @ordered
	 */
	public static final int NORESOURCE_VALUE = 13;

	/**
	 * The '<em><b>Recordunsupported</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Recordunsupported</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECORDUNSUPPORTED
	 * @model name="recordunsupported"
	 * @generated
	 * @ordered
	 */
	public static final int RECORDUNSUPPORTED_VALUE = 14;

	/**
	 * The '<em><b>Unknown</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN
	 * @model name="unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN_VALUE = 15;

	/**
	 * An array of all the '<em><b>Events Handler</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EventsHandler[] VALUES_ARRAY =
		new EventsHandler[] {
			BUSY,
			CONNECTIONERROR,
			ERROR,
			FAR_END_DISCONNECT,
			HANGUP,
			MAXTIME_DISCONNECT,
			MAX_ATTEMPTS,
			MAX_NO_INPUT,
			MAX_NO_MATCH,
			NEAR_END_DISCONNECT,
			NETWORK_BUSY,
			NETWORK_DISCONNECT,
			NOANSWER,
			NORESOURCE,
			RECORDUNSUPPORTED,
			UNKNOWN,
		};

	/**
	 * A public read-only list of all the '<em><b>Events Handler</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EventsHandler> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Events Handler</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventsHandler get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventsHandler result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Events Handler</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventsHandler getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventsHandler result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Events Handler</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventsHandler get(int value) {
		switch (value) {
			case BUSY_VALUE: return BUSY;
			case CONNECTIONERROR_VALUE: return CONNECTIONERROR;
			case ERROR_VALUE: return ERROR;
			case FAR_END_DISCONNECT_VALUE: return FAR_END_DISCONNECT;
			case HANGUP_VALUE: return HANGUP;
			case MAXTIME_DISCONNECT_VALUE: return MAXTIME_DISCONNECT;
			case MAX_ATTEMPTS_VALUE: return MAX_ATTEMPTS;
			case MAX_NO_INPUT_VALUE: return MAX_NO_INPUT;
			case MAX_NO_MATCH_VALUE: return MAX_NO_MATCH;
			case NEAR_END_DISCONNECT_VALUE: return NEAR_END_DISCONNECT;
			case NETWORK_BUSY_VALUE: return NETWORK_BUSY;
			case NETWORK_DISCONNECT_VALUE: return NETWORK_DISCONNECT;
			case NOANSWER_VALUE: return NOANSWER;
			case NORESOURCE_VALUE: return NORESOURCE;
			case RECORDUNSUPPORTED_VALUE: return RECORDUNSUPPORTED;
			case UNKNOWN_VALUE: return UNKNOWN;
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
	private EventsHandler(int value, String name, String literal) {
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
	
} //EventsHandler
