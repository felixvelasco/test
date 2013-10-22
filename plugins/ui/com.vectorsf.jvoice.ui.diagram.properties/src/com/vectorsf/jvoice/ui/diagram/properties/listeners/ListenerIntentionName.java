package com.vectorsf.jvoice.ui.diagram.properties.listeners;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Text;

import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.ui.diagram.properties.filters.StateSection;
import com.vectorsf.jvoice.ui.diagram.properties.util.RenameCommand;

public class ListenerIntentionName implements FocusListener {
	
	private Text nameText;
	
	public ListenerIntentionName(Text nameText) {
		this.nameText = nameText;
	}

	@Override
	public void focusLost(FocusEvent e) {
		PictogramElement pe = StateSection.getInstance().obtenerPe();
		State bimElement = (State) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bimElement);

		IFeatureProvider fp = StateSection.getInstance().obtenerFeatureProvider();
		editingDomain.getCommandStack().execute(new RenameCommand(editingDomain, pe, bimElement, nameText.getText(), fp));
	}

	@Override
	public void focusGained(FocusEvent e) {}
}
