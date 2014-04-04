package com.vectorsf.jvoice.ui.wizard.page;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.core.internal.runtime.CommonMessages;
import org.eclipse.core.internal.runtime.IRuntimeConstants;
import org.eclipse.core.internal.runtime.RuntimeLog;
import org.eclipse.core.internal.utils.Messages;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;

public class PropertiesFileNameWizardPage extends AbstractWizardPage {

	private static final String PAGE_DESC = "Enter a Properties File name";
	private static final String PAGE_TITLE = "Create a Properties File";

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;
	private static final char[] INVALID_RESOURCE_CHARACTERS = new char[] { ' ', ',', '.', '^', '¿', '(', ')', '[', ']',
			'{', '}', ';', '-', '_', '!', '?', '$', '%', '&', '=' };

	Text textFieldProperName;

	private int primeraVez;
	private IPath path;
	private static final String PROPERTY = "properties";

	private Listener nameModifyListener = new Listener() {
		@Override
		public void handleEvent(Event e) {
			boolean valid = validatePage();
			setPageComplete(valid);

		}
	};
	private Object selection;
	private IFile file;
	private static final Path PROPERTIES_PATH = new Path(BaseModel.PROPERTIES_PATH);

	public PropertiesFileNameWizardPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
		primeraVez = 0;
	}

	public PropertiesFileNameWizardPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
		primeraVez = 0;
	}

	public PropertiesFileNameWizardPage(String pageName, boolean projectEnable) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
		primeraVez = 0;
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
		if (textFieldProperName == null) {
			return getInitialTextFieldValue();
		}

		return getTextFieldValue();
	}

	protected boolean validatePage() {
		String text = getTextFieldValue();
		if (text.isEmpty() || text.trim().equals("")) {
			setErrorMessage(null);
			setMessage("Enter a Properties File name");
			return false;
		}

		char initial = text.charAt(0);
		if (Character.isDigit(initial)) {
			setErrorMessage("The first letter of the Properties File name can't be a number.");
			return false;
		}
		if (!Character.isLetter(initial)) {
			setErrorMessage("The first letter of the Properties File is not valid.");
			return false;
		}
		for (int i = 1; i < text.length(); i++) {
			char letter = text.charAt(i);
			if (!Character.isLetterOrDigit(letter)) {
				setErrorMessage("Name contains incorrect character");
				return false;
			}

		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		IStatus status = doWorkspaceValidation(workspace, text);
		if (!status.isOK()) {
			setErrorMessage(status.getMessage());
			return false;
		}
		if (!NameFileValidate(text)) {
			return false;
		}

		// Comprobamos que no exista un fichero con el mismo nombre.
		if (getPath() != null) {
			path = getPath();
			file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null && file.exists()) {
				if (primeraVez == 0) {
					primeraVez++;
					return false;
				}
				setErrorMessage("Properties File already exists");
				return false;
			}

		}

		primeraVez++;
		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	private boolean NameFileValidate(String text) {
		for (int i = 0; i < INVALID_RESOURCE_CHARACTERS.length; i++) {
			if (text.indexOf(INVALID_RESOURCE_CHARACTERS[i]) != -1) {
				setErrorMessage(NLS.bind(Messages.resources_invalidCharInName,
						String.valueOf(INVALID_RESOURCE_CHARACTERS[i]), text));
				return false;

			}
		}
		return true;
	}

	@Override
	protected void createWizardContents(Composite parent) {
		createProjectNameGroup(parent);
	}

	private final void createProjectNameGroup(Composite parent) {

		Composite projectGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		projectGroup.setLayout(layout);
		projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// Properties File label
		Label projectLabel = new Label(projectGroup, SWT.NONE);
		projectLabel.setText("Properties File name:");
		projectLabel.setFont(parent.getFont());

		// Properties File name entry field
		textFieldProperName = new Text(projectGroup, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		data.horizontalSpan = 2;
		textFieldProperName.setLayoutData(data);
		textFieldProperName.setFont(parent.getFont());

		// Set the initial value first before listener
		// to avoid handling an event during the creation.
		if (getInitialTextFieldValue() != null) {
			textFieldProperName.setText(getInitialTextFieldValue());
			textFieldProperName.selectAll();
		}
		textFieldProperName.addListener(SWT.Modify, nameModifyListener);

	}

	private String getTextFieldValue() {
		if (textFieldProperName == null) {
			return ""; //$NON-NLS-1$
		}

		return textFieldProperName.getText().trim();
	}

	private String getInitialTextFieldValue() {
		return "newPropertiesFile"; //$NON-NLS-1$
	}

	private IStatus doWorkspaceValidation(IWorkspace workspace, String text) {
		IStatus ret = workspace.validateName(text, IResource.FILE);
		return ret;
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			textFieldProperName.setFocus();
			textFieldProperName.selectAll();
		}
	}

	public void setSelection(Object firstElement) {
		selection = firstElement;

	}

	public Object getSelection() {
		return selection;
	}

	/*
	 * Equivalente al performFinish En este método o que se hace es comprobar que el que archivo de propiedades no
	 * exista y crearlo en blanco. Despues de crearlo se abrira el archivo en la pantalla.
	 */

	@Override
	public void createResource() throws CoreException {

		IFile PropertiesFile = null;
		String PropertiesFileName = getText();
		path = getPath();
		// Comprobamos que existe la carpeta de properties. En caso de que no exista, la creamos para evitar errores y
		// que se pueda crear el fichero sin ningun problema.
		PropertiesFile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		if (!PropertiesFile.getParent().exists()) {
			IPath pathParent = PropertiesFile.getParent().getFullPath();
			IFolder PropertiesFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(pathParent);
			PropertiesFolder.create(true, true, null);
		}
		if (!PropertiesFile.exists()) {
			// No existe, se procede a la creación. Se crea vacio. Si se crea con el sources a null da error al
			// mostrarlo.
			String contents = "";
			InputStream source = new ByteArrayInputStream(contents.getBytes());
			try {
				PropertiesFile.create(source, true, null);
			} catch (ResourceException e) {
				handleException(e);
				MessageDialog.openError(null, "Error", "A resource \"" + PropertiesFileName
						+ "\" exists with a different case. Please check Error Log.");
			}
		}

		// Se procede a abrir el fichero creado en pantalla.
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		file = PropertiesFile;
		if (file.exists()) {
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

	public IFile getFile() {
		return file;
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

	/*
	 * Método para recuperar la ruta donde se guardan los properties. Depende desde donde hayamos iniciado la creación,
	 * un proyecto o un paquete, para montarla.
	 */
	private IPath getPath() {
		String nameproject = null;
		if (selection instanceof JVProject) {
			nameproject = ((JVProject) selection).getName();
			return new Path("/" + nameproject).append(PROPERTIES_PATH).append(getTextFieldValue())
					.addFileExtension(PROPERTY);
		} else if (selection instanceof JVPackage) {
			nameproject = ((JVPackage) selection).getOwnerModule().getName();
			return new Path("/" + nameproject).append(PROPERTIES_PATH).append(getTextFieldValue())
					.addFileExtension(PROPERTY);
		} else {
			return null;
		}

	}

}
