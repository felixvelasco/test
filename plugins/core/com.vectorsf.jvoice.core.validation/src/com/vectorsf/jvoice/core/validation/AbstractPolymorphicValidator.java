/**
 * 
 */
package com.vectorsf.jvoice.core.validation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.parsley.runtime.util.PolymorphicDispatcher;
import org.eclipse.emf.parsley.runtime.util.PolymorphicDispatcher.ErrorHandler;

import com.google.common.base.Predicate;

public abstract class AbstractPolymorphicValidator extends EObjectValidator {

	public class ValidationErrorHandler implements ErrorHandler<Boolean> {

		@Override
		public Boolean handle(Object[] params, Throwable throwable) {
			error((EObject) params[0], "Error during validation, please see the error log", throwable);
			return false;
		}

	}

	public class ValidatorErrorHandler implements ErrorHandler<Boolean> {

		@Override
		public Boolean handle(Object[] params, Throwable throwable) {
			EClass eclass = (EClass) params[0];
			error(eclass, "Error obtaining validator for " + eclass.getName() + ", please see the error log", throwable);
			return false;
		}

	}

	private PolymorphicDispatcher.ErrorHandler<Boolean> errorValidatingHandler = new ValidationErrorHandler();
	private PolymorphicDispatcher.ErrorHandler<Boolean> errorValidatorHandler = new ValidatorErrorHandler();
	private DiagnosticChain currentDiagnostic;

	@Override
	public final boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return super.validate(eClass, eObject, diagnostics, context)
				&& hierarchicalValidate(eClass, eObject, diagnostics);
	}

	private boolean hierarchicalValidate(EClass eClass, EObject eObject, DiagnosticChain diagnostics) {
		boolean ret = polymorphicValidate(eClass, eObject, diagnostics);

		for (EClass eSuperClass : eClass.getESuperTypes()) {
			ret &= hierarchicalValidate(eSuperClass, eObject, diagnostics);
		}
		return ret;
	}

	private boolean polymorphicValidate(EClass eClass, EObject eObject, DiagnosticChain diagnostics) {
		Object polymorphicValidator = getPolymorphicValidator(eClass);
		if (polymorphicValidator != null) {
			PolymorphicDispatcher<Boolean> dispatcher = new PolymorphicDispatcher<Boolean>(
					Collections.singletonList(polymorphicValidator), getValidatePredicate(eClass),
					errorValidatingHandler) {
				@Override
				protected Boolean handleNoSuchMethod(Object... params) {
					return Boolean.TRUE;
				}

				@Override
				protected Boolean handleAmbigousMethods(List<PolymorphicDispatcher<Boolean>.MethodDesc> result,
						Object... params) {
					boolean acum = true;
					for (MethodDesc current : result) {
						try {
							current.getMethod().setAccessible(true);
							acum &= (Boolean) current.getMethod().invoke(current.getTarget(), params);
						} catch (InvocationTargetException e) {
							if (e.getTargetException() instanceof Error) {
								throw (Error) e.getTargetException();
							}
							return errorValidatingHandler.handle(params, e.getTargetException());
						} catch (IllegalArgumentException e) {
							return errorValidatingHandler.handle(params, e);
						} catch (IllegalAccessException e) {
							return errorValidatingHandler.handle(params, e);
						}
					}
					return acum;
				}
			};

			this.currentDiagnostic = diagnostics;
			Boolean invoke = dispatcher.invoke(eObject);
			this.currentDiagnostic = null;
			return invoke;
		} else {
			return true;
		}
	}

	private Object getPolymorphicValidator(EClass eClass) {
		PolymorphicDispatcher<Boolean> dispatcher = new PolymorphicDispatcher<Boolean>(Collections.singletonList(this),
				getValidatorPredicate(eClass), errorValidatorHandler) {

			@Override
			protected Boolean handleNoSuchMethod(Object... params) {
				return Boolean.TRUE;
			}

		};

		Object invoke = dispatcher.invoke();
		return invoke;
	}

	private Predicate<Method> getValidatePredicate(EClass eClass) {
		String methodName = "validate_" + eClass.getName() + "_";
		return new PartialMethodNameFilter(methodName, 1, 1);
	}

	private Predicate<Method> getValidatorPredicate(EClass eClass) {
		String methodName = "get" + eClass.getName() + "Validator";
		return new PolymorphicDispatcher.MethodNameFilter(methodName, 0, 0);
	}

	public void error(EObject eobject, String message) {
		currentDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, EcoreUtil.getURI(eobject).toPlatformString(true),
				-1, message, new Object[] { eobject }));
	}

	public void error(EObject eobject, String message, Throwable t) {
		currentDiagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, EcoreUtil.getURI(eobject).toPlatformString(true),
				-1, message, new Object[] { eobject, t }));
	}

	public void warning(EObject eobject, String message) {
		currentDiagnostic.add(new BasicDiagnostic(Diagnostic.WARNING, EcoreUtil.getURI(eobject).toPlatformString(true),
				-1, message, new Object[] { eobject }));
	}

	public static class PartialMethodNameFilter implements Predicate<Method> {

		protected final int maxParams;

		protected final String methodName;

		protected final int minParams;

		public PartialMethodNameFilter(String methodName, int minParams, int maxParams) {
			this.maxParams = maxParams;
			this.methodName = methodName;
			this.minParams = minParams;
		}

		@Override
		public boolean apply(Method param) {
			return param.getName().startsWith(methodName) && param.getParameterTypes().length >= minParams
					&& param.getParameterTypes().length <= maxParams;
		}

		@Override
		public String toString() {
			return "'" + methodName + "'";
		}

		public int getMaxParams() {
			return maxParams;
		}

		public int getMinParams() {
			return minParams;
		}
	}
}
