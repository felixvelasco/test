package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.State
import com.vectorsf.jvoice.model.operations.SwitchState
import com.vectorsf.jvoice.model.operations.Transition

class SwitchStateCodeXML {

	
	def static doGenerateSwitchState(State switchState) '''
	« var SwitchState state = switchState as SwitchState»

	
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
<transition on="yes" to="«transition.target.name»"/>
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
<transition on="yes" to="«transition.target.name»"/>
	   «ENDIF»
	 «ENDFOR»   
	 </action-state>
	 
	 
   «ENDIF»
   «ENDFOR»    

	'''
}

