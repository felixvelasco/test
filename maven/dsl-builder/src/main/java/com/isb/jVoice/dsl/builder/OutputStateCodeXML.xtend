package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.Transition
import org.eclipse.emf.common.util.EList

class OutputStateCodeXML {
	
	// Falta por definir
	
	def static doGenerateOutputState(State state){
		var EList<Transition> TranSalida =state.getOutgoingTransitions()
'''
       <action-state id="«state.name»">
        	<on-entry>
        	...
        	</on-entry>
        	<evaluate expression="flowProcessor.process(flowScope.«state.name»)"/>
       		<transition to="«TranSalida.get(0).target.name»"/>
       
       </action-state>
    	'''
	}
}

