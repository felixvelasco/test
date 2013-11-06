package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.Transition
import org.eclipse.emf.common.util.EList
import com.vectorsf.jvoice.model.operations.CustomState

class CallStateCodeXML {
	
	def static doGenerateCallState(State state){
		var EList<Transition> TranSalida =state.getOutgoingTransitions()
'''
		<action-state id="«state.name»">
			«FOR trans : TranSalida»
				«IF trans.target instanceof CustomState»
					<transition on="«trans.eventName»" to="render_«trans.target.name»"/>
				«ELSE»
					<transition on="«trans.eventName»" to="«trans.target.name»"/>
				«ENDIF»
			«ENDFOR»
		</action-state>
    	'''
	}
}

