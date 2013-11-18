package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


public class CustomStateSection extends StateSection {

	private TabbedPropertySheetPage tabbedPropertySheetPage;
	
	public CustomStateSection() {}
	
	@Override
    public void createControls(Composite parent,
        TabbedPropertySheetPage atabbedPropertySheetPage) 
	{
		this.tabbedPropertySheetPage = atabbedPropertySheetPage;
        TabbedPropertySheetWidgetFactory factory = tabbedPropertySheetPage.getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        super.drawName(factory, composite);
        super.drawCustomStatePath(factory, composite, "Custom Page Name:");
		
	}

}
