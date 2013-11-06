package com.vectorsf.jvoice.ui.diagram.properties.util;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.swt.widgets.Text;

import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.TransferState;
import com.vectorsf.jvoice.model.operations.TypeTransfer;

public class ChangeTypeTransfer extends RecordingCommand {

	private final PictogramElement pe;
	private final State bimElement;
	private IFeatureProvider fp;
	private String newValue;
	private Text timeOutText;
	private Text maxTimeText;
	
	public ChangeTypeTransfer(TransactionalEditingDomain editingDomain,
			PictogramElement pe, State bimElement, String text,
			IFeatureProvider fp, Text timeOutText, Text maxTimeText) {
		super(editingDomain);
		this.pe = pe;
		this.bimElement = bimElement;
		this.newValue = text;
		this.fp = fp;
		this.timeOutText = timeOutText;
		this.maxTimeText = maxTimeText;
	}

	@Override
	protected void doExecute() {
		@SuppressWarnings("static-access")
		List <TypeTransfer> tipos = ((TransferState) bimElement).getTypeTransfer().VALUES;
		for (TypeTransfer tipo : tipos){
			if (tipo.getName().equals(newValue)){
				((TransferState) bimElement).setTypeTransfer(tipo);
				actualizarTimes(((TransferState) bimElement));
				fp.updateIfPossibleAndNeeded(new UpdateContext(pe));
				break;
			}
		}
		
	}

	private void actualizarTimes(TransferState transferState) {
		switch (transferState.getTypeTransfer().getValue()){
		case 0:
			transferState.setTimeout(0);
			transferState.setMaxTime(0);
			timeOutText.setText("0");
			maxTimeText.setText("0");
			timeOutText.setEnabled(false);
			maxTimeText.setEnabled(false);
			break;
			
		case 1:
			transferState.setMaxTime(0);
			timeOutText.setText(Integer.toString(transferState.getTimeout()));
			maxTimeText.setText("0");
			timeOutText.setEnabled(true);
			maxTimeText.setEnabled(false);
			break;
			
		case 2:
			timeOutText.setText(Integer.toString(transferState.getTimeout()));
			maxTimeText.setText(Integer.toString(transferState.getMaxTime()));
			timeOutText.setEnabled(true);
			maxTimeText.setEnabled(true);
			break;
		}
		
	}

}
