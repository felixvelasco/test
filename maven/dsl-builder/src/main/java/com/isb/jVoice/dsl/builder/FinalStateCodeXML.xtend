package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State

class FinalStateCodeXML {

	
	def static doGenerateFinalState(State state) '''
		<action-state id="«state.name»">
		     <on-entry>
		          <evaluate expression="end" result="flowScope.endState"></evaluate>
		          <set name="flowScope.endState.name" value="«state.name»"></set>                
		     </on-entry>                
		     <evaluate expression="flowProcessor.process(flowScope.endState)"></evaluate>
		     <transition to="end-call"/>       
		 </action-state>
	'''
}