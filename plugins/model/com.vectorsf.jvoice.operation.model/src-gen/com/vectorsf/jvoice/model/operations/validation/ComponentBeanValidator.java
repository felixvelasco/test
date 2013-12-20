/**
 *
 * $Id$
 */
package com.vectorsf.jvoice.model.operations.validation;


/**
 * A sample validator interface for {@link com.vectorsf.jvoice.model.operations.ComponentBean}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ComponentBeanValidator {
	boolean validate();

	boolean validateFqdn(String value);
	boolean validateNameBean(String value);
	boolean validatePrototype(boolean value);
}
