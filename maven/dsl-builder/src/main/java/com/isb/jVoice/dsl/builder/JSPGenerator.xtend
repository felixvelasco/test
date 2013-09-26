package com.isb.jVoice.dsl.builder

import java.io.File
import java.io.FileWriter
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import voiceDsl.Audio
import voiceDsl.InputElement

class JSPGenerator {
	
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
		«if (element.initialAudios != null) doGenerateInitial(element.initialAudios)»
		«doGenerateNoMatch(element.noMatchAudios)»
	«doGenerateFooter()»
	'''
	
	def doGenerateFooter() '''
	</body>
	</html>
	'''
	
	def doGenerateInitial(List<Audio> initial) '''
		<div class='initial'>
		<h1>Saludo inicial</h1>
			«FOR Audio audio: initial»
				«printAudio(audio)»
			«ENDFOR»
		</div>
		
	'''
	
	def doGenerateNoMatch(List<Audio> match) '''
		<div class='nomatch'>
		<h1>No match</h1>
			«FOR Audio audio: match»
				«printAudio(audio)»
			«ENDFOR»
		</div>
		
	'''

	def doGenerateHeader(String name) '''
	<html>
	<head>
		<title>«element.name»</title>
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
		new JSPGenerator(resource).generate(target);
	}
}