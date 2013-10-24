package com.vectorsf.jvoice.core.factory;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

import com.vectorsf.jvoice.model.base.JVBean;

public interface JVBeanFactory {

	JVBean loadBeanFromFile(URI uri);

	String getNameFromFile(IFile file);

}
