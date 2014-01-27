/**
 * 
 */
package com.vectorsf.jvoice.ui.wizard.page;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.vectorsf.jvoice.ui.wizard.Activator;

/**
 * @author xIS14487
 * 
 */
public class ApplicationNameWizardPage extends AbstractWizardPage {

	private static final String PAGE_DESC = "Enter application name";
	private static final String PAGE_TITLE = "Create an Application";

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;
	private static final int SIZING_TEXT_FIELD_HEIGHT = 50;

	private Text textField;
	private Text descriptionField;

	private Listener nameModifyListener = new Listener() {
		@Override
		public void handleEvent(Event e) {
			boolean valid = validatePage();
			setPageComplete(valid);

		}
	};

	private Listener focusListener = new Listener() {
		@Override
		public void handleEvent(Event e) {
			boolean valid = validatePage();
			setPageComplete(valid);
		}
	};

	public ApplicationNameWizardPage(String pageName, String imagePath) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
		setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, imagePath));
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());

		initializeDialogUnits(parent);

		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createProjectNameGroup(composite);
		createDescriptionGroup(composite);

		setPageComplete(validatePage());

		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(composite);
	}

	public String getText() {
		if (textField == null) {
			return getInitialTextFieldValue();
		}

		return getTextFieldValue();
	}

	protected boolean validatePage() {
		setErrorMessage(null);
		setMessage(null);

		String text = getTextFieldValue();
		if (text.equals("")) { //$NON-NLS-1$
			setMessage("Enter application name");
			return false;
		}

		char initial = text.charAt(0);
		if (Character.isDigit(initial)) {
			setErrorMessage("The first letter of the application name can't be a number.");
			return false;
		}

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		if (root.getProject(text).exists()) {
			setErrorMessage("Application name already exit");
			return false;
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus status = doWorkspaceValidation(workspace, text);
		if (!status.isOK()) {
			setErrorMessage(status.getMessage());
			return false;
		}
		if (!customValidate(text)) {
			return false;
		}

		if (getDescriptionFieldValue().length() == 0) {
			setMessage("The field Description is empty", WARNING);
		}

		return true;
	}

	private boolean customValidate(String text) {
		return ResourcesPlugin.getWorkspace().validateName(text, IResource.PROJECT).isOK();
	}

	private final void createProjectNameGroup(Composite parent) {

		Composite projectGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		projectGroup.setLayout(layout);
		projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// new project label
		Label projectLabel = new Label(projectGroup, SWT.NONE);
		projectLabel.setText("Application name:");
		projectLabel.setFont(parent.getFont());

		textField = new Text(projectGroup, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		textField.setLayoutData(data);
		textField.setFont(parent.getFont());

		Label label = new Label(parent, SWT.LEFT);
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.BEGINNING;
		gd.grabExcessHorizontalSpace = false;
		gd.horizontalSpan = 1;
		gd.horizontalIndent = 0;
		gd.widthHint = 0;
		gd.heightHint = 0;
		label.setLayoutData(gd);

		// Set the initial value first before listener
		// to avoid handling an event during the creation.
		if (getInitialTextFieldValue() != null) {
			textField.setText(getInitialTextFieldValue());
		}
		textField.addListener(SWT.Modify, nameModifyListener);
		textField.addListener(SWT.FocusIn, nameModifyListener);
	}

	private void createDescriptionGroup(Composite composite) {
		Composite descriptionGroup = new Composite(composite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		descriptionGroup.setLayout(layout);
		descriptionGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label projectLabel = new Label(descriptionGroup, SWT.NONE);
		projectLabel.setText("Description:");
		projectLabel.setFont(composite.getFont());

		descriptionField = new Text(descriptionGroup, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		data.heightHint = SIZING_TEXT_FIELD_HEIGHT;
		descriptionField.setLayoutData(data);
		descriptionField.setFont(composite.getFont());

		descriptionField.addListener(SWT.Modify, nameModifyListener);
		descriptionField.addListener(SWT.FocusIn, focusListener);
	}

	private String getTextFieldValue() {
		if (textField == null) {
			return ""; //$NON-NLS-1$
		}

		return textField.getText().trim();
	}

	private String getDescriptionFieldValue() {
		if (descriptionField == null) {
			return ""; //$NON-NLS-1$
		}
		return descriptionField.getText().trim();
	}

	private String getInitialTextFieldValue() {
		return "newApplicationJVoice"; //$NON-NLS-1$
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
		}
	}

	@Override
	public String getDescription() {
		return getDescriptionFieldValue();
	}

	@Override
	protected void createWizardContents(Composite parent) {

	}

	@Override
	public void createResource() throws CoreException {

	}

}