package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CallState
import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.model.operations.State

class CallStateCodeXML {
	
	def static doGenerateCallState(CallState state){
		var jvBean = state.bean
		if (jvBean == null)
		{
			return ""
		}
		
		'''
		<action-state id="«state.name»">
		 <evaluate expression="«jvBean.nameBean».«state.methodName»"/>
			«state.transitions»
		</action-state>
    	'''
	}
	
	def static transitions(State state) { 
		if (state.outgoingTransitions.size==1)
		{
			var trans = state.outgoingTransitions.get(0);
			if (trans.target instanceof CustomState)
			{
				return '''<transition to="render_«trans.target.name»"/>'''
			}
			return '''<transition to="«trans.target.name»"/>'''
			
		} else {
			for (trans : state.outgoingTransitions) {
				if (trans.target instanceof CustomState) {
					return '''<transition on="«trans.eventName»" to="render_«trans.target.name»"/>'''
				}
				return '''<transition on="«trans.eventName»" to="«trans.target.name»"/>'''
			}
		}
	}
}

