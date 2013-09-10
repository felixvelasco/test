package com.vectorsf.jvoice.diagram.core;

import org.eclipse.equinox.log.ExtendedLogService;
import org.eclipse.equinox.log.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.vectorsf.jvoice.diagram.core"; //$NON-NLS-1$
	public static final String EQUINOX_LOGGER_NAME = "org.eclipse.equinox.logger"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	private static Logger logger;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		ServiceTracker<ExtendedLogService, ExtendedLogService> logServiceTracker = new ServiceTracker<ExtendedLogService, ExtendedLogService>(
				context, ExtendedLogService.class.getName(), null);
		logServiceTracker.open();
		ExtendedLogService logservice = logServiceTracker.getService();

		if (logservice != null) {
			logger = logservice.getLogger(EQUINOX_LOGGER_NAME);
		}

	}

	/**
	 * @return logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
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
