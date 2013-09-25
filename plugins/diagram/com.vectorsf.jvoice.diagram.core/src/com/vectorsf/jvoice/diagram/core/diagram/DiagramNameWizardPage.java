package com.vectorsf.jvoice.diagram.core.diagram;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class DiagramNameWizardPage extends AbstractWizardPage {

	private static final String PAGE_DESC = "Enter a diagram name";
	private static final String PAGE_TITLE = "New JVoice Diagram";

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	Text textField;

	private Listener nameModifyListener = new Listener() {
		@Override
		public void handleEvent(Event e) {
			boolean valid = validatePage();
			setPageComplete(valid);

		}
	};

	public DiagramNameWizardPage(String pageName, String title,
			ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	protected DiagramNameWizardPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());

		initializeDialogUnits(parent);

		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createWizardContents(composite);

		setPageComplete(validatePage());

		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(composite);
	}

	@Override
	public String getText() {
		if (textField == null) {
			return getInitialTextFieldValue();
		}

		return getTextFieldValue();
	}

	protected boolean validatePage() {
		String text = getTextFieldValue();
		if (text.equals("")) { //$NON-NLS-1$
			setErrorMessage(null);
			setMessage("Message empty");
			return false;
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus status = doWorkspaceValidation(workspace, text);
		if (!status.isOK()) {
			setErrorMessage(status.getMessage());
			return false;
		}

		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	@Override
	protected void createWizardContents(Composite parent) {
		createProjectNameGroup(parent);
	}

	private final void createProjectNameGroup(Composite parent) {
		// project specification group
		Composite projectGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		projectGroup.setLayout(layout);
		projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// new project label
		Label projectLabel = new Label(projectGroup, SWT.NONE);
		projectLabel.setText("Diagram name:");
		projectLabel.setFont(parent.getFont());

		// new project name entry field
		textField = new Text(projectGroup, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		textField.setLayoutData(data);
		textField.setFont(parent.getFont());

		// Set the initial value first before listener
		// to avoid handling an event during the creation.
		if (getInitialTextFieldValue() != null) {
			textField.setText(getInitialTextFieldValue());
		}
		textField.addListener(SWT.Modify, nameModifyListener);
	}

	private String getTextFieldValue() {
		if (textField == null) {
			return ""; //$NON-NLS-1$
		}

		return textField.getText().trim();
	}

	private String getInitialTextFieldValue() {
		return "newJVoice"; //$NON-NLS-1$
	}

	private IStatus doWorkspaceValidation(IWorkspace workspace, String text) {
		IStatus ret = workspace.validateName(text, IResource.FILE);
		return ret;
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			textField.setFocus();
			textField.selectAll();
		}
	}
}