package com.vectorsf.jvoice.ui.wizard.create;

import org.eclipse.core.runtime.CoreException;
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
	public boolean performFinish() {

		final String applicationName = ((ProjectNameWizardPage) getPage(PAGE_NAME_APPLICATION_NAME)).getText();

		final String descriptionProject = ((ProjectNameWizardPage) getPage(PAGE_NAME_APPLICATION_NAME))
				.getDescription();

		try {
			JVoiceApplicationConfigurator.createApplication(applicationName, applicationName, applicationName,
					descriptionProject);
		} catch (CoreException e) {
			return false;
		}

		return true;
	}

}