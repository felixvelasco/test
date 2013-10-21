package com.vectorsf.jvoice.diagram.core.features.editing;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;

import com.vectorsf.jvoice.model.operations.Case;

public class TransitionsUpdateFeature extends AbstractUpdateFeature {

	public TransitionsUpdateFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canUpdate(IUpdateContext context) {
		return true;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ConnectionDecorator) {
			ConnectionDecorator connDecorator = (ConnectionDecorator) pictogramElement;
			if (connDecorator.getGraphicsAlgorithm() instanceof Text) {
				PictogramLink pl = connDecorator.getLink();
				if (pl.getBusinessObjects() != null) {
					List<EObject> bos = pl.getBusinessObjects();
					if (bos.get(0) instanceof Case) {
						String eventName = ((Case) bos.get(0)).getEventName();
						Text text = (Text) connDecorator.getGraphicsAlgorithm();
						if (!eventName.equals(text.getValue())) {
							return new Reason(true, "");
						}
					}
				}
			}
		}
		return new Reason(false, "");
	}

	@Override
	public boolean update(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ConnectionDecorator) {
			ConnectionDecorator connDecorator = (ConnectionDecorator) pictogramElement;
			if (connDecorator.getGraphicsAlgorithm() instanceof Text) {
				PictogramLink pl = connDecorator.getLink();
				if (pl.getBusinessObjects() != null) {
					List<EObject> bos = pl.getBusinessObjects();
					if (bos.get(0) instanceof Case) {
						String eventName = ((Case) bos.get(0)).getEventName();
						Text text = (Text) connDecorator.getGraphicsAlgorithm();
						text.setValue(eventName);
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public String getName() {
		return "Transition Update";
	}

}
