package com.vectorsf.jvoice.ui.wizard.create;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class XMLGeneratorENDP {
  public static void generate(final File target) {
    XMLGeneratorENDP _xMLGeneratorENDP = new XMLGeneratorENDP();
    _xMLGeneratorENDP.generateXML(target);
  }
  
  public void generateXML(final File file) {
    try {
      FileOutputStream _fileOutputStream = new FileOutputStream(file);
      OutputStreamWriter _outputStreamWriter = new OutputStreamWriter(_fileOutputStream, "UTF-8");
      BufferedWriter _bufferedWriter = new BufferedWriter(_outputStreamWriter);
      BufferedWriter out = _bufferedWriter;
      CharSequence _doGenerate = this.doGenerate();
      out.append(_doGenerate);
      out.close();
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
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
    _builder.newLine();
    _builder.append("<endpoints>");
    _builder.newLine();
    _builder.append("<!--");
    _builder.newLine();
    _builder.append("namespace: wsdl targetNameSpace or tns");
    _builder.newLine();
    _builder.append("name: portType name");
    _builder.newLine();
    _builder.append("url: target endpoint");
    _builder.newLine();
    _builder.append("-->");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<!-- Examples:");
    _builder.newLine();
    _builder.append("<endpoint namespace=\"http://bluedash.net/ws\" name=\"HelloService\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("url=\"http://localhost:8080/ws/sayHello\" />");
    _builder.newLine();
    _builder.append("<endpoint namespace=\"http://bluedash.net/ws\" name=\"OtherHelloService\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("url=\"http://localhost:8080/ws/otherSayHello\" />");
    _builder.newLine();
    _builder.append("-->");
    _builder.newLine();
    _builder.newLine();
    _builder.append("</endpoints>");
    _builder.newLine();
    return _builder;
  }
}
