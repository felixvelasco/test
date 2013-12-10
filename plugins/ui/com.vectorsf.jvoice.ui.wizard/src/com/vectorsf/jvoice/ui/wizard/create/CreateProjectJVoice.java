package com.vectorsf.jvoice.ui.wizard.create;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.vectorsf.jvoice.core.project.JVoiceProjectConfigurator;
import com.vectorsf.jvoice.ui.wizard.page.ProjectNameWizardPage;

/**
 * @author xIS14487
 * 
 */
public class CreateProjectJVoice extends BasicNewResourceWizard {

	private static final String PAGE_NAME_PROJECT_NAME = "Module Project Name";
	private static final String WIZARD_WINDOW_TITLE = "New Module Project";

	@Override
	public void addPages() {
		IWizardContainer container = getContainer();
		if (container instanceof WizardDialog) {
			((WizardDialog) container).setHelpAvailable(false);
		}
		super.addPages();
		ProjectNameWizardPage pageName = new ProjectNameWizardPage(PAGE_NAME_PROJECT_NAME,
				"res/wizban/icon_wiz_project.png");
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
	public boolean performFinish() {

		final String projectName = ((ProjectNameWizardPage) getPage(PAGE_NAME_PROJECT_NAME)).getText();

		final String projectDescription = ((ProjectNameWizardPage) getPage(PAGE_NAME_PROJECT_NAME)).getDescription();

		try {
			getContainer().run(true, true, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					try {
						monitor.beginTask("Create application", 100);
						JVoiceProjectConfigurator.createProject(projectName, projectName, projectName,
								projectDescription, monitor);
					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					} finally {
						monitor.done();
					}
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}