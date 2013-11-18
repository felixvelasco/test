/**
 */
package com.vectorsf.jvoice.core.reconciliator.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * The <b>Resource Factory</b> associated with the package.
 * 
 * @see com.vectorsf.jvoice.model.operations.util.OperationsResourceImpl
 */
public class ReconciliableResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * 
	 */
	public ReconciliableResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 */
	@Override
	public XMLResource createResource(URI uri) {
		XMLResource result = new ReconciliableResource(uri);
		return result;
	}
}
