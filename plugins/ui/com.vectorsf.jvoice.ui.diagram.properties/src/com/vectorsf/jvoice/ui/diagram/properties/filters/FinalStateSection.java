package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class FinalStateSection extends StateSection { 
	
	private TabbedPropertySheetPage tabbedPropertySheetPage;
	
	public FinalStateSection() {}
	
	@Override
    public void createControls(Composite parent,
        TabbedPropertySheetPage atabbedPropertySheetPage) 
	{
		this.tabbedPropertySheetPage = atabbedPropertySheetPage;
        TabbedPropertySheetWidgetFactory factory = tabbedPropertySheetPage.getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        super.nombre_path(factory, composite);
        super.comboTransaIn(factory, composite);
		
	}
	
	@Override
    public void refresh() {
		super.removelistener();
    	PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            Object bo = Graphiti.getLinkService()
                 .getBusinessObjectForLinkedPictogramElement(pe);
            // the filter assured, that it is a EClass
            if (bo == null)
                return;
            textnompath(bo);

            transactionIncoming(bo);
	
        }
	}


}
