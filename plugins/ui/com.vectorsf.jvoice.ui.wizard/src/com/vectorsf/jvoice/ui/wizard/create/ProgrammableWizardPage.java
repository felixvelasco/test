package com.vectorsf.jvoice.ui.wizard.create;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.vectorsf.jvoice.ui.wizard.Activator;

public class ProgrammableWizardPage extends WizardPage {

	private static final String PAGE_DESC = "Select definition type";
	private static final String PAGE_TITLE = "Select type";

	public static final String TEXTUAL = "TextualDefinition";
	public static final String PROGRAMMABLE = "ProgrammableDefinition";

	private String mode;

	public ProgrammableWizardPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
		setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "res/wizban/icon_wiz_locution.png"));
	}

	@Override
	public IWizardPage getNextPage() {
		return getWizard().getPage(mode);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Dsl label
		Label selectTypeLabel = new Label(composite, SWT.NONE);
		selectTypeLabel.setText("HOLA!!!");
		selectTypeLabel.setFont(parent.getFont());
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		selectTypeLabel.setLayoutData(data);

		setPageComplete(false);

		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(composite);
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
}
