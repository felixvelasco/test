package com.isb.jVoice.dsl.builder

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
import com.vectorsf.jvoice.model.operations.InitialState
import com.vectorsf.jvoice.model.operations.CustomState

class SpringWebFlowGenerator {
	
	Resource res
	Flow element

	int positionIni;
	
	new(Resource resource) {
		res = resource;
		element = res.contents.get(1) as Flow;
	}
		
	def generate(File file) {
		var initial = false;
		var positionFin =element.getStates().length-1;
		var fw = new FileWriter(file)
		//Obtenemos el estado inicial para escribri la cabecera.
		for (State state : element.getStates()) {
			if (state instanceof InitialState){
				fw.append(doGenerateHeader(state));	
				initial = true;			
			}			
		}
		//En el caso de que no haya estados iniciales y haya otros estados en el diagrama se coge cualquiera
		if (!initial && element.getStates().length>0){
			fw.append(doGenerateHeader(element.getStates().get(0)));	
		}
		// Se recorre de nuevo todo el array para escribir el resto de estados del diagrama 
		for (State state : element.getStates()) {
				positionIni =element.getStates().indexOf(state);				
				fw.append(doGenerate(state, positionIni,positionFin));	
		}

		fw.close()
	}
	
	def doGenerate(State state, int position, int positionFin) '''
		«doGenerateCallFlowState(state)»
		«doGenerateCallState(state)»
		«doGenerateOutputState(state)»		
		«doGenerateSwitchState(state)»
		«doGenerateInputState(state)»
		«doGenerateMenuState(state)»
		«doGenerateFinalState(state)»
		«doGenerateCustomState(state)»
		«doGenerateTransferState(state)»
	«IF positionIni==positionFin»
			«doGenerateFooter()»
	«ENDIF»
	
	'''
	
	def doGenerateHeader(State state) '''
	<flow xmlns="http://www.springframework.org/schema/webflow"	
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"	
	xsi:schemaLocation="http://www.springframework.org/schema/webflow        				
	http://www.springframework.org/schema/webflow/spring-webflow-2.0.xsd"
	start-state= "«GetNameTransOut.Name(state)»" >
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

	def doGenerateCustomState(State state) '''
		«IF state instanceof CustomState»
			«CustomStateCodeXML.doGenerateCustomState(state)»
		«ENDIF»		
	'''
	
		def doGenerateTransferState(State state) '''
		«IF state instanceof CustomState»
			«TransferStateCodeXML.doGenerateTransferState(state)»
		«ENDIF»		
	'''


	def doGenerateFooter() '''
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