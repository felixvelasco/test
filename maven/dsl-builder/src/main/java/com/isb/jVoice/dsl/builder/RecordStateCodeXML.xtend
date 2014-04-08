package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.RecordState
import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl

class RecordStateCodeXML {
	def static doGenerateRecordState(State state, String nameProject){
			
		var tranSalidaS =state.getOutgoingTransitions()
		var RecordState recordIn = state as RecordState
		
		var RecordDsl dsl = recordIn.locution as RecordDsl
		var configuration = recordIn.locution.configuration
		
		var audios = recordIn.locution.audios
		
'''
		<action-state id="«state.name»">
			«IF recordIn.textual»
				<on-entry>
					<evaluate expression="jVoiceArchRecord" result="flashScope.«state.name»" />
					<set name="flashScope.«state.name».fileName" value="'«dsl.fileName»'" />
					«IF configuration != null»
						«FOR configValue : configuration.configValue»
							«IF configValue.name != null && configValue.name.equals("beep")»
								«IF configValue.value != null && !configValue.value.empty»
									<set name="flashScope.«state.name».beep" value="«configValue.value»" />
								«ENDIF»
							«ELSEIF configValue.name != null && configValue.name.equals("dtmfterm")»
								«IF configValue.value != null && !configValue.value.empty»
									<set name="flashScope.«state.name».dtmfterm" value="«configValue.value»" />
								«ENDIF»
							«ELSEIF configValue.name != null && configValue.name.equals("maxtime")»
								«IF configValue.value != null && !configValue.value.empty»
									<set name="flashScope.«state.name».maxtime" value="«configValue.value»" />
								«ENDIF»
							«ELSEIF configValue.name != null && configValue.name.equals("finalsilence")»
								«IF configValue.value != null && !configValue.value.empty»
									<set name="flashScope.«state.name».finalsilence" value="«configValue.value»" />
								«ENDIF»
							«ELSEIF configValue.name != null && configValue.name.equals("keep")»
								«IF configValue.value != null && !configValue.value.empty»
									<set name="flashScope.«state.name».keep" value="«configValue.value»" />
								«ENDIF»
							«ELSEIF configValue.name != null && configValue.name.equals("filepath")»
								«IF configValue.value != null && !configValue.value.empty»
									<set name="flashScope.«state.name».filePath" value="«configValue.value»" />
								«ENDIF»
							«ELSEIF configValue.name != null && !configValue.name.empty»
								«IF configValue.value != null && !configValue.value.empty»
									<evaluate expression="flashScope.«state.name».properties.put('«configValue.name»','«configValue.value»')" />
								«ENDIF»
							«ENDIF»
						«ENDFOR»
					«ENDIF»
					<set name="flowScope.jVoiceArchRecFileName" value="flashScope.«state.name».fileName" />
		        «IF audios != null»
		        «var mainAudios = recordIn.locution.audios.mainAudios»
		        «GeneralStateCodeXML.doGenerateGeneralState(state, mainAudios, "audioItems", nameProject)»
				«ENDIF»
					</on-entry>
					<evaluate expression="flowProcessor.process(flashScope.«state.name»)"/>		
			«ELSE»	
					<evaluate expression="flowProcessor.process(flashScope.«state.name».«recordIn.methodName»())"/>
			«ENDIF»
			<transition to="render_«state.name»"/>
		</action-state>
		
		<view-state id="render_«state.name»" view="#{flowProcessor.getRenderer().getView()}" model="lastRecordResult">
			«IF tranSalidaS != null && tranSalidaS.size>0»
			    «FOR tranSalida : tranSalidaS» 
			    	«IF tranSalida.target instanceof CustomState»
			    		«IF tranSalida.eventName == "ok"»	 			    	 
			    		<transition on="recorded" to="render_«tranSalida.target.name»">
			    			<evaluate expression="recordingService.saveRecording(lastRecordResult.temprecording, flowScope.jVoiceArchRecFileName)"/>
			    		</transition>
			    		«ELSE»
			    		<transition on="«tranSalida.eventName»" to="render_«tranSalida.target.name»"/>
			    		«ENDIF»
			    	«ELSE»
			    		«IF tranSalida.eventName == "ok"»	 			    	 
			    		<transition on="recorded" to="«tranSalida.target.name»">
			    			<evaluate expression="recordingService.saveRecording(lastRecordResult.temprecording, flowScope.jVoiceArchRecFileName)"/>
			    		</transition>
			    		«ELSE»
			    		<transition on="«tranSalida.eventName»" to="«tranSalida.target.name»"/>
			    		«ENDIF»
			    	«ENDIF»
			    «ENDFOR»
			«ENDIF»	
		</view-state>
'''
	}}