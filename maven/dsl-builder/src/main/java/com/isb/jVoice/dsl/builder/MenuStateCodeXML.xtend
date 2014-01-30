package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.MenuState
import com.vectorsf.jvoice.model.operations.CustomState
import org.eclipse.emf.common.util.EList
import com.vectorsf.jvoice.prompt.model.voiceDsl.Output
import java.util.List

class MenuStateCodeXML {
	
	def static doGenerateMenuState(State state, String nameProject){
			
		var tranSalidaS =state.getOutgoingTransitions()
		var MenuState audioIn = state as MenuState
		
		var grammars = audioIn.locution.grammars
		var configuration = audioIn.locution.configuration
		
		var audios = audioIn.locution.audios

		var outputs = audioIn.locution.outputs
		var outputsList = audioIn.locution.outputs.output
		
		var i=0
		
		
'''
		<action-state id="«state.name»">
			<on-entry>
				<evaluate expression="jVoiceArchInput" result="flashScope.«state.name»"/>
				<set name="flashScope.«state.name».name" value="'«audioIn.name»'" />
				«IF configuration != null»
					«FOR configValue : configuration.configValue»
						«IF configValue.name != null && configValue.name.equals("bargein")»
							«IF configValue.value != null && !configValue.value.empty»
								<set name="flashScope.«state.name».bargein" value="«configValue.value»" />
							«ENDIF»
						«ELSEIF configValue.name != null && configValue.name.equals("maxAttempts")»
							«IF configValue.value != null && !configValue.value.empty»
								<set name="flashScope.«state.name».maxAttempts" value="«configValue.value»" />
							«ENDIF»
						«ELSEIF configValue.name != null && configValue.name.equals("timeout")»
							«IF configValue.value != null && !configValue.value.empty»
								<set name="flashScope.«state.name».timeout" value="«configValue.value»" />
							«ENDIF»
						«ELSEIF configValue.name != null && configValue.name.equals("interdigittimeout")»
							«IF configValue.value != null && !configValue.value.empty»
								<set name="flashScope.«state.name».interdigittimeout" value="«configValue.value»" />
							«ENDIF»
						«ELSEIF configValue.name != null && configValue.name.equals("confidence")»
							«IF configValue.value != null && !configValue.value.empty»
								<set name="flashScope.«state.name».confidence" value="«configValue.value»" />
							«ENDIF»
						«ELSEIF configValue.name != null && configValue.name.equals("maxNoInput")»
							«IF configValue.value != null && !configValue.value.empty»
								<set name="flashScope.«state.name».maxNoInput" value="«configValue.value»" />
							«ENDIF»
						«ELSEIF configValue.name != null && configValue.name.equals("maxNoMatch")»
							«IF configValue.value != null && !configValue.value.empty»
								<set name="flashScope.«state.name».maxNoMatch" value="«configValue.value»" />
							«ENDIF»
						«ELSEIF configValue.name != null && configValue.name.equals("recordutterance")»
							«IF configValue.value != null && !configValue.value.empty»
								<set name="flashScope.«state.name».recordutterance" value="«configValue.value»" />
							«ENDIF»
						«ELSEIF configValue.name != null && !configValue.name.empty»
							«IF configValue.value != null && !configValue.value.empty»
								<evaluate name="flashScope.«state.name».properties.put('«configValue.name»','«configValue.value»')" />
							«ENDIF»
						«ENDIF»
					«ENDFOR»
				«ENDIF»		
				«/*Obtenemos las gramaticas del menu */»
				«IF grammars != null»
					«var grammatics = audioIn.locution.grammars.grammatics»
					«IF grammatics != null && grammatics.size>0» 				
						«FOR grammatic : grammatics »
							<evaluate expression="jVoiceArchGrammar" result="flashScope.grammar«i=i+1»" />
							<set name="flashScope.grammar«i».src" value="'«grammatic.src»'"/>
							<set name="flashScope.grammar«i».mode" value="'«grammatic.mode»'"/>
							<set name="flashScope.grammar«i».module" value="'«nameProject»'"/>
							<evaluate expression="flashScope.«state.name».grammars.add(flashScope.grammar«i»)" />
						«ENDFOR»
	        		«ENDIF»
        		«ENDIF»
        		«IF audios != null» 
        			«var mainAudios = audioIn.locution.audios.mainAudios»
	        		«var noMatchAudios = audioIn.locution.audios.noMatchAudios»
	        		«var noInputAudios = audioIn.locution.audios.noInputAudios»
	        		«var matchAudios = audioIn.locution.audios.matchAudios»
			        «GeneralStateCodeXML.doGenerateGeneralState(state, mainAudios, "mainAudios", nameProject)»
			       	«GeneralStateCodeXML.doGenerateGeneralState(state, noMatchAudios, "noMatchAudios", nameProject)»
			      	«GeneralStateCodeXML.doGenerateGeneralState(state, noInputAudios, "noInputAudios", nameProject)»
			      	«GeneralStateCodeXML.doGenerateGeneralState(state, matchAudios, "matchAudios", nameProject)»
		      	«ENDIF»
			</on-entry>
			<evaluate expression="flowProcessor.process(flashScope.«state.name»)"/>
			<transition to="render_«state.name»"></transition>
		</action-state>
		
		<view-state id="render_«state.name»" view="#{flowProcessor.getRenderer().getView()}" model="lastInputResult">
			<transition on="match" to="render_decision_«state.name»"/>
			«IF outputs != null && tranSalidaS != null && tranSalidaS.size>0 && outputsList !=null && outputsList.size>0»
			   	«FOR tranSalida : tranSalidaS»
				   	«IF isEventTransition(tranSalida.eventName, outputsList)»
				   		«IF tranSalida.target instanceof CustomState»
				   			<transition on="«tranSalida.eventName»" to="render_«tranSalida.target.name»"/>
				   		«ELSE»
				   			<transition on="«tranSalida.eventName»" to="«tranSalida.target.name»"/>
						«ENDIF»			   	
				   	«ENDIF»
			   	«ENDFOR»
			«ENDIF»			
		</view-state>
			
		<action-state id="render_decision_«state.name»">
			<evaluate expression="lastInputResult.interpretation"></evaluate>
			«IF outputs != null && tranSalidaS != null && outputsList !=null && outputsList.size>0 && tranSalidaS.size>0»
			   		«FOR out : outputsList»
			   			«FOR tranSalida : tranSalidaS»
			   				«IF out.name.equals(tranSalida.eventName)»	
			   					«FOR outputValue : out.outputValue»
			   						«IF tranSalida.target instanceof CustomState» 
			   							<transition on="«outputValue.value»" to="render_«tranSalida.target.name»"/>
			   						«ELSE»
			   							<transition on="«outputValue.value»" to="«tranSalida.target.name»"/>
			   						«ENDIF»
			   					«ENDFOR»
			   				«ENDIF»
			   			«ENDFOR»
			   		«ENDFOR»
			«ENDIF»
		</action-state>
'''
	}
	
	def static isEventTransition(String transition, List<Output> list) {
		for (Output output: list) {
			if (output.name.equals(transition)) {
				return false;
			}
		}
		true;
	}
	
}


