package com.vectorsf.jvoice.ui.navigator.util;

import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.actions.ContextualLaunchAction;

/**
 * Specialization of <code>ContextualLaunchAction</code> for the run mode
 * 
 * @see {@link ContextualLaunchAction}
 */
public class DebugContextualLaunchAction extends ContextualLaunchAction {

	/**
	 * Constructor
	 */
	public DebugContextualLaunchAction() {
		super(ILaunchManager.DEBUG_MODE);
	}
}
