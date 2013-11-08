package com.isb.jVoice.application.builder

import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class XMLGeneratorRHTML {
	
	def static generate(File target) {
		new XMLGeneratorRHTML().generateXML(target);
	}
	
	def generateXML(File file) {
		var out = new BufferedWriter
			    (new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
		out.append(doGenerate());
		out.close();	
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




