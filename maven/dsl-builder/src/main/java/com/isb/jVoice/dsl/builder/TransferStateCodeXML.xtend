package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.TransferState
import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl

class TransferStateCodeXML {
	// Falta por definir
	
	def static doGenerateTransferState(State state, String nameProject){
		var tranSalidaS =state.getOutgoingTransitions()
		var TransferState transfer = state as TransferState
		
		var TransferDsl dsl = transfer.locution as TransferDsl
		
		var audio = transfer.locution.audios
		var configurations = transfer.locution.configuration
		

'''
		<action-state id="«transfer.name»">
		<on-entry>
			«IF dsl.typeTransfer.value == 0»
				<evaluate expression="jVoiceArchBlindTransfer" result = "flashScope.«transfer.name»"/>
				<set name="flashScope.«transfer.name».dest" value="'«dsl.destination»'"/>
				«IF dsl.audioTransfer!=null && !dsl.audioTransfer.trim.empty»
					<set name="flashScope.«transfer.name».transferaudio" value="'«dsl.audioTransfer»'"/>
				«ENDIF»
			«ELSEIF dsl.typeTransfer.value == 1»
				<evaluate expression="jVoiceArchConsultationTransfer" result = "flashScope.«transfer.name»"/>
				<set name="flashScope.«transfer.name».dest" value="'«dsl.destination»'"/>
				«IF dsl.audioTransfer!=null && !dsl.audioTransfer.trim.empty»
					<set name="flashScope.«transfer.name».transferaudio" value="'«dsl.audioTransfer»'"/>
				«ENDIF»
				<set name="flashScope.«transfer.name».timeout" value="'«dsl.timeout»'"/>
			«ELSEIF dsl.typeTransfer.value == 2»
				<evaluate expression="jVoiceArchBridgeTransfer" result = "flashScope.«transfer.name»"/>
				<set name="flashScope.«transfer.name».dest" value="'«dsl.destination»'"/>
				«IF dsl.audioTransfer!=null && !dsl.audioTransfer.trim.empty»
					<set name="flashScope.«transfer.name».transferaudio" value="'«dsl.audioTransfer»'"/>
				«ENDIF»
				<set name="flashScope.«transfer.name».timeout" value="'«dsl.timeout»'"/>
				<set name="flashScope.«transfer.name».maxtime" value="'«dsl.maxTime»'"/>
			«ENDIF»	
			«IF audio != null» 
					«var audios = transfer.locution.audios.mainAudios»
					«GeneralStateCodeXML.doGenerateGeneralState(state, audios,"audioItems", nameProject)»
					«IF configurations != null» 
						«FOR configValue : configurations.configValue »
							«IF configValue.name != null && !configValue.name.empty»
								«IF configValue.value != null && !configValue.value.empty»
									<evaluate name="flashScope.«state.name».properties.put('«configValue.name»','«configValue.value»')" />
								«ENDIF»
							«ENDIF»
						«ENDFOR»
	        		«ENDIF» 
        		«ENDIF» 
		</on-entry>
		<evaluate expression="flowProcessor.process(flashScope.«transfer.name»)"/>	
		<transition to="render_«transfer.name»" />
		
		</action-state>
		
		<view-state id="render_«transfer.name»" view="#{flowProcessor.getRenderer().getView()}" model="lastTransferResult">
		
		«IF tranSalidaS != null && tranSalidaS.size>0»
			«FOR tranSalida : tranSalidaS» 			
				«IF tranSalida.target instanceof CustomState»
					«IF tranSalida.eventName == "ok"»	 			    	 					
					<transition on="transferred" to="render_«tranSalida.target.name»"/>
					«ELSE»
					<transition on="«tranSalida.eventName»" to="render_«tranSalida.target.name»"/>
					«ENDIF»
				«ELSE»
					«IF tranSalida.eventName == "ok"»	 			    	 					
					<transition on="transferred" to="«tranSalida.target.name»"/>
					«ELSE»
					<transition on="«tranSalida.eventName»" to="«tranSalida.target.name»"/>
					«ENDIF»					
				«ENDIF»
			«ENDFOR»
		«ENDIF»
		
		</view-state>
    	'''
	}
}