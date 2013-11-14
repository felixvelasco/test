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
import com.vectorsf.jvoice.model.operations.TransferState;
import com.vectorsf.jvoice.ui.diagram.properties.filters.StateSection;
import com.vectorsf.jvoice.ui.diagram.properties.util.RenameCommand;

public class ListenerIntentionName implements FocusListener {
	
	private Text nameText;
	private StateSection stateSection;
	private int option;
	
	public ListenerIntentionName(StateSection stateSection,Text nameText) {
		this.nameText = nameText;
		this.stateSection = stateSection;
		this.option = 0;
	}
	
	public ListenerIntentionName(StateSection stateSection,Text nameText, int option) {
		this.nameText = nameText;
		this.stateSection = stateSection;
		this.option = option;
	}

	@Override
	public void focusLost(FocusEvent e) {
		PictogramElement pe = stateSection.obtenerPe();
		State bimElement = (State) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bimElement);
		
		boolean changed = false;
		switch (option){
			case 0:
				if (!bimElement.getName().equals(nameText.getText())){
					changed = true;
				}
				break;
				
			case 1:
				//se trata de un transfer y queremos cambiar la URI a la que se transferirá la llamada
				if (!((TransferState) bimElement).getDestination().equals(nameText.getText())){
					changed = true;
				}	
				break;
				
			case 2:
				//se trata de un transfer y queremos cambiar el audio de espera
				if (!((TransferState) bimElement).getAudioTransfer().equals(nameText.getText())){
					changed = true;
				}	
				break;
				
			case 3:
				//se trata de un transfer y queremos cambiar el tiempo de timeout
				if (((TransferState) bimElement).getTimeout() != Integer.parseInt(nameText.getText())){
					changed = true;
				}	
				break;
				
			case 4:
				//se trata de un transfer y queremos cambiar el tiempo máximo de espera
				if (((TransferState) bimElement).getMaxTime() != Integer.parseInt(nameText.getText())){
					changed = true;
				}	
				break;
			
			default:
				break;
		}

		if (changed){
			IFeatureProvider fp = stateSection.obtenerFeatureProvider();
			editingDomain.getCommandStack().execute(new RenameCommand(editingDomain, pe, bimElement, nameText.getText(), fp, option));
		}
		
	}

	@Override
	public void focusGained(FocusEvent e) {}
}
