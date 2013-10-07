package com.vectorsf.jvoice.ui.diagram.properties.filters;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.Transition;

public class InitialStateSection extends StateSection {

	private TabbedPropertySheetPage tabbedPropertySheetPage;
	private Text OutTransitions;
	private FormData data;
	private org.eclipse.graphiti.mm.algorithms.Text nameArrow;
	
	public InitialStateSection() {}
	
	@Override
    public void createControls(Composite parent,
        TabbedPropertySheetPage atabbedPropertySheetPage) 
	{
		this.tabbedPropertySheetPage = atabbedPropertySheetPage;
        TabbedPropertySheetWidgetFactory factory = tabbedPropertySheetPage.getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        super.nombre_path(factory, composite);
        
      //Transiciones de salida.
        OutTransitions = factory.createText(composite, "");
        data = new FormData();
        data.left = new FormAttachment(0,STANDARD_LABEL_WIDTH+10);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE+60);
        OutTransitions.setLayoutData(data);
        OutTransitions.setEditable(false);
        OutTransitions.setEnabled(false);
        
        CLabel LabelOutTrans = factory.createCLabel(composite, "Out Transitions: ");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(OutTransitions,-HSPACE+200);
        data.top = new FormAttachment(OutTransitions, 0, SWT.CENTER);
        LabelOutTrans.setLayoutData(data);
       
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
            
            EList<Transition> listadoOut =((InitialState) bo).getOutgoingTransitions();
            if(listadoOut.size()==0){
            	OutTransitions.setText("");
            }else{
            	//Solo puede tener una transicion de salida, ya que se trata del estado inicial.
            	Transition tr = (Transition)listadoOut.get(0);
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
                        			OutTransitions.setText(nameArrow.getValue().toString());	
                        		}
                        		
            				}
            		}
				}//Fin del for.
            	
            }//Fin else. Hay transicion.
	
        }
	}
	
	

}
