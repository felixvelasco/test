package com.isb.bks.ivr.voice.dsl.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Field;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Function;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Member;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Type;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>
 */
@SuppressWarnings("all")
public class VoiceDslJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  protected void _infer(final VoiceDsl voiceDsl, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPrelinkingPhase) {
    EList<Type> _types = voiceDsl.getTypes();
    for (final Type classElement : _types) {
      if ((classElement instanceof com.vectorsf.jvoice.prompt.model.voiceDsl.Class)) {
        final com.vectorsf.jvoice.prompt.model.voiceDsl.Class clase = ((com.vectorsf.jvoice.prompt.model.voiceDsl.Class) classElement);
        JvmGenericType _class = this._jvmTypesBuilder.toClass(clase, "example1.main");
        IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
        final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
            public void apply(final JvmGenericType it) {
              String _documentation = VoiceDslJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(clase);
              VoiceDslJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
              EList<Member> _members = clase.getMembers();
              for (final Member functionElement : _members) {
                {
                  if ((functionElement instanceof Function)) {
                    final Function function = ((Function) functionElement);
                    EList<JvmMember> _members_1 = it.getMembers();
                    JvmOperation _buildFunction = VoiceDslJvmModelInferrer.this.buildFunction(function);
                    VoiceDslJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _buildFunction);
                  }
                  if ((functionElement instanceof Field)) {
                    final Field field = ((Field) functionElement);
                    EList<JvmMember> _members_2 = it.getMembers();
                    JvmField _buildField = VoiceDslJvmModelInferrer.this.buildField(field);
                    VoiceDslJvmModelInferrer.this._jvmTypesBuilder.<JvmField>operator_add(_members_2, _buildField);
                  }
                }
              }
            }
          };
        _accept.initializeLater(_function);
      }
    }
  }
  
  /**
   * method definition, starts with 'def' like xtend
   */
  public JvmOperation buildFunction(final Function function) {
    String methodName = function.getName();
    JvmTypeReference methodType = function.getReturnType();
    final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
        public void apply(final JvmOperation it) {
          String _documentation = VoiceDslJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(function);
          VoiceDslJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
          XExpression _expression = function.getExpression();
          VoiceDslJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _expression);
        }
      };
    return this._jvmTypesBuilder.toMethod(function, methodName, methodType, _function);
  }
  
  /**
   * variable/value definition, starts with 'var' or 'val' like xtend
   */
  public JvmField buildField(final Field field) {
    JvmTypeReference _type = field.getType();
    boolean _equals = Objects.equal(_type, null);
    if (_equals) {
      InputOutput.<String>println("type = null");
      return null;
    }
    String _name = field.getName();
    JvmTypeReference _type_1 = field.getType();
    final Procedure1<JvmField> _function = new Procedure1<JvmField>() {
        public void apply(final JvmField it) {
        }
      };
    return this._jvmTypesBuilder.toField(field, _name, _type_1, _function);
  }
  
  public void infer(final EObject voiceDsl, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPrelinkingPhase) {
    if (voiceDsl instanceof VoiceDsl) {
      _infer((VoiceDsl)voiceDsl, acceptor, isPrelinkingPhase);
      return;
    } else if (voiceDsl != null) {
      _infer(voiceDsl, acceptor, isPrelinkingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(voiceDsl, acceptor, isPrelinkingPhase).toString());
    }
  }
}
