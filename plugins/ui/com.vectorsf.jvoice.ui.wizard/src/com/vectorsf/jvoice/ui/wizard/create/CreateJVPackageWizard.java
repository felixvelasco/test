package com.vectorsf.jvoice.ui.wizard.create;

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
import com.vectorsf.jvoice.ui.wizard.page.PackageNameWizardPage;

public class CreateJVPackageWizard extends BasicNewResourceWizard {

	private static final String PAGE_NAME_PROJECT_NAME = "Package Name";
	private static final String WIZARD_WINDOW_TITLE = "New Package";

	@Override
	public void addPages() {
		IWizardContainer container = getContainer();
		if (container instanceof WizardDialog) {
			((WizardDialog) container).setHelpAvailable(false);
		}
		super.addPages();
		PackageNameWizardPage pageName = new PackageNameWizardPage(PAGE_NAME_PROJECT_NAME);
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
			((AbstractWizardPage) getPage(PAGE_NAME_PROJECT_NAME)).createResource();
		} catch (CoreException e) {
			Activator.getDefault().getLog()
					.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error creando recurso", e));

			e.printStackTrace();
			return false;
		}

		return true;
	}
}