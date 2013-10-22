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
						«IF condition.simpleA.tts!=null»
							«IF condition.simpleA.interpretation.name.equals("STRING")» 
								<set name="flowScope.«state.name»«type»«i».wording.text" value="«condition.simpleA.tts»"/>
							«ELSEIF condition.simpleA.interpretation.name !=null»
								<evaluate expression="sayAs" result="flowScope.«state.name»«type»«i».wording.sayAs" />
								<set name="flowScope.«state.name»«type»«i».wording.sayAs.interpretAs" value="«condition.simpleA.tts».«condition.simpleA.interpretation.name»"/>
								«IF condition.simpleA.format!=null»
									<set name="flowScope.«state.name»«type»«i».wording.sayAs.formatAs" value="«condition.simpleA.format»"/>
								«ENDIF»
							«ENDIF»
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
						«IF audio.tts!=null»
							«IF audio.interpretation.name.equals("STRING")» 
								<set name="flowScope.«state.name»«type»«i».wording.text" value="«audio.tts»"/>
							«ELSEIF audio.interpretation.name !=null»
								<evaluate expression="sayAs" result="flowScope.«state.name»«type»«i».wording.sayAs" />
								<set name="flowScope.«state.name»«type»«i».wording.sayAs.interpretAs" value="«audio.tts».«audio.interpretation.name»"/>
								«IF audio.format!=null»
									<set name="flowScope.«state.name»«type»«i».wording.sayAs.formatAs" value="«audio.format»"/>
								«ENDIF»					
							«ENDIF»	
						«ENDIF»		   
					«ENDIF»
					<evaluate expression="flowScope.«state.name».«type».add(flowScope.«state.name»«type»«i»)"/>
					
				«ENDFOR»			 
'''
	}
}


