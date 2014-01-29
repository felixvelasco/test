package com.vectorsf.jvoice.ui.diagram.properties.editting;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.custom.CLabel;

import com.vectorsf.jvoice.model.operations.*;

public class EventNameEditingSupport extends EditingSupport {

	private final TableViewer viewer;
	private Case caso;
	private String eventName;
	private CLabel error;
	private IFeatureProvider fp;

	public EventNameEditingSupport(TableViewer viewer, CLabel error, IFeatureProvider fp) {
		super(viewer);
		this.viewer = viewer;
		this.error = error;
		this.fp = fp;
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
		if (element instanceof Case) {
			caso = (Case) element;
			if (!caso.getEventName().equals("default")) {
				return true;
			} else {
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
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(caso);
		domain.getCommandStack().execute(
				new RenameTransitionCommand(domain, (SwitchState) caso.eContainer(), caso, eventName, viewer, fp));
	}

}
