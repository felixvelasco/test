package com.vectorsf.jvoice.diagram.core.pattern.states;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl;
import com.vectorsf.jvoice.ui.wizard.create.DefinitionHelper;

public class InputStatePattern extends LocutionStatePattern {

	private static final String INPUT = "Input";

	@Override
	public String getCreateName() {
		return INPUT;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof InputState || mainBusinessObject instanceof InputDsl
				&& isDslFromTargetFlow((InputDsl) mainBusinessObject);
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_INPUT;
	}

	@Override
	public String getCreateLargeImageId() {
		return CoreImageProvider.IMG_LARGE_PALETTE_INPUT;
	}

	@Override
	protected String getStateImageId() {
		return CoreImageProvider.IMG_STATE_INPUT;
	}

	@Override
	protected LocutionState createMainState() {
		InputState cs = OperationsFactory.eINSTANCE.createInputState();
		cs.getFireableEvents().add("ok");
		return cs;
	}

	@Override
	protected String getTitle() {
		return "Input Selection";
	}

	@Override
	protected String getDescription() {
		return "Select an input:";
	}

	@Override
	protected DefinitionHelper getMainType() {
		return DefinitionHelper.INPUT;
	}
}
