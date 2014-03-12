package com.vectorsf.jvoice.ui.wizard.page;

import java.io.IOException;

import org.eclipse.core.internal.runtime.CommonMessages;
import org.eclipse.core.internal.runtime.IRuntimeConstants;
import org.eclipse.core.internal.runtime.RuntimeLog;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.core.operation.helper.PrototypeCreator;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.Transition;
import com.vectorsf.jvoice.ui.wizard.Activator;

public class FlowCreator {

	private Shell shell;

	public FlowCreator(Shell shell) {
		this.shell = shell;
	}

	public Flow createResource(String diagramName, Object selectedElement, String projectName, String packageName)
			throws CoreException {
		IProject project = null;
		IFolder diagramFolder = null;
		JVModule module = null;

		if (selectedElement instanceof JVModule) {
			project = (IProject) Platform.getAdapterManager().getAdapter(selectedElement, IProject.class);
			module = (JVModule) selectedElement;
		} else if (selectedElement instanceof JVPackage) {
			diagramFolder = (IFolder) Platform.getAdapterManager().getAdapter(selectedElement, IFolder.class);
			project = diagramFolder.getProject();
			module = ((JVPackage) selectedElement).getOwnerModule();
		}

		if (project == null || !project.isAccessible()) {
			String error = "No Project Found";
			IStatus status = new Status(IStatus.ERROR, "1", error);
			ErrorDialog.openError(shell, error, null, status);
			throw new CoreException(status);
		}

		Diagram diagram = Graphiti.getPeCreateService().createDiagram("jVoiceDiagram", diagramName, true);

		String editorExtension = "jvflow"; //$NON-NLS-1$

		IFile diagramFile = diagramFolder != null ? diagramFolder.getFile(diagramName + "." + editorExtension)
				: project.getFile(diagramName + "." + editorExtension); //$NON-NLS-1$
		URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);

		// Calculate resources folder
		IFolder packageFolder = project.getFolder(BaseModel.JV_PATH + "/" + toPath(packageName));
		String folderName = getFolderName(packageFolder, diagramName);
		IFolder resourcesFolder = getFolder(projectName, folderName);

		// Calculate helper file
		IJavaProject jProject = JavaCore.create(project);
		IPackageFragmentRoot packageFragmentRoot = jProject.getPackageFragmentRoot(project.findMember("src/main/java"));
		IPackageFragment packageFragment = packageFragmentRoot.getPackageFragment(module.getComponentsPackage());

		Flow flow = createFile(uri, diagram, packageName, diagramName, resourcesFolder, packageFragment);

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		try {
			IDE.openEditor(activeWorkbenchWindow.getActivePage(), diagramFile);
		} catch (PartInitException e) {
			String error = "error open editor";
			IStatus status = new Status(IStatus.ERROR, "0", error, e);
			ErrorDialog.openError(shell, error, null, status);
			throw new CoreException(status);
		}

		return flow;
	}

	private Flow createFile(URI diagramResourceUri, final Diagram diagram, final String packageName,
			final String diagramName, final IFolder resourcesFolder, IPackageFragment packageFragment)
			throws JavaModelException {

		// Create a resource set and EditingDomain
		final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE
				.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();
		// Create a resource for this file.
		final Resource resource = resourceSet.createResource(diagramResourceUri);
		final CommandStack commandStack = editingDomain.getCommandStack();
		final Flow flow = OperationsFactory.eINSTANCE.createFlow();
		final IPackageFragment helperClassPackage = findHelperClassPackage(packageFragment, packageName);
		final String helperClassName = toClassName(diagramName);

		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				resource.setTrackingModification(true);
				resource.getContents().add(diagram);
				flow.setDescription(diagramName);
				flow.setName(diagramName);
				String helperClassFqdn = helperClassPackage.getElementName() + "." + helperClassName;
				flow.setHelperClass(helperClassFqdn);

				ComponentBean defaultBean = OperationsFactory.eINSTANCE.createComponentBean();
				defaultBean.setFqdn(helperClassFqdn);
				String lowerCaseHelperClassName = Character.toLowerCase(helperClassName.charAt(0))
						+ helperClassName.substring(1);
				defaultBean.setName(lowerCaseHelperClassName);
				defaultBean.setNameBean(lowerCaseHelperClassName);
				defaultBean.setPrototype(true);
				flow.getBeans().add(defaultBean);

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
						}
					}
				};

				try {
					editingDomain.runExclusive(runnable);

					// Creamos la carpeta de recursos del flow
					createRecursively(resourcesFolder, monitor);

					// Creamos el bean asociado
					PrototypeCreator.createBeanFor(helperClassName, helperClassPackage, monitor);

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

		return flow;
	}

	private String toClassName(String diagramName) {
		return Character.toUpperCase(diagramName.charAt(0)) + diagramName.substring(1);
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

	private String toPath(String packageFieldValue) {
		return packageFieldValue.replace('.', '/');
	}

	private IFolder getFolder(String projectName, String folderName) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		return project.getFolder(folderName);
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

	private IPackageFragment findHelperClassPackage(IPackageFragment packageFragment, String packageName)
			throws JavaModelException {
		IPackageFragmentRoot iPackageFragmentRoot = (IPackageFragmentRoot) packageFragment.getParent();
		String componentsPackageName = packageFragment.getElementName();
		if (packageName.startsWith(componentsPackageName)) {
			return iPackageFragmentRoot.createPackageFragment(packageName, true, null);
		} else {
			return iPackageFragmentRoot.createPackageFragment(componentsPackageName + "." + packageName, true, null);
		}
	}

	private void handleException(Throwable e) {
		if (!(e instanceof OperationCanceledException)) {
			// try to obtain the correct plug-in id for the bundle providing the safe runnable
			Activator activator = Activator.getDefault();
			String pluginId = Activator.PLUGIN_ID;
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
