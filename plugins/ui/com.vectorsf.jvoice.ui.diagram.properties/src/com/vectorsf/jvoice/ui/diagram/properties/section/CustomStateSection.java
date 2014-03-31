package com.vectorsf.jvoice.ui.diagram.properties.section;

import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.CustomPageChooser;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.LabelAndText;

public class CustomStateSection extends SimpleStateSection {

	private LabelAndText returnBeanName;
	private LabelAndText customPage;

	public CustomStateSection() {
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage atabbedPropertySheetPage) {
		super.createControls(parent, atabbedPropertySheetPage);

		returnBeanName = createLabelAndText("Binding bean:", "",
				OperationsPackage.eINSTANCE.getCustomState_BindingBean(), CommandParameter.NO_INDEX);
		customPage = createLabelTextAndButton("Custom Page Name:", "",
				OperationsPackage.eINSTANCE.getCustomState_Path(), new CustomPageChooser());

	}

	@Override
	public void refresh() {
		super.refresh();
		CustomState customState = (CustomState) state;

		String bindingBean = customState.getBindingBean();
		returnBeanName.text.setText(bindingBean == null ? "" : bindingBean);

		String path = customState.getPath();
		customPage.text.setText(path == null ? "" : path);
	}
}
