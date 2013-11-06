package com.isb.jVoice.dsl.builder

import org.eclipse.emf.common.util.EList
import com.vectorsf.jvoice.model.operations.Transition
import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.TransferState
import com.vectorsf.jvoice.model.operations.CustomState

class TransferStateCodeXML {
	// Falta por definir
	
	def static doGenerateTransferState(State state){
		var TransferState transfer = state as TransferState
		var EList<Transition> tranSalida =state.getOutgoingTransitions()
'''
		<action-state id="«transfer.name»">
		<on-entry>
			«IF transfer.typeTransfer.value == 0»
				<evaluate expression="jVoiceArchBlindTransfer" result = "flashScope.«transfer.name»"/>
				<set name="flowScope.«transfer.name».dest" value="«transfer.destination»"/>
				<set name="flowScope.«transfer.name».transferaudio" value="«transfer.audioTransfer»"/>
				
			«ELSEIF transfer.typeTransfer.value == 1»
				<evaluate expression="jVoiceArchConsultationTransfer" result = "flashScope.«transfer.name»"/>
				<set name="flowScope.«transfer.name».dest" value="«transfer.destination»"/>
				<set name="flowScope.«transfer.name».transferaudio" value="«transfer.audioTransfer»"/>
				<set name="flowScope.«transfer.name».timeout" value="«transfer.timeout»"/>
				
			«ELSEIF transfer.typeTransfer.value == 2»
				<evaluate expression="jVoiceArchBridgeTransfer" result = "flashScope.«transfer.name»"/>
				<set name="flowScope.«transfer.name».dest" value="«transfer.destination»"/>
				<set name="flowScope.«transfer.name».transferaudio" value="«transfer.audioTransfer»"/>
				<set name="flowScope.«transfer.name».timeout" value="«transfer.timeout»"/>
				<set name="flowScope.«transfer.name».maxtime" value="«transfer.maxTime»"/>
			«ENDIF»	
			
			
		</on-entry>
		<evaluate expression="flowProcessor.process(flowScope.«transfer.name»)"/>
		
		<transition to="render_«transfer.name»" />
		
		</action-state>
		
		<view-state id="render_«transfer.name»" view="#{flowProcessor.getRenderer().getView()}" model="lastTransferResult">
		
		«IF tranSalida !=null»
			«FOR trans : tranSalida»
				«IF trans.target instanceof CustomState»
					<transition on="«trans.eventName»" to="render_«trans.target.name»"/>
				«ELSE»
					<transition on="«trans.eventName»" to="«trans.target.name»"/>
				«ENDIF»
			«ENDFOR»
		«ENDIF»
		
		</view-state>
    	'''
	}
}