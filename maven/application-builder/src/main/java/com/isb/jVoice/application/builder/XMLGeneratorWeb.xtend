package com.isb.jVoice.application.builder

import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class XMLGeneratorWeb {
	
	def static generate(File target) {
		new XMLGeneratorWeb().generateXML(target);
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
	<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
	    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
	
	    <!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
		<context-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>/WEB-INF/spring/root-context.xml</param-value>
		</context-param>
	        
		<!-- Creates the Spring Container shared by all Servlets and Filters -->
		<listener>
				<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
	
		<!-- Processes application requests -->
		<servlet>
				<servlet-name>appServlet</servlet-name>
				<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
				<init-param>
						<param-name>contextConfigLocation</param-name>
						<param-value>/WEB-INF/**/*-context.xml
												 classpath*:/META-INF/*-context.xml
						</param-value>
				</init-param>
				<load-on-startup>1</load-on-startup>
		</servlet>
				
		<servlet-mapping>
				<servlet-name>appServlet</servlet-name>
				<url-pattern>/</url-pattern>
		</servlet-mapping>

	</web-app>
	'''
}




