package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.Transition
import org.eclipse.emf.common.util.EList
import com.vectorsf.jvoice.model.operations.CustomState

class CustomStateCodeXML {
	
	def static doGenerateCustomState(State state){
		var CustomState custom = state as CustomState 
		var EList<Transition> TranSalida =state.getOutgoingTransitions()
'''
		<view-state id="render_«state.name»" view="#{flowProcessor.getRenderer().getView()}">    
			<transition to="«state.name»"/>
		</view-state>

		<view-state id="«state.name»" view="«custom.path»">
			«IF TranSalida != null && TranSalida.size>0»
				«IF TranSalida.get(0).target instanceof CustomState»
					<transition to="render_«TranSalida.get(0).target.name»"/>
				«ELSE»	
					<transition to="«TranSalida.get(0).target.name»"/>
				«ENDIF»
			«ENDIF» 	
		</view-state>
    	'''
	}
}

