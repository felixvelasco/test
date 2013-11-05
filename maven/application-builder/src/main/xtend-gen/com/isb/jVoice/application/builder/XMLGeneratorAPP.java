package com.isb.jVoice.application.builder;

import java.io.File;
import java.io.FileWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class XMLGeneratorAPP {
  public static void generate(final File target) {
    XMLGeneratorAPP _xMLGeneratorAPP = new XMLGeneratorAPP();
    _xMLGeneratorAPP.generateXML(target);
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
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<!-- Application beans -->");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<context:component-scan base-package=\"com.vectorsf.jvoiceframework.testapp\" />");
    _builder.newLine();
    _builder.newLine();
    _builder.append("</beans:beans>");
    _builder.newLine();
    return _builder;
  }
}
