package com.vectorsf.jvoice.ui.edit.dialogs;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.vectorsf.jvoice.ui.navigator.activator.Activator;

public class DialogLocution extends FilteredItemsSelectionDialog {

	private static final String DIALOG_SETTINGS = "FilteredResourcesSelectionDialogExampleSettings";
	private List<?> resources;
	private static boolean createAvailable;

	public DialogLocution(Shell shell) {
		super(shell);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		if (isButtonCreateAvailable()) {
			createButton(parent, IDialogConstants.PROCEED_ID, "Create", false);
		}
		super.createButtonsForButtonBar(parent);
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (IDialogConstants.PROCEED_ID == buttonId) {
			setReturnCode(IDialogConstants.PROCEED_ID);
			close();
		}
		super.buttonPressed(buttonId);
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings()
				.getSection(DIALOG_SETTINGS);
		if (settings == null) {
			settings = Activator.getDefault().getDialogSettings()
					.addNewSection(DIALOG_SETTINGS);
		}
		return settings;
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected ItemsFilter createFilter() {
		return new ItemsFilter() {
			@Override
			public boolean matchItem(Object item) {
				return matches(item.toString());
			}

			@Override
			public boolean isConsistentItem(Object item) {
				return true;
			}
		};
	}

	@Override
	protected Comparator<Object> getItemsComparator() {
		return new Comparator<Object>() {
			@Override
			public int compare(Object arg0, Object arg1) {
				return arg0.toString().compareTo(arg1.toString());
			}
		};
	}

	@Override
	public String getElementName(Object item) {
		return item.toString();
	}

	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {
		progressMonitor.beginTask("Searching", resources.size()); //$NON-NLS-1$
		for (Iterator<?> iter = resources.iterator(); iter.hasNext();) {
			contentProvider.add(iter.next(), itemsFilter);
			progressMonitor.worked(1);
		}
		progressMonitor.done();

	}

	public void setResources(List<?> locutionResources) {
		resources = locutionResources;

	}

	public boolean isButtonCreateAvailable() {
		return createAvailable;
	}

	public void setButtonCreateAvailable(boolean buttonAvailable) {
		createAvailable = buttonAvailable;
	}
}
