package com.isb.jVoice.application.builder

import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class XMLGeneratorENDP {
	
	def static generate(File target) {
		new XMLGeneratorENDP().generateXML(target);
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
	<?xml version="1.0" encoding="UTF-8" ?>
	<endpoints>
	<!--
	namespace: wsdl targetNameSpace or tns
	name: portType name
	url: target endpoint
	-->
	
	<!-- Examples:
	<endpoint namespace="http://bluedash.net/ws" name="HelloService"
		url="http://localhost:8080/ws/sayHello" />
	<endpoint namespace="http://bluedash.net/ws" name="OtherHelloService"
		url="http://localhost:8080/ws/otherSayHello" />
	-->
	
	</endpoints>
	'''
}




