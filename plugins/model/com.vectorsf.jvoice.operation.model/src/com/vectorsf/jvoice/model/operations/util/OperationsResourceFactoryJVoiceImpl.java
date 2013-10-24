/**
 */
package com.vectorsf.jvoice.model.operations.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;

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
	public XMLResource createResource(URI uri) {
		XMLResource result = new ExtOperationsResourceImpl(uri);
		return result;
	}
}
