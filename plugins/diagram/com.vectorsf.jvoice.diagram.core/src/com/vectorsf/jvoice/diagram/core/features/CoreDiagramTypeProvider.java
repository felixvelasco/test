package com.vectorsf.jvoice.diagram.core.features;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class CoreDiagramTypeProvider extends AbstractDiagramTypeProvider {

	public static final String IVR_DIAGRAM_TYPE_PROVIDER_ID = "jvoice.ivr.features"; //$NON-NLS-1$

	private IToolBehaviorProvider toolBehaviorProvider;

	public CoreDiagramTypeProvider() {
		super();
		setFeatureProvider(new CoreFeatureProvider(this));
	}

	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {

		if (toolBehaviorProvider == null) {

			toolBehaviorProvider =

			new CoreToolBehaviourProvider(this);

		}

		return new IToolBehaviorProvider[] { toolBehaviorProvider };

	}

}