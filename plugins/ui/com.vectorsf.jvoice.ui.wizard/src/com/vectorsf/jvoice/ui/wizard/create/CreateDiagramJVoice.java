/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2005, 2010 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    SAP AG - initial API, implementation and documentation
 *    Bug 336488 - DiagramEditor API
 *
 * </copyright>
 *
 *******************************************************************************/
package com.vectorsf.jvoice.ui.wizard.create;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.ui.wizard.page.AbstractWizardPage;
import com.vectorsf.jvoice.ui.wizard.page.DiagramNameWizardPage;

/**
 * The Class CreateDiagramWizard.
 */
public class CreateDiagramJVoice extends BasicNewResourceWizard {

	private static final String PAGE_NAME_DIAGRAM_NAME = "Flow Name";
	private static final String WIZARD_WINDOW_TITLE = "New Flow";
	private static IFolder myPackage;
	DiagramNameWizardPage pageName;

	public CreateDiagramJVoice() {
	}
	
	public CreateDiagramJVoice(IFolder ownerPackage) {
		myPackage = ownerPackage;
	}

	@Override
	public void addPages() {
		IWizardContainer container = getContainer();
		if (container instanceof WizardDialog)
		{
			((WizardDialog) container).setHelpAvailable(false);
		}
		super.addPages();
		if (myPackage == null){
			pageName = new DiagramNameWizardPage(
					PAGE_NAME_DIAGRAM_NAME);
			pageName.setSelection(getSelection().getFirstElement());
			addPage(pageName);
		}else{
			pageName = new DiagramNameWizardPage(
					PAGE_NAME_DIAGRAM_NAME, false);
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
			((AbstractWizardPage) getPage(PAGE_NAME_DIAGRAM_NAME))
					.createResource();
		} catch (CoreException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public Flow getReturnFlow(){
		return pageName.returnFlow();
	}
}
