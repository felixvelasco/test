package com.vectorsf.jvoice.diagram.core.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class SwapFixPointAnchorFeature extends AbstractCustomFeature {

	public SwapFixPointAnchorFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes.length == 2) {
			PictogramElement peSrc = pes[0];
			PictogramElement peTar = pes[1];
			if (peSrc instanceof FixPointAnchor && peTar instanceof FixPointAnchor) {
				return ((FixPointAnchor) peSrc).getParent() == ((FixPointAnchor) peTar).getParent();
			}
		}
		return false;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes.length == 2) {
			PictogramElement peSrc = pes[0];
			PictogramElement peTar = pes[1];
			if (peSrc instanceof FixPointAnchor && peTar instanceof FixPointAnchor) {
				FixPointAnchor src = (FixPointAnchor) peSrc;
				FixPointAnchor tar = (FixPointAnchor) peTar;

				AnchorContainer container = src.getParent();
				EList<Anchor> anchors = container.getAnchors();
				int indexSrc = anchors.indexOf(src);
				int indexTar = anchors.indexOf(tar);

				anchors.move(indexTar, src);
				anchors.move(indexSrc, tar);

				layoutPictogramElement(container);
			}
		}
	}

}
