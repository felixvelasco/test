package com.vectorsf.jvoice.ui.wizard.create;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.vectorsf.jvoice.ui.wizard.page.AbstractWizardPage;
import com.vectorsf.jvoice.ui.wizard.page.CustomNameWizardPage;

public class CreateJspCustom extends BasicNewResourceWizard {

	private static final String PAGE_NAME_DSL_NAME = "Custom Name";
	private static final String WIZARD_WINDOW_TITLE = "New Custom";
	private IFolder myPackage;
	private String tipoDSL;
	CustomNameWizardPage pageName;

	public CreateJspCustom() {
	}

	public CreateJspCustom(IFolder ownerPackage, String tipo) {
		this.myPackage = ownerPackage;
		this.tipoDSL = tipo;
	}

	@Override
	public void addPages() {
		IWizardContainer container = getContainer();
		if (container instanceof WizardDialog) {
			((WizardDialog) container).setHelpAvailable(false);
		}

		super.addPages();
		if (myPackage == null) {
			pageName = new CustomNameWizardPage(PAGE_NAME_DSL_NAME);
			pageName.setSelection(getSelection().getFirstElement());
			addPage(pageName);
		} else {
			pageName = new CustomNameWizardPage(PAGE_NAME_DSL_NAME, false, tipoDSL);
			pageName.setSelection(myPackage);
			addPage(pageName);
		}

	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		setWindowTitle(WIZARD_WINDOW_TITLE);
	}

	@Override
	public boolean performFinish() {

		try {
			((AbstractWizardPage) getPage(PAGE_NAME_DSL_NAME)).createResource();
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public IFile getFile() {
		return pageName.getFile();
	}

}
