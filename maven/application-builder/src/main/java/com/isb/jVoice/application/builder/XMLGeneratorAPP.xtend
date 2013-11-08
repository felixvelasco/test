package com.isb.jVoice.application.builder

import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class XMLGeneratorAPP {
	
	def static generate(File target) {
		new XMLGeneratorAPP().generateXML(target);
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
	<?xml version="1.0" encoding="UTF-8"?>
	<beans:beans xmlns="http://www.springframework.org/schema/mvc"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:beans="http://www.springframework.org/schema/beans"
		xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/mvc
												http://www.springframework.org/schema/mvc/spring-mvc.xsd
												http://www.springframework.org/schema/beans
												http://www.springframework.org/schema/beans/spring-beans.xsd
												http://www.springframework.org/schema/context
												http://www.springframework.org/schema/context/spring-context.xsd">
	
		<!-- Application beans -->
		<context:component-scan base-package="com.vectorsf.jvoiceframework.testapp" />
	
	</beans:beans>
	'''
}




