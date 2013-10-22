package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.MenuState

class MenuStateCodeXML {
	
	def static doGenerateMenuState(State state){
			
		var tranSalidaS =state.getOutgoingTransitions()
		var MenuState audioIn = state as MenuState
		
		var grammars = audioIn.locution.grammars.grammatics
		
		var mainAudios = audioIn.locution.audios.mainAudios
		var noMatchAudios = audioIn.locution.audios.noMatchAudios
		var noInputAudios = audioIn.locution.audios.noInputAudios
		var matchAudios = audioIn.locution.audios.matchAudios
		var outputs = audioIn.locution.outputs.output
		
		var i=0
		
'''
		<action-state id="«state.name»">
			<on-entry>
				<evaluate expression="output" result="flowScope.«state.name»"></evaluate>
				<set name="flowScope.«state.name».name" value="'«audioIn.name»'" />
				«/*Obtenemos las gramaticas del menu */»
				«IF grammars != null || grammars.size>0» 				
					«FOR grammar : grammars »
						<evaluate expression="grammar" result="flowScope.grammar«i=i+1»" />
						<set name="flowScope.grammar«i».type" value="'«grammar.expr.booleanValue»'"/>
						<set name="flowScope.grammar«i».src" value="'«grammar.src»'"/>
						<set name="flowScope.grammar«i».mode" value="'«grammar.mode»'"/>
						<evaluate expression="flowScope.«state.name».grammars.add(flowScope.grammar«i»)" />
					«ENDFOR»
        		«ENDIF»
		        «GeneralStateCodeXML.doGenerateGeneralState(state, mainAudios, "mainAudios")»
		       	«GeneralStateCodeXML.doGenerateGeneralState(state, noMatchAudios, "noMatchAudios")»
		      	«GeneralStateCodeXML.doGenerateGeneralState(state, noInputAudios, "noInputAudios")»
		      	«GeneralStateCodeXML.doGenerateGeneralState(state, matchAudios, "matchAudios")»
			</on-entry>
			<evaluate expression="flowProcessor.process(flowScope.«state.name»)"/>
			<transition to="render_«state.name»"></transition>				
		</action-state>
		
		<view-state id="render_«state.name»" view="#{flowProcessor.getRenderer().getView()}" model="lastInputResult">
		    <transition on="match" to="render_decision_«state.name»"/>
		</view-state>
			
		<action-state id="render_decision_«state.name»">
			<evaluate expression="flowScope.menuOption"></evaluate>
			«IF tranSalidaS != null && outputs !=null && outputs.size>0 && tranSalidaS.size>0»
			   		«FOR output :outputs»
			   			«FOR tranSalida : tranSalidaS»
			   				«IF output.name.equals(tranSalida.eventName)»	
			   					«FOR outputValue : output.outputValue»
			   						<transition on="«outputValue.value»" to="«tranSalida.target.name»"/>
			   					«ENDFOR»
			   				«ENDIF»
			   			«ENDFOR»
			   		«ENDFOR»
			«ENDIF»
		</action-state>
'''
	}
}


