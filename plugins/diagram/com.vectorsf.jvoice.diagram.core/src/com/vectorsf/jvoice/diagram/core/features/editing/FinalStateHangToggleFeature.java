package com.vectorsf.jvoice.diagram.core.features.editing;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.vectorsf.jvoice.model.operations.FinalState;

public class FinalStateHangToggleFeature extends AbstractCustomFeature {

	public FinalStateHangToggleFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement pe = context.getInnerPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pe);

		if (bo instanceof FinalState) {
			FinalState finalState = (FinalState) bo;
			finalState.setFinal(!finalState.isFinal());
		}
		layoutPictogramElement(pe);
	}
}
