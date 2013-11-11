package com.vectorsf.jvoice.ui.wizard.create;


import org.eclipse.core.runtime.CoreException;
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
		if (container instanceof WizardDialog)
		{
			((WizardDialog) container).setHelpAvailable(false);
		}
		super.addPages();
		ProjectNameWizardPage pageName = new ProjectNameWizardPage(
				PAGE_NAME_PROJECT_NAME);
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
		
		final String ProjectName = ((ProjectNameWizardPage) getPage(PAGE_NAME_PROJECT_NAME))
				.getText();
		
		final String descriptionProject = ((ProjectNameWizardPage) getPage(PAGE_NAME_PROJECT_NAME))
				.getDescription();
		
		try {
			JVoiceProjectConfigurator.createProject(ProjectName, ProjectName, ProjectName, descriptionProject);
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}