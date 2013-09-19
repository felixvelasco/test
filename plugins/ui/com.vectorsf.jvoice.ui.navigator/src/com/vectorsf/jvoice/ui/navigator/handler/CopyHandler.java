package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.vectorsf.jvoice.ui.navigator.util.UtilHandler;

public class CopyHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		UtilHandler.Copiar(event);

		return null;
	}
}
