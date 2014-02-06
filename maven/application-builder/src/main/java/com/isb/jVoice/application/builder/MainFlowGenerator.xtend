package com.isb.jVoice.application.builder

import com.vectorsf.jvoice.model.base.EventHandler
import com.vectorsf.jvoice.model.base.JVApplication
import java.io.File
import java.io.FileWriter
import java.util.List
import org.eclipse.emf.ecore.InternalEObject

import static com.isb.jVoice.application.builder.Using.*

class MainFlowGenerator {

	JVApplication module

	val PATH = "src/main/resources/jv/"
	val SLASH_JV = "/jv/"

	new(JVApplication module) {
		this.module = module
	}

	def generate(File file) {
		using(new FileWriter(file)) [
			it.append(doGenerateHeader())
			for (handler : module.handlers) {
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
		abstract="true">
		
	'''

	def generateTransitions(List<EventHandler> handlers) {
		if (handlers.empty)
			return ""
		'''
			<global-transitions>
			«FOR handler : handlers»
				<transition on="«handler.event.toString.toLowerCase»" to="globalhandler_«handler.event»"/>
			«ENDFOR»
			</global-transitions>
		'''
	}

	def generateViews(EventHandler handler) '''
		<view-state id="globalhandler_«handler.event»" view="flowRedirect:«handler.createId»"/>
	'''

	def createId(EventHandler handler) {
		var bean = handler.handler
		if (bean.eIsProxy) {
			var internal = bean as InternalEObject
			var pathURI = internal.eProxyURI.path
			pathURI.substring(SLASH_JV.length, pathURI.lastIndexOf("."))
		} else {
			var pathURI = bean.eResource.getURI.path
			pathURI.substring(pathURI.indexOf(PATH) + PATH.length, pathURI.lastIndexOf("."))
		}
	}

	def doGenerateFooter() '''
		</flow> 
	'''

	def static compile(File target, JVApplication project) {
		new MainFlowGenerator(project).generate(target);
	}
}
