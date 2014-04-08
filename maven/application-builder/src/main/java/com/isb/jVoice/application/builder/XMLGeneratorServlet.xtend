package com.isb.jVoice.application.builder

import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import static com.isb.jVoice.application.builder.Using.*

class XMLGeneratorServlet {
	
	def static generate(File target) {
		new XMLGeneratorServlet().generateXML(target);
	}
	
	def generateXML(File file) {
		using(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8")))[
			it.append(doGenerate());
		]	
	}
	
	def doGenerate() '''
		«doGenerateServlet()»
	'''

	def doGenerateServlet() '''
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
												
		<!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
		
		<!-- Enables the Spring MVC @Controller programming model -->
		<annotation-driven />
	
		<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
		<resources mapping="/resources/**" location="/resources/" />
	
		<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
		<beans:bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
				<beans:property name="prefix" value="/WEB-INF/views/" />
				<beans:property name="suffix" value=".jsp" />
		</beans:bean>
	
		<!-- Registra un multipartResolver para que Spring sepa como manejar peticiones de tipo multipart/from-data -->
		<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />
	
	</beans:beans>
	'''
}



