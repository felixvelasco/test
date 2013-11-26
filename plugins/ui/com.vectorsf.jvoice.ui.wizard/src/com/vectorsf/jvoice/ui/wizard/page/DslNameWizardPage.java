package com.vectorsf.jvoice.ui.wizard.page;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.ide.IDE;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.ui.wizard.Activator;

public class DslNameWizardPage extends AbstractWizardPage {

	private static final String PAGE_DESC = "Enter a locution name";
	private static final String PAGE_TITLE = "Create a Locution";

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	Text textFieldDSL;
	Text textFieldProject;
	Text textFieldPackage;
	Text textFieldDiagram;

	private Button browsePackage;
	private Button browseDiagram;
	private Combo box;
	private int primeraVez;
	private static URI miURI;
	private String tipo = null;

	// Variable para diferenciar si la locucion se crea desde el
	// navegador o desde el diagrama
	// Si se crea desde el diagrama en el wizard no se podran
	// modificar los campos de proyecto, paquete y diagrama
	private boolean fromNavigator = false;

	private Listener nameModifyListener = new Listener() {
		@Override
		public void handleEvent(Event e) {
			boolean valid = validatePage();
			setPageComplete(valid);

		}
	};
	private Object selection;
	private String initialFlow = "";
	private String initialPackage = "";
	private String initialProject = "";
	private String configuration = "configuration{\n //setting variables \n}\n";
	private String grammars = "grammars{\n // User's grammar \n }\n";
	private String outputs = "outputs{\n //Variables \n}";
	private String audios = "audios{\n //Code \n}";
	private String variables = "variables{\n // User's variables \n}\n";

	public DslNameWizardPage(String pageName) {
		this(pageName, null);
	}

	public DslNameWizardPage(String pageName, String tipo) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
		primeraVez = 0;
		this.tipo = tipo;
		setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "res/wizban/icon_wiz_locution.png"));
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

	public String getText() {
		if (textFieldDSL == null) {
			return getInitialTextFieldValue();
		}

		return getTextFieldValue();
	}

	protected boolean validatePage() {
		String text = getTextFieldValue();
		if (text.isEmpty()) {
			setErrorMessage(null);
			setMessage("Enter a locution name");
			return false;
		}

		String projectName = getProjectFieldValue();
		if (projectName.isEmpty()) {
			setErrorMessage("Enter a project name");
			return false;
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();

		if (!root.getProject(projectName).exists()) {
			setErrorMessage("Project does not exist");
			return false;
		}

		JVProject project = BaseModel.getInstance().getModel().getProject(projectName);
		if (!(project instanceof JVModule)) {
			setErrorMessage("Project is not a module project");
			browsePackage.setEnabled(false);
			return false;
		}
		JVModule module = (JVModule) project;

		IStatus status = doWorkspaceValidation(workspace, text);
		if (!status.isOK()) {
			setErrorMessage(status.getMessage());
			return false;
		}
		if (!customValidate(text)) {
			return false;
		}

		String packageName = getPackageFieldValue();

		if (packageName.isEmpty()) {
			setErrorMessage("Enter a package name");
			return false;
		}

		JVPackage paquete = module.getPackage(packageName);

		if (paquete == null) {
			setErrorMessage("Package does not exist");
			return false;
		}

		String diagramName = getDiagramFieldValue();
		JVBean diagram = paquete.getBean(diagramName);

		if (diagram == null) {
			setErrorMessage("Diagram does not exist");
			return false;
		}

		JVBean voiceDsl = paquete.getBean(text);

		if (voiceDsl != null) {
			if (primeraVez == 0) {
				primeraVez++;
				return false;
			}
			setErrorMessage("Locution already exists");
			return false;
		}

		primeraVez++;
		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	private boolean customValidate(String text) {
		return ResourcesPlugin.getWorkspace().validateName(text, IResource.FILE).isOK();
	}

	@Override
	protected void createWizardContents(Composite parent) {
		createProjectNameGroup(parent);
	}

	private final void createProjectNameGroup(Composite parent) {

		// Obtenemos el nombre del proyecto, paquete y diagrama
		if (selection instanceof IFolder) {
			// Si se crea desde el diagrama
			IFolder folder = (IFolder) selection;
			setNames(folder);
		} else {
			// Si se crea desde el navegador
			fromNavigator = true;
			Flow flow = (Flow) selection;
			initialProject = flow.getOwnerPackage().getOwnerModule().getName();
			initialPackage = flow.getOwnerPackage().getName();
			initialFlow = flow.getName();
		}

		Composite projectGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		projectGroup.setLayout(layout);
		projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// Dsl label
		Label projectLabel = new Label(projectGroup, SWT.NONE);
		projectLabel.setText("DSL name:");
		projectLabel.setFont(parent.getFont());

		// Dsl name entry field
		textFieldDSL = new Text(projectGroup, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		data.horizontalSpan = 2;
		textFieldDSL.setLayoutData(data);
		textFieldDSL.setFont(parent.getFont());

		// Project label

		Label projectLabel2 = new Label(projectGroup, SWT.NONE);
		projectLabel2.setText("Project name:");
		projectLabel2.setFont(parent.getFont());

		textFieldProject = new Text(projectGroup, SWT.BORDER);
		GridData data2 = new GridData(GridData.FILL_HORIZONTAL);
		data2.widthHint = SIZING_TEXT_FIELD_WIDTH;
		textFieldProject.setLayoutData(data2);
		textFieldProject.setFont(parent.getFont());
		textFieldProject.setEditable(false);

		// Project browse button
		Button browse = new Button(projectGroup, SWT.PUSH);
		browse.setText("Browse...");
		browse.setEnabled(fromNavigator);
		browse.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(),
						new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
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
					textFieldPackage.setText("");
					textFieldDiagram.setText("");
				} else {
					textFieldProject.setText("");
				}
			}
		});

		// Package label
		Label projectLabel3 = new Label(projectGroup, SWT.NONE);
		projectLabel3.setText("Package name:");
		projectLabel3.setFont(parent.getFont());

		textFieldPackage = new Text(projectGroup, SWT.BORDER);
		GridData data3 = new GridData(GridData.FILL_HORIZONTAL);
		data3.widthHint = SIZING_TEXT_FIELD_WIDTH;
		textFieldPackage.setLayoutData(data3);
		textFieldPackage.setFont(parent.getFont());
		textFieldPackage.setEditable(false);

		// Package browse button
		browsePackage = new Button(projectGroup, SWT.PUSH);
		browsePackage.setText("Browse...");
		browsePackage.setEnabled(fromNavigator);
		browsePackage.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(),
						new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
								ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
				dialog.setTitle("Container Selection");
				dialog.setAllowDuplicates(false);
				dialog.setMultipleSelection(false);

				dialog.setElements(getPackages().toArray());
				dialog.open();
				Object[] result = dialog.getResult();
				if (result != null && result.length == 1) {
					JVPackage paquete = (JVPackage) result[0];
					setSelection(paquete);
					textFieldPackage.setText(paquete.getName());
					textFieldDiagram.setText("");
				} else {
					textFieldPackage.setText("");
				}
			}
		});

		// Diagram label
		Label projectLabel4 = new Label(projectGroup, SWT.NONE);
		projectLabel4.setText("Diagram name:");
		projectLabel4.setFont(parent.getFont());

		textFieldDiagram = new Text(projectGroup, SWT.BORDER);
		GridData data4 = new GridData(GridData.FILL_HORIZONTAL);
		data4.widthHint = SIZING_TEXT_FIELD_WIDTH;
		textFieldDiagram.setLayoutData(data4);
		textFieldDiagram.setFont(parent.getFont());
		textFieldDiagram.setEditable(false);

		// Diagram browse button
		browseDiagram = new Button(projectGroup, SWT.PUSH);
		browseDiagram.setText("Browse...");
		browseDiagram.setEnabled(fromNavigator);
		browseDiagram.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(),
						new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
								ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
				dialog.setTitle("Container Selection");
				dialog.setAllowDuplicates(false);
				dialog.setMultipleSelection(false);
				JVModule project = (JVModule) BaseModel.getInstance().getModel().getProject(textFieldProject.getText());
				JVPackage pack = project.getPackage(textFieldPackage.getText());
				dialog.setElements(pack.getBeans().toArray());
				dialog.open();
				Object[] result = dialog.getResult();
				if (result != null && result.length == 1) {
					JVBean diagram = (JVBean) result[0];
					setSelection(diagram);
					textFieldDiagram.setText(diagram.getName());
				} else {
					textFieldDiagram.setText("");
				}
			}
		});

		// Locution type combo label
		Label ComboLabel4 = new Label(projectGroup, SWT.NONE);
		ComboLabel4.setText("Select an option:");
		ComboLabel4.setFont(parent.getFont());

		// Combo para indicar que clase de DSL queremos crear.

		box = new Combo(projectGroup, SWT.READ_ONLY);
		box.setEnabled(fromNavigator);
		box.add("Menu");
		box.add("Input");
		box.add("Output");
		box.add("Record");

		if (tipo != null) {
			if (tipo.equalsIgnoreCase("Menu")) {
				box.select(0);
			}
			if (tipo.equalsIgnoreCase("Input")) {
				box.select(1);
			}
			if (tipo.equalsIgnoreCase("Output")) {
				box.select(2);
			}
			if (tipo.equalsIgnoreCase("Record")) {
				box.select(3);
			}

			box.setEnabled(false);
		} else {
			box.select(0);
		}

		// Set the initial value first before listener
		// to avoid handling an event during the creation.
		if (getInitialTextFieldValue() != null) {
			textFieldDSL.setText(getInitialTextFieldValue());
		}
		textFieldDSL.addListener(SWT.Modify, nameModifyListener);

		textFieldProject.setText(getInitialTextProjectFieldValue());
		textFieldProject.addListener(SWT.Modify, nameModifyListener);

		textFieldPackage.setText(getInitialTextFolderFieldValue());
		textFieldPackage.addListener(SWT.Modify, nameModifyListener);

		textFieldDiagram.setText(getInitialTextDiagramFieldValue());
		textFieldDiagram.addListener(SWT.Modify, nameModifyListener);
	}

	private String getTextFieldValue() {
		if (textFieldDSL == null) {
			return ""; //$NON-NLS-1$
		}

		return textFieldDSL.getText().trim();
	}

	private String getInitialTextFieldValue() {
		return "newLocution"; //$NON-NLS-1$
	}

	private String getInitialTextDiagramFieldValue() {
		return initialFlow;
	}

	private String getInitialTextFolderFieldValue() {
		return initialPackage;
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
			textFieldDSL.setFocus();
			textFieldDSL.selectAll();
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

	private List<JVPackage> getPackages() {
		IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(textFieldProject.getText());
		JVModule project = (JVModule) BaseModel.getInstance().getModel().getProject(iProject.getName());

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

	private String getDiagramFieldValue() {
		if (textFieldDiagram == null) {
			return ""; //$NON-NLS-1$
		}

		return textFieldDiagram.getText().trim();
	}

	// Equivalente al performFinish
	@Override
	public void createResource() throws CoreException {
		String dslName = getText();
		IProject project = null;
		IFolder dslFolder = null;
		String editorExtension = "voiceDsl";
		IFile dslFile = null;
		String contents = "";
		String seleccion = box.getText();

		Object element = getSelection();

		if (element instanceof IFolder) {
			// Creado desde el diagrama
			project = (IProject) Platform.getAdapterManager().getAdapter(((IFolder) element).getProject(),
					IProject.class);

			dslFolder = (IFolder) Platform.getAdapterManager().getAdapter(element, IFolder.class);
		} else {
			// Creado desde el navegador
			Flow flow = (Flow) element;
			project = (IProject) Platform.getAdapterManager().getAdapter(flow.getOwnerPackage().getOwnerModule(),
					IProject.class);
			IFolder packageFolder = project.getFolder(BaseModel.JV_PATH + "/" + toPath(getPackageFieldValue()));
			String folderName = getFolderName(packageFolder, flow.getName());
			dslFolder = getFolder(folderName);
		}

		if (project == null || !project.isAccessible()) {
			String error = "No Project Found";
			IStatus status = new Status(IStatus.ERROR, "1", error);
			ErrorDialog.openError(getShell(), error, null, status);
			throw new CoreException(status);
		}

		if (dslFolder != null) {
			dslFile = dslFolder.getFile(dslName + "." + editorExtension);

			if (!dslFile.exists()) {
				if (seleccion.equals("Menu")) {
					contents = "menuname " + dslName + "\n\n" + configuration + grammars + audios + outputs;

				} else if (seleccion.equals("Input")) {
					contents = "inputname " + dslName + "\n\n" + configuration + grammars + audios;

				} else if (seleccion.equals("Output")) {
					contents = "outputname " + dslName + "\n\n" + variables + audios;

				} else if (seleccion.equals("Record")) {
					contents = "recordname " + dslName + "\n\n" + configuration + audios;

				}

				InputStream source = new ByteArrayInputStream(contents.getBytes());
				dslFile.create(source, false, null);
			}

		}

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = (IFile) Platform.getAdapterManager().getAdapter(dslFile, IFile.class);
		miURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true).appendFragment("/0");

		try {
			IDE.openEditor(page, file);
		} catch (PartInitException e) {
			String error = "error open editor";
			IStatus status = new Status(IStatus.ERROR, "0", error, e);
			ErrorDialog.openError(getShell(), error, null, status);
			throw new CoreException(status);
		}
	}

	public URI returnURI() {
		return miURI;
	}

	private String getFolderName(IFolder packageFolder, String dslName) {
		String folderName = packageFolder + "/" + dslName + ".resources";
		String newFolderName = "";
		String[] folderNameSegments = folderName.split("/");
		for (int i = 2; i < folderNameSegments.length; i++) {
			newFolderName = newFolderName.concat("/" + folderNameSegments[i]);
		}
		return newFolderName;
	}

	private IProject getProject() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectFieldValue());
	}

	public IFolder getFolder(String folderName) {
		IProject project = getProject();
		return project.getFolder(folderName);
	}

	public String getProjectName(IFolder folderName) {
		IProject iProject = folderName.getProject();
		return iProject.getName();
	}

	public void setNames(IFolder folder) {
		IProject iProject = folder.getProject();
		initialProject = iProject.getName();
		IPath iPath = folder.getFullPath();
		String path = iPath.toString().substring(1);
		String[] pathSegments = path.split("/");
		String diagramFolder = pathSegments[pathSegments.length - 1];
		if (diagramFolder.endsWith("resources")) {
			// Obtenemos el pack
			for (int i = 5; i < pathSegments.length - 1; i++) {
				if (i == 5) {
					initialPackage = pathSegments[i].toString();
				} else {
					initialPackage = initialPackage + "." + pathSegments[i].toString();
				}
			}
			// initialPackage = pathSegments[pathSegments.length-2];
			String[] diagramNameSegments = diagramFolder.split("\\.");
			initialFlow = diagramNameSegments[0];
		}
	}

	private String toPath(String packageFieldValue) {
		return packageFieldValue.replace('.', '/');
	}
}
