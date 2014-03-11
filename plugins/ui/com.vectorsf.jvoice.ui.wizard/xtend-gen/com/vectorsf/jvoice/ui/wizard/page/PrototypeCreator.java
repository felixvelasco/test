package com.vectorsf.jvoice.ui.wizard.page;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PrototypeCreator {
  public static CharSequence create(final String packageName, final String name) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.io.Serializable;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.springframework.stereotype.Component;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Component(\"prototype\")");
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(name, "");
    _builder.append(" implements Serializable {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final long serialVersionUID = 1L;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// Add your methods here");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
