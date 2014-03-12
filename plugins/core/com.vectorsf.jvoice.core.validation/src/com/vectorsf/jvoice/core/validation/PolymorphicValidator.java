package com.vectorsf.jvoice.core.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public interface PolymorphicValidator {

	public abstract boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context);

	public abstract void error(EObject eobject, String message);

	public abstract void error(EObject eobject, String message, Throwable t);

	public abstract void warning(EObject eobject, String message);

}