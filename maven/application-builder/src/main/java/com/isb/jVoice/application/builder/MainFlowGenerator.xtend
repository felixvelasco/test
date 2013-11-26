package com.isb.jVoice.application.builder

import com.vectorsf.jvoice.model.base.EventHandler
import com.vectorsf.jvoice.model.base.JVBean
import com.vectorsf.jvoice.model.base.JVProject
import java.io.File
import java.io.FileWriter

import static com.isb.jVoice.application.builder.Using.*

class MainFlowGenerator {

	JVProject module
	
	val PATH = "src/main/resources/jv/"

	new(JVProject module) {
		this.module = module
	}

	def generate(File file) {
		using(new FileWriter(file)) [
			//Obtenemos el estado inicial para escribri la cabecera.
			it.append(doGenerateHeader())
			
			// Se recorre de nuevo todo el array para escribir el resto de estados del diagrama 
			for (handler: module.handlers) {
				it.append(generateTransition(handler))
			}
			it.append(doGenerateFooter());
		]
	}
	
	
	def doGenerateHeader() '''
		<flow xmlns="http://www.springframework.org/schema/webflow"	
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"	
		xsi:schemaLocation="http://www.springframework.org/schema/webflow        				
		http://www.springframework.org/schema/webflow/spring-webflow-2.0.xsd"
		abstract="true">

	'''

	def generateTransition(EventHandler handler) '''
		<view-state id="globalhandler_«handler.event»" view="flowRedirect:«handler.handler.createId»"/>  
			
		<global-transitions>
			<transition on="«handler.event»" to="globalhandler_«handler.event»"/>
		</global-transitions>
	'''
	
	def createId(JVBean bean) {
		var pathURI = bean.eResource.getURI.path
		pathURI.substring(pathURI.indexOf(PATH) + PATH.length, pathURI.lastIndexOf("."))
	}

	def doGenerateFooter() '''
		</flow> 
	'''

	def static compile(File target, JVProject project) {
		new MainFlowGenerator(project).generate(target);
	}
}
