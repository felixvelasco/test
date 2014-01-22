package com.vectorsf.jvoice.ui.wizard.create;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.ui.wizard.page.AbstractWizardPage;
import com.vectorsf.jvoice.ui.wizard.page.DslNameWizardPage;

public class CreateDslJVoice extends BasicNewResourceWizard {

	private static final String PAGE_NAME_DSL_NAME = "Definition Name";
	private static final String WIZARD_WINDOW_TITLE = "New Definition";
	private IFolder folder;
	private Class<? extends VoiceDsl> targetClazz;
	private DslNameWizardPage pageName;

	public CreateDslJVoice() {
	}

	public CreateDslJVoice(IFolder folder, Class<? extends VoiceDsl> targetClazz) {
		this.folder = folder;
		this.targetClazz = targetClazz;
	}

	@Override
	public void addPages() {
		IWizardContainer container = getContainer();
		if (container instanceof WizardDialog) {
			((WizardDialog) container).setHelpAvailable(false);
		}

		super.addPages();
		if (folder == null) {
			pageName = new DslNameWizardPage(PAGE_NAME_DSL_NAME);
			pageName.setSelection(getSelection().getFirstElement());
			addPage(pageName);
		} else {
			pageName = new DslNameWizardPage(PAGE_NAME_DSL_NAME, targetClazz);
			pageName.setSelection(folder);
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

	public URI getURI() {
		return pageName.returnURI();
	}

}
