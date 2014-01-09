package com.isb.jVoice.application.builder

import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class XMLGeneratorLogback {
	
	def static generate(File target, boolean legacyLogger) {
		new XMLGeneratorLogback().generateXML(target, legacyLogger);
	}
	
	def generateXML(File file, boolean legacyLogger) {
		var out = new BufferedWriter
			    (new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
		out.append(doGenerate(legacyLogger));
		out.close();	
	}

	def doGenerate(boolean legacyLogger) '''
	<?xml version="1.0" encoding="UTF-8"?>
	<configuration>
	
	    <include resource="com/vectorsf/jvoiceframework/config/logger/logback-core.xml"/>
	    «IF (legacyLogger)»
	    <include resource="com/vectorsf/jvoiceframework/config/logger/logback-isban-logger.xml"/>
		«ENDIF»

	</configuration>
	'''
}




