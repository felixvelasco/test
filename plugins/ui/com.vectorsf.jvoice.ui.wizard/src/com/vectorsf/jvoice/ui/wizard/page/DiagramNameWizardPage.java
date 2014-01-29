package com.vectorsf.jvoice.ui.wizard.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.runtime.CommonMessages;
import org.eclipse.core.internal.runtime.IRuntimeConstants;
import org.eclipse.core.internal.runtime.RuntimeLog;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
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
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.mm.pictograms.PictogramsFactory;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.dialogs.ErrorDialog;
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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.navigator.CommonNavigator;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.Transition;
import com.vectorsf.jvoice.ui.wizard.Activator;

public class DiagramNameWizardPage extends AbstractWizardPage {

	private static final String PAGE_DESC = "Enter a flow name";
	private static final String PAGE_TITLE = "Create a Flow";
	private static final Path PACKAGES_PATH = new Path(BaseModel.JV_PATH);

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	Text textFieldDiagram;
	Text textFieldProject;
	Text textFieldPackage;

	private Button browsePackage;
	private boolean first;
	private boolean projectEnable = true;
	private Flow flow;

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

	public DiagramNameWizardPage(String pageName) {
		this(pageName, true);
	}

	public DiagramNameWizardPage(String pageName, boolean projectEnable) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
		first = true;
		this.projectEnable = projectEnable;
		setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "res/wizban/icon_wiz_flow.png"));
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
		if (textFieldDiagram == null) {
			return getInitialTextFieldValue();
		}

		return getTextFieldValue();
	}

	protected boolean validatePage() {
		String text = getTextFieldValue();
		if (text.isEmpty()) {
			setErrorMessage(null);
			setMessage("Enter a flow name");
			return false;
		}

		char initial = text.charAt(0);
		if (Character.isDigit(initial)) {
			setErrorMessage("The first letter of the flow name can't be a number.");
			return false;
		}
		String projectName = getProjectFieldValue();
		if (projectName.isEmpty()) {
			setErrorMessage("Enter a project name");
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
		browsePackage.setEnabled(true);

		if (packageName.isEmpty()) {
			setErrorMessage("Enter a package name");
			return false;
		}

		JVPackage paquete = module.getPackage(packageName);

		if (paquete == null) {
			setErrorMessage("Package does not exist");
			return false;
		}

		JVBean diagrama = paquete.getBean(text);

		if (diagrama != null) {
			if (first) {
				first = false;
				return false;
			}
			setErrorMessage("Flow already exists");
			return false;
		}
		first = false;
		setSelection(paquete);
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

		JVProject project = null;
		JVPackage diagramFolder = null;
		if (selection instanceof IProject) {
			IProject iProject = (IProject) selection;
			project = BaseModel.getInstance().getModel().getProject(iProject.getName());
		} else if (selection instanceof IFolder) {
			IFolder folder = (IFolder) selection;
			IPath relativePath = folder.getProjectRelativePath().makeRelativeTo(PACKAGES_PATH);
			String nameFolder = relativePath.toString().replace("/", ".");
			IProject iProject = folder.getProject();
			project = BaseModel.getInstance().getModel().getProject(iProject.getName());

			// si el proyecto es nulo es porque el proyecto donde se quiere
			// crear el flujo no
			// es un proyecto jvoice
			if (project instanceof JVModule) {
				diagramFolder = ((JVModule) project).getPackage(nameFolder);
			}
		} else if (selection instanceof JVProject) {
			project = (JVProject) selection;
		} else if (selection instanceof JVPackage) {
			diagramFolder = (JVPackage) selection;
			project = diagramFolder.getOwnerModule();
		} else if (selection instanceof IPackageFragmentRoot) {
			IPackageFragmentRoot prueba = (IPackageFragmentRoot) selection;
			IFolder folder = (IFolder) prueba.getResource();
			IProject iProject = folder.getProject();
			project = BaseModel.getInstance().getModel().getProject(iProject.getName());
			if (project instanceof JVModule) {
				diagramFolder = ((JVModule) project).getPackage(folder.getName());
			}
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
		projectLabel.setText("Flow name:");
		projectLabel.setFont(parent.getFont());

		// new project name entry field
		textFieldDiagram = new Text(projectGroup, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		data.horizontalSpan = 2;
		textFieldDiagram.setLayoutData(data);
		textFieldDiagram.setFont(parent.getFont());

		// new project label
		Label projectLabel2 = new Label(projectGroup, SWT.NONE);
		projectLabel2.setText("Project name:");
		projectLabel2.setFont(parent.getFont());

		textFieldProject = new Text(projectGroup, SWT.BORDER);
		GridData data2 = new GridData(GridData.FILL_HORIZONTAL);
		data2.widthHint = SIZING_TEXT_FIELD_WIDTH;
		textFieldProject.setLayoutData(data2);
		textFieldProject.setFont(parent.getFont());
		textFieldProject.setEditable(false);

		// browse button on right
		Button browse = new Button(projectGroup, SWT.PUSH);
		browse.setText("Browse...");
		browse.setEnabled(projectEnable);
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
				} else {
					textFieldProject.setText("");
				}
			}
		});

		// new project label
		Label projectLabel3 = new Label(projectGroup, SWT.NONE);
		projectLabel3.setText("Package name:");
		projectLabel3.setFont(parent.getFont());

		textFieldPackage = new Text(projectGroup, SWT.BORDER);
		GridData data3 = new GridData(GridData.FILL_HORIZONTAL);
		data3.widthHint = SIZING_TEXT_FIELD_WIDTH;
		textFieldPackage.setLayoutData(data3);
		textFieldPackage.setFont(parent.getFont());
		textFieldPackage.setEditable(false);

		// browse button on right
		browsePackage = new Button(projectGroup, SWT.PUSH);
		browsePackage.setText("Browse...");
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

	@Override
	public void createResource() throws CoreException {
		String diagramName = getText();
		IProject project = null;
		IFolder diagramFolder = null;

		Object element = getSelection();
		if (element instanceof JVProject) {
			project = (IProject) Platform.getAdapterManager().getAdapter(element, IProject.class);
		} else if (element instanceof JVPackage) {
			diagramFolder = (IFolder) Platform.getAdapterManager().getAdapter(element, IFolder.class);
			project = diagramFolder.getProject();
		}

		if (project == null || !project.isAccessible()) {
			String error = "No Project Found";
			IStatus status = new Status(IStatus.ERROR, "1", error);
			ErrorDialog.openError(getShell(), error, null, status);
			throw new CoreException(status);
		}

		Diagram diagram = Graphiti.getPeCreateService().createDiagram("jVoiceDiagram", diagramName, true);

		String editorExtension = "jvflow"; //$NON-NLS-1$

		IFile diagramFile = diagramFolder != null ? diagramFolder.getFile(diagramName + "." + editorExtension)
				: project.getFile(diagramName + "." + editorExtension); //$NON-NLS-1$
		URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);

		createFile(uri, diagram, diagramName);

		// Creamos la carpeta de recursos del flow
		final IFolder packageFolder = project.getFolder(BaseModel.JV_PATH + "/" + toPath(getPackageFieldValue()));
		String folderName = getFolderName(packageFolder, diagramName);

		final IFolder resourcesFolder = getFolder(folderName);
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				createRecursively(resourcesFolder, monitor);
			}
		};

		ResourcesPlugin.getWorkspace().run(runnable, resourcesFolder.getProject(), IWorkspace.AVOID_UPDATE, null);
		// Reveal new flow on navigator
		for (Shell shell : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getShells()) {
			if (shell.getText().contains("New Flow")) {
				shell.close();
			}
		}
		for (IViewPart view : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViews()) {
			if (view.getTitle().equals("Navigator IVR")) {
				CommonNavigator commmonNavigator = (CommonNavigator) view;
				URI flowUri = uri.appendFragment("/1");
				EObject eObject = BaseModel.getInstance().getResourceSet().getEObject(flowUri, false);
				StructuredSelection structuredSelection = new StructuredSelection(eObject);
				commmonNavigator.selectReveal(structuredSelection);
			}
		}

		try {
			IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), diagramFile);
		} catch (PartInitException e) {
			String error = "error open editor";
			IStatus status = new Status(IStatus.ERROR, "0", error, e);
			ErrorDialog.openError(getShell(), error, null, status);
			throw new CoreException(status);
		}
	}

	public void createFile(URI diagramResourceUri, final Diagram diagram, final String diagramName) {

		// Create a resource set and EditingDomain
		final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE
				.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();
		// Create a resource for this file.
		final Resource resource = resourceSet.createResource(diagramResourceUri);
		final CommandStack commandStack = editingDomain.getCommandStack();

		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				resource.setTrackingModification(true);
				resource.getContents().add(diagram);
				flow = OperationsFactory.eINSTANCE.createFlow();
				flow.setDescription(diagramName);
				flow.setName(diagramName);

				resource.getContents().add(flow);

				// create new link
				PictogramLink link = PictogramsFactory.eINSTANCE.createPictogramLink();
				link.setPictogramElement(diagram);
				// add new link to diagram
				diagram.getPictogramLinks().add(link);
				link.getBusinessObjects().add(flow);

				IFeatureProvider featureProvider = GraphitiUi.getExtensionManager().createFeatureProvider(diagram);

				InitialState iState = OperationsFactory.eINSTANCE.createInitialState();
				iState.setName("Initial");
				flow.getStates().add(iState);
				AddContext addContext = new AddContext();
				addContext.setTargetContainer(diagram);
				addContext.setLocation(400, 0);
				addContext.setNewObject(iState);
				PictogramElement initialPe = featureProvider.addIfPossible(addContext);
				Anchor initialAnchor = Graphiti.getPeService().getChopboxAnchor((AnchorContainer) initialPe);

				FinalState fState = OperationsFactory.eINSTANCE.createFinalState();
				fState.setName("Final");
				flow.getStates().add(fState);
				addContext = new AddContext();
				addContext.setTargetContainer(diagram);
				addContext.setLocation(400, 200);
				addContext.setNewObject(fState);
				PictogramElement finalPe = featureProvider.addIfPossible(addContext);
				Anchor finalAnchor = Graphiti.getPeService().getChopboxAnchor((AnchorContainer) finalPe);

				Transition transition = OperationsFactory.eINSTANCE.createTransition();
				transition.setSource(iState);
				transition.setTarget(fState);
				transition.setEventName("Ok");
				flow.getTransitions().add(transition);

				AddConnectionContext addContextInicial = new AddConnectionContext(initialAnchor, finalAnchor);
				addContextInicial.setNewObject(transition);

				PictogramElement connection = featureProvider.addIfPossible(addContextInicial);
				featureProvider.layoutIfPossible(new LayoutContext(connection));
				featureProvider.layoutIfPossible(new LayoutContext(finalPe));
				featureProvider.layoutIfPossible(new LayoutContext(initialPe));
			}
		});

		IWorkspaceRunnable wsRunnable = new IWorkspaceRunnable() {
			@Override
			public void run(final IProgressMonitor monitor) throws CoreException {

				final Runnable runnable = new Runnable() {
					@Override
					public void run() {
						try {
							resource.save(null);
						} catch (IOException e) {
							handleException(e);
							MessageDialog.openError(null, "Error",
									"A resource exists with a different case. Please check Error Log.");
						}
					}
				};

				try {
					editingDomain.runExclusive(runnable);
				} catch (final InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		};
		try {
			ResourcesPlugin.getWorkspace().run(wsRunnable, null);
		} catch (final CoreException e) {
			final Throwable cause = e.getStatus().getException();
			if (cause instanceof RuntimeException) {
				throw (RuntimeException) cause;
			}
			throw new RuntimeException(e);
		}
		editingDomain.dispose();
	}

	public Flow returnFlow() {
		return flow;
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

	private void createRecursively(IFolder container, IProgressMonitor monitor) throws CoreException {
		IContainer parent = container.getParent();
		if (parent instanceof IFolder && !parent.exists()) {
			createRecursively((IFolder) parent, monitor);
		}

		if (!container.exists()) {
			container.create(true, true, monitor);
		}

	}

	public IFolder getFolder(String folderName) {
		IProject project = getProject();
		return project.getFolder(folderName);
	}

	private IProject getProject() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectFieldValue());
	}

	private String toPath(String packageFieldValue) {
		return packageFieldValue.replace('.', '/');
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
}
