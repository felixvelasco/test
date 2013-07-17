package com.isb.bks.ivr.voice.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class SampleHandler extends AbstractHandler {

	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil
				.getCurrentSelection(event);
		Object o = selection.getFirstElement();
		if (o instanceof IFile) {
			IFile file = (IFile) o;

			ResourceSet rSet = new ResourceSetImpl();
			VegaXMLURIHandlerImpl vegaURIHandler = new VegaXMLURIHandlerImpl();
			vegaURIHandler.setFile(file);
			rSet.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER,
					vegaURIHandler);

			URI uri = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource res = rSet.getResource(uri, true);
			res.getContents().get(0);
		}
		return null;
	}

}
