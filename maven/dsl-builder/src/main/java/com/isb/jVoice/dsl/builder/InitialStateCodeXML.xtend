package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.operations.InitialState
import com.vectorsf.jvoice.model.operations.Flow

class InitialStateCodeXML {
	
	def static doGenerateInitialState(Flow flow, InitialState state) {
		var beans = flow.beans

	'''
		<on-start>
			<on-entry>
			«FOR bean: beans »
				<evaluate expression="«bean.fqdn»" result="flowScope.«bean.name»"></evaluate>
			«ENDFOR»
			</on-entry>
		</on-start>
	'''
	}
}