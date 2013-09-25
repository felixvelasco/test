package com.vectorsf.jvoice.core.uri;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.base.model.service.JVModelLifecycleListener;

public class URIListener implements JVModelLifecycleListener {

	public URIListener() {
	}

	@Override
	public void modelCreated(BaseModel baseModel) {
		ResourceSet resourceSet = BaseModel.getInstance().getResourceSet();
		VegaXMLURIHandlerImpl vegaURIHandler = new VegaXMLURIHandlerImpl();
		resourceSet.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER,
				vegaURIHandler);
		
	}

}
	