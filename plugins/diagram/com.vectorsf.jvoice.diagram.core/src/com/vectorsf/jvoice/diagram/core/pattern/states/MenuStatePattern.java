package com.vectorsf.jvoice.diagram.core.pattern.states;

import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.*;
import com.vectorsf.jvoice.prompt.model.voiceDsl.*;

public class MenuStatePattern extends LocutionStatePattern {

	private static final String MENU = "Menu";

	@Override
	public String getCreateName() {
		return MENU;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof MenuState || mainBusinessObject instanceof MenuDsl
				&& isDslFromTargetFlow((MenuDsl) mainBusinessObject);
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_MENU;
	}

	@Override
	public String getCreateLargeImageId() {
		return CoreImageProvider.IMG_LARGE_PALETTE_MENU;
	}

	@Override
	protected String getStateImageId() {
		return CoreImageProvider.IMG_STATE_MENU;
	}

	@Override
	protected LocutionState createMainState() {
		return OperationsFactory.eINSTANCE.createMenuState();
	}

	@Override
	protected String getTitle() {
		return "Menu Selection";
	}

	@Override
	protected String getDescription() {
		return "Select a menu:";
	}

	@Override
	protected Class<? extends VoiceDsl> getMainType() {
		return MenuDsl.class;
	}
}
