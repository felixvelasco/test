package com.vectorsf.jvoice.ui.diagram.properties.filters;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
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

import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

public class StateSection  extends  GFPropertySection implements
ITabbedPropertyConstants {
	private Text nameText;
	private Text pathText;
	private CCombo InTransitions;
	private CCombo OutTransitions;
	private FormData data;
	private org.eclipse.graphiti.mm.algorithms.Text nameArrow;

	public StateSection() {}
	
	protected FocusListener listenerIntentionName = new FocusListener(){
		@Override
		public void focusLost(FocusEvent e) {
			PictogramElement pe = getSelectedPictogramElement();
			final State bimElement = (State) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bimElement);

			IFeatureProvider fp =getDiagramTypeProvider().getFeatureProvider();
			
			editingDomain.getCommandStack().execute(new RenameCommand(editingDomain, pe, bimElement, nameText.getText(), fp));

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
    
        nombre_path(factory, composite);
        
        comboTransaIn(factory, composite);

        	//Transiciones de salida.
            OutTransitions = factory.createCCombo(composite, 0);
            data = new FormData();
            data.left = new FormAttachment(0,STANDARD_LABEL_WIDTH+40);
            data.right = new FormAttachment(100, 0);
            data.top = new FormAttachment(0, VSPACE+90);
            OutTransitions.setLayoutData(data);
            OutTransitions.setEditable(false);
            
            CLabel LabelOutTrans = factory.createCLabel(composite, "Out Transitions:");
            data = new FormData();
            data.left = new FormAttachment(0, 0);
            data.right = new FormAttachment(OutTransitions,-HSPACE);
            data.top = new FormAttachment(OutTransitions, 0, SWT.CENTER);
            LabelOutTrans.setLayoutData(data);

        
    }

	/**
	 * @param factory
	 * @param composite
	 */
	protected void comboTransaIn(TabbedPropertySheetWidgetFactory factory,
			Composite composite) {
		//Transiciones de Entrada. 
	       	InTransitions = factory.createCCombo(composite, 0);
	       	data = new FormData();
	       	data.left = new FormAttachment(0,STANDARD_LABEL_WIDTH+40);
	       	data.right = new FormAttachment(100, 0);
	       	data.top = new FormAttachment(0, VSPACE+60);
	       	InTransitions.setLayoutData(data);
	       	InTransitions.setEditable(false);
	        	
	        CLabel LabelINTrans = factory.createCLabel(composite, "Incoming Transitions:");
	        data = new FormData();
	        data.left = new FormAttachment(0, 0);
	        data.right = new FormAttachment(InTransitions,-HSPACE+10);
	        data.top = new FormAttachment(InTransitions, 0, SWT.CENTER);
	        LabelINTrans.setLayoutData(data);
	}

	/**
	 * @param factory
	 * @param composite
	 */
	protected void nombre_path(TabbedPropertySheetWidgetFactory factory,
			Composite composite) {
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
	}
 
    @Override
    public void refresh() {
    	removelistener();
    	PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            Object bo = Graphiti.getLinkService()
                 .getBusinessObjectForLinkedPictogramElement(pe);
            // the filter assured, that it is a EClass
            if (bo == null)
                return;
            textnompath(bo);

            transactionIncoming(bo);
            
            transactionOut(bo);

        }
    }

	/**
	 * Eliminamos el listener
	 */
	protected void removelistener() {
		nameText.removeFocusListener(listenerIntentionName);
	}

	/**
	 * Obtenemos el nombre de las transiciones de salida.
	 * @param bo
	 */
	protected void transactionOut(Object bo) {
		EList<Transition> OUTtransaction = ((State) bo).getOutgoingTransitions();
		OutTransitions.removeAll();

		if(OUTtransaction.size()>0){             	
			for (Object trans : OUTtransaction){            		
				Transition tr = (Transition)trans;
		    	//Cogemos el Pictogram Elements a la transacion.
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
		                			OutTransitions.add(nameArrow.getValue().toString());
		                		}
		                		
		    				}
		    		}
				}//Fin del for.   
			} 
			
		}else{
			OutTransitions.add("none");      
		}
		OutTransitions.select(0);
	}

	/**
	 * Obtenemos el nombre de las transiciones de entrada.
	 * @param bo
	 */
	protected void transactionIncoming(Object bo) {
		EList<Transition>INCOMtransaction = ((State) bo).getIncomingTransitions();
		InTransitions.removeAll();
           
		if(INCOMtransaction.size()>0){ 
			
				for (Object transIN : INCOMtransaction){            		
		    		Transition tr = (Transition)transIN;
		        	//Cogemos el Pictogram Elements a la transacion.
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
		                    			InTransitions.add(nameArrow.getValue().toString());
		                    		}
		                    		
		        				}
		        		}
					}//Fin del for.           		
			}
				
		}else{
			InTransitions.add("none");      
		}
		
		InTransitions.select(0);
	}

	/**
	 * @param bo
	 */
	protected void textnompath(Object bo) {
		String name = null;
		name = ((State) bo).getName();            
		nameText.setText(name == null ? "" : name);
		nameText.addFocusListener(listenerIntentionName);
		String path = (((State) bo).eResource()).getURI().path().substring(9).toString();
		pathText.setText(path == null ? "" : path);
	}



}
