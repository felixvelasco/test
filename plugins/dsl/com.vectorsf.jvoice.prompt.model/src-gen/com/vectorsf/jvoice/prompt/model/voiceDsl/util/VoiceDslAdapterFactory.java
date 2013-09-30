/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl.util;

import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVElement;
import com.vectorsf.jvoice.model.base.NamedElement;

import com.vectorsf.jvoice.prompt.model.voiceDsl.Audio;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Audios;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Condition;
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio;
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConfigValue;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Configuration;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Field;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Function;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Grammars;
import com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Member;
import com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Output;
import com.vectorsf.jvoice.prompt.model.voiceDsl.OutputValue;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs;
import com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Property;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Type;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Variable;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Variables;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage
 * @generated
 */
public class VoiceDslAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VoiceDslPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoiceDslAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = VoiceDslPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VoiceDslSwitch<Adapter> modelSwitch =
		new VoiceDslSwitch<Adapter>() {
			@Override
			public Adapter caseVoiceDsl(VoiceDsl object) {
				return createVoiceDslAdapter();
			}
			@Override
			public Adapter caseConfiguration(Configuration object) {
				return createConfigurationAdapter();
			}
			@Override
			public Adapter caseConfigValue(ConfigValue object) {
				return createConfigValueAdapter();
			}
			@Override
			public Adapter caseGrammar(Grammar object) {
				return createGrammarAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseCondition(Condition object) {
				return createConditionAdapter();
			}
			@Override
			public Adapter caseAudios(Audios object) {
				return createAudiosAdapter();
			}
			@Override
			public Adapter caseAudio(Audio object) {
				return createAudioAdapter();
			}
			@Override
			public Adapter caseConditionalAudio(ConditionalAudio object) {
				return createConditionalAudioAdapter();
			}
			@Override
			public Adapter caseOutputValue(OutputValue object) {
				return createOutputValueAdapter();
			}
			@Override
			public Adapter caseOutputs(Outputs object) {
				return createOutputsAdapter();
			}
			@Override
			public Adapter caseGrammars(Grammars object) {
				return createGrammarsAdapter();
			}
			@Override
			public Adapter caseOutput(Output object) {
				return createOutputAdapter();
			}
			@Override
			public Adapter caseVariables(Variables object) {
				return createVariablesAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseMember(Member object) {
				return createMemberAdapter();
			}
			@Override
			public Adapter caseClass(com.vectorsf.jvoice.prompt.model.voiceDsl.Class object) {
				return createClassAdapter();
			}
			@Override
			public Adapter caseField(Field object) {
				return createFieldAdapter();
			}
			@Override
			public Adapter caseFunction(Function object) {
				return createFunctionAdapter();
			}
			@Override
			public Adapter caseInputDsl(InputDsl object) {
				return createInputDslAdapter();
			}
			@Override
			public Adapter caseMenuDsl(MenuDsl object) {
				return createMenuDslAdapter();
			}
			@Override
			public Adapter casePromptDsl(PromptDsl object) {
				return createPromptDslAdapter();
			}
			@Override
			public Adapter caseJVElement(JVElement object) {
				return createJVElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseJVBean(JVBean object) {
				return createJVBeanAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl <em>Voice Dsl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl
	 * @generated
	 */
	public Adapter createVoiceDslAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConfigValue <em>Config Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.ConfigValue
	 * @generated
	 */
	public Adapter createConfigValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar <em>Grammar</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Grammar
	 * @generated
	 */
	public Adapter createGrammarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audios <em>Audios</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audios
	 * @generated
	 */
	public Adapter createAudiosAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Audio <em>Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Audio
	 * @generated
	 */
	public Adapter createAudioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio <em>Conditional Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio
	 * @generated
	 */
	public Adapter createConditionalAudioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.OutputValue <em>Output Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.OutputValue
	 * @generated
	 */
	public Adapter createOutputValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs
	 * @generated
	 */
	public Adapter createOutputsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Grammars <em>Grammars</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Grammars
	 * @generated
	 */
	public Adapter createGrammarsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Output
	 * @generated
	 */
	public Adapter createOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Variables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Variables
	 * @generated
	 */
	public Adapter createVariablesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Member <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Member
	 * @generated
	 */
	public Adapter createMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Class
	 * @generated
	 */
	public Adapter createClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Field
	 * @generated
	 */
	public Adapter createFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.Function
	 * @generated
	 */
	public Adapter createFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl <em>Input Dsl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl
	 * @generated
	 */
	public Adapter createInputDslAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl <em>Menu Dsl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl
	 * @generated
	 */
	public Adapter createMenuDslAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl <em>Prompt Dsl</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl
	 * @generated
	 */
	public Adapter createPromptDslAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.base.JVElement <em>JV Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.base.JVElement
	 * @generated
	 */
	public Adapter createJVElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.base.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.base.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.vectorsf.jvoice.model.base.JVBean <em>JV Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.vectorsf.jvoice.model.base.JVBean
	 * @generated
	 */
	public Adapter createJVBeanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //VoiceDslAdapterFactory
