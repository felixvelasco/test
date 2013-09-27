/**
 * 
 */
package com.vectorsf.jvoice.ui.wizard.Wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
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

import com.vectorsf.jvoice.base.model.service.BaseModel;

public class PackageNameWizardPage extends AbstractWizardPage {

	private static final String PAGE_DESC = "Package name";
	private static final String PAGE_TITLE = "New JVoice package";

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	private Text textField;
	private Text packageField;

	private Listener nameModifyListener = new Listener() {
		@Override
		public void handleEvent(Event e) {
			boolean valid = validatePage();
			setPageComplete(valid);

		}
	};

	public PackageNameWizardPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	protected PackageNameWizardPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
	}

	public String getText() {
		return getProjectFieldValue();
	}

	protected boolean validatePage() {
		String projectName = getProjectFieldValue();
		if (projectName.equals("")) { //$NON-NLS-1$
			setErrorMessage(null);
			setMessage("package name empty");
			return false;
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();

		if (!root.getProject(projectName).exists()) {
			setErrorMessage("Project does not exist");
			return false;
		}

		String packageName = getPackageFieldValue();

		for (String path : packageName.split("\\.")) {
			IStatus status = doWorkspaceValidation(workspace, path);
			if (!status.isOK()) {
				setErrorMessage(status.getMessage());
				return false;
			}
		}

		if (root.getProject(projectName).getFolder(packageName).exists()) {
			setErrorMessage("Package already exists");
			return false;
		}

		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	@Override
	protected final void createWizardContents(Composite parent) {

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

		textField.addListener(SWT.Modify, nameModifyListener);
		textField.addListener(SWT.FocusIn, nameModifyListener);

		// new project label
		Label packageLabel = new Label(projectGroup, SWT.NONE);
		packageLabel.setText("Package name:");
		packageLabel.setFont(parent.getFont());

		packageField = new Text(projectGroup, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		packageField.setLayoutData(data);
		packageField.setFont(parent.getFont());

		packageField.addListener(SWT.Modify, nameModifyListener);
		packageField.addListener(SWT.FocusIn, nameModifyListener);

	}

	private String getProjectFieldValue() {
		if (textField == null) {
			return ""; //$NON-NLS-1$
		}

		return textField.getText().trim();
	}

	private String getPackageFieldValue() {
		if (packageField == null) {
			return ""; //$NON-NLS-1$
		}

		return packageField.getText().trim();
	}

	private IStatus doWorkspaceValidation(IWorkspace workspace, String text) {
		IStatus ret = workspace.validateName(text, IResource.FOLDER);
		return ret;
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			packageField.setFocus();
		}
	}

	@Override
	protected void createResource() throws CoreException {
		final IFolder packageFolder = getFolder();
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				createRecursively(packageFolder, monitor);
			}
		};

		ResourcesPlugin.getWorkspace().run(runnable, packageFolder.getProject(), IWorkspace.AVOID_UPDATE, null);
	}

	public IFolder getFolder() {
		IProject project = getProject();
		return project.getFolder(BaseModel.JV_PATH + "/" + toPath(getPackageFieldValue()));
	}

	private IProject getProject() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectFieldValue());
	}

	private String toPath(String packageFieldValue) {
		return packageFieldValue.replace('.', '/');
	}

	private void createRecursively(IFolder container, IProgressMonitor monitor) throws CoreException {
		IContainer parent = container.getParent();
		if (parent instanceof IFolder && !parent.exists()) {
			createRecursively((IFolder) parent, monitor);
		}

		if (!container.exists()) {
			container.create(true, true, monitor);
		}

	}
}