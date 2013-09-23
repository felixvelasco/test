package com.isb.bks.ivr.voice.dsl.jvmmodel

import com.google.inject.Inject
import com.vectorsf.jvoice.prompt.model.voiceDsl.Class
import com.vectorsf.jvoice.prompt.model.voiceDsl.Field
import com.vectorsf.jvoice.prompt.model.voiceDsl.Function
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl
import org.eclipse.emf.common.util.EList
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class VoiceDslJvmModelInferrer extends AbstractModelInferrer {

  @Inject extension JvmTypesBuilder
  
  def dispatch void infer(VoiceDsl voiceDsl, IJvmDeclaredTypeAcceptor acceptor,  boolean isPrelinkingPhase) {
      for (classElement : voiceDsl.types) {
      	if (classElement instanceof Class) {
      	  val Class clase=classElement as Class
      	  acceptor.accept(clase.toClass("example1.main")).initializeLater [
            documentation = clase.documentation
//            var JvmParameterizedTypeReference ext = clase.getExtends()
//            if (ext!=null && superTypes!=null) {
//               superTypes += ext.cloneWithProxies
//            }
//            var EList<JvmParameterizedTypeReference> imps = clase.getImplements()
//            for (imp:imps){
//            	superTypes += imp.cloneWithProxies
//            }
            for (functionElement : clase.members) {
               if (functionElement instanceof Function) {
                  val Function function=functionElement as Function
                   members += buildFunction(function)
               }
               if (functionElement instanceof Field) {
                  val Field field=functionElement as Field
                  members += buildField(field)
               }
            }
        ]
        }
      }
  }

 

    /**
     * method definition, starts with 'def' like xtend
     */
    def JvmOperation buildFunction(Function function){
      var String methodName = function.name;
      var JvmTypeReference methodType = function.returnType
  	  return function.toMethod(methodName,methodType) [
        documentation = function.documentation
        body = function.expression	
      ]
  	}
 

    /**
     * variable/value definition, starts with 'var' or 'val' like xtend
     */
    def JvmField buildField(Field field){
      if (field.type == null) {
      	println("type = null")
      	return null;
      }
  	  return field.toField(field.name,field.type) []
  	}

}

