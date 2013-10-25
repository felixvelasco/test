package com.vectorsf.jvoice.model.operations.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;

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
		if (eObject instanceof JVElement) {
			return ((JVElement) eObject).getId();
		} else {
			return null;
		}
	}

	@Override
	public void setID(EObject eObject, String id) {
		if (eObject instanceof JVElement) {
			((JVElement) eObject).setId(id);
		}
	}

	@Override
	protected XMLHelper createXMLHelper() {
		return new XMIHelperImpl(this) {
			@Override
			public String getID(EObject obj) {
				return null;
			}
		};
	}
}
