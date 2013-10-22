package com.vectorsf.jvoice.ui.diagram.properties.util;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.TableViewer;

import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.SwitchState;

public class AddCaseSwitch extends RecordingCommand {

	private SwitchState estadoSelection;
	private List<Case> casos;
	private TableViewer tableViewer;
	
	public AddCaseSwitch (TransactionalEditingDomain domain, SwitchState estadoSelection, List<Case> casos, TableViewer tableViewer){
		super(domain);
		this.estadoSelection = estadoSelection;
		this.casos = casos;
		this.tableViewer = tableViewer;
	}
	@Override
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

}
