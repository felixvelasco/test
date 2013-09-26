/**
 * 
 */
package com.vectorsf.jvoice.ui.wizard.Wizards;


import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;



/**
 * @author xIS14487
 *
 */
public class ProjectNameWizardPage extends AbstractWizardPage {

	private static final String PAGE_DESC = "Enter a Project name";
	private static final String PAGE_TITLE = "New JVoice Project";



	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	private Text textField;

		private Listener nameModifyListener = new Listener() {
			@Override
			public void handleEvent(Event e) {
				boolean valid = validatePage();
				setPageComplete(valid);

			}
		};
		private Object selection;


		public ProjectNameWizardPage(String pageName, String title,
				ImageDescriptor titleImage) {
			super(pageName, title, titleImage);
		}

		protected ProjectNameWizardPage(String pageName) {
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

			createProjectNameGroup(composite);

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
				setMessage("Project name empty");
				return false;
			}
			
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			
			
			if (root.getProject(text).exists())
			{
				setErrorMessage("Project name already exit"); 
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


		private final void createProjectNameGroup(Composite parent) {

	        Composite projectGroup = new Composite(parent, SWT.NONE);
	        GridLayout layout = new GridLayout();
	        layout.numColumns = 1;
	        projectGroup.setLayout(layout);
	        projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	        
	     // new project label
			Label projectLabel = new Label(projectGroup, SWT.NONE);
			projectLabel.setText("Project name:");
			projectLabel.setFont(parent.getFont());
			
			
	        textField = new Text(projectGroup, SWT.BORDER);
	        GridData data = new GridData(GridData.FILL_HORIZONTAL);
	        data.widthHint = SIZING_TEXT_FIELD_WIDTH;
	        textField.setLayoutData(data);
	        textField.setFont(parent.getFont());
	        
	    	DialogField.createEmptySpace(projectGroup);
	        

	    	textField.addListener(SWT.Modify, nameModifyListener);
	    	textField.addListener(SWT.FocusIn, nameModifyListener);
		}

		private String getTextFieldValue() {
			if (textField == null) {
				return ""; //$NON-NLS-1$
			}

			return textField.getText().trim();
		}

		private String getInitialTextFieldValue() {
			return "newProjectJVoice"; //$NON-NLS-1$
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

		public void setSelection(Object firstElement) {
			selection = firstElement;

		}

		@Override
		protected void createWizardContents(Composite parent) {
			// TODO Auto-generated method stub
			
		}

}