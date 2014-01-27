package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.ParameterizedState;

public class CallFlowStateSection extends ParametrizableStateSection {

	private LabelAndTextAndButton subFlow;

	public CallFlowStateSection() {
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage atabbedPropertySheetPage) {
		super.createControls(parent, atabbedPropertySheetPage);

		subFlow = createLabelAndTextAndButton("Subflow", "", null, -1);
		subFlow.text.setEnabled(false);

	}

	@Override
	public void refresh() {
		super.refresh();

		if (((CallFlowState) state).getSubflow().getName() != null) {
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

	@Override
	protected LabelAndText createLabelAndText(String labelText, String value, final EStructuralFeature feature,
			final int index) {
		return super.createLabelAndText(labelText, value, feature, index);
	}
}
