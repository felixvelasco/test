package com.vectorsf.jvoice.ui.diagram.properties.filters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;
import com.vectorsf.jvoice.ui.diagram.properties.Activator;
import com.vectorsf.jvoice.ui.diagram.properties.editting.ConditionEditingSupport;
import com.vectorsf.jvoice.ui.diagram.properties.editting.EventNameEditingSupport;

public class StateSection  extends  GFPropertySection implements
ITabbedPropertyConstants {
	private Text nameText;
	private Text pathText;
	private CCombo InTransitions;
	private CCombo OutTransitions;
	private FormData data;
	private Table table;
	private TableViewer tableViewer;
	private org.eclipse.graphiti.mm.algorithms.Text nameArrow;
	private List<Case> casos = new ArrayList<Case>();
	private static final String CONDITION = "Condition";
	private static final String NAME = "EventName";
	private static final String[] PROPS = { CONDITION, NAME};
	private SwitchState estadoSelection;
	private CLabel error;

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

        comboTransaOut(factory, composite);
        	

        
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
		    data.left = new FormAttachment(nameText, 0,SWT.LEFT);
		    data.right = new FormAttachment(nameText,0,SWT.RIGHT);
	       	data.top = new FormAttachment(pathText, 10);
	       	InTransitions.setLayoutData(data);
	       	InTransitions.setEditable(false);
	        	
	        CLabel LabelINTrans = factory.createCLabel(composite, "Incoming Transitions:");
	        data = new FormData();
	        data.left = new FormAttachment(0, 0);
	        data.right = new FormAttachment(InTransitions,-HSPACE);
	        data.top = new FormAttachment(InTransitions, 0, SWT.CENTER);
	        LabelINTrans.setLayoutData(data);
	}
	
	/**
	 * @param factory
	 * @param composite
	 */
	protected void comboTransaOut(TabbedPropertySheetWidgetFactory factory,
			Composite composite) {
		//Transiciones de salida.
        OutTransitions = factory.createCCombo(composite, 0);
        data = new FormData();
	    data.left = new FormAttachment(nameText, 0,SWT.LEFT);
	    data.right = new FormAttachment(nameText,0,SWT.RIGHT);
        if(InTransitions!=null)
        	data.top = new FormAttachment(InTransitions, 10);
        else
        	data.top = new FormAttachment(pathText, 10);
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
	protected void tableSwitchCase(TabbedPropertySheetWidgetFactory factory,
			Composite composite) {
		//Tabla con los Case de un Switch
		table = factory.createTable(composite, 0);
		data = new FormData();
		data.left = new FormAttachment(nameText, 0,SWT.LEFT);
//		data.right = new FormAttachment(50, 0);
		data.right = new FormAttachment(nameText,-120,SWT.RIGHT);
        data.top = new FormAttachment(OutTransitions, 10);
        table.setLayoutData(data);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tableViewer = new TableViewer(table);
	    tableViewer.setUseHashlookup(true);
	    
	    TableViewerColumn condition = createTableViewerColumn(CONDITION, 400, 0);
	    condition.setEditingSupport(new ConditionEditingSupport(tableViewer));
	    TableViewerColumn eventName = createTableViewerColumn(NAME, 120, 0);
	    eventName.setEditingSupport(new EventNameEditingSupport(tableViewer, error));
	    
	    
	    tableViewer.setContentProvider(new CaseContentProvider());
	    tableViewer.setLabelProvider(new CaseLabelProvider());
	    tableViewer.setInput(casos);
	    
	    CellEditor[] editors = new CellEditor[2];
	    editors[0] = new TextCellEditor(table);
	    editors[1] = new TextCellEditor(table);

	    tableViewer.setColumnProperties(PROPS);
	    tableViewer.setCellModifier(new CaseCellModifier(tableViewer));
	    tableViewer.setCellEditors(editors);
	    
	    Button btAdd = factory.createButton(composite, "", SWT.PUSH);
	    btAdd.setImage(Activator.getDefault().getImageRegistry().get("imageAdd"));
	    data = new FormData();
	    data.left = new FormAttachment(table, 5);
	    data.top =  new FormAttachment(table, 0,SWT.TOP);
	    btAdd.setLayoutData(data);
	    btAdd.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				PictogramElement pe = getSelectedPictogramElement();
		        if (pe != null) {
		            Object bo = Graphiti.getLinkService()
		                 .getBusinessObjectForLinkedPictogramElement(pe);
		            // the filter assured, that it is a EClass
		            if (bo == null)
		            	return;
		            
		            if(bo instanceof SwitchState){
		            	estadoSelection = (SwitchState)bo;
		            	TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(estadoSelection);
		            	dominio.getCommandStack().execute(new RecordingCommand(dominio) {
		            		protected void doExecute() {
		            			Case casoNuevo = OperationsFactory.eINSTANCE.createCase();
				            	boolean repetido = true;
				            	int i = 1;
				            	while (repetido){
				            		if (estadoSelection.getCase("Case_" + i) == null){
				            			casoNuevo.setEventName("Case_" + i);
				            			casoNuevo.setCondition("");
				            			repetido = false;
				            		}else{
				            			i++;
				            		}
				            	}
				            	estadoSelection.getCase().add(casoNuevo);
				            	estadoSelection.getCase().move(estadoSelection.getCase().size()-2, casoNuevo);
				            	casos = estadoSelection.getCase();
				            	tableViewer.setInput(casos);
		            		}
		            	});
		            }
		        }
			}
		});
	    Button btRemove = factory.createButton(composite, "", SWT.PUSH);
	    btRemove.setImage(Activator.getDefault().getImageRegistry().get("imageRemove"));
	    data = new FormData();
	    data.left = new FormAttachment(btAdd,0,SWT.LEFT);
	    data.right = new FormAttachment(btAdd,0,SWT.RIGHT);
	    data.top =  new FormAttachment(btAdd, 10);
	    btRemove.setLayoutData(data);
	    btRemove.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(estadoSelection);
            	dominio.getCommandStack().execute(new RecordingCommand(dominio) {
            		protected void doExecute() {
            			TableItem[] item = tableViewer.getTable().getSelection();
            			if (item.length>0){
            				Case caso = (Case)item[0].getData();
            				if (estadoSelection.getCase(caso.getEventName()) !=null && !caso.getEventName().equals("default")){
            					estadoSelection.getCase().remove(caso);
            					casos = estadoSelection.getCase();
    			            	tableViewer.setInput(casos);
            				}
            			}
            		}
            	});
			}
	    });
	    Button btUp = factory.createButton(composite, "",SWT.PUSH);
	    btUp.setImage(Activator.getDefault().getImageRegistry().get("imageUp"));
	    data = new FormData();
	    data.left = new FormAttachment(btAdd, 5);
	    data.top =  new FormAttachment(table, 0,SWT.TOP);
	    btUp.setLayoutData(data);
	    btUp.addListener(SWT.Selection, new Listener() {
	    	@Override
			public void handleEvent(Event event) {
	    		TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(estadoSelection);
            	dominio.getCommandStack().execute(new RecordingCommand(dominio) {
            		protected void doExecute() {
            			TableItem[] item = tableViewer.getTable().getSelection();
            			if (item.length>0){
            				Case caso = (Case)item[0].getData();
            				if (!caso.getEventName().equals("default")){
            					for (int i=0; i< estadoSelection.getCase().size(); i++){
            						if (estadoSelection.getCase().get(i).equals(caso)){
            							if (i>0){
            								estadoSelection.getCase().move(i-1, caso);
                        					casos = estadoSelection.getCase();
                			            	tableViewer.setInput(casos);
                			            	break;
            							}
            						}
            					}
            				}
            			}
            		}
            	});
	    	}
	    });

	    Button btDown = factory.createButton(composite, "", SWT.PUSH);
	    btDown.setImage(Activator.getDefault().getImageRegistry().get("imageDown"));
	    data = new FormData();
	    data.left = new FormAttachment(btUp,0,SWT.LEFT);
	    data.right = new FormAttachment(btUp,0,SWT.RIGHT);
	    data.top =  new FormAttachment(btUp, 10);
	    btDown.setLayoutData(data);
	    btDown.addListener(SWT.Selection, new Listener() {
	    	@Override
			public void handleEvent(Event event) {
	    		TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(estadoSelection);
            	dominio.getCommandStack().execute(new RecordingCommand(dominio) {
            		protected void doExecute() {
            			TableItem[] item = tableViewer.getTable().getSelection();
            			if (item.length>0){
            				Case caso = (Case)item[0].getData();
            				if (!caso.getEventName().equals("default")){
            					for (int i=0; i< estadoSelection.getCase().size(); i++){
            						if (estadoSelection.getCase().get(i).equals(caso)){
            							if (i<estadoSelection.getCase().size()-2){
            								estadoSelection.getCase().move(i+1, caso);
                        					casos = estadoSelection.getCase();
                			            	tableViewer.setInput(casos);
                			            	break;
            							}
            						}
            					}
            				}
            			}
            		}
            	});
	    	}
	    });
	}

	/**
	 * @param factory
	 * @param composite
	 */
	protected void nombre_path(TabbedPropertySheetWidgetFactory factory,
			Composite composite) {
			error = factory.createCLabel(composite, "", SWT.CENTER);
			data = new FormData();
		    data.left = new FormAttachment(0, 0);
		    data.right = new FormAttachment(100, 0);
		    error.setLayoutData(data);
		
			//Nombre del elemento
		    nameText = factory.createText(composite, "");
		    data = new FormData();
		    data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH+50);
		    data.right = new FormAttachment(error,0,SWT.RIGHT);
		    data.top = new FormAttachment(error, 10);
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

            if(!(bo instanceof InitialState))
            	transactionIncoming(bo);
            
            transactionOut(bo);
            
            if(bo instanceof SwitchState){
            	estadoSelection = (SwitchState)bo;
            	casos = estadoSelection.getCase();
            	tableViewer.setInput(casos);
            }

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


	class CaseCellModifier implements ICellModifier {
		  private Viewer viewer;

		  public CaseCellModifier(Viewer viewer) {
		    this.viewer = viewer;
		  }

		  public boolean canModify(Object element, String property) {
		    return true;
		  }

		  public Object getValue(Object element, String property) {
		    Case p = (Case) element;
		    if (StateSection.NAME.equals(property))
		      return p.getEventName();
		    else if (StateSection.CONDITION.equals(property))
		    	return p.getCondition();
		    else
		      return null;
		  }

		  public void modify(Object element, String property, Object value) {
		    if (element instanceof Item) element = ((Item) element).getData();

		    Case p = (Case) element;
		    if (StateSection.NAME.equals(property))
		      p.setEventName((String) value);
		    else if (StateSection.CONDITION.equals(property))
		    	 p.setCondition((String) value);
		    viewer.refresh();
		  }
		}
	
	class CaseContentProvider implements IStructuredContentProvider {
		  public Object[] getElements(Object inputElement) {
		    return ((List<?>) inputElement).toArray();
		  }

		  public void dispose() {
		  }

		  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		  }
		}
	
	class CaseLabelProvider implements ITableLabelProvider {
		  public Image getColumnImage(Object element, int columnIndex) {
		    return null;
		  }

		  public String getColumnText(Object element, int columnIndex) {
		    Case caso = (Case) element;
		    switch (columnIndex) {
		    case 0:
		      return caso.getCondition();
		    case 1:
		      return caso.getEventName();
		    }
		    return null;
		  }

		  public void dispose() {
		  }

		  public boolean isLabelProperty(Object element, String property) {
		    return false;
		  }

		@Override
		public void addListener(ILabelProviderListener listener) {}

		@Override
		public void removeListener(ILabelProviderListener listener) {}
		}
	
	private TableViewerColumn createTableViewerColumn(String title, int bound,
		      final int colNumber) {
		    final TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer,
		        SWT.NONE);
		    final TableColumn column = viewerColumn.getColumn();
		    column.setText(title);
		    column.setWidth(bound);
		    column.setResizable(true);
		    column.setMoveable(true);
		    return viewerColumn;
		  }

}
