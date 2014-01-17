package com.vectorsf.jvoice.ui.navigator.util;

import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.actions.ContextualLaunchAction;

/**
 * Specialization of <code>ContextualLaunchAction</code> for the run mode
 * 
 * @see {@link ContextualLaunchAction}
 */
public class RunContextualLaunchAction extends ContextualLaunchAction {

	/**
	 * Constructor
	 */
	public RunContextualLaunchAction() {
		super(ILaunchManager.RUN_MODE);
	}
}
