package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State

class FinalStateCodeXML {

	
	def static doGenerateFinalState(State state) '''
		<action-state id="«state.name»">
		    <on-entry>
		        <evaluate expression="end" result="flowScope.end_«state.name»"></evaluate>
		        <set name="flowScope.end_«state.name».name" value="end_«state.name»"></set>                
		    </on-entry>                
		    <evaluate expression="flowProcessor.process(flowScope.end_«state.name»)"></evaluate>
		    <transition to="end-call"/>       
		</action-state>
	'''
}