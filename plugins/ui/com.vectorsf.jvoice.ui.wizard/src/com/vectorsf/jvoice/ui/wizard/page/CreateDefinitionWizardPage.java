package com.vectorsf.jvoice.ui.wizard.page;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.vectorsf.jvoice.core.operation.helper.FlowService;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.ui.wizard.Activator;
import com.vectorsf.jvoice.ui.wizard.create.CreateDefinitionWizard;

public class CreateDefinitionWizardPage extends WizardPage {

	private static final String PAGE_DESC = "Select definition type";
	private static final String PAGE_TITLE = "Create definition";

	private Button textualButton;
	private Button programmaticButton;
	private SelectionListener buttonsSelectionListener;

	private Text nameText;
	private Flow flow;
	private CreateDefinitionWizard wizard;

	public CreateDefinitionWizardPage(CreateDefinitionWizard wizard, Flow flow) {
		super(PAGE_TITLE);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
		setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "res/wizban/icon_wiz_locution.png"));
		buttonsSelectionListener = new RadioSelectionListener();
		this.flow = flow;
		this.wizard = wizard;
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		GridData gd = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(gd);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		composite.setLayout(layout);
		{
			// Element name label
			Label selectTypeLabel = new Label(composite, SWT.NONE);
			selectTypeLabel.setText("State name:");
			selectTypeLabel.setFont(parent.getFont());
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			data.horizontalSpan = 2;
			selectTypeLabel.setLayoutData(data);

			nameText = new Text(composite, SWT.BORDER);
			nameText.setText("state");
			data = new GridData(GridData.FILL_HORIZONTAL);
			data.horizontalSpan = 2;
			nameText.setLayoutData(data);
			nameText.setFont(parent.getFont());
			nameText.addModifyListener(new ModifyListener() {

				@Override
				public void modifyText(ModifyEvent e) {
					validatePage();
				}
			});
		}

		{
			// Textual radio button
			textualButton = new Button(composite, SWT.RADIO);
			textualButton.setText("Textual");
			textualButton.setSelection(true);
			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
			data.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
			textualButton.setLayoutData(data);
			textualButton.setFont(parent.getFont());
			textualButton.addSelectionListener(buttonsSelectionListener);

			// Programmable ratio button
			programmaticButton = new Button(composite, SWT.RADIO);
			programmaticButton.setText("Programmable");
			data = new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_BEGINNING);
			data.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
			programmaticButton.setLayoutData(data);
			programmaticButton.setFont(parent.getFont());
			programmaticButton.addSelectionListener(buttonsSelectionListener);
		}

		validatePage();

		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(composite);
	}

	private void validatePage() {
		String text = nameText.getText();
		boolean valid = isValidName(text);
		if (isTextual()) {
			valid &= isValidTextualName(text);
		} else {
			valid &= isValidMethodName(text);
		}
		setPageComplete(valid);
	}

	public boolean isTextual() {
		return wizard.isTextual();
	}

	private boolean isValidName(String text) {

		if (text.isEmpty()) {
			setErrorMessage(null);
			setMessage("Enter a definition name");
			return false;
		}

		char initial = text.charAt(0);
		if (Character.isDigit(initial)) {
			setErrorMessage("The definition cannot begin with a number.");
			return false;
		}
		if (!Character.isJavaIdentifierStart(initial)) {
			setErrorMessage("The first character of the definition is not valid.");
			return false;
		}
		for (int i = 1; i < text.length(); i++) {
			char c = text.charAt(i);
			if (!Character.isJavaIdentifierPart(c)) {
				setErrorMessage("Definition contains incorrect character '" + c + "'");
				return false;
			}
		}

		if (text.indexOf(' ') != -1) {
			setErrorMessage("The name of the definition cannot contain spaces.");
			return false;
		}

		isValidTextualName(text);

		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	private boolean isValidTextualName(String text) {
		IStatus status = ResourcesPlugin.getWorkspace().validateName(text, IResource.FILE);
		if (!status.isOK()) {
			setErrorMessage(status.getMessage());
			return false;
		}

		IFile file = findLocutionFolder().getFile(text + ".voiceDsl");

		if (file.exists()) {
			setErrorMessage("Definition already exists");
			return false;
		}
		// setErrorMessage(null);
		setMessage(null);
		return true;
	}

	private boolean isValidMethodName(String text) {
		try {
			for (IMethod method : FlowService.getHelperType(flow).getMethods()) {
				if (method.getParameterTypes().length == 0 && method.getElementName().equals(text)) {
					setErrorMessage("There already exists a method called '" + method.getElementName() + "'.");
					return false;
				}
			}
		} catch (JavaModelException e) {
			return true;
		}
		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	private IFolder findLocutionFolder() {
		// Creado desde el diagrama
		IResource res = (IResource) Platform.getAdapterManager().getAdapter(flow, IResource.class);
		IFolder packageFolder = (IFolder) res.getParent();
		IFolder dslFolder = packageFolder.getFolder(flow.getName() + ".resources");

		return dslFolder;
	}

	public class RadioSelectionListener implements SelectionListener {

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (e.getSource() == textualButton && textualButton.getSelection()) {
				wizard.setTextual(true);

			} else if (e.getSource() == programmaticButton && programmaticButton.getSelection()) {
				wizard.setTextual(false);
			}
			validatePage();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}

	}

	public String getDefinitionName() {
		return nameText.getText();

	}

	public void setTextual(boolean textual) {
		if (textual && programmaticButton.getSelection()) {
			textualButton.setSelection(true);
			programmaticButton.setSelection(false);
		} else if (!textual && textualButton.getSelection()) {
			textualButton.setSelection(false);
			programmaticButton.setSelection(true);
		}
	}

}
