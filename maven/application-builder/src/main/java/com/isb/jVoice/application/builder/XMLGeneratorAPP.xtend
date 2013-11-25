package com.isb.jVoice.application.builder

import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import com.vectorsf.jvoice.model.base.JVModule
import java.util.List

class XMLGeneratorAPP {
	
	def static generate(File target, List<JVModule> modules) {
		new XMLGeneratorAPP().generateXML(target, modules);
	}
	
	def generateXML(File file, List<JVModule> modules) {
		var out = new BufferedWriter
			    (new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
		out.append(doGenerate(modules));
		out.close();	
	}
	
	def doGenerate(List<JVModule> modules) '''
		«doGenerateWeb(modules)»
	'''

	def doGenerateWeb(List<JVModule> modules) '''
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
	«FOR module : modules »
	<context:component-scan base-package="«module.componentsPackage»" />
	«ENDFOR»
	
	</beans:beans>
	'''
}




