package com.vectorsf.jvoice.ui.diagram.properties.util;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.TransferState;

public final class RenameCommand extends RecordingCommand {
	private final PictogramElement pe;
	private final State bimElement;
	private IFeatureProvider fp;
	private String newValue;
	private int option;
	
	public RenameCommand(TransactionalEditingDomain domain,
			PictogramElement pe, State bimElement, String newValue, IFeatureProvider fp, int option) {
		super(domain);
		this.pe = pe;
		this.bimElement = bimElement;
		this.newValue = newValue;
		this.fp = fp;
		this.option = option;
	}

	protected void doExecute() {
		
		switch (option){
			case 0:
				bimElement.setName(newValue);

				break;
				
			case 1:
				//se trata de un transfer y queremos cambiar la URI a la que se transferirá la llamada
				((TransferState) bimElement).setDestination(newValue);

				break;
				
			case 2:
				//se trata de un transfer y queremos cambiar el audio de espera
				((TransferState) bimElement).setAudioTransfer(newValue);

				break;
				
			case 3:
				//se trata de un transfer y queremos cambiar el tiempo de timeout
				((TransferState) bimElement).setTimeout(Integer.parseInt(newValue));

				break;
				
			case 4:
				//se trata de un transfer y queremos cambiar el tiempo máximo de espera
				((TransferState) bimElement).setMaxTime(Integer.parseInt(newValue));

				break;
			
			default:
				break;
		}
		
		fp.updateIfPossibleAndNeeded(new UpdateContext(pe));	
	}
}