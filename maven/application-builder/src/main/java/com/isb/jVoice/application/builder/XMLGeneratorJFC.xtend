package com.isb.jVoice.application.builder

import java.io.File
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import static com.isb.jVoice.application.builder.Using.*

class XMLGeneratorJFC {
	
	def static generate(File target, String projectName) {
		new XMLGeneratorJFC().generateXML(target,projectName);
	}
	
	def generateXML(File file, String projectName) {
		using(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8")))[
			it.append(doGenerate(projectName));
		]	
	}
	
	def doGenerate(String projectName) '''
		«doGenerateWeb(projectName)»
	'''

	def doGenerateWeb(String projectName) '''
	<?xml version="1.0" encoding="UTF-8"?>
	<beans:beans xmlns="http://www.springframework.org/schema/mvc"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:beans="http://www.springframework.org/schema/beans"
		xmlns:context="http://www.springframework.org/schema/context"
		xmlns:aop="http://www.springframework.org/schema/aop"
		xmlns:webflow="http://www.springframework.org/schema/webflow-config"
		xsi:schemaLocation="http://www.springframework.org/schema/mvc 
							http://www.springframework.org/schema/mvc/spring-mvc.xsd
							http://www.springframework.org/schema/beans 
							http://www.springframework.org/schema/beans/spring-beans.xsd
							http://www.springframework.org/schema/context 
							http://www.springframework.org/schema/context/spring-context.xsd
							http://www.springframework.org/schema/aop
	    					http://www.springframework.org/schema/aop/spring-aop.xsd
	    					http://www.springframework.org/schema/webflow-config
	        				http://www.springframework.org/schema/webflow-config/spring-webflow-config.xsd">
	
		<!-- Beans jVoice Framework -->
		<context:component-scan base-package="com.vectorsf.jvoiceframework"/>
	
		<!-- Aspectos. Usamos JDK proxys frente a CGLIB -->
		<aop:aspectj-autoproxy proxy-target-class="true"/> 
		
	    <beans:bean class="org.springframework.webflow.mvc.servlet.FlowHandlerMapping">
	        <beans:property name="flowRegistry" ref="flowRegistry"/>
	        <beans:property name="order" value="-1" />
	    </beans:bean>
	    
	    <beans:bean class="org.springframework.webflow.mvc.servlet.FlowHandlerAdapter">
	        <beans:property name="flowExecutor" ref="flowExecutor"/>
	    </beans:bean>
	
		<webflow:flow-executor id="flowExecutor" flow-registry="flowRegistry" >
			<webflow:flow-execution-listeners>
				<webflow:listener ref="logFlowExecutionListener" />
			</webflow:flow-execution-listeners>
		</webflow:flow-executor>
	
		<!-- Registro de flujos -->
		<webflow:flow-registry id="flowRegistry" flow-builder-services="flowBuilderServices" base-path="/WEB-INF/flows">
			<webflow:flow-location-pattern value="/**/*-flow.xml" />
		</webflow:flow-registry>
	
		<!-- Asociamos el resolutor de vistas al flow Executor -->
		<webflow:flow-builder-services id="flowBuilderServices"
			view-factory-creator="viewFactoryCreator" />

		«IF (false) /* TODO */»
		<bean id="renderer" class="com.vectorsf.jvoiceframework.isban.logger.render.vxi.IsbanLoggerRenderer">
		«ELSE»
		<bean id="renderer" class="com.vectorsf.jvoiceframework.flow.render.vxi.VXIRenderer">
		«ENDIF»
			<property name="view" value="renderVXI"></property>
		</bean>
		<beans:bean id="viewFactoryCreator" class="org.springframework.webflow.mvc.builder.MvcViewFactoryCreator">
			<beans:property name="viewResolvers">
				<beans:list>
					<beans:ref bean="viewResolver" />
				</beans:list>
			</beans:property>
		</beans:bean>
		
		<!-- Habilitamos los ámbitos flow y flash -->
		<beans:bean class="org.springframework.beans.factory.config.CustomScopeConfigurer">
			<beans:property name="scopes">
				<beans:map>
					<beans:entry key="flash">
						<beans:bean class="org.springframework.webflow.scope.FlashScope" />
					</beans:entry>
					<beans:entry key="flow">
						<beans:bean class="org.springframework.webflow.scope.FlowScope" />
				</beans:entry>
				</beans:map>
			</beans:property>
		</beans:bean>
		
		<beans:bean id="endpointProvider" class="com.vectorsf.jvoiceframework.core.service.ws.XMLBasedEndpointProvider">
		   <beans:property name="resource" value="/resources/com/vectorsf/«projectName»/ws/ws-endpoints.xml" /> 
		</beans:bean>
		

	</beans:beans>
	'''
}




