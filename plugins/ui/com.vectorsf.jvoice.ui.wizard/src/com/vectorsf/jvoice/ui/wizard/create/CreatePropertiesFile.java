package com.vectorsf.jvoice.ui.wizard.create;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.vectorsf.jvoice.ui.wizard.Activator;
import com.vectorsf.jvoice.ui.wizard.page.AbstractWizardPage;
import com.vectorsf.jvoice.ui.wizard.page.PropertiesFileNameWizardPage;

public class CreatePropertiesFile extends BasicNewResourceWizard {

	private static final String PAGE_NAME_DSL_NAME = "Properties File Name";
	private static final String WIZARD_WINDOW_TITLE = "New Properties File";
	private IFolder myPackage;
	PropertiesFileNameWizardPage pageName;

	public CreatePropertiesFile() {
	}

	public CreatePropertiesFile(IFolder ownerPackage) {
		this.myPackage = ownerPackage;
	}

	@Override
	public void addPages() {
		IWizardContainer container = getContainer();
		if (container instanceof WizardDialog) {
			((WizardDialog) container).setHelpAvailable(false);
		}

		super.addPages();
		if (myPackage == null) {
			pageName = new PropertiesFileNameWizardPage(PAGE_NAME_DSL_NAME);
			pageName.setSelection(getSelection().getFirstElement());
			addPage(pageName);
		} else {
			pageName = new PropertiesFileNameWizardPage(PAGE_NAME_DSL_NAME, false);
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
			Activator.getDefault().getLog()
					.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error creando recurso", e));

			e.printStackTrace();
			return false;
		}

		return true;

	}

	public IFile getFile() {
		return pageName.getFile();
	}

}
