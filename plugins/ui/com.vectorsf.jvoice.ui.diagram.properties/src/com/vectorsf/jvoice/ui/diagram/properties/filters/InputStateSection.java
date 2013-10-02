package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.vectorsf.jvoice.model.operations.InputState;


public class InputStateSection extends GFPropertySection implements
ITabbedPropertyConstants {

	private Text nameText;
	
	public InputStateSection(){}
	
	private ModifyListener listenerIntentionName = new ModifyListener(){

		public void modifyText (ModifyEvent arg0){

		// set the new name for the Intention
		PictogramElement pe = getSelectedPictogramElement();
		final InputState bimElement = (InputState) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bimElement);

		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
		protected void doExecute() {
		bimElement.setName(nameText.getText());
		}
		});

		}
	};
	 
    @Override
    public void createControls(Composite parent,
        TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
 
        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        FormData data;
 
        nameText = factory.createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        nameText.setLayoutData(data);
        nameText.addModifyListener(listenerIntentionName);
 
        CLabel valueLabel = factory.createCLabel(composite, "Name:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(nameText, -HSPACE);
        data.top = new FormAttachment(nameText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
    }
 
    @Override
    public void refresh() {
    	nameText.removeModifyListener(listenerIntentionName);
        PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            Object bo = Graphiti.getLinkService()
                 .getBusinessObjectForLinkedPictogramElement(pe);
            // the filter assured, that it is a EClass
            if (bo == null)
                return;
            String name = ((InputState) bo).getName();
            nameText.setText(name == null ? "" : name);
            nameText.addModifyListener(listenerIntentionName);
        }
    }


}
