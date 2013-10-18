package com.vectorsf.jvoice.diagram.core.features.editing;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;

public class TextEventDirectEditFeature extends AbstractDirectEditingFeature {

	public TextEventDirectEditFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}

	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		return false;
	}

	@Override
	public void setValue(String value, IDirectEditingContext context) {
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		if (ga instanceof Text) {
			Text tga = (Text) ga;
			tga.setValue(value);
		}
		updatePictogramElement(context.getPictogramElement());

	}

	@Override
	public String getInitialValue(IDirectEditingContext context) {
		return null;
	}
}
