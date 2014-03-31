package com.vectorsf.jvoice.ui.diagram.properties.section;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.vectorsf.jvoice.model.operations.Transition;

public class TransitionSection extends GFPropertySection implements
		ITabbedPropertyConstants {
	
	private Text nameText;
	private Text pathText;
	private Text InitialState;
	private Text FinalState;

	public TransitionSection() {}
	
	@Override
    public void createControls(Composite parent,
        TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
 
        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        FormData data;
 
      //Nombre del elemento
        nameText = factory.createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH+10);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        nameText.setLayoutData(data);
        nameText.setEditable(false);
        nameText.setEnabled(false); 
     
        CLabel LabelName = factory.createCLabel(composite, "Name:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(nameText, -HSPACE);
        data.top = new FormAttachment(nameText, 0, SWT.CENTER);
        LabelName.setLayoutData(data);
        
        //Path donde se encuentra el elemento
        pathText = factory.createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(nameText, 0,SWT.LEFT);
	    data.right = new FormAttachment(nameText,0,SWT.RIGHT);
	    data.top = new FormAttachment(nameText, 10);
        pathText.setLayoutData(data);
        pathText.setEditable(false);
        pathText.setEnabled(false);       
      
        CLabel LabelPath = factory.createCLabel(composite, "Path:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(pathText, -HSPACE);
        data.top = new FormAttachment(pathText, 0, SWT.CENTER);
        LabelPath.setLayoutData(data);
        
        //Estado inicial   
        InitialState = factory.createText(composite, "");
       	data = new FormData();
       	data.left = new FormAttachment(pathText, 0,SWT.LEFT);
	    data.right = new FormAttachment(pathText,0,SWT.RIGHT);
	    data.top = new FormAttachment(pathText, 10);
       	InitialState.setLayoutData(data);
       	InitialState.setEditable(false);
       	InitialState.setEnabled(false); 
        	
        CLabel LabelIniState = factory.createCLabel(composite, "Initial State:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(InitialState,-HSPACE);
        data.top = new FormAttachment(InitialState, 0, SWT.CENTER);
        LabelIniState.setLayoutData(data);
        
        //Estado final   
        FinalState = factory.createText(composite, "");
       	data = new FormData();
       	data.left = new FormAttachment(InitialState, 0,SWT.LEFT);
	    data.right = new FormAttachment(InitialState,0,SWT.RIGHT);
	    data.top = new FormAttachment(InitialState, 10);
       	FinalState.setLayoutData(data);
       	FinalState.setEditable(false); 
       	FinalState.setEnabled(false); 
        	
        CLabel LabelFinState = factory.createCLabel(composite, "Final State:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(FinalState,-HSPACE);
        data.top = new FormAttachment(FinalState, 0, SWT.CENTER);
        LabelFinState.setLayoutData(data);
    }
 
    @Override
    public void refresh() {
        PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            Object bo = Graphiti.getLinkService()
                 .getBusinessObjectForLinkedPictogramElement(pe);
            // the filter assured, that it is a EClass
            if (bo == null)
                return;

            Transition tr = (Transition)bo;
            
            nameText.setText(tr.getEventName());
        	
            String path = (tr.eResource()).getURI().path().substring(9).toString();
            pathText.setText(path == null ? "" : path);
            String origen = tr.getSource().getName().toString();
            InitialState.setText(origen == null ? "" : origen);
            String destino = tr.getTarget().getName().toString();
            FinalState.setText(destino == null ? "" : destino);
        }
    }
}
