package com.vectorsf.jvoice.ui.diagram.properties.editting;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.custom.CLabel;

import com.vectorsf.jvoice.model.operations.Case;

public class EventNameEditingSupport extends EditingSupport {

private final TableViewer viewer;
private Case caso;
private String eventName;
private CLabel error;
	
	public EventNameEditingSupport(TableViewer viewer, CLabel error) {
	    super(viewer);
	    this.viewer = viewer;
	    this.error = error;
	  }
	
	@Override
	protected CellEditor getCellEditor(Object element) {
		TextCellEditor testCell = new TextCellEditor(viewer.getTable());
		testCell.setValidator(new ValidateCase((Case) element));
		testCell.addListener(new ValidateListener(testCell, error));
		return testCell;
	}

	@Override
	protected boolean canEdit(Object element) {
		if (element instanceof Case){
			caso = (Case) element;
			if(!caso.getEventName().equals("default")){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}

	@Override
	protected Object getValue(Object element) {
		return ((Case) element).getEventName();
	}

	@Override
	protected void setValue(Object element, Object value) {
		caso = (Case) element;
		eventName = String.valueOf(value).trim();
		TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(caso);
		dominio.getCommandStack().execute(new RecordingCommand(dominio) {
    		protected void doExecute() {
        		caso.setEventName(eventName.trim());
        		viewer.update(caso, null);
    		}
		});
	}

}
