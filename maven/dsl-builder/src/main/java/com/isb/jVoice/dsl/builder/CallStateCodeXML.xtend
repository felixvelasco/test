package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.Transition
import org.eclipse.emf.common.util.EList

class CallStateCodeXML {
	
	def static doGenerateCallState(State state){
		var EList<Transition> TranSalida =state.getOutgoingTransitions()
'''
		<action-state id="«state.name»">
			«FOR trans : TranSalida»
				<transition on="«trans.eventName»" to="«trans.target.name»"/>
			«ENDFOR»
		</action-state>
    	'''
	}
}

