package com.vectorsf.jvoice.ui.wizard.create;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.vectorsf.jvoice.core.project.JVoiceApplicationConfigurator;
import com.vectorsf.jvoice.ui.wizard.page.ProjectNameWizardPage;

public class CreateJVoiceApplicationWizard extends BasicNewResourceWizard {

	private static final String PAGE_NAME_APPLICATION_NAME = "Application Project Name";
	private static final String WIZARD_WINDOW_TITLE = "New Application Project";
	private static final String ENDPOINTS_DIR = "src/main/resources/com/vectorsf/";
	private static final String SEPARATOR = "/";
	private static final String WS = "ws";

	@Override
	public void addPages() {
		IWizardContainer container = getContainer();
		if (container instanceof WizardDialog) {
			((WizardDialog) container).setHelpAvailable(false);
		}
		super.addPages();
		ProjectNameWizardPage pageName = new ProjectNameWizardPage(PAGE_NAME_APPLICATION_NAME,
				"res/wizban/icon_wiz_app.png");
		addPage(pageName);
	}

	@Override
	public boolean canFinish() {
		return super.canFinish();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		setWindowTitle(WIZARD_WINDOW_TITLE);
	}

	@Override
	public boolean needsProgressMonitor() {
		return true;
	}

	@Override
	public boolean performFinish() {

		final String applicationName = ((ProjectNameWizardPage) getPage(PAGE_NAME_APPLICATION_NAME)).getText();

		final String descriptionProject = ((ProjectNameWizardPage) getPage(PAGE_NAME_APPLICATION_NAME))
				.getDescription();

		try {
			getContainer().run(true, true, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					try {
						monitor.beginTask("Create application", 100);
						IProject app = JVoiceApplicationConfigurator.createApplication(applicationName,
								applicationName, applicationName, descriptionProject, monitor);
						// Creamos el ws-endpoints.xml en dentro de la carpeta resources
						String path = app.getLocationURI().toString();
						File wsendpointsDirectory = new File(path.substring(6, path.length()), ENDPOINTS_DIR
								+ SEPARATOR + applicationName + SEPARATOR + WS);
						wsendpointsDirectory.mkdirs();
						XMLGeneratorENDP.generate(new File(wsendpointsDirectory, "ws-endpoints.xml"));
					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					} finally {
						monitor.done();
					}
				}
			});

		} catch (InvocationTargetException | InterruptedException e) {
			return false;
		}

		return true;
	}

}