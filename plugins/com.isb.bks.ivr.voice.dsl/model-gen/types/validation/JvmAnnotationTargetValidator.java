/**
 *
 * $Id$
 */
package types.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmAnnotationReference;

/**
 * A sample validator interface for {@link org.eclipse.xtext.common.types.JvmAnnotationTarget}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface JvmAnnotationTargetValidator {
	boolean validate();

	boolean validateAnnotations(EList<JvmAnnotationReference> value);
}
