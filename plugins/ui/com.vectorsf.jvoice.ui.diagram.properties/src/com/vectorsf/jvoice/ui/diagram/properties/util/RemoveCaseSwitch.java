package com.vectorsf.jvoice.ui.diagram.properties.util;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.SwitchState;

public class RemoveCaseSwitch extends RecordingCommand {

	private SwitchState estadoSelection;
	private List<Case> casos;
	private TableViewer tableViewer;
	
	public RemoveCaseSwitch (TransactionalEditingDomain domain, SwitchState estadoSelection, List<Case> casos, TableViewer tableViewer){
		super(domain);
		this.estadoSelection = estadoSelection;
		this.casos = casos;
		this.tableViewer = tableViewer;
	}
	@Override
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

}
