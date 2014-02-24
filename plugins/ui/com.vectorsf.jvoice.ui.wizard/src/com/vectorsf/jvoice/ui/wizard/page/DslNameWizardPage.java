package com.vectorsf.jvoice.ui.wizard.page;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.internal.runtime.CommonMessages;
import org.eclipse.core.internal.runtime.IRuntimeConstants;
import org.eclipse.core.internal.runtime.RuntimeLog;
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
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
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
import org.eclipse.xtext.Keyword;

import com.google.inject.Injector;
import com.isb.bks.ivr.voice.dsl.services.VoiceDslGrammarAccess;
import com.isb.bks.ivr.voice.dsl.ui.internal.VoiceDslActivator;
import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.ui.wizard.Activator;

public class DslNameWizardPage extends AbstractWizardPage {

	private static final String PAGE_DESC = "Enter a definition name";
	private static final String PAGE_TITLE = "Create a Definition";

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	Text textFieldDSL;
	Text textFieldProject;
	Text textFieldPackage;
	Text textFieldDiagram;

	private Button browsePackage;
	private Button browseDiagram;
	private Combo box;
	private boolean primeraVez;
	private static URI miURI;
	private Class<? extends VoiceDsl> targetClazz;

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

	private static String STATIC_DSLS_LOCATION = "res/voiceDsls/";
	private static String STATIC_DSLS_EXT = ".voiceDsl";

	public DslNameWizardPage(String pageName) {
		this(pageName, null);
	}

	public DslNameWizardPage(String pageName, Class<? extends VoiceDsl> targetClazz) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
		primeraVez = true;
		this.targetClazz = targetClazz;
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
			setMessage("Enter a definition name");
			return false;
		}

		char initial = text.charAt(0);
		if (Character.isDigit(initial)) {
			setErrorMessage("The first letter of the definition name cannot be a number.");
			return false;
		}
		if (!Character.isJavaLetter(initial)) {
			setErrorMessage("The first letter of the definition is not valid.");
			return false;
		}
		for (int i = 1; i < text.length(); i++) {
			char letter = text.charAt(i);
			if (!Character.isJavaLetterOrDigit(letter)) {
				setErrorMessage("Name contains incorrect character");
				return false;
			}
		}

		if (text.indexOf(' ') != -1) {
			setErrorMessage("The name of the definition cannot contain spaces.");
			return false;
		}

		if (!Character.isJavaLetter(initial)) {
			setErrorMessage("The first letter of the application is not valid.");
			return false;
		}
		for (int i = 1; i < text.length(); i++) {
			char letter = text.charAt(i);
			if (!Character.isJavaLetterOrDigit(letter)) {
				setErrorMessage("Name contains incorrect character");
				return false;
			}

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

		IStatus status = workspace.validateName(text, IResource.FILE);
		if (!status.isOK()) {
			setErrorMessage(status.getMessage());
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

		IFile file = findLocutionFolder().getFile(text + ".voiceDsl");

		if (file.exists()) {
			if (primeraVez) {
				primeraVez = false;
				return false;
			}
			setErrorMessage("Definition already exists");
			return false;
		}

		primeraVez = false;
		setErrorMessage(null);
		setMessage(null);
		return true;
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
		projectLabel.setText("Name:");
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
		box.setItems(new String[] { "Menu", "Input", "Output", "Record", "Transfer" });

		if (targetClazz != null) {
			if (targetClazz.equals(MenuDsl.class)) {
				box.select(0);
			}
			if (targetClazz.equals(InputDsl.class)) {
				box.select(1);
			}
			if (targetClazz.equals(PromptDsl.class)) {
				box.select(2);
			}
			if (targetClazz.equals(RecordDsl.class)) {
				box.select(3);
			}
			if (targetClazz.equals(TransferDsl.class)) {
				box.select(4);
			}

			box.setEnabled(false);
		} else {
			box.select(0);
		}

		// Set the initial value first before listener
		// to avoid handling an event during the creation.
		if (getInitialTextFieldValue() != null) {
			textFieldDSL.setText(getInitialTextFieldValue());
			textFieldDSL.selectAll();
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
		return "newDefinition"; //$NON-NLS-1$
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
		Injector injector = VoiceDslActivator.getInstance().getInjector(
				VoiceDslActivator.COM_ISB_BKS_IVR_VOICE_DSL_VOICEDSL);
		VoiceDslGrammarAccess access = injector.getInstance(VoiceDslGrammarAccess.class);

		String dslName = getText();
		IFolder dslFolder = null;
		String editorExtension = "voiceDsl";
		IFile dslFile = null;
		String contents = "";
		String seleccion = box.getText();

		dslFolder = findLocutionFolder();

		IProject project = dslFolder.getProject();

		if (project == null || !project.isAccessible()) {
			String error = "No Project Found";
			IStatus status = new Status(IStatus.ERROR, "1", error);
			ErrorDialog.openError(getShell(), error, null, status);
			throw new CoreException(status);
		}

		if (dslFolder != null) {
			dslFile = dslFolder.getFile(dslName + "." + editorExtension);

			if (!dslFile.exists()) {
				String resName;
				List<Keyword> findKeywords = access.findKeywords(dslName);
				String escapedName = findKeywords.isEmpty() ? dslName : "^" + dslName;
				if (seleccion.equals("Menu")) {
					contents = "menu " + escapedName + "\n\n";
					resName = "basicMenu";

				} else if (seleccion.equals("Input")) {
					contents = "input " + escapedName + "\n\n";
					resName = "basicInput";

				} else if (seleccion.equals("Output")) {
					contents = "output " + escapedName + "\n\n";
					resName = "basicOutput";

				} else if (seleccion.equals("Record")) {
					contents = "record " + escapedName + "\n\n";
					resName = "basicRecord";

				} else {
					contents = "blindTransfer " + escapedName + "\n\n";
					resName = "basicBlindTransfer";

				}

				try (InputStream resIs = getInputStreamFromFile(resName)) {
					InputStream source = new ByteArrayInputStream(contents.getBytes());
					if (resIs != null) {
						source = new SequenceInputStream(source, resIs);
					}
					dslFile.create(source, false, null);
				} catch (ResourceException e) {
					handleException(e);
					MessageDialog.openError(null, "Error", "A resource \"" + dslName
							+ "\" exists with a different case. Please check Error Log.");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		}

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = (IFile) Platform.getAdapterManager().getAdapter(dslFile, IFile.class);
		if (file.exists()) {
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

	private InputStream getInputStreamFromFile(String dslName) {

		URL resUrl;
		InputStream resIs = null;
		resUrl = Platform.getBundle(Activator.PLUGIN_ID).getResource(STATIC_DSLS_LOCATION + dslName + STATIC_DSLS_EXT);
		try {
			if (resUrl != null) {
				resIs = resUrl.openConnection().getInputStream();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resIs;
	}

	private IFolder findLocutionFolder() {
		IFolder dslFolder;
		Object element = getSelection();

		if (element instanceof IFolder) {
			// Creado desde el diagrama
			dslFolder = (IFolder) element;

		} else {
			// Creado desde el navegador
			Flow flow = (Flow) element;
			IFolder packageFolder = (IFolder) Platform.getAdapterManager().getAdapter(flow.getOwnerPackage(),
					IFolder.class);
			String folderName = getFolderName(packageFolder, flow.getName());
			dslFolder = getFolder(folderName);
		}
		return dslFolder;
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
			String[] diagramNameSegments = diagramFolder.split("\\.");
			initialFlow = diagramNameSegments[0];
		}
	}
}
