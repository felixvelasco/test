package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.ParameterizedState;

public class CallFlowStateSection extends ParametrizableStateSection {

	private LabelAndText subFlow;

	public CallFlowStateSection() {
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage atabbedPropertySheetPage) {
		super.createControls(parent, atabbedPropertySheetPage);

		subFlow = createLabelAndText("Subflow", "", null, -1);
		subFlow.text.setEnabled(false);
	}

	@Override
	public void refresh() {
		super.refresh();

		subFlow.text.setText(((CallFlowState) state).getSubflow().getName());
	}

	@Override
	protected String[] getParameterNames(ParameterizedState state) {
		CallFlowState subFlowState = (CallFlowState) state;
		return subFlowState.getSubflow().getParameters().toArray(new String[0]);
	}
}
