package com.vectorsf.jvoice.core.operation.helper;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
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
  
  public static ICompilationUnit createBeanFor(final String name, final IPackageFragment packageFragment, final IProgressMonitor monitor) throws JavaModelException {
    ICompilationUnit _xblockexpression = null;
    {
      String _elementName = packageFragment.getElementName();
      CharSequence _create = PrototypeCreator.create(_elementName, name);
      String contents = _create.toString();
      String _plus = (name + ".java");
      ICompilationUnit _createCompilationUnit = packageFragment.createCompilationUnit(_plus, contents, true, monitor);
      _xblockexpression = (_createCompilationUnit);
    }
    return _xblockexpression;
  }
}
