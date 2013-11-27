package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CallFlowState

class CallFlowStateCodeXML extends StateCodeGenerator {

	val path = "src/main/resources/jv/"

	def doGenerateCallFlowState(CallFlowState state) '''
		<subflow-state id="«state.name»" subflow="«state.flowName»">
		«state.externalizeParameters»
		«state.transitions('\n\t<evaluate expression="currentEvent.attributes.result" result="flowScope.result" />\n')»
		</subflow-state>
	'''
	
	def externalizeParameters(CallFlowState state) '''
		«FOR i : 0..<state.subflow.parameters.size»
			<input name="«state.subflow.parameters.get(i)»" value="«state.parameters.get(i)»" 
		«ENDFOR»
	'''

	def flowName(CallFlowState state) {
		var pathURI = state.subflow.eResource.URI.path
		pathURI.substring(pathURI.indexOf(path) + path.length, pathURI.lastIndexOf("."))
	}

}
