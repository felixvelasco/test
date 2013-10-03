package com.vectorsf.jvoice.ui.wizard.create;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.vectorsf.jvoice.core.project.JVoiceProjectConfigurator;
import com.vectorsf.jvoice.ui.wizard.page.ProjectNameWizardPage;



/**
 * @author xIS14487
 *
 */
public class CreateProjectJVoice extends BasicNewResourceWizard {
	
	private static final String PAGE_NAME_PROJECT_NAME = "JVoice Project Name";
	private static final String WIZARD_WINDOW_TITLE = "New JVoice Project";

	
	@Override
	public void addPages() {
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
		
		try {
			JVoiceProjectConfigurator.createProject(ProjectName, ProjectName, ProjectName);
		} catch (CoreException e) {
			return false;
		}
		
		return true;
	}

}