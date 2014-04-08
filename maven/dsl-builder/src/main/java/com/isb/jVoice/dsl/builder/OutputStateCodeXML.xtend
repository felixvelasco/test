package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.model.operations.PromptState

class OutputStateCodeXML {
	
	def static doGenerateOutputState(PromptState state, String nameProject){
			
		var tranSalida =state.getOutgoingTransitions()
		var audio = state.locution.audios
		var configuration = state.locution.configuration

'''
		<action-state id="«state.name»">
			«IF state.textual»
				<on-entry>
					<evaluate expression="jVoiceArchOutput" result="flashScope.«state.name»"></evaluate>
					«IF configuration != null» 
						«FOR configValue : configuration.configValue»
							«IF configValue.name != null && configValue.name.equals("bargein")»
								«IF configValue.value != null && !configValue.value.empty»
									<set name="flashScope.«state.name».bargein" value="«configValue.value»" />
								«ENDIF»
							«ELSEIF configValue.name != null && configValue.name.equals("flush")»
								«IF configValue.value != null && !configValue.value.empty»
									<set name="flashScope.«state.name».flush" value="«configValue.value»" />
								«ENDIF»
							«ELSEIF configValue.name != null && configValue.name.equals("catchHangup")»
								«IF configValue.value != null && !configValue.value.empty»
									<set name="flashScope.«state.name».catchHangup" value="«configValue.value»" />
								«ENDIF»
							«ELSEIF configValue.name != null && !configValue.name.empty»
								«IF configValue.value != null && !configValue.value.empty»
									<evaluate expression="flashScope.«state.name».properties.put('«configValue.name»','«configValue.value»')" />
								«ENDIF»
							«ENDIF»
						«ENDFOR»
	        		«ENDIF»
					«IF audio != null» 
						«var audios = state.locution.audios.mainAudios»
						«GeneralStateCodeXML.doGenerateGeneralState(state, audios,"audioItems", nameProject)» 
	        		«ENDIF»     
				</on-entry>
				<evaluate expression="flowProcessor.process(flashScope.«state.name»)"/>
			«ELSE»
				<evaluate expression="flowProcessor.process(flashScope.«state.name».«state.methodName»())"/>
			«ENDIF»	
			«IF tranSalida != null && tranSalida.size>0»
				«IF tranSalida.get(0).target instanceof CustomState»
					<transition to="render_«tranSalida.get(0).target.name»"/>
				«ELSE»
					<transition to="«tranSalida.get(0).target.name»"/>
				«ENDIF»
			«ENDIF» 		
		</action-state>
		«/*Falta ver que pasaria con view-state para las vbles catchHangup y flush  */»
'''
	}
}


