package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.RecordState
import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl

class RecordStateCodeXML {
	def static doGenerateRecordState(State state){
			
		var tranSalidaS =state.getOutgoingTransitions()
		var RecordState recordIn = state as RecordState
		
		var RecordDsl dsl = recordIn.locution as RecordDsl
		var configuration = recordIn.locution.configuration
		
		var audios = recordIn.locution.audios
		
'''
		<action-state id="«state.name»">
			<on-entry>
				<evaluate expression="jVoiceArchRecord" result="flashScope.«state.name»"></evaluate>
				
				<set name="flashScope.«state.name».fileName" value="'«dsl.fileName»'" />
				«IF configuration != null»
					«IF configuration.getValue("beep") != null && !configuration.getValue("beep").equals("")»
						<set name="flashScope.«state.name».beep" value="«configuration.getValue("beep")»" />
					«ENDIF»	
					«IF configuration.getValue("dtmfterm") != null && !configuration.getValue("dtmfterm").equals("")»
					<set name="flashScope.«state.name».dtmfterm" value="«configuration.getValue("dtmfterm")»" />
					«ENDIF»
					«IF configuration.getValue("maxtime") != null && !configuration.getValue("maxtime").equals("")»
					<set name="flashScope.«state.name».maxtime" value="'«configuration.getValue("maxtime")»'" />
					«ENDIF»
					«IF configuration.getValue("finalsilence") != null && !configuration.getValue("finalsilence").equals("")»
					<set name="flashScope.«state.name».finalsilence" value="'«configuration.getValue("finalsilence")»'" />
					«ENDIF»
					«IF configuration.getValue("fileName") != null && !configuration.getValue("fileName").equals("")»
					<set name="flashScope.«state.name».fileName" value="'«configuration.getValue("fileName")»'" />
					«ENDIF»
					«IF configuration.getValue("keep") != null && !configuration.getValue("keep").equals("")»
					<set name="flashScope.«state.name».keep" value="«configuration.getValue("keep")»" />
					«ENDIF»
				«ENDIF»
		<set name="flashScope.jVoiceArchRecFileName" value="flashScope.«state.name».fileName" />		
        «IF audios != null»
        «var mainAudios = recordIn.locution.audios.mainAudios»
        «var noMatchAudios = recordIn.locution.audios.noMatchAudios»
        «var noInputAudios = recordIn.locution.audios.noInputAudios»
       	«var matchAudios = recordIn.locution.audios.matchAudios»
        «GeneralStateCodeXML.doGenerateGeneralState(state, mainAudios, "mainAudios")»
        «GeneralStateCodeXML.doGenerateGeneralState(state, noMatchAudios, "noMatchAudios")»
        «GeneralStateCodeXML.doGenerateGeneralState(state, noInputAudios, "noInputAudios")»
        «GeneralStateCodeXML.doGenerateGeneralState(state, matchAudios, "matchAudios")»
		«ENDIF»
			</on-entry>
			<evaluate expression="flowProcessor.process(flashScope.«state.name»)"/>			
			<transition to="render_«state.name»"/>
		</action-state>
		
		<view-state id="render_«state.name»" view="#{flowProcessor.getRenderer().getView()}" model="lastRecordResult">
			«IF tranSalidaS != null && tranSalidaS.size>0»
			    «FOR tranSalida : tranSalidaS» 
			    	«IF tranSalida.target instanceof CustomState» 
			    		<transition on="recorded" to="render_«tranSalida.target.name»"/>
			    	«ELSE»
			    		<transition on="recorded" to="«tranSalida.target.name»"/>
			    	«ENDIF»
			    «ENDFOR»
			«ENDIF»	
		</view-state>
'''
	}}