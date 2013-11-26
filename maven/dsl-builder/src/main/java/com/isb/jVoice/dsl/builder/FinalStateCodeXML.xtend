package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.FinalState

class FinalStateCodeXML {
	
	def static doGenerateFinalState(FinalState state) 
	    '''
		«IF state.final»
				<view-state id="redirect" view="flowredirect:jVoiceArch-end">    
				</view-state>
		«ENDIF»
	'''
}
