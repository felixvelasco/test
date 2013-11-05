package com.isb.jVoice.application.builder;

import java.io.File;
import java.io.FileWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class XMLGeneratorServlet {
  public static void generate(final File target) {
    XMLGeneratorServlet _xMLGeneratorServlet = new XMLGeneratorServlet();
    _xMLGeneratorServlet.generateXML(target);
  }
  
  public void generateXML(final File file) {
    try {
      FileWriter _fileWriter = new FileWriter(file);
      FileWriter fw = _fileWriter;
      CharSequence _doGenerate = this.doGenerate();
      fw.append(_doGenerate);
      fw.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence doGenerate() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _doGenerateServlet = this.doGenerateServlet();
    _builder.append(_doGenerateServlet, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence doGenerateServlet() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<beans:beans xmlns=\"http://www.springframework.org/schema/mvc\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:beans=\"http://www.springframework.org/schema/beans\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:context=\"http://www.springframework.org/schema/context\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xsi:schemaLocation=\"http://www.springframework.org/schema/mvc");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("http://www.springframework.org/schema/mvc/spring-mvc.xsd");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("http://www.springframework.org/schema/beans");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("http://www.springframework.org/schema/beans/spring-beans.xsd");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("http://www.springframework.org/schema/context");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.append("http://www.springframework.org/schema/context/spring-context.xsd\">");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<!-- DispatcherServlet Context: defines this servlet\'s request-processing infrastructure -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<!-- Enables the Spring MVC @Controller programming model -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<annotation-driven />");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<resources mapping=\"/resources/**\" location=\"/resources/\" />");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<beans:bean id=\"viewResolver\" class=\"org.springframework.web.servlet.view.InternalResourceViewResolver\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<beans:property name=\"prefix\" value=\"/WEB-INF/views/\" />");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<beans:property name=\"suffix\" value=\".jsp\" />");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</beans:bean>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<!-- Registra un multipartResolver para que Spring sepa como manejar peticiones de tipo multipart/from-data -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<beans:bean id=\"multipartResolver\" class=\"org.springframework.web.multipart.commons.CommonsMultipartResolver\" />");
    _builder.newLine();
    _builder.newLine();
    _builder.append("</beans:beans>");
    _builder.newLine();
    return _builder;
  }
}
