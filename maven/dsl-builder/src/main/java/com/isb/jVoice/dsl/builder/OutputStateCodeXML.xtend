package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.PromptState
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio

class OutputStateCodeXML {
	
	def static doGenerateOutputState(State state){
			
		var TranSalida =state.getOutgoingTransitions()
		var PromptState audioOut = state as PromptState
		var audios = audioOut.locution.audios.mainAudios
		var properties = audioOut.locution.properties

'''
		<action-state id="«state.name»">
			<on-entry>
				<evaluate expression="output" result="flowScope.«state.name»"></evaluate>
			«/*Falta especificar el bargein del propmp general  */»
				«GeneralStateCodeXML.doGenerateGeneralState(state, audios,"audioItems")»
				«/*Obtenemos las propiedades de la locucion */»
				«IF properties != null && properties.size>0 » 
				«FOR property : properties »
				<evaluate expression="flowScope.«state.name».properties.put('«property.name»','«property.value»')"/>
				«ENDFOR»
        		«ENDIF»      
			</on-entry>
			<evaluate expression="flowProcessor.process(flowScope.«state.name»)"/>
			<transition to="«TranSalida.get(0).target.name»"/>		
		</action-state>
		«/*Falta ver que pasaria con view-state para las vbles catchHangup y flush  */»
'''
	}
}


