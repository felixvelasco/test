package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CallFlowState
import com.vectorsf.jvoice.model.operations.CallState
import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.model.operations.FinalState
import com.vectorsf.jvoice.model.operations.Flow
import com.vectorsf.jvoice.model.operations.InitialState
import com.vectorsf.jvoice.model.operations.InputState
import com.vectorsf.jvoice.model.operations.MenuState
import com.vectorsf.jvoice.model.operations.PromptState
import com.vectorsf.jvoice.model.operations.RecordState
import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.SwitchState
import com.vectorsf.jvoice.model.operations.TransferState
import java.io.File
import java.io.FileWriter
import org.eclipse.emf.ecore.resource.Resource

import static com.isb.jVoice.dsl.builder.Using.*

class SpringWebFlowGenerator {

	Resource res
	Flow element

	new(Resource resource) {
		res = resource;
		element = res.contents.get(1) as Flow;
	}

	def generate(File file, String nameProject) {
		using(new FileWriter(file)) [
			//Obtenemos el estado inicial para escribri la cabecera.
			it.append(doGenerateHeader())
			
			// Se recorre de nuevo todo el array para escribir el resto de estados del diagrama 
			for (State state : element.getStates()) {
				it.append(generateState(state, nameProject))
			}
			it.append(doGenerateFooter());
		]
	}
	
	def doGenerateHeader() '''
		<flow xmlns="http://www.springframework.org/schema/webflow"	
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"	
		xsi:schemaLocation="http://www.springframework.org/schema/webflow        				
		http://www.springframework.org/schema/webflow/spring-webflow-2.0.xsd"
		start-state= "«GetNameTransOut.Name(initialState)»" >
	'''
	
	def getInitialState() {
		for (State state : element.getStates()) {
			if (state instanceof InitialState) {
				return state;
			}
		}
		//En el caso de que no haya estados iniciales y haya otros estados en el diagrama se coge cualquiera
		if (element.getStates().length > 0) {
			element.getStates().get(0);
		}
	}

	def dispatch generateState(FinalState state, String nameProject) {
		FinalStateCodeXML.doGenerateFinalState(state)
	}

	def dispatch generateState(InitialState state, String nameProject) {
		InitialStateCodeXML.doGenerateInitialState(element, state)
	}

	def dispatch generateState(CallFlowState state, String nameProject) {
		CallFlowStateCodeXML.doGenerateCallFlowState(state)
	}

	def dispatch generateState(SwitchState state, String nameProject) {
		SwitchStateCodeXML.doGenerateSwitchState(state)
	}

	def dispatch generateState(PromptState state, String nameProject) {
		OutputStateCodeXML.doGenerateOutputState(state, nameProject)
	}

	def dispatch generateState(InputState state, String nameProject) {
		InputStateCodeXML.doGenerateInputState(state, nameProject)
	}

	def dispatch generateState(CallState state, String nameProject) {
		CallStateCodeXML.doGenerateCallState(state)
	}

	def dispatch generateState(MenuState state, String nameProject) {
		MenuStateCodeXML.doGenerateMenuState(state, nameProject)
	}

	def dispatch generateState(CustomState state, String nameProject) {
		CustomStateCodeXML.doGenerateCustomState(state)
	}

	def dispatch generateState(TransferState state, String nameProject) {
		TransferStateCodeXML.doGenerateTransferState(state)
	}

	def dispatch generateState(RecordState state, String nameProject) {
		RecordStateCodeXML.doGenerateRecordState(state, nameProject)
	}

	def doGenerateFooter() '''
		<end-state id="end-call" view="#{flowProcessor.getRenderer().getView()}"/>
		</flow> 
	'''

	def setResource(Resource resource) {
		res = resource;
	}

	def static compile(File target, Resource resource, String nameProject) {
		new SpringWebFlowGenerator(resource).generate(target, nameProject);
	}
}
