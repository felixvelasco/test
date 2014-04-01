package com.vectorsf.jvoice.ui.diagram.properties.section;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.ParameterizedState;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.LabelAndText;

/**
 * @author felix
 * 
 */
public abstract class ParametrizableStateSection extends SimpleStateSection {

	private List<LabelAndText> callParameters = new ArrayList<>();
	protected Group params;

	@Override
	public final void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		doCreateControls(parent, tabbedPropertySheetPage);

		params = factory.createGroup(composite, "Parameters");
		factory.paintBordersFor(params);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 3;
		params.setLayoutData(layoutData);
		GridLayout layout = new GridLayout(3, false);
		layout.marginTop = 10;
		layout.marginBottom = 10;
		layout.verticalSpacing = 10;
		layout.horizontalSpacing = 10;
		params.setLayout(layout);
	}

	/**
	 * Subclasses may override
	 * 
	 * @param parent
	 * @param tabbedPropertySheetPage
	 */
	protected void doCreateControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

	}

	/**
	 * @param index
	 * @param factory
	 * @param composite
	 */
	protected LabelAndText drawParameter(String name, String value, int index) {
		return createLabelAndText(params, name + ":", value,
				OperationsPackage.eINSTANCE.getParameterizedState_Parameters(), index);

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
			int i = 0;
			for (; i < parametersValues.size(); i++) {
				String paramValue = parametersValues.get(i);
				if (parameterNames.length != 0 && i < parameterNames.length) {
					callParameters.add(drawParameter(parameterNames[i], paramValue, i));
				}
			}

			for (; i < parameterNames.length; i++) {
				if (parameterNames.length != 0 && i < parameterNames.length) {
					callParameters.add(drawParameter(parameterNames[i], "", i));
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
