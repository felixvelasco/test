package com.isb.jVoice.dsl.builder

//import com.vectorsf.jvoice.prompt.model.voiceDsl.Audio
//import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl

import java.io.File
import java.io.FileWriter
import org.eclipse.emf.ecore.resource.Resource
import com.vectorsf.jvoice.model.operations.Flow
import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.FinalState
import com.vectorsf.jvoice.model.operations.InitialState

class SpringWebFlowGenerator {
	
	Resource res
	Flow element

	int position
	
	new(Resource resource) {
		res = resource;
		element = res.contents.get(1) as Flow;
	}
		
	def generate(File file) {
		var fw = new FileWriter(file)
		for (State state : element.getStates()) {
			position =element.getStates().indexOf(state);
			fw.append(doGenerate(state, position));
		}
		
		
		fw.close()
	}
	
	def doGenerate(State state, int position) '''
	«IF state instanceof InitialState »
	«doGenerateHeader()»
	«ELSE»
		«IF position==1 »
			«doGenerateCompleteHeader(state)»
		«ENDIF»
			«doGenerateFinalState(state)»
«««		«doGenerateNoMatch(element.audios.noMatchAudios)»
		«IF state instanceof FinalState »
			«doGenerateFooter(state)»
		«ENDIF»
	«ENDIF»
	
	'''
	
	def doGenerateHeader() '''
	<flow xmlns="http://www.springframework.org/schema/webflow"	
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"	
	xsi:schemaLocation="http://www.springframework.org/schema/webflow        				
	http://www.springframework.org/schema/webflow/spring-webflow-2.0.xsd"
	'''
	
	def doGenerateCompleteHeader(State state) '''
		start-state= "«state.name»" >
	'''
	
	
	def doGenerateFinalState(State state) '''
		<action-state id="«state.name»">
		     <on-entry>
		          <evaluate expression="end" result="flowScope.endState"></evaluate>
		          <set name="flowScope.endState.name" value="«state.name»"></set>                
		     </on-entry>                
		     <evaluate expression="flowProcessor.process(flowScope.endState)"></evaluate>
		     <transition to="end"/>       
		 </action-state>
	'''

	def doGenerateFooter(State state) '''
		
		<end-state id="end"/>
		</flow> 
	'''
	
//	def doGenerateInitial(List<Audio> initial) '''
//		<div class='initial'>
//		<h1>Saludo inicial</h1>
//			«FOR Audio audio: initial»
//				«printAudio(audio)»
//			«ENDFOR»
//		</div>
//		
//	'''
	
//	def doGenerateNoMatch(List<Audio> match) '''
//		<div class='nomatch'>
//		<h1>No match</h1>
//			«FOR Audio audio: match»
//				«printAudio(audio)»
//			«ENDFOR»
//		</div>
//		
//	'''


	
//	def printAudio(Audio audio) '''
//		<p>
//		«IF audio.tts != null »
//			<h2>»audio.tts»</h2>
//		«ENDIF»
//		&nbsp;
//		«IF audio.src != null »
//			<h2><b>«audio.src»</b></h2>
//		«ENDIF»
//		</p>
//	'''
	
	def setResource(Resource resource) {
		res = resource;
	}
	
	def static compile(File target, Resource resource) {
		new SpringWebFlowGenerator(resource).generate(target);
	}
}