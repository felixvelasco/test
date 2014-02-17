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
	Flow flow

	new(Resource resource) {
		res = resource;
		flow = res.contents.get(1) as Flow;
	}

	def generate(File file, String nameProject) {
		using(new FileWriter(file)) [
			//Obtenemos el estado inicial para escribri la cabecera.
			it.append(doGenerateHeader(nameProject))
			it.append(generateScope())
			it.append(generateInitialization())
			// Se recorre de nuevo todo el array para escribir el resto de estados del diagrama 
			for (State state : flow.getStates()) {
				it.append(generateState(state, nameProject))
			}
			it.append(doGenerateFooter());
		]
	}
	
	def doGenerateHeader(String projectName) '''
		<flow xmlns="http://www.springframework.org/schema/webflow"	
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"	
		xsi:schemaLocation="http://www.springframework.org/schema/webflow
		http://www.springframework.org/schema/webflow/spring-webflow-2.0.xsd"
		parent="«projectName»/errorHandler"
		start-state= "_jVoiceCheckInit" >
		«FOR param: flow.parameters»
		<input name="«param»"/>
		«ENDFOR»

	'''
	
	def generateScope() {
		var beans = flow.beans
		var hasPrototypes = false
		if (beans.empty)
			return "";
			
		for(bean: beans){
			if (bean.prototype){
			hasPrototypes=true
			}
		}
		
		'''		
		«IF (hasPrototypes)»
			<on-start>
		«ENDIF»
		«FOR bean: beans »
		  «IF (bean.prototype)»
		     <evaluate expression="«bean.nameBean»" result="flowScope.«bean.name»"></evaluate>
		  «ENDIF»
		«ENDFOR»
		
		«IF (hasPrototypes)»
			</on-start>
		«ENDIF»

     '''

	}
	
	def generateInitialization() '''
		
		<action-state id="_jVoiceCheckInit">
			<evaluate expression="jVoiceArchData.initialized" />
				<transition on="no" to="_jVoiceInit"/>
				<transition to="«GetNameTransOut.Name(initialState)»"/>
			</action-state>
		
		<view-state id="_jVoiceInit" view="#{flowProcessor.getRenderer().getInitView()}" model="jVoiceArchData">
			<transition to="«GetNameTransOut.Name(initialState)»" >
				<set name="jVoiceArchData.initialized" value="true"/>
			</transition>
		</view-state>
	'''
	
	def getInitialState() {
		for (State state : flow.getStates()) {
			if (state instanceof InitialState) {
				return state as InitialState;
			}
		}
	}

	def dispatch generateState(FinalState state, String nameProject) {
		FinalStateCodeXML.doGenerateFinalState(state)
	}

	def dispatch generateState(InitialState state, String nameProject) '''
	'''

	def dispatch generateState(CallFlowState state, String nameProject) {
		new CallFlowStateCodeXML().doGenerateCallFlowState(state)
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
		new CallStateCodeXML().doGenerateCallState(state)
	}

	def dispatch generateState(MenuState state, String nameProject) {
		MenuStateCodeXML.doGenerateMenuState(state, nameProject)
	}

	def dispatch generateState(CustomState state, String nameProject) {
		CustomStateCodeXML.doGenerateCustomState(state)
	}

	def dispatch generateState(TransferState state, String nameProject) {
		TransferStateCodeXML.doGenerateTransferState(state, nameProject)
	}

	def dispatch generateState(RecordState state, String nameProject) {
		RecordStateCodeXML.doGenerateRecordState(state, nameProject)
	}

	def doGenerateFooter() '''
		</flow> 
	'''

	def setResource(Resource resource) {
		res = resource;
	}

	def static compile(File target, Resource resource, String nameProject) {
		new SpringWebFlowGenerator(resource).generate(target, nameProject);
	}
}
