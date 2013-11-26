package com.vectorsf.jvoice.diagram.core.features.editing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.internal.features.context.impl.base.PictogramElementContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;

import com.vectorsf.jvoice.model.operations.FinalState;

public class FinalStateFinalFeature extends AbstractFeature implements ICustomFeature {

	private IFeatureProvider featureProvider;

	public FinalStateFinalFeature(IFeatureProvider fp) {
		super(fp);
		featureProvider = fp;
	}

	@Override
	public boolean isAvailable(IContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canExecute(IContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void execute(IContext context) {
		PictogramElementContext customContext = (PictogramElementContext) context;
		PictogramElement pe = customContext.getPictogramElement();

		if (pe instanceof ContainerShape) {
			PictogramLink link = pe.getLink();
			EList<EObject> eObjects = link.getBusinessObjects();
			for (EObject o : eObjects) {
				if (o instanceof FinalState) {
					FinalState finalState = (FinalState) o;
					if (finalState.isFinal()) {
						finalState.setFinal(false);
					} else {
						finalState.setFinal(true);
					}
				}
			}

		}
	}

	@Override
	public boolean canUndo(IContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean hasDoneChanges() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Final";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFeatureProvider getFeatureProvider() {

		return featureProvider;
	}

	@Override
	public String getImageId() {
		return null;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		// TODO Auto-generated method stub
	}

}
