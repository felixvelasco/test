package com.isb.jVoice.dsl.builder

import com.isb.bks.ivr.voice.dsl.voiceDsl.Audio
import com.isb.bks.ivr.voice.dsl.voiceDsl.Initial
import com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement
import com.isb.bks.ivr.voice.dsl.voiceDsl.NoMatch
import java.io.File
import java.io.FileWriter
import org.eclipse.emf.ecore.resource.Resource

class SpringWebFlowGenerator {
	
	Resource res
	InputElement element
	
	new(Resource resource) {
		res = resource;
		element = res.getEObject("/0") as InputElement;
	}
		
	def generate(File file) {
		var fw = new FileWriter(file)
		var name = file.name.substring(0, file.name.lastIndexOf('.'))
		fw.append(doGenerate(name))
		fw.close()
	}
	
	def doGenerate(String name) '''
	«doGenerateHeader(name)»
		«if (element.audios.initial != null) doGenerateInitial(element.audios.initial)»
		«doGenerateNoMatch(element.audios.noMatch)»
	«doGenerateFooter()»
	'''
	
	def doGenerateFooter() '''
	</body>
	</html>
	'''
	
	def doGenerateInitial(Initial initial) '''
		<div class='initial'>
		<h1>Saludo inicial</h1>
			«FOR Audio audio: initial.audio»
				«printAudio(audio)»
			«ENDFOR»
		</div>
		
	'''
	
	def doGenerateNoMatch(NoMatch match) '''
		<div class='nomatch'>
		<h1>No match</h1>
			«FOR Audio audio: match.audio»
				«printAudio(audio)»
			«ENDFOR»
		</div>
		
	'''

	def doGenerateHeader(String name) '''
	<html>
	<head>
		<title>«element.configuration.name»</title>
	</head>
	<body>
	'''
	
	def printAudio(Audio audio) '''
		<p>
		«IF audio.tts != null »
			<h2>«audio.tts»</h2>
		«ENDIF»
		&nbsp;
		«IF audio.src != null »
			<h2><b>«audio.src»</b></h2>
		«ENDIF»
		</p>
	'''
	
	def setResource(Resource resource) {
		res = resource;
	}
	
	def static compile(File target, Resource resource) {
		new SpringWebFlowGenerator(resource).generate(target);
	}
}