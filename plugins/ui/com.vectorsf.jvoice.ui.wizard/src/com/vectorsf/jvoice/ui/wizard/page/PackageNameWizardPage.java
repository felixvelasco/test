/**
 * 
 */
package com.vectorsf.jvoice.ui.wizard.page;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.internal.runtime.CommonMessages;
import org.eclipse.core.internal.runtime.IRuntimeConstants;
import org.eclipse.core.internal.runtime.RuntimeLog;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.navigator.CommonNavigator;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.ui.wizard.Activator;

public class PackageNameWizardPage extends AbstractWizardPage {

	private static final String PAGE_DESC = "Enter a package name";
	private static final String PAGE_TITLE = "Create a Package";

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	private Text textField;
	private Text packageField;
	private Object selection;

	private Listener nameModifyListener = new Listener() {
		@Override
		public void handleEvent(Event e) {
			boolean valid = validatePage();
			setPageComplete(valid);

		}
	};

	public PackageNameWizardPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
		setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "res/wizban/icon_wiz_box.png"));
	}

	public String getText() {
		return getProjectFieldValue();
	}

	protected boolean validatePage() {
		String projectName = getProjectFieldValue();
		if (projectName.equals("")) { //$NON-NLS-1$
			setErrorMessage(null);
			setMessage("Enter a project name");
			return false;
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();

		if (!root.getProject(projectName).exists()) {
			setErrorMessage("Project does not exist");
			return false;
		}

		JVProject proyecto = BaseModel.getInstance().getModel().getProject(projectName);

		// verificamos que el proyecto es de tipo jvoice
		if (proyecto == null) {
			setErrorMessage("Project is not jvoice project");
			return false;
		}

		String packageName = getPackageFieldValue();

		for (String path : packageName.split("\\.")) {
			IStatus status = doWorkspaceValidation(workspace, path);
			if (!status.isOK()) {
				setErrorMessage(status.getMessage());
				return false;
			}
			if (!customValidate(packageName)) {
				return false;
			}
		}

		IPath path = new Path(BaseModel.JV_PATH + "/" + toPath(packageName));

		if (root.getProject(projectName).getFolder(path).exists()) {
			setErrorMessage("Package already exists");
			return false;
		}

		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	private boolean customValidate(String text) {
		return ResourcesPlugin.getWorkspace().validateName(text, IResource.FOLDER).isOK();
	}

	@Override
	protected final void createWizardContents(Composite parent) {

		Composite projectGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
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
		textField.setEditable(false);

		// browse button on right
		Button browse = new Button(projectGroup, SWT.PUSH);
		browse.setText("Browse...");
		browse.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(),
						new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
								ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
				dialog.setTitle("Container Selection");
				dialog.setAllowDuplicates(false);
				dialog.setMultipleSelection(false);

				dialog.setElements(llenarElementos().toArray());
				dialog.open();
				Object[] result = dialog.getResult();
				if (result != null && result.length == 1) {
					JVProject projecto = (JVProject) result[0];
					setSelection(projecto);
					textField.setText(projecto.getName());
				} else {
					textField.setText("");
				}
			}
		});

		if (getInitialTextFieldValue() != null) {
			textField.setText(getInitialTextFieldValue());
		}

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

		// Set the initial value first before listener
		// to avoid handling an event during the creation.
		packageField.setText("newPackage");
		packageField.selectAll();

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
	public void createResource() throws CoreException {
		final IFolder packageFolder = getFolder();

		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				try {
					createRecursively(packageFolder, monitor);
				} catch (ResourceException e) {
					handleException(e);
					MessageDialog.openError(null, "Error", "A resource \"" + packageFolder.getName()
							+ "\" exists with a different case. Please check Error Log.");
				}
			}

		};
		ResourcesPlugin.getWorkspace().run(runnable, packageFolder.getProject(), IWorkspace.AVOID_UPDATE, null);
		for (Shell shell : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getShells()) {
			if (shell.getText().contains("New Package")) {
				shell.close();
			}
		}
		for (IViewPart view : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViews()) {
			if (view.getTitle().equals("Navigator IVR")) {
				CommonNavigator commonNavigator = (CommonNavigator) view;
				JVProject project = BaseModel.getInstance().getModel().getProject(packageFolder.getProject().getName());
				for (EObject pack : project.eContents()) {
					JVPackage packa = (JVPackage) Platform.getAdapterManager().getAdapter(pack, JVPackage.class);
					if (packa != null) {
						if (packa.getName().equals(packageFolder.getName())) {
							StructuredSelection structuredSelection = new StructuredSelection(pack);
							commonNavigator.selectReveal(structuredSelection);
						}
					}
				}
			}
		}
	}

	private static void handleException(Throwable e) {
		if (!(e instanceof OperationCanceledException)) {
			// try to obtain the correct plug-in id for the bundle providing the safe runnable
			Activator activator = Activator.getDefault();
			String pluginId = null;
			if (pluginId == null) {
				pluginId = IRuntimeConstants.PI_COMMON;
			}
			String message = NLS.bind(CommonMessages.meta_pluginProblems, pluginId);
			IStatus status;
			if (e instanceof CoreException) {
				status = new MultiStatus(pluginId, IRuntimeConstants.PLUGIN_ERROR, message, e);
				((MultiStatus) status).merge(((CoreException) e).getStatus());
			} else {
				status = new Status(IStatus.ERROR, pluginId, IRuntimeConstants.PLUGIN_ERROR, message, e);
			}
			// Make sure user sees the exception: if the log is empty, log the exceptions on stderr
			if (!RuntimeLog.isEmpty()) {
				RuntimeLog.log(status);
			} else {
				e.printStackTrace();
			}
		}
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

	public void setSelection(Object firstElement) {
		selection = firstElement;

	}

	private String getInitialTextFieldValue() {
		if (selection instanceof JVProject) {
			return ((JVProject) selection).getName();
		} else if (selection instanceof IProject) {
			IProject project = (IProject) selection;
			JVProject jvProject = BaseModel.getInstance().getModel().getProject(project.getName());
			if (jvProject != null) {
				return ((IProject) selection).getName();
			} else {
				return null;
			}
		} else if (selection instanceof IFolder) {
			return ((IFolder) selection).getProject().getName();
		} else if (selection instanceof JVPackage) {
			return ((JVPackage) selection).getOwnerModule().getName();
		} else if (selection instanceof IPackageFragmentRoot) {
			IPackageFragmentRoot iPackageFragmentRoot = (IPackageFragmentRoot) selection;
			return ((IFolder) iPackageFragmentRoot.getResource()).getProject().getName();
		} else {
			return null;
		}

	}

	private List<JVProject> llenarElementos() {

		List<JVProject> input = new ArrayList<JVProject>();
		for (int i = 0; i < ResourcesPlugin.getWorkspace().getRoot().getProjects().length; i++) {
			IProject proyecto = ResourcesPlugin.getWorkspace().getRoot().getProjects()[i];
			String nombreProyecto = proyecto.getName();
			JVProject project = BaseModel.getInstance().getModel().getProject(nombreProyecto);

			if (project != null) {
				input.add(project);
			}
		}
		return input;
	}
}