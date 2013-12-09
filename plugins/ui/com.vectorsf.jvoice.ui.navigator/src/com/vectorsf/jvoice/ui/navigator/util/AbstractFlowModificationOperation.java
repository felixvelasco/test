package com.vectorsf.jvoice.ui.navigator.util;

import java.io.IOException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;
import com.vectorsf.jvoice.model.operations.Flow;

public abstract class AbstractFlowModificationOperation {

	protected Flow flow;
	private EditingDomain editingDomain;
	private boolean shouldSave;

	protected abstract Command getChangeCommand(EditingDomain domain, Flow persistedFlow);

	public void setOriginalFlow(Flow flow) {
		this.flow = flow;
	}

	public Flow getOriginalFlow() {
		return flow;
	}

	public void saveFlow() throws ExecutionException {
		try {
			URI uri = EcoreUtil.getURI(flow);
			Flow persistedFlow = getModifiableFlow(uri);

			Command command = getChangeCommand(editingDomain, persistedFlow);
			editingDomain.getCommandStack().execute(command);

			if (shouldSave) {
				persistedFlow.eResource().save(null);
			}
		} catch (IOException e) {
			throw new ExecutionException("Error saving " + flow.getName(), e);
		}
	}

	private Flow getModifiableFlow(URI uri) {
		URIEditorInput input = new URIEditorInput(uri);
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findEditor(input);

		if (editor == null || !(editor instanceof IEditingDomainProvider)) {
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
			ResourceSet resourceSet = editingDomain.getResourceSet();
			VegaXMLURIHandlerImpl vegaURIHandler = new VegaXMLURIHandlerImpl();
			resourceSet.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, vegaURIHandler);
			Flow persistedFlow = (Flow) resourceSet.getEObject(uri, true);
			shouldSave = true;

			return persistedFlow;
		} else if (editor instanceof IEditingDomainProvider) {
			IEditingDomainProvider provider = (IEditingDomainProvider) editor;
			editingDomain = provider.getEditingDomain();
			ResourceSet rSet = editingDomain.getResourceSet();
			Flow liveFlow = (Flow) rSet.getEObject(uri, true);
			shouldSave = false;

			return liveFlow;
		}
		return null;
	}
}
