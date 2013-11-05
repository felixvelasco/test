package com.vectorsf.jvoice.diagram.core.features;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class CoreImageProvider extends AbstractImageProvider {

	// States
	public static final String IMG_TRANSACTION_PAD = "transition_pad"; //$NON-NLS-1$

	public static final String IMG_RELATION_PAD = "relation_pad"; //$NON-NLS-1$

	@Override
	protected void addAvailableImages() {

		addImageFilePath(IMG_TRANSACTION_PAD, "icons/transition.gif"); //$NON-NLS-1$
		addImageFilePath(IMG_RELATION_PAD, "icons/relation.gif"); //$NON-NLS-1$
	}

}
