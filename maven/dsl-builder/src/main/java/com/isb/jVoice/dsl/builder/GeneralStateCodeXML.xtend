package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import java.util.List
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio
import com.vectorsf.jvoice.prompt.model.voiceDsl.Audio

class GeneralStateCodeXML {
	
	def static doGenerateGeneralState(State state, List mainAudios, String type){
		var i=0		
'''
		«IF (mainAudios!=null && mainAudios.size>0)»
				«FOR mainAudio : mainAudios »	
					<evaluate expression="jVoiceArchAudioItem" result="flashScope.«state.name»«type»«i=i+1»"/>	
							
					«IF mainAudio instanceof ConditionalAudio»
						«var ConditionalAudio condition = mainAudio as ConditionalAudio» 
						<set name="flashScope.«state.name»«type»«i».bargein" value="«condition.simpleA.dontBargeIn.booleanValue»"/>
						«IF condition.simpleA.src != null» 
							<set name="flashScope.«state.name»«type»«i».src" value="'«condition.simpleA.src»'"/>
						«ENDIF»
						«IF condition.simpleA.tts!=null»
							<evaluate expression="jVoiceArchWording" result="flashScope.«state.name»«type»«i».wording"/>	
							«IF condition.simpleA.interpretation.name.equals("STRING")» 
								<set name="flashScope.«state.name»«type»«i».wording.text" value="«condition.simpleA.tts.expandCode»"/>
							«ELSEIF condition.simpleA.interpretation.name !=null»
								<evaluate expression="jVoiceArchSayAs" result="flashScope.«state.name»«type»«i».wording.sayAs" />
								<set name="flashScope.«state.name»«type»«i».wording.sayAs.interpretAs" value="«condition.simpleA.tts».«condition.simpleA.interpretation.name»"/>
								«IF condition.simpleA.format!=null»
									<set name="flashScope.«state.name»«type»«i».wording.sayAs.formatAs" value="'«condition.simpleA.format»'"/>
								«ENDIF»
							«ENDIF»
						«ENDIF»
						«IF condition.condit != null» 
							<set name="flashScope.«state.name»«type»«i».condition" value="«condition.condit»"/>
						«ENDIF»
					«ELSE»
						«var Audio audio = mainAudio as Audio»
						<set name="flashScope.«state.name»«type»«i».bargein" value="«audio.dontBargeIn.booleanValue»"/>
						«IF audio.src != null» 
							<set name="flashScope.«state.name»«type»«i».src" value="'«audio.src»'"/>
						«ENDIF»
						«IF audio.tts!=null»
							<evaluate expression="jVoiceArchWording" result="flashScope.«state.name»«type»«i».wording"/>
							<set name="flashScope.«state.name»«type»«i».wording.text" value="«audio.tts.expandCode»"/>
							«IF !audio.interpretation.name.equals("STRING")» 
								<evaluate expression="jVoiceArchSayAs" result="flashScope.«state.name»«type»«i».wording.sayAs" />
								<set name="flashScope.«state.name»«type»«i».wording.sayAs.interpretAs" value="T(com.vectorsf.jvoiceframework.core.enums.InterpretAs).«audio.interpretation.name»"/>
								«IF audio.format!=null»
									<set name="flashScope.«state.name»«type»«i».wording.sayAs.formatAs" value="'«audio.format»'"/>
								«ENDIF»					
							«ENDIF»	
						«ENDIF»		   
					«ENDIF»
					<evaluate expression="flashScope.«state.name».«type».add(flashScope.«state.name»«type»«i»)"/>
					
				«ENDFOR»	
			«ENDIF»		 
'''
	}
	
	static def expandCode(String string) {
		if (string.indexOf("${") == -1)
			"'" + string + "'"
		else   
			"'" + string.replace("${", "' + ").replace("}", " + '") + "'"
	}
	
}


