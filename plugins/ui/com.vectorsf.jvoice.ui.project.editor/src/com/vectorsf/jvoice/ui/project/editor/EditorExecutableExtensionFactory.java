package com.vectorsf.jvoice.ui.project.editor;

import org.osgi.framework.Bundle;

import org.eclipse.emf.parsley.EmfParsleyExtensionFactory;
import org.eclipse.emf.parsley.EmfParsleyGuiceModule;

import com.google.inject.Injector;

public class EditorExecutableExtensionFactory extends
		EmfParsleyExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return EditorActivator.getDefault().getBundle();
	}

	@Override
	protected EmfParsleyGuiceModule getModule() {
		return EditorActivator.getDefault().createModule();
	}

	@Override
	protected Injector getInjector() {
		return EditorActivator.getDefault().getInjector();
	}
}
