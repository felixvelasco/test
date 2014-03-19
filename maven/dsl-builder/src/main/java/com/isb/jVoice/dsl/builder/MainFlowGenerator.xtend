package com.isb.jVoice.dsl.builder

import com.vectorsf.jvoice.model.base.EventHandler
import com.vectorsf.jvoice.model.base.JVBean
import com.vectorsf.jvoice.model.base.JVModule
import java.io.File
import java.io.FileWriter

import static com.isb.jVoice.dsl.builder.Using.*
import java.util.List

class MainFlowGenerator {

	JVModule module
	
	val PATH = "src/main/resources/jv/"

	new(JVModule module) {
		this.module = module
	}

	def generate(File file) {
		using(new FileWriter(file)) [
			it.append(doGenerateHeader())
			
			for (handler: module.handlers) {
				it.append(generateViews(handler))
			}
			it.append(generateTransitions(module.handlers))

			it.append(doGenerateFooter());
		]
	}
	
	
	def doGenerateHeader() '''
		<flow xmlns="http://www.springframework.org/schema/webflow"	
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"	
		xsi:schemaLocation="http://www.springframework.org/schema/webflow        				
		http://www.springframework.org/schema/webflow/spring-webflow-2.0.xsd"
		abstract="true" 
		parent="_AppEventsHandlers/eventsHandlers">

	'''

	def generateTransitions(List<EventHandler> handlers) {
		if (handlers.empty)
			return ""
		
	 '''
		<global-transitions>
		«FOR handler: handlers»
			<transition on="«handler.event.toString.toLowerCase»" to="globalhandler_«handler.event»"/>
		«ENDFOR»
		</global-transitions>
	'''
	}
	
	def generateViews(EventHandler handler) '''
		<view-state id="globalhandler_«handler.event»" view="flowRedirect:«handler.handler.createId»"/>
	'''
	

	def createId(JVBean bean) {
		var pathURI = bean.eResource.URI.path
		pathURI.substring(pathURI.indexOf(PATH) + PATH.length, pathURI.lastIndexOf("."))
	}

	def doGenerateFooter() '''
		</flow> 
	'''

	def static compile(File target, JVModule module) {
		new MainFlowGenerator(module).generate(target);
	}
}
