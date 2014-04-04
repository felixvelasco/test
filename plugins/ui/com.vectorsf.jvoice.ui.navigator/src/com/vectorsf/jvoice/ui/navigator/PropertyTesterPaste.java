/**
 * 
 */
package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;

/**
 * @author PORTATIL20
 * 
 */
public class PropertyTesterPaste extends PropertyTester {
	public static final String PROPERTY_CLIPBOARD = "ClipboardType";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 * java.lang.Object)
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		if (!PROPERTY_CLIPBOARD.equals(property) && expectedValue instanceof String) {
			return false;
		}

		Clipboard clip = new Clipboard(Display.getCurrent());
		Object contents = clip.getContents(LocalSelectionTransfer.getTransfer());
		clip.dispose();

		return checkListClass(contents, (String) expectedValue);
	}

	private boolean checkListClass(Object contents, String className) {

		// Todos los elementos deben ser navegaciones
		if (contents instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) contents;
			if (selection.isEmpty()) {
				return false;
			}
			for (Object o : selection.toList()) {
				if (!checkObjectClass(o, className)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private boolean checkObjectClass(Object object, String className) {
		Class<?> clazz = object.getClass();
		if (clazz.getName().equals(className)) {
			return true;
		}
		for (Class<?> ifz : clazz.getInterfaces()) {
			if (ifz.getName().equals(className)) {
				return true;
			}
		}

		Class<?> superclass = clazz.getSuperclass();
		if (superclass == null) {
			return false;
		} else {
			return checkObjectClass(superclass, className);
		}
	}

}
