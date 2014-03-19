package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.FinalState

class FinalStateCodeXML {
	
	def static doGenerateFinalState(FinalState state) 
	    '''
		«IF state.final»
			<view-state id="«state.name»" view="flowRedirect:jVoiceArchFlows/jVoiceArch-end"/>
		«ELSE»
			<end-state id="«state.name»" view="#{flowProcessor.getRenderer().getView()}">
				<output name="result" value="«if(state.returnExpression == null || state.returnExpression.empty) "''" else state.returnExpression »" />
			</end-state>
		«ENDIF»
	'''
}
