package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State

class CallFlowStateCodeXML {

	
	def static doGenerateCallFlowState(State state) '''
        <subflow-state id="«state.name»" subflow="«state.name»">

              <transition to="«NombreTranSalida.Nombre(state)»"/> 
	</subflow-state>
   '''
}