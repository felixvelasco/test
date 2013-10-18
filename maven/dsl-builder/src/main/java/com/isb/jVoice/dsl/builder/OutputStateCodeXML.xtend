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

		var i=0

'''
		<action-state id="«state.name»">
			<on-entry>
			<evaluate expression="output" result="flowScope.«state.name»"></evaluate>
		«/*Falta especificar el bargein del propmp general  */»
		«FOR audio : audios »
		
				<evaluate expression="audioItem" result="flowScope.«state.name»«i=i+1»"/>
			«IF audio instanceof ConditionalAudio»
				«var ConditionalAudio condition = audio as ConditionalAudio» 
					<set name="flowScope.«state.name».bargein" value="«condition.simpleA.dontBargeIn.booleanValue»"/>
					«IF condition.simpleA.src != null» 
					<set name="flowScope.flowScope.«state.name»«i».src" value="«condition.simpleA.src»"/>
					«ENDIF»
					«IF condition.simpleA.tts != null» 
					<set name="flowScope.«state.name»«i».wording" value="«condition.simpleA.tts»"/>
					«ENDIF»
					«IF condition.condit != null» 
					<set name="flowScope.«state.name»«i».condition" value="«condition.condit»"/>
					«ENDIF»
			«ELSE»
					<set name="flowScope.«state.name».bargein" value="«audio.dontBargeIn.booleanValue»"/>
					«IF audio.src != null» 
					<set name="flowScope.flowScope.«state.name»«i».src" value="«audio.src»"/>
					«ENDIF»
					«IF audio.tts != null» 
					<set name="flowScope.«state.name»«i».wording" value="«audio.tts»"/>
					«ENDIF»		   
			«ENDIF»		  	
				<evaluate expression="flowScope.«state.name».audioItems.add(flowScope.«state.name»«i»)"/>
		«ENDFOR»
		«/*Obtenemos las propiedades de la locucion  */»
		«IF properties != null || properties.size>0 » 
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


