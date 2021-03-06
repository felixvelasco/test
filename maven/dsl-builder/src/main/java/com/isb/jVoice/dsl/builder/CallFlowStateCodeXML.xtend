package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.CallFlowState

class CallFlowStateCodeXML extends StateCodeGenerator {

	val path = "/jv/"

	def doGenerateCallFlowState(CallFlowState state) '''
		<subflow-state id="«state.name»" subflow="«state.flowName»">
		«state.externalizeParameters»
		«state.transitions('\n\t<set name="flowScope.result" value="currentEvent.attributes.result" />\n')»
		</subflow-state>
	'''
	
	def externalizeParameters(CallFlowState state) '''
		«FOR i : 0..< Math.min(state.subflow.parameters.size, state.parameters.size)»
			<input name="«state.subflow.parameters.get(i)»" value="«state.parameters.get(i)»" />
		«ENDFOR»
	'''

	def flowName(CallFlowState state) {
		var pathURI = state.subflow.eResource.URI.path
		pathURI.substring(pathURI.indexOf(path) + path.length, pathURI.lastIndexOf("."))
		
	}

}
