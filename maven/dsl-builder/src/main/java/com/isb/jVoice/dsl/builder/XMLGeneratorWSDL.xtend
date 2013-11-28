package com.isb.jVoice.dsl.builder

import java.io.File
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.FileOutputStream

class XMLGeneratorWSDL {
	def static generate(File targetFile, File[] files) {
		new XMLGeneratorWSDL().generateXML(targetFile, files);
	}
	
	def generateXML(File targetFile, File[] files) {
		var out = new BufferedWriter
			    (new OutputStreamWriter(new FileOutputStream(targetFile),"UTF-8"));
			    
		out.append(doGenerate(files));
		out.close();
	}
	
	def doGenerate(File[] files) '''
		«doGenerateWSDL(files)»
	'''
	
	def doGenerateWSDL(File[] files) '''
	<?xml version="1.0" encoding="UTF-8"?>
	<catalog xmlns="urn:oasis:names:tc:entity:xmlns:xml:catalog" prefer="system">
	«FOR file : files »
		<system systemId="http://localhost/wsdl/«file.name»" uri="wsdl/«file.name»" />
	«ENDFOR»
	</catalog>
	'''
}