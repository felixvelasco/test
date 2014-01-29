package com.vectorsf.jvoice.diagram.core.features;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.log.Logger;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.*;
import org.eclipse.graphiti.mm.pictograms.*;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.eclipse.graphiti.pattern.IPattern;
import org.osgi.service.log.LogService;

import com.vectorsf.jvoice.diagram.core.Activator;
import com.vectorsf.jvoice.diagram.core.features.editing.StatesCopyFeature;
import com.vectorsf.jvoice.diagram.core.features.editing.StatesPasteFeature;
import com.vectorsf.jvoice.diagram.core.features.editing.TextEventDirectEditFeature;
import com.vectorsf.jvoice.diagram.core.features.editing.TransitionsDeleteFeature;
import com.vectorsf.jvoice.diagram.core.features.editing.TransitionsUpdateFeature;
import com.vectorsf.jvoice.diagram.core.pattern.note.RelationPattern;
import com.vectorsf.jvoice.diagram.core.pattern.transition.*;
import com.vectorsf.jvoice.model.operations.*;
import com.vectorsf.jvoice.model.operations.impl.*;

public class CoreFeatureProvider extends DefaultFeatureProviderWithPatterns {
    public static final String PATTERN_EXTENSIONS_ID = "com.vectorsf.jvoice.diagram.core.patternContributor"; //$NON-NLS-1$

    public CoreFeatureProvider(IDiagramTypeProvider dtp) {
	super(dtp);
	IConfigurationElement[] config = Platform.getExtensionRegistry()
		.getConfigurationElementsFor(PATTERN_EXTENSIONS_ID);

	try {
	    for (IConfigurationElement configEl : config) {
		Object o;
		o = configEl
			.createExecutableExtension("patternContributorClass");
		if (o instanceof IPattern) {
		    IPattern patternContributor = (IPattern) o;
		    addPattern(patternContributor);
		}
	    }
	} catch (CoreException e) {
	    Logger logger = Activator.getLogger();
	    if (logger != null) {
		logger.log(
			LogService.LOG_ERROR,
			"CoreFeatureProvider::CoreFeatureProvider, Error adding patterns",
			e);
	    }
	}

	addConnectionPattern(new RelationPattern(this));
	addConnectionPattern(new TransitionPattern(this));
	addConnectionPattern(new TransitionSwitchPattern(this));

    }

    @Override
    public IDirectEditingFeature getDirectEditingFeature(
	    IDirectEditingContext context) {
	PictogramElement pe = context.getPictogramElement();
	if (pe instanceof ConnectionDecorator) {
	    return new TextEventDirectEditFeature(this);
	}
	return super.getDirectEditingFeature(context);
    }

    @Override
    protected IUpdateFeature getUpdateFeatureAdditional(IUpdateContext context) {
	return new TransitionsUpdateFeature(this);
    }

    @Override
    public ICopyFeature getCopyFeature(ICopyContext context) {
	return new StatesCopyFeature(this);

    }

    @Override
    public IPasteFeature getPasteFeature(IPasteContext context) {
	return new StatesPasteFeature(this);
    }

    @Override
    protected IDeleteFeature getDeleteFeatureAdditional(IDeleteContext context) {
	return new TransitionsDeleteFeature(this);
    }

    @Override
    public IReconnectionFeature getReconnectionFeature(
	    IReconnectionContext context) {

	return new ReconnectTransitionFeature(this);
    }

    @Override
    public IMoveAnchorFeature getMoveAnchorFeature(IMoveAnchorContext context) {
	return null;
    }

    /**
     * Se sobreescribe para que se puedan lanzar transiciones desde los eventos.
     */
    @Override
    public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {
	// Lanzamos transiciones desde los anchors de los eventos
	PictogramElement pe = context.getPictogramElement();
	if (pe instanceof FixPointAnchor) {
	    State state = (State) getBusinessObjectForPictogramElement(((FixPointAnchor) pe)
		    .getParent());
	    return new IFeature[] { new CreateTransitionFromPad(this,
		    new TransitionCallFlowPattern(state, this)) };
	}

	return super.getDragAndDropFeatures(context);
    }
}
