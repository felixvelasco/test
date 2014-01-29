package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.model.operations.State

class StateCodeGenerator {

	def transitions(State state) {
		transitions(state, "")
	}

	def transitions(State state, String innerxml) {
		'''
		«IF state.outgoingTransitions.size == 1» 
			«var trans = state.outgoingTransitions.get(0)»
			«IF trans.target instanceof CustomState» 
				 <transition to="render_«trans.target.name»">«innerxml»</transition>
			«ENDIF»
			 <transition to="«trans.target.name»">«innerxml»</transition>

		 «ELSE» 
			«FOR trans : state.outgoingTransitions » 
				«IF (trans.target instanceof CustomState)» 
					 <transition on="«trans.eventName»" to="render_«trans.target.name»">«innerxml»</transition>
				«ENDIF»
				<transition on="«trans.eventName»" to="«trans.target.name»">«innerxml»</transition>
			«ENDFOR»
		«ENDIF»
		'''
	}
}
