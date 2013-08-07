/**
 *
 * $Id$
 */
package voiceDsl.validation;

import voiceDsl.Condition;

/**
 * A sample validator interface for {@link voiceDsl.ConditionalAudio}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ConditionalAudioValidator {
	boolean validate();

	boolean validateCondition(Condition value);
}
