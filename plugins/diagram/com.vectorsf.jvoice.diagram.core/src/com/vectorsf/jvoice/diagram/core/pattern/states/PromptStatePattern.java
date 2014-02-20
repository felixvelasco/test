package com.vectorsf.jvoice.diagram.core.pattern.states;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.PromptState;
import com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class PromptStatePattern extends LocutionStatePattern {

	private static final String PROMPT = "Output";

	@Override
	public String getCreateName() {
		return PROMPT;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof PromptState || mainBusinessObject instanceof PromptDsl
				&& isDslFromTargetFlow((PromptDsl) mainBusinessObject);
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_PROMPT;
	}

	@Override
	public String getCreateLargeImageId() {
		return CoreImageProvider.IMG_LARGE_PALETTE_PROMPT;
	}

	@Override
	protected String getStateImageId() {
		return CoreImageProvider.IMG_STATE_PROMPT;
	}

	@Override
	protected LocutionState createMainState() {
		PromptState cs = OperationsFactory.eINSTANCE.createPromptState();
		cs.getFireableEvents().add("ok");
		return cs;
	}

	@Override
	protected String getTitle() {
		return "Output Selection";
	}

	@Override
	protected String getDescription() {
		return "Select an output:";
	}

	@Override
	protected Class<? extends VoiceDsl> getMainType() {
		return PromptDsl.class;
	}
}
