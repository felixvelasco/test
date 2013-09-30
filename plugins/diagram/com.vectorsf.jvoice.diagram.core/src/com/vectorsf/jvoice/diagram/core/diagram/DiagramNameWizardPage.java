package com.vectorsf.jvoice.diagram.core.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;

@SuppressWarnings("restriction")
public class DiagramNameWizardPage extends AbstractWizardPage {

	private static final String PAGE_DESC = "Enter a diagram name";
	private static final String PAGE_TITLE = "New JVoice Diagram";

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	Text textFieldDiagram;
	Text textFieldProject;
	Text textFieldPackage;

	private Button browsePackage;

	private Listener nameModifyListener = new Listener() {
		@Override
		public void handleEvent(Event e) {
			boolean valid = validatePage();
			setPageComplete(valid);

		}
	};
	private Object selection;
	private String initialFolder = "";
	private String initialProject = "";

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

		// Show description on opening
		setErrorMessage(null);
		setMessage(null);

		setPageComplete(validatePage());

		setControl(composite);
	}

	@Override
	public String getText() {
		if (textFieldDiagram == null) {
			return getInitialTextFieldValue();
		}

		return getTextFieldValue();
	}

	protected boolean validatePage() {
		String text = getTextFieldValue();
		if (text.isEmpty()) {
			setErrorMessage(null);
			setMessage("Diagram name empty");
			return false;
		}

		String projectName = getProjectFieldValue();
		if (projectName.isEmpty()) {
			setErrorMessage("Project name empty");
			browsePackage.setEnabled(false);
			return false;
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();

		if (!root.getProject(projectName).exists()) {
			setErrorMessage("Project does not exist");
			browsePackage.setEnabled(false);
			return false;
		}

		JVProject proyecto = BaseModel.getInstance().getModel()
				.getProject(projectName);
		if (proyecto == null) {
			setErrorMessage("Project does not jvoice project");
			browsePackage.setEnabled(false);
			return false;
		}

		IStatus status = doWorkspaceValidation(workspace, text);
		if (!status.isOK()) {
			setErrorMessage(status.getMessage());
			return false;
		}

		String packageName = getPackageFieldValue();
		browsePackage.setEnabled(true);

		if (packageName.isEmpty()) {
			setErrorMessage("Package name empty");
			return false;
		}

		JVPackage paquete = proyecto.getPackage(packageName);

		if (paquete == null) {
			setErrorMessage("Package does not exist");
			return false;
		}

		JVBean diagrama = paquete.getBean(text);

		if (diagrama != null) {
			setErrorMessage("Diagram already exists");
			return false;
		}

		setSelection(paquete);
		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	@Override
	protected void createWizardContents(Composite parent) {
		createProjectNameGroup(parent);
	}

	private final void createProjectNameGroup(Composite parent) {

		JVProject project = null;
		JVPackage diagramFolder = null;
		if (selection instanceof IProject) {
			IProject iProject = (IProject) selection;
			project = BaseModel.getInstance().getModel()
					.getProject(iProject.getName());
		} else if (selection instanceof IFolder) {
			IFolder folder = (IFolder) selection;
			IProject iProject = folder.getProject();
			project = BaseModel.getInstance().getModel()
					.getProject(iProject.getName());

			// si el proyecto es nulo es porque el proyecto donde se quiere
			// crear el flujo no
			// es un proyecto jvoice
			if (project != null) {
				diagramFolder = project.getPackage(folder.getName());
			}
		} else if (selection instanceof JVProject) {
			project = (JVProject) selection;
		} else if (selection instanceof JVPackage) {
			diagramFolder = (JVPackage) selection;
			project = diagramFolder.getOwnerProject();
		} else if (selection instanceof IPackageFragmentRoot) {
			IPackageFragmentRoot prueba = (IPackageFragmentRoot) selection;
			IFolder folder = (IFolder) prueba.getResource();
			IProject iProject = folder.getProject();
			project = BaseModel.getInstance().getModel()
					.getProject(iProject.getName());
			diagramFolder = project.getPackage(folder.getName());
		}

		initialFolder = diagramFolder != null ? diagramFolder.getName() : "";
		initialProject = project != null ? project.getName() : "";

		Composite projectGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		projectGroup.setLayout(layout);
		projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// new project label
		Label projectLabel = new Label(projectGroup, SWT.NONE);
		projectLabel.setText("Diagram name:");
		projectLabel.setFont(parent.getFont());

		// new project name entry field
		textFieldDiagram = new Text(projectGroup, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		textFieldDiagram.setLayoutData(data);
		textFieldDiagram.setFont(parent.getFont());

		DialogField.createEmptySpace(projectGroup);

		// new project label
		Label projectLabel2 = new Label(projectGroup, SWT.NONE);
		projectLabel2.setText("project:");
		projectLabel2.setFont(parent.getFont());

		textFieldProject = new Text(projectGroup, SWT.BORDER);
		GridData data2 = new GridData(GridData.FILL_HORIZONTAL);
		data2.widthHint = SIZING_TEXT_FIELD_WIDTH;
		textFieldProject.setLayoutData(data2);
		textFieldProject.setFont(parent.getFont());

		// browse button on right
		Button browse = new Button(projectGroup, SWT.PUSH);
		browse.setText("Browse...");
		browse.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(
						getShell(),
						new AdapterFactoryLabelProvider(
								new ComposedAdapterFactory(
										ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
				dialog.setTitle("Container Selection");
				dialog.setAllowDuplicates(false);
				dialog.setMultipleSelection(false);

				dialog.setElements(llenarProyectos().toArray());
				dialog.open();
				Object[] result = dialog.getResult();
				if (result != null && result.length == 1) {
					JVProject projecto = (JVProject) result[0];
					setSelection(projecto);
					textFieldProject.setText(projecto.getName());
				} else {
					textFieldProject.setText("");
				}
			}
		});

		// new project label
		Label projectLabel3 = new Label(projectGroup, SWT.NONE);
		projectLabel3.setText("folder:");
		projectLabel3.setFont(parent.getFont());

		textFieldPackage = new Text(projectGroup, SWT.BORDER);
		GridData data3 = new GridData(GridData.FILL_HORIZONTAL);
		data3.widthHint = SIZING_TEXT_FIELD_WIDTH;
		textFieldPackage.setLayoutData(data3);
		textFieldPackage.setFont(parent.getFont());

		// browse button on right
		browsePackage = new Button(projectGroup, SWT.PUSH);
		browsePackage.setText("Browse...");
		browsePackage.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(
						getShell(),
						new AdapterFactoryLabelProvider(
								new ComposedAdapterFactory(
										ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
				dialog.setTitle("Container Selection");
				dialog.setAllowDuplicates(false);
				dialog.setMultipleSelection(false);

				dialog.setElements(llenarPaquetes().toArray());
				dialog.open();
				Object[] result = dialog.getResult();
				if (result != null && result.length == 1) {
					JVPackage paquete = (JVPackage) result[0];
					setSelection(paquete);
					textFieldPackage.setText(paquete.getName());
				} else {
					textFieldPackage.setText("");
				}
			}
		});

		browsePackage.setEnabled(false);

		// Set the initial value first before listener
		// to avoid handling an event during the creation.
		if (getInitialTextFieldValue() != null) {
			textFieldDiagram.setText(getInitialTextFieldValue());
		}
		textFieldDiagram.addListener(SWT.Modify, nameModifyListener);

		textFieldProject.setText(getInitialTextProjectFieldValue());
		textFieldProject.addListener(SWT.Modify, nameModifyListener);

		textFieldPackage.setText(getInitialTextFolderFieldValue());
		textFieldPackage.addListener(SWT.Modify, nameModifyListener);
	}

	private String getTextFieldValue() {
		if (textFieldDiagram == null) {
			return ""; //$NON-NLS-1$
		}

		return textFieldDiagram.getText().trim();
	}

	private String getInitialTextFieldValue() {
		return "newJVoice"; //$NON-NLS-1$
	}

	private String getInitialTextFolderFieldValue() {
		return initialFolder;
	}

	private String getInitialTextProjectFieldValue() {
		return initialProject;
	}

	private IStatus doWorkspaceValidation(IWorkspace workspace, String text) {
		IStatus ret = workspace.validateName(text, IResource.FILE);
		return ret;
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			textFieldDiagram.setFocus();
			textFieldDiagram.selectAll();
		}
	}

	public void setSelection(Object firstElement) {
		selection = firstElement;

	}

	public Object getSelection() {
		return selection;
	}

	private List<JVProject> llenarProyectos() {

		List<JVProject> input = new ArrayList<JVProject>();

		for (int i = 0; i < ResourcesPlugin.getWorkspace().getRoot()
				.getProjects().length; i++) {
			IProject proyecto = ResourcesPlugin.getWorkspace().getRoot()
					.getProjects()[i];
			String nombreProyecto = proyecto.getName();
			JVProject project = BaseModel.getInstance().getModel()
					.getProject(nombreProyecto);
			if (project != null) {
				input.add(project);
			}
		}
		return input;
	}

	private List<JVPackage> llenarPaquetes() {

		IProject proyecto = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(textFieldProject.getText());

		JVProject project = BaseModel.getInstance().getModel()
				.getProject(proyecto.getName());

		return project.getPackages();
	}

	private String getProjectFieldValue() {
		if (textFieldProject == null) {
			return ""; //$NON-NLS-1$
		}

		return textFieldProject.getText().trim();
	}

	private String getPackageFieldValue() {
		if (textFieldPackage == null) {
			return ""; //$NON-NLS-1$
		}

		return textFieldPackage.getText().trim();
	}
}
