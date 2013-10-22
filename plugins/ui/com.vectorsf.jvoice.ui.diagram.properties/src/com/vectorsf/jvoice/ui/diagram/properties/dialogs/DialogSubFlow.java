package com.vectorsf.jvoice.ui.diagram.properties.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

public class DialogSubFlow extends ElementTreeSelectionDialog {

	public DialogSubFlow(Shell parent, ILabelProvider labelProvider,
			ITreeContentProvider contentProvider) {
		super(parent, labelProvider, contentProvider);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected org.eclipse.jface.viewers.TreeViewer doCreateTreeViewer(
			org.eclipse.swt.widgets.Composite parent, int style) {
		PatternFilter filter = new PatternFilter();
		FilteredTree filteredTree = new FilteredTree(parent, style,
				filter, true);
		return filteredTree.getViewer();

	}

}
