package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio
import com.vectorsf.jvoice.model.operations.InputState

class InputStateCodeXML {
	
	def static doGenerateInputState(State state){
			
		var TranSalida =state.getOutgoingTransitions()
		var InputState audioIn = state as InputState
		
		var grammars = audioIn.locution.grammars.grammatics
		var configuration = audioIn.locution.configuration
		
		var mainAudios = audioIn.locution.audios.mainAudios
		var noMatchAudios = audioIn.locution.audios.noMatchAudios
		var noInputAudios = audioIn.locution.audios.noInputAudios
		var matchAudios = audioIn.locution.audios.matchAudios
		
		var i=0
		
'''
		<action-state id="«state.name»">
			<on-entry>
				<evaluate expression="output" result="flowScope.«state.name»"></evaluate>
				<set name="flowScope.setLanguageInput.name" value="'«audioIn.name»'" />
				<set name="flowScope.setLanguageInput.bargein" value="«configuration.getValue("bargein")»" />
				<set name="flowScope.setLanguageInput.maxAttempts" value="«configuration.getValue("maxAttempts")»" />			
				«/*Obtenemos las gramaticas de la locucion  */»
				«IF grammars != null || grammars.size>0» 				
				«FOR grammar : grammars »
				<evaluate expression="grammar" result="flowScope.grammar«i=i+1»" />
				<set name="flowScope.grammar«i».type" value="'«grammar.expr.booleanValue»'"/>
				<set name="flowScope.grammar«i».src" value="'«grammar.src»'"/>
				<set name="flowScope.grammar«i».mode" value="'«grammar.mode»'"/>
				<evaluate expression="flowScope.«state.name».grammars.add(flowScope.grammar«i»)" />
				
				«ENDFOR»
        		«ENDIF»
        «GeneralStateCodeXML.doGenerateGeneralState(state, mainAudios, "mainAudios")»
       	«GeneralStateCodeXML.doGenerateGeneralState(state, noMatchAudios, "noMatchAudios")»
      	«GeneralStateCodeXML.doGenerateGeneralState(state, noInputAudios, "noInputAudios")»
      	«GeneralStateCodeXML.doGenerateGeneralState(state, matchAudios, "matchAudios")»
			</on-entry>
			<evaluate expression="flowProcessor.process(flowScope.«state.name»)"/>
			«IF TranSalida != null && TranSalida.size>0»  
			<transition to="«TranSalida.get(0).target.name»"/>
			«ENDIF»			
		</action-state>
		«/*Falta ver que pasaria con view-state para las vbles catchHangup y flush  */»
'''
	}
}


