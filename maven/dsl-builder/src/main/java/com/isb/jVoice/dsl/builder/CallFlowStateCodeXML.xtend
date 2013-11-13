package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.Transition
import org.eclipse.emf.common.util.EList
import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.model.operations.CallFlowState

class CallFlowStateCodeXML {
	
	// Falta por definir
	
	def static doGenerateCallFlowState(State state){
		var EList<Transition> TranSalida =state.getOutgoingTransitions()
		var callFlow = state as CallFlowState
'''
		<subflow-state id="«state.name»" subflow="«callFlow.subflow.name»">
			«FOR trans : TranSalida»
				«IF TranSalida.length==1»
					«IF trans.target instanceof CustomState»
						<transition to="render_«trans.target.name»"/>
					«ELSE»
						<transition to="«trans.target.name»"/>
					«ENDIF»				
				«ELSE»
					«IF trans.target instanceof CustomState»
						<transition on="«trans.eventName»" to="render_«trans.target.name»"/>
					«ELSE»
						<transition on="«trans.eventName»" to="«trans.target.name»"/>
					«ENDIF»
				«ENDIF»				
       		«ENDFOR»
		</subflow-state>
    	'''
	}
}

