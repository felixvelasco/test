package com.vectorsf.jvoice.ui.edit.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

public class DialogSubFlow extends ElementTreeSelectionDialog {

	private static boolean createAvailable;

	public DialogSubFlow(Shell parent, ILabelProvider labelProvider,
			ITreeContentProvider contentProvider) {
		super(parent, labelProvider, contentProvider);
	}

	@Override
	protected org.eclipse.jface.viewers.TreeViewer doCreateTreeViewer(
			org.eclipse.swt.widgets.Composite parent, int style) {
		PatternFilter filter = new PatternFilter();
		FilteredTree filteredTree = new FilteredTree(parent, style, filter,
				true);
		return filteredTree.getViewer();

	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		if (isButtonCreatevailable()) {
			createButton(parent, IDialogConstants.PROCEED_ID, "Create", false);
		}
		super.createButtonsForButtonBar(parent);

	}

	public boolean isButtonCreatevailable() {
		return createAvailable;
	}

	public void setIsButtonCreatevailable(boolean buttonAvailable) {
		createAvailable = buttonAvailable;
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (IDialogConstants.PROCEED_ID == buttonId) {
			createPressed();
		} else {
			super.buttonPressed(buttonId);
		}
	}

	protected void createPressed() {
		setReturnCode(IDialogConstants.PROCEED_ID);
		close();
	}

}
