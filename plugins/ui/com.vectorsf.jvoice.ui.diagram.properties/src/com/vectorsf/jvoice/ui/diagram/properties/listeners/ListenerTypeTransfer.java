package com.vectorsf.jvoice.ui.diagram.properties.listeners;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.ui.diagram.properties.filters.StateSection;
import com.vectorsf.jvoice.ui.diagram.properties.util.ChangeTypeTransfer;

public class ListenerTypeTransfer implements SelectionListener {
	
	private CCombo itemSelected;
	private Text timeOutText;
	private Text maxTimeText;
	private StateSection stateSection;
	
	public ListenerTypeTransfer(StateSection stateSection,CCombo itemSelected, Text timeOutText, Text maxTimeText) {
		this.itemSelected = itemSelected;
		this.stateSection = stateSection;
		this.timeOutText = timeOutText;
		this.maxTimeText = maxTimeText;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		PictogramElement pe = stateSection.obtenerPe();
		State bimElement = (State) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bimElement);

		IFeatureProvider fp = stateSection.obtenerFeatureProvider();
		editingDomain.getCommandStack().execute(new ChangeTypeTransfer(editingDomain, pe, bimElement, itemSelected.getText(), fp, timeOutText, maxTimeText));

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {}

}
