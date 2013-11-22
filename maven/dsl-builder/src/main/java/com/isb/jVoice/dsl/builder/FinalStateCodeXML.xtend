package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.FinalState

class FinalStateCodeXML {

	
	def static doGenerateFinalState(FinalState state) '''
		<action-state id="«state.name»">
		    <on-entry>
		        <evaluate expression="jVoiceArchEnd" result="flashScope.end_«state.name»"></evaluate>              
		    </on-entry>                
		    <evaluate expression="flowProcessor.process(flashScope.end_«state.name»)"></evaluate>
		    <transition to="end-call"/>       
		</action-state>
	'''
}