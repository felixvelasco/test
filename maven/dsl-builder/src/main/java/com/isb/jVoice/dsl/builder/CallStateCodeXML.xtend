package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CallState
import com.vectorsf.jvoice.model.operations.ComponentBean
import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.Transition
import org.eclipse.emf.common.util.EList

class CallStateCodeXML {
	
	def static doGenerateCallState(State state){
		var EList<Transition> TranSalida =state.getOutgoingTransitions()
		var CallState callState = state as CallState 
		var ComponentBean jvB= callState.bean
		jvB.nameBean
'''
		<action-state id="«state.name»">
		 <evaluate expression="«jvB.nameBean».«callState.methodName»"/>
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
		</action-state>
    	'''
	}
}

