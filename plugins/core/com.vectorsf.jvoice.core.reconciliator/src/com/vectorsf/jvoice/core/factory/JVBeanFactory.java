package com.vectorsf.jvoice.core.factory;

import org.eclipse.core.resources.IFile;

import com.vectorsf.jvoice.model.base.JVBean;

public interface JVBeanFactory {

	JVBean loadBeanFromFile(IFile file);

	String getNameFromFile(IFile file);

}
