package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class TransferStateSection extends StateSection {

	private TabbedPropertySheetPage tabbedPropertySheetPage;

	public TransferStateSection() {
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage atabbedPropertySheetPage) {
		this.tabbedPropertySheetPage = atabbedPropertySheetPage;
		TabbedPropertySheetWidgetFactory factory = tabbedPropertySheetPage.getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		super.nombre_path(factory, composite);
		super.subFlowPath(factory, composite, "Name definition:");
	}

}
