package com.vectorsf.jvoice.ui.diagram.properties;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.vectorsf.jvoice.ui.diagram.properties"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		ImageDescriptor imageDown = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,  "/resources/Down.ico");
	    Activator.getDefault().getImageRegistry().put("imageDown", imageDown);
	    ImageDescriptor imageUp = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,  "/resources/Up.ico");
	    Activator.getDefault().getImageRegistry().put("imageUp", imageUp);
	    ImageDescriptor imageAdd = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,  "/resources/Add.ico");
	    Activator.getDefault().getImageRegistry().put("imageAdd", imageAdd);
	    ImageDescriptor imageRemove = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,  "/resources/Remove.ico");
	    Activator.getDefault().getImageRegistry().put("imageRemove", imageRemove);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
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
