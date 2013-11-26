package com.vectorsf.jvoice.ui.edit.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

public class DialogExecuteBean extends ElementTreeSelectionDialog {

	public DialogExecuteBean(Shell parent, ILabelProvider labelProvider,
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
		super.createButtonsForButtonBar(parent);

	}

	@Override
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);

	}

}
