package com.vectorsf.jvoice.ui.navigator.util;

import org.eclipse.core.internal.propertytester.ResourcePropertyTester;

import com.vectorsf.jvoice.model.base.JVProject;

public class ProjectPropertyTester extends ResourcePropertyTester {

	/**
	 * A property indicating whether the project is open (value
	 * <code>"open"</code>).
	 */
	private static final String OPEN = "open"; //$NON-NLS-1$

	@Override
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (receiver instanceof JVProject && method.equals(OPEN)) {
			// Siempre va a devolver true
			return true;
		}
		return false;
	}
}
