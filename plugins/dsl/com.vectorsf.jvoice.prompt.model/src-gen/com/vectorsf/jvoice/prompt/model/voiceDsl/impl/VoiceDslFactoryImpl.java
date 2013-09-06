/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl.impl;

import com.vectorsf.jvoice.prompt.model.voiceDsl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VoiceDslFactoryImpl extends EFactoryImpl implements VoiceDslFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VoiceDslFactory init() {
		try {
			VoiceDslFactory theVoiceDslFactory = (VoiceDslFactory)EPackage.Registry.INSTANCE.getEFactory(VoiceDslPackage.eNS_URI);
			if (theVoiceDslFactory != null) {
				return theVoiceDslFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VoiceDslFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoiceDslFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VoiceDslPackage.VOICE_DSL: return createVoiceDsl();
			case VoiceDslPackage.CONFIGURATION: return createConfiguration();
			case VoiceDslPackage.CONFIG_VALUE: return createConfigValue();
			case VoiceDslPackage.GRAMMAR: return createGrammar();
			case VoiceDslPackage.PROPERTY: return createProperty();
			case VoiceDslPackage.CONDITION: return createCondition();
			case VoiceDslPackage.AUDIOS: return createAudios();
			case VoiceDslPackage.AUDIO: return createAudio();
			case VoiceDslPackage.CONDITIONAL_AUDIO: return createConditionalAudio();
			case VoiceDslPackage.OUTPUT_VALUE: return createOutputValue();
			case VoiceDslPackage.OUTPUTS: return createOutputs();
			case VoiceDslPackage.GRAMMARS: return createGrammars();
			case VoiceDslPackage.OUTPUT: return createOutput();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoiceDsl createVoiceDsl() {
		VoiceDslImpl voiceDsl = new VoiceDslImpl();
		return voiceDsl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigValue createConfigValue() {
		ConfigValueImpl configValue = new ConfigValueImpl();
		return configValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Grammar createGrammar() {
		GrammarImpl grammar = new GrammarImpl();
		return grammar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition createCondition() {
		ConditionImpl condition = new ConditionImpl();
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Audios createAudios() {
		AudiosImpl audios = new AudiosImpl();
		return audios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Audio createAudio() {
		AudioImpl audio = new AudioImpl();
		return audio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalAudio createConditionalAudio() {
		ConditionalAudioImpl conditionalAudio = new ConditionalAudioImpl();
		return conditionalAudio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputValue createOutputValue() {
		OutputValueImpl outputValue = new OutputValueImpl();
		return outputValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Outputs createOutputs() {
		OutputsImpl outputs = new OutputsImpl();
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Grammars createGrammars() {
		GrammarsImpl grammars = new GrammarsImpl();
		return grammars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output createOutput() {
		OutputImpl output = new OutputImpl();
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoiceDslPackage getVoiceDslPackage() {
		return (VoiceDslPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VoiceDslPackage getPackage() {
		return VoiceDslPackage.eINSTANCE;
	}

} //VoiceDslFactoryImpl