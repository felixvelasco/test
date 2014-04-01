package com.vectorsf.jvoice.ui.wizard.create;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.vectorsf.jvoice.core.operation.helper.FlowService;
import com.vectorsf.jvoice.core.operation.helper.PrototypeCreator;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.ui.wizard.Activator;
import com.vectorsf.jvoice.ui.wizard.page.CreateDefinitionWizardPage;
import com.vectorsf.jvoice.ui.wizard.page.SelectDefinitionWizardPage;

public class CreateDefinitionWizard extends BasicNewResourceWizard {

	private static final String WIZARD_WINDOW_TITLE = "New Definition";
	public static final String TEXTUAL = "TextualDefinition";
	public static final String PROGRAMMABLE = "ProgrammableDefinition";
	public static final String CREATION = "_creation";

	private Flow flow;
	private URI textualDefinitonURI;

	private DefinitionHelper definition;

	private CreateDefinitionWizardPage createPage;
	private SelectDefinitionWizardPage selectPage;
	private boolean textual;
	private IMethod methodHandle;

	public CreateDefinitionWizard(Flow flow, DefinitionHelper definition) {
		this.flow = flow;
		this.definition = definition;
		textual = true;
	}

	@Override
	public void addPages() {
		IWizardContainer container = getContainer();
		if (container instanceof WizardDialog) {
			((WizardDialog) container).setHelpAvailable(false);
		}

		createPage = new CreateDefinitionWizardPage(this, flow);
		addPage(createPage);

		selectPage = new SelectDefinitionWizardPage(this, flow, definition);
		addPage(selectPage);
	}

	@Override
	public boolean needsPreviousAndNextButtons() {
		return false;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		setWindowTitle(WIZARD_WINDOW_TITLE);
	}

	@Override
	public boolean performFinish() {

		if (getContainer().getCurrentPage() == createPage) {
			if (createPage.isTextual()) {
				try {
					textualDefinitonURI = createTextualResource();
				} catch (CoreException e) {
					e.printStackTrace();
					Activator.getDefault().getLog()
							.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error creando recurso", e));

					return false;
				}
			} else {
				try {
					methodHandle = createMethod();
				} catch (JavaModelException e) {
					e.printStackTrace();
					Activator.getDefault().getLog()
							.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error creando metodo", e));

					return false;
				}
			}
		} else {
			Object selectedElement = selectPage.getSelectedElement();
			if (selectPage.isTextual()) {
				textualDefinitonURI = EcoreUtil.getURI((EObject) selectedElement);
			} else {
				methodHandle = (IMethod) selectedElement;
			}
		}

		return true;
	}

	@Override
	public boolean canFinish() {
		return getContainer().getCurrentPage().isPageComplete();
	}

	public boolean isTextual() {
		return textual;
	}

	public void setTextual(boolean textual) {
		this.textual = textual;
		selectPage.setTextual(textual);
		createPage.setTextual(textual);
	}

	private IMethod createMethod() throws JavaModelException {
		IType helperType = FlowService.getHelperType(flow);
		String returnType = getReturnType();
		helperType.getCompilationUnit().createImport("com.vectorsf.placeholder." + returnType, null, null);
		helperType.getCompilationUnit()
				.createImport("com.vectorsf.services.placeholder.DefinitionsService", null, null);
		helperType.getCompilationUnit().createImport("org.springframework.beans.factory.annotation.Autowired", null,
				null);

		if (!helperType.getField("definitionsService").exists()) {
			helperType.createField(PrototypeCreator.createInjectedField("definitionsService", "DefinitionsService")
					.toString(), null, false, null);
		}

		String methodBody = PrototypeCreator.createMethod(createPage.getDefinitionName(), returnType).toString();

		IMethod createMethod = helperType.createMethod(methodBody, null, false, null);
		try {
			JavaUI.openInEditor(createMethod);
		} catch (PartInitException e) {
			String error = "error open editor";
			IStatus status = new Status(IStatus.ERROR, "0", error, e);
			ErrorDialog.openError(getShell(), error, null, status);
			throw new JavaModelException(new CoreException(status));
		}

		return createMethod;
	}

	private String getReturnType() {
		switch (definition) {
		case INPUT:
			return "IInput";
		case MENU:
			return "IMenu";
		case RECORD:
			return "IRecord";
		case OUTPUT:
			return "IOutput";
		case TRANSFER:
			return "ITransfer";
		}
		return null;
	}

	public URI createTextualResource() throws CoreException {

		String dslName = createPage.getDefinitionName();
		IFolder dslFolder = null;
		String editorExtension = "voiceDsl";
		IFile dslFile = null;
		URI retUri = null;

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
				try (InputStream source = definition.getInputStreamFromFile(dslName)) {
					dslFile.create(source, true, null);
				} catch (@SuppressWarnings("restriction") org.eclipse.core.internal.resources.ResourceException e) {
					MessageDialog.openError(null, "Error", "A resource \"" + dslName
							+ "\" exists with a different case. Please check Error Log.");
				} catch (IOException e1) {
					Activator.getDefault().getLog()
							.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error leyendo fichero", e1));

					e1.printStackTrace();
				}
			}
		}

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (dslFile.exists()) {
			retUri = URI.createPlatformResourceURI(dslFile.getFullPath().toString(), true).appendFragment("/0");

			try {
				IDE.openEditor(page, dslFile);
			} catch (PartInitException e) {
				String error = "error open editor";
				IStatus status = new Status(IStatus.ERROR, "0", error, e);
				ErrorDialog.openError(getShell(), error, null, status);
				throw new CoreException(status);
			}
		}

		return retUri;
	}

	private IFolder findLocutionFolder() {

		IResource res = (IResource) Platform.getAdapterManager().getAdapter(flow, IResource.class);
		IFolder packageFolder = (IFolder) res.getParent();
		IFolder dslFolder = packageFolder.getFolder(flow.getName() + ".resources");

		return dslFolder;
	}

	public URI getURI() {
		return textualDefinitonURI;
	}

	public IMethod getMethod() {
		return methodHandle;
	}

}
