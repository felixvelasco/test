package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CallState

class CallStateCodeXML extends StateCodeGenerator {

	def doGenerateCallState(CallState state) {
		var jvBean = state.bean
		if (jvBean == null) {
			return ""
		}

		'''
			<action-state id="«state.name»">
				<evaluate expression="flowScope.«state.bean.name».«state.methodName»(«state.parameters.join(", ")»)"/>
				«state.transitions»
			</action-state>
		  	'''
	}

}
