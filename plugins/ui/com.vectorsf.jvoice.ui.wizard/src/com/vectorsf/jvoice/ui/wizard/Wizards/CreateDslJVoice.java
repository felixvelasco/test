package com.vectorsf.jvoice.ui.wizard.Wizards;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

public class CreateDslJVoice extends BasicNewResourceWizard {
	
	private static final String PAGE_NAME_DSL_NAME = "JVoice DSL Name";
	private static final String WIZARD_WINDOW_TITLE = "New JVoice DSL";
	
	@Override
	public void addPages() {
		super.addPages();
		DslNameWizardPage pageName = new DslNameWizardPage(
				PAGE_NAME_DSL_NAME);
		pageName.setSelection(getSelection().getFirstElement());
		addPage(pageName);
	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		setWindowTitle(WIZARD_WINDOW_TITLE);
	}

	@Override
	public boolean performFinish() {

		try {
			((AbstractWizardPage) getPage(PAGE_NAME_DSL_NAME))
					.createResource();
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

}
