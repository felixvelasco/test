package com.isb.jVoice.application.builder

import java.io.File
import java.io.FileWriter

class XMLGeneratorRHTML {
	
	def static generate(File target) {
		new XMLGeneratorRHTML().generateXML(target);
	}
	
	def generateXML(File file) {
	var fw = new FileWriter(file)
	fw.append(doGenerate());
	fw.close()
	}
	
	def doGenerate() '''
		«doGenerateWeb()»
	'''

	def doGenerateWeb() '''
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<script type="text/javascript" src="resources/javascript/HTMLRenderer.js"></script>
<link href="resources/css/HTMLRenderer.css" rel="stylesheet"/>
 	
${flowProcessor.render(FlowExecutionUrl)}
	'''
}




