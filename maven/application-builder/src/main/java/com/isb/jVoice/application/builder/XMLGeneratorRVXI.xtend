package com.isb.jVoice.application.builder

import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import static com.isb.jVoice.application.builder.Using.*

class XMLGeneratorRVXI {
	
	def static generate(File target) {
		new XMLGeneratorRVXI().generateXML(target);
	}
	
	def generateXML(File file) {
		using(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8")))[
			it.append(doGenerate());
		]	
	}
	
	def doGenerate() '''
		«doGenerateWeb()»
	'''

	def doGenerateWeb() '''
	<%@ page language="java" contentType="application/vxml; charset=UTF-8" pageEncoding="UTF-8" %>${flowProcessor.render(flowExecutionUrl)}

	'''
}




