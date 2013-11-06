package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State

class FinalStateCodeXML {

	
	def static doGenerateFinalState(State state) '''
		<action-state id="«state.name»">
		    <on-entry>
		        <evaluate expression="jVoiceArchEnd" result="flashScope.end_«state.name»"></evaluate>
		        <set name="flashScope.end_«state.name».name" value="end_«state.name»"></set>                
		    </on-entry>                
		    <evaluate expression="flowProcessor.process(flashScope.end_«state.name»)"></evaluate>
		    <transition to="end-call"/>       
		</action-state>
	'''
}