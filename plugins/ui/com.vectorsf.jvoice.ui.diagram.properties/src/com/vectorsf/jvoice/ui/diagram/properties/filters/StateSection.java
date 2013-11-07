package com.vectorsf.jvoice.ui.diagram.properties.filters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.PromptState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.TransferState;
import com.vectorsf.jvoice.model.operations.Transition;
import com.vectorsf.jvoice.model.operations.TypeTransfer;
import com.vectorsf.jvoice.ui.diagram.properties.Activator;
import com.vectorsf.jvoice.ui.diagram.properties.editting.ConditionEditingSupport;
import com.vectorsf.jvoice.ui.diagram.properties.editting.EventNameEditingSupport;
import com.vectorsf.jvoice.ui.diagram.properties.listeners.ListenerIntentionName;
import com.vectorsf.jvoice.ui.diagram.properties.listeners.ListenerTypeTransfer;
import com.vectorsf.jvoice.ui.diagram.properties.listeners.PropertiesListener;
import com.vectorsf.jvoice.ui.diagram.properties.listeners.VerifyNumericListener;
import com.vectorsf.jvoice.ui.diagram.properties.provider.CaseContentProvider;
import com.vectorsf.jvoice.ui.diagram.properties.provider.CaseLabelProvider;

public class StateSection  extends  GFPropertySection implements
ITabbedPropertyConstants {
	
	private Text nameText;
	private Text pathText;
	private Text nameSubFlow;
	private Text destinationText;
	private Text transferAudioText;
	private Text maxTimeText;
	private Text timeOutText;
	private CCombo typeTranferCombo;
	private CCombo InTransitions;
	private CCombo OutTransitions;
	private Button btEditFlow;
	private Button btAdd;
	private Button btRemove;
	private Button btUp;
	private Button btDown;
	private FormData data;
	private Table table;
	private TableViewer tableViewer;
	private org.eclipse.graphiti.mm.algorithms.Text nameArrow;
	private List<Case> casos = new ArrayList<Case>();
	private static final String CONDITION = "Condition";
	private static final String NAME = "EventName";
	private static final String[] PROPS = { CONDITION, NAME};
	private static SwitchState estadoSelection;
	private CLabel error;
	private static IFeatureProvider fp;
	private PictogramElement pe;
	private ListenerIntentionName nameStateListener;
	private ListenerIntentionName destinationListener;
	private ListenerIntentionName audioListener;
	private ListenerIntentionName timeOutListener;
	private ListenerIntentionName maxTimeListener;
	private ListenerTypeTransfer typeTransferListener;
	private PropertiesListener propertielistener;
	private VerifyNumericListener timeOutVerifyListener;
	private VerifyNumericListener maxTimeVerifyListener;
	

	public StateSection() {}
	
	
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
		table = factory.createTable(composite, SWT.SINGLE|SWT.FULL_SELECTION);
		data = new FormData();
		data.left = new FormAttachment(nameText, 0,SWT.LEFT);
		data.right = new FormAttachment(nameText,-120,SWT.RIGHT);
        data.top = new FormAttachment(OutTransitions, 10);
        table.setLayoutData(data);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tableViewer = new TableViewer(table);
	    tableViewer.setUseHashlookup(true);
	    
	    TableViewerColumn condition = createTableViewerColumn(CONDITION, 400);
	    condition.setEditingSupport(new ConditionEditingSupport(tableViewer));
	    TableViewerColumn eventName = createTableViewerColumn(NAME, 120);
	    eventName.setEditingSupport(new EventNameEditingSupport(tableViewer, error));
	    
	    
	    tableViewer.setContentProvider(new CaseContentProvider());
	    tableViewer.setLabelProvider(new CaseLabelProvider());
	    tableViewer.setInput(casos);
	    
	    CellEditor[] editors = new CellEditor[2];
	    editors[0] = new TextCellEditor(table);
	    editors[1] = new TextCellEditor(table);

	    tableViewer.setColumnProperties(PROPS);
	    tableViewer.setCellEditors(editors);

	    propertielistener = new PropertiesListener(this, tableViewer);

	    btAdd = factory.createButton(composite, "", SWT.PUSH);
	    btAdd.setData("add");
	    btAdd.setImage(Activator.getDefault().getImageRegistry().get("imageAdd"));
	    data = new FormData();
	    data.left = new FormAttachment(table, 5);
	    data.top =  new FormAttachment(table, 0,SWT.TOP);
	    btAdd.setLayoutData(data);
		btAdd.addListener(SWT.Selection, propertielistener);
		
	    btRemove = factory.createButton(composite, "", SWT.PUSH);
	    btRemove.setData("remove");
	    btRemove.setImage(Activator.getDefault().getImageRegistry().get("imageRemove"));
	    data = new FormData();
	    data.left = new FormAttachment(btAdd,0,SWT.LEFT);
	    data.right = new FormAttachment(btAdd,0,SWT.RIGHT);
	    data.top =  new FormAttachment(btAdd, 10);
	    btRemove.setLayoutData(data);
	    btRemove.addListener(SWT.Selection, propertielistener);
	    
	    btUp = factory.createButton(composite, "",SWT.PUSH);
	    btUp.setData("up");
	    btUp.setImage(Activator.getDefault().getImageRegistry().get("imageUp"));
	    data = new FormData();
	    data.left = new FormAttachment(btAdd, 5);
	    data.top =  new FormAttachment(table, 0,SWT.TOP);
	    btUp.setLayoutData(data);
	    btUp.addListener(SWT.Selection, propertielistener);

	    btDown = factory.createButton(composite, "", SWT.PUSH);
	    btDown.setData("down");
	    btDown.setImage(Activator.getDefault().getImageRegistry().get("imageDown"));
	    data = new FormData();
	    data.left = new FormAttachment(btUp,0,SWT.LEFT);
	    data.right = new FormAttachment(btUp,0,SWT.RIGHT);
	    data.top =  new FormAttachment(btUp, 10);
	    btDown.setLayoutData(data);
	    btDown.addListener(SWT.Selection, propertielistener);
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
		    
		    nameStateListener = new ListenerIntentionName(this, nameText);
		    
		    nameText.addFocusListener(nameStateListener);
		 
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
	
	/**
	 * @param factory
	 * @param composite
	 */
	protected void drawName(TabbedPropertySheetWidgetFactory factory,
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
		    
		    nameStateListener = new ListenerIntentionName(this, nameText);
		    
		    nameText.addFocusListener(nameStateListener);
		 
		    CLabel LabelName = factory.createCLabel(composite, "Name:");
		    data = new FormData();
		    data.left = new FormAttachment(0, 0);
		    data.right = new FormAttachment(nameText, -HSPACE);
		    data.top = new FormAttachment(nameText, 0, SWT.CENTER);
		    LabelName.setLayoutData(data);
		    
	}
	
	protected void subFlowPath(TabbedPropertySheetWidgetFactory factory,
			Composite composite, String nameLabel) {
		//Nombre del elemento

		nameSubFlow = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(nameText, 0,SWT.LEFT);
		data.right = new FormAttachment(nameText,-120,SWT.RIGHT);
        data.top = new FormAttachment(OutTransitions, 10);
	    nameSubFlow.setLayoutData(data);
	    nameSubFlow.setEditable(false);
	    nameSubFlow.setEnabled(false);
	 
	    CLabel LabelName = factory.createCLabel(composite, nameLabel);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(nameSubFlow, -HSPACE);
	    data.top = new FormAttachment(nameSubFlow, 0, SWT.CENTER);
	    LabelName.setLayoutData(data);
	    
	    btEditFlow = factory.createButton(composite, "",SWT.PUSH);
	    btEditFlow.setImage(Activator.getDefault().getImageRegistry().get("imageModify"));
	    data = new FormData();
	    data.left = new FormAttachment(nameSubFlow, 5);
	    data.top =  new FormAttachment(nameSubFlow, 0,SWT.CENTER);
	    btEditFlow.setLayoutData(data);
	    
	    propertielistener = new PropertiesListener(this, nameSubFlow);
	    
	    btEditFlow.addListener(SWT.Selection, propertielistener);
	}
	
	protected void transferEspecific(TabbedPropertySheetWidgetFactory factory,
			Composite composite) {
		typeTranferCombo = factory.createCCombo(composite, 0);
       	data = new FormData();
	    data.left = new FormAttachment(nameText, 0,SWT.LEFT);
	    data.right = new FormAttachment(nameText,0,SWT.RIGHT);
       	data.top = new FormAttachment(OutTransitions, 10);
       	typeTranferCombo.setLayoutData(data);
       	typeTranferCombo.setEditable(false);
       	llenarCombo();
       	

        	
        CLabel labelTransType = factory.createCLabel(composite, "Transfer Type:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(typeTranferCombo,-HSPACE);
        data.top = new FormAttachment(typeTranferCombo, 0, SWT.CENTER);
        labelTransType.setLayoutData(data);
        
        
        destinationText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(nameText, 0,SWT.LEFT);
	    data.right = new FormAttachment(nameText,0,SWT.RIGHT);
        data.top = new FormAttachment(typeTranferCombo, 10);
        destinationText.setLayoutData(data);
        
        destinationListener = new ListenerIntentionName(this, destinationText, 1);
        
        
        destinationText.addFocusListener(destinationListener);
	 
	    CLabel labelDestination = factory.createCLabel(composite, "Destination:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(destinationText, -HSPACE);
	    data.top = new FormAttachment(destinationText, 0, SWT.CENTER);
	    labelDestination.setLayoutData(data);
	    
	        
	    transferAudioText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(nameText, 0,SWT.LEFT);
	    data.right = new FormAttachment(nameText,0,SWT.RIGHT);
        data.top = new FormAttachment(destinationText, 10);
        transferAudioText.setLayoutData(data);
        
        audioListener = new ListenerIntentionName(this, transferAudioText, 2);
        
        transferAudioText.addFocusListener(audioListener);
        
	    CLabel labelAudio = factory.createCLabel(composite, "Audio Transfer:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(transferAudioText, -HSPACE);
	    data.top = new FormAttachment(transferAudioText, 0, SWT.CENTER);
	    labelAudio.setLayoutData(data);
	    
	    
	    timeOutText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(nameText, 0,SWT.LEFT);
	    data.right = new FormAttachment(nameText,0,SWT.RIGHT);
        data.top = new FormAttachment(transferAudioText, 10);
        timeOutText.setLayoutData(data);
        timeOutText.setEnabled(false);
        
        timeOutListener = new ListenerIntentionName(this, timeOutText, 3);
        
        timeOutText.addFocusListener(timeOutListener);
        
        timeOutVerifyListener = new VerifyNumericListener();
        
        timeOutText.addVerifyListener(timeOutVerifyListener);
        
	    CLabel labelTimeOut = factory.createCLabel(composite, "TimeOut:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(timeOutText, -HSPACE);
	    data.top = new FormAttachment(timeOutText, 0, SWT.CENTER);
	    labelTimeOut.setLayoutData(data);	    
	    
	    maxTimeText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(nameText, 0,SWT.LEFT);
	    data.right = new FormAttachment(nameText,0,SWT.RIGHT);
        data.top = new FormAttachment(timeOutText, 10);
        maxTimeText.setLayoutData(data);
        maxTimeText.setEnabled(false);
        
        maxTimeListener = new ListenerIntentionName(this, maxTimeText, 4);
        
        maxTimeText.addFocusListener(maxTimeListener);
        
        maxTimeVerifyListener = new VerifyNumericListener();
        
        maxTimeText.addVerifyListener(maxTimeVerifyListener);
        
	    CLabel labelTimeMax = factory.createCLabel(composite, "Max Time:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(maxTimeText, -HSPACE);
	    data.top = new FormAttachment(maxTimeText, 0, SWT.CENTER);
	    labelTimeMax.setLayoutData(data);
	    
	    
	    
       	typeTransferListener = new ListenerTypeTransfer(this, typeTranferCombo, timeOutText, maxTimeText);
       	
       	typeTranferCombo.addSelectionListener(typeTransferListener);
	    
	}
	
	protected void drawCustomStatePath(TabbedPropertySheetWidgetFactory factory,
			Composite composite, String nameLabel) {


		nameSubFlow = factory.createText(composite, "");
		data = new FormData();
	    data.left = new FormAttachment(nameText, 0,SWT.LEFT);
		data.right = new FormAttachment(nameText,-120,SWT.RIGHT);
        data.top = new FormAttachment(nameText, 10);
	    nameSubFlow.setLayoutData(data);
	    nameSubFlow.setEditable(false);
	    nameSubFlow.setEnabled(false);
	 
	    CLabel LabelName = factory.createCLabel(composite, nameLabel);
        data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(nameSubFlow, -HSPACE);
	    data.top = new FormAttachment(nameSubFlow, 0, SWT.CENTER);
	    LabelName.setLayoutData(data);
	    
	    btEditFlow = factory.createButton(composite, "",SWT.PUSH);
	    btEditFlow.setText("...");
	    data = new FormData();
	    data.left = new FormAttachment(nameSubFlow, 5);
	    data.top =  new FormAttachment(nameSubFlow, 0, SWT.CENTER);
	    btEditFlow.setLayoutData(data);
	    
	    propertielistener = new PropertiesListener(this, nameSubFlow);
	    
	    btEditFlow.addListener(SWT.Selection, propertielistener);
	}
	
    @Override
    public void refresh() {
    	pe = getSelectedPictogramElement();
        if (pe != null) {
        	fp =getDiagramTypeProvider().getFeatureProvider();
        	
            Object bo = Graphiti.getLinkService()
                 .getBusinessObjectForLinkedPictogramElement(pe);
            // the filter assured, that it is a EClass
            if (bo == null)
                return;
            
            removelistener(bo);
            if (pathText!=null){
            	textnompath(bo);
            }else{
            	refreshName(bo);
            }

            if(!(bo instanceof InitialState)){
            	if(InTransitions!=null){
            		transactionIncoming(bo);
            	}
            }
            
            if(!(bo instanceof FinalState))
            	if(OutTransitions!=null){
            	transactionOut(bo);
            	}
            
            if(bo instanceof SwitchState){
            	estadoSelection = (SwitchState)bo;
            	casos = estadoSelection.getCase();
            	tableViewer.setInput(casos);
            	addListenerSwtich();
            	
            }else if(bo instanceof CallFlowState){
            	CallFlowState subFlow = (CallFlowState)bo;
            	if (subFlow.getSubflow().getName()!=null){
            		nameSubFlow.setText(subFlow.getSubflow().getName());
            	}
            	addListenerSubflujos();
            }else if(bo instanceof MenuState){
            	MenuState menuLocution = (MenuState)bo;
            	if (menuLocution.getLocution().getName()!=null){
            		nameSubFlow.setText(menuLocution.getLocution().getName());
            	}
            	addListenerSubflujos();
            }else if(bo instanceof InputState){
            	InputState inputLocution = (InputState)bo;
            	if (inputLocution.getLocution().getName()!=null){
            		nameSubFlow.setText(inputLocution.getLocution().getName());
            	}
            	addListenerSubflujos();
            }else if(bo instanceof PromptState){
            	PromptState outputLocution = (PromptState)bo;
            	if (outputLocution.getLocution().getName()!=null){
            		nameSubFlow.setText(outputLocution.getLocution().getName());
            	}
            	addListenerSubflujos();
            }else if(bo instanceof CustomState){
            	CustomState custom = (CustomState)bo;
            	if (custom.getPath()!=null){
            		nameSubFlow.setText(custom.getPath());
            	}
            	addListenerSubflujos();
            }else if (bo instanceof TransferState){
            	TransferState transfer = (TransferState)bo;
            	if (transfer.getDestination()!=null){
            		destinationText.setText(transfer.getDestination());	
            	}
            	if (transfer.getAudioTransfer()!=null){
            		transferAudioText.setText(transfer.getAudioTransfer());
            	}

            	if (transfer.getTypeTransfer().getValue() == 0){
            		timeOutText.setEnabled(false);
            		maxTimeText.setEnabled(false);
            		timeOutText.setText(Integer.toString(transfer.getTimeout()));
                	maxTimeText.setText(Integer.toString(transfer.getMaxTime()));
            	}else if(transfer.getTypeTransfer().getValue() == 1){
            		timeOutText.setEnabled(true);
            		maxTimeText.setEnabled(false);
                	timeOutText.setText(Integer.toString(transfer.getTimeout()));
                	maxTimeText.setText(Integer.toString(transfer.getMaxTime()));
            	}else if(transfer.getTypeTransfer().getValue() == 2){
            		timeOutText.setEnabled(true);
            		maxTimeText.setEnabled(true);
                	timeOutText.setText(Integer.toString(transfer.getTimeout()));
                	maxTimeText.setText(Integer.toString(transfer.getMaxTime()));
            	}

            	
            	seleccionarTipo(transfer);
            	addListenerTransfer();
            	
            }
        }
    }
    
    private void addListenerTransfer() {
    	destinationListener = new ListenerIntentionName(this, destinationText, 1);
    	audioListener = new ListenerIntentionName(this, transferAudioText, 2);
    	maxTimeListener = new ListenerIntentionName(this, maxTimeText, 4);
    	timeOutListener = new ListenerIntentionName(this, timeOutText, 3);
    	timeOutVerifyListener = new VerifyNumericListener();
    	maxTimeVerifyListener = new VerifyNumericListener();
    	
		destinationText.addFocusListener(destinationListener);
		transferAudioText.addFocusListener(audioListener);
		maxTimeText.addFocusListener(maxTimeListener);
		timeOutText.addFocusListener(timeOutListener);
		typeTranferCombo.addSelectionListener(typeTransferListener);
		timeOutText.addVerifyListener(timeOutVerifyListener);
		maxTimeText.addVerifyListener(maxTimeVerifyListener);
		
	}


	private void addListenerSubflujos() {
    	propertielistener = new PropertiesListener(this, nameSubFlow);
    	btEditFlow.addListener(SWT.Selection, propertielistener);
	}


	private void addListenerSwtich() {
    	propertielistener = new PropertiesListener(this, tableViewer);
		btAdd.addListener(SWT.Selection, propertielistener);
		btRemove.addListener(SWT.Selection, propertielistener);
		btUp.addListener(SWT.Selection, propertielistener);
		btDown.addListener(SWT.Selection, propertielistener);
	}


	private void seleccionarTipo(TransferState transfer) {
    	for (int i = 0; i< typeTranferCombo.getItemCount(); i++){
    		if (typeTranferCombo.getItem(i).equals(transfer.getTypeTransfer().getName())){
    			typeTranferCombo.select(i);
    			break;
    		}
    	}
	}


	public PictogramElement obtenerPe(){
    	return pe;
    }

	/**
	 * Eliminamos el listener
	 */
	protected void removelistener(Object bo) {
		nameText.removeFocusListener(nameStateListener);
		if (bo instanceof TransferState){
			destinationText.removeFocusListener(destinationListener);
			transferAudioText.removeFocusListener(audioListener);
			maxTimeText.removeFocusListener(maxTimeListener);
			timeOutText.removeFocusListener(timeOutListener);
			typeTranferCombo.removeSelectionListener(typeTransferListener);
			timeOutText.removeVerifyListener(timeOutVerifyListener);
			maxTimeText.removeVerifyListener(maxTimeVerifyListener);
		}else if ((bo instanceof MenuState) || (bo instanceof InputState) || (bo instanceof PromptState) || (bo instanceof CallFlowState)
				|| (bo instanceof CustomState)){
			
			btEditFlow.removeListener(SWT.Selection, propertielistener);
		}else if(bo instanceof SwitchState){
			btAdd.removeListener(SWT.Selection, propertielistener);
			btRemove.removeListener(SWT.Selection, propertielistener);
			btUp.removeListener(SWT.Selection, propertielistener);
			btDown.removeListener(SWT.Selection, propertielistener);
		}
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
				PictogramElement obj =  obtenerFeatureProvider().getPictogramElementForBusinessObject(tr);
	    		if(obj instanceof Connection){
		    		Connection connection = (Connection) obj;
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
		
		nameStateListener = new ListenerIntentionName(this, nameText);
		
		nameText.addFocusListener(nameStateListener);
		String path = (((State) bo).eResource()).getURI().path().substring(9).toString();
		pathText.setText(path == null ? "" : path);
	}
	
	/**
	 * @param bo
	 */
	protected void refreshName(Object bo) {
		String name = null;
		name = ((State) bo).getName();            
		nameText.setText(name == null ? "" : name);
		nameText.addFocusListener(new ListenerIntentionName(this, nameText));
	}
	
	private TableViewerColumn createTableViewerColumn(String title, int bound) {
		    final TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer,
		        SWT.NONE);
		    final TableColumn column = viewerColumn.getColumn();
		    column.setText(title);
		    column.setWidth(bound);
		    column.setResizable(true);
		    column.setMoveable(true);
		    return viewerColumn;
	}
	
	public IFeatureProvider obtenerFeatureProvider (){
		return fp;
	}

	public SwitchState obtenerSwitch(){
		return estadoSelection;
	}
	
	public List<Case> obtenerCases(){
		return casos;
	}
	
	private void llenarCombo(){
		List<TypeTransfer> tipos = TypeTransfer.VALUES;

       	for (TypeTransfer tipo: tipos){     		
       		typeTranferCombo.add(tipo.getName());
       	}
	}
}
