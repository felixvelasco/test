package com.vectorsf.jvoice.core.operation;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.core.factory.JVBeanFactory;
import com.vectorsf.jvoice.model.operations.Flow;

public class FlowFactory implements JVBeanFactory {

	public FlowFactory() {
	}

	@Override
	public Flow loadBeanFromFile(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		ResourceSet resourceSet = BaseModel.getInstance().getResourceSet();
		Resource resource = resourceSet.getResource(uri, false);
		if (resource == null) {
			resource = resourceSet.getResource(uri, true);
		}

		for (EObject eobject : resource.getContents()) {
			if (eobject instanceof Flow) {
				return (Flow) eobject;
			}
		}
		return null;
	}

	@Override
	public String getNameFromFile(IFile file) {
		return file.getName().replace(".jvflow", "");
	}

}
