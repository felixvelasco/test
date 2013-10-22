package com.vectorsf.jvoice.ui.diagram.properties.util;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.SwitchState;

public class DownCaseSwitch extends RecordingCommand {

	private SwitchState estadoSelection;
	private List<Case> casos;
	private TableViewer tableViewer;
	
	public DownCaseSwitch (TransactionalEditingDomain domain, SwitchState estadoSelection, List<Case> casos, TableViewer tableViewer){
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

}
