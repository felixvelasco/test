package com.isb.jVoice.dsl.builder;

import com.google.common.base.Objects;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Audio;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Audios;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Condition;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Configuration;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Initial;
import com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement;
import com.isb.bks.ivr.voice.dsl.voiceDsl.Match;
import java.io.File;
import java.io.FileWriter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Builder {
  private Resource res;
  
  private InputElement element;
  
  public Builder(final Resource resource) {
    this.res = resource;
    EObject _eObject = this.res.getEObject("/0");
    this.element = ((InputElement) _eObject);
  }
  
  public void generate(final File file) {
    try {
      FileWriter _fileWriter = new FileWriter(file);
      FileWriter fw = _fileWriter;
      String _name = file.getName();
      String _name_1 = file.getName();
      int _lastIndexOf = _name_1.lastIndexOf(".");
      String name = _name.substring(0, _lastIndexOf);
      CharSequence _doGenerate = this.doGenerate(name);
      fw.append(_doGenerate);
      fw.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence doGenerate(final String name) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _doGenerateHeader = this.doGenerateHeader(name);
    _builder.append(_doGenerateHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Audios _audios = this.element.getAudios();
    Initial _initial = _audios.getInitial();
    CharSequence _doGenerateInitial = this.doGenerateInitial(_initial);
    _builder.append(_doGenerateInitial, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Audios _audios_1 = this.element.getAudios();
    Match _match = _audios_1.getMatch();
    CharSequence _doGenerateMatch = this.doGenerateMatch(_match);
    _builder.append(_doGenerateMatch, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence doGenerateInitial(final Initial initial) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void callInitial() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("System.out.println(\"Saludo inicial \");");
    _builder.newLine();
    {
      EList<Audio> _audio = initial.getAudio();
      for(final Audio audio : _audio) {
        _builder.append("\t");
        CharSequence _printAudio = this.printAudio(audio);
        _builder.append(_printAudio, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence doGenerateMatch(final Match match) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void callMatch() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("System.out.println(\"Resoluci\u00F3n del match\");");
    _builder.newLine();
    {
      EList<Audio> _audio = match.getAudio();
      for(final Audio audio : _audio) {
        _builder.append("\t");
        CharSequence _printAudio = this.printAudio(audio);
        _builder.append(_printAudio, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence doGenerateHeader(final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class ");
    _builder.append(name, "");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String args[])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"Input configurado como ");
    Configuration _configuration = this.element.getConfiguration();
    String _name = _configuration.getName();
    _builder.append(_name, "		");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append(name, "		");
    _builder.append(" element = new ");
    _builder.append(name, "		");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("element.callInitial();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("element.callMatch();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence printAudio(final Audio audio) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("System.out.println(\"Audio\");");
    _builder.newLine();
    {
      String _tts = audio.getTts();
      boolean _notEquals = (!Objects.equal(_tts, null));
      if (_notEquals) {
        _builder.append("System.out.println(\"Salida tts: ");
        String _tts_1 = audio.getTts();
        _builder.append(_tts_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      String _src = audio.getSrc();
      boolean _notEquals_1 = (!Objects.equal(_src, null));
      if (_notEquals_1) {
        _builder.append("System.out.println(\"Salida pregrabrabado: ");
        String _src_1 = audio.getSrc();
        _builder.append(_src_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Condition _condition = audio.getCondition();
      boolean _notEquals_2 = (!Objects.equal(_condition, null));
      if (_notEquals_2) {
        _builder.append("System.out.println(\"Solo en la vuelta: ");
        Condition _condition_1 = audio.getCondition();
        _builder.append(_condition_1, "");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("System.out.println(\"Fin audio\\n\");");
    _builder.newLine();
    return _builder;
  }
  
  public Resource setResource(final Resource resource) {
    Resource _res = this.res = resource;
    return _res;
  }
  
  public static void compile(final File target, final Resource resource) {
    Builder _builder = new Builder(resource);
    _builder.generate(target);
  }
}
