package com.isb.jVoice.application.builder

import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import static com.isb.jVoice.application.builder.Using.*

class XMLGeneratorRC {
	
	def static generate(File target) {
		new XMLGeneratorRC().generateXML(target);
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
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
		
		<!-- Root Context: defines shared resources visible to all other web components -->
			
	</beans>
	'''
}




