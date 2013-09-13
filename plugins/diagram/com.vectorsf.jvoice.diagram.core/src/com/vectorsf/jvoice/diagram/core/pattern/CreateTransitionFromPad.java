package com.vectorsf.jvoice.diagram.core.pattern;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.pattern.CreateConnectionFeatureForPattern;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;

public class CreateTransitionFromPad extends CreateConnectionFeatureForPattern {

	public CreateTransitionFromPad(IFeatureProvider iFeatureProvider,
			TransitionPattern transitionPattern) {
		super(iFeatureProvider, transitionPattern);
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_TRANSACTION_PAD;
	}
}
