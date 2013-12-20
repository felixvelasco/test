/**
 *
 * $Id$
 */
package com.vectorsf.jvoice.model.operations.validation;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.vectorsf.jvoice.model.operations.ParameterizedState}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ParameterizedStateValidator {
	boolean validate();

	boolean validateParameters(EList<String> value);
}
