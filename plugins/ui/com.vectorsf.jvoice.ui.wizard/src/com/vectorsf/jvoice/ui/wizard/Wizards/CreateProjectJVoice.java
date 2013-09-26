package com.vectorsf.jvoice.ui.wizard.Wizards;


import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.vectorsf.jvoice.core.project.JVoiceProjectConfigurator;



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
		pageName.setSelection(getSelection().getFirstElement());
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
			IProject proyecto = JVoiceProjectConfigurator.createProject(ProjectName, ProjectName, ProjectName);
	
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}