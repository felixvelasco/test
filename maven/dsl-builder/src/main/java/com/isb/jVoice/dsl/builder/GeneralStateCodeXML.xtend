package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import java.util.List
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio
import com.vectorsf.jvoice.prompt.model.voiceDsl.Audio

class GeneralStateCodeXML {
	
	def static doGenerateGeneralState(State state, List mainAudios, String type){
		var i=0		
'''
				«FOR mainAudio : mainAudios »	
				<evaluate expression="audioItem" result="flowScope.«state.name»«type»«i=i+1»"/>				
				«IF mainAudio instanceof ConditionalAudio»
					«var ConditionalAudio condition = mainAudio as ConditionalAudio» 
					<set name="flowScope.«state.name»«type»«i».bargein" value="«condition.simpleA.dontBargeIn.booleanValue»"/>
					«IF condition.simpleA.src != null» 
					<set name="flowScope.flowScope.«state.name»«type»«i».src" value="«condition.simpleA.src»"/>
					«ENDIF»
					«IF condition.simpleA.tts != null» 
					<set name="flowScope.«state.name»«type»«i».wording" value="«condition.simpleA.tts»"/>
					«ENDIF»
					«IF condition.condit != null» 
					<set name="flowScope.«state.name»«type»«i».condition" value="«condition.condit»"/>
					«ENDIF»
				«ELSE»
					«var Audio audio = mainAudio as Audio»
					<set name="flowScope.«state.name»«type»«i».bargein" value="«audio.dontBargeIn.booleanValue»"/>
					«IF audio.src != null» 
					<set name="flowScope.flowScope.«state.name»«type»«i».src" value="«audio.src»"/>
					«ENDIF»
					«IF audio.tts != null» 
					<set name="flowScope.«state.name»«type»«i».wording" value="«audio.tts»"/>
					«ENDIF»		   
				«ENDIF»
				<evaluate expression="flowScope.«state.name».«type».add(flowScope.«state.name»«type»«i»)"/>
				
				«ENDFOR»			 
'''
	}
}


