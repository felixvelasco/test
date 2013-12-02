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
			«IF state.parameters.size>0»
				<evaluate expression="flowScope.«state.bean.name».«state.methodName»('«state.parameters.join(", ")»')" result="flowScope.result"/>
			«ELSE»
				<evaluate expression="flowScope.«state.bean.name».«state.methodName»()" result="flowScope.result"/>
			«ENDIF»
				«state.transitions»
			</action-state>
		  	'''
	}

}
