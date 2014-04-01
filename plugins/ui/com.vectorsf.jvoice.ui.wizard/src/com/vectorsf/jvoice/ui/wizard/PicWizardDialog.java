package com.vectorsf.jvoice.ui.wizard;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.vectorsf.jvoice.ui.wizard.page.SelectDefinitionWizardPage;

public class PicWizardDialog extends WizardDialog {

	private Button selectButton;
	private Button createButton;

	private static final int CREATE_ID = IDialogConstants.CLIENT_ID + 1;
	private static final int SELECT_ID = IDialogConstants.CLIENT_ID + 2;

	public PicWizardDialog(Shell parentShell, IWizard newWizard) {
		super(parentShell, newWizard);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton = createButton(parent, CREATE_ID, "Create a definition", false);
		selectButton = createButton(parent, SELECT_ID, "Select a definition", false);
		selectButton.setVisible(false);

		((GridLayout) parent.getLayout()).numColumns++;
		Composite composite = new Composite(parent, SWT.NONE);
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false);
		composite.setLayoutData(data);

		super.createButtonsForButtonBar(parent);
	}

	@Override
	public void updateButtons() {
		super.updateButtons();
		IWizardPage currentPage = getCurrentPage();
		boolean select = currentPage instanceof SelectDefinitionWizardPage;

		if (select) {
			selectButton.setVisible(false);
			createButton.setVisible(true);
			createButton.moveAbove(null);
		} else {
			selectButton.setVisible(true);
			createButton.setVisible(false);
			selectButton.moveAbove(null);
		}
		createButton.getParent().layout();
	}

	@Override
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);
		switch (buttonId) {
		case CREATE_ID: {
			backPressed();
			break;
		}
		case SELECT_ID: {
			nextPressed();
			break;
		}

		}
	}
}
