package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.model.operations.MenuState
import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.prompt.model.voiceDsl.Output
import java.util.List

class MenuStateCodeXML {
	
	def static doGenerateMenuState(State state, String nameProject){
			
		var tranSalidaS =state.getOutgoingTransitions()
		var MenuState menu = state as MenuState
		
		var grammars = menu.locution.grammars
		var configuration = menu.locution.configuration
		
		var audios = menu.locution.audios

		var outputs = menu.locution.outputs
		var outputsList = menu.locution.outputs.output
		
		var i=0
		
		var String prefix = '''jVoiceArch''' + state.name
		
		
'''
		<action-state id="«state.name»">
		«IF menu.textual»
			<on-entry>
				<evaluate expression="jVoiceArchMenu" result="flashScope.«state.name»"/>
				<set name="flashScope.«state.name».name" value="'«menu.name»'" />
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
								<evaluate expression="flashScope.«state.name».properties.put('«configValue.name»','«configValue.value»')" />
							«ENDIF»
						«ENDIF»
					«ENDFOR»
				«ENDIF»		
				«/*Obtenemos las gramaticas del menu */»
				«IF grammars != null»
					«var grammatics = menu.locution.grammars.grammatics»
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
        		«IF outputs != null && tranSalidaS != null && outputsList !=null && outputsList.size>0 && tranSalidaS.size>0»
				   		«FOR out : outputsList»
				   			«FOR tranSalida : tranSalidaS»
				   				«IF out.name.equals(tranSalida.eventName)»	
				   					«FOR outputValue : out.outputValue»
				   						<evaluate expression="flashScope.«state.name».addValueOption(«tranSalida.target.name»,«outputValue.value»)" />
				   					«ENDFOR»
				   				«ENDIF»
				   			«ENDFOR»
				   		«ENDFOR»
				«ENDIF»
        		«IF audios != null» 
        			«var mainAudios = menu.locution.audios.mainAudios»
	        		«var noMatchAudios = menu.locution.audios.noMatchAudios»
	        		«var noInputAudios = menu.locution.audios.noInputAudios»
	        		«var matchAudios = menu.locution.audios.matchAudios»
			        «GeneralStateCodeXML.doGenerateGeneralState(state, mainAudios, "mainAudios", nameProject)»
			       	«GeneralStateCodeXML.doGenerateGeneralState(state, noMatchAudios, "noMatchAudios", nameProject)»
			      	«GeneralStateCodeXML.doGenerateGeneralState(state, noInputAudios, "noInputAudios", nameProject)»
			      	«GeneralStateCodeXML.doGenerateGeneralState(state, matchAudios, "matchAudios", nameProject)»
		      	«ENDIF»
			</on-entry>
			<evaluate expression="flowProcessor.process(flashScope.«state.name»)"/>
		«ELSE»	
			<on-entry>
				<evaluate expression="jVoiceArchMenu" result="flowScope.«state.name»"/>
			</on-entry>
			<evaluate expression="flowProcessor.process(flowScope.«state.name».«menu.methodName»())"/>
		«ENDIF»
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
			
		«IF menu.textual»
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
		«ELSE»	
			<action-state id="render_decision_«state.name»">
				<evaluate expression="lastInputResult.interpretation"></evaluate>
				«IF menu.options != null && menu.options.size>0 »
			   			«FOR option : menu.options»	
			   			    «FOR tranSalida : tranSalidaS»
		   						«IF tranSalida.target.name.equals(option)»
		   							«IF tranSalida.target instanceof CustomState»
		   								<transition on="flowScope.«state.name».getValueOption(«option»)" to="render_«tranSalida.target.name»"/>
			   						«ELSE»
			   							<transition on="flowScope.«state.name».getValueOption(«option»)" to="«tranSalida.target.name»"/>
			   						«ENDIF»
		   						«ENDIF»
	   						«ENDFOR»
			   			«ENDFOR»
				«ENDIF»
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


