/**
 */
package com.vectorsf.jvoice.model.operations.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the
 * package. <!-- end-user-doc -->
 * 
 * @see com.vectorsf.jvoice.model.operations.util.OperationsResourceImpl
 * @generated
 */
public class OperationsResourceFactoryJVoiceImpl extends
		OperationsResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationsResourceFactoryJVoiceImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Resource createResource(URI uri) {
		Resource result = new OperationsResourceImpl(uri);
		((XMLResource) result).getDefaultSaveOptions().put(
				XMLResource.OPTION_URI_HANDLER, new VegaXMLURIHandlerImpl());
		return result;
	}
} // OperationsResourceFactoryImpl
