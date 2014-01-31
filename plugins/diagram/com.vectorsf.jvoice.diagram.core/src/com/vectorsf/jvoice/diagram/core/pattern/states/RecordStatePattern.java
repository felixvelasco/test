package com.vectorsf.jvoice.diagram.core.pattern.states;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.RecordState;
import com.vectorsf.jvoice.prompt.model.voiceDsl.RecordDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class RecordStatePattern extends LocutionStatePattern {
	private static final String RECORD = "Record";

	@Override
	public String getCreateName() {
		return RECORD;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof RecordState || mainBusinessObject instanceof RecordDsl
				&& isDslFromTargetFlow((RecordDsl) mainBusinessObject);
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_RECORD;
	}

	@Override
	public String getCreateLargeImageId() {
		return CoreImageProvider.IMG_LARGE_PALETTE_RECORD;
	}

	@Override
	protected String getStateImageId() {
		return CoreImageProvider.IMG_STATE_RECORD;
	}

	@Override
	protected LocutionState createMainState() {
		RecordState cs = OperationsFactory.eINSTANCE.createRecordState();
		cs.getFireableEvents().add("ok");
		return cs;
	}

	@Override
	protected String getTitle() {
		return "Record Selection";
	}

	@Override
	protected String getDescription() {
		return "Select a record:";
	}

	@Override
	protected Class<? extends VoiceDsl> getMainType() {
		return RecordDsl.class;
	}

}
