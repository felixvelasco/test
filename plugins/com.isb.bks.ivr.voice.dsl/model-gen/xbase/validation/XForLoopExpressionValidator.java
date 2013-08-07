/**
 *
 * $Id$
 */
package xbase.validation;

import org.eclipse.xtext.common.types.JvmFormalParameter;

import org.eclipse.xtext.xbase.XExpression;

/**
 * A sample validator interface for {@link org.eclipse.xtext.xbase.XForLoopExpression}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface XForLoopExpressionValidator {
	boolean validate();

	boolean validateForExpression(XExpression value);
	boolean validateEachExpression(XExpression value);
	boolean validateDeclaredParam(JvmFormalParameter value);
}
