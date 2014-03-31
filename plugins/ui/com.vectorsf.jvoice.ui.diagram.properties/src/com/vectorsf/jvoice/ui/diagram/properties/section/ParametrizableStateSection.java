package com.vectorsf.jvoice.ui.diagram.properties.section;

import java.util.ArrayList;
import java.util.List;

import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.ParameterizedState;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.LabelAndText;

public abstract class ParametrizableStateSection extends SimpleStateSection {

	private List<LabelAndText> callParameters = new ArrayList<>();

	/**
	 * @param index
	 * @param factory
	 * @param composite
	 */
	protected LabelAndText drawParameter(String name, String value, int index) {
		return createLabelAndText(name + ":", value, OperationsPackage.eINSTANCE.getParameterizedState_Parameters(),
				index);

	}

	@Override
	public void refresh() {
		super.refresh();

		if (state != null) {
			ParameterizedState pState = (ParameterizedState) state;

			String[] parameterNames = getParameterNames(pState);

			for (LabelAndText callp : callParameters) {
				callp.label.dispose();
				callp.text.dispose();
			}
			callParameters.clear();
			List<String> parametersValues = pState.getParameters();
			for (int i = 0; i < parametersValues.size(); i++) {
				String paramValue = parametersValues.get(i);
				if (parameterNames.length != 0 && i < parameterNames.length) {
					callParameters.add(drawParameter(parameterNames[i], paramValue, i));
				}

			}

			composite.layout(true, true);
		}
	}

	protected abstract String[] getParameterNames(ParameterizedState state);

	@Override
	public void dispose() {
		super.dispose();

		for (LabelAndText callp : callParameters) {
			callp.label.dispose();
			callp.text.dispose();
		}
		callParameters.clear();
	}

}
