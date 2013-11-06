package com.isb.jVoice.application.builder

import java.io.File
import java.io.FileWriter

class XMLGeneratorRVXI {
	
	def static generate(File target) {
		new XMLGeneratorRVXI().generateXML(target);
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
	<%@ page language="java" contentType="application/vxml; charset=UTF-8" pageEncoding="UTF-8" %>${flowProcessor.render(flowExecutionUrl)}

	'''
}




