package com.isb.bks.ivr.voice.ui.handlers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;

public class VegaXMLURIHandlerImpl implements URIHandler {

	private URI baseUri;

	@Override
	public void setBaseURI(URI uri) {
		this.baseUri = uri;
	}

	@Override
	public URI resolve(URI uri) {
		System.out.println("Resolve " + uri + " contra " + baseUri);
		return uri.resolve(baseUri);
	}

	@Override
	public URI deresolve(URI uri) {
		System.out.print("Deresolve ");
		System.out.println(uri);
		return baseUri.deresolve(uri);
	}

}
