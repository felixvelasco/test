package com.vectorsf.jvoice.diagram.core.pattern.transition;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.vectorsf.jvoice.diagram.core.pattern.transition.messages"; //$NON-NLS-1$
	public static String AddMoreEventFeature_moreEvents;
	public static String AddMoreEventFeature_dialogTitle;
	public static String AddMoreEventFeature_newEvent;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
