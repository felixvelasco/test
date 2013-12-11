/**
 * 
 */
package com.vectorsf.jvoice.core.validation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.parsley.runtime.util.PolymorphicDispatcher;

import com.google.common.base.Predicate;

public abstract class AbstractPolymorphicValidator extends EObjectValidator {

	private PolymorphicDispatcher.ErrorHandler<Boolean> errorHandler = new PolymorphicDispatcher.NullErrorHandler<Boolean>();

	@Override
	public final boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return super.validate(eClass, eObject, diagnostics, context)
				&& hierarchicalValidate(eClass, eObject, diagnostics);
	}

	private boolean hierarchicalValidate(EClass eClass, EObject eObject, DiagnosticChain diagnostics) {
		boolean ret = polymorphicValidate(eClass, eObject, diagnostics);

		for (EClass eSuperClass : eClass.getESuperTypes()) {
			ret &= polymorphicValidate(eSuperClass, eObject, diagnostics);
		}
		return ret;
	}

	private boolean polymorphicValidate(EClass eClass, EObject eObject, DiagnosticChain diagnostics) {
		PolymorphicDispatcher<Boolean> dispatcher = new PolymorphicDispatcher<Boolean>(Collections.singletonList(this),
				getValidatePredicate(eClass), errorHandler) {
			@Override
			protected Boolean handleNoSuchMethod(Object... params) {
				if (PolymorphicDispatcher.NullErrorHandler.class.equals(errorHandler.getClass())) {
					return true;
				}
				return super.handleNoSuchMethod(params);
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
						return errorHandler.handle(params, e.getTargetException());
					} catch (IllegalArgumentException e) {
						return errorHandler.handle(params, e);
					} catch (IllegalAccessException e) {
						return errorHandler.handle(params, e);
					}
				}
				return acum;
			}
		};

		return dispatcher.invoke(eObject, diagnostics);
	}

	private Predicate<Method> getValidatePredicate(EClass eClass) {
		String methodName = "validate_" + eClass.getName() + "_";
		return new PartialMethodNameFilter(methodName, 2, 2);
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
