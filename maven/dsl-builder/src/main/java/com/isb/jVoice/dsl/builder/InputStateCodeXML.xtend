package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio
import com.vectorsf.jvoice.model.operations.InputState

class InputStateCodeXML {
	
	def static doGenerateInputState(State state){
			
		var tranSalidaS =state.getOutgoingTransitions()
		var InputState audioIn = state as InputState
		
		var grammars = audioIn.locution.grammars
		var configuration = audioIn.locution.configuration
		
		var audios = audioIn.locution.audios
		
		var i=0
		
'''
		<action-state id="«state.name»">
			<on-entry>
				<evaluate expression="output" result="flowScope.«state.name»"></evaluate>
				<set name="flowScope.«state.name».name" value="'«audioIn.name»'" />
				«IF configuration != null»
					«IF configuration.getValue("bargein") != null && !configuration.getValue("bargein").equals("")»
						<set name="flowScope.«state.name».bargein" value="«configuration.getValue("bargein")»" />
					«ENDIF»	
					«IF configuration.getValue("maxAttempts") != null && !configuration.getValue("maxAttempts").equals("")»
					<set name="flowScope.«state.name».maxAttempts" value="«configuration.getValue("maxAttempts")»" />
					«ENDIF»
				«ENDIF»			
				«/*Obtenemos las gramaticas de la locucion  */»
				«IF grammars != null»
					«var grammatics = audioIn.locution.grammars.grammatics»
					«IF grammatics != null && grammatics.size>0» 				
						«FOR grammatic : grammatics »
							<evaluate expression="grammar" result="flowScope.grammar«i=i+1»" />
							<set name="flowScope.grammar«i».type" value="'«grammatic.expr.booleanValue»'"/>
							<set name="flowScope.grammar«i».src" value="'«grammatic.src»'"/>
							<set name="flowScope.grammar«i».mode" value="'«grammatic.mode»'"/>
							<evaluate expression="flowScope.«state.name».grammars.add(flowScope.grammar«i»)" />
							
						«ENDFOR»
	        		«ENDIF»
        		«ENDIF»
        		«IF audios != null»
	        		«var mainAudios = audioIn.locution.audios.mainAudios»
	        		«var noMatchAudios = audioIn.locution.audios.noMatchAudios»
	        		«var noInputAudios = audioIn.locution.audios.noInputAudios»
	        		«var matchAudios = audioIn.locution.audios.matchAudios»		      	
			        «GeneralStateCodeXML.doGenerateGeneralState(state, mainAudios, "mainAudios")»
			       	«GeneralStateCodeXML.doGenerateGeneralState(state, noMatchAudios, "noMatchAudios")»
			      	«GeneralStateCodeXML.doGenerateGeneralState(state, noInputAudios, "noInputAudios")»
			      	«GeneralStateCodeXML.doGenerateGeneralState(state, matchAudios, "matchAudios")»
		      	«ENDIF»
			</on-entry>
			<evaluate expression="flowProcessor.process(flowScope.«state.name»)"/>			
			<transition to="render_«state.name»"/>
		</action-state>
		
		<view-state id="render_«state.name»" view="#{flowProcessor.getRenderer().getView()}" model="lastInputResult">
			«IF tranSalidaS != null && tranSalidaS.size>0»
			    «FOR tranSalida : tranSalidaS»  
			    	<transition on="match" to="«tranSalida.target.name»"/>
			    «ENDFOR»
			«ENDIF»	
		</view-state>
'''
	}
}


