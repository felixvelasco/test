package com.vectorsf.jvoice.ui.navigator.handler;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;

public class PasteHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Clipboard clip = new Clipboard(Display.getCurrent());
		Object contents = clip
				.getContents(LocalSelectionTransfer.getTransfer());
		if (contents == null) {
			return null;
		}

		List toPaste = ((IStructuredSelection) contents).toList();

		for (int i = 0; i < toPaste.size(); i++) {
			System.out.println("to pasteeee " + toPaste.get(i).toString());
		}

		return null;
	}

}
