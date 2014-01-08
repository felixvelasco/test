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
			   «IF state.bean.prototype»
			      «IF state.parameters.size>0»
			         <evaluate expression="flowScope.«state.bean.name».«state.methodName»(«state.parameters.join(", ")»)"
			      «ELSE»
			         <evaluate expression="flowScope.«state.bean.name».«state.methodName»()"
			      «ENDIF»
			   «ELSE»  
			      «IF state.parameters.size>0»
			         <evaluate expression="«state.bean.nameBean».«state.methodName»(«state.parameters.join(", ")»)"
			      «ELSE»
			         <evaluate expression="«state.bean.nameBean».«state.methodName»()"
			      «ENDIF»
			   «ENDIF»
			   «IF state.referencedBean!=null»
			       result="«state.referencedBean.name»"/>
			   «ELSE»
			       />
			   «ENDIF»
			   
			
				«state.transitions»
			</action-state>
		  	'''
	}

}
