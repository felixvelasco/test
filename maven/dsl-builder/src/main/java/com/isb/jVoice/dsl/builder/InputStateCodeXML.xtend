package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.model.operations.InputState
import com.vectorsf.jvoice.model.operations.State

class InputStateCodeXML {
	
	def static doGenerateInputState(State state, String nameProject){
			
		var tranSalidaS =state.getOutgoingTransitions()
		var InputState audioIn = state as InputState
		
		var grammars = audioIn.locution.grammars
		var configuration = audioIn.locution.configuration
		
		var audios = audioIn.locution.audios
		
		var i=0
		
'''
		<action-state id="«state.name»">
			<on-entry>
				<evaluate expression="jVoiceArchInput" result="flashScope.«state.name»"></evaluate>
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
				«/*Obtenemos las gramaticas de la locucion  */»
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
			<transition to="render_«state.name»"/>
		</action-state>
		
		<view-state id="render_«state.name»" view="#{flowProcessor.getRenderer().getView()}" model="lastInputResult">
			«IF tranSalidaS != null && tranSalidaS.size>0»
			    «FOR tranSalida : tranSalidaS» 
			    	«IF tranSalida.target instanceof CustomState» 
			    		<transition on="match" to="render_«tranSalida.target.name»"/>
			    	«ELSE»
			    		<transition on="match" to="«tranSalida.target.name»"/>
			    	«ENDIF»
			    «ENDFOR»
			«ENDIF»	
		</view-state>
'''
	}
}


