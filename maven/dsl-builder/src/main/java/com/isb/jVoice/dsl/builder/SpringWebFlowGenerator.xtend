package com.isb.jVoice.dsl.builder

//import com.vectorsf.jvoice.prompt.model.voiceDsl.Audio
//import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl

import java.io.File
import java.io.FileWriter
import org.eclipse.emf.ecore.resource.Resource
import com.vectorsf.jvoice.model.operations.Flow
import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.FinalState
import com.vectorsf.jvoice.model.operations.CallFlowState
import com.vectorsf.jvoice.model.operations.CallState
import com.vectorsf.jvoice.model.operations.PromptState
import com.vectorsf.jvoice.model.operations.SwitchState
import com.vectorsf.jvoice.model.operations.InputState
import com.vectorsf.jvoice.model.operations.MenuState

class SpringWebFlowGenerator {
	
	Resource res
	Flow element

	int positionIni;
	int positionFin;
	
	new(Resource resource) {
		res = resource;
		element = res.contents.get(1) as Flow;
	}
		
	def generate(File file) {
		var fw = new FileWriter(file)
		for (State state : element.getStates()) {
			positionIni =element.getStates().indexOf(state);
			positionFin =element.getStates().length-1;
			fw.append(doGenerate(state, positionIni,positionFin));
		}
		
		
		fw.close()
	}
	
	def doGenerate(State state, int position, int positionFin) '''
	«IF position==0 »
	«doGenerateHeader(state)»
	«ELSE»		
		«doGenerateCallFlowState(state)»
		«doGenerateCallState(state)»
		«doGenerateOutputState(state)»		
		«doGenerateSwitchState(state)»
		«doGenerateInputState(state)»
		«doGenerateMenuState(state)»
		«doGenerateFinalState(state)»
		«IF positionIni==positionFin»
			«doGenerateFooter(state)»
		«ENDIF»
	«ENDIF»
	
	'''
	
	def doGenerateHeader(State state) '''
	<flow xmlns="http://www.springframework.org/schema/webflow"	
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"	
	xsi:schemaLocation="http://www.springframework.org/schema/webflow        				
	http://www.springframework.org/schema/webflow/spring-webflow-2.0.xsd"
	start-state= "«NombreTranSalida.Nombre(state)»" >
	'''
	
	def doGenerateFinalState(State state) '''
		«IF state instanceof FinalState »
			«FinalStateCodeXML.doGenerateFinalState(state)»
		«ENDIF»	
	'''

	def doGenerateCallFlowState(State state) '''
		«IF state instanceof CallFlowState »
			«CallFlowStateCodeXML.doGenerateCallFlowState(state)»
		«ENDIF»		
	'''
	
	def doGenerateSwitchState(State state) '''
		«IF state instanceof SwitchState »
			«SwitchStateCodeXML.doGenerateSwitchState(state)»
		«ENDIF»	
	'''
	
	def doGenerateOutputState(State state) '''
		«IF state instanceof PromptState »
			«OutputStateCodeXML.doGenerateOutputState(state)»
		«ENDIF»		
	'''
	
	def doGenerateInputState(State state) '''
		«IF state instanceof InputState »
			«InputStateCodeXML.doGenerateInputState(state)»
		«ENDIF»		
	'''
	
	def doGenerateCallState(State state) '''
		«IF state instanceof CallState »
			«CallStateCodeXML.doGenerateCallState(state)»
		«ENDIF»	
	'''
	
	def doGenerateMenuState(State state) '''
		«IF state instanceof MenuState »
			«MenuStateCodeXML.doGenerateMenuState(state)»
		«ENDIF»	
	'''

	def doGenerateFooter(State state) '''
		<end-state id="end-call"/>
		</flow> 
	'''
	
	def setResource(Resource resource) {
		res = resource;
	}
	
	def static compile(File target, Resource resource) {
		new SpringWebFlowGenerator(resource).generate(target);
	}
}