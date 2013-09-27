package com.vectorsf.jvoice.ui.navigator.util;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;

public class Submenujvoices extends Action {

	private IWorkbenchWindow window;

	private static final String PROJECT_JVOICES = "Project JVoices";//$NON-NLS-1$

	public Submenujvoices() {
		this(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
	}

	public Submenujvoices(IWorkbenchWindow window) {
		super(IDEWorkbenchMessages.NewProjectAction_text);
		if (window == null) {
			throw new IllegalArgumentException();
		}
		this.window = window;
		// ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
		// setImageDescriptor(images
		// .getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
		// setDisabledImageDescriptor(images
		// .getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD_DISABLED));
		setToolTipText(PROJECT_JVOICES);
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(this, PROJECT_JVOICES);
	}

}
