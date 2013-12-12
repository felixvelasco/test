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
	private StateSection stateSection;

	public ListenerIntentionName(StateSection stateSection, Text nameText) {
		this.nameText = nameText;
		this.stateSection = stateSection;
	}

	@Override
	public void focusLost(FocusEvent e) {
		PictogramElement pe = stateSection.obtenerPe();
		State bimElement = (State) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bimElement);

		boolean changed = false;
		if (bimElement != null && !bimElement.getName().equals(nameText.getText())) {
			changed = true;
		}

		if (changed) {
			IFeatureProvider fp = stateSection.obtenerFeatureProvider();
			editingDomain.getCommandStack().execute(
					new RenameCommand(editingDomain, pe, bimElement, nameText.getText(), fp));
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
	}
}
