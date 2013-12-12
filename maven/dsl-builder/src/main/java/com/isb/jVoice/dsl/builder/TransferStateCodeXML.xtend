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
		var properties = transfer.locution.properties
		

'''
		<action-state id="«transfer.name»">
		<on-entry>
			«IF dsl.typeTransfer.equals("blind")»
				<evaluate expression="jVoiceArchBlindTransfer" result = "flashScope.«transfer.name»"/>
				<set name="flashScope.«transfer.name».dest" value="'«dsl.destination»'"/>
				«IF dsl.audioTransfer!=null && !dsl.audioTransfer.trim.empty»
					<set name="flashScope.«transfer.name».transferaudio" value="'«dsl.audioTransfer»'"/>
				«ENDIF»
			«ELSEIF dsl.typeTransfer.equals("consultation")»
				<evaluate expression="jVoiceArchConsultationTransfer" result = "flashScope.«transfer.name»"/>
				<set name="flashScope.«transfer.name».dest" value="'«dsl.destination»'"/>
				«IF dsl.audioTransfer!=null && !dsl.audioTransfer.trim.empty»
					<set name="flashScope.«transfer.name».transferaudio" value="'«dsl.audioTransfer»'"/>
				«ENDIF»
				<set name="flashScope.«transfer.name».timeout" value="'«dsl.timeout»'"/>
			«ELSEIF dsl.typeTransfer.equals("bridge")»
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
					«IF properties != null && properties.size>0 » 
						«FOR property : properties »
							<evaluate expression="flashScope.«state.name».properties.put('«property.name»','«property.value»')"/>
						«ENDFOR»
	        		«ENDIF» 
        		«ENDIF» 
		</on-entry>
		<evaluate expression="flowProcessor.process(flashScope.«transfer.name»)"/>	
		<transition to="render_«transfer.name»" />
		
		</action-state>
		
		<view-state id="render_«transfer.name»" view="#{flowProcessor.getRenderer().getView()}" model="lastTransferResult">
		
		«IF tranSalidaS != null && tranSalidaS.size>0»
			«IF tranSalidaS.get(0).target instanceof CustomState»
					<transition on="transferred" to="render_«tranSalidaS.get(0).target.name»"/>
				«ELSE»
					<transition on="transferred" to="«tranSalidaS.get(0).target.name»"/>
				«ENDIF»
		«ENDIF»
		
		</view-state>
    	'''
	}
}