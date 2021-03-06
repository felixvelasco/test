package com.vectorsf.jvoice.core.prompt;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.vectorsf.jvoice.core.factory.JVBeanFactory;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class PromptFactory implements JVBeanFactory {

	public PromptFactory() {
	}

	@Override
	public VoiceDsl loadBeanFromFile(ResourceSet resourceSet, URI uri) {
		Resource resource = resourceSet.getResource(uri, true);

		for (EObject eobject : resource.getContents()) {
			if (eobject instanceof VoiceDsl) {
				return (VoiceDsl) eobject;
			}
		}
		return null;
	}

	@Override
	public String getNameFromFile(IFile file) {
		return file.getName().replace(".voiceDsl", "");
	}

}
