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

	// Para solucionar problemas de pila.
	@Override
	public boolean isAutoUpdateAtRuntime() {
		return false;
	}

	/**
	 * Para que refresque los estados al arrancar el editor. Por ejemplo, que actualice los options del estado Menu.
	 */
	@Override
	public boolean isAutoUpdateAtStartup() {
		return super.isAutoUpdateAtStartup();
	}
}
