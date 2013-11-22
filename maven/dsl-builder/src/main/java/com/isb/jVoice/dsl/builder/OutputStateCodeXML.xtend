package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.model.operations.PromptState

class OutputStateCodeXML {
	
	def static doGenerateOutputState(PromptState state){
			
		var tranSalida =state.getOutgoingTransitions()
		var audio = state.locution.audios
		var properties = state.locution.properties

'''
		<action-state id="«state.name»">
			<on-entry>
				<evaluate expression="jVoiceArchOutput" result="flashScope.«state.name»"></evaluate>
			«/*Falta especificar el bargein del propmp general  */»
				«IF audio != null» 
					«var audios = state.locution.audios.mainAudios»
					«GeneralStateCodeXML.doGenerateGeneralState(state, audios,"audioItems")»
					«IF properties != null && properties.size>0 » 
						«FOR property : properties »
							<evaluate expression="flashScope.«state.name».properties.put('«property.name»','«property.value»')"/>
						«ENDFOR»
	        		«ENDIF» 
        		«ENDIF»     
			</on-entry>
			<evaluate expression="flowProcessor.process(flashScope.«state.name»)"/>
			«IF tranSalida != null && tranSalida.size>0»
				«IF tranSalida.get(0).target instanceof CustomState»
					<transition to="render_«tranSalida.get(0).target.name»"/>
				«ELSE»
					<transition to="«tranSalida.get(0).target.name»"/>
				«ENDIF»
			«ENDIF» 		
		</action-state>
		«/*Falta ver que pasaria con view-state para las vbles catchHangup y flush  */»
'''
	}
}


