package com.vectorsf.jvoice.diagram.core.pattern;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.pattern.CreateConnectionFeatureForPattern;

public class CreateTransitionFromPad extends CreateConnectionFeatureForPattern {

	public CreateTransitionFromPad(IFeatureProvider iFeatureProvider,
			TransitionPattern transitionPattern) {
		super(iFeatureProvider, transitionPattern);

	}

}
