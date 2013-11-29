package com.isb.jVoice.dsl.builder

import java.io.File
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.util.List

class XMLGeneratorWSDL {
	def static generate(File targetFile, List<String> locations) {
		new XMLGeneratorWSDL().generateXML(targetFile, locations);
	}
	
	def generateXML(File targetFile, List<String> locations) {
		var out = new BufferedWriter
			    (new OutputStreamWriter(new FileOutputStream(targetFile),"UTF-8"));
			    
		out.append(doGenerate(locations));
		out.close();
	}
	
	def doGenerate(List<String> locations) '''
		«doGenerateWSDL(locations)»
	'''
	
	def doGenerateWSDL(List<String> locations) '''
	<?xml version="1.0" encoding="UTF-8"?>
	<catalog xmlns="urn:oasis:names:tc:entity:xmlns:xml:catalog" prefer="system">
	«FOR location : locations »
		<system systemId="«location»" uri="wsdl/«location.substring(location.lastIndexOf("/")+1, location.length)»" />
	«ENDFOR»
	</catalog>
	'''
}