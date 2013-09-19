package com.vectorsf.jvoice.ui.navigator.util;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;

public class UtilHandler {

	public UtilHandler() {
		// Constructor
	}

	public static void Copiar(ExecutionEvent event) {
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

	}

}
