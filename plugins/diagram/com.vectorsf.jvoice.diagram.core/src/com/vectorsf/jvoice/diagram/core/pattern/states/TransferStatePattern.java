package com.vectorsf.jvoice.diagram.core.pattern.states;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.TransferState;
import com.vectorsf.jvoice.prompt.model.voiceDsl.TransferDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class TransferStatePattern extends LocutionStatePattern {
	private static final String TRANSFER = "Transfer";

	@Override
	public String getCreateName() {
		return TRANSFER;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof TransferState;
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_TRANSFER;
	}

	@Override
	protected String getStateImageId() {
		return CoreImageProvider.IMG_STATE_TRANSFER;
	}

	@Override
	protected LocutionState createMainState() {
		return OperationsFactory.eINSTANCE.createTransferState();
	}

	@Override
	protected String getTitle() {
		return "Transfer Selection";
	}

	@Override
	protected String getDescription() {
		return "Select a transfer:";
	}

	@Override
	protected Class<? extends VoiceDsl> getMainType() {
		return TransferDsl.class;
	}
}
