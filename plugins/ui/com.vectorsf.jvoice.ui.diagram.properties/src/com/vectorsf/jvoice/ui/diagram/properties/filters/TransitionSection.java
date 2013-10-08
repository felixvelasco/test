package com.vectorsf.jvoice.ui.diagram.properties.filters;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
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
	private org.eclipse.graphiti.mm.algorithms.Text nameArrow;
	private PictogramElement pe;

	public TransitionSection() {}
	
	private FocusListener listenerIntentionName = new FocusListener(){

		public void focusLost(FocusEvent e) {

		// set the new name for the Intention
		pe = getSelectedPictogramElement();
		final Transition bimElement = (Transition) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bimElement);
		
		
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			
			@Override
			protected void doExecute() {
			
	            List<?> lista = Graphiti.getLinkService().getPictogramElements(getDiagramTypeProvider().getDiagram(), bimElement);
	        	for (Object object : lista) {            		
	        		if(object instanceof Connection){
	        		Connection connection = (Connection) object;
	        				//Obtenemos la conexion de nuestra transacion y la recorremos.
	                    	EList<ConnectionDecorator> liCD = connection.getConnectionDecorators();
	                    	for (ConnectionDecorator connectionDecorator : liCD) 
	                    	{
	                    		/**Obtenemos los Graphics Algorithms, que en este caso son dos, 
	                    		 * el texto y el arrow.
	                    		 * Para obtener el nombre, comprobamos que el Graphics Algorithm sea Text,
	                    		 * de ser asi lo modificamos.
	                    		 * 	                    		**/
	                    		GraphicsAlgorithm ga= connectionDecorator.getGraphicsAlgorithm();
	                    		if (ga instanceof org.eclipse.graphiti.mm.algorithms.Text)
	                    		{
	                    			nameArrow = (org.eclipse.graphiti.mm.algorithms.Text)ga;
	                    			nameArrow.setValue(nameText.getText());
	                    			
	                    		}
	                    		
	        				}
	        		}
				}//Fin del for.
				
			}
		});

		}
		
		@Override
		public void focusGained(FocusEvent e) {}
	};
	
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
        nameText.addFocusListener(listenerIntentionName);
     
        CLabel LabelName = factory.createCLabel(composite, "Name:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(nameText, -HSPACE);
        data.top = new FormAttachment(nameText, 0, SWT.CENTER);
        LabelName.setLayoutData(data);
        
        //Path donde se encuentra el elemento
        pathText = factory.createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH+10);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE+30);
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
       	data.left = new FormAttachment(0,STANDARD_LABEL_WIDTH+10);
       	data.right = new FormAttachment(100, 0);
       	data.top = new FormAttachment(0, VSPACE+60);
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
       	data.left = new FormAttachment(0,STANDARD_LABEL_WIDTH+10);
       	data.right = new FormAttachment(100, 0);
       	data.top = new FormAttachment(0, VSPACE+90);
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
    	nameText.removeFocusListener(listenerIntentionName);
        PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            Object bo = Graphiti.getLinkService()
                 .getBusinessObjectForLinkedPictogramElement(pe);
            // the filter assured, that it is a EClass
            if (bo == null)
                return;
            String name = null;
            //Vamos a obtener el nombre del GA
            Transition tr = (Transition)bo;
            List<?> li = Graphiti.getLinkService().getPictogramElements(getDiagramTypeProvider().getDiagram(), tr);
        	for (Object object : li) {            		
        		if(object instanceof Connection){
        		Connection connection = (Connection) object;
        				//Obtenemos la conexion de nuestra transacion y la recorremos.
                    	EList<ConnectionDecorator> liCD = connection.getConnectionDecorators();
                    	for (ConnectionDecorator connectionDecorator : liCD) 
                    	{
                    		/**Obtenemos los Graphics Algorithms, que en este caso son dos, 
                    		 * el texto y el arrow.
                    		 * Para obtener el nombre, comprobamos que el Graphics Algorithm sea Text,
                    		 * de ser asi obtenemos el nombre.
                    		**/
                    		GraphicsAlgorithm ga= connectionDecorator.getGraphicsAlgorithm();
                    		if (ga instanceof org.eclipse.graphiti.mm.algorithms.Text)
                    		{
                    			nameArrow = (org.eclipse.graphiti.mm.algorithms.Text)ga;
                    			name = nameArrow.getValue().toString();                                
                                nameText.setText(name == null ? "" : name);
                    		}
                    		
        				}
        		}
			}//Fin del for.  

            nameText.addFocusListener(listenerIntentionName);
            String path = (tr.eResource()).getURI().path().substring(9).toString();
            pathText.setText(path == null ? "" : path);
            String origen = tr.getSource().getName().toString();
            InitialState.setText(origen == null ? "" : origen);
            String destino = tr.getTarget().getName().toString();
            FinalState.setText(destino == null ? "" : destino);

        }
    }


}
