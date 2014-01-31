package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.ParameterizedState;
import com.vectorsf.jvoice.ui.diagram.properties.section.SubFlowChooser;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.LabelAndText;

public class CallFlowStateSection extends ParametrizableStateSection {

	private LabelAndText subFlow;

	public CallFlowStateSection() {
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage atabbedPropertySheetPage) {
		super.createControls(parent, atabbedPropertySheetPage);

		subFlow = createLabelTextAndButton("Subflow:", "", OperationsPackage.eINSTANCE.getCallFlowState_Subflow(),
				new SubFlowChooser());
		subFlow.text.setEnabled(false);

	}

	@Override
	public void refresh() {
		super.refresh();

		if (state != null && ((CallFlowState) state).getSubflow().getName() != null) {
			subFlow.text.setText(((CallFlowState) state).getSubflow().getName());
		} else {
			subFlow.text.setText("");
		}

	}

	@Override
	protected String[] getParameterNames(ParameterizedState state) {
		CallFlowState subFlowState = (CallFlowState) state;
		return subFlowState.getSubflow().getParameters().toArray(new String[0]);
	}
}
