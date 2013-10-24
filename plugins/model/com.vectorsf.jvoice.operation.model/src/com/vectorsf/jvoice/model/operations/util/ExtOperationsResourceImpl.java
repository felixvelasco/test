package com.vectorsf.jvoice.model.operations.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;
import com.vectorsf.jvoice.model.base.JVElement;

public class ExtOperationsResourceImpl extends OperationsResourceImpl implements XMLResource {

	public ExtOperationsResourceImpl(URI uri) {
		super(uri);

		getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, new VegaXMLURIHandlerImpl());
	}

	@Override
	protected boolean useUUIDs() {
		return true;
	}

	@Override
	public String getID(EObject eObject) {
		return super.getID(eObject);
	}

	@Override
	public void setID(EObject eObject, String id) {
		if (eObject instanceof JVElement) {
			((JVElement) eObject).setId(id);
		}
	}
}
