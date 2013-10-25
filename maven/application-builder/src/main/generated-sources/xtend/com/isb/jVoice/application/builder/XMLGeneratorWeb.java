package com.isb.jVoice.application.builder;

import java.io.File;
import java.io.FileWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class XMLGeneratorWeb {
  public static void generate(final File target) {
    XMLGeneratorWeb _xMLGeneratorWeb = new XMLGeneratorWeb();
    _xMLGeneratorWeb.generateXML(target);
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
    CharSequence _doGenerateWeb = this.doGenerateWeb();
    _builder.append(_doGenerateWeb, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence doGenerateWeb() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<web-app version=\"2.5\" xmlns=\"http://java.sun.com/xml/ns/javaee\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("xsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd\">");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<!-- The definition of the Root Spring Container shared by all Servlets and Filters -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<context-param>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<param-name>contextConfigLocation</param-name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<param-value>/WEB-INF/spring/root-context.xml</param-value>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</context-param>");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<!-- Creates the Spring Container shared by all Servlets and Filters -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<listener>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</listener>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<!-- Processes application requests -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<servlet>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<servlet-name>appServlet</servlet-name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<init-param>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<param-name>contextConfigLocation</param-name>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<param-value>/WEB-INF/**/*-context.xml");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t\t\t\t ");
    _builder.append("classpath*:/META-INF/*-context.xml");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("</param-value>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</init-param>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<load-on-startup>1</load-on-startup>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</servlet>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<servlet-mapping>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<servlet-name>appServlet</servlet-name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<url-pattern>/</url-pattern>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</servlet-mapping>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("</web-app>");
    _builder.newLine();
    return _builder;
  }
}
