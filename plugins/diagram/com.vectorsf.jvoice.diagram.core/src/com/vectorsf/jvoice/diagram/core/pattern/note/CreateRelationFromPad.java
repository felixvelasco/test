package com.vectorsf.jvoice.diagram.core.pattern.note;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.pattern.CreateConnectionFeatureForPattern;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;

public class CreateRelationFromPad extends CreateConnectionFeatureForPattern {

	public CreateRelationFromPad(IFeatureProvider iFeatureProvider, RelationPattern relationPattern) {
		super(iFeatureProvider, relationPattern);
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_RELATION_PAD;
	}
}
