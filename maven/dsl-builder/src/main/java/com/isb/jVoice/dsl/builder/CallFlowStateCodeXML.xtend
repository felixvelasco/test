package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.Transition
import org.eclipse.emf.common.util.EList

class CallFlowStateCodeXML {
	
	// Falta por definir
	
	def static doGenerateCallFlowState(State state){
		var EList<Transition> TranSalida =state.getOutgoingTransitions()
'''
		<subflow-state id="«state.name»" subflow="«state.name»">
			«FOR trans : TranSalida»
			<transition on="«trans.eventName»" to="«trans.target.name»"/>
       		«ENDFOR»
		</subflow-state>
    	'''
	}
}

