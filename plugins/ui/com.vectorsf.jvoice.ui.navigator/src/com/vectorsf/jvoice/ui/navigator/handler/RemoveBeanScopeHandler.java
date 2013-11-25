package com.vectorsf.jvoice.ui.navigator.handler;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;

public class RemoveBeanScopeHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) currentSelection)
					.getFirstElement();
			if (firstElement instanceof ComponentBean) {
				ComponentBean seleccionado = (ComponentBean) firstElement;
				Flow flujo = (Flow) seleccionado.eContainer();
				try {
					removeScopedBean(flujo, seleccionado);
				} catch (IOException e) {
					throw new ExecutionException("Error saving "
							+ flujo.getName(), e);
				}
			}
		}
		return null;
	}

	private void removeScopedBean(Flow flow, ComponentBean bean)
			throws IOException {
		URI uri = EcoreUtil.getURI(flow);
		ResourceSet resourceSet = new ResourceSetImpl();
		VegaXMLURIHandlerImpl vegaURIHandler = new VegaXMLURIHandlerImpl();
		resourceSet.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER,
				vegaURIHandler);
		Flow persistedFlow = (Flow) resourceSet.getEObject(uri, true);

		for (int i = 0; i < persistedFlow.getBeans().size(); i++) {
			ComponentBean miBean = persistedFlow.getBeans().get(i);
			if (miBean.getNameBean().equals(bean.getNameBean())
					&& miBean.getName().equals(bean.getName())
					&& miBean.getFqdn().equals(bean.getFqdn())) {
				persistedFlow.getBeans().remove(i);
				break;
			}
		}
		persistedFlow.eResource().save(null);
	}

}
