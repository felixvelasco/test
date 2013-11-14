package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.SwitchState
import com.vectorsf.jvoice.model.operations.Transition
import com.vectorsf.jvoice.model.operations.CustomState

class SwitchStateCodeXML {

	
	def static doGenerateSwitchState(State switchState) '''
	«var SwitchState state = switchState as SwitchState»
	«FOR i: 0..state.^case.size-1»
		«IF i==0»
			<action-state id="«state.name»">
		«ENDIF»
		«IF !(i==0)»
			<action-state id="«state.name+"_"+state.^case.get(i).eventName»">
      	«ENDIF»
		«IF !state.^case.get(i).eventName.equals("default")»
			<evaluate expression="«state.^case.get(i).condition»" />
			«FOR Transition transition: state.outgoingTransitions»
				«IF transition.eventName.equals(state.^case.get(i).eventName)»
					«IF transition.target instanceof CustomState»
					<transition on="yes" to="render_«transition.target.name»"/>
					«ELSE» 
					<transition on="yes" to="«transition.target.name»"/>
					«ENDIF» 
	       		«ENDIF» 
	     	«ENDFOR»    
			«IF state.^case.size > i »
				<transition to="«state.name+"_"+state.^case.get(i+1).eventName»"/>
			«ENDIF»
		</action-state>
		«ENDIF»
		«IF state.^case.get(i).eventName.equals("default")»
			«FOR Transition transition: state.outgoingTransitions»
				«IF transition.eventName.equals("default")»
					«IF transition.target instanceof CustomState»
						<transition to="render_«transition.target.name»"/>
					«ELSE» 
						<transition to="«transition.target.name»"/>
					«ENDIF»
				«ENDIF»
			«ENDFOR»   
		</action-state>	 
		«ENDIF»
	«ENDFOR»    

	'''
}

