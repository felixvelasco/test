package com.vectorsf.jvoice.diagram.core.features;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.log.Logger;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddBendpointFeature;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IMoveAnchorFeature;
import org.eclipse.graphiti.features.IMoveBendpointFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveBendpointFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddBendpointContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IMoveAnchorContext;
import org.eclipse.graphiti.features.context.IMoveBendpointContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveBendpointContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.eclipse.graphiti.pattern.IPattern;
import org.osgi.service.log.LogService;

import com.vectorsf.jvoice.diagram.core.Activator;
import com.vectorsf.jvoice.diagram.core.editor.JVoiceDiagramBehavior;
import com.vectorsf.jvoice.diagram.core.features.editing.StatesCopyFeature;
import com.vectorsf.jvoice.diagram.core.features.editing.StatesPasteFeature;
import com.vectorsf.jvoice.diagram.core.features.editing.TextEventDirectEditFeature;
import com.vectorsf.jvoice.diagram.core.features.editing.TransitionsDeleteFeature;
import com.vectorsf.jvoice.diagram.core.features.editing.TransitionsUpdateFeature;
import com.vectorsf.jvoice.diagram.core.pattern.note.RelationPattern;
import com.vectorsf.jvoice.diagram.core.pattern.transition.CreateTransitionFromPad;
import com.vectorsf.jvoice.diagram.core.pattern.transition.ReconnectTransitionFeature;
import com.vectorsf.jvoice.diagram.core.pattern.transition.TransitionCallFlowPattern;
import com.vectorsf.jvoice.diagram.core.pattern.transition.TransitionPattern;
import com.vectorsf.jvoice.diagram.core.pattern.transition.TransitionSwitchPattern;
import com.vectorsf.jvoice.model.operations.State;

public class CoreFeatureProvider extends DefaultFeatureProviderWithPatterns {
	public static final String PATTERN_EXTENSIONS_ID = "com.vectorsf.jvoice.diagram.core.patternContributor"; //$NON-NLS-1$

	public CoreFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
				PATTERN_EXTENSIONS_ID);

		try {
			for (IConfigurationElement configEl : config) {
				Object o;
				o = configEl.createExecutableExtension("patternContributorClass");
				if (o instanceof IPattern) {
					IPattern patternContributor = (IPattern) o;
					addPattern(patternContributor);
				}
			}
		} catch (CoreException e) {
			Logger logger = Activator.getLogger();
			if (logger != null) {
				logger.log(LogService.LOG_ERROR, "CoreFeatureProvider::CoreFeatureProvider, Error adding patterns", e);
			}
		}

		addConnectionPattern(new RelationPattern(this));
		addConnectionPattern(new TransitionPattern(this));
		addConnectionPattern(new TransitionSwitchPattern(this));

	}

	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		if (isReadOnly()) {
			return null;
		}
		return super.getMoveShapeFeature(context);
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		if (isReadOnly()) {
			return null;
		}
		return super.getAddFeature(context);
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		if (isReadOnly()) {
			return new ICreateConnectionFeature[0];
		}
		return super.getCreateConnectionFeatures();
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		if (isReadOnly()) {
			return new ICreateFeature[0];
		}
		return super.getCreateFeatures();
	}

	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		if (isReadOnly()) {
			return null;
		}
		return super.getDeleteFeature(context);
	}

	@Override
	public IMoveBendpointFeature getMoveBendpointFeature(IMoveBendpointContext context) {
		if (isReadOnly()) {
			return null;
		}
		return super.getMoveBendpointFeature(context);
	}

	@Override
	public IRemoveBendpointFeature getRemoveBendpointFeature(IRemoveBendpointContext context) {
		if (isReadOnly()) {
			return null;
		}
		return super.getRemoveBendpointFeature(context);
	}

	@Override
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		if (isReadOnly()) {
			return null;
		}
		return super.getRemoveFeature(context);
	}

	@Override
	public IAddBendpointFeature getAddBendpointFeature(IAddBendpointContext context) {
		if (isReadOnly()) {
			return null;
		}
		return super.getAddBendpointFeature(context);
	}

	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		if (isReadOnly()) {
			return null;
		}
		return super.getResizeShapeFeature(context);
	}

	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		if (isReadOnly()) {
			return new ICustomFeature[0];
		}
		return super.getCustomFeatures(context);
	}

	private boolean isReadOnly() {
		return ((JVoiceDiagramBehavior) getDiagramTypeProvider().getDiagramBehavior()).isReadOnly();
	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
		if (isReadOnly()) {
			return null;
		}
		PictogramElement pe = context.getPictogramElement();
		if (pe instanceof ConnectionDecorator) {
			return new TextEventDirectEditFeature(this);
		}
		return super.getDirectEditingFeature(context);
	}

	@Override
	protected IUpdateFeature getUpdateFeatureAdditional(IUpdateContext context) {
		if (isReadOnly()) {
			return null;
		}
		return new TransitionsUpdateFeature(this);
	}

	@Override
	public ICopyFeature getCopyFeature(ICopyContext context) {
		return new StatesCopyFeature(this);

	}

	@Override
	public IPasteFeature getPasteFeature(IPasteContext context) {
		if (isReadOnly()) {
			return null;
		}
		return new StatesPasteFeature(this);
	}

	@Override
	protected IDeleteFeature getDeleteFeatureAdditional(IDeleteContext context) {
		if (isReadOnly()) {
			return null;
		}
		return new TransitionsDeleteFeature(this);
	}

	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		if (isReadOnly()) {
			return null;
		}

		return new ReconnectTransitionFeature(this);
	}

	@Override
	public IMoveAnchorFeature getMoveAnchorFeature(IMoveAnchorContext context) {
		if (isReadOnly()) {
			return null;
		}
		return null;
	}

	/**
	 * Se sobreescribe para que se puedan lanzar transiciones desde los eventos.
	 */
	@Override
	public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {

		if (isReadOnly()) {
			return null;
		}

		// Lanzamos transiciones desde los anchors de los eventos
		PictogramElement pe = context.getPictogramElement();
		if (pe instanceof FixPointAnchor) {
			State state = (State) getBusinessObjectForPictogramElement(((FixPointAnchor) pe).getParent());
			return new IFeature[] { new CreateTransitionFromPad(this, new TransitionCallFlowPattern(state, this)),
					new SwapFixPointAnchorFeature(this) };
		}

		return super.getDragAndDropFeatures(context);
	}
}
