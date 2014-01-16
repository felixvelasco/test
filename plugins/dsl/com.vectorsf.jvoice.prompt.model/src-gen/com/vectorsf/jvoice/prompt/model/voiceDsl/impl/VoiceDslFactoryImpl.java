/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl.impl;

import com.vectorsf.jvoice.prompt.model.voiceDsl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
			case VoiceDslPackage.CONDITION: return createCondition();
			case VoiceDslPackage.AUDIOS: return createAudios();
			case VoiceDslPackage.AUDIO: return createAudio();
			case VoiceDslPackage.CONDITIONAL_AUDIO: return createConditionalAudio();
			case VoiceDslPackage.OUTPUT_VALUE: return createOutputValue();
			case VoiceDslPackage.OUTPUTS: return createOutputs();
			case VoiceDslPackage.GRAMMARS: return createGrammars();
			case VoiceDslPackage.OUTPUT: return createOutput();
			case VoiceDslPackage.INPUT_DSL: return createInputDsl();
			case VoiceDslPackage.MENU_DSL: return createMenuDsl();
			case VoiceDslPackage.PROMPT_DSL: return createPromptDsl();
			case VoiceDslPackage.RECORD_DSL: return createRecordDsl();
			case VoiceDslPackage.TRANSFER_DSL: return createTransferDsl();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case VoiceDslPackage.INTERPRETATION:
				return createInterpretationFromString(eDataType, initialValue);
			case VoiceDslPackage.TYPE_TRANSFER:
				return createTypeTransferFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case VoiceDslPackage.INTERPRETATION:
				return convertInterpretationToString(eDataType, instanceValue);
			case VoiceDslPackage.TYPE_TRANSFER:
				return convertTypeTransferToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	public InputDsl createInputDsl() {
		InputDslImpl inputDsl = new InputDslImpl();
		return inputDsl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuDsl createMenuDsl() {
		MenuDslImpl menuDsl = new MenuDslImpl();
		return menuDsl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PromptDsl createPromptDsl() {
		PromptDslImpl promptDsl = new PromptDslImpl();
		return promptDsl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordDsl createRecordDsl() {
		RecordDslImpl recordDsl = new RecordDslImpl();
		return recordDsl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransferDsl createTransferDsl() {
		TransferDslImpl transferDsl = new TransferDslImpl();
		return transferDsl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interpretation createInterpretationFromString(EDataType eDataType, String initialValue) {
		Interpretation result = Interpretation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInterpretationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeTransfer createTypeTransferFromString(EDataType eDataType, String initialValue) {
		TypeTransfer result = TypeTransfer.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeTransferToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
