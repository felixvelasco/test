package com.vectorsf.jvoice.core.project;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.EValidator;
import org.osgi.framework.BundleContext;

import com.vectorsf.jvoice.core.validation.OperationsValidator;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.vectorsf.jvoice.core.project"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		EValidator.Registry.INSTANCE.put(OperationsPackage.eINSTANCE, new OperationsValidator());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
}
