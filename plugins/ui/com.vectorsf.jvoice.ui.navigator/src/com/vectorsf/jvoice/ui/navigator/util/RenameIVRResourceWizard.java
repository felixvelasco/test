package com.vectorsf.jvoice.ui.navigator.util;

import org.eclipse.core.resources.IResource;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.internal.core.refactoring.resource.RenameResourceProcessor;
import org.eclipse.ltk.internal.ui.refactoring.RefactoringUIMessages;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

public class RenameIVRResourceWizard extends RefactoringWizard {

	private IResource resource;
	RenameResourceRefactoringConfigurationPage reconfigRename;

	public RenameIVRResourceWizard(IResource resource) {

		super(new RenameRefactoring(new RenameResourceProcessor(resource)), DIALOG_BASED_USER_INTERFACE);
		setDefaultPageTitle(RefactoringUIMessages.RenameResourceWizard_page_title);
		setWindowTitle(RefactoringUIMessages.RenameResourceWizard_window_title);

		this.resource = resource;
	}

	@Override
	protected void addUserInputPages() {
		RenameResourceProcessor processor = (RenameResourceProcessor) getRefactoring().getAdapter(
				RenameResourceProcessor.class);

		reconfigRename = new RenameResourceRefactoringConfigurationPage(processor, resource);
		addPage(reconfigRename);
	}

	public boolean isDsl() {
		return reconfigRename.isDsl();
	}

	public String getNewName() {
		return reconfigRename.getText();
	}
}
