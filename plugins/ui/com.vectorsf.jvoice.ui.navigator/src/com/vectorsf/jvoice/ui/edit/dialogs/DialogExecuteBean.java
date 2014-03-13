package com.vectorsf.jvoice.ui.edit.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

import com.vectorsf.jvoice.model.operations.ComponentBean;

public class DialogExecuteBean extends ElementTreeSelectionDialog {

	private ComponentBean segment = null;

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
		TreeViewer fViewer = filteredTree.getViewer();

		fViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				setProperResult(((ITreeSelection) event.getSelection())
						.getPaths());
			}

		});

		return fViewer;
	}

	private void setProperResult(TreePath[] treePaths) {
		for (TreePath treePath : treePaths) {
			for (int i = 0; i < treePath.getSegmentCount(); i++) {
				if (treePath.getSegment(i) instanceof ComponentBean) {
					segment = (ComponentBean) treePath.getSegment(i);
				}
			}

		}

	}

	@Override
	public Object[] getResult() {
		Object[] result = new Object[2];
		Object[] superResult = super.getResult();
		if (superResult.length > 0) {
			result[0] = superResult[0];
		}

		result[1] = segment;
		return result;
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
