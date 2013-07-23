package com.isb.bks.ivr.voice.ui.handlers;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import Generic_BKS.Flow;
import Generic_BKS.State;
import Generic_BKS.SubFlow;

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
			
			

			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource res = rSet.getResource(uri, true);

			Flow flow = (Flow)res.getContents().get(0);

			for (State state:flow.getStates())
			{
				if (state instanceof SubFlow)
				{	
					SubFlow sf = (SubFlow)state;
					Flow flowCC = sf.getCalledFlow();
					String gramma = "El estado " + sf.getName() + " apunta a " + flowCC.getName(); 
					IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
					MessageDialog.openInformation(window.getShell(), "Info", gramma);

				}
			}
			
			URI uri2 = URI.createPlatformResourceURI("/padre/src/main/resources/re42.generic_bks", true);
			
			ResourceSet rSet2 = new ResourceSetImpl();
			rSet2.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER,
					vegaURIHandler);
			Resource res2 = rSet2.getResource(uri2, true);

			if(res2 instanceof XMLResource) {
				
				
				((XMLResource)res2).getDefaultSaveOptions().put(
						XMLResource.OPTION_URI_HANDLER, vegaURIHandler);
			}
			
			try {
				res2.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

}
