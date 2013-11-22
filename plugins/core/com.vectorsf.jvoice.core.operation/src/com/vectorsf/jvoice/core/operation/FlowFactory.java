package com.vectorsf.jvoice.core.operation;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.vectorsf.jvoice.core.factory.JVBeanFactory;
import com.vectorsf.jvoice.model.operations.Flow;

public class FlowFactory implements JVBeanFactory {

	public FlowFactory() {
	}

	@Override
	public Flow loadBeanFromFile(ResourceSet resourceSet, URI uri) {
		Resource resource = resourceSet.getResource(uri, true);

		for (EObject eobject : resource.getContents()) {
			if (eobject instanceof Flow) {
				return (Flow) eobject;
			}
		}
		return null;
	}

	@Override
	public String getNameFromFile(IFile file) {
		if (file.exists()) {
			ResourceSet rset = new ResourceSetImpl();
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			return loadBeanFromFile(rset, uri).getName();
		} else {
			return file.getName().replace(".jvflow", "");
		}
	}

}
