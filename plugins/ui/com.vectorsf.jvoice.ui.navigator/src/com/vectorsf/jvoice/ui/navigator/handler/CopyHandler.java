package com.vectorsf.jvoice.ui.navigator.handler;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;

import com.vectorsf.jvoice.model.base.Configuration;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVPackage;

public class CopyHandler extends AbstractHandler {

	private enum KnownElements {
		PACKAGE, BEAN, CONFIGURATION
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Object o = ((IEvaluationContext) event.getApplicationContext()).getDefaultVariable();

		if (o instanceof List<?>) {
			Object[] selection = ((List<?>) o).toArray();
			LocalSelectionTransfer.getTransfer().setSelection(new StructuredSelection(selection));
			Clipboard clipboard = new Clipboard(null);
			clipboard.setContents(new Object[] { new Object() },
					new Transfer[] { LocalSelectionTransfer.getTransfer() });

		}

		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(isValid(evaluationContext));
	}

	private boolean isValid(Object target) {
		Object def = ((IEvaluationContext) target).getDefaultVariable();
		if (def instanceof Collection<?>) {
			Collection<?> colection = (Collection<?>) def;
			KnownElements current = null;

			for (Object o : colection) {
				if (o instanceof JVPackage) {
					if (current != null && current != KnownElements.PACKAGE) {
						return false;
					} else {
						current = KnownElements.PACKAGE;
					}
				} else if (o instanceof JVBean) {
					if (current != null && current != KnownElements.BEAN) {
						return false;
					} else {
						current = KnownElements.BEAN;
					}
				} else if (o instanceof Configuration) {
					if (current != null && current != KnownElements.CONFIGURATION) {
						return false;
					} else {
						current = KnownElements.CONFIGURATION;
					}
				} else {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
