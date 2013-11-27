package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.model.operations.State

class StateCodeGenerator {

	def transitions(State state) {
		transitions(state, "")
	}

	def transitions(State state, String innerxml) {
		if (state.outgoingTransitions.size == 1) {
			var trans = state.outgoingTransitions.get(0);
			if (trans.target instanceof CustomState) {
				return '''<transition to="render_«trans.target.name»">«innerxml»</transition>'''
			}
			return '''<transition to="«trans.target.name»">«innerxml»</transition>'''

		} else {
			for (trans : state.outgoingTransitions) {
				if (trans.target instanceof CustomState) {
					return '''<transition on="«trans.eventName»" to="render_«trans.target.name»">«innerxml»</transition>'''
				}
				return '''<transition on="«trans.eventName»" to="«trans.target.name»">«innerxml»</transition>'''
			}
		}
	}
}
