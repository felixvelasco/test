/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl.impl;

import com.vectorsf.jvoice.model.base.impl.JVBeanImpl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Audios;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Condition;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Configuration;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Grammars;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Property;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Type;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Variables;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Voice Dsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl#getConditions <em>Conditions</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl#getAudios <em>Audios</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl#getGrammars <em>Grammars</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link com.vectorsf.jvoice.prompt.model.voiceDsl.impl.VoiceDslImpl#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VoiceDslImpl extends JVBeanImpl implements VoiceDsl {
	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected Configuration configuration;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * The cached value of the '{@link #getConditions() <em>Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<Condition> conditions;

	/**
	 * The cached value of the '{@link #getAudios() <em>Audios</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAudios()
	 * @generated
	 * @ordered
	 */
	protected Audios audios;

	/**
	 * The cached value of the '{@link #getGrammars() <em>Grammars</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrammars()
	 * @generated
	 * @ordered
	 */
	protected Grammars grammars;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected Variables variables;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> types;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected Outputs outputs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VoiceDslImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VoiceDslPackage.Literals.VOICE_DSL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(Configuration newConfiguration, NotificationChain msgs) {
		Configuration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.VOICE_DSL__CONFIGURATION, oldConfiguration, newConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(Configuration newConfiguration) {
		if (newConfiguration != configuration) {
			NotificationChain msgs = null;
			if (configuration != null)
				msgs = ((InternalEObject)configuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.VOICE_DSL__CONFIGURATION, null, msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.VOICE_DSL__CONFIGURATION, null, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.VOICE_DSL__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this, VoiceDslPackage.VOICE_DSL__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Condition> getConditions() {
		if (conditions == null) {
			conditions = new EObjectContainmentEList<Condition>(Condition.class, this, VoiceDslPackage.VOICE_DSL__CONDITIONS);
		}
		return conditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Audios getAudios() {
		return audios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAudios(Audios newAudios, NotificationChain msgs) {
		Audios oldAudios = audios;
		audios = newAudios;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.VOICE_DSL__AUDIOS, oldAudios, newAudios);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAudios(Audios newAudios) {
		if (newAudios != audios) {
			NotificationChain msgs = null;
			if (audios != null)
				msgs = ((InternalEObject)audios).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.VOICE_DSL__AUDIOS, null, msgs);
			if (newAudios != null)
				msgs = ((InternalEObject)newAudios).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.VOICE_DSL__AUDIOS, null, msgs);
			msgs = basicSetAudios(newAudios, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.VOICE_DSL__AUDIOS, newAudios, newAudios));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Grammars getGrammars() {
		return grammars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGrammars(Grammars newGrammars, NotificationChain msgs) {
		Grammars oldGrammars = grammars;
		grammars = newGrammars;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.VOICE_DSL__GRAMMARS, oldGrammars, newGrammars);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrammars(Grammars newGrammars) {
		if (newGrammars != grammars) {
			NotificationChain msgs = null;
			if (grammars != null)
				msgs = ((InternalEObject)grammars).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.VOICE_DSL__GRAMMARS, null, msgs);
			if (newGrammars != null)
				msgs = ((InternalEObject)newGrammars).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.VOICE_DSL__GRAMMARS, null, msgs);
			msgs = basicSetGrammars(newGrammars, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.VOICE_DSL__GRAMMARS, newGrammars, newGrammars));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Outputs getOutputs() {
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputs(Outputs newOutputs, NotificationChain msgs) {
		Outputs oldOutputs = outputs;
		outputs = newOutputs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.VOICE_DSL__OUTPUTS, oldOutputs, newOutputs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputs(Outputs newOutputs) {
		if (newOutputs != outputs) {
			NotificationChain msgs = null;
			if (outputs != null)
				msgs = ((InternalEObject)outputs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.VOICE_DSL__OUTPUTS, null, msgs);
			if (newOutputs != null)
				msgs = ((InternalEObject)newOutputs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.VOICE_DSL__OUTPUTS, null, msgs);
			msgs = basicSetOutputs(newOutputs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.VOICE_DSL__OUTPUTS, newOutputs, newOutputs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variables getVariables() {
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariables(Variables newVariables, NotificationChain msgs) {
		Variables oldVariables = variables;
		variables = newVariables;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VoiceDslPackage.VOICE_DSL__VARIABLES, oldVariables, newVariables);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariables(Variables newVariables) {
		if (newVariables != variables) {
			NotificationChain msgs = null;
			if (variables != null)
				msgs = ((InternalEObject)variables).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.VOICE_DSL__VARIABLES, null, msgs);
			if (newVariables != null)
				msgs = ((InternalEObject)newVariables).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VoiceDslPackage.VOICE_DSL__VARIABLES, null, msgs);
			msgs = basicSetVariables(newVariables, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VoiceDslPackage.VOICE_DSL__VARIABLES, newVariables, newVariables));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList<Type>(Type.class, this, VoiceDslPackage.VOICE_DSL__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VoiceDslPackage.VOICE_DSL__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
			case VoiceDslPackage.VOICE_DSL__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case VoiceDslPackage.VOICE_DSL__CONDITIONS:
				return ((InternalEList<?>)getConditions()).basicRemove(otherEnd, msgs);
			case VoiceDslPackage.VOICE_DSL__AUDIOS:
				return basicSetAudios(null, msgs);
			case VoiceDslPackage.VOICE_DSL__GRAMMARS:
				return basicSetGrammars(null, msgs);
			case VoiceDslPackage.VOICE_DSL__VARIABLES:
				return basicSetVariables(null, msgs);
			case VoiceDslPackage.VOICE_DSL__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case VoiceDslPackage.VOICE_DSL__OUTPUTS:
				return basicSetOutputs(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VoiceDslPackage.VOICE_DSL__CONFIGURATION:
				return getConfiguration();
			case VoiceDslPackage.VOICE_DSL__PROPERTIES:
				return getProperties();
			case VoiceDslPackage.VOICE_DSL__CONDITIONS:
				return getConditions();
			case VoiceDslPackage.VOICE_DSL__AUDIOS:
				return getAudios();
			case VoiceDslPackage.VOICE_DSL__GRAMMARS:
				return getGrammars();
			case VoiceDslPackage.VOICE_DSL__VARIABLES:
				return getVariables();
			case VoiceDslPackage.VOICE_DSL__TYPES:
				return getTypes();
			case VoiceDslPackage.VOICE_DSL__OUTPUTS:
				return getOutputs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VoiceDslPackage.VOICE_DSL__CONFIGURATION:
				setConfiguration((Configuration)newValue);
				return;
			case VoiceDslPackage.VOICE_DSL__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case VoiceDslPackage.VOICE_DSL__CONDITIONS:
				getConditions().clear();
				getConditions().addAll((Collection<? extends Condition>)newValue);
				return;
			case VoiceDslPackage.VOICE_DSL__AUDIOS:
				setAudios((Audios)newValue);
				return;
			case VoiceDslPackage.VOICE_DSL__GRAMMARS:
				setGrammars((Grammars)newValue);
				return;
			case VoiceDslPackage.VOICE_DSL__VARIABLES:
				setVariables((Variables)newValue);
				return;
			case VoiceDslPackage.VOICE_DSL__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends Type>)newValue);
				return;
			case VoiceDslPackage.VOICE_DSL__OUTPUTS:
				setOutputs((Outputs)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VoiceDslPackage.VOICE_DSL__CONFIGURATION:
				setConfiguration((Configuration)null);
				return;
			case VoiceDslPackage.VOICE_DSL__PROPERTIES:
				getProperties().clear();
				return;
			case VoiceDslPackage.VOICE_DSL__CONDITIONS:
				getConditions().clear();
				return;
			case VoiceDslPackage.VOICE_DSL__AUDIOS:
				setAudios((Audios)null);
				return;
			case VoiceDslPackage.VOICE_DSL__GRAMMARS:
				setGrammars((Grammars)null);
				return;
			case VoiceDslPackage.VOICE_DSL__VARIABLES:
				setVariables((Variables)null);
				return;
			case VoiceDslPackage.VOICE_DSL__TYPES:
				getTypes().clear();
				return;
			case VoiceDslPackage.VOICE_DSL__OUTPUTS:
				setOutputs((Outputs)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VoiceDslPackage.VOICE_DSL__CONFIGURATION:
				return configuration != null;
			case VoiceDslPackage.VOICE_DSL__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case VoiceDslPackage.VOICE_DSL__CONDITIONS:
				return conditions != null && !conditions.isEmpty();
			case VoiceDslPackage.VOICE_DSL__AUDIOS:
				return audios != null;
			case VoiceDslPackage.VOICE_DSL__GRAMMARS:
				return grammars != null;
			case VoiceDslPackage.VOICE_DSL__VARIABLES:
				return variables != null;
			case VoiceDslPackage.VOICE_DSL__TYPES:
				return types != null && !types.isEmpty();
			case VoiceDslPackage.VOICE_DSL__OUTPUTS:
				return outputs != null;
		}
		return super.eIsSet(featureID);
	}

} //VoiceDslImpl
