package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.MenuState
import com.vectorsf.jvoice.model.operations.CustomState

class MenuStateCodeXML {
	
	def static doGenerateMenuState(State state, String nameProject){
			
		var tranSalidaS =state.getOutgoingTransitions()
		var MenuState audioIn = state as MenuState
		
		var grammars = audioIn.locution.grammars
		var configuration = audioIn.locution.configuration
		
		var audios = audioIn.locution.audios

		var outputs = audioIn.locution.outputs
		
		var i=0
		
'''
		<action-state id="«state.name»">
			<on-entry>
				<evaluate expression="jVoiceArchInput" result="flashScope.«state.name»"/>
				<set name="flashScope.«state.name».name" value="'«audioIn.name»'" />
				«IF configuration != null»
					«IF configuration.getValue("bargein") != null && !configuration.getValue("bargein").equals("")»
						<set name="flashScope.«state.name».bargein" value="«configuration.getValue("bargein")»" />
					«ENDIF»	
					«IF configuration.getValue("maxAttempts") != null && !configuration.getValue("maxAttempts").equals("")»
					<set name="flashScope.«state.name».maxAttempts" value="«configuration.getValue("maxAttempts")»" />
					«ENDIF»
					«IF configuration.getValue("timeout") != null && !configuration.getValue("timeout").equals("")»
					<set name="flashScope.«state.name».timeout" value="'«configuration.getValue("timeout")»'" />
					«ENDIF»
					«IF configuration.getValue("interdigittimeout") != null && !configuration.getValue("interdigittimeout").equals("")»
					<set name="flashScope.«state.name».interdigittimeout" value="'«configuration.getValue("interdigittimeout")»'" />
					«ENDIF»
					«IF configuration.getValue("confidence") != null && !configuration.getValue("confidence").equals("")»
					<set name="flashScope.«state.name».confidence" value="'«configuration.getValue("confidence")»'" />
					«ENDIF»
					«IF configuration.getValue("maxNoInput") != null »
					<set name="flashScope.«state.name».maxNoInput" value="«configuration.getValue("maxNoInput")»" />
					«ENDIF»
					«IF configuration.getValue("maxNoMatch") != null»
					<set name="flashScope.«state.name».maxNoMatch" value="«configuration.getValue("maxNoMatch")»" />
					«ENDIF»
				«ENDIF»		
				«/*Obtenemos las gramaticas del menu */»
				«IF grammars != null»
					«var grammatics = audioIn.locution.grammars.grammatics»
					«IF grammatics != null && grammatics.size>0» 				
						«FOR grammatic : grammatics »
							<evaluate expression="jVoiceArchGrammar" result="flashScope.grammar«i=i+1»" />
							<set name="flashScope.grammar«i».src" value="'«grammatic.src»'"/>
							<set name="flashScope.grammar«i».mode" value="'«grammatic.mode»'"/>
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
		</view-state>
			
		<action-state id="render_decision_«state.name»">
			<evaluate expression="lastInputResult.interpretation"></evaluate>
			«IF outputs != null» 
				«var output = audioIn.locution.outputs.output» 
				«IF tranSalidaS != null && output !=null && output.size>0 && tranSalidaS.size>0»
				   		«FOR out :output»
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
			«ENDIF»
		</action-state>
'''
	}
}


