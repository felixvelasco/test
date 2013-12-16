package com.vectorsf.jvoice.ui.navigator.util;

import org.eclipse.jface.wizard.Wizard;

import com.vectorsf.jvoice.model.operations.Flow;

public class RenameFlowParameterWizard extends Wizard {
	protected RenameFlowParameterPage one;
	public String newParamName;
	private Flow flow;
	private String oldParamName;

	public RenameFlowParameterWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	public RenameFlowParameterWizard(Flow flow, String oldParamName) {
		super();
		setNeedsProgressMonitor(true);
		this.flow = flow;
		this.oldParamName = oldParamName;
	}

	@Override
	public void addPages() {
		one = new RenameFlowParameterPage();
		addPage(one);
	}

	@Override
	public boolean performFinish() {
		newParamName = one.getText();
		return true;
	}

	public String getParamName() {
		return newParamName;
	}
}