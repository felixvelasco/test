/**
 */
package com.vectorsf.jvoice.model.operations.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;

/**
 * The <b>Resource Factory</b> associated with the package.
 * 
 * @see com.vectorsf.jvoice.model.operations.util.OperationsResourceImpl
 */
public class OperationsResourceFactoryJVoiceImpl extends OperationsResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * 
	 */
	public OperationsResourceFactoryJVoiceImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 */
	@Override
	public Resource createResource(URI uri) {
		Resource result = new OperationsResourceImpl(uri);
		((XMLResource) result).getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, new VegaXMLURIHandlerImpl());
		return result;
	}
}
