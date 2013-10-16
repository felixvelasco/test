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

import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVPackage;

public class CopyHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Object o = ((IEvaluationContext) event.getApplicationContext())
				.getDefaultVariable();

		if (o instanceof List<?>) {
			Object[] selection = ((List<?>) o).toArray();
			LocalSelectionTransfer.getTransfer().setSelection(
					new StructuredSelection(selection));
			Clipboard clipboard = new Clipboard(null);
			clipboard.setContents(new Object[] { new Object() },
					new Transfer[] { LocalSelectionTransfer.getTransfer() });

		}

		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(getValidTarget(evaluationContext));
	}

	@SuppressWarnings("unchecked")
	private boolean getValidTarget(Object target) {
		Object def = ((IEvaluationContext) target).getDefaultVariable();
		if (def instanceof Collection<?>) {
			boolean paquete = false;
			boolean bean = false;
			Collection<Object> colection = (Collection<Object>) def;

			for (int i = 0; i < colection.toArray().length; i++) {
				Object o = colection.toArray()[i];
				if (o instanceof JVPackage) {
					if (bean) {
						return false;
					} else {
						paquete = true;
					}
				} else if (o instanceof JVBean) {
					if (paquete) {
						return false;
					} else {
						bean = true;
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
