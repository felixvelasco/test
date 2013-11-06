package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.MenuState
import com.vectorsf.jvoice.model.operations.CustomState

class MenuStateCodeXML {
	
	def static doGenerateMenuState(State state){
			
		var tranSalidaS =state.getOutgoingTransitions()
		var MenuState audioIn = state as MenuState
		
		var grammars = audioIn.locution.grammars
		
		var Audios = audioIn.locution.audios

		var outputs = audioIn.locution.outputs
		
		var i=0
		
'''
		<action-state id="«state.name»">
			<on-entry>
				<evaluate expression="output" result="flowScope.«state.name»"></evaluate>
				<set name="flowScope.«state.name».name" value="'«audioIn.name»'" />
				«/*Obtenemos las gramaticas del menu */»
				«IF grammars != null»
					«var grammatics = audioIn.locution.grammars.grammatics»
					«IF grammatics != null && grammatics.size>0» 				
						«FOR grammatic : grammatics »
							<evaluate expression="grammar" result="flowScope.grammar«i=i+1»" />
							<set name="flowScope.grammar«i».type" value="'«grammatic.expr.booleanValue»'"/>
							<set name="flowScope.grammar«i».src" value="'«grammatic.src»'"/>
							<set name="flowScope.grammar«i».mode" value="'«grammatic.mode»'"/>
							<evaluate expression="flowScope.«state.name».grammars.add(flowScope.grammar«i»)" />
						«ENDFOR»
	        		«ENDIF»
        		«ENDIF»
        		«IF Audios != null» 
        			«var mainAudios = audioIn.locution.audios.mainAudios»
	        		«var noMatchAudios = audioIn.locution.audios.noMatchAudios»
	        		«var noInputAudios = audioIn.locution.audios.noInputAudios»
	        		«var matchAudios = audioIn.locution.audios.matchAudios»		   	
			        «GeneralStateCodeXML.doGenerateGeneralState(state, mainAudios, "mainAudios")»
			       	«GeneralStateCodeXML.doGenerateGeneralState(state, noMatchAudios, "noMatchAudios")»
			      	«GeneralStateCodeXML.doGenerateGeneralState(state, noInputAudios, "noInputAudios")»
			      	«GeneralStateCodeXML.doGenerateGeneralState(state, matchAudios, "matchAudios")»
		      	«ENDIF»
			</on-entry>
			<evaluate expression="flowProcessor.process(flowScope.«state.name»)"/>
			<transition to="render_«state.name»"></transition>				
		</action-state>
		
		<view-state id="render_«state.name»" view="#{flowProcessor.getRenderer().getView()}" model="lastInputResult">
		    <transition on="match" to="render_decision_«state.name»"/>
		</view-state>
			
		<action-state id="render_decision_«state.name»">
			<evaluate expression="flowScope.menuOption"></evaluate>
			«IF outputs != null» 
				«var output = audioIn.locution.outputs.output» 
				«IF tranSalidaS != null && output !=null && output.size>0 && tranSalidaS.size>0»
				   		«FOR out :output»
				   			«FOR tranSalida : tranSalidaS»
				   				«IF out.name.equals(tranSalida.eventName)»	
				   					«FOR outputValue : out.outputValue»
				   						«IF tranSalida.target instanceof CustomState» 
				   							<transition on="«outputValue.value»" to="render_«tranSalida.target.name»"/>
				   						«ELSE»
				   							<transition on="«outputValue.value»" to="«tranSalida.target.name»"/>
				   						«ENDIF»
				   					«ENDFOR»
				   				«ENDIF»
				   			«ENDFOR»
				   		«ENDFOR»
				«ENDIF»
			«ENDIF»
		</action-state>
'''
	}
}


