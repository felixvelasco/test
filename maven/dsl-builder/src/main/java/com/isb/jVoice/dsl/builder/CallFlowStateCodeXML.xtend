package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.Transition
import org.eclipse.emf.common.util.EList
import com.vectorsf.jvoice.model.operations.CustomState
import com.vectorsf.jvoice.model.operations.CallFlowState

class CallFlowStateCodeXML { // Falta por definir
	def static doGenerateCallFlowState(State state) {
		var EList<Transition> TranSalida = state.getOutgoingTransitions()
		var callFlow = state as CallFlowState
		'''
		«var pathURI = callFlow.subflow.eResource.URI.path» 
		«var pathURIFinal = pathURI.substring(pathURI.indexOf("src/main/resources/jv")+22,pathURI.lastIndexOf("."))»
		<subflow-state id="«state.name»" subflow="«pathURIFinal»">
		«IF TranSalida.length==1»
			«val target = TranSalida.get(0).target»
			«IF target instanceof CustomState»
				<transition to="render_«target.name»"/>
			«ELSE»
				<transition to="«target.name»"/>
			«ENDIF»				
		«ELSE»
			«FOR trans : TranSalida»
				«IF trans.target instanceof CustomState»
					<transition on="«trans.eventName»" to="render_«trans.target.name»"/>
				«ELSE»
					<transition on="«trans.eventName»" to="«trans.target.name»"/>
				«ENDIF»
       		«ENDFOR»
		«ENDIF»				
		</subflow-state>
    	'''
	}
}
