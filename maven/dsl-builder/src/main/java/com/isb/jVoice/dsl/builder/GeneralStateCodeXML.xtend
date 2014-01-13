package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.prompt.model.voiceDsl.Audio
import com.vectorsf.jvoice.prompt.model.voiceDsl.ConditionalAudio

import java.util.List

class GeneralStateCodeXML {

	def static doGenerateGeneralState(State state, List<Audio> mainAudios, String type, String projectName) {
		var i = 0
		var ret = new StringBuilder()
		if (mainAudios != null && mainAudios.size > 0) {
			for (mainAudio : mainAudios) {
				
				if (mainAudio instanceof ConditionalAudio) {
					
					var ConditionalAudio condition = mainAudio as ConditionalAudio
					for (audio : condition.simpleAudios) {
						ret.append('''<evaluate expression="jVoiceArchAudioItem" result="flashScope.«state.name»«type»«i = i + 1»"/>''')
						ret.append(writeAudio(audio, state.name + type + i, projectName))
						if (condition.condit != null) {
							ret.append(
								'''<set name="flashScope.«state.name»«type»«i».condition" value="«condition.condit»"/>''')
						}
						ret.append('''<evaluate expression="flashScope.«state.name».«type».add(flashScope.«state.name»«type»«i»)"/>''')
					}
				} else {
					ret.append('''<evaluate expression="jVoiceArchAudioItem" result="flashScope.«state.name»«type»«i = i + 1»"/>''')
					ret.append(writeAudio(mainAudio, state.name + type + i, projectName))
					ret.append('''<evaluate expression="flashScope.«state.name».«type».add(flashScope.«state.name»«type»«i»)"/>''')
				}
				

			}
		}
		ret.toString
	}

	def static writeAudio(Audio audio, String name, String projectName) '''
		««« <set name="flashScope.«name».bargein" value="«audio.dontBargeIn.booleanValue»"/>
		«IF audio.src != null» 
			<set name="flashScope.«name».src" value="locutionProvider.getAudioSrc('«audio.src»','«projectName»')"/>
		«ENDIF»
		«IF audio.tts != null»
			<evaluate expression="jVoiceArchWording" result="flashScope.«name».wording"/>
			<set name="flashScope.«name».wording.text" value="«audio.tts.expandCode»"/>
			«IF !audio.interpretation.name.equals("STRING")» 
				<evaluate expression="jVoiceArchSayAs" result="flashScope.«name».wording.sayAs" />
				<set name="flashScope.«name».wording.sayAs.interpretAs" value="T(com.vectorsf.jvoiceframework.core.enums.InterpretAs).«audio.
			interpretation.name»"/>
				«IF audio.format != null»
					<set name="flashScope.«name».wording.sayAs.formatAs" value="'«audio.format»'"/>
				«ENDIF»					
			«ENDIF»	
		«ENDIF»	
	'''

	static def expandCode(String string) {
		if (string.indexOf("${") == -1)
			"'" + string + "'"
		else
			"'" + string.replace("${", "' + ").replace("}", " + '") + "'"
	}

}
