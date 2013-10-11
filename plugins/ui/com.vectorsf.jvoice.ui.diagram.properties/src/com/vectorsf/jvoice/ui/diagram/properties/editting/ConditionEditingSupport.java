package com.vectorsf.jvoice.ui.diagram.properties.editting;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import com.vectorsf.jvoice.model.operations.Case;

public class ConditionEditingSupport extends EditingSupport {

	private final TableViewer viewer;
	private Case caso;
	private String condition;
	
	public ConditionEditingSupport(TableViewer viewer) {
	    super(viewer);
	    this.viewer = viewer;
	  }
	
	@Override
	protected CellEditor getCellEditor(Object element) {
		return new TextCellEditor(viewer.getTable());
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
		return ((Case) element).getCondition();
	}

	@Override
	protected void setValue(Object element, Object value) {
		caso = (Case) element;
		condition = String.valueOf(value);
		TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(caso);
		dominio.getCommandStack().execute(new RecordingCommand(dominio) {
    		protected void doExecute() {
    			caso.setCondition(condition);
    			viewer.update(caso, null);
    		}
		});
	}

}
